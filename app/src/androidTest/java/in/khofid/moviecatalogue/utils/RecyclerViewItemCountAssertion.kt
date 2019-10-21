package `in`.khofid.moviecatalogue.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat

class RecyclerViewItemCountAssertion(private val expectedCount: Int): ViewAssertion {

    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if(noViewFoundException != null) {
            throw noViewFoundException
        }

        val rv = view as RecyclerView
        val adapter = rv.adapter
        assertNotNull(adapter)
        assertThat(adapter!!.itemCount, `is`(expectedCount))
    }
}