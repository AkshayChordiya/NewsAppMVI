package com.akshay.newsapp.repo

import com.akshay.newsapp.api.NewsService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(
    private val newsService: NewsService
) {
    fun getTopHeadlines(category: String) = newsService.getTopHeadlines(category)
}