package com.zhanziwei.lottery.rpc;

import com.zhanziwei.lottery.rpc.req.ActivityReq;
import com.zhanziwei.lottery.rpc.res.ActivityRes;

/**
 * @author 17150
 * 活动展台：
 * 1. 创建
 * 2. 更新
 * 3. 查询
 */
public interface IActivityBooth {
    /**
     *
     * @param req
     * @return
     */
    ActivityRes queryActivityById(ActivityReq req);
}
