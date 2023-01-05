package DTO;

import java.util.ArrayList;
import java.util.Objects;

public class FacultyDTO {


    private Integer id;
    private String name;
    private String location;
    private String study_field;

    private String uniName;

    public FacultyDTO() {
    }

    public FacultyDTO(Integer id, String name, String location, String study_field, String uniName) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.study_field = study_field;
        this.uniName = uniName;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStudy_field() {
        return study_field;
    }

    public void setStudy_field(String study_field) {
        this.study_field = study_field;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    @Override
    public String toString() {
        return "FacultyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", study_field='" + study_field + '\'' +
                ", uniName=" + uniName +
                '}';
    }

}


