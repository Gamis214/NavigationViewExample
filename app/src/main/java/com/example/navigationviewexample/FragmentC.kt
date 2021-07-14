package com.example.navigationviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class FragmentC : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnBack  : Button = view.findViewById(R.id.btnBack)
        val btnHome  : Button = view.findViewById(R.id.btnHome)

        btnBack.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
        btnHome.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentC_to_fragmentHome)
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) = FragmentC().apply {
            arguments = Bundle().apply {
                putString("param1",param1)
                putString("param2",param2)
            }
        }
        /*fun oldInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            args.putString("","")
            fragment.arguments = args
            return fragment
        }*/
    }
}