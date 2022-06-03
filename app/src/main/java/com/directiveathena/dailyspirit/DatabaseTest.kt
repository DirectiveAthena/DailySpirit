package com.directiveathena.dailyspirit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.directiveathena.dailyspirit.databinding.FragmentDatabaseTestBinding

class DatabaseTest : Fragment() {

    private lateinit var binding: FragmentDatabaseTestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_database_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDatabaseTestBinding.bind(view)

    }
}