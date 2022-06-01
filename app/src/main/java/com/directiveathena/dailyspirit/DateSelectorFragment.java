package com.directiveathena.dailyspirit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.directiveathena.dailyspirit.databinding.FragmentDateSelectorBinding;

//--------------------------------------------------------------------------------------------------
public class DateSelectorFragment extends Fragment {

    private FragmentDateSelectorBinding binding;
    GridView calender;
    TextView year;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentDateSelectorBinding.inflate(inflater, container, false);

        calender = binding.GridViewCustomCalender;


        year = binding.TextCalendarYear;



        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}