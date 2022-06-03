package com.directiveathena.dailyspirit

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.directiveathena.dailyspirit.databinding.FragmentCalendarBinding
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import java.time.LocalDate
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

class Calendar : Fragment() {

    private lateinit var binding: FragmentCalendarBinding
    private val today = LocalDate.now()

    private var selectedDate: LocalDate? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCalendarBinding.bind(view)

        // Logic behind every day container
        class DayViewContainer(view: View) : ViewContainer(view) {

            lateinit var day: CalendarDay
            val textView = view.findViewById<TextView>(R.id.calendarDay)

            init {
                view.setOnClickListener{
                    if (day.owner == DayOwner.THIS_MONTH) {
                        val currentSelection = selectedDate
                        if (currentSelection == day.date) {
                            selectedDate = null
                            textView.setTextColor(Color.WHITE)
                        } else {
                            selectedDate = day.date
                            textView.setTextColor(Color.CYAN)

                        }
                    }
                }
            }
        }

        // Create the calendar binder and logic
        binding.calendarView.dayBinder = object : DayBinder<DayViewContainer> {
            // Called only when a new container is needed.
            override fun create(view: View) = DayViewContainer(view)

            // Called every time we need to reuse a container.
            override fun bind(container: DayViewContainer, day: CalendarDay) {

                container.day = day
                val textView = container.textView
                textView.text = day.date.dayOfMonth.toString()

                // Grey out the days that aren't part of the current month
                when {
                    today == day.date -> {
                        textView.setTextColor(Color.RED)
                    }
                    day.owner == DayOwner.THIS_MONTH -> {
                        textView.setTextColor(Color.WHITE)
                    }
                    else -> {
                        textView.setTextColor(Color.GRAY)
                    }
                }
            }
        }

        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)
        val lastMonth = currentMonth.plusMonths(10)
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek

        binding.calendarView.setup(firstMonth, lastMonth, firstDayOfWeek)
        binding.calendarView.scrollToMonth(currentMonth)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Calendar().apply {
                arguments = Bundle().apply {
                }
            }
    }
}