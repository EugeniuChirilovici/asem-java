import java.util.Scanner;

//Proprietatile matematice a Aranjamentelor se pot vedea in fisier
class Arrangements {
    private boolean[] used;
    private StringBuilder out = new StringBuilder();
    private  String in;
    private int n;
    public static int count = 0;

    public Arrangements() {}

    public Arrangements(final String str, int n) {
        in = str;
        used = new boolean[in.length()];
        this.n = n;
    }

    public void incrementation(){
        this.count++;
    }

    public int getCount(){
        return count;
    }

    public void arrange() {
        if (out.length() == n) {
            System.out.println(out+" ");
            incrementation();
            return;
        }
        for (int i = 0; i < in.length(); ++i) {
            if (used[i]) continue;
            out.append(in.charAt(i));
            used[i] = true;
            arrange();
            used[i] = false;
            out.setLength(out.length() - 1);
        }
    }
}
public class Main {
    public int Aranjament(int n){
        if(n<=0){
            return 1;
        }
        return n * Aranjament(n-1);
    }
    public static void main(String[] args) {
        System.out.println("Enter your desired name:");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        int number = name.length();
        System.out.println(" The number of arrangements in the mathematical formula \n"+new Main().Aranjament(number));

        Arrangements a = new Arrangements(name,number);
        a.arrange();
        System.out.println(" The number of arguments in the code \n"+new Arrangements().getCount());
    }
}
