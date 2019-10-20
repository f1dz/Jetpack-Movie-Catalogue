package `in`.khofid.moviecatalogue.ui.home

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.ui.movie.MovieFragment
import `in`.khofid.moviecatalogue.ui.tv.TvFragment
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_home.*

const val SELECTED_MENU = "selected_menu"

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        nav_view.setOnNavigationItemSelectedListener {
            var fragment: Fragment?

            fragment = when (it.itemId) {
                R.id.action_movie -> MovieFragment.newInstance()
                R.id.action_tv -> TvFragment.newInstance()
                else -> null
            }

            if(fragment != null) {
                supportFragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.container, fragment)
                    .commit()

            }

            true
        }

        if (savedInstanceState != null) {
            savedInstanceState.getInt(SELECTED_MENU)
        } else {
            nav_view.selectedItemId = R.id.action_movie
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(SELECTED_MENU, nav_view.selectedItemId)
    }
}
