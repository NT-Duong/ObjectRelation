public class DoubleLinkedList {
    Node head; // head of list
    Node end; // end of list
    Node middle;
    static int length = 0; //number of nodes
    // Linked list Node.
    static class Node { 
    
        int data; 
        Node next; 
        Node last;
    
        // Constructor 
        Node(int d) 
        { 
            data = d; 
            next = null; 
            last = null;
        }
    }

    public static DoubleLinkedList add(DoubleLinkedList list, int data) 
    { 
        Node new_node = new Node(data);
        // If the Linked List is empty,
        // then make the new node as head 
        if (list.head == null) { 
            list.head = new_node;
            list.end = new_node;
            length ++;
        }
        else { 
            Node current = list.head;
            // If length is 1 check if new node is bigger
            if (length == 1){
                current = list.head;
                // if new node is bigger then list head put it first
                if(current.data < new_node.data){
                    list.head = new_node;
                    new_node.next = current;
                    current.last = list.head;
                    list.end = current;
                    list.middle = current;
                }
                // if new node is smaller then list head put it last
                else {
                    list.head.next = new_node;
                    new_node.last = list.head;
                    list.end = new_node;
                    list.middle = new_node;
                }
                length ++;
            }
            // Organize list by highest grade to lowest grade
            // If length is bigger then 1
            else{
            // Go down the list and Compare new node to each value in linked list until a value is smaller then new node
            int counter = 0;
            while (current.data > new_node.data) {
                    current = current.next;
                    counter ++;
            }
            if (current.last == null){
                new_node.next = current;
                current.last = new_node;
                list.head = new_node;
            }
            // If new node is bigger then head put it first
            else if ((current.data == new_node.data && current.last != null) || current.data < new_node.data){
                //insert new node between last and current
                new_node.last = current.last;
                current.last.next = new_node;
                new_node.next = current;
                current.last = new_node;
            }
            // If it is the end of the list, put new node at the end
            else{
                    current.next = new_node;
                    new_node.last = current;
                    list.end = new_node;
                }
            length ++;
            // move list middle depending on where the insert is
            if (length == 3){
                list.middle = list.head.next;
            }
            else if (counter > length/2 && length%2 != 0 ){
                list.middle = list.middle.next;
            }
            else if (counter < length/2 && length%2 ==0){

            }
            else{
                list.middle = list.middle.last;
            }
            // check if length is more then 15
            if (length > 15){
                // if length is more then 15 drop last node
                current = list.head;
                for (int i = 0; i < length-2; i++){
                    if(i== length/2){
                        list.middle = current;
                    }
                    current = current.next;
                }
                list.end = current;
                current.next = null;
                length --;
            }
        }
        } 
        // Return the list by head 
        return list; 
    }
    public static DoubleLinkedList remove(DoubleLinkedList list, int data) 
    {
        Node remove_node = new Node(data);
        // List is 0
        if (length == 0){
            System.out.println("The list is empty");
        }
        // List is equal to 1
        else if (length == 1){
            list.head = null;
        }
        // List is bigger than 1
        else {
            // remove_node is smaller than middle
            if (remove_node.data < list.middle.data){
                Node current = list.end;
                for(int i=0; i < (length/2)+1;i++){
                    if (remove_node.data == current.data){
                        // If remove_node is the last item
                        if (current.next == null){
                            list.end = current.last;
                            list.middle = list.middle.last;
                            current.last.next = null;
                            current.last = null;
                            length--;
                            break;
                        }
                        // remove_node is not the last item
                        else{
                            current.last.next = current.next;
                            current.next.last = current.last;
                            current.last = null;
                            current.next = null;
                            length--;
                            break;
                        }
                    }
                    // Item is not on the half end of the list
                    else if (i> (length/2)+1){
                        System.out.println("The value does not exist on the list.");
                    }
                    // go to the next item
                    else{
                        current = current.last;
                    }
                }
            }
            // remove_node bigger than middle
            else{
                Node current = list.head;
                for(int i=0; i < (length/2)+1;i++){
                    if (remove_node.data == current.data){
                        // If remove_node is the first item
                        if (current.last == null){
                            list.head = current.next;
                            list.middle = list.middle.next;
                            list.head.last = null;
                            current.next = null;
                            length--;
                            break;
                        }
                        // remove_node is not the first item
                        else{
                            current.last.next = current.next;
                            current.next.last = current.last;
                            current.last = null;
                            current.next = null;
                            length--;
                            break;
                        }
                    }
                    // Item is not on the half begining of the list
                    else if (i > (length/2)+1){
                        System.out.println("The value does not exist on the list.");
                    }
                    // go to the next item
                    else{
                        current = current.next;
                    }
                }
            }
        }
        return list; 
    }

    public static void printList(DoubleLinkedList list) 
    { 
        Node currNode = list.head; 
        System.out.print("Double Linked List: "); 
     
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

    public static void main(String[] args) 
    { 
        // Start with the empty list. //
        DoubleLinkedList list = new DoubleLinkedList();

        // Add to list
        list = add(list, 1); 
        list = add(list, 2);
        list = add(list, 4);
        // Add number smaller then previous number
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

        //Print list
        printList(list);
        System.out.println("Middle: " + list.middle.data);

        list = add(list, 17);

        //Print list
        printList(list); 
        System.out.println("Middle: " + list.middle.data);

        // Add another duplicate number already on the list
        list = add(list, 8);

        //Print list
        printList(list); 
        System.out.println("Middle: " + list.middle.data);

        // Remove a value on the list
        list = remove(list, 8);

        //Print list
        printList(list); 
        System.out.println("Middle: " + list.middle.data);
    }
}
