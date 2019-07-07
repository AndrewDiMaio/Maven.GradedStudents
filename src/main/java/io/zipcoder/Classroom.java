package io.zipcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;


public class Classroom {

    protected static ArrayList<Student> students;


    public Classroom(ArrayList<Student> students) {
        Classroom.students = students;
    }

    public Classroom(int maxNumberOfStudents){
        students = new ArrayList<>(maxNumberOfStudents);
    }

    public Classroom(){
        students = new ArrayList<>(30);
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public Double classAvg(){
        double totalSum = 0;
        int totalTests = 0;
        for (int i = 0; i < students.size(); i++) {
            for (int f = 0; f < students.get(i).getNumExamsTaken(); f++) {
                totalSum += students.get(i).getTestScores().get(f);
                totalTests++;
            }
        }return totalSum/totalTests;
    }

    public void addStudent(Student student) {
        if (getStudents() == null) {
            students = new ArrayList<>(30);
            students.add(0, student);
        }else {
            students.add(students.size(), student);
        }
    }

    public void removeStudent(String firstName, String lastName){
        for (Student student:students){
            if (student.getFirstName().equals(firstName)&&student.getLastName().equals(lastName)){
                students.remove(student);
                break;
            }
        }
    }

    public ArrayList<Student> getStudentByGrade(Double grade){
        ArrayList<Student> list = students.stream().filter(s -> s.getAvgScore().equals(grade)).collect(Collectors.toCollection(ArrayList::new));
        return list;
    }

    public HashMap<Student,Character> getGradeBook(){

        HashMap<Student,Character> gradeBook = new HashMap<>();
        for (Student student:students) {
            Character grade='F';
            if(student.getAvgScore()>=(.9*classAvg())) grade='A';
            else if (student.getAvgScore()>=(.71*classAvg())) grade='B';
            else if (student.getAvgScore()>=(.50*classAvg())) grade='C';
            else if (student.getAvgScore()>=(.11*classAvg())) grade='D';
            gradeBook.put(student,grade);
        }
        return gradeBook;
    }
}