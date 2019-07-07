package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ClassroomTest {
    @Test
    public void getStudents() {
        ArrayList<Student> students = new ArrayList<>(10);
        ArrayList<Double> examScores = new ArrayList(Arrays.asList( 100.0, 95.0, 123.0, 96.0));
        Classroom classroom = new Classroom(students);
        students.add(0, new Student("Bob", "Smith", examScores));
        int expected = 1;
        int actual = classroom.getStudents().size();

        Assert.assertEquals(expected,actual);

        classroom.addStudent(new Student("Bob", "Smith", examScores));

        Assert.assertEquals(2, classroom.getStudents().size());

    }


    @Test
    public void classAvg() {
        ArrayList<Student> students = new ArrayList<>(10);
        ArrayList<Double> examScores = new ArrayList(Arrays.asList( 100.0, 100.0));
        for (int i = 0; i<5; i++){
            Student student = new Student("Mack", "Mick", examScores);
            students.add(i, student);
        }
        ArrayList<Double> examScores2 = new ArrayList(Arrays.asList( 90.0, 90.0, 90.0, 90.0));
        for (int i = 5; i<10; i++){
            Student student = new Student("Mack", "Mick", examScores2);
            students.add(i, student);
        }
        Classroom classroom = new Classroom(students);

        double expected =93.33333333333333;
        double actual = classroom.classAvg();

        Assert.assertEquals(expected,actual, .00009);
    }

    @Test
    public void addStudent() {
        ArrayList<Double> examScores = new ArrayList(Arrays.asList( 100.0, 100.0));
        ArrayList<Student> students = new ArrayList<>();
        Classroom classroom = new Classroom(students);
        for (int i = 0; i<5; i++){
            Student student = new Student("Mack", "Mick", examScores);
            classroom.addStudent(student);
        }

        ArrayList<Double> examScores2 = new ArrayList(Arrays.asList( 50.0, 50.0));
        Student student2 = new Student("Michael", "Smith", examScores2);
        classroom.addStudent(student2);

        int expected = 6;
        int actual = classroom.getStudents().size();
        for (Student s: students){
            System.out.println(s.toString());
        }
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeStudent() {
        ArrayList<Double> examScores = new ArrayList(Arrays.asList( 100.0, 100.0));
        ArrayList<Student> students = new ArrayList<>();
        Classroom classroom = new Classroom(students);
        for (int i = 0; i<5; i++){
            Student student = new Student("Mack", "Mick", examScores);
            classroom.addStudent(student);
        }

        ArrayList<Double> examScores2 = new ArrayList(Arrays.asList( 50.0, 50.0));
        Student student2 = new Student("Michael", "Smith", examScores2);
        classroom.addStudent(student2);

        int expected = 5;
        classroom.removeStudent("Michael", "Smith");
        int actual = classroom.getStudents().size();
        for (Student s: students){
            System.out.println(s.toString());
        }
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void getStudentByGrade() {
        ArrayList<Student> students = new ArrayList<>();
        Classroom classroom = new Classroom(students);
        ArrayList<Double> examScores1 = new ArrayList(Arrays.asList( 100.0, 100.0));
        ArrayList<Double> examScores2 = new ArrayList(Arrays.asList( 100.0, 10.0));
        ArrayList<Double> examScores3 = new ArrayList(Arrays.asList( 100.0, 100.0));

        classroom.addStudent(new Student("andy", "smo", examScores1));
        classroom.addStudent(new Student("sms", "ddkd", examScores2));
        classroom.addStudent(new Student("zoo", "tom", examScores3));

        ArrayList<Student> newList = new ArrayList<>(2);
        newList.add(0, new Student("andy", "smo", examScores3));
        newList.add(1, new Student("zoo", "tom", examScores1));

        ArrayList<Student> expected = newList;
        ArrayList<Student> actual = classroom.getStudentByGrade(100.0);
    }


    @Test
    public void getGradeBook() {
        ArrayList<Double> examScores1 = new ArrayList(Arrays.asList( 100.0, 150.0));
        ArrayList<Double> examScores2 = new ArrayList(Arrays.asList( 225.0, 25.0));
        ArrayList<Double> examScores3 = new ArrayList(Arrays.asList( 100.0, 50.0));
        ArrayList<Double> examScores4 = new ArrayList(Arrays.asList( 0.0, 0.0));

        Student s1 = new Student("asdf", "fds", examScores1);
        Student s2 = new Student("sdf", "cx", examScores2);
        Student s3 = new Student("asd", "seds", examScores3);
        Student s4 = new Student("dfv", "asd", examScores4);

        ArrayList<Student> students = new ArrayList(Arrays.asList( s1, s2, s3, s4));
        Classroom classroom = new Classroom(students);

        System.out.println(classroom.getGradeBook().toString());

    }
}
