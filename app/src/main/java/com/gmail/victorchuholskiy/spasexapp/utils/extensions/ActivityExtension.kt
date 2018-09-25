package com.gmail.victorchuholskiy.spasexapp.utils.extensions

import android.app.Activity
import android.support.annotation.StringRes
import android.widget.Toast

fun Activity.toast(msg: String?,
				   length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, msg, length).show()

fun Activity.toast(@StringRes msgRes: Int,
				   length: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, msgRes, length).show()
