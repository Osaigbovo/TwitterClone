package com.osaigbovo.twitterclone.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import com.osaigbovo.twitterclone.data.result.Result

abstract class FlowUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P?): Flow<Result<R>> {
        return execute(parameters)
            .catch { e -> emit(Result.Error(Exception(e))) }
            .flowOn(coroutineDispatcher)
    }

    abstract suspend fun execute(parameters: P?): Flow<Result<R>>
}
