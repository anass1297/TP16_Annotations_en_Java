package com.example.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void processClass(Class<?> clazz) {
        System.out.println("Traitement de la classe: " + clazz.getName());

        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Auteur: " + author.name());
            System.out.println("Date: " + author.date());
        }

        if (clazz.isAnnotationPresent(Version.class)) {
            Version version = clazz.getAnnotation(Version.class);
            System.out.println("Version: " + version.value());
        }

        System.out.println("\nToutes les annotations:");
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println(annotation);
        }

        System.out.println("\nTraitement des méthodes:");
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo info = method.getAnnotation(MethodInfo.class);
                System.out.println("Méthode: " + method.getName());
                System.out.println("Description: " + info.description());
                System.out.println("Tags: " + String.join(", ", info.tags()));
                System.out.println("Révision: " + info.revision());
                System.out.println();
            }
        }
    }

    public static void processClassWithBugs(Class<?> clazz) {
        System.out.println("Traitement des bugs pour: " + clazz.getName());

        Bug[] bugs = clazz.getAnnotationsByType(Bug.class);

        if (bugs.length == 0) {
            System.out.println("Aucun bug trouvé");
            return;
        }

        for (Bug bug : bugs) {
            System.out.println("ID: " + bug.id());
            System.out.println("Description: " + bug.description());
            System.out.println("Statut: " + bug.status());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        processClass(AnnotatedClass.class);
    }
}
