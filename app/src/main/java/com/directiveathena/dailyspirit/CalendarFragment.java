package com.directiveathena.dailyspirit;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.directiveathena.dailyspirit.databinding.FragmentCalendarBinding;

import java.util.Calendar;

//--------------------------------------------------------------------------------------------------
public class CalendarFragment extends Fragment {

    private FragmentCalendarBinding binding;
    GridView calender;
    TextView year;

    int[] moodarray = new int[]{
            R.drawable.mood_excellent,
            R.drawable.mood_excellent,
            R.drawable.mood_excellent,
            R.drawable.mood_excellent,
            R.drawable.mood_excellent,
            R.drawable.mood_excellent,
            R.drawable.mood_excellent,
            R.drawable.mood_excellent,
            R.drawable.mood_excellent,
            R.drawable.mood_excellent,
    };

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        calender = binding.GridViewCustomCalender;
        year = binding.TextCalendarYear;

        GridView grid = binding.GridViewCustomCalender;
        CalendarAdapter calendarAdapter = new CalendarAdapter(requireContext(), moodarray);
        grid.setAdapter(calendarAdapter);

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