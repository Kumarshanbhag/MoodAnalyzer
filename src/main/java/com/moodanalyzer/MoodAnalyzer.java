package com.moodanalyzer;

import com.moodanalyzerexception.MoodAnalysisException;

public class MoodAnalyzer {
    private String mood;
    public MoodAnalyzer() {
        this.mood="I am in Happy Mood";
    }
    public MoodAnalyzer(String mood) {
        this.mood = mood;
    }

    public String analyzeMood() {
        try {
            if(mood.contains("Sad")) {
                return "Sad";
            }
            else if(mood.length()==0) {
                throw new MoodAnalysisException(MoodAnalysisException.enumExceptionType.ENTERED_EMPTY,"Empty Message Entered");
            }
            return "Happy";
        }
        catch(NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.enumExceptionType.ENTERED_NULL,"Null Message Entered");
        }
    }

    public boolean equals(Object another) {
        if(this.mood.equals(((MoodAnalyzer) another).mood))
            return true;
        return false;
    }

}

