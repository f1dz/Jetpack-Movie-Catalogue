package `in`.khofid.moviecatalogue.ui.movie


import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.Movie
import `in`.khofid.moviecatalogue.ui.detail.DetailMovieActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import org.jetbrains.anko.support.v4.startActivity


/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    private lateinit var viewModel: MovieViewModel
    private lateinit var movies: List<Movie>
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    companion object {
        fun newInstance(): Fragment {
            return MovieFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if(activity != null) {
            viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
            movies = viewModel.getMovies()
            adapter = MovieAdapter(context!!, movies) {
                startActivity<DetailMovieActivity>("movieId" to it.id)
            }
            rv_movie.adapter = adapter
            rv_movie.layoutManager = LinearLayoutManager(context)
            rv_movie.setHasFixedSize(true)
        }
    }
}
