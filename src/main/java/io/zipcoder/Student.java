package io.zipcoder;

import java.util.ArrayList;
import java.util.OptionalDouble;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;


    public Student(String firstName, String lastName, ArrayList<Double> scores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = scores;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumExamsTaken() {
        return testScores.size();
    }

    public String getExamScoresToString() {
        StringBuilder scores = new StringBuilder("Exam Scores:\n");
        for (int i=0; i<this.getNumExamsTaken();i++){
            while (i < testScores.size()-1){
                scores.append("     Exam ").append(i+1).append(" -> ").append(testScores.get(i));
                scores.append("\n");
                i++;
            }scores.append("     Exam ").append(i+1).append(" -> ").append(testScores.get(i));

        }
        return scores.toString();
    }

    public ArrayList<Double> getTestScores() {
        return testScores;
    }

    public String addExamScore(Double score){
        testScores.add(score);
        return this.getExamScoresToString();
    }

    public String setExamScore(int testNum, Double score){
        testScores.set(testNum-1, score);
        return this.getExamScoresToString();
    }

    public Double getAvgScore(){
        OptionalDouble avg = testScores.stream()
                .mapToDouble(a -> a)
                .average();
        return avg.isPresent() ? avg.getAsDouble() :0;
    }

    @Override
    public String toString(){
            StringBuilder scores = new StringBuilder(String.format("Student Name: %s %s\n", this.getFirstName(), this.getLastName()));
            scores.append("Average Score: ").append(this.getAvgScore()).append("\n");
            scores.append(this.getExamScoresToString());
            return scores.toString();
    }
}


