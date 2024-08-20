import java.util.*;

public class GraphStructure {
    // Number of nodes
    static int length;
    // Designated begining Node of list
    Node start;
    // Queue list of all nodes in the model
    static Queue<Node> nodeList = new LinkedList<Node>();
    // Initialize Matrix Structure
    static int[][] Matrix= {};

    static class Node {
        String value;
        // lists of nodes connected to this node
        ArrayList<Node> neighborList = new ArrayList<Node>();
        boolean visited;
        int position = 0;

        Node(String data){
            value = data;
            visited = false;
            position = length;
        }
    }

    // Add Node to Queue list and assign them a position
    public GraphStructure AddtoList(GraphStructure list, Node data){
        if(list.start == null){
            list.start = data;
            nodeList.offer(data);
            data.position = 0;
        }
        else {
            nodeList.offer(data);
            data.position = length;
        }
        length++;
        return list;
    }

    // Attach 2 nodes together using neighborList
    public static GraphStructure AttachNode(GraphStructure list, Node a, Node b){
        boolean found = false;
        for (int i = 0; i<a.neighborList.size();i++){
            Node temp = a.neighborList.get(i);
            //found b in neighboreList of a
            if (temp == b){
                found = true;
                break;
            }
            else{}
        }
        // if no connection exist add connection
        if (found == false){
            a.neighborList.add(b);
            b.neighborList.add(a);
        }
        //do not attach, node are already attached to each other
        else{
        }
        return list;
    }

    // Print the Adjancency List Structure of each node in the Queue List
    public static void AdjancencyList(GraphStructure list){
        Queue Nodes = new LinkedList<>(list.nodeList);
        while (!Nodes.isEmpty()){
            Node a = (Node) Nodes.poll();
            System.out.println("Node:"+a.value);
            System.out.println("Connected To:");
            for(int i = 0; i< a.neighborList.size();i++){
                Node b = a.neighborList.get(i);
                System.out.println("-"+ b.value + " ");
            }
        }
    }

    // Create and print the Adjacency Matrix Structure
    public static void MatrixList(GraphStructure list){
        Queue Nodes = new LinkedList<>(list.nodeList);
        //create array with x size of queue
        int tempArray[][] = new int[length][length];
        for (int i = 0; i < nodeList.size(); i++){
            Node temp = (Node) Nodes.poll();
            for(int j=0; j < temp.neighborList.size(); j++){
                Node tempneighbore = temp.neighborList.get(j);
                if (tempneighbore != null){
                    // if there is a connection assign 1
                    tempArray[i][temp.neighborList.get(j).position] = 1;
                } 
                else{
                    // if there is no connection assign 0
                    tempArray[i][temp.neighborList.get(j).position] = 0;
                }
            }
        }
        // replace Matrix with tempArray
        Matrix = tempArray;
        // print the Matrix Structure
        list.printMatrix();
    }

    // print the Matrix Structure
    public void printMatrix(){
        // print X axis
        Queue NodesList = new LinkedList<>(nodeList);
        System.out.print("   ");
        while (!NodesList.isEmpty()){
            Node temp = (Node) NodesList.poll();
            System.out.print(temp.value+" ");
        }
        System.out.println();
        Queue NodesList2 = new LinkedList<>(nodeList);
        for(int i=0;i < length;i++){
            // print Y axis
            Node temp2 = (Node) NodesList2.poll();
            System.out.print(temp2.value+"| ");
            for (int j=0;j< length; j++){
                // print connection
                System.out.print(Matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        // Initialize Class
        GraphStructure Tree = new GraphStructure();
        // Create Nodes
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        // Add node to nodeList
        Tree.AddtoList(Tree, A);
        System.out.println("A position: "+ A.position);
        Tree.AddtoList(Tree, B);
        System.out.println("B position: "+ B.position);
        Tree.AddtoList(Tree, C);
        System.out.println("C position: "+ C.position);
        Tree.AddtoList(Tree, D);
        System.out.println("D position: "+ D.position);
        Tree.AddtoList(Tree, E);
        System.out.println("E position: "+ E.position);
        System.out.println();

        // Attach Nodes to other Nodes
        GraphStructure.AttachNode(Tree, A , C);
        GraphStructure.AttachNode(Tree, A , B);
        GraphStructure.AttachNode(Tree, B , C);
        GraphStructure.AttachNode(Tree, D , E);
        GraphStructure.AttachNode(Tree, E , A);

        // Create Structure and print
        System.out.println("Adjancency List Structure: ");
        Tree.AdjancencyList(Tree);
        System.out.println();

        System.out.println("Matrix List Structure: ");
        System.out.println("0 = not connected; 1 = is connected");
        Tree.MatrixList(Tree);
    }
}
