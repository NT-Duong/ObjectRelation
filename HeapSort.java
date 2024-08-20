import java.util.ArrayList;

public class HeapSort {
    static int length;
    public static int counter;
    static ArrayList<Integer> HeapTree;

    public void Create(String name){
        HeapTree = new ArrayList<Integer>();
    }

    public static HeapSort Add(HeapSort list, int data){
        HeapTree.add(data);
        length++;
        int dataindex = HeapTree.size()-1;
        int temp= (int)Math.ceil(((double)dataindex/2))-1;

        // bubble highest number to the top
        while (dataindex > 0 && HeapTree.get(dataindex) > HeapTree.get(temp)){
            int tempvalue = HeapTree.get(temp);
            // swap dataindex with temp
            HeapTree.set(dataindex, tempvalue);
            HeapTree.set(temp, data);
            dataindex = temp;
            temp= (int)Math.ceil(((double)dataindex/2))-1;
        }
        return list;
    }

    // in-place sort method
    public static HeapSort IPSort(HeapSort list){
        int tempvalue;
        for (int i = 0; 0< HeapTree.size()-i-1; i++){
            tempvalue = HeapTree.get(0);
            // move each value up in the array
            for (int j = 0; j<HeapTree.size()-i-1; j++){
                HeapTree.set(j,HeapTree.get(j+1));
            }
            // set last value with tempvalue
            HeapTree.set(HeapTree.size()-i-1, tempvalue);
            //time tracker
            counter++;
        }
        return list;
    }

    // Selection sort method
    public static HeapSort SelectionSort(HeapSort list){
        ArrayList<Integer> temparray = new ArrayList<Integer>();
        // find the largest value
        int smallvalue=0;
        int j = 0;
        // cycle through HeapTree array until there are no more elements
        while (HeapTree.size()>0){
            smallvalue = HeapTree.get(0);
            j = 0;
            for (int i=0; i<HeapTree.size(); i++){
                int currentvalue = HeapTree.get(i);
                if (smallvalue > currentvalue){
                    j = i;
                    smallvalue = HeapTree.get(i);
                }
                else {
                }
                //time tracker
                counter++;
            }
            //add element to temp array
            temparray.add(smallvalue);
            //remove element from HeapTree array  
            HeapTree.remove(j);
        }
        // replace HeapTree array with temparray
        HeapTree = temparray;
        return list;
    }

    // print the tree level by level
    public static void printTree(HeapSort list){
        double count = 1;
        double j = 2;
        for (int i = 0; i < HeapTree.size();i++){
            if (count % j ==0){
                System.out.println(" ");
                j=j*2;
            }
                System.out.print(HeapTree.get(i));
                System.out.print(" ");
                count++;
        }
        System.out.println("");
    }
    public static void main(String[] args) 
    {

        // create Tree
        HeapSort Tree = new HeapSort();
        // start tree array
        Tree.Create("HeapSort");
        // add to Box
        Add(Tree, 9);
        Add(Tree, 4);
        Add(Tree, 6);
        Add(Tree, 10);
        Add(Tree, 2);
        Add(Tree, 7);
        Add(Tree, 12);
        Add(Tree, 15);
        Add(Tree, 3);
        Add(Tree, 8);

        //print tree
        System.out.println("In-Place Tree Before Sorting");
        printTree(Tree);
        System.out.println();
        // in-place sort
        IPSort(Tree);
        //print tree
        System.out.println("In-Place Tree After Sorting");
        printTree(Tree);
        System.out.println("Loop Counter:"+ Tree.counter);
        System.out.println();

        // create new HeapTree class
        HeapSort Tree2 = new HeapSort();
        // start tree2 array
        Tree2.Create("HeapSort");

        // add to tree
        Add(Tree2, 12);
        Add(Tree2, 14);
        Add(Tree2, 1);
        Add(Tree2, 6);
        Add(Tree2, 2);
        Add(Tree2, 21);
        Add(Tree2, 13);
        Add(Tree2, 15);
        Add(Tree2, 8);
        Add(Tree2, 9);

        //print Tree2
        System.out.println("Selection Sort Tree Before Sorting");
        printTree(Tree2);
        System.out.println();
        // Selection Sort
        SelectionSort(Tree2);
        //print Box
        System.out.println("Selection Sort Tree After Sorting");
        printTree(Tree2);
        System.out.println("Loop Counter:"+ Tree2.counter);
        System.out.println();
    }
}
