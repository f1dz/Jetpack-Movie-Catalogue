package `in`.khofid.moviecatalogue.ui.movie


import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.Movie
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*


/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    lateinit var viewModel: MovieViewModel
    lateinit var movies: List<Movie>
    lateinit var adapter: MovieAdapter

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
                Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            }
            rv_movie.adapter = adapter
            rv_movie.layoutManager = LinearLayoutManager(context)
            rv_movie.setHasFixedSize(true)
        }
    }
}
