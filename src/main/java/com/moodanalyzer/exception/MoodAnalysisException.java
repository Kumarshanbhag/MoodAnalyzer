package com.moodanalyzer.exception;

public class MoodAnalysisException extends RuntimeException{
    public final enumExceptionType type;

    public enum enumExceptionType{
        ENTERED_NULL, ENTERED_EMPTY;
    }

    public MoodAnalysisException(enumExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
