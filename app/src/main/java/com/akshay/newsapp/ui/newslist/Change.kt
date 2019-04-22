package com.akshay.newsapp.ui.newslist

import com.akshay.newsapp.domain.Article

/**
 * Action -> 1..n change
 */
sealed class Change {

    /* News data loaded change  */
    data class News(val news: List<Article>) : Change()

    /* Loading change */
    object Loading : Change()

    /* Error change */
    object Error : Change()
}
