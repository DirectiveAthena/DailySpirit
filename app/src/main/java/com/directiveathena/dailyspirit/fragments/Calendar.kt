// -------------------------------------------------------------------------------------------------
// - Imports -
// -------------------------------------------------------------------------------------------------
package com.directiveathena.dailyspirit.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.directiveathena.dailyspirit.MainActivity
import com.directiveathena.dailyspirit.R
import com.directiveathena.dailyspirit.db.content.Day
import com.directiveathena.dailyspirit.databinding.FragmentCalendarBinding
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

// -------------------------------------------------------------------------------------------------
// - Code -
// -------------------------------------------------------------------------------------------------
class Calendar : Fragment() {
    // ---------------------------------------------------------------------------------------------
    // - Class Variable definition -
    // ---------------------------------------------------------------------------------------------
    private lateinit var binding: FragmentCalendarBinding
    private val today = LocalDate.now()

    private var selectedDate: LocalDate? = null

    // ---------------------------------------------------------------------------------------------
    // - OnCreateView -
    // ---------------------------------------------------------------------------------------------
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    // ---------------------------------------------------------------------------------------------
    // - OnViewCreated -
    // ---------------------------------------------------------------------------------------------
    private fun onViewCreatedCalendar() {
        // -----------------------------------------------------------------------------------------
        // Logic behind every day container
        // -----------------------------------------------------------------------------------------
        class DayViewContainer(view: View) : ViewContainer(view) {

            lateinit var day: CalendarDay
            val textView = view.findViewById<TextView>(R.id.calendarDay)
            val imgMood =  view.findViewById<ImageView>(R.id.imgMood)
            val imgOther =  view.findViewById<ImageView>(R.id.imgOther)

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

        // -----------------------------------------------------------------------------------------
        // Create the calendar binder and logic
        // -----------------------------------------------------------------------------------------
        binding.calendarView.dayBinder = object : DayBinder<DayViewContainer> {
            // Called only when a new container is needed.
            override fun create(view: View) = DayViewContainer(view)

            // Called every time we need to reuse a container.
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.day = day
                val textView:TextView = container.textView
                val imgMood:ImageView = container.imgMood
                val imgOther:ImageView = container.imgOther
                textView.text = day.date.dayOfMonth.toString()
                imgMood.setImageResource(R.drawable.ic_launcher_background)
                imgOther.setImageResource(R.drawable.ic_launcher_foreground)

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

        // -----------------------------------------------------------------------------------------
        // Month scroll
        // -----------------------------------------------------------------------------------------
        binding.calendarView.monthScrollListener = {
            // handles the setting of the calender text in all cases
            binding.txtYear.text = it.yearMonth.year.toString()
            binding.txtMonth.text = it.yearMonth.month.toString()
        }

        // -----------------------------------------------------------------------------------------
        // Further makeup of the layout
        // -----------------------------------------------------------------------------------------
        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)
        val lastMonth = currentMonth.plusMonths(10)
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        binding.calendarView.setup(firstMonth, lastMonth, firstDayOfWeek)
        binding.calendarView.scrollToMonth(currentMonth)
    }

    fun onViewCreatedUtility() {
        // utility to jump to today
        val btnToday: Button = binding.btnToday
        btnToday.setOnClickListener {
            binding.calendarView.smoothScrollToDate(today)
        }

        // TODO ------------------------------------------------------------------------------------
        // TODO REMOVE THIS HERE AND ADD A FUNCTIONING MENU FOR THIS!
        // TODO ------------------------------------------------------------------------------------
        // test the database database
        val btnValueSet: Button = binding.dbTest.btnValueSet
        val btnValueGet: Button = binding.dbTest.btnValueGet
        val txtOutput: TextView = binding.dbTest.txtOutput

        val dbDao = (activity as MainActivity).db.dbDao()

        var counter = 0

        btnValueSet.setOnClickListener {

            android.util.Log.d("DEBUG", (activity as MainActivity).db.isOpen.toString())

            lifecycleScope.launch() {
                dbDao.insertDays(
                    Day(
                        counter,
                        date=Date(),
                        mood=4,
                        null,
                        null,
                        null
                    )
                )
            }
            counter += 1
        }
        btnValueGet.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val result = dbDao.getAll().toString()
                withContext(Dispatchers.Main) {
                    txtOutput.text = result
                }
            }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCalendarBinding.bind(view)

        // handle the creation of the Calendar
        onViewCreatedCalendar()

        // handle the logic behind the utility options
        onViewCreatedUtility()
    }
}