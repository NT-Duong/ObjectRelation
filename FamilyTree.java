import java.util.*;

public class FamilyTree {
    String name;
    public static int length = 0; //number of nodes
    List <FamilyTree> children;
    public FamilyTree parent;
    // Constructor
    FamilyTree(String name) { 
        this.name = name;
        children = new ArrayList<>();
    }
    // method to add child node to parent
    public FamilyTree addChild(FamilyTree node){
        children.add(node);
        node.parent = this;
        return this;
    }   

    //print Tree
    private static void printFamilyTree(FamilyTree root){
        int dash =0;
        // if tree does not exist, exit
        if(root == null) {
            return;
        }
        // add each node to a queue starting at root
        Queue<FamilyTree> queue = new LinkedList<>();
        queue.offer(root);
        // print the nodes in the queue
        while(!queue.isEmpty()) {
            int len = queue.size();
            //print dash to denote level
            for (int j =0;j<dash; j++){
                System.out.print("-");
            }
            for(int i=0; i<len; i++) {
                FamilyTree node = queue.poll();
                assert node != null;
                System.out.print(node.name + " ");
                // add any children of the node to the queue
                for (FamilyTree item : node.children) {
                    queue.offer(item);
                }
            }
            dash++;
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        // create FamilyTree nodes
        FamilyTree root = new FamilyTree("Ben");
        System.out.println("Added Ben as root");
        
        FamilyTree mocha = new FamilyTree("Mocha");
        FamilyTree jess = new FamilyTree("Jess");
        FamilyTree jones = new FamilyTree("Jones");
        FamilyTree ace = new FamilyTree("Ace");
        FamilyTree tom = new FamilyTree("Tom");
        FamilyTree ruth = new FamilyTree("Ruth");
        FamilyTree tim = new FamilyTree("Tim");
        FamilyTree dave = new FamilyTree("Dave");

        // add each node to the tree attached to a parent
        System.out.println();
        root.addChild(mocha);
        System.out.println("Added Mocha as child of Ben at index 0");
        root.addChild(jess);
        System.out.println("Added Jess as child of Ben at index 1");
        mocha.addChild(jones);
        System.out.println("Added Jones as child of Mocha at index 0");
        mocha.addChild(ace);
        System.out.println("Added Ace as child of Mocha at index 0");
        jess.addChild(tom);
        System.out.println("Added Tom as child of Jess at index 0");
        jess.addChild(ruth);
        System.out.println("Added Ruth as child of Jess at index 1");
        jess.addChild(tim);
        System.out.println("Added Tim as child of Jess at index 2");
        tim.addChild(dave);
        System.out.println("Added Dave as child of Tim at index 0");

        System.out.println();
        System.out.println("Family Tree Structure");
        // print the whole tree starting at root
        printFamilyTree(root);
        
    }
}