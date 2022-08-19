class Start {
    public static void main(String[] data) {
        Block tail = Chain.build(3, 5, 8, 2, 7); 
        // System.out.println(tail.value);   // 7
        
        // Write code to print array every block from the chain
        for (Block current = tail; current != null; current = current.back) {
            System.out.print(" " + current.value);
        }
        
        System.out.println("");
        // Write code to find the maximum block value
        int m = tail.value;
        for (Block b = tail; b != null; b = b.back) {
            if (b.value > m) {
                m = b.value;
            }
        }
        System.out.println("The maximum value in the chain is " + m);
        
    }
}

class Chain {
    static Block build(int ... data) {
        Block newly = null;
        for (int i = 0; i < data.length; i++) {
            Block x = new Block();
            x.value = data[i];
            x.back = newly;
            newly = x;
        }
        return newly;
    }

}

class Block {
    Block back;
    int value;
    String name;
    double salary;
}

class Node {
    int value;
    Node next;
}