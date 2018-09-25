package com.gmail.victorchuholskiy.spasexapp.ui.rocketsList

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.gmail.victorchuholskiy.spasexapp.R
import com.gmail.victorchuholskiy.spasexapp.databinding.ActivityRocketsListBinding
import com.gmail.victorchuholskiy.spasexapp.decorations.RocketsListDecoration
import com.gmail.victorchuholskiy.spasexapp.ui.base.BaseActivity
import javax.inject.Inject

/**
 * Created by aleksey.stepanov
 * 8/9/18.
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

		adapter = RocketsListAdapter()
		binding.rv.adapter = adapter
		binding.rv.addItemDecoration(RocketsListDecoration())

		viewModel.rocketsList.observe(this, Observer {
			adapter.update(it)
		})
	}

	/* inherited */

	override fun getLayoutRes() = R.layout.activity_rockets_list

	override fun getViewModelClass() = RocketsListViewModel::class.java

	override fun getViewModelFactory() = vmFactory
}