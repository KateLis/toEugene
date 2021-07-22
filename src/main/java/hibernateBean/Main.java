package hibernateBean;

import hibernateBean.dao.KateDaoImpl;
import hibernateBean.entity.Buyer;
import hibernateBean.entity.Course;
import hibernateBean.entity.Manager;
import hibernateBean.entity.Supervisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(HibernateConfig.class);
        KateDaoImpl bean3 = applicationContext.getBean(KateDaoImpl.class);

//        Buyer buyer1 = new Buyer("Kirill", false, manager1);
//        Buyer buyer2 = new Buyer("Artem", true, manager1);
//        Buyer buyer3 = new Buyer("Lena", true, manager1); //почему у buyer в табл менеджер_айди?
      //  Course course1 = new Course("Ivanov", buyer1, "English1", 1500, true);
        Supervisor sup1 = new Supervisor("Borisov", 12);
        bean3.saveSupervisor(sup1);
        Manager manager1 = new Manager("Petrov", (float) 0.2, sup1);//почему 0.2 - Это double?
        Manager manager2 = new Manager("Avdeev", (float) 0.7, sup1);//почему 0.2 - Это double?
//        Set<Manager> managerSet = new HashSet<>();
//
//        managerSet.add(manager1);
//        managerSet.add(manager2);
        bean3.saveManager(manager1);
        bean3.saveManager(manager2);
        System.out.println(bean3.getSupById(28L));

      //  sup1.getManagerSet().addAll(managerSet);
        //ПОЧЕМУ НЕТ МОИХ МЕНЕДЖЕРОВ????

      //  bean3.setCourse(course1);
           //почему дважды создался, если в конфиге validate?

      //  bean3.saveBuyer(buyer2);
       // bean3.changeCourse(course1, "Maths");//почему я не могу без шага "сохранени" курса, его изменить?
      //  bean3.showAllCourses(); //как-то так себе показал, ПОЧЕМУ И КАК НАДО??
        // Course course = new Course.Builder
       // kateDao.buyCourse(course1);
    }

}
