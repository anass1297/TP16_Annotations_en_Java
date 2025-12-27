package com.example.annotations.security;

import java.lang.reflect.Method;

public class SecurityTest {

    @RequiresRole("ADMIN")
    public void supprimerUtilisateur() {
        System.out.println("Utilisateur supprimé");
    }

    public static void main(String[] args) throws Exception {
        SecurityTest obj = new SecurityTest();
        Method m = SecurityTest.class.getMethod("supprimerUtilisateur");

        SecurityContext.setRole("USER"); // changer en "ADMIN"
        SecurityProcessor.checkAccess(m);
        m.invoke(obj);
    }
}
