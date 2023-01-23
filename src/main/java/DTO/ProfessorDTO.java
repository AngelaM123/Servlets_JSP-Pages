package DTO;

import java.util.Objects;

public class ProfessorDTO {

    private Integer id;
    private Integer age;
    private String name;
    private String primary_subject1;
    private String primary_subject2;
    private String surname;
    private String facName;

    public ProfessorDTO() {
    }

    public ProfessorDTO(Integer id, Integer age, String name, String primary_subject1, String primary_subject2, String surname, String facName) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.primary_subject1 = primary_subject1;
        this.primary_subject2 = primary_subject2;
        this.surname = surname;
        this.facName = facName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    @Override
    public String toString() {
        return "ProfessorDTO{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", primary_subject1='" + primary_subject1 + '\'' +
                ", primary_subject2='" + primary_subject2 + '\'' +
                ", surname='" + surname + '\'' +
                ", facName='" + facName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorDTO that = (ProfessorDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(age, that.age) && Objects.equals(name, that.name) && Objects.equals(primary_subject1, that.primary_subject1) && Objects.equals(primary_subject2, that.primary_subject2) && Objects.equals(surname, that.surname) && Objects.equals(facName, that.facName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, primary_subject1, primary_subject2, surname, facName);
    }
}
