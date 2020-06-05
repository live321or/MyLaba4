package com.samoylov.lab4;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.RemoteViews;

public class MalibuCountDownTimer extends CountDownTimer {
    Context context;
    AppWidgetManager appWidgetManager;
    public MalibuCountDownTimer(long startTime, long interval, Context context, AppWidgetManager appWidgetManager) {
        super(startTime, interval);
        this.context = context;
        this.appWidgetManager = appWidgetManager;
    }

    @Override
    public void onFinish() {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.widget);
        remoteViews.setTextViewText(R.id.date_str, "дата не установлена");
        ComponentName appWidget = new ComponentName(context, Widget.class);
        appWidgetManager.updateAppWidget(appWidget, remoteViews);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
                R.layout.widget);
        long res = millisUntilFinished / Widget.MDAY;
        if (millisUntilFinished > Widget.MDAY) {
            remoteViews.setTextViewText(R.id.days_num, Long.toString(res));
        } else {
            remoteViews.setTextViewText(R.id.days_num, "0");
        }
        ComponentName appWidget = new ComponentName(context, Widget.class);
        appWidgetManager.updateAppWidget(appWidget, remoteViews);

    }
}

