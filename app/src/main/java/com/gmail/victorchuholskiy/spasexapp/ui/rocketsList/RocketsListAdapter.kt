package com.gmail.victorchuholskiy.spasexapp.ui.rocketsList

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.victorchuholskiy.spasexapp.R
import com.gmail.victorchuholskiy.spasexapp.BR
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Rocket

/**
 * Created by aleksey.stepanov
 * 8/9/18.
 */
class RocketsListAdapter : RecyclerView.Adapter<RocketsListAdapter.VH>() {

	private val data = mutableListOf<Rocket>()

	/* inherited */

	override fun getItemCount() = data.size

	override fun onCreateViewHolder(parent: ViewGroup,
									viewType: Int): VH {
		val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_rocket, parent, false)
		return VH(binding)
	}

	override fun onBindViewHolder(holder: VH,
								  position: Int) = holder.bind(data[position])

	/* own methods */

	fun update(newData: List<Rocket>?) {
		data.clear()
		newData?.run { data.addAll(this) }
		notifyDataSetChanged()
	}

	/* data types */

	class VH(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

		fun bind(rocket: Rocket) {
			binding.setVariable(BR.rocket, rocket)
			binding.executePendingBindings()
		}

	}
}