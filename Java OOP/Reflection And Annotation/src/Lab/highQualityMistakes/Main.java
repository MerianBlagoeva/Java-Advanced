package Lab.highQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        Set<Field> fields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Field::getName))));

        Method[] methods = clazz.getDeclaredMethods();

        Comparator<Method> comparator = Comparator.comparing(Method::getName);

        Set<Method> getters = new TreeSet<>(comparator);
        Set<Method> setters = new TreeSet<>(comparator);

        for (Method method : methods) {
            String methodName = method.getName();

            if (methodName.contains("get")) {
                getters.add(method);
            } else if (methodName.contains("set")) {
                setters.add(method);
            }

        }


        for (Field field : fields) {
            int modifier = field.getModifiers();

            if (!Modifier.isPrivate(modifier)) {
                System.out.println(field.getName() + " must be private!");
            }
        }


        for (Method getter : getters) {
            int modifier = getter.getModifiers();

            if (!Modifier.isPublic(modifier)) {
                System.out.println(getter.getName() + " have to be public!");
            }

        }

        for (Method setter : setters) {
            int modifier = setter.getModifiers();

            if (!Modifier.isPrivate(modifier)) {
                System.out.println(setter.getName() + " have to be private!");
            }
        }

    }

}
