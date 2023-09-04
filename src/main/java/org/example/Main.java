package org.example;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> listIntegers1 = new Random().ints(100_000, 1, 100).boxed().collect(Collectors.toList());
        List<Integer> listIntegers2 = new Random().ints(100_000, 1, 100).boxed().collect(Collectors.toList());
        List<Integer> listIntegers3 = new Random().ints(100_000, 1, 100).boxed().collect(Collectors.toList());

        long start1 = System.currentTimeMillis();
        sortBubble(listIntegers1);
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();
        sortSelection(listIntegers2);
        System.out.println(System.currentTimeMillis() - start2);


        long start3 = System.currentTimeMillis();
        sortInsertion(listIntegers3);
        System.out.println(System.currentTimeMillis() - start3);


    }

    private static void swapElements(List<Integer> list, int indexA, int indexB) {
        int tmp = list.get(indexA);
        list.set(indexA, list.get(indexB));
        list.set(indexB, tmp);
    }

    public static void sortBubble(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    swapElements(list, j, j + 1);
                }
            }
        }
    }

    public static void sortSelection(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(min)) {
                    min = j;
                }
            }
            swapElements(list, i, min);
        }
    }

    public static void sortInsertion(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i);
            int j = i;
            while (j > 0 && list.get(j - 1) >= temp) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, temp);
        }
    }
}