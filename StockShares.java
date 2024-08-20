public class StockShares {
    Node head; // head of list
    Node end; // end of list
    static int length = 0; //number of nodes
    // Linked list Node.
    static class Node { 
    
        int amount;
        int price;
        Node next; 
        Node last;
    
        // Constructor 
        Node(int a, int p)
        { 
            amount = a;
            price = p;
            next = null; 
            last = null;
        }
    }

    public static StockShares buy(StockShares list, int amount, int price) 
    { 
        Node new_node = new Node(amount, price);
        // If the Linked List is empty,
        // then make the new node as head 
        if (list.head == null) { 
            list.head = new_node;
            list.end = new_node;
            length ++;
        }
        // put new Node at the end of the list
        else { 
            Node current = list.head;
            while (current.next != null){
                current = current.next;
            }
            current.next = new_node;
            new_node.last = current;
            list.end = current.next;
            length++;
        } 
        // Return the list by head 
        return list;
    }
    public static StockShares sell(StockShares list, int amount, int price) 
    {
        int total = 0;
        Node current = list.head;
        // List is 0
        if (length == 0){
            System.out.println("There is no stock to sell");
        }
        // List is equal to 1
        else{
            int sold_amount = 0;
            System.out.println("Sell Stock Amount: "+amount+" at $"+price+" per share"); 
            while (amount > 0){
                //If amount has more stock then current node and you have more stock available
                if(amount>current.amount & current.next!=null){
                    sold_amount=current.amount;
                    amount=amount-current.amount;
                    total += sold_amount*(price-current.price);
                    System.out.println("Stock sold: "+sold_amount);
                    System.out.println("Original Price: $"+current.price);
                    System.out.println("Capital Gain Price: $"+(price-current.price));
                    System.out.println("Total Capital Gain: $"+total);
                    sold_amount = 0;
                    // Remove empty node from list;
                    list.head=current.next;
                    current=current.next;
                    current.last.next=null;
                    current.last=null;
                    length--;
                }
                //If trying to sell more stock then you have
                else if(amount>current.amount&current.next==null){
                    sold_amount=current.amount;
                    amount=amount-current.amount;
                    total += sold_amount*(price-current.price);
                    System.out.println("Stock sold: "+sold_amount);
                    System.out.println("Original Price: $"+current.price);
                    System.out.println("Capital Gain Price: $"+(price-current.price));
                    System.out.println("Total Capital Gain: $"+total);
                    System.out.println("You have less stock then what you are trying to sell");
                    System.out.println("Number of stock that could not be sold: "+amount);
                    list.head=null;
                    length=0;
                    amount=0;
                }
                //If amount has less stock then current node 
                else{
                    current.amount = current.amount-amount;
                    sold_amount=sold_amount+amount;
                    total += sold_amount*(price-current.price);
                    System.out.println("Stock sold: "+sold_amount);
                    System.out.println("Original Price: $"+current.price);
                    System.out.println("Capital Gain Price: $"+(price-current.price));
                    System.out.println("Total Capital Gain: $"+total);
                    amount = 0;
                    if (current.amount==0 & current.next!=null){
                        list.head=current.next;
                        length--;
                    }
                    else if(current.amount== 0 & current.next==null){
                        list.head=null;
                        length=0;
                    }
                    else{}
                }
            }
        }
        return list; 
    }

    public static void printList(StockShares list) 
    { 
        Node currNode = list.head; 
        System.out.print("Stocks: "); 
     
        // Traverse through the List
        while (currNode != null) { 
            // Print the amount at current node 
            System.out.print(currNode.amount+"/$"+currNode.price+ " "); 
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
        StockShares list = new StockShares();

        // Buy stock (amount, price per share)
        buy(list, 100,20); 
        buy(list, 20,24);
        buy(list, 200,36);
        printList(list);

        //Sell stock (amount, price per share)
        sell(list,150,30);

        //Print list
        printList(list);

        //Buy 100 stock at $45
        System.out.println("Buy 100 Stock at $45 per share");
        list = buy(list, 100,45);
        printList(list);

        //Sell more stock then you have
        sell(list,300,40);
    }
}
