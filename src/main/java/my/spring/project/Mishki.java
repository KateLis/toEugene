package my.spring.project;

import org.springframework.stereotype.Component;

@Component
public class Mishki {
    private Tom tom;
    public Mishki(Tom tom){
        this.tom = tom;
    }

    @Override
    public String toString() {
        return "Мишки Гамми " + tom.toString();
    }
}
