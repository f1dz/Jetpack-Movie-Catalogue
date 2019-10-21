package `in`.khofid.moviecatalogue.ui.detail

import `in`.khofid.moviecatalogue.R
import `in`.khofid.moviecatalogue.utils.DataDummy
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class DetailTvShowActivityTest {

    var tvShow = DataDummy.generateDummyTvShow().get(0)

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<DetailTvShowActivity> =
        object : ActivityTestRule<DetailTvShowActivity>(DetailTvShowActivity::class.java) {

            override fun getActivityIntent(): Intent {
                val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailTvShowActivity::class.java)
                result.putExtra("tvShowId", tvShow.id)
                return result
            }
        }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(tvShow.title)))
        onView(withId(R.id.tvDescription)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDescription)).check(matches(withText(tvShow.description)))
        onView(withId(R.id.imgPoster)).check(matches(isDisplayed()))
        onView(withId(R.id.imgBackdrop)).check(matches(isDisplayed()))
    }
}