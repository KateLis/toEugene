package hibernateBean.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supervisor {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String surnameSuper;
    private int yearsOfWork;


    public void setManagerSet(Set<Manager> managerSet) {
        this.managerSet = managerSet;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "managerName", fetch = FetchType.EAGER)
    Set<Manager> managerSet = new HashSet<>();

    public Supervisor(){}

    public Supervisor(String surnameSuper, int yearsOfWork) {
        this.surnameSuper = surnameSuper;
        this.yearsOfWork = yearsOfWork;
    }

    public Supervisor(String surnameSuper, int yearsOfWork, Set<Manager> managerSet) {
        this.surnameSuper = surnameSuper;
        this.yearsOfWork = yearsOfWork;
        this.managerSet = managerSet;
    }
    public String getSurnameSuper() {
        return surnameSuper;
    }

    public void setSurnameSuper(String surnameSuper) {
        this.surnameSuper = surnameSuper;
    }

    public int getYearsOfWork() {
        return yearsOfWork;
    }

    public void setYearsOfWork(int yearsOfWork) {
        this.yearsOfWork = yearsOfWork;
    }
    public Set<Manager> getManagerSet() {
        return managerSet;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "id=" + id +
                ", surnameSuper='" + surnameSuper + '\'' +
                ", yearsOfWork=" + yearsOfWork +
                ", managerSet=" + managerSet +
                '}';
    }
}
