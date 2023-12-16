package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Object object) {
        List<String> notValidFields = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(object) == null) {
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Object object) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            String fieldName = field.getName();

            if (field.isAnnotationPresent(NotNull.class)) {
                if (checkNull(object, field)) {
                    notValidFields.putIfAbsent(fieldName, new ArrayList<>());
                    notValidFields.get(fieldName).add("can not be null]");
                    continue;
                }
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                if (checkMinLength(object, field)) {
                    MinLength annotation = field.getAnnotation(MinLength.class);
                    notValidFields.putIfAbsent(field.getName(), new ArrayList<>());
                    notValidFields.get(fieldName).add("length less than " + annotation.minLength());
                }
            }
        }

        return notValidFields;
    }

    public static boolean checkNull(Object object, Field field) {
        field.setAccessible(true);
        try {
            return field.get(object) == null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkMinLength(Object object, Field field) {
        field.setAccessible(true);
        try {
            String value = (String) field.get(object);
            MinLength annotation = field.getAnnotation(MinLength.class);
            return value == null || value.length() < annotation.minLength();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
// END
