package com.moodanalyzertest;


import com.moodanalyzer.MoodAnalyzer;
import com.moodanalyzerexception.MoodAnalysisException;
import com.moodanalyzerfactory.MoodAnalyzerFactory;
import org.junit.Assert;
import org.junit.Test;

import static com.moodanalyzerfactory.MoodAnalyzerFactory.*;

public class MoodAnalyzerTest {
    private String mood;

    @Test
    public void givenSadMoodInConstructor_WhenProper_ShouldReturnSad() {
        try {
            MoodAnalyzer moodAnalysis=new MoodAnalyzer("I am in Sad Mood");
            mood = moodAnalysis.analyzeMood();
            Assert.assertEquals("Sad",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenAnyMoodInConstructor_WhenProper_ShouldReturnHappy() {
        try {
            MoodAnalyzer moodAnalysis=new MoodAnalyzer("This is Happy Mood");
            mood = moodAnalysis.analyzeMood();
            Assert.assertEquals("Happy",mood);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenNullMoodInConstructor_WhenProper_ShouldThrowMoodAnalysisException() {
        try {
            MoodAnalyzer moodAnalysis=new MoodAnalyzer();

        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.enumExceptionType.ENTERED_NULL,e.type);
        }
    }

    @Test
    public void givenEmptyMoodInConstructor_WhenProper_ShouldThrowMoodAnalysisException(){
        try {
            MoodAnalyzer moodAnalysis=new MoodAnalyzer("");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.enumExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassWithDefaultConstructor_WhenProper_ShouldReturnObject() {
        MoodAnalyzer moodAnalyzer = createMoodAnalyzerObject();
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("Happy", mood);
        }
        catch(MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProper_ShouldReturnObject() {
        try {
            MoodAnalyzer mood=createMoodAnalyzerObject();
            Assert.assertEquals(new MoodAnalyzer(),mood);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenImproper_ShouldReturnException() {
        try {
            MoodAnalyzerFactory.getConstuctor("com.moodanalyzer.MoodAnalyzer1",String.class);
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.enumExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMoodAnalyzerClass_WhenProperWithImproperConstructor_ShouldReturnException() {
        try {
            MoodAnalyzerFactory.getConstuctor("com.moodanalyzer.MoodAnalyzer",Integer.class);
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.enumExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassWithParameterConstructor_WhenProper_ShouldReturnObject() {
        try {
            MoodAnalyzer mood = createMoodAnalyzerObject("I am in Happy mood");
            Assert.assertEquals(new MoodAnalyzer("I am in Happy mood"), mood);
        }
        catch(MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMoodUsingReflection_WhenProper_ShouldReturnObject() {
        try {
            String mood = MoodAnalyzerFactory.invokeMethod("I am in Happy Mood", "com.moodanalyzer.MoodAnalyzer","analyzeMood");
            Assert.assertEquals("Happy", mood);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMoodUsingReflection_WhenImproperMethodName_ShouldReturnException() {
        try {
            MoodAnalyzerFactory.invokeMethod("I am in Happy Mood", "com.moodanalyzer.MoodAnalyzer","analyzeMood1");
        }
        catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.enumExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenHappyMoodUsingReflection_WhenProperSetField_ShouldReturnObject() {
        try {
            MoodAnalyzer moodAnalyzerObject = createMoodAnalyzerObject();
            String fieldMood = invokeField(moodAnalyzerObject, "I am in Happy Mood", "mood");
            Assert.assertEquals("Happy", fieldMood);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMoodUsingReflection_WhenImproperSetMood_ShouldReturnException() {
        try {
            MoodAnalyzer moodAnalyzerObject = createMoodAnalyzerObject();
            invokeField(moodAnalyzerObject, "I am in Happy Mood", "mood1");
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.enumExceptionType.NO_SUCH_FIELD,e.type);
        }
    }

    @Test
    public void givenNullMessageUsingReflection_WhenProperSetMood_ShouldReturnException() {
        try {
            MoodAnalyzer moodAnalyzerObject = createMoodAnalyzerObject();
            invokeField(moodAnalyzerObject, null, "mood");
        }
        catch(MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.enumExceptionType.OBJECT_INVOCATION_ISSUE,e.type);
        }
    }
}
