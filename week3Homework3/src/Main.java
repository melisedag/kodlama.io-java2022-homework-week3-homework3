import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import dataAccess.*;
import loggers.DatabaseLogger;
import loggers.FileLogger;
import loggers.Logger;
import loggers.EmailLogger;
import entities.Instructor;

public class Main {
    public static void main(String[] args) {

        Logger[] loggers = { new DatabaseLogger(), new EmailLogger(), new FileLogger() };

        CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), loggers);

        CourseManager courseManager = new CourseManager(new JdbcCourseDao(), loggers);

        Instructor newInstructor = new Instructor(1, "Melise", "Dağ");

        InstructorManager instructorManager = new InstructorManager(new JdbcInstructorDao(), loggers);
        instructorManager.add(newInstructor);
    }
}