package com.gmail.victorchuholskiy.spasexapp.ui.launches

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.IntDef
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gmail.victorchuholskiy.spasexapp.R
import com.gmail.victorchuholskiy.spasexapp.BR
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.Launch
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_chart.view.*
import kotlinx.android.synthetic.main.item_details.view.*
import kotlinx.android.synthetic.main.item_launch.view.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.anychart.enums.MarkerType
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.enums.TooltipPositionMode
import com.anychart.AnyChart
import com.anychart.data.Set
import com.gmail.victorchuholskiy.spasexapp.data.entities.db.query.LaunchStatistic
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.enums.Anchor

/**
 * Created by victor.chukholskiy
 * 25.09.2018.
 */
class LaunchesListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

	private val data = mutableListOf<Launch>()
	private val dataStatistic = mutableListOf<LaunchStatistic>()
	private var details: String = ""

	/* inherited */

	override fun getItemCount() = data.size + 2

	override fun onCreateViewHolder(parent: ViewGroup,
									viewType: Int): RecyclerView.ViewHolder {
		val layoutInflater = LayoutInflater.from(parent.context)
		return when (viewType) {
			CHART -> ChartViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_chart, parent, false))
			DETAILS -> DetailsViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_details, parent, false))
			else -> LaunchViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_launch, parent, false))
		}
	}

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		when (holder.itemViewType) {
			CHART -> (holder as ChartViewHolder).bind(dataStatistic)
			DETAILS -> (holder as DetailsViewHolder).bind(details)
			else -> (holder as LaunchViewHolder).bind(data[position - 2])
		}
	}

	/* own methods */

	fun updateStatistic(newData: List<LaunchStatistic>?) {
		dataStatistic.clear()
		newData?.run { dataStatistic.addAll(this) }
		notifyItemChanged(0)
	}

	fun updateDetails(details: String) {
		this.details = details
		notifyItemChanged(1)
	}

	fun updateLaunches(newData: List<Launch>?) {
		data.clear()
		newData?.run { data.addAll(this) }
		notifyDataSetChanged()
	}

	/* data types */

	class LaunchViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
		fun bind(launch: Launch) {
			binding.setVariable(BR.launch, launch)
			binding.executePendingBindings()

			val dateFormat = SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.GERMAN)
			binding.root.tv_date.text = dateFormat.format(Date(TimeUnit.SECONDS.toMillis(launch.launchDateUnix)))

			Picasso.get()
					.load(launch.url)
					.error(R.drawable.ic_placeholder)
					.placeholder(R.drawable.ic_placeholder)
					.into(binding.root.iv)
		}

	}

	class DetailsViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
		fun bind(details: String) {
			binding.executePendingBindings()
			binding.root.tv_details.text = details
		}
	}

	class ChartViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
		private var isDisplayed = false
		fun bind(data: List<LaunchStatistic>) {
			binding.executePendingBindings()
			if (data.isNotEmpty()) {
				binding.root.acv_chart.visibility = View.VISIBLE
				binding.root.tv_no_launches.visibility = View.GONE

				if (!isDisplayed) {
					val cartesian = AnyChart.line()
					cartesian.animation(true)
					cartesian.tooltip().positionMode(TooltipPositionMode.POINT)

					cartesian.title("Launches statistic")
					val seriesData = ArrayList<DataEntry>()
					var maxValue = 0
					for (statistic in data) {
						seriesData.add(ValueDataEntry(statistic.launchYear.toString(), statistic.count))
						if (maxValue < statistic.count) {
							maxValue = statistic.count
						}
					}
					cartesian.yScale()
							.minimum(0)
							.maximum(if (maxValue < 4) 4 else maxValue)

					val set = Set.instantiate()
					set.data(seriesData)
					val series1Mapping = set.mapAs("{ x: 'x', value: 'value'}")

					val series1 = cartesian.line(series1Mapping)
					series1.hovered().markers().enabled(true)
					series1.hovered().markers()
							.type(MarkerType.CIRCLE)
							.size(4.0)
					series1.tooltip()
							.position("right")
							.anchor(Anchor.LEFT_CENTER)
							.offsetX(5.0)
							.offsetY(5.0)
					binding.root.acv_chart.setChart(cartesian)
					isDisplayed = true
				}
			} else {
				binding.root.acv_chart.visibility = View.GONE
				binding.root.tv_no_launches.visibility = View.VISIBLE
			}
		}
	}

	override fun getItemViewType(position: Int): Int {
		return when (position) {
			0 -> CHART
			1 -> DETAILS
			else -> LAUNCH
		}
	}

	companion object {
		@IntDef(DETAILS, LAUNCH)
		@Retention(AnnotationRetention.SOURCE)
		annotation class Type

		const val CHART = 0
		const val DETAILS = 1
		const val LAUNCH = 2
	}
}