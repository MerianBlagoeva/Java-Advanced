package Lab.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> clazz = Reflection.class;

        Reflection reflection = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("setName", String.class);

        Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        Inject annotation = (Inject) parameterAnnotations[0][0];

        String value = annotation.value();

        method.invoke(reflection, value);

        System.out.println();


    }
}
