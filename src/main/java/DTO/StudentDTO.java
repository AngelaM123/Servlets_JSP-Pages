package DTO;

public class StudentDTO {


    private Integer id;
    private Integer indeks;
    private String name;
    private String location;
    private String surname;

    private String uniName;

    public StudentDTO() {
    }

    public StudentDTO(Integer id, Integer indeks, String name, String location, String surname, String uniName) {
        this.id = id;
        this.indeks = indeks;
        this.name = name;
        this.location = location;
        this.surname = surname;
        this.uniName = uniName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndeks() {
        return indeks;
    }

    public void setIndeks(Integer indeks) {
        this.indeks = indeks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", indeks=" + indeks +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", surname='" + surname + '\'' +
                ", uniName='" + uniName + '\'' +
                '}';
    }
}
