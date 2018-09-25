package com.gmail.victorchuholskiy.spasexapp.data.entities.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "rockets")
data class Rocket(@PrimaryKey() var id: Int,
				  @ColumnInfo(name = "active") var active: Boolean,
				  @ColumnInfo(name = "stages") var stages: Int,
				  @ColumnInfo(name = "boosters") var boosters: Int,
				  @ColumnInfo(name = "cost_per_launch") var costPerLaunch: Long,
				  @ColumnInfo(name = "first_flight") var firstFlight: String?,
				  @ColumnInfo(name = "country") var country: String?,
				  @ColumnInfo(name = "company") var company: String?,
				  @ColumnInfo(name = "rocket_id") var rocketId: String?,
				  @ColumnInfo(name = "rocket_name") var rocketName: String?,
				  @ColumnInfo(name = "details") var details: String?,
				  @ColumnInfo(name = "count_of_engines") var countOfEngines: Int)