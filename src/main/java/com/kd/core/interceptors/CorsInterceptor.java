package com.kd.core.interceptors;

import com.kd.core.util.PropertiesUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: latham
 * @Date: 2019/12/28 17:43
 **/
//@Configuration
public class CorsInterceptor extends HandlerInterceptorAdapter {

    private final String corsOrigins = PropertiesUtil.readValue("service.corsOrigin");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String origin = request.getHeader("Origin");

        if (StringUtils.isNotBlank(origin)) {
            //String haeaders = request.getHeader("Access-Control-Allow-Headers");

            //response.setHeader("Access-Control-Allow-Headers", haeaders);
//            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With,cache-control, Content-Type, Accept, XFILENAME, XFILECATEGORY, XFILESIZE, " +
//                    "WG-App-Version, WG-Device-Id, WG-Network-Type, WG-Vendor, WG-OS-Type, WG-OS-Version, WG-Device-Model, WG-CPU, WG-Sid, WG-App-Id, WG-Token");
            response.setHeader("AAccess-Control-Allow-Headers", "Origin, Content-Type, cache-control,postman-token,Cookie, Accept,Access-Token");
            response.setHeader("Access-Control-Allow-Origin", corsOrigins);
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.setHeader("Access-Control-Allow-Credentials", "true");

            if (request.getMethod().equals("OPTIONS")) {
                response.setStatus(HttpStatus.OK.value());
            }
        }
        /**设备默认值**/
        response.setContentType("application/json;charset=UTF-8");

        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
