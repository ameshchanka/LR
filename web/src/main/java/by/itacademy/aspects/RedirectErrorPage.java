package by.itacademy.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Aspect
public class RedirectErrorPage {

    private final Logger log = Logger.getLogger(RedirectErrorPage.class);

    @Pointcut("@annotation(by.itacademy.aspects.ErrorCatcher) && execution(String by.itacademy.controllers.*.*(..))")
    public void redirectOnErrorPage() {
    }


    @Around("redirectOnErrorPage()")
    public Object catchError(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object result = joinPoint.proceed();
            log.info(joinPoint.toShortString());
            return result;
        } catch (Throwable t) {
            log.error(t.toString());
            RedirectAttributes redirectAttributes = (RedirectAttributes)joinPoint.getArgs()[0];
            if(redirectAttributes != null) {
                redirectAttributes.addFlashAttribute("error", t.toString());
            }
            return "redirect:/error";
        }
    }
}
