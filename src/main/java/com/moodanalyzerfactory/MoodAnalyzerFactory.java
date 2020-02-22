package com.moodanalyzerfactory;

import com.moodanalyzer.MoodAnalyzer;
import com.moodanalyzerexception.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzerObject() {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.moodanalyzer.MoodAnalyzer");
            Constructor<?> moodAnalyzerconstructor = moodAnalyzerClass.getConstructor();
            MoodAnalyzer obj=(MoodAnalyzer) moodAnalyzerconstructor.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getConstuctor(String className, Class param ) {
        try {
            Constructor<?> constructor = Class.forName(className).getConstructor(param);
            return constructor;
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.enumExceptionType.NO_SUCH_METHOD,e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.enumExceptionType.NO_SUCH_CLASS,e.getMessage());
        }
    }

    public static MoodAnalyzer createMoodAnalyzerObject(String message) {
        try {
            Class<?> moodAnalyzerClass = Class.forName("com.moodanalyzer.MoodAnalyzer");
            Constructor<?> moodAnalyzerconstructor = moodAnalyzerClass.getConstructor(String.class);
            MoodAnalyzer obj=(MoodAnalyzer) moodAnalyzerconstructor.newInstance(message);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String invokeMethod(String message, String className,String methodName) {
        try {
            Class<?> moodAnalyzerClass = Class.forName(className);
            Object obj = moodAnalyzerClass.getConstructor(String.class).newInstance(message);
            return (String) moodAnalyzerClass.getMethod(methodName).invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.enumExceptionType.NO_SUCH_METHOD,e.getMessage());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String invokeField(MoodAnalyzer obj,String message, String mood) {
        try {
            Field moodField = obj.getClass().getDeclaredField(mood);
            moodField.setAccessible(true);
            moodField.set(obj,message);
            return (String) obj.getClass().getMethod("analyzeMood").invoke(obj);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalysisException(MoodAnalysisException.enumExceptionType.NO_SUCH_FIELD,e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.enumExceptionType.OBJECT_INVOCATION_ISSUE,e.getMessage());
        }
        return null;
    }
}
