package com.neo.service.impl;


import com.neo.Exception.ServiceException;
import com.neo.constant.Constant;
import com.neo.service.RedisService;
import com.neo.service.TokenService;
import com.neo.utils.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.util.Random;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisService redisService;


    /**
     * 创建token
     *
     * @return
     */
    @Override
    public String createToken() {
        String str = "mytoken";
//        String str = RandomUtil..randomUUID();
        StringBuilder token = new StringBuilder();
        try {
            token.append(Constant.Redis.TOKEN_PREFIX.getValue()).append(str);
            redisService.setEx(token.toString(), token.toString(), 10000L);
            boolean notEmpty = StrUtil.isNotEmpty(token.toString());
            if (notEmpty) {
                return token.toString();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * 检验token
     *
     * @param request
     * @return
     */
    @Override
    public boolean checkToken(HttpServletRequest request) throws Exception {

        String token = request.getHeader(Constant.FeEnum.TOKEN_NAME.getValue());
        if (StrUtil.isBlank(token)) {// header中不存在token
            token = request.getParameter(Constant.FeEnum.TOKEN_NAME.getValue());
            if (StrUtil.isBlank(token)) {// parameter中也不存在token
                throw new ServiceException (Constant.ResponseCode.ILLEGAL_ARGUMENT.getDesc(), 100);
            }
        }

        if (!redisService.exists(token)) {
            throw new ServiceException(Constant.ResponseCode.REPETITIVE_OPERATION.getDesc(), 200);
        }

        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new ServiceException (Constant.ResponseCode.REPETITIVE_OPERATION.getDesc(), 200);
        }
        return true;
    }
}
