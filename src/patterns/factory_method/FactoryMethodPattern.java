package patterns.factory_method;

import java.util.Date;

public class FactoryMethodPattern {
    public static void main(String[] args) {

        WatchMaker maker = new DigitalWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {
    public void showTime() {
        System.out.println("VII - XX");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new RomeWatch();
    }
}
