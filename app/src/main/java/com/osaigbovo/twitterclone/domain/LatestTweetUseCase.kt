package com.osaigbovo.twitterclone.domain

import com.osaigbovo.twitterclone.data.CoroutinesDispatcherProvider
import com.osaigbovo.twitterclone.data.repository.TweetRepository
import com.osaigbovo.twitterclone.data.result.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LatestTweetUseCase @Inject constructor(
    private val tweetRepository: TweetRepository,
    dispatcherProvider: CoroutinesDispatcherProvider,
) : FlowUseCase<Unit, Any>(dispatcherProvider.io) {

    override suspend fun execute(parameters: Unit?): Flow<Result<Any>> {
        return tweetRepository.getTweets().map {
            when (it) {
                is Result.Loading -> it
                is Result.Success -> it
                is Result.Error -> it
            }
        } as Flow<Result<Any>>
    }
}