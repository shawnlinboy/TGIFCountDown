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
                AppWidgetManager.getInstance(context).updateAppWidget(cm, RemoteViewsProvider.getDarkRemoteViews(ctx))
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
            appWidgetManager?.updateAppWidget(appWidgetId, RemoteViewsProvider.getDarkRemoteViews(context))
        }
    }

}
