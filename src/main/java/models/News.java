package models;

import java.util.Objects;

public class News {
    private String general;
    private String department;
    private int id;

    public News(String general, String department) {
        this.general = general;
        this.department = department;
    }
//getters
    public String getGeneral() {
        return general;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }
//setters
    public void setGeneral(String general) {
        this.general = general;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(general  , department , id);
    }
}
