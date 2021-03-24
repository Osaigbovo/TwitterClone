package com.osaigbovo.twitterclone.di

import com.osaigbovo.twitterclone.data.CoroutinesDispatcherProvider
import com.osaigbovo.twitterclone.data.repository.TweetRepository
import com.osaigbovo.twitterclone.data.repository.TweetRepositoryImpl
import com.osaigbovo.twitterclone.domain.LatestTweetUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideLatestTweetUseCase(
        tweetRepository: TweetRepository,
        dispatcherProvider: CoroutinesDispatcherProvider
    ): LatestTweetUseCase = LatestTweetUseCase(tweetRepository, dispatcherProvider)

    @Singleton
    @Provides
    fun provideTweetRepository(): TweetRepository = TweetRepositoryImpl()
}