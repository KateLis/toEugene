package javarush;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Weekday {
        public static void main(String[] args) throws Exception {
            //напишите тут ваш код
            Map<Integer, String> hs = new HashMap<>();
            hs.put(1, "monday");
            hs.put(2, "tuesday");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String den1 = bf.readLine();
            int den = Integer.parseInt(den1);
            int indexMap = Integer.parseInt(hs.get(den));
            if (den == indexMap) {
                System.out.println("ghj");
            }
            else
                System.out.println("hi");


        }
}
