package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.data.TvShow
import `in`.khofid.moviecatalogue.utils.Constants
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_tv_show.*

class DetailTvShowActivity : AppCompatActivity() {

    private var tvShowId: Int = 0
    private lateinit var tvShow: TvShow
    private lateinit var viewModel: DetailTvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv_show)

        tvShowId = intent.getIntExtra("tvShowId", 0)

        viewModel = ViewModelProviders.of(this).get(DetailTvShowViewModel::class.java)
        viewModel.tvShowId = tvShowId
        tvShow = viewModel.getTvShow()

        tvTitle.text = tvShow.title
        tvDescription.text = tvShow.description
        ratingBar.rating = tvShow.rating/2

        Glide.with(this)
            .load(Constants.IMG_URL + tvShow.backdrop)
            .into(imgBackdrop)


        Glide.with(this)
            .load(Constants.IMG_URL + tvShow.poster)
            .into(imgPoster)
    }
}
