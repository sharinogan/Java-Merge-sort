class Start {
    public static void main(String ... data) {
        int[] a = { 8, 5, 4, 2, 7, 1, 9, 3 };
        Node head = Link.create(a);
        Node second = Link.cutMiddle(head);
        System.out.println("First : ");
        Link.print(head);
        System.out.println("Second : ");
        Link.print(second);
    }
}

class Link {
    
    static Node cutMiddle(Node start) {
        if(start == null) return null;            // No data
        if(start.next == null) return null;       // One Node
        
        Node rabbit = start, turtle = start;
        while(rabbit != null && rabbit.next != null && rabbit.next.next != null) {
            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }
        Node result = turtle.next;
        turtle.next = null;        // null
        return result;
    }
    
    // Linked list
    static Node create(int[] data) {
        Node head = null, tail = null;
        for (int i = 0; i < data.length; i++){
            Node x = new Node();
            x.value = data[i];
            if (head == null) {
                head = x;
                tail = x;
            } else {
                tail.next = x;
                tail = tail.next;  // tail++
            }
        }
        return head;
    }
    
    static void print(Node start) {
        for (Node e = start; e != null; e = e.next) {
            System.out.println(e.value);
        }
    }
}

class Node {
    int value;
    Node next;
}
