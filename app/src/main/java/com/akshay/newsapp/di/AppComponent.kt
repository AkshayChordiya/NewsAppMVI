package com.akshay.newsapp.di

import android.app.Application
import com.akshay.newsapp.NewsApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        // Dagger support
        AndroidInjectionModule::class,

        // Core
        AppModule::class,
        ActivityModule::class,
        ViewModelModule::class,

        // Feature
        NewsModule::class
    ]
)
interface AppComponent {
    fun inject(app: NewsApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
