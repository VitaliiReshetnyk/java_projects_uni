package Topic4;
import java.util.Scanner;
import Topic4.Rectangle.rectangle;
//import static Debug.Log.log;
import static Debugoff.Log.log;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        rectangle r = new rectangle();
        r.input(sc);
        System.out.println(r);
        sc.close();
        // r.x = 1;
        //r.setAll(1,1);
        System.out.println(r);
        Debug.Log.log(String.valueOf(r.area()));

    }
}
