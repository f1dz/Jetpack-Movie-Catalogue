package `in`.khofid.moviecatalogue.ui.tv


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import `in`.khofid.moviecatalogue.R

/**
 * A simple [Fragment] subclass.
 */
class TvFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    companion object {
        fun newInstance() = TvFragment()
    }

}
