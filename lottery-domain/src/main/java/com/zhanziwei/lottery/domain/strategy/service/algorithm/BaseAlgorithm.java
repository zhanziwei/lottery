package com.zhanziwei.lottery.domain.strategy.service.algorithm;

import com.zhanziwei.lottery.domain.strategy.model.vo.AwardRateInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 17150
 */
public abstract class BaseAlgorithm implements IDrawAlgorithm {
    /**
     * 斐波那契散列增量，逻辑：黄金分割点：(√5 - 1) / 2 = 0.6180339887，Math.pow(2, 32) * 0.6180339887 = 0x61c88647
     */
    private final int HASH_INCREMENT = 0x61c88647;
    /**
     * 数组初始化长度
     */
    private final int RATE_TUPLE_LENGTH = 128;
    /**
     * 存放概率与奖品对应的散列结果，strategyId -> rateTuple
     */
    protected Map<Long, String[]> rateTupleMap = new ConcurrentHashMap<>();
    /**
     * 奖品区间概率值，strategyId -> [awardId->begin、awardId->end]
     */
    protected Map<Long, List<AwardRateInfo>> awardRateInfoMap = new ConcurrentHashMap<>();

    public void initRateTuple(Long strategyId, List<AwardRateInfo> awardRateInfos) {
        awardRateInfoMap.put(strategyId, awardRateInfos);
        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, key -> new String[RATE_TUPLE_LENGTH]);
        rateTupleMap.put(strategyId, rateTuple);
        int cursorVal = 0;
        for(AwardRateInfo awardRateInfo:awardRateInfos) {
            int rateVal = awardRateInfo.getAwardRate().multiply(new BigDecimal(100)).intValue();
            for(int i = cursorVal + 1; i <= rateVal+cursorVal; i++) {
                rateTuple[hashIdx(i)] = awardRateInfo.getAwardId();
            }
            cursorVal += rateVal;
        }
    }

    public boolean isExistRateTuple(Long strategyId) {
        return rateTupleMap.containsKey(strategyId);
    }
    protected int hashIdx(int val) {
        int hashCode = val * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGTH - 1);
    }
}
