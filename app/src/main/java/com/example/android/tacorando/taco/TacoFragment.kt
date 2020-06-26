package com.example.android.tacorando.taco

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.tacorando.R

class TacoFragment : Fragment() {

    companion object {
        fun newInstance() = TacoFragment()
    }

    private lateinit var viewModel: TacoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.taco_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TacoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}