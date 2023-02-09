import java.util.*;
import java.io.*;


public class BubbleSort {
    public static int[] createRandomArray(int length){
        Random random = new Random();
        int [] a = new int[length];

        for (int i=0; i < a.length; i++){
            a[i] = random.nextInt(100);
        }
        return a;
    }
    
    public static void writeArrayToFile(int[] array, String filename){
        try (FileWriter fileWriter = new FileWriter(filename)){
            for (int i=0; i < array.length; i++){
                fileWriter.write(array[i] + "\n");
            }
        }catch(IOException e){
            System.out.println("An error occured.");
        }
    }

    public static int[] readFileToArray(String filename){
        ArrayList<Integer> arrayList = new ArrayList();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String s = scanner.nextLine();
                arrayList.add(Integer.parseInt(s));
            }
            scanner.close();
        } catch (IOException e){

        }

        int[] array = new int[arrayList.size()];
        for (int i=0; i < array.length; i++){
            array[i] = arrayList.get(i);
        }
        return array;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void bubbleSort(int[] array){
        for (int j = array.length - 1; j >= 1; j--){
            for (int i=0; i < j; i++){
                if (array[i] > array[i+1]){
                swap(array, i, i+1);
                }
            }
        }
    }

    public static boolean isSorted(int[] array){
        for (int i=0; i < array.length - 1; i++){
            if (array[i] > array[i + 1])
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name to store array in: ");
        String filename = scanner.nextLine();
        

        System.out.println("Enter array length: ");
        int length = scanner.nextInt();
        int[] a = createRandomArray(length);
        writeArrayToFile(a, filename);

        System.out.println("\n" + filename + " before Bubble Sort: ");
        System.out.println(Arrays.toString(a));
        System.out.println("Sorted: " + isSorted(a));

        bubbleSort(a);
        System.out.println("\n" + filename + " after Bubble Sort: ");
        System.out.println(Arrays.toString(a));
        System.out.println("Sorted: " + isSorted(a));
        
       
        System.out.println("\nEnter file name to read array from: ");
        Scanner readFile = new Scanner(System.in);
        filename = readFile.nextLine();
        int [] array = readFileToArray(filename);
        System.out.println("\nArray from " + filename + " before Bubble Sort: " + "\n" + Arrays.toString(array));
        System.out.println("Sorted: " + isSorted(array));
        bubbleSort(array);
        System.out.println("\nArray from " + filename + " after Bubble Sort: " + "\n" + Arrays.toString(array));
        System.out.println("Sorted: " + isSorted(array));

        scanner.close();
        readFile.close();
    }  
}