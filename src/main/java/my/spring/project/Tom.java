package my.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tom {

    private TriUt triUt;

    @Autowired
    public void setTriUt(TriUt triUt){
        this.triUt = triUt;
    }

    @Override
    public String toString() {
        return "Том и Джери " + triUt.toString();
    }
}
