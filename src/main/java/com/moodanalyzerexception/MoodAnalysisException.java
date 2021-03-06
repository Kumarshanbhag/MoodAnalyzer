package com.moodanalyzerexception;

public class MoodAnalysisException extends RuntimeException{
    public final enumExceptionType type;

    public enum enumExceptionType{
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_CLASS, NO_SUCH_METHOD, NO_SUCH_FIELD, OBJECT_INVOCATION_ISSUE;
    }

    public MoodAnalysisException(enumExceptionType type,String message) {
        super(message);
        this.type=type;
    }
}
