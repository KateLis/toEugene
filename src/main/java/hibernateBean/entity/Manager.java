package hibernateBean.entity;

import com.jdbc.research.Car;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String managerName;
    private float percentReward;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manager", fetch = FetchType.EAGER)
    private Set<Buyer> buyers = new HashSet<>();//так или без new HashSet?

    @ManyToOne
    private Supervisor supervisor;

    public Manager(){}

    public Manager(String managerName, float percentReward) {
        this.managerName = managerName;
        this.percentReward = percentReward;
       // this.buyers = buyers;
    }

    public Manager(String managerName, float percentReward, Supervisor supervisor) {
        this.managerName = managerName;
        this.percentReward = percentReward;
        this.supervisor = supervisor;
        // this.buyers = buyers;
    }
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public float getPercentReward() {
        return percentReward;
    }

    public void setPercentReward(float percentReward) {
        this.percentReward = percentReward;
    }

    public Set<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(Set<Buyer> buyers) {
        this.buyers = buyers;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
