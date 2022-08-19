class Start {
    public static void main(String ... data) {
        int[] a = { 8, 5, 4, 2, 7, 1, 9, 3 };
        Node head = Link.create(a);
        head = Link.sort(head);
        Link.print(head);
    }
}

class Link {
    
    static Node sort(Node start) {
        if(start == null) return null;             // Empty List
        if(start.next == null) return start;       // One Node
        
        Node second = cutMiddle(start);
        start = sort(start);
        second = sort(second);
        return merge(start, second);
    }
    
    static Node merge(Node a, Node b) {
        if (a == null && b == null) return null;
        if (a != null && b == null) return a;
        if (a == null && b != null) return b;
        if (a.value < b.value) {
            a.next = merge(a.next, b);
            return a;
        } else {
            b.next = merge(a, b.next);
            return b;
        }
    }
    
    static Node cutMiddle(Node start) {
        if(start == null) return null;            // No data
        if(start.next == null) return start;       // One Node
        
        Node rabbit = start, turtle = start;
        while(rabbit != null && rabbit.next != null && rabbit.next.next != null) {
            rabbit = rabbit.next.next;
            turtle = turtle.next;
        }
        Node result = turtle.next;
        turtle.next = null;        // cut
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
