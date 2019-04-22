package com.akshay.newsapp.di

import com.akshay.newsapp.api.NewsService
import com.akshay.newsapp.utils.create
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit): NewsService = retrofit.create()

}