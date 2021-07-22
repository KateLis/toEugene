package javarush;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Visokosnyi {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String year = bf.readLine();
        int yearIn = Integer.parseInt(year);
        int onestep = yearIn % 400;
        int twostep = yearIn % 100;
        int treestep = yearIn % 4;
        if (twostep == 0) {
            if (onestep == 0) {
                System.out.println("количество дней в году: 366");
            } else
                System.out.println("количество дней в году: 365");
        } else if (treestep == 0)
            System.out.println("количество дней в году: 366");
        else
            System.out.println("количество дней в году: 365");
    }
}
