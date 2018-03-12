package by.itacademy.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyLogger {

    private final Logger log = Logger.getLogger(MyLogger.class);

    @Pointcut("@annotation(LoggerMethod)")
    public void loggerMethod() {}

    @AfterReturning("loggerMethod()")
    public void singAfterSuccess(JoinPoint joinPoint) {
        log.info(joinPoint.toLongString());
        System.out.println("Log4j from service");
    }

    @AfterThrowing(pointcut = "loggerMethod()", throwing = "error")
    public void singAfterFail(JoinPoint joinPoint, Throwable error) throws Throwable  {
//        log.warn(joinPoint.toLongString());
        log.error(joinPoint.toLongString() + error);
//        log.fatal(joinPoint.toLongString() + error);
        System.out.println("Log4j from service ERROR");
    }

//    @Around("loggerMethod()")
//    public Object singAboutTheFight(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Around " + joinPoint.getArgs()[0] + " starts!");
//        Object result = joinPoint.proceed();
//        System.out.println("Around ended!");
//        return result;
//    }
}
