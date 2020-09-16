package patterns.bridge;

public class BridgePattern {
    public static void main(String[] args) {

        Car car = new Sedan(new Kia());
        car.showDetails();

    }
}

abstract class Car {
    Make make;

    public Car(Make m) {
        make = m;
    }

    abstract void showDetails();
}

class Sedan extends Car {
    public Sedan(Make m) {
        super(m);
    }

    @Override
    void showDetails() {
        System.out.println("Sedan");
        make.setMake();
    }
}

class Hatchback extends Car {
    public Hatchback(Make m) {
        super(m);
    }

    @Override
    void showDetails() {
        System.out.println("Hatchback");
        make.setMake();
    }
}

interface Make {
    void setMake();
}

class Kia implements Make {
    public void setMake() {
        System.out.println("Kia");
    }
}

class Scoda implements Make {
    public void setMake() {
        System.out.println("Scoda");
    }
}
