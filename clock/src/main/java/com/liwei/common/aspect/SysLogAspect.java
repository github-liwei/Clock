package com.liwei.common.aspect;

import com.google.gson.Gson;
import com.liwei.common.annotation.SysLog;
import com.liwei.common.exception.RRException;
import com.liwei.common.utils.HttpContextUtils;
import com.liwei.common.utils.IPUtils;
import com.liwei.modules.app.controller.ApiLoginController;
import com.liwei.modules.app.controller.ApiMusicController;
import com.liwei.modules.app.entity.AppUserEntity;
import com.liwei.modules.app.interceptor.AuthorizationInterceptor;
import com.liwei.modules.app.service.impl.UserServiceImpl;
import com.liwei.modules.sys.entity.SysLogEntity;
import com.liwei.modules.sys.entity.SysUserEntity;
import com.liwei.modules.sys.service.SysLogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;


/**
 * 系统日志，切面处理类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017年3月8日 上午11:07:35
 */
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private UserServiceImpl userService;

    @Pointcut("@annotation(com.liwei.common.annotation.SysLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveSysLog(point, time);

        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLogEntity sysLog = new SysLogEntity();
        SysLog syslog = method.getAnnotation(SysLog.class);
        if (syslog != null) {
            //注解上的描述
            sysLog.setOperation(syslog.value());
        }

        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");

        //请求的参数（包含了web中的参数head......）
        Object[] args = joinPoint.getArgs();
        try {
            String params = new Gson().toJson(args[0]);
            sysLog.setParams(params);
        } catch (Exception e) {

        }

        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));

        String _username;
        if (SecurityUtils.getSubject().getPrincipal() != null) {
            _username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUsername();

        } else {
            String _packageName = new ApiLoginController().getClass().getPackage().getName();
            String _packageName2 = new ApiMusicController().getClass().getPackage().getName();
            if ((className.indexOf(_packageName) != -1) || (className.indexOf(_packageName2) != -1)) {//使用在这个包名下,log实体类以后还要添加属于什么类别的日志,或者设计多张表
                //用户名****还未加入
                //获取用户ID

                Object object = request.getAttribute(AuthorizationInterceptor.USER_KEY);
                if (object != null) {
                    AppUserEntity _user = userService.selectByPrimaryKey((Long) object);
                    _username = _user.getUsername();
                } else {
                    throw new RRException("日志获取userId错误");
                }
            } else {
                throw new RRException("没有找到此包将不保存日志");
            }
        }
        //用户名
        sysLog.setUsername(_username);

        sysLog.setTime(time);
        sysLog.setCreateDate(new Date());
        //保存系统日志
        sysLogService.insert(sysLog);
    }
}
