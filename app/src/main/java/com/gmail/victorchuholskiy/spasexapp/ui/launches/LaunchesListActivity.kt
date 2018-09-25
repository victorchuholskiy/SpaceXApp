package com.gmail.victorchuholskiy.spasexapp.ui.launches

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.gmail.victorchuholskiy.spasexapp.R
import com.gmail.victorchuholskiy.spasexapp.databinding.ActivityLaunchesBinding
import com.gmail.victorchuholskiy.spasexapp.ui.base.BaseActivity
import javax.inject.Inject

/**
 * Created by victor.chukholskiy
 * 25.09.2018.
 */
class LaunchesListActivity : BaseActivity<LaunchesListViewModel, ActivityLaunchesBinding>() {

	private lateinit var adapter: LaunchesListAdapter

	@Inject
	lateinit var vmFactory: ViewModelProvider.Factory

	companion object {

		const val ROCKET_ID_PARAM  = "rocket_id_param"
		const val ROCKET_NAME_PARAM  = "rocket_name_param"
		const val ROCKET_DESC_PARAM  = "rocket_desc_param"

		fun getIntent(ctx: Context,
					  rocketId: String,
					  rocketName: String,
					  rocketDesc: String) : Intent {
			val intent = Intent(ctx, LaunchesListActivity::class.java)
			intent.putExtra(ROCKET_ID_PARAM, rocketId)
			intent.putExtra(ROCKET_NAME_PARAM, rocketName)
			intent.putExtra(ROCKET_DESC_PARAM, rocketDesc)
			return intent
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setSupportActionBar(binding.incToolbar.toolbar)

		adapter = LaunchesListAdapter()
		binding.rv.adapter = adapter
		binding.rv.isNestedScrollingEnabled = false

		supportActionBar?.apply {
			title = intent.extras!!.getString(ROCKET_NAME_PARAM)
			setDisplayHomeAsUpEnabled(true)
		}

		viewModel.launchesList.observe(this, Observer {
			adapter.update(it)
		})

		viewModel.details.observe(this, Observer {
			binding.tvDetails.text = it
		})
	}

	/* inherited */

	override fun getLayoutRes() = R.layout.activity_launches

	override fun getViewModelClass() = LaunchesListViewModel::class.java

	override fun getViewModelFactory() = vmFactory
}