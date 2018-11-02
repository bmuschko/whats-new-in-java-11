package com.bmuschko.java11.library;

import java.lang.reflect.Field;

public class Outer {
    private static String level = "outer";

    public static class Inner {
        // already valid in Java 10
        public static String getOuterViaRegularFieldAccess() {
            return Outer.level;
        }

        public static String getOuterViaReflection() {
            try {
                Field levelField = Outer.class.getDeclaredField("level");
                // levelField.setAccessible(true); // required in Java <= 10
                return levelField.get(null).toString();
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
