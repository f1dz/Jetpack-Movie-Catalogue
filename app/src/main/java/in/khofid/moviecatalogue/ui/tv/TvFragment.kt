package `in`.khofid.moviecatalogue.ui.tv


import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.model.TvShow
import `in`.khofid.moviecatalogue.ui.detail.DetailTvShowActivity
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
import kotlinx.android.synthetic.main.fragment_tv.*
import org.jetbrains.anko.support.v4.startActivity

class TvFragment : Fragment() {

    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    private var page = 1
    private var mShows: MutableList<TvShow> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    companion object {
        fun newInstance() = TvFragment()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        progressBar.show()

        if(activity != null) {
            viewModel = obtainViewModel(requireActivity())
            adapter = TvShowAdapter(context!!) {
                startActivity<DetailTvShowActivity>("tvShowId" to it.id)
            }

            loadShows()

            rvTvShow.adapter = adapter
            rvTvShow.layoutManager = LinearLayoutManager(context)
            rvTvShow.setHasFixedSize(true)
        }

        rvTvShow.addOnScrollListener(scrollData())
    }

    private fun obtainViewModel(activity: FragmentActivity): TvShowViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProviders.of(activity, factory).get(TvShowViewModel::class.java)
    }

    private fun loadShows(){
        progressBar.show()
        viewModel.page = page
        viewModel.getTvShows().observe(this, Observer { tvShows->
            mShows.addAll(tvShows)
            adapter.setTvShows(mShows)
            progressBar.hide()
        })
    }

    private fun scrollData(): InfiniteScrollListener{
        return object : InfiniteScrollListener(){
            override fun onLoadMore() {
                page += 1
                loadShows()
            }

        }
    }

}
