package com.shrikanth.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.activity.OnBackPressedCallback




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PageThree.newInstance] factory method to
 * create an instance of this fragment.
 */
class PageThree : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val done: Button = view.findViewById(R.id.done)
        val passAndMove: Button = view.findViewById(R.id.pass_and_move)
        done.setOnClickListener {
            findNavController().previousBackStackEntry!!.savedStateHandle.set("key", "this is a string from page 3")
            findNavController().popBackStack()
        }
        passAndMove.setOnClickListener {
            findNavController().previousBackStackEntry!!.savedStateHandle.set("pass", "This is my pass label")
            findNavController().popBackStack()
        }
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                    findNavController().previousBackStackEntry!!.savedStateHandle.set("key", "Cancelled")
                    findNavController().popBackStack()
                }
            }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}