package `in`.khofid.moviecatalogue.testing

import `in`.khofid.moviecatalogue.R
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class SingleFragmentActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val content: View = FrameLayout(this)
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.CENTER
        )
        content.layoutParams = params
        content.id = R.id.container

        setContentView(content)
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment, "TEST")
            .commit()
    }
}