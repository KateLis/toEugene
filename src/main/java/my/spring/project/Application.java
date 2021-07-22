package my.spring.project;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        FlatMortgage bean = applicationContext.getBean(FlatMortgage.class); //тут мы создаем экзеиляр класса какого? в смысле, того, где все мтеоды, а если они в разных местах?
        bean.whatIsYourMortgage();
        Krylo bean2 = applicationContext.getBean(Krylo.class);
        System.out.println(bean2.toString());
    }
}
