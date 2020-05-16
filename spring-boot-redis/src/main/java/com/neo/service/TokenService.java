package com.neo.service;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    /**
     * 创建token
     * @return
     */
    public  String createToken();

    /**
     * 检验token
     * @param request
     * @return
     *
     * 检验token的话主要是传达request对象，为什么要传request对象呢？
     * 主要作用就是获取header里面的token,然后检验，通过抛出的Exception来获取具体的报错信息返回给前端
     */
    public boolean checkToken(HttpServletRequest request) throws Exception;


}
