package com.gmail.victorchuholskiy.spasexapp.di.module

import com.gmail.victorchuholskiy.spasexapp.BuildConfig
import com.gmail.victorchuholskiy.spasexapp.di.scope.AppScope
import com.gmail.victorchuholskiy.spasexapp.repository.api.MainApi
import com.gmail.victorchuholskiy.spasexapp.repository.api.error.RxErrorHandlingCallAdapterFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
object RetrofitModule {

	@JvmStatic
	@Provides
	@AppScope
	fun provideMainApi(@Named("mainApi") retrofit: Retrofit) = retrofit.create<MainApi>(MainApi::class.java)!!

	@JvmStatic
	@Provides
	@Named("mainApi")
	@AppScope
	fun provideRetrofitMain(okHttpClient: OkHttpClient) =
			buildRetrofit(okHttpClient, Gson(), BuildConfig.MAIN_API_URL)

	@JvmStatic
	@Provides
	@AppScope
	fun provideOkHttpClient() = with(OkHttpClient.Builder()) {
		interceptors().add(HttpLoggingInterceptor().apply {
			level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else level

		})
		build()
	}!!

	@JvmStatic
	private fun buildRetrofit(
			okHttpClient: OkHttpClient,
			gson: Gson,
			url: String) =
			Retrofit.Builder()
					.client(okHttpClient)
					.baseUrl(url)
					.addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
					.addConverterFactory(GsonConverterFactory.create(gson))
					.build()!!
}