import com.google.gson.Gson;
import dao.Sql2oUsersDao;
import dao.Sql2oNewsDao;
import dao.Sql2oDepartmentsDao;
import models.Departments;
import models.News;
import models.Users;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oDepartmentsDao departmentDao;
        Sql2oNewsDao newsDao;
        Sql2oUsersDao userDao;
        Connection conn;
        Gson gson = new Gson();

        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/database.sql'";
        Sql2o sql2o = new Sql2o(connectionString,""," ");

        departmentDao = new  Sql2oDepartmentsDao (sql2o);
        userDao = new Sql2oUsersDao(sql2o);
        newsDao = new Sql2oNewsDao(sql2o);
        conn = sql2o.open();

        post("/departments/new", "application/json", (req, res) -> {
            Departments department = gson.fromJson(req.body(), Departments.class);
            departmentDao.add(department);
            res.status(201);
            res.type("application/json");
            return gson.toJson(department);
        });

        get("/departments", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());
        });

        get("/departments/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int departmentId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.getAllNewsByDepartments(departmentId));
        });

        post("/users/new", "application/json", (req, res) -> {
            Users user = gson.fromJson(req.body(), Users.class);
            userDao.add(user);
            res.status(201);
            res.type("application/json");
            return gson.toJson(user);
        });

        get("/users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(userDao.getAll());
        });

        get("/users/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int userId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(userDao.getAllUsersByDepartments(userId));
        });

        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });

        get("/news", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(newsDao.getAll());
        });

        get("/news/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int newsId = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(newsDao.getAllDepartmentsByNews(newsId));
        });

    }
}