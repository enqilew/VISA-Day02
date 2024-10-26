package cars;

public class Workshop {
    
    public void service(Toyota toyota) {
        System.out.printf("Servicing Toyota: %s\n", toyota.getOwner());
    }

    public void service(Car car) {
        if (car instanceof Fiat) {
            System.out.printf("Servicing Fiat: %s\n", car.getOwner());
        } else {
            System.out.printf("Servicing generic car: %s\n", car.getOwner());
        }

    }
}
