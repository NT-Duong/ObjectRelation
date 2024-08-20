
public class SingleLinkedList { 
    Node head; // head of list
    static int length = 0; //number of nodes
    // Linked list Node.
    static class Node { 
    
        int data; 
        Node next; 
    
        // Constructor 
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    } 
    
    // Method to add a grade to the list
    public static SingleLinkedList add(SingleLinkedList list, int data) 
    { 
        Node new_node = new Node(data);
        // If the Linked List is empty,
        // then make the new node as head 
        if (list.head == null) { 
            list.head = new_node;
            length ++;
        }
        else { 
            Node current = list.head;
            Node last = null;
            // If length is 1 check if new node is bigger
            if (length == 1){
                current = list.head;
                // if new node is bigger then list head put it first
                if(current.data < new_node.data){
                    list.head = new_node;
                    new_node.next = current;
                    last = new_node;
                }
                // if new node is smaller then list head put it last
                else {
                    list.head.next = new_node;
                    last = list.head;
                    current = new_node;
                }
                length ++;
            }
            // Organize list by highest grade to lowest grade
            // If length is bigger then 1
            else{
            // Go down the list and Compare new node to each value in linked list until a value is smaller then new node
            while (current.data >= new_node.data) {
                    last = current;
                    current = current.next;
            }
            // If new node is bigger than current, put it first
            if (current.data <= new_node.data && last != null){
                //insert new node between last and current
                last.next = new_node;
                new_node.next = current;
            }
            else if (last == null){
                list.head = new_node;
                list.head.next = current;
            }
            // If it is the end of the list, put new node at the end
            else{
                    current.next = new_node; 
                }
            length ++;
            // check if length is more then 15
            if (length > 15){
                // if length is more then 15 drop last node
                current = list.head;
                for (int i = 0; i < length-2; i++){
                    current = current.next;
                }
                current.next = null;
                length --;
            }
        }
        } 
        // Return the list by head 
        return list; 
    } 
    
    // Method to remove a grade if it exist on the list
    public static SingleLinkedList remove(SingleLinkedList list, int data)
    {
        // If list is empty return empty message
        if (length == 0){
            System.out.println("The list is empty");
        }
        // If list is 1 remove list head
        else if (length == 1){
            list.head = null;
            length--;
        }
        // Scroll throught list to see if any grades are the same as data
        else {
            Node current = list.head;
            Node last = null;
            Node remove_node = new Node(data);
            while(remove_node.data != current.data){
                if(current.next !=null){
                last = current;
                current = current.next;
                }
                else {
                    last = null;
                    break;
                }
            }
            // If matched data is list head change list head to 2nd option
            if (remove_node.data == current.data && last == null){
                list.head = current.next;
                current.next = null;
                length --;
            }
            // If matched data is on list, remove from list
            else if (last == null){
                System.out.println("No match found on list.");
            }
            else{
                // Scroll through list to see if data matches
                while (remove_node.data != current.data){
                    last = current;
                    current = current.next;
                }
                // Found match on list
                if (remove_node.data == current.data){
                    last.next = current.next;
                    current.next = null;
                    length --;
                }
                else {
                    System.out.println("No match found on list.");
                }
            }
        }
        
        return list;
    }
    // Method to print the LinkedList. 
    public static void printList(SingleLinkedList list) 
    { 
        Node currNode = list.head; 
        System.out.print("Single Linked List: "); 
     
        // Traverse through the List
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
            // Go to next node 
            currNode = currNode.next; 
        }
        // Print length
        System.out.println();
        System.out.println("Length of List: " + length);
    } 
     
    // Driver code 
    public static void main(String[] args) 
    { 
        // Start with the empty list. //
        SingleLinkedList list = new SingleLinkedList(); 
    
        // Add the values 
        list = add(list, 1); 
        list = add(list, 2); 
        list = add(list, 4);
        list = add(list, 3); 
        list = add(list, 5); 
        list = add(list, 6); 
        list = add(list, 7); 
        list = add(list, 8);
        list = add(list, 9);
        list = add(list, 10);
        list = add(list, 11);
        list = add(list, 12);
        list = add(list, 13);
        list = add(list, 14);
        list = add(list, 15);
        list = add(list, 16);
        list = add(list, 17);

        // Print the SingleLinkedList
        printList(list); 
        
        // remove from SingleLinkedList
        list = remove(list, 6);
        // remove non-existing number on list
        list = remove(list, 166);
        // Print the SingleLinkedList
        printList(list); 

        // Add a value already on the list
        list = add(list, 8);
        printList(list); 
    } 
}
