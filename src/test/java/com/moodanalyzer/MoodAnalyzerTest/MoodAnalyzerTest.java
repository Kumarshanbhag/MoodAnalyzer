package com.moodanalyzer.MoodAnalyzerTest;


import com.moodanalyzer.MoodAnalyzer.MoodAnalyzer;
import com.moodanalyzer.exception.MoodAnalysisException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {
    private String mood;

    @Test
    public void givenSadMood_whenProper_ShouldReturnSad() {
        try {
            MoodAnalyzer moodAnalysis=new MoodAnalyzer("I am in Sad Mood");
            mood = moodAnalysis.analyzeMood();
            Assert.assertEquals("Sad",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMood_WhenProper_ShouldReturnHappy() {
        try {
            MoodAnalyzer moodAnalysis=new MoodAnalyzer("This is Happy Mood");
            mood = moodAnalysis.analyzeMood();
            Assert.assertEquals("Happy",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMood_WhenProper_ShouldReturnInvalidMessage() {
        try {
            MoodAnalyzer moodAnalysis=new MoodAnalyzer();

        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.enumExceptionType.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenEmptyMood_WhenProper_ShouldReturnInvalidMessage(){
        try {
            MoodAnalyzer moodAnalysis=new MoodAnalyzer("");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.enumExceptionType.ENTERED_EMPTY,e.type);
        }
    }
}
