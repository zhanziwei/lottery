package com.zhanziwei.lottery.interfaces;

import com.zhanziwei.lottery.common.Constants;
import com.zhanziwei.lottery.common.Result;
import com.zhanziwei.lottery.infrastructure.dao.IActivityDao;
import com.zhanziwei.lottery.infrastructure.po.Activity;
import com.zhanziwei.lottery.rpc.IActivityBooth;
import com.zhanziwei.lottery.rpc.dto.ActivityDto;
import com.zhanziwei.lottery.rpc.req.ActivityReq;
import com.zhanziwei.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author 17150
 * <p>
 *     活动展台
 * </p>
 */
@Service
public class ActivityBooth implements IActivityBooth {
    @Resource
    private IActivityDao activityDao;
    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo()), activityDto);

    }
}
