package com.akshay.newsapp.ui.newslist

import com.akshay.newsapp.repo.NewsRepository
import com.ww.roxie.BaseViewModel
import com.ww.roxie.Reducer
import io.reactivex.rxkotlin.ofType
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : BaseViewModel<Action, State>() {

    /* Initial state */
    override val initialState = State.Loading

    /* Reducer => <Previous State, Change> -> New State  */
    private val reducer: Reducer<State, Change> = { _, change ->
        when (change) {
            is Change.News -> State.News(change.news)
            is Change.Loading -> State.Loading
            is Change.Error -> State.Error
        }
    }

    init {
        bindActions()
    }

    private fun bindActions() {
        // Action -> 1..n Change
        val loadNews = actions.ofType<Action.LoadNews>()
            .switchMap {
                newsRepository.getTopHeadlines("technology")
                    .subscribeOn(Schedulers.io())
                    .map<Change> { Change.News(it.articles) }
                    .onErrorReturn { Change.Error }
                    .startWith(Change.Loading)
            }

        // To handle multiple Changes, use Observable.merge to merge them into a single stream:
        // val allChanges = Observable.merge(loadNews, ...)

        // Change -> Reducer
        disposables += loadNews
            .scan(initialState, reducer)
            .distinctUntilChanged()
            .subscribe(state::postValue, Timber::e)
    }
}
