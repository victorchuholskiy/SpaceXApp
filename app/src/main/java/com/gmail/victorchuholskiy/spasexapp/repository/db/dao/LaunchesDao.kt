package com.gmail.victorchuholskiy.spasexapp.repository.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import io.reactivex.Flowable

/**
 * Created by user
 * 24.09.2018.
 */
@Dao
interface LaunchesDao {

	@Query("SELECT * from launches")
	fun getAll(): Flowable<List<Launch>>

	@Query("SELECT * from launches WHERE rocket_id LIKE :rocketId")
	fun getAllByRocketId(rocketId: String): Flowable<List<Launch>>

	@Query("SELECT COUNT(*) FROM launches")
	fun getNumberOfRows(): Flowable<Int>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertAll(data: List<Launch>)

	@Query("DELETE FROM launches")
	fun deleteProducts()
}