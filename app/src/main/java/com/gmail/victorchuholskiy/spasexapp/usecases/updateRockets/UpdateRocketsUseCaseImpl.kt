package com.gmail.victorchuholskiy.spasexapp.usecases.updateRocketsList

import javax.inject.Inject

class LoadUserListUseCaseImpl @Inject constructor(private val remoteRepository: UserRemoteRepository) : LoadUserListUseCase {

	override fun loadUserList() = remoteRepository.loadUserList()
}