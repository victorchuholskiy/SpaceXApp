package com.gmail.victorchuholskiy.spasexapp.data.entities.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "launches")
data class Launch(@PrimaryKey() var id: Int,
				  @ColumnInfo(name = "rocket_id") var rocketId: String,
				  @ColumnInfo(name = "mission_name") var missionName: String,
				  @ColumnInfo(name = "launch_year") var launchYear: Int,
				  @ColumnInfo(name = "launch_date_unix") var launchDateUnix: Long,
				  @ColumnInfo(name = "launch_success") var launchSuccess: Boolean,
				  @ColumnInfo(name = "url") var url: String?)