package com.zhanziwei.lottery.domain.strategy.service.algorithm.impl;

import com.zhanziwei.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * @author 17150
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm{
    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        String[] rateTuple = rateTupleMap.get(strategyId);
        int random = new SecureRandom().nextInt(100) + 1;
        String awardId = rateTuple[hashIdx(random)];
        if(excludeAwardIds.contains(awardId)) {
            return "未中奖";
        }
        return awardId;
    }
}
