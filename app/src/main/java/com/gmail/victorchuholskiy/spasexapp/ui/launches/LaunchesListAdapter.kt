package com.gmail.victorchuholskiy.spasexapp.ui.launches

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gmail.victorchuholskiy.spasexapp.R
import com.gmail.victorchuholskiy.spasexapp.BR
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_launch.view.*

/**
 * Created by aleksey.stepanov
 * 8/9/18.
 */
class LaunchesListAdapter : RecyclerView.Adapter<LaunchesListAdapter.VH>() {

	private val data = mutableListOf<Launch>()

	/* inherited */

	override fun getItemCount() = data.size

	override fun onCreateViewHolder(parent: ViewGroup,
									viewType: Int): VH {
		val binding: ViewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_launch, parent, false)
		return VH(binding)
	}

	override fun onBindViewHolder(holder: VH,
								  position: Int) = holder.bind(data[position])

	/* own methods */

	fun update(newData: List<Launch>?) {
		data.clear()
		newData?.run { data.addAll(this) }
		notifyDataSetChanged()
	}

	/* data types */

	class VH(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

		fun bind(launch: Launch) {
			binding.setVariable(BR.launch, launch)
			binding.executePendingBindings()

			Picasso.get()
					.load(launch.url)
					.error(R.drawable.ic_placeholder)
					.placeholder(R.drawable.ic_placeholder)
					.into(binding.root.iv)
		}

	}
}