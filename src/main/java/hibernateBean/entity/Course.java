package hibernateBean.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String surname;
    private String courseName;
    private int price;
    private boolean haveBought;

    public Course() {}

    public Course(String sur, Buyer buyer, String courseName, int price, boolean haveBought){
        this.surname = sur;
        this.courseName = courseName;
        this.price = price;
        this.haveBought = haveBought;
        this.buyer = buyer;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Buyer buyer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_discount", joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id"))
    private List<Discount> discounts;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course", fetch = FetchType.EAGER)
//    private Set<Discount> discounts;

    public String getSurname(){
        return surname;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getPrice() {
        return price;
    }

    public boolean isHaveBought() {
        return haveBought;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setHaveBought(boolean haveBought) {
        this.haveBought = haveBought;
    }
    public Buyer getBuyers() {
        return buyer;
    }

    public void setBuyers(Buyer buyer) {
        this.buyer = buyer;
    }
    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public static class CourseBuilder{
        private String surname;
        private String courseName;
        private int price;
        private boolean haveBought;

        public CourseBuilder surname(String surname){
            this.surname = surname;
            return this;
        }
        public CourseBuilder courseName(String courseName){
            this.courseName = courseName;
            return this;
        }

        public Course build(){
            return new Course(this);//наш courseBuilder, который ранее заполнили
        }
    }
    Course(CourseBuilder courseBuilder){
        this.surname = courseBuilder.surname;
        this.courseName = courseBuilder.courseName;
    };
}
