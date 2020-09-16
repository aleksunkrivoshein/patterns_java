package patterns.abstract_factory;

public class AbstractFactoryPattern {

    public static void main(String[] args) {

        DeviceFactory factory = getFactoryByCountryCode("EN");
        Mouse m = factory.getMouse();
        Keyboard k = factory.getKeyboard();
        Touchpad t = factory.getTouchpad();

        m.click();
        k.print();
        k.println();
        t.track(10, 35);

    }

    private static DeviceFactory getFactoryByCountryCode(String lang) {

        if (lang == "RU") {
            return new RuDeviceFactory();
        } else if (lang == "EN") {
            return new EnDeviceFactory();
        } else {
            throw new RuntimeException("Unsupported Country Code: " + lang);
        }
    }
}

interface Mouse {
    void click();

    void dblclick();

    void scroll(int direction);
}

interface Keyboard {
    void print();

    void println();
}

interface Touchpad {

    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();

    Keyboard getKeyboard();

    Touchpad getTouchpad();
}

class EnDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new EnTouchpad();
    }
}

class RuDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public Touchpad getTouchpad() {
        return new RuTouchpad();
    }
}

class RuMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Щелчок мышью");
    }

    @Override
    public void dblclick() {
        System.out.println("Двойной щелчок мышью");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Скроллим вверх");
        } else if (direction < 0) {
            System.out.println("скроллим вниз");
        } else {
            System.out.println("не скроллим");
        }
    }
}

class RuKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Печатаем строку");
    }

    @Override
    public void println() {
        System.out.println("Печатаем строку с переносом строки");
    }
}

class RuTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Передвинули на " + s + " пикселей");
    }
}

class EnMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Mouse click");
    }

    @Override
    public void dblclick() {
        System.out.println("Mouse double click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Scroll up");
        } else if (direction < 0) {
            System.out.println("Scroll down");
        } else {
            System.out.println("No scrolling");
        }
    }
}

class EnKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Print");
    }

    @Override
    public void println() {
        System.out.println("Print line");
    }
}

class EnTouchpad implements Touchpad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved " + s + " pixels");
    }
}

