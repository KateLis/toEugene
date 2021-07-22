package my.spring.project;

import org.springframework.stereotype.Component;

@Component
public class Krylo {

    private Mishki mishki;
    public Krylo(Mishki mishki){ //инджекст с помощью конструктора
        this.mishki = mishki;
    }

    @Override
    public String toString() {
        return "На золотом крыльце сидели: " + mishki.toString();
    }
}
