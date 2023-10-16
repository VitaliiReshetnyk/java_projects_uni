package Topic4.Rectangle;
import java.util.Scanner;
public class rectangle {
    double x;
    double y;
    public double area(){
        return x*y;
    }
    protected double getX(){
        return x;
    }
    private void setX(double x){
        this.x = x;
    }

    public void input(Scanner sc){
        System.out.println("Input x,y:");
        this.x = sc.nextDouble();
        this.y = sc.nextDouble();
    }
    @Override
    public String toString(){
        return String.format("%f, %f", this.x, this.y);
    }
}

