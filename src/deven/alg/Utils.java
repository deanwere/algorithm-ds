package deven.alg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Utils {
    public static int[] createRandomArray(boolean sort) {
        Random random = new Random();
        int arrLen = random.nextInt(10) + 3;
        int[] array = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            array[i] = random.nextInt(100);
        }

        if (sort) {
            Arrays.sort(array);
        }
        return array;
    }

    public static void displayArray(int[] array) {
        // Display array and ask user to choose one
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            if (i == array[array.length - 1]) {
                sb.append(i);
            } else {
                sb = sb.append(i + ", ");
            }
        }
        System.out.println(sb);
        System.out.println();
        System.out.println("Choose one of above number to test!");
    }

    public static int userInput() throws IOException {
        // User input one number
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String numStr = null;
        int value = 0;
        while ((numStr = stdin.readLine()) != null) {
            try {
                value = Integer.parseInt(numStr);
                break;
            } catch (NumberFormatException e) {
                continue;
            }

        }
        return value;
    }

    public static void swap(int[] array, int i, int j) {
        int iValue = array[i];
        array[i] = array[j];
        array[j] = iValue;

    }
}
