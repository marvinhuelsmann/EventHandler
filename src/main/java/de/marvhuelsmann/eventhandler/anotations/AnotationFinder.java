package de.marvhuelsmann.eventhandler.anotations;

import de.marvhuelsmann.eventhandler.EventManager;
import de.marvhuelsmann.eventhandler.eventplayer.EventPlayer;
import io.github.classgraph.*;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AnotationFinder {

    @Getter
    private final HashMap<Anotations, Method> methodsLists = new HashMap<>();

    public void detectAnotation(String... packages) {
        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()
                .whitelistPackages(packages)
                .scan()) {

            ClassInfoList classInfos= scanResult.getAllClasses();

            for (ClassInfo classInfo : classInfos) {
                for (MethodInfo methodInfo : classInfo.getMethodInfo()) {
                    for (Anotations anotations : Anotations.values()) {
                        if (methodInfo.hasAnnotation(anotations.getType().getName())) {
                            methodInfo.loadClassAndGetMethod();
                            Method method = methodInfo.loadClassAndGetMethod();
                            methodsLists.put(anotations, method);
                        }
                    }
                }
            }
        }
    }

    public void runAnotation(Anotations anotations, EventPlayer eventPlayer) {
        for (Map.Entry<Anotations, Method> anotationsEntry : EventManager.getInstance().getAnotationFinder().getMethodsLists().entrySet()) {
            if (anotationsEntry.getKey().equals(anotations)) {
                try {
                    anotationsEntry.getValue().invoke(anotationsEntry.getValue().getDeclaringClass().newInstance(), eventPlayer);
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException illegalAccessException) {
                    illegalAccessException.printStackTrace();
                }
            }
        }
    }
}
