package `in`.khofid.moviecatalogue.ui.movie


import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.model.Movie
import `in`.khofid.moviecatalogue.ui.detail.DetailMovieActivity
import `in`.khofid.moviecatalogue.utils.InfiniteScrollListener
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


class MovieFragment : Fragment() {

    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter
    private var page = 1
    private var mMovies: MutableList<Movie> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
            viewModel = obtainViewModel(requireActivity())
            adapter = MovieAdapter(context!!) {
                startActivity<DetailMovieActivity>("movieId" to it.id)
            }

            loadMovies()

            rv_movie.adapter = adapter
            rv_movie.layoutManager = LinearLayoutManager(context)
            rv_movie.setHasFixedSize(true)
        }

        rv_movie.addOnScrollListener(scrollData())
    }

    private fun obtainViewModel(activity: FragmentActivity): MovieViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(MovieViewModel::class.java)
    }

    private fun loadMovies(){
        progress_bar.show()
        viewModel.page = page
        viewModel.getMovies().observe(this, Observer { movies ->
            mMovies.addAll(movies)
            adapter.setMovies(mMovies)
            progress_bar.hide()
        })
    }

    private fun scrollData(): InfiniteScrollListener {
        return object : InfiniteScrollListener() {
            override fun onLoadMore() {
                page += 1
                loadMovies()
            }
        }
    }
}