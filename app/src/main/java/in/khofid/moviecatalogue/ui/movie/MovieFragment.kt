package `in`.khofid.moviecatalogue.ui.movie


import `in`.khofid.moviecatalogue.ui.detail.DetailMovieActivity
import `in`.khofid.moviecatalogue.utils.hide
import `in`.khofid.moviecatalogue.utils.show
import `in`.khofid.moviecatalogue.viewmodel.ViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import org.jetbrains.anko.support.v4.startActivity


/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(`in`.khofid.moviecatalogue.R.layout.fragment_movie, container, false)
    }

    companion object {
        fun newInstance(): Fragment {
            return MovieFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        progress_bar.show()

        if(activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = MovieAdapter(context!!) {
                startActivity<DetailMovieActivity>("movieId" to it.id)
            }

            viewModel.getMovies().observe(this, Observer { movies ->
                adapter.setMovies(movies)
                progress_bar.hide()
            })

            rv_movie.adapter = adapter
            rv_movie.layoutManager = LinearLayoutManager(context)
            rv_movie.setHasFixedSize(true)
        }
    }

    private fun obtainViewModel(activity: FragmentActivity): MovieViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(MovieViewModel::class.java)
    }
}
