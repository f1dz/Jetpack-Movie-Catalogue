package `in`.khofid.moviecatalogue.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class InfiniteScrollListener: RecyclerView.OnScrollListener() {
    private var mTotalPrev = 0
    private var mLoading = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val visibleItemCount = recyclerView.childCount
        val totalItemCount = recyclerView.layoutManager!!.itemCount
        val firstVisibleItem = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

        if(mLoading) {
            if(totalItemCount > mTotalPrev) {
                mLoading = false
                mTotalPrev = totalItemCount
            }
        }
        val threshold = 3
        if(!mLoading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + threshold)){
            onLoadMore()
            mLoading = true
        }
    }

    abstract fun onLoadMore()
}
