package com.gmail.victorchuholskiy.spasexapp.repository.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import com.gmail.victorchuholskiy.spasexapp.repository.db.dao.LaunchesDao
import com.gmail.victorchuholskiy.spasexapp.repository.db.dao.RocketsDao

/**
 * Created by viktor.chukholskiy
 * 18/08/18.
 */
@Database(entities = [Rocket::class, Launch::class], version = 1)
abstract class SpaceXDataBase : RoomDatabase() {

	abstract fun productsDao(): RocketsDao

	abstract fun launchesDao(): LaunchesDao

	companion object {
		private var INSTANCE: SpaceXDataBase? = null

		fun getInstance(context: Context): SpaceXDataBase {
			synchronized(SpaceXDataBase::class) {
				return INSTANCE ?: Room.databaseBuilder(context.applicationContext,
						SpaceXDataBase::class.java, "products_database")
						.build()
			}
		}

		fun destroyInstance() {
			INSTANCE = null
		}
	}
}