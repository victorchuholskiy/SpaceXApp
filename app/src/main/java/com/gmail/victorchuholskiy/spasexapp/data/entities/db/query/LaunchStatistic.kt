package com.gmail.victorchuholskiy.spasexapp.data.entities.db.query

import android.arch.persistence.room.ColumnInfo

data class LaunchStatistic(@ColumnInfo(name = "launch_year") var launchYear: Int,
						   @ColumnInfo(name = "launch_count") var count: Int)