package top.littleTomato.clock.receiver;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

import top.littleTomato.clock.R;
import top.littleTomato.clock.constant.Constants;
import top.littleTomato.clock.views.NewActivity;

public class WidgetProvider extends AppWidgetProvider {

    private static final String TAG = "WidgetProvider";

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int id : appWidgetIds) {
            Intent intent = new Intent(context, NewActivity.class);
            intent.putExtra(Constants.INTENT_EXTRA_MODE_OF_NEW_ACT, Constants.MODE_OF_NEW_ACT.MODE_QUICK);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            String packageName = context.getPackageName();
            RemoteViews rv = new RemoteViews(packageName, R.layout.widget_new_task);
            rv.setOnClickPendingIntent(R.id.ll_widget, pendingIntent);

            appWidgetManager.updateAppWidget(id, rv);

        }

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }


    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.d(TAG, "onEnabled: ");
    }
}
