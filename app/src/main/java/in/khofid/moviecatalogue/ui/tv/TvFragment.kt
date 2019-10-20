package `in`.khofid.moviecatalogue.ui.tv


import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.TvShow
import `in`.khofid.moviecatalogue.ui.detail.DetailTvShowActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tv.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * A simple [Fragment] subclass.
 */
class TvFragment : Fragment() {

    lateinit var viewModel: TvShowViewModel
    lateinit var tvShows: List<TvShow>

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
        if(activity != null) {
            viewModel = ViewModelProviders.of(this).get(TvShowViewModel::class.java)
            tvShows = viewModel.getTvShow()
            rvTvShow.adapter = TvShowAdapter(context!!, tvShows) {
                startActivity<DetailTvShowActivity>("tvShowId" to it.id)
            }
            rvTvShow.layoutManager = LinearLayoutManager(context)
            rvTvShow.setHasFixedSize(true)
        }
    }

}
