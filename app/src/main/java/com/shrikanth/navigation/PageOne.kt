package com.shrikanth.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PageOne.newInstance] factory method to
 * create an instance of this fragment.
 */
class PageOne : Fragment() {


    private val pageOneArgs: PageOneArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.button)
        val text: TextView = view.findViewById(R.id.text)
        button.setOnClickListener {
            val action = PageOneDirections.actionPageOneToPageTwo2()
            action.id = 3
            findNavController().navigate(action)
        }
        findNavController().currentBackStackEntry!!.savedStateHandle.getLiveData("key", "Default")
            .observe(this.viewLifecycleOwner) {
                text.text = it
            }
    }
}