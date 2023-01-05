package model;

import java.util.ArrayList;
import java.util.Objects;

public class Subject {
    private Integer id;

    private String name;

    private String semester;

    private Integer credits;
    //many-to-one professor
    private Professor professor;

    public Professor getProfessor() {
        return professor;
    }

    public Subject(){}

    public Subject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subject(Integer id, String name, String semester, Integer credits) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.credits = credits;
    }

    public Subject(String name, String semester, Integer credits) {
        this.name = name;
        this.semester = semester;
        this.credits = credits;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    //many-to-many students
    ArrayList<Student> students = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id) && Objects.equals(name, subject.name)
                && Objects.equals(semester, subject.semester)

                && Objects.equals(credits, subject.credits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, semester, credits);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", semester='" + semester + '\'' +
                ", credits=" + credits +
                '}';
    }
}
