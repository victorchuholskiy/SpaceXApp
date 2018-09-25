package com.gmail.victorchuholskiy.spasexapp.usecases.updateRocketsList

import io.reactivex.Single

interface LoadUserListUseCase {

	fun loadUserList(): Single<List<UserRemote>>
}