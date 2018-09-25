package com.gmail.victorchuholskiy.spasexapp.decorations

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.gmail.victorchuholskiy.spasexapp.R

/**
 * Created by viktor.chukholskiy
 * 9/25/18.
 */
class RocketsListDecoration : RecyclerView.ItemDecoration() {
	override fun getItemOffsets(outRect: Rect,
								view: View,
								parent: RecyclerView,
								state: RecyclerView.State) {
		val params = view.layoutParams as RecyclerView.LayoutParams
		val position = params.viewAdapterPosition
		val res = view.context.resources
		val itemTopMargin = res.getDimensionPixelSize(R.dimen.items_top_margin)
		val itemDefMargin = res.getDimensionPixelSize(R.dimen.items_def_margin)
		outRect.set(itemDefMargin, if (position == 0) itemTopMargin else 0, itemDefMargin, 0)
	}
}
