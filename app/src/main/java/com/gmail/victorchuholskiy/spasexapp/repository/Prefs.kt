package com.gmail.victorchuholskiy.spasexapp.repository

import android.content.Context
import android.content.SharedPreferences
import com.nalulabs.prefs.boolean

private const val PREF_NAME: String = "mainPrefs"

class Prefs(context: Context) {

	private val prefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

	var firstLaunch by prefs.boolean(true)
}