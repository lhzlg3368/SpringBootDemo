package com.jesse.spring.service;

import com.jesse.spring.entity.CopyEntity;

import java.util.List;

public interface CopyService {

    /**
     * 添加拷贝的信息
     *
     * @param copyEntity
     * @return 验证码
     */
    String add(CopyEntity copyEntity);

    /**
     * 根据验证码获取拷贝的类容
     *
     * @param verificationCode
     * @return
     */
    CopyEntity queryByVerificationCode(String verificationCode);

    /**
     * 查询所有的验证码
     *
     * @return
     */
    List<String> queryAllVerificationCode();

    String generatingUniqueValidVerificationCode();
}
