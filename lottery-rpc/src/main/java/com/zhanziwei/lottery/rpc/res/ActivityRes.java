package com.zhanziwei.lottery.rpc.res;

import com.zhanziwei.lottery.common.Result;
import com.zhanziwei.lottery.rpc.dto.ActivityDto;

/**
 * @author 17150
 */
public class ActivityRes {
    private Result result;
    private ActivityDto activityDto;

    public ActivityRes() {
    }

    public ActivityRes(Result result) {
        this.result = result;
    }

    public ActivityRes(Result result, ActivityDto activityDto) {
        this.result = result;
        this.activityDto = activityDto;
    }
}
