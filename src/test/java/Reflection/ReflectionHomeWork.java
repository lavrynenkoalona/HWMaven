package Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

public class ReflectionHomeWork implements ReflectionPractice {

    private Object anInstanceOfSomething;
    private Class<?> myClass;

    @Override
    public void load(Object anInstanceOfSomething) {
        this.anInstanceOfSomething = anInstanceOfSomething;
        myClass = anInstanceOfSomething.getClass();
    }

    @Override
    public int getTotalNumberOfMethods() {
        Class<?> refPractice = null;
        try {
            refPractice = Class.forName("Reflection.ReflectionPractice");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Class name by method forName" + refPractice);
        Method[] methods = refPractice.getDeclaredMethods();
           for (Method method : methods) {
            System.out.println("Number of methods:" + methods.length);
        }
       return methods.length;
    }

    @Override
    public int getTotalNumberOfConstructors() {
        Class<?> refPractice = null;
        try {
            refPractice = Class.forName("Reflection.ReflectionPractice");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Class name by method forName" + refPractice);
        Constructor[] constructors = refPractice.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Number of methods:" + constructors.length);
        }
        return constructors.length;
    }

    @Override
    public int getTotalNumberOfFields() {


        return 0; //TODO.
    }

    @Override
    public Set<String> getAllImplementedInterfaces() {
        return null; //TODO.
    }

    @Override
    public int getCountOfConstantFields() {
        return 0; //TODO.
    }

    @Override
    public int getCountOfStaticMethods() {
        return 0; //TODO.
    }

    @Override
    public boolean isExtendingClassWhichIsNotObject() {
        return false; //TODO.
    }

    @Override
    public String getParentClassSimpleName() {
        return null; //TODO.
    }

    @Override
    public boolean isParentClassAbstract() {
        return false; //TODO.
    }

    @Override
    public Set<String> getNamesOfAllFieldsIncludingInheritanceChain() {
        return null; //TODO.
    }

    @Override
    public int invokeMethodThatReturnsInt(String methodName, Object... args) {
        return 0; //TODO.
    }

    @Override
    public Object createInstance(int numberOfArgs, Object... args) {
        return null; //TODO.
    }

    @Override
    public Object invokePrivateMethod(String name, Class<?>[] parametersTypes, Object... args) {
        return null; //TODO.
    }

    @Override
    public String getInheritanceChain(String delimiter) {
        return null; //TODO.
    }

    @Override
    public int howManyAnnotationsTheClassAndMethodsHave() {
        return 0; //TODO.
    }

    @Override
    public List<Integer> getAllMethodAnnotationsParamsNumber(Class<? extends Annotation> annotation) {
        return null; //TODO.

    }
}
