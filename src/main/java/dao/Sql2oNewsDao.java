package dao;

import models.Departments;
import models.News;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oNewsDao {
    private final Sql2o sql2o;

    public Sql2oUsersDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Users users) {
        String sql = "INSERT INTO users (name, position, role,badgeNo,department,email, departmentId) VALUES (:name, :position, :role, :badgeNo, :department, :email , :departmentId)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(users)
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public List<News> getAll() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM news")
                    .executeAndFetch(News.class);
        }
    }
    @Override
    public void deleteById(int id) {
        String sql = "DELETE from news WHERE id=:id";
        String deleteJoin = "DELETE from departments_news WHERE newsId = :newsId";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
            con.createQuery(deleteJoin)
                    .addParameter("newsId", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public void clearAll() {
        String sql = "DELETE from news";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public void addNewsToDepartments(News  news, Departments departments ){
        String sql = "INSERT INTO departments_news (departmentId, newsId) VALUES (:departmentId, :newsId)";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("departmentId", departments.getId())
                    .addParameter("newsId", news.getId())
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public List<Departments> getAllDepartmentsByNews(int newsId) {
        ArrayList<Departments> departments = new ArrayList();
        String joinQuery = "SELECT departmentId FROM departments_news WHERE newsId = :newsId";
        try (Connection con = sql2o.open()) {
            List<Integer> allDepartmentsIds = con.createQuery(joinQuery)
                    .addParameter("newsId", newsId)
                    .executeAndFetch(Integer.class);
            for (Integer departmentId : allDepartmentsIds){
                String departmentsQuery = "SELECT * FROM departments WHERE id = :departmentId";
                departments.add(
                        con.createQuery(departmentsQuery)
                                .addParameter("departmentId", departmentId)
                                .executeAndFetchFirst(Departments.class));
            }
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
        return departments;

    }
}
