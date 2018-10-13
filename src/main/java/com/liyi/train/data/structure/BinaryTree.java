package com.liyi.train.data.structure;

import java.util.Stack;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-12 10:28
 */
public class BinaryTree {
    private TreeNode root = null;

    public BinaryTree () {
        root = new TreeNode(1, "A");
    }

    public void createBinaryTree () {
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;
    }

    public class TreeNode {
        private int index;
        private String data;
        private TreeNode leftChild;
        private TreeNode rightChild;


        public int getIndex () {
            return index;
        }

        public void setIndex (int index) {
            this.index = index;
        }

        public String getData () {
            return data;
        }

        public void setData (String data) {
            this.data = data;
        }

        public TreeNode (int index, String data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    /**
     * 非迭代中序遍历
     *
     * @param node
     */
    public void nonRecMidOrder (TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
//        stack.push(node);
        TreeNode n = node;
        while (n != null || !stack.isEmpty()) {
            if (n != null) {
                stack.push(n);
                n = n.leftChild;
            } else {
                TreeNode pop = stack.pop();
                System.out.println(pop.getData());
                n = pop.rightChild;
            }
        }
    }

    /**
     * 非迭代后序遍历
     *
     * @param node
     */
    public void nonRecPostOrder (TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        //pre:上次pop的对象
        TreeNode pre = null;
        TreeNode current = null;
        while (!stack.isEmpty()) {
            current = stack.peek();
            boolean hasChildren = current.leftChild == null && current.rightChild == null;
            boolean preIsChildren = pre != null && (pre == current.leftChild || pre == current.rightChild);
            if (hasChildren || preIsChildren) {
                System.out.println(current.getData());
                pre = current;
                stack.pop();
            } else {
                if (current.rightChild != null) {
                    stack.push(current.rightChild);
                }
                if (current.leftChild != null) {
                    stack.push(current.leftChild);
                }
            }
        }
    }

    public static void main (String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();

//        binaryTree.nonRecMidOrder(binaryTree.root);
        binaryTree.nonRecPostOrder(binaryTree.root);
    }
}

