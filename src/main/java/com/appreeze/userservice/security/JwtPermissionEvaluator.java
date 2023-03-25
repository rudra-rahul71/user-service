package com.appreeze.userservice.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.io.Serializable;
import java.util.List;

public class JwtPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if (authentication instanceof JwtAuthenticationToken jwtToken) {
//            String customerNumber = jwtToken.getToken().getClaimAsStringList("sub").get(0).substring(6);
            List<String> permissions = jwtToken.getToken().getClaimAsStringList("permissions");
//            return permissions.contains(permission.toString()) && customerNumber.equals(targetDomainObject);
            return permissions.contains(permission.toString());
        } else {
            return false;
        }
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}