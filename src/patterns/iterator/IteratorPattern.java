package patterns.iterator;

public class IteratorPattern {
    public static void main(String[] args) {

        Tasks c = new Tasks();

        Iterator it = c.getIteretor();

        while (it.hasNext()) {
            System.out.println((String)it.next());
        }

    }
}

interface Iterator {
    boolean hasNext();
    Object next();
}

interface Container {
    Iterator getIteretor();
}

class Tasks implements Container {
    String[] tasks = {"House", "Son", "Tree"};

    @Override
    public Iterator getIteretor() {
        return new TaskIterator();
    }
    private class TaskIterator implements Iterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (index < tasks.length) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
