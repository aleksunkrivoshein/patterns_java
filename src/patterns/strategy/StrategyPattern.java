package patterns.strategy;

import java.util.Arrays;

public class StrategyPattern {
    public static void main(String[] args) {

        StrategyClient c = new StrategyClient();

        int[] arr0 = {1, 3, 2, 1};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr0);

        int[] arr1 = {11, 3, 100, 1, 8, 26, 46};
        c.setStrategy(new InsertingSort());
        c.executeStrategy(arr1);

        int[] arr2 = {12, 7, -10, 1, 8, 425, 31};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr2);

    }
}

class StrategyClient {
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

interface Sorting {
    void sort(int[] arr);
}

class BubbleSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка пузырьком");
        System.out.println("до: \t" + Arrays.toString(arr));
        for (int barier = arr.length - 1; barier >= 0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        System.out.println("после: \t" + Arrays.toString(arr));
    }
}

class SelectionSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка выборками");
        System.out.println("до: \t" + Arrays.toString(arr));
        for (int barier = 0; barier < arr.length - 1; barier++) {
            for (int i = barier + 1; i < arr.length; i++) {
                if (arr[i] < arr[barier]) {
                    int tmp = arr[i];
                    arr[i] = arr[barier];
                    arr[barier] = tmp;
                }
            }
        }
        System.out.println("после: \t" + Arrays.toString(arr));
    }
}

class InsertingSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка вставками");
        System.out.println("до: \t" + Arrays.toString(arr));
        for (int barier = 1; barier < arr.length; barier++) {
            int index = barier;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                int tmp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = tmp;
                index--;

            }
        }
        System.out.println("после: \t" + Arrays.toString(arr));
    }
}
