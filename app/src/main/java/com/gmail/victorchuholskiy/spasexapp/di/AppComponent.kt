package  com.gmail.victorchuholskiy.spasexapp.di

import com.gmail.victorchuholskiy.spasexapp.App
import com.gmail.victorchuholskiy.spasexapp.di.module.ActivityModule
import com.gmail.victorchuholskiy.spasexapp.di.module.AppModule
import com.gmail.victorchuholskiy.spasexapp.di.module.RepositoryModule
import com.gmail.victorchuholskiy.spasexapp.di.module.RetrofitModule
import com.gmail.victorchuholskiy.spasexapp.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by aleksey.stepanov
 * 8/13/18.
 */
@AppScope
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityModule::class, RetrofitModule::class, RepositoryModule::class])
interface AppComponent : AndroidInjector<App> {

	@Component.Builder
	interface Builder {

		@BindsInstance
		fun app(app: App): Builder

		fun build(): AppComponent
	}
}