package com.gmail.victorchuholskiy.spasexapp.data.entities.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "rockets")
data class Rocket(@PrimaryKey() var id: Int,
				  @ColumnInfo(name = "active") var active: Boolean,
				  @ColumnInfo(name = "stages") var stages: Int,
				  @ColumnInfo(name = "boosters") var boosters: Int,
				  @ColumnInfo(name = "costPerLaunch") var costPerLaunch: Long,
				  @ColumnInfo(name = "firstFlight") var firstFlight: String?,
				  @ColumnInfo(name = "country") var country: String?,
				  @ColumnInfo(name = "company") var company: String?,
				  @ColumnInfo(name = "rocketId") var rocketId: String?,
				  @ColumnInfo(name = "rocketName") var rocketName: String?,
				  @ColumnInfo(name = "countOfEngines") var countOfEngines: Int)