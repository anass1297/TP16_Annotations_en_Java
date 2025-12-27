package com.example.annotations.security;

import java.lang.reflect.Method;

public class SecurityProcessor {

    public static void checkAccess(Method method) {
        if (method.isAnnotationPresent(RequiresRole.class)) {
            RequiresRole rr = method.getAnnotation(RequiresRole.class);
            if (!rr.value().equals(SecurityContext.getRole())) {
                throw new SecurityException(
                        "Accès refusé : rôle requis = " + rr.value()
                );
            }
        }
    }
}
