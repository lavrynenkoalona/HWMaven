

package Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReflectionHWTest implements ReflectionPractice{

    private Class<?> aClass;

    ReflectionHWTest(Object object)
    {
        if (object == null)
        {
            throw new IllegalArgumentException("Argument can't be null!!!");
        }
        load(object);
    }

    @Override
    public void load(Object anInstanceOfSomething) {
        this.aClass = anInstanceOfSomething.getClass();
    }

    @Override
    public int getTotalNumberOfMethods() {
        return aClass.getMethods().length;
    }

    @Override
    public int getTotalNumberOfConstructors() {
        return aClass.getConstructors().length;
    }

    @Override
    public int getTotalNumberOfFields() {
        return aClass.getFields().length;
    }

    @Override
    public Set<String> getAllImplementedInterfaces() {
        return Arrays.stream(aClass.getInterfaces()).map(Class::getName).collect(Collectors.toSet());
    }

    @Override
    public int getCountOfConstantFields() {
        return (int) Arrays.stream(aClass.getFields())
                .filter(f -> Modifier.isStatic(f.getModifiers())
                        && Modifier.isFinal(f.getModifiers())
                        && Modifier.isPublic(f.getModifiers()))
                .count();
    }

    @Override
    public int getCountOfStaticMethods() {
        return (int) Arrays.stream(aClass.getMethods())
                .filter(m -> Modifier.isStatic(m.getModifiers())).count();
    }

    @Override
    public boolean isExtendingClassWhichIsNotObject() {
        return false;
    }

    @Override
    public String getParentClassSimpleName() {
        return aClass.getSuperclass().getSimpleName();
    }

    @Override
    public boolean isParentClassAbstract() {
        return Modifier.isAbstract(aClass.getSuperclass().getModifiers());
    }

    @Override
    public Set<String> getNamesOfAllFieldsIncludingInheritanceChain() {
        Set<String> res = new HashSet<>();
        Class<?> k = aClass;
        while (k != null){
            res.addAll(Arrays.stream(k.getFields()).map(Field::getName).collect(Collectors.toSet()));
            k = k.getSuperclass();
        }
        return res;
    }

    @Override
    public int invokeMethodThatReturnsInt(String methodName, Object... args) {
        try {
            Method method = aClass.getMethod(methodName);
            method.invoke(args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    @Override
    public Object createInstance(int numberOfArgs, Object... args) {
        return null;
    }

    @Override
    public Object invokePrivateMethod(String name, Class<?>[] parametersTypes, Object... args) {
        return null;
    }

    @Override
    public String getInheritanceChain(String delimiter) {
        String res = "";
        Class<?> k = aClass;
        while (k != null){
            res = k.getSimpleName() + delimiter + res;
            k = k.getSuperclass();
        }
        return res;
    }

    @Override
    public int howManyAnnotationsTheClassAndMethodsHave() {
        int classAnnotationCount = aClass.getAnnotations().length;
        Integer methodAnnotationCount = Arrays.stream(aClass.getMethods()).map(m -> m.getAnnotations().length).collect(Collectors.summingInt(Integer::intValue));

        return classAnnotationCount + methodAnnotationCount;
    }

    @Override
    public List<Integer> getAllMethodAnnotationsParamsNumber(Class<? extends Annotation> annotation) {
        return null;
    }
}

