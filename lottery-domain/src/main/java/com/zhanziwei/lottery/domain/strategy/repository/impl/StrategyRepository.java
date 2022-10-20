package com.zhanziwei.lottery.domain.strategy.repository.impl;

import com.zhanziwei.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.zhanziwei.lottery.domain.strategy.repository.IStrategyRepository;
import com.zhanziwei.lottery.infrastructure.dao.IAwardDao;
import com.zhanziwei.lottery.infrastructure.dao.IStrategyDao;
import com.zhanziwei.lottery.infrastructure.dao.IStrategyDetailDao;
import com.zhanziwei.lottery.infrastructure.po.Award;
import com.zhanziwei.lottery.infrastructure.po.Strategy;
import com.zhanziwei.lottery.infrastructure.po.StrategyDetail;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author：zhanziwei
 * @date: 2022/10/16
 */
public class StrategyRepository implements IStrategyRepository {
    @Resource
    private IStrategyDao strategyDao;
    @Resource
    private IStrategyDetailDao strategyDetailDao;
    @Resource
    private IAwardDao awardDao;
    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAward(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }

    @Override
    public List<String> queryNoStockAwardList(Long strategyId) {
        return strategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail strategyDetail = new StrategyDetail();
        strategyDetail.setStrategyId(strategyId);
        strategyDetail.setAwardId(awardId);
        int count = strategyDetailDao.deductStock(strategyDetail);
        return count == 1;
    }
}
