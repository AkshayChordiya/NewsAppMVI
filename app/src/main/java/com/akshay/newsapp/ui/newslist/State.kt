package com.akshay.newsapp.ui.newslist

import com.akshay.newsapp.domain.Article
import com.ww.roxie.BaseState

/**
 * Immutable representation of state of the UI
 */
sealed class State : BaseState {

    /* News list shown state of UI */
    data class News(
        val news: List<Article>
    ) : State()

    /* Loading state of UI */
    object Loading : State()

    /* Error state of UI  */
    object Error : State()
}