package com.example.navigationviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment


class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnA : Button = view.findViewById(R.id.btnA)
        val btnB : Button = view.findViewById(R.id.btnB)
        val edt  : EditText = view.findViewById(R.id.edt)

        btnA.setOnClickListener { view ->
            val directions = HomeFragmentDirections.actionFragmentHomeToFragmentA().apply {
                valueFromHome = edt.text.toString()
            }
            Navigation.findNavController(view).navigate(directions)
        }
        btnB.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentB)
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) = HomeFragment().apply {
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