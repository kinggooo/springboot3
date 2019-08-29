package com.wangnz.springboot.hello.mapper;


import com.wangnz.springboot.hello.entity.LoanApplyInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface LoanApplyInfoMapper {
    int deleteByPrimaryKey(String applyNo);

    int insert(LoanApplyInfo record);

    int insertSelective(LoanApplyInfo record);

    LoanApplyInfo selectByPrimaryKey(String applyNo);

    List<LoanApplyInfo> selectByCond(@Param("batchStartDate") Date batchStartDate,
                                     @Param("batchEndDate") Date batchEndDate);

    int updateByPrimaryKeySelective(LoanApplyInfo record);

    int updateByPrimaryKey(LoanApplyInfo record);
}