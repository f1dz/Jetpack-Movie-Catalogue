package `in`.khofid.moviecatalogue.ui.favorite

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.utils.Constants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_items.view.*

class FavoriteMovieAdapter(
    private val listener: (Movie) -> Unit
): PagedListAdapter<Movie, FavoriteMovieViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavoriteMovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_items, parent, false))

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        val favorite: Movie? = getItem(position)

        favorite?.let {
            holder.itemView.tvTitle.text = it.title
            holder.itemView.tvDescription.text = it.description
            holder.itemView.tvYear.text = it.releaseDate
            holder.itemView.ratingBar.rating = it.vote/2

            Glide.with(holder.itemView.context)
                .load(Constants.IMG_URL + it.poster)
                .into(holder.itemView.imgPoster)

            holder.itemView.setOnClickListener { listener(favorite) }
        }

    }

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie) =
                oldItem.id == newItem.id
        }
    }

}

class FavoriteMovieViewHolder(view: View): RecyclerView.ViewHolder(view)
