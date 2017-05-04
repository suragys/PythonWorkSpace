import java.io.*;
import java.util.*;
/********************************************************
 * CODE INSTRUCTIONS:                                   *
 * 1) The method findInOrderSuccessor you're asked      *
 *    to implement is located at line 36.               *
 * 2) Use the helper code below to implement it.        *
 * 3) In a nutshell, the helper code allows you to      *
 *    to build a Binary Search Tree.                    *
 * 4) Jump to line 103 to see an example for how the    *
 *    helper code is used to test findInOrderSuccessor. *
 ********************************************************/
class Solution {

    static class Node {

        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    static class BinarySearchTree {

        Node root;

// Strategy:
//  1. If we have a right subtree, then we look for a leftmost node
//    in our right subtree.
//  2. If we don't have a RST, then
//    2.1 If we are the RST of parent node, then we are looking
//        for the first parent node in the hierarchy which is the
//        LST of its parent
//    2.2 If we are the LST of parent node, then we are looking
//        for the parent

        Node findInOrderSuccessor(Node inputNode) {
            if (inputNode == null) {
                return null;
            }

            if (inputNode.right == null) {
//  2
                if (inputNode.parent == null) {
                    return null;
                }

                if (inputNode == inputNode.parent.left) {
//  2.2
                    return inputNode.parent;
                } else {
//  2.1
                    Node node = inputNode;
                    boolean found = false;

                    while (node.parent != null) {
                        node = node.parent;

                        if (node.parent != null && node == node.parent.left) {
                            node = node.parent;
                            found = true;
                            break;
                        }
                    }

                    if (found) {
                        return node;
                    }
                }
            } else {
//  1
                Node node = inputNode.right;

                while (node.left != null) {
                    node = node.left;
                }

                return node;
            }

            return null;
        }

        //  Given a binary search tree and a number, inserts a new node
        //  with the given number in the correct place in the tree
        void insert(int key) {

// 1. If the tree is empty, create the root
            if(this.root == null) {
                this.root = new Node(key);
                return;
            }

// 2) Otherwise, create a node with the key
//    and traverse down the tree to find where to
//    to insert the new node
            Node currentNode = this.root;
            Node newNode = new Node(key);

            while(currentNode != null) {
                if(key < currentNode.key) {
                    if(currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if(currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }

        // Return a reference to a node in the BST by its key.
        // Use this method when you need a node to test your
        // findInOrderSuccessor method on
        Node getNodeByKey(int key) {
            Node currentNode = this.root;

            while(currentNode != null) {
                if(key == currentNode.key) {
                    return currentNode;
                }

                if(key < currentNode.key) {
                    currentNode = currentNode.left;
                } else {
                    currentNode = currentNode.right;
                }
            }

            return null;
        }
    }

    /***********************************************
     * Driver program to test findInOrderSuccessor *
     ***********************************************/

    public static void main(String[] args) {

        Node test = null, succ = null;

// Create a Binary Search Tree
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(9);
        tree.insert(25);
        tree.insert(5);
        tree.insert(12);
        tree.insert(11);
        tree.insert(14);

// Get a reference to the node whose key is 9
        test = tree.getNodeByKey(11);

// Find the in order successor of test
        succ = tree.findInOrderSuccessor(test);

// Print the key of the successor node
        if (succ != null) {
            System.out.println("Inorder successor of " + test.key +
                    " is " + succ.key);
        } else {
            System.out.println("Inorder successor does not exist");
        }
    }
}