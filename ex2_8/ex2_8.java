package ex2_8;

class Car {
    private int id;
    private String make;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double price;
    private String registrationNumber;

    public Car(int id, String make, String model, int yearOfManufacture, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    // Getter methods for accessing car properties

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }
    public String getRegistrationNumber(){
        return registrationNumber;
    }
    public double getPrice() {
        return price;
    }
}

public class ex2_8 {
    public static void main(String[] args) {
        Car[] cars = {
                new Car(1, "Toyota", "Camry", 2019, "Red", 25000.0, "ABC123"),
                new Car(2, "Honda", "Civic", 2017, "Blue", 20000.0, "XYZ456"),
                new Car(3, "Ford", "F-150", 2020, "Silver", 35000.0, "DEF789"),
                new Car(4, "Chevrolet", "Malibu", 2018, "White", 22000.0, "GHI101"),
                new Car(5, "Nissan", "Altima", 2019, "Black", 24000.0, "JKL202"),
                new Car(6, "Tesla", "Model 3", 2021, "Blue", 45000.0, "MNO303"),
                new Car(7, "BMW", "X5", 2020, "Black", 55000.0, "PQR404"),
                new Car(8, "Audi", "A4", 2017, "Gray", 28000.0, "STU505"),
                new Car(9, "Jeep", "Wrangler", 2017, "Green", 32000.0, "VWX606"),
                new Car(10, "Mercedes-Benz", "C-Class", 2022, "Silver", 60000.0, "YZA707")
        };

        String brandToFilter = "Toyota";
        displayCarsByBrand(cars, brandToFilter);

        String modelToFilter = "Civic";
        int yearsToOperate = 5;
        displayCarsByModelAndYears(cars, modelToFilter, yearsToOperate);

        int yearToFilter = 2017;
        double minPrice = 22000.0;
        displayCarsByYearAndPrice(cars, yearToFilter, minPrice);
    }

    public static void displayCarsByBrand(Car[] cars, String brand) {
        System.out.println("Cars of brand " + brand + ":");
        for (Car car : cars) {
            if (car.getMake().equals(brand)) {
                System.out.println(car.getModel() + " - " + car.getYearOfManufacture());
            }
        }
    }

    public static void displayCarsByModelAndYears(Car[] cars, String model, int years) {
        System.out.println("Cars of model " + model + " operated for more than " + years + " years:");
        int currentYear = 2023; // Current year
        for (Car car : cars) {
            if (car.getModel().equals(model) && currentYear - car.getYearOfManufacture() > years) {
                System.out.println(car.getMake() + " - " + car.getYearOfManufacture());
            }
        }
    }

    public static void displayCarsByYearAndPrice(Car[] cars, int year, double price) {
        System.out.println("Cars of year " + year + " with price more than " + price + ":");
        for (Car car : cars) {
            if (car.getYearOfManufacture() == year && car.getPrice() > price) {
                System.out.println(car.getMake() + " " + car.getModel() + " - " + car.getRegistrationNumber());
            }
        }
    }
}

