package dao;

import org.sql2o.Sql2o;

public class Sql2oDepartmentDao implements DepartmentsDao  {
    private final Sql2o sql2o;
    public Sql2oDepartmentsDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

}
