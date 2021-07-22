import hibernateBean.entity.Course;

public class Builder {
    private Course course;
    public Builder(){
        course = new Course();
    }
    public Builder withSurname(String surname){
        surname = course.getSurname();
        return this;
    }
    public Builder withCourse(String courseName){
        courseName = course.getCourseName();
        return this;
    }
    public Builder withPrice(int price){
        price = course.getPrice();
        return this;
    }
    public Builder withBuyOrNot(Boolean haveBought){
        haveBought = course.isHaveBought();
        return this;
    }
    public Course build(){
        return course;
    }

}
