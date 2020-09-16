package com.beignet.springboot;

import com.beignet.springboot.shiro.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class AuthenticationTest {
    static SimpleAccountRealm accountRealm = new SimpleAccountRealm();
    @BeforeAll
    public static  void addUser(){
        accountRealm.addAccount("liuyifei","123456");
    }
    @Test
    public void testLogin(){
        //构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(accountRealm);
        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("liuyifei","123456");
        subject.login(token);
        if(subject.isAuthenticated()){

            System.out.println("登录成功，恭喜您！刘亦菲");
        }else{
            subject.logout();
            System.out.println("账号或密码错误！请确认！");
        }


    }
    @Test
    public void testLoginByMyRealm(){
        MyRealm myRealm = new MyRealm();
        //构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm);
        //主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("liuyifei","123456");
        subject.login(token);
        if(subject.isAuthenticated()){

            System.out.println("登录成功，恭喜您！刘亦菲");
        }else{
            subject.logout();
            System.out.println("账号或密码错误！请确认！");
        }


    }
}
