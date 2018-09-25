package com.gmail.victorchuholskiy.spasexapp.repository.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket
import io.reactivex.Flowable

/**
 * Created by user
 * 24.09.2018.
 */
@Dao
interface RocketsDao {

	@Query("SELECT * from rockets")
	fun getAll(): Flowable<List<Rocket>>

	@Query("SELECT COUNT(*) FROM rockets")
	fun getNumberOfRows(): Flowable<Int>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertAll(data: List<Rocket>)

	@Query("DELETE FROM rockets")
	fun deleteProducts()
}