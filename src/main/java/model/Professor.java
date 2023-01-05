package model;

import java.util.ArrayList;
import java.util.Objects;

public class Professor {


    public Professor(Integer id, String name, String surname, Integer age, String primary_subject1, String primary_subject2) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.primary_subject1 = primary_subject1;
        this.primary_subject2 = primary_subject2;
    }

    public Professor(String name, String surname, Integer age, String primary_subject1, String primary_subject2) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.primary_subject1 = primary_subject1;
        this.primary_subject2 = primary_subject2;
    }

    public  Professor(){}
    private Integer id;

    private String name;

    private String surname;

    private Integer age;

    private String primary_subject1;

    private String primary_subject2;

    //many-to-one faculty
    private Faculty faculty;

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    //one-to-many subjects
    ArrayList<Subject> subjects = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id) && Objects.equals(name, professor.name)
                && Objects.equals(surname, professor.surname)
                && Objects.equals(primary_subject1, professor.primary_subject1)
                && Objects.equals(primary_subject2, professor.primary_subject2)
                && Objects.equals(age, professor.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname,primary_subject1,primary_subject2,age);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPrimary_subject1() {
        return primary_subject1;
    }

    public void setPrimary_subject1(String primary_subject1) {
        this.primary_subject1 = primary_subject1;
    }

    public String getPrimary_subject2() {
        return primary_subject2;
    }

    public void setPrimary_subject2(String primary_subject2) {
        this.primary_subject2 = primary_subject2;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", primary_subject1='" + primary_subject1 + '\'' +
                ", primary_subject2='" + primary_subject2 + '\'' +
                ", faculty=" + faculty +
                ", subjects=" + subjects +
                '}';
    }
}

