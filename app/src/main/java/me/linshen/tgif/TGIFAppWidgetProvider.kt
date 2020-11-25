package me.linshen.tgif

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import me.linshen.tgif.util.CalendarUtils
import java.util.*

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
                R.layout.widget_tgif_count_down
            ).apply {
                setTextViewText(
                    android.R.id.text1, context?.getString(
                        R.string.tgif_format,
                        CalendarUtils.getFriCountDown()
                    )
                )
            }
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager?.updateAppWidget(appWidgetId, views)
        }
    }

}
