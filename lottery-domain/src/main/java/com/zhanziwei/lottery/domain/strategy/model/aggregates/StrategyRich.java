package com.zhanziwei.lottery.domain.strategy.model.aggregates;

import com.zhanziwei.lottery.infrastructure.po.Strategy;
import com.zhanziwei.lottery.infrastructure.po.StrategyDetail;

import java.util.List;

/**
 * @description:
 * @author：zhanziwei
 * @date: 2022/10/16
 */
public class StrategyRich {
    private Long strategyId;
    private Strategy strategy;
    private List<StrategyDetail> strategyDetailList;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetail> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetail> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }
}
