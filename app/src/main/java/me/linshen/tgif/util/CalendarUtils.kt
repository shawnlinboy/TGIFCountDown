package me.linshen.tgif.util

import me.linshen.tgif.TGIFAppWidgetProvider
import java.util.*

object CalendarUtils {

    private const val FRI_DAY_OF_WEEK = 6

    fun getFriCountDown(): Int {
        val today = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
        return when {
            today == FRI_DAY_OF_WEEK -> {
                0
            }
            today < FRI_DAY_OF_WEEK -> {
                FRI_DAY_OF_WEEK - today
            }
            else -> {
                FRI_DAY_OF_WEEK
            }
        }
    }

}