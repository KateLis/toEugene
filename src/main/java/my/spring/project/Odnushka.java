package my.spring.project;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component

public class Odnushka extends Flats{
    @Override
    public String toString() {
        return "Odnushka";
    }
}
