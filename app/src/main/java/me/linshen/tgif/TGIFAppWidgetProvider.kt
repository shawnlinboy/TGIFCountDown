package me.linshen.tgif

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import me.linshen.tgif.util.CalendarUtils

class TGIFAppWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        appWidgetIds?.forEach { appWidgetId ->
            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            val views: RemoteViews = RemoteViews(
                context?.packageName,
                R.layout.widget_tgif_count_down_dark
            ).apply {
                val daysLeft = CalendarUtils.getFriCountDown()
                if (daysLeft > 0) {
                    //还没到星期五
                    setTextViewText(android.R.id.text1, context?.getString(R.string.not_friday))
                    setTextViewText(android.R.id.text2, context?.getString(
                        R.string.tgif_left_day_format, daysLeft))
                }
            }
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager?.updateAppWidget(appWidgetId, views)
        }
    }

}
