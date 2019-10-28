package `in`.khofid.moviecatalogue.ui.tv

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.utils.Constants
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_items.view.*

class TvShowAdapter(
    private val context: Context,
    private val listener: (TvShow) -> Unit): RecyclerView.Adapter<TvShowAdapter.ViewHolder>() {

    private var mTvShows: MutableList<TvShow> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_items, parent, false))

    override fun getItemCount()= mTvShows.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(mTvShows[position], listener)
    }

    fun setTvShows(tvShows: List<TvShow>) {
        mTvShows.clear()
        mTvShows.addAll(tvShows)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bindView(tv: TvShow, listener: (TvShow) -> Unit) {
            Glide.with(itemView.context)
                .load(Constants.IMG_URL + tv.poster)
                .into(itemView.imgPoster)

            itemView.tvTitle.text = tv.title
            itemView.tvDescription.text = tv.description
            itemView.ratingBar.rating = tv.rating/2

            itemView.setOnClickListener { listener(tv) }
        }

    }
}