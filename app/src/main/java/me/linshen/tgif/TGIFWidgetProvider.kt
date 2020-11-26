package me.linshen.tgif

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Log
import android.widget.RemoteViews
import me.linshen.tgif.util.CalendarUtils

class TGIFWidgetProvider : AppWidgetProvider() {

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        val action = intent?.action
        if (TextUtils.equals(action, Intent.ACTION_DATE_CHANGED)
            || TextUtils.equals(action, Intent.ACTION_TIME_CHANGED)
        ) {
            Log.e("@@@", "onReceive, action = $action")
            context?.let { ctx ->
                val cm = ComponentName(ctx, TGIFWidgetProvider::class.java)
                AppWidgetManager.getInstance(context).updateAppWidget(cm, generateRemoteViews(ctx))
            }
        }
    }

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        Log.e("@@@", "TGIFWidgetProvider onUpdate")
        appWidgetIds?.forEach { appWidgetId ->
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager?.updateAppWidget(appWidgetId, generateRemoteViews(context))
        }
    }

    private fun generateRemoteViews(context: Context?): RemoteViews = RemoteViews(
        context?.packageName,
        R.layout.widget_tgif_count_down_dark
    ).apply {
        val daysLeft = CalendarUtils.getFriCountDown()
        if (daysLeft > 0) {
            //还没到星期五
            setTextViewText(android.R.id.text1, context?.getString(R.string.not_friday))
            setTextViewText(
                android.R.id.text2, context?.getString(
                    R.string.tgif_left_day_format, daysLeft
                )
            )
        }
    }


}
