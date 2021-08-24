package com.codegym.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    @AfterThrowing(value = "execution(* com.codegym.controller.BookController.oder(..))")
    public void check() {
        System.out.println("---------------");
        System.out.println("-------Error--------");
    }
    @After(value = "execution(* com.codegym.controller.BookController.oder(..))")
    public void done() {
        System.out.println("---------------");
        System.out.println("-------Done--------");
    }
}
