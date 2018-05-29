package com.jesse.spring.service.impl;

import com.jesse.spring.entity.CopyEntity;
import com.jesse.spring.mapper.CopyEntityMapper;
import com.jesse.spring.service.CopyService;
import com.jesse.spring.util.VerificationCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyServiceImpl implements CopyService {

    @Autowired
    private CopyEntityMapper copyEntityMapper;

    @Override
    public String add(CopyEntity copyEntity) {
        try {
            if (copyEntity == null) {
                throw new RuntimeException("添加的信息不能为空");
            }
            String verificationCode = generatingUniqueValidVerificationCode();
            copyEntity.setCopyVerificationCode(verificationCode);
            int insert = copyEntityMapper.insert(copyEntity);
            if (insert != 0) {
                return verificationCode;
            } else {
                throw new RuntimeException("添加拷贝失败！");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("添加拷贝异常:" + e.getMessage());
        }
    }

    @Override
    public CopyEntity queryByVerificationCode(String verificationCode) {
        return null;
    }

    @Override
    public List<String> queryAllVerificationCode() {
        try {
            List<String> copyEntities = copyEntityMapper.queryAllVerificationCode();
            if (copyEntities == null) {
                throw new RuntimeException("verification error");
            } else {
                return copyEntities;
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("verification query error:" + e.getMessage());
        }
    }

    @Override
    public String generatingUniqueValidVerificationCode() {
        try {
            List<String> strings = queryAllVerificationCode();
            String verification = verification(strings);
            return verification;
        } catch (Exception e) {
            throw new RuntimeException("生成验证码错误:" + e.getMessage());
        }
    }

    private String verification(List<String> verificationCodes) {
        String verificationCode = VerificationCodeUtils.createVerificationCode();
        for (String code : verificationCodes) {
            if (code.equals(verificationCode)) {
                return verification(verificationCodes);
            }
        }
        return verificationCode;
    }

}
