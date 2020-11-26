package me.linshen.tgif

import android.content.Context
import android.widget.RemoteViews
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.target.AppWidgetTarget
import me.linshen.tgif.util.CalendarUtils

object RemoteViewsProvider {

    fun getDarkRemoteViews(context: Context?): RemoteViews = RemoteViews(
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

    fun getColorfulRemoteViews(context: Context?, appWidgetId: Int): RemoteViews = RemoteViews(
        context?.packageName,
        R.layout.widget_tgif_count_down_colorful
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
            /*context?.let {ctx ->
                ctx
                val target = AppWidgetTarget(ctx, android.R.id.background, this, appWidgetId)
                Glide.with(ctx).asBitmap().load(R.drawable.widget_bg_colorful)
                    .transform(RoundedCorners(20))
                    .into(target)
            }*/
        }
    }

}