package com.tdd.data.repositoryImpl

import com.tdd.data.dataSource.AuthDataSource
import com.tdd.data.mapper.auth.LogInMapper
import com.tdd.data.mapper.auth.LogInMapper.toDto
import com.tdd.domain.entity.request.auth.AuthRequestModel
import com.tdd.domain.entity.response.auth.AuthResponseModel
import com.tdd.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
) : AuthRepository {

    override suspend fun postLogIn(request: AuthRequestModel): Flow<Result<AuthResponseModel>> =
        LogInMapper.responseToModel(apiCall = { authDataSource.postLogIn(request.toDto()) })
}