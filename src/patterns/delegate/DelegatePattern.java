package patterns.delegate;


class DelegatePattern {
    public static void main(String[] args) {
        Painter painter = new Painter();
        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Triangle());
        painter.draw();
    }
}

interface Graphics {

    void draw();
}

class Triangle implements Graphics {

    public void draw() {
        System.out.println("Рисуем треугольник");
    }
}

class Square implements Graphics {
    public void draw() {
        System.out.println("Рисуем квадрат");
    }
}

class Circle implements Graphics {
    public void draw() {
        System.out.println("Рисуем круг");
    }
}

class Painter {

    Graphics graphics;

    void setGraphics(Graphics g) {
        graphics = g;
    }

    void draw() {
        graphics.draw();
    }

}



