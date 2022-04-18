package Project4;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MaxHeapDriver {
    public static void main(String[] args) throws FileNotFoundException{

        //relative path 
        File file = new File("data_sorted.txt"); //open file to read from and create heap
        Scanner scan = new Scanner(file);
        Integer[] heapData = new Integer[100];
        MaxHeap<Integer> iter = new MaxHeap<>(101);

        // loop to iterate & print through integers in data_sorted.txt
        int i = 0;
        while(scan.hasNextInt()){
            int next = scan.nextInt();
            System.out.print(next + " ");
            iter.add(next);
            heapData[i++] = next;
        }
        
        System.out.println();

        // for loop below used for writing first 10 integers to new file
        /*
        for(int index=1; index<=10; index++){
            System.out.print(iter.get(index) + " ");
        }
        */

        MaxHeap<Integer> smart = new MaxHeap<>(heapData);
        for(int index = 1; index<=10; index++){
           System.out.print(smart.get(index) + " ");
        }

        System.out.println();
        System.out.println(iter.getSwaps());
        
        scan.close();
        }
}
