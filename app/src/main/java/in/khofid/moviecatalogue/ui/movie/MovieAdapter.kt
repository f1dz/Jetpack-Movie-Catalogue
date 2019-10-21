package `in`.khofid.moviecatalogue.ui.movie

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.Movie
import `in`.khofid.moviecatalogue.utils.Constants
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_items.view.*

class MovieAdapter(
    private val context: Context,
    private val movies: List<Movie>,
    private val listener: (Movie) -> Unit
    ): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_items, parent, false))

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(movies[position], listener)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        fun bindItem(movie: Movie, listener: (Movie) -> Unit) {
            Glide.with(itemView.context)
                .load(Constants.IMG_URL + movie.poster)
                .into(itemView.imgPoster)

            itemView.tvTitle.text = movie.title
            itemView.tvDescription.text = movie.description
            itemView.ratingBar.rating = movie.vote/2

            itemView.setOnClickListener { listener(movie) }
        }
    }
}