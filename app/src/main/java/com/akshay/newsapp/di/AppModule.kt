package com.akshay.newsapp.di

import android.app.Application
import com.akshay.newsapp.BuildConfig
import com.akshay.newsapp.BuildConfig.BASE_URL
import com.akshay.newsapp.NewsApp
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(application: Application) = application as NewsApp

    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(BASE_URL)
        .client(httpClient)
        .build()

    @Provides
    fun provideHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()

        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
            builder.addInterceptor(interceptor)
        }

        builder.addInterceptor { chain ->
            val original = chain.request()

            val request = original.newBuilder()
                .header("X-Api-Key", BuildConfig.NEWS_API_KEY)
                .build()

            chain.proceed(request)
        }

        return builder.build()
    }

}
