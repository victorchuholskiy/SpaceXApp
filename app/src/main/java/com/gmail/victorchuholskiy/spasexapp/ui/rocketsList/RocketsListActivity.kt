package com.gmail.victorchuholskiy.spasexapp.ui.rocketsList

import android.app.AlertDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import com.gmail.victorchuholskiy.spasexapp.R
import com.gmail.victorchuholskiy.spasexapp.databinding.ActivityRocketsListBinding
import com.gmail.victorchuholskiy.spasexapp.decorations.RocketsListDecoration
import com.gmail.victorchuholskiy.spasexapp.repository.Prefs
import com.gmail.victorchuholskiy.spasexapp.ui.base.BaseActivity
import com.gmail.victorchuholskiy.spasexapp.ui.launches.LaunchesListActivity
import javax.inject.Inject

/**
 * Created by victor.chukholskiy
 * 25.09.2018.
 */
class RocketsListActivity : BaseActivity<RocketsListViewModel, ActivityRocketsListBinding>() {

	private lateinit var adapter: RocketsListAdapter

	@Inject
	lateinit var vmFactory: ViewModelProvider.Factory

	companion object {
		fun getIntent(ctx: Context) = Intent(ctx, RocketsListActivity::class.java)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setSupportActionBar(binding.incToolbar.toolbar)

		supportActionBar?.apply {
			title = getString(R.string.rockets)
		}

		adapter = RocketsListAdapter(listener = {
			openDetails(
					it.rocketId ?: "",
					it.rocketName ?: "",
					it.details ?: ""
			)
		})
		binding.rv.adapter = adapter
		binding.rv.addItemDecoration(RocketsListDecoration())

		viewModel.rocketsList.observe(this, Observer {
			adapter.update(it)
		})

		if (Prefs(this).firstLaunch) {
			AlertDialog.Builder(this)
					.setTitle(R.string.welcome_title)
					.setMessage(R.string.welcome_msg)
					.setCancelable(false)
					.setPositiveButton("OK")
					{ dialogInterface, _ ->
						Prefs(this).firstLaunch = false
						dialogInterface.cancel()
					}
					.create()
					.show()
		}
	}

	/* inherited */

	override fun getLayoutRes() = R.layout.activity_rockets_list

	override fun getViewModelClass() = RocketsListViewModel::class.java

	override fun getViewModelFactory() = vmFactory

	private fun openDetails(rocketId: String,
							rocketName: String,
							rocketDesc: String) {
		startActivity(LaunchesListActivity.getIntent(this, rocketId, rocketName, rocketDesc))
	}
}