package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        if (!this.data.contains(student)) {
            if (getCount() < this.capacity) {
                this.data.add(student);
                return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            } else {
                return "The hall is full.\n";
            }
        }else {
            return "Student is already in the hall.";
        }
    }

    public String remove(Student student) {
        String output = "Student not found";
        if (this.data.contains(student)) {
            this.data.remove(student);
            output = String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }
        return output;
    }

    public Student getStudent(String firstName, String lastName) {
        Student searchedStudent = null;
        for (Student student : data) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                searchedStudent = student;
            }
        }
        return searchedStudent;
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("Hall size: " + getCount() + "\n");
        for (Student student : data) {
            String secondHalf = "Student: " + student + "\n";
            output.append(secondHalf);
        }
        return output.toString().trim();
    }
}
