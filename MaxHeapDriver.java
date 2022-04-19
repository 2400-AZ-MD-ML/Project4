package Project4;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class MaxHeapDriver {
    public static void main(String[] args) throws IOException, FileNotFoundException{

        //relative path 
        File file = new File("Project4\\data_sorted.txt"); //open file to read from and create heap
        Scanner scan = new Scanner(file);
        Integer[] heapData = new Integer[100];
        MaxHeap<Integer> iter = new MaxHeap<>(101);

        // loop to iterate & print through integers in data_sorted.txt
        int i = 0;
        while(scan.hasNextInt()){
            int next = scan.nextInt();
            iter.add(next);
            heapData[i++] = next;
        }
        System.out.println();
        for(int index =0; index<10; index++){
            iter.removeMax();
        }
        for(int index=1; index<=10; index++){
           System.out.print(iter.get(index) + " ");
        }
        // MaxHeap<Integer> smart = new MaxHeap<>(heapData);
        // for(int index = 1; index<=10; index++){
        //    System.out.print(smart.get(index) + " ");
        // }
    
        System.out.println();
        System.out.println(iter.getSwaps());
        
        scan.close();

        File output = new File("Project4\\Output.txt"); //file to hold output data
        FileWriter fw = new FileWriter(output);

        //building heap using sequential insertions
        MaxHeap<Integer> sequential = new MaxHeap<>(101);
        for(int index = 0; index < heapData.length; index++){
            int next = heapData[index];
            sequential.add(next);
        }
        //output first 10 integers of array
        fw.write("Heap built using sequential insertions: ");
        for(int index = 1; index <= 10; index++){
            String input = Integer.toString(sequential.get(index));
            fw.write(input + ", ");
        }
        fw.write("...");
        //output number of swaps
        String swaps1 = Integer.toString(sequential.getSwaps());
        fw.write("\nNumber of swaps in the heap creation: " + swaps1);
        //perform 10 removals
        for(int index = 1; index <= 10; index++){
            sequential.removeMax();
        }
        //output first 10 integers in array after removal
        fw.write("\nHeap after 10 removals: "); 
        for(int index = 1; index <= 10; index++){
            String input = Integer.toString(sequential.get(index));
            fw.write(input + ", ");
        }
        fw.write("...\n");
        //building heap using optimal method
        MaxHeap<Integer> smart = new MaxHeap<>(heapData);
        //output first 10 integers of array
        fw.write("\nHeap built using optimal method: ");
        for(int index = 1; index<= 10; index++){
            String input = Integer.toString(smart.get(index));
            fw.write(input + ", ");
        }
        fw.write("...");
        //output number of swaps
        String swaps2 = Integer.toString(smart.getSwaps());
        fw.write("\nNumber of swaps in the heap creation: " + swaps2);
        for(int index = 1; index <= 10; index++){ //perform 10 removals
            smart.removeMax();
        }
        //output first 10 integers in array after removal
        fw.write("\nHeap after 10 removals: ");
        for(int index = 1; index <= 10; index++){
            String input = Integer.toString(smart.get(index));
            fw.write(input + ", ");
        }
        fw.write("...");
        fw.close();
    }
}
