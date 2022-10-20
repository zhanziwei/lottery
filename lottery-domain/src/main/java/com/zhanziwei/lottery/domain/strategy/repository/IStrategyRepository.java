package com.zhanziwei.lottery.domain.strategy.repository;

import com.zhanziwei.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.zhanziwei.lottery.infrastructure.po.Award;

import java.util.List;

/**
 * @description:
 * @author：zhanziwei
 * @date: 2022/10/16
 */
public interface IStrategyRepository {
    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAward(String awardId);

    List<String> queryNoStockAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyId 策略ID
     * @param awardId    奖品ID
     * @return           扣减结果
     */
    boolean deductStock(Long strategyId, String awardId);
}
