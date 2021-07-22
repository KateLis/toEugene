package javarush;

public class Jupiter {
    public static void main (String[] args) {
    System.out.print("Welcome " + args[1] + "!");    }   }
class Juno {
    public static void main (String[] args) {
    Jupiter.main(args);   }   }