package patterns.prototype;

public class PrototypePattern {
    public static void main(String[] args) {

        Human original = new Human(18, "Vasya");
        System.out.println(original);

        Human copy = (Human) original.copy();
        System.out.println(copy);

        HumanFactory factory = new HumanFactory(copy);
        Human h1 = factory.makeCopy();
        System.out.println(h1);

        factory.setProrotype(new Human(30, "Valery"));
        Human h2 = factory.makeCopy();
        System.out.println(h2);
    }
}

interface Copyble {
    Object copy();
}

class Human implements Copyble {
    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        Human copy = new Human(age, name);
        return copy;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

class HumanFactory {
    Human human;

    public HumanFactory(Human human) {
        setProrotype(human);
    }

    public void setProrotype(Human human) {
        this.human = human;
    }

    Human makeCopy() {
        return (Human) human.copy();
    }
}


