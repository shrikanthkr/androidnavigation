package com.shrikanth.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PageTwo.newInstance] factory method to
 * create an instance of this fragment.
 */
class PageTwo : Fragment() {

    private val pageTwoArgs: PageTwoArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.done)
        val toThree: Button = view.findViewById(R.id.toThree)
        val text: EditText = view.findViewById(R.id.editTextTextPersonName)
        button.setOnClickListener {
            findNavController().previousBackStackEntry!!.savedStateHandle.set(
                "key",
                text.text.toString()
            )
            findNavController().popBackStack()
        }
        toThree.setOnClickListener {
            val action = PageTwoDirections.actionPageTwoToPageTwo3()
            findNavController().navigate(action)
        }
        findNavController().currentBackStackEntry!!.savedStateHandle.getLiveData<String>(
            "key",
        ).observe(viewLifecycleOwner) {
            text.setText(it)
            findNavController().previousBackStackEntry!!.savedStateHandle.set(
                "key",
                text.text.toString()
            )
            findNavController().popBackStack()
        }
    }
}