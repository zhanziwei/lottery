package com.zhanziwei.lottery.infrastructure.dao;

import com.zhanziwei.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author：zhanziwei
 * @date: 2022/10/16
 */
@Mapper
public interface IAwardDao {
    Award queryAwardInfo(String awardId);
}
