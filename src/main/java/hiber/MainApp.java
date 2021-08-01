package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);


      User user1 = new User("Vasya","Pupkin","vasya1@mail.ru");
      user1.setCar(new Car("Zhiguli", 5));
      User user2 = new User("Tolik","Mosin","tolya@mail.ru");
      user2.setCar(new Car("YAZ", 469));
      User user3 = new User("Anya","Vasina","anya@mail.ru");
      user3.setCar(new Car("Volga", 21));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);




      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
        }

      System.out.println();
      System.out.println();

      List<User> usersByCars = userService.usersByCars("YAZ", 469);
      System.out.println(usersByCars);

      context.close();
   }
}
