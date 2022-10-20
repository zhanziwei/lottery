package com.zhanziwei.lottery.domain.strategy.service.draw;

import com.zhanziwei.lottery.domain.strategy.model.req.DrawReq;
import com.zhanziwei.lottery.domain.strategy.model.res.DrawRes;

/**
 * @description:
 * @author：zhanziwei
 * @date: 2022/10/16
 */
public interface IDrawExec {
    /**
     * 抽奖方法
     * @param req 抽奖参数；用户ID、策略ID
     * @return    中奖结果
     */
    DrawRes doDrawExec(DrawReq req);
}
