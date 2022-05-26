package com.example.baseandroidmodulekevcordova.utils

import java.lang.NullPointerException
import java.text.SimpleDateFormat
import java.util.*

object KCalendarUtils {
    const val PATTERN_DATE_COMPLETE_WITH_HOUR = "yyyy-MM-dd HH:mm:ss"
    const val PATTERN_DATE_COMPLETE_YEAR_START = "yyyy-MM-dd"
    const val PATTERN_DATE_COMPLETE_DAY_START = "dd-MM-yyyy"
    const val PATTERN_DATE_COMPLETE_MONTH_START = "MM-dd-yyyy"
    const val PATTERN_DATE_COMPLETE_TWO_DIGITS = "dd-MM-yy"
    const val PATTERN_DATE_YEAR_COMPLETE = "YYYY"
    const val PATTERN_DATE_MONTH = "MM"
    const val PATTERN_DATE_DAY = "dd"
    const val PATTERN_DATE_MONTH_NAME = "MMMM"
    const val PATTERN_DATE_DAY_NAME = "EEEE"
    const val DIVIDER_DATE_ORIGINAL = "-"
    const val DIVIDER_TIME_ORIGINAL = ":"

    /**
     * Format calendar in String with YEAR-MONTH-DAY HOUR:MINUTE:SECONDS
     *
     * @param calendar is Calendar to transform in String format
     * @return date formatted in String
     */
    fun formatDateWithPattern(
        calendar: Calendar,
        patternFormat: String = PATTERN_DATE_COMPLETE_WITH_HOUR,
        locale: Locale = Locale.getDefault()
    ): String {
        val dateFormat = SimpleDateFormat(patternFormat, locale)
        return dateFormat.format(calendar.time)
    }

    /**
     * Replace string divider by other string character
     *
     * @param dateString is a date string
     * @param dividerDate is the divider for date
     * @param dividerTime is the divider for time
     *
     * @return date replace your divider
     */
    fun replaceDateStringDividers(dateString: String?, dividerDate: String = DIVIDER_DATE_ORIGINAL, dividerTime: String = DIVIDER_TIME_ORIGINAL): String {
        return dateString?.run {
            replace(DIVIDER_DATE_ORIGINAL, dividerDate).replace(DIVIDER_TIME_ORIGINAL, dividerTime)
        } ?: throw NullPointerException("Date String is null")
    }
}