package dao;

import models.Departments;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oDepartmentDao implements DepartmentsDao  {
    private final Sql2o sql2o;
    public Sql2oDepartmentsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public boolean equals(Departments departments {
        String sql = "INSERT INTO departments (name, description, totalNumber) VALUES (:name, :description, :totalNumber)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(departments)
                    .executeUpdate()
                    .getKey();
            departments .setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}

