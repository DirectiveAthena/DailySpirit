package com.directiveathena.dailyspirit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.directiveathena.dailyspirit.databinding.FragmentMoodInputBinding;

import java.util.Hashtable;

public class MoodInputFragment extends Fragment {

    private FragmentMoodInputBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentMoodInputBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//
//        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
//        //      Display the mood selection
//                text_output.setText(mood_value);
//            }
//        });

//      Store the inserted note and mood
        Button save_button = binding.BtnStoreMood;
        save_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//              Retrieve mood value
                RadioGroup radio_group = binding.IncludeFragmentMoodToggles.RdGroupMoodToggles;
                RadioButton selected_button = radio_group.findViewById(radio_group.getCheckedRadioButtonId());
                String mood_value = selected_button.getContentDescription().toString();

//              Retrieve note
                EditText note = binding.EditTextNote;
                String note_value = note.getText().toString();

//              Output the values
                String combined = mood_value + note_value;
                TextView text_output = binding.TextRdGroupOuput;
                text_output.setText(combined);

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}