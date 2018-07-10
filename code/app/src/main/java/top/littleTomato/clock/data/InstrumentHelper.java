package top.littleTomato.clock.data;

import android.content.Context;
import android.content.Intent;

import top.littleTomato.clock.constant.Constants;
import top.littleTomato.clock.entities.TaskDetailEntity;
import top.littleTomato.clock.views.NewActivity;

public class InstrumentHelper {

    private InstrumentHelper() {
    }

    public static Intent toEditActivity(Context context, int position, TaskDetailEntity entity) {
        Intent intent = new Intent(context, NewActivity.class);
        intent.putExtra(Constants.INTENT_EXTRA_EDIT_TASK_DETAIL_ENTITY, entity.cloneObj());
        intent.putExtra(Constants.INTENT_EXTRA_MODE_OF_NEW_ACT, Constants.MODE_OF_NEW_ACT.MODE_EDIT);
        return intent;
    }

}
