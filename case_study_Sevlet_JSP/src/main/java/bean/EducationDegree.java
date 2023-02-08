package bean;

public class EducationDegree {
    private int educationDegree;
    private String educationDegreeName;

    public EducationDegree() {
    }

    public EducationDegree(int educationDegree, String educationDegreeName) {
        this.educationDegree = educationDegree;
        this.educationDegreeName = educationDegreeName;
    }

    public EducationDegree(int educationDegreeId) {
        this.educationDegree = educationDegreeId;
    }

    public int getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(int educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }
}
