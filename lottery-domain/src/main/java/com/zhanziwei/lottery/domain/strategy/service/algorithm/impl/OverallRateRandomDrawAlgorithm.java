package com.zhanziwei.lottery.domain.strategy.service.algorithm.impl;

import com.zhanziwei.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.zhanziwei.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import com.zhanziwei.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 17150
 */
public class OverallRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {
        BigDecimal denominator = BigDecimal.ZERO;
        List<AwardRateInfo> awardRateInfos = new ArrayList<>();
        List<AwardRateInfo> allAwardRateInfos = super.awardRateInfoMap.get(strategyId);
        for(AwardRateInfo awardRateInfo: allAwardRateInfos) {
            String awardId = awardRateInfo.getAwardId();
            if(excludeAwardIds.contains(awardId)) {
                continue;
            }
            awardRateInfos.add(awardRateInfo);
        }

        if(awardRateInfos.size() == 0) {
            return "";
        }
        if(awardRateInfos.size() == 1) {
            return awardRateInfos.get(0).getAwardId();
        }
        int random = new SecureRandom().nextInt(100) + 1;

        String awardId = "";
        int cursorVal = 0;

        for(AwardRateInfo awardRateInfo : awardRateInfos) {
            int rateVal = awardRateInfo.getAwardRate().divide(denominator, 2, RoundingMode.UP).multiply(new BigDecimal(100)).intValue();
            if (random <= cursorVal+rateVal) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }
        return awardId;
    }
}
