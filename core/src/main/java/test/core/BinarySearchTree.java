package test.core;

import test.core.BinarySearchTree.cnout;

public class BinarySearchTree{
	/* Class containing left and right child of current node and key value*/
   
	class cnout { 
	     int counter = 0; 
	 } 
	
	class Node {
        int key;
        Node left, right;
      public Node(int item) {
                key = item;
                left = right = null;
      }
    }
    // Root of BST
    Node root;
    // Constructor
    BinarySearchTree() { 
        root = null; 
    }
 
    // This method mainly calls insertRec()
    void insert(int key) {
        root = insertRec(root, key);
    }
     
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
 
        /* return the (unchanged) node pointer */
        return root;
    }
 
    // This method mainly calls InorderRec()
    void inorder()  {
       inorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
    int findMinValue() {
        return minValue(this.root);
    }
    int findMaxValue() {
        return maxValue(this.root);
    }
    int minValue(Node node) {
        if(node.left!= null) {
            return minValue(node.left);
        }
        return node.key; 
    }
    int maxValue(Node node) {
        if(node.right != null) {
            return maxValue(node.right);
        }
        return node.key; 
    }
    
    // method to find k-largest in bst
    void find_k_largest_value(Node node, int k, cnout c1) { 
        if (node == null || c1.counter >= k) 
            return; 
        // recurs for right
        this.find_k_largest_value(node.right, k, c1);  
        c1.counter++; 
        if (c1.counter == k) { 
            System.out.println(k + "th largest:" +  node.key); 
            return; 
        } 
        // recurs for left
        this.find_k_largest_value(node.left, k, c1);  
    } 
    // method to find k-largest in bst 
    void k_largest(int k) { 
        cnout c = new cnout(); 
        this.find_k_largest_value(this.root, k, c); 
    } 
 
    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(7);
        tree.insert(10);
        tree.insert(4);
        tree.insert(3);
        tree.insert(20);
        tree.insert(15);
// 
//        // print inorder traversal of the BST
       tree.inorder();
       
       System.out.println("Max = "+tree.findMaxValue());
       System.out.println("Min = "+tree.findMinValue());
       
       for (int k = 1; k <= 6; k++) { 
           tree.k_largest(k); 
       } 
    }
}
