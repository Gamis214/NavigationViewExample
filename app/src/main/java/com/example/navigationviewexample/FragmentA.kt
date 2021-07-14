package com.example.navigationviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs


class FragmentA : Fragment() {

    val args: FragmentAArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val txtValue : TextView = view.findViewById(R.id.txtValue)
        val btnBack  : Button = view.findViewById(R.id.btnBack)
        txtValue.text = args.valueFromHome
        btnBack.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) = FragmentA().apply {
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