package models;

import java.util.Objects;

public class Users {
    private String name;
    private String position;
    private String role;
    private String email;
    private int badgeNo;
    private String department;
    private int departmentId;
    private int id;

    public Users(String name, String position, String role, String email, int badgeNo, String department,int departmentId) {
        this.name = name;
        this.position = position;
        this.role = role;
        this.badgeNo = badgeNo;
        this.department = department;
        this.email = email;
        this.departmentId =departmentId;
    }
  //Getters
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public int getBadgeNo() {
        return badgeNo;
    }

    public String getDepartment() {
        return department;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
//Setters
    public void setPosition(String position) {
        this.position = position;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBadgeNo(int badgeNo) {
        this.badgeNo = badgeNo;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users )) return false;
        Users  that = (Users ) o;
        return id == that.id &&
                departmentId == that.departmentId  &&
                Objects.equals(name, that.name) &&
                Objects.equals(position , that.position) &&
                Objects.equals(role, that.role ) &&
                Objects.equals(email, that.email ) &&
                Objects.equals(badgeNo , that.badgeNo ) &&
                Objects.equals(department , that.department );
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, position , email , badgeNo , email , department , id);
    }
}

