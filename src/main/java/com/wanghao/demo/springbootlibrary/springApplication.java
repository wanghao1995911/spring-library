package com.wanghao.demo.springbootlibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * className:springApplication
 * Package:com.wanghao.demo.springbootlibrary
 * Description:
 *
 * @date:2019/5/911:53
 * @author:guoxin@bjpowernode.com
 */
@SpringBootApplication
@MapperScan("com.wanghao.demo.springbootlibrary.mapper")
@ServletComponentScan


public class springApplication {
    public static void main(String[] args) {
        SpringApplication.run(springApplication.class,args);
    }
}
