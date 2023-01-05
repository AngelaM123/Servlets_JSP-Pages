package DTO;

public class SubjectDTO {

    private Integer id;
    private Integer credits;
    private String name;
    private String semester;
    private String profName;


    public SubjectDTO() {
    }

    public SubjectDTO(Integer id, Integer credits, String name, String semester, String profName) {
        this.id = id;
        this.credits = credits;
        this.name = name;
        this.semester = semester;
        this.profName = profName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
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

    public String getProfName() {
        return profName;
    }

    public void setProfName(String profName) {
        this.profName = profName;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "id=" + id +
                ", credits=" + credits +
                ", name='" + name + '\'' +
                ", semester='" + semester + '\'' +
                ", profName='" + profName + '\'' +
                '}';
    }
}
