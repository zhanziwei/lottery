package com.zhanziwei.lottery.domain.strategy.service.draw;

import com.zhanziwei.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.zhanziwei.lottery.domain.strategy.repository.IStrategyRepository;
import com.zhanziwei.lottery.infrastructure.po.Award;

import javax.annotation.Resource;

/**
 * @description:
 * @author：zhanziwei
 * @date: 2022/10/16
 */
public class DrawStrategySupport extends DrawConfig {
    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     *
     * @param strategyId 策略ID
     * @return 策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId){
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详情信息
     *
     * @param awardId 奖品ID
     * @return 中奖详情
     */
    protected Award queryAwardInfoByAwardId(String awardId){
        return strategyRepository.queryAward(awardId);
    }
}
