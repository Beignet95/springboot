package com.beignet.springboot.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyRealm extends AuthorizingRealm{

    Map<String,String> userMap = new HashMap(16);
    {
        userMap.put("liuyifei","123456");
        super.setName("myRealm");
    }
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        String pwd = getPWDByUserName(userName);
        if(pwd==null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("liuyifei",pwd,"myRealm");
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String)principals.getPrimaryPrincipal();
        Set<String> promissions = getPromisstionByUserName(userName);
        Set<String> roles = getRoleByUserName(userName);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(promissions);
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }

    public Set<String> getPromisstionByUserName(String userName){
        HashSet<String> promissions = new HashSet<String>();
        promissions.add("user:add");
        promissions.add("user:delete");
        return promissions;
    }

    public Set<String> getRoleByUserName(String userName){
        HashSet<String> roles = new HashSet<String>();
        roles.add("admin");
        roles.add("user");
        return roles;
    }
    public String getPWDByUserName(String uaserName){
        return "123456";
    }
}
