package `in`.khofid.moviecatalogue.ui.favorite

import `in`.khofid.moviecatalogue.R
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FavoriteTabAdapter(val ctx: Context, fm: FragmentManager): FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTVFragment()
            else -> FavoriteMovieFragment()
        }
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> ctx.getString(R.string.movie)
            1 -> ctx.getString(R.string.tv)
            else -> null
        }
    }
}