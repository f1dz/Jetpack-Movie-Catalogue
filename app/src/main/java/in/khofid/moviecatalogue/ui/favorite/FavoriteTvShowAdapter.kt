package `in`.khofid.moviecatalogue.ui.favorite

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.utils.Constants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_items.view.*

class FavoriteTvShowAdapter(
    private val listener: (TvShow) -> Unit
): PagedListAdapter<TvShow, FavoriteTvShowViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavoriteTvShowViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_items, parent, false))

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val favorite: TvShow? = getItem(position)

        favorite?.let {
            holder.itemView.tvTitle.text = it.title
            holder.itemView.tvDescription.text = it.description
            holder.itemView.tvYear.text = it.firstAirDate
            holder.itemView.ratingBar.rating = it.rating/2

            Glide.with(holder.itemView.context)
                .load(Constants.IMG_URL + it.poster)
                .into(holder.itemView.imgPoster)

            holder.itemView.setOnClickListener { listener(favorite) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShow>() {
            override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow) =
                oldItem.id == newItem.id
        }
    }
}

class FavoriteTvShowViewHolder(view: View): RecyclerView.ViewHolder(view)