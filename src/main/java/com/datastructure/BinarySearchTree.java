package com.datastructure;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(){
        this.root=new Node();
    }

    public BinarySearchTree(int key){
        this.root= new Node(key);
    }

    public void insert(int key){
        Node x=this.root;
        Node y=null;
         while (x!=null) {
             y = x;
             if (key < x.key)
                 x = x.left;
             else x = x.right;
         }
         if(y==null) {
             this.root = new Node(key);
         }else if(key < y.key) {
             y.left = new Node(key);
             y.left.p=y.left;
         }
         else {
             y.right= new Node(key);
             y.right.p=y.right;
         }
    }

    public Node get(int key){
        Node x=this.root;
        while (x!=null && key!=x.key){
            if(key<x.key)
                x=x.left;
            else x=x.right;
        }
            return x;
    }

    public void getAll(Node node){
        Node x=node;
        if(x!=null)
            getAll(x.left);
        System.out.println(x);
         getAll(x.right);
    }

    public boolean contains(int key){
        return get(key)!=null;
    }
    
    public class Node{
        int key;
        Node p;
        Node left;
        Node right;

        Node(int key){
            this.key=key;
            this.p=null;
            this.left=null;
            this.right=null;
        }

        Node(){
            this.key=0;
            this.p=null;
            this.left=null;
            this.right=null;
        }

        @Override
        public String   toString() {
            System.out.println(this.key);
            return null;
        }
    }
}
