package com.moodanalyzer.MoodAnalyzer;

import com.moodanalyzer.exception.MoodAnalysisException;

public class MoodAnalyzer {
    private String mood;
    public MoodAnalyzer() {
    }
    public MoodAnalyzer(String mood) {
        this.mood = mood;
    }

    public String analyzeMood() {
        try {
            if(mood.contains("Sad")) {
                return "Sad";
            }
            else if(mood.isEmpty()) {
                throw new MoodAnalysisException(MoodAnalysisException.enumExceptionType.ENTERED_EMPTY,"Empty Message Entered");
            }
            return "Happy";
        }
        catch(NullPointerException | MoodAnalysisException ex) {
            throw new MoodAnalysisException(MoodAnalysisException.enumExceptionType.ENTERED_NULL,"Null Message Entered");
        }

    }
}

