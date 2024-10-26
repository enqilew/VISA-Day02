package cars;

public class Main {

    public static void main(String[] args) {

        //Instantiation
        //Creating an instance of the class
        //myCar is an instance of Car
        Car myCar = new Car("Toyota");
        myCar.setOwner("Fred");
        myCar.info();

        Car yourCar = new Car("Nissan", "Red");
        yourCar.setOwner("Barney");
        yourCar.info();

        Car ourCar = new Car();
        ourCar.setMake("BMW");
        ourCar.setOwner("Wilma");
        ourCar.info();

        Car batCar = new Car();
        batCar.setOwner("Bruce Wayne");
        batCar.info();

        batCar.fuelGuage();
        batCar.go();
        batCar.fuelGuage();
        batCar.go(3, true);
        batCar.fuelGuage();

        //Car trailer for 6 cars
        Car[] trailer = new Car[6];
        trailer[0] = myCar;
    }

    
}
