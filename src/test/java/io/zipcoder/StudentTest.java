package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {
    ArrayList<Double> examScores = new ArrayList(Arrays.asList( 100.0, 95.0, 123.0, 96.0));
    Student student = new Student("Mack", "Mick", examScores );

    @Test
    public void getNumExamsTaken() {

        Integer expected = 4;
        Integer actual = student.getNumExamsTaken();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getExamScoresTest() {
        String expected = "Exam Scores:\n" +
                "     Exam 1 -> 100.0\n" +
                "     Exam 2 -> 95.0\n" +
                "     Exam 3 -> 123.0\n" +
                "     Exam 4 -> 96.0";
        String actual = student.getExamScoresToString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addExamScore() {

        String expected = "Exam Scores:\n" +
                "     Exam 1 -> 100.0\n" +
                "     Exam 2 -> 95.0\n" +
                "     Exam 3 -> 123.0\n" +
                "     Exam 4 -> 96.0\n"+
                "     Exam 5 -> 50.0";
        String actual = student.addExamScore(50.0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setExamScore() {
        String expected = "Exam Scores:\n" +
                "     Exam 1 -> 100.0\n" +
                "     Exam 2 -> 45.0\n" +
                "     Exam 3 -> 123.0\n" +
                "     Exam 4 -> 96.0";
        String actual = student.setExamScore(2, 45.0);
        System.out.println(student.getExamScoresToString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAvgScore() {
        Double expected = 103.5;
        Double actual = student.getAvgScore();
        System.out.println(student.getAvgScore());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        String expected = "Student Name: Mack Mick\n" +
                "Average Score: 103.5\n" +
                "Exam Scores:\n" +
                "     Exam 1 -> 100.0\n" +
                "     Exam 2 -> 95.0\n" +
                "     Exam 3 -> 123.0\n" +
                "     Exam 4 -> 96.0";
        String actual = student.toString();
        System.out.println(student.toString());

        Assert.assertEquals(expected, actual);
    }
}