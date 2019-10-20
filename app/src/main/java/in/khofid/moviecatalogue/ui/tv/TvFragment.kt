package `in`.khofid.moviecatalogue.ui.tv


import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.TvShow
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tv.*

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
                Toast.makeText(context!!, it.title, Toast.LENGTH_SHORT).show()
            }
            rvTvShow.layoutManager = LinearLayoutManager(context)
            rvTvShow.setHasFixedSize(true)
        }
    }

}
