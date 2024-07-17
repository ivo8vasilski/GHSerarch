package com.example.githubsearch.di

import com.example.githubsearch.Repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideMainRepository(httpClient: OkHttpClient): MainRepository = MainRepository(httpClient)

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient()
}