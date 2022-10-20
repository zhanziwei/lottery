package com.zhanziwei.lottery.domain.strategy.service.draw;

import com.zhanziwei.lottery.common.Constants;
import com.zhanziwei.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import com.zhanziwei.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * @description:
 * @author：zhanziwei
 * @date: 2022/10/16
 */
public class DrawConfig {
    @Resource
    private BaseAlgorithm overallRateRandomDrawAlgorithm;
    @Resource
    private BaseAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, BaseAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        drawAlgorithmMap.put(Constants.StrategyMode.ENTIRETY.getCode(), overallRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(Constants.StrategyMode.SINGLE.getCode(), singleRateRandomDrawAlgorithm);
    }
}
