package DTO;

public class UniversityDTO {

    private Integer id;
    private String name;
    private String description;

    private String facName;


    public UniversityDTO() {
    }

    public UniversityDTO(Integer id, String name, String description, String facName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.facName = facName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    @Override
    public String toString() {
        return "UniversityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", facName='" + facName + '\'' +
                '}';
    }
}
