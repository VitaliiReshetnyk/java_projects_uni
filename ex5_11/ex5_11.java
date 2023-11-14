package ex5_11;

class Bird {
    public void fly() {
        System.out.println("Bird is flying.");
    }

    public void sing() {
        System.out.println("Bird is singing.");
    }
}

class Hen extends Bird {
    public void layEggs() {
        System.out.println("Hen is laying eggs.");
    }

    public void hatchChicks() {
        System.out.println("Hen is hatching chicks.");
    }
}

class Cuckoo extends Bird {
    public void layEggs() {
        System.out.println("Cuckoo is laying eggs.");
    }

    public void Eggtrick() {
        System.out.println("Cuckoo is sending an egg.");
    }
}

public class ex5_11 {
    public static void main(String[] args) {
        Hen myHen = new Hen();
        myHen.fly();
        myHen.sing();
        myHen.layEggs();
        myHen.hatchChicks();

        Cuckoo myCuckoo = new Cuckoo();
        myCuckoo.Eggtrick();
        myCuckoo.fly();
    }
}
