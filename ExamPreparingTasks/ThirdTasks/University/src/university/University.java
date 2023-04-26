package university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {

    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {

        if (getStudentCount() < getCapacity()) {
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }else if (students.contains(student)){
            return "Student is already in the university";
        }else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student){
        if (students.contains(student)){
            students.remove(student);
            return String.format("Removed student %s %s",student.getFirstName(),student.getLastName());
        }else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName){
        Student searchedStudent = null;
        for (Student student: students){
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                searchedStudent = student;
            }
        }
        return searchedStudent;
    }

    public String getStatistics(){
        return students.stream().map(s->String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                s.getFirstName(), s.getLastName(), s.getBestSubject()))
                .collect(Collectors.joining(System.lineSeparator()));
    }

}
