package com.moodanalyzerfactory;

import com.moodanalyzer.MoodAnalyzer;
import com.moodanalyzerexception.MoodAnalysisException;

import java.lang.reflect.Constructor;
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
}
