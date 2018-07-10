package top.littleTomato.clock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import top.littleTomato.clock.constant.Constants;
import top.littleTomato.clock.data.AlarmHelper;
import top.littleTomato.clock.utils.PreferenceUtils;

public class BootReceiver extends BroadcastReceiver {
    public BootReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean autoNotify = PreferenceUtils.getInstance(context).getBooleanParam(Constants.CONFIG_KEY.AUTO_NOTIFY, false);
        if (autoNotify) {
            AlarmHelper.startNotifyAlarm(context);
        }
    }
}
