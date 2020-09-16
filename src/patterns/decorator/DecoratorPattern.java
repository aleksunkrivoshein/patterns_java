package patterns.decorator;

public class DecoratorPattern {
    public static void main(String[] args) {

        //PrinterInterface printer = new Printer("Hey");
        PrinterInterface printer = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hey"))));
        printer.print();
    }
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

class QuotesDecorator implements PrinterInterface {
    PrinterInterface component;

    public QuotesDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator implements PrinterInterface {
    PrinterInterface component;

    public LeftBracketDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();

    }
}

class RightBracketDecorator implements PrinterInterface {
    PrinterInterface component;

    public RightBracketDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
        System.out.print("]");

    }
}
