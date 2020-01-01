package com.gsm.project.bwcar.realm;

import com.gsm.project.bwcar.pojo.SysUser;
import com.gsm.project.bwcar.service.SysMenuService;
import com.gsm.project.bwcar.service.SysRoleService;
import com.gsm.project.bwcar.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到用户名和密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());
        SysUser byUsername = sysUserService.findUserByUsername(username);
        if (byUsername == null){
            throw new UnknownAccountException("用户名不存在");
        }
        if (!byUsername.getPassword().equals(password)){
            throw new IncorrectCredentialsException("密码不正确");
        }
        if (byUsername.getStatus() == 0){
            throw new LockedAccountException("账户被冻结");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(byUsername,password,this.getName());
        return info;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser = (SysUser)principalCollection.getPrimaryPrincipal();
        Long userId = sysUser.getUserId();
        //用户的角色
        List<String> roleByUserId = sysRoleService.findRoleNameByUserId(userId);
        //用户菜单权限
        List<String> perms = sysMenuService.findPermsByUserId(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleByUserId);
        info.addStringPermissions(perms);
        return info;
    }


}
