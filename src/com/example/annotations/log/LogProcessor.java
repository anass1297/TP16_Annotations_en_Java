package com.example.annotations.log;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

public class LogProcessor {

    public static Object invoke(Object obj, Method method, Object... args) throws Exception {

        boolean log = method.isAnnotationPresent(Loggable.class);

        if (log) {
            System.out.println("===== LOG =====");
            System.out.println("Méthode : " + method.getName());
            System.out.println("Heure   : " + LocalDateTime.now());
            System.out.println("Params  : " + Arrays.toString(args));
        }

        Object result = method.invoke(obj, args);

        if (log) {
            System.out.println("Retour  : " + result);
            System.out.println("==============\n");
        }

        return result;
    }
}
