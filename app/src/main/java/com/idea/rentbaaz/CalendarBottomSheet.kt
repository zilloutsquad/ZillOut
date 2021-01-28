package com.idea.rentbaaz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.lang.reflect.Array.get
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalendarBottomSheet.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalendarBottomSheet : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar_bottomsheet, container, false)
    }

    override fun onResume() {
        super.onResume()
        val calendarView = view?.rootView?.findViewById(R.id.calendarView) as CalendarView
        calendarView.minDate = System.currentTimeMillis() - 1000
        val confirmCta = view?.rootView?.findViewById(R.id.confirm) as TextView
        confirmCta.setOnClickListener {
            dismiss()
        }
    }
    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTheme
    }

    fun confirm(view: View) {
        dismiss()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String, fragmentManager: FragmentManager) =
            CalendarBottomSheet().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }.show(fragmentManager, null)
    }
}