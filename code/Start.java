class Start {
    public static void main(String ... data) {
        int[] a = { 3, 5, 7, 6, 9, 2, 4, 1 };
        java.util.Arrays.sort(a);
        Element root = Tree.create(a);  // This is root node
        // System.out.println(root.value);
        
        // Write code to find the maximum value in the given binary tree
        // int m = Tree.findMax(root);
        // System.out.println(m);
        
        // Write code to find the maximum value in the given binary search tree
        // using non-recursive
        Element e = root;
        for ( ; e.right != null; e = e.right) {
            
        }
        System.out.println(e.value);
        
        // print everything in the right path
        // for (Element e = root; e != null; e = e.right) {
        //    System.out.println(e.value); // 4 6 7
        // }
        
    }
}

class Tree {
    
    static int findMaxBinarySearchTree (Element current) {
        
        return 0;
    }
    
    static int findMax(Element current) {
        if (current == null) return 0;
        int a = findMax(current.left);
        int b = findMax(current.right);
        int c = current.value;
        
        if (a >= b && a >= c) return a;
        if (b >= a && b >= c) return b;
        return c;
    }
    
    static Element create(int[] data) {
        return create(data, 0, data.length - 1);
    }
    
    static Element create(int[] data, int left, int right) {
        if (left > right) return null;  // no element
        int mid = (left + right) / 2;   // Divide and conquer
        
        Element e = new Element();
        e.left = create(data, left, mid - 1);
        e.right = create(data, mid + 1, right);
        e.value = data[mid];
        return e;
    }
}

class Element {
    int value;
    Element left;
    Element right;
    Element middle;
}