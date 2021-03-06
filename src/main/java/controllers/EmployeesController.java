package controllers;

import db.DBHelper;
import db.seeds;
import models.Department;
import models.Employee;
import models.Manager;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;

public class EmployeesController {

    public static void main(String[] args) {

        ManagersController managersController = new ManagersController();
        seeds.seedData();

        get("/employees", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();
            List<Employee> employees = DBHelper.getAll(Employee.class);
            model.put("template", "templates/employees/index.vtl");
            model.put("employees", employees);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}
