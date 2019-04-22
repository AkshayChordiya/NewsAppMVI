package com.akshay.newsapp.utils

import retrofit2.Retrofit

/**
 * Synthetic sugaring [Retrofit.create]
 */
inline fun <reified T> Retrofit.create(): T = create(T::class.java)

