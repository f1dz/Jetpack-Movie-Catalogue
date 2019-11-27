package `in`.khofid.moviecatalogue.ui.favorite


import `in`.khofid.moviecatalogue.R
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

class FavoriteMovieFragment : Fragment() {

    private lateinit var viewModel: FavoriteViewModel
    private lateinit var adapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        progress_bar.show()

        if(activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = FavoriteMovieAdapter{
                startActivity<DetailMovieActivity>("movieId" to it.id)
            }

            viewModel.getMovies().observe(this, Observer {
                adapter.submitList(it)
                progress_bar.hide()
            })

            rv_movie.adapter = adapter
            rv_movie.layoutManager = LinearLayoutManager(context)
            rv_movie.setHasFixedSize(true)
        }
    }

    private fun obtainViewModel(activity: FragmentActivity): FavoriteViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return  ViewModelProviders.of(activity, factory).get(FavoriteViewModel::class.java)
    }
}
