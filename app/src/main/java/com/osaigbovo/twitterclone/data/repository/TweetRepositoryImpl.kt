package com.osaigbovo.twitterclone.data.repository

import com.osaigbovo.twitterclone.data.result.Result
import com.osaigbovo.twitterclone.utils.generateTweets
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retryWhen
import java.io.IOException
import javax.inject.Inject

class TweetRepositoryImpl @Inject constructor() : TweetRepository {

    override suspend fun getTweets(): Flow<Result<*>> {
        return flow {
            emit(Result.Loading)

            delay(1500) // simulate network calls

            emit(Result.Success(generateTweets()))
        }.catch {
            emit(Result.Error(Exception("An Error Occurred...")))
        }.retryWhen { cause, attempt ->
            if (cause is IOException || attempt < 3) {
                delay(2000)
                true
            } else {
                false
            }
        }
    }
}