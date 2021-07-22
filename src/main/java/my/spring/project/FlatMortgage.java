package my.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlatMortgage {
    @Autowired
    private Flats flats;

    public void whatIsYourMortgage(){
        System.out.println("You mortgage will be counted for this flat: ");
        System.out.println(flats.toString());
    }
}
