package patterns.tamplate_method;

public class TemplateMethodPattern {
    public static void main(String[] args) {

        C a = new A();
        a.templateMethod();

        System.out.println();

        C b = new B();
        b.templateMethod();

    }
}

abstract class C {
    void templateMethod() {
        System.out.println("1");
        differ();
        System.out.println("3");
    }

    abstract void differ();
}

class A extends C {
    @Override
    void differ() {
        System.out.println("2");
    }
}

class B extends C {
    @Override
    void differ() {
        System.out.println("4");
    }
}
