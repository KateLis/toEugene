package hibernateBean.dao;

import hibernateBean.entity.Buyer;
import hibernateBean.entity.Course;
import hibernateBean.entity.Manager;
import hibernateBean.entity.Supervisor;

import java.util.List;

public interface KateDao {
    public void setCourse(Course course);
    public void changeCourse(Course course, String anotherName);
    public void deleteBuyer(Buyer buyer);
    public List showAllCourses();
    public void saveBuyer(Buyer buyer);
    public void saveSupervisor(Supervisor supervisor);
    public void saveManager(Manager manager);

}
