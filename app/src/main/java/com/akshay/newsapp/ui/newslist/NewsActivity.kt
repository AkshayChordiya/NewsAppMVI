package com.akshay.newsapp.ui.newslist

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshay.newsapp.R
import com.akshay.newsapp.adapter.NewsArticlesAdapter
import com.akshay.newsapp.ui.base.BaseActivity
import com.akshay.newsapp.utils.getViewModel
import com.akshay.newsapp.utils.observe
import com.akshay.newsapp.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.empty_layout.*
import kotlinx.android.synthetic.main.progress_layout.*

class NewsActivity : BaseActivity() {

    private val newsViewModel by lazy { getViewModel<NewsViewModel>() }

    private val adapter by lazy {
        NewsArticlesAdapter {
            toast("Clicked on item")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cosmetic setup for list
        setupList()

        // Observe for state changes
        newsViewModel.observableState.observe(this) { state ->
            renderState(state)
        }

        // Dispatch initial action to load news
        newsViewModel.dispatch(Action.LoadNews)
    }

    private fun setupList() {
        newsList.setEmptyView(emptyView)
        newsList.setProgressView(progressView)

        newsList.adapter = adapter
        newsList.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Update the UI based upon the [state]
     */
    private fun renderState(state: State) {
        when (state) {
            is State.News
            -> adapter.replaceItems(state.news)
            is State.Loading,
            is State.Error
            -> newsList.showState(state)
        }
    }
}
