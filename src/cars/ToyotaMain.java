package cars;

public class ToyotaMain {

    public static void main(String[] args) {

        Toyota camry = new Toyota();

        camry.info();
        System.out.printf(">>> has GPS: %b\n", camry.isGps());

        camry.setMake("BMW");

        camry.fuelGuage();
        camry.go(5,true);
        camry.fuelGuage();
        camry.go(7, false);
        camry.fuelGuage();

        Car myCar = new Toyota();
        Fiat fiat = new Fiat();

        Workshop workshop = new Workshop();
        workshop.service(myCar);

        workshop.service(camry);
        workshop.service(fiat);
        

    }
    
}
