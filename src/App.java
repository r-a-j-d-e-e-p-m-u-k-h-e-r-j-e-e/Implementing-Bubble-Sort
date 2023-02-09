import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App{
    public static int[] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length-1; i++ ) {
            if (array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void bubbleSort(int a[]) {
        for (int i = a.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++ ) {
                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void writeArraytoFile( int[] array, String filename) {
        try(FileWriter fileWriter = new FileWriter(filename)) {
            for(int i = 0; i < array.length; i++) {
                    fileWriter.write(array[i] + "\n");
            }
        } catch(IOException e){

        }
    }

    public static int[] readFileToArray(String filename) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        try (File file = new File(filename)){
        Scanner scanner = new Scanner(file) ;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                arrayList.add(Integer.parseInt(s));
            }
        } catch (IOException e) {
        }

        int[] array = new int[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }  

    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the array length: ");
        int arrayLength = scanner.nextInt();
        int[] array = createRandomArray(arrayLength);
        writeArraytoFile(array, "temp.txt");
        System.out.println("Is the array sorted?\n" + isSorted(array));
        bubbleSort(array);
        System.out.println("Is the array sorted?\n" + isSorted(array));

    }
}