package `in`.khofid.moviecatalogue.utils

import androidx.test.espresso.idling.CountingIdlingResource

const val RESOURCE = "GLOBAL"

class EspressoIdlingResource {

    companion object {
        val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

        fun increment() {
            espressoTestIdlingResource.increment()
        }

        fun decrement() {
            espressoTestIdlingResource.decrement()
        }
    }
}