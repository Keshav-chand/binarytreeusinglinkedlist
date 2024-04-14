import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//import org.w3c.dom.Node;

public class binarytreeusinglist{
    static int value;
    static Scanner sc=new Scanner (System.in);
    Deque <Node> queue=new LinkedList <Node>();

    static class Node{
        int key;
        Node left;
        Node right;
    }
    static Node newNode(int data) {
        Node temp = new Node();
        temp.key=data;
        temp.left=null;
        temp.right=null;
        return temp;
    }
    Node insertNode(Node root ,int key){
        Node newnode=newNode(key);
        if(root==null){
            root=newnode;
            queue.add(root);
            return root;
        }
        else{
            Node node;
            node=queue.remove();
            System.out.println("parent is"+node.key);
            if(node.left==null){
                node.left=newnode;
                queue.add(node.left);
                queue.addFirst(node);//ensures that the parent node remains at the front of the queue
                return root;
            }
            else if(node.right==null){
                node.right=newnode;
                queue.add(node.right);
                return root;
            }
        }
        return root;
    }
    public void maxminNode(Node root){
        int max=root.key;
        int min=root.key;
        Queue<Node>queue1=new LinkedList<Node>();//queue1 is an object that stores Node objects , referencce to queue data structures
        queue1.add(root);
        while(!queue1.isEmpty()){
            Node tempnode=queue1.poll();
            if(tempnode.key>max){
                max=tempnode.key;
            }if(tempnode.key<min){
                min=tempnode.key;
            }
            if(tempnode.left!=null){//traversing the tree level by level
                queue1.add(tempnode.left);
            }
            if(tempnode.right!=null){//traversing the tree level by level
                queue1.add(tempnode.right);
            }
        }
        System.out.println("Max value in the tree is "+max);
        System.out.println("Min value in the tree is "+min);
    }
    public void levelbylevel(Node root){
        Queue<Node>queue1=new LinkedList<Node>();
        queue1.add(root);
        while(!queue1.isEmpty()){
            Node tempnode=queue1.poll();
            System.out.println(tempnode.key+" ");

            if(tempnode.left!=null){//traversing the tree level by level
                queue1.add(tempnode.left);
            }
            if(tempnode.right!=null){//traversing the tree level by level
                queue1.add(tempnode.right);
            }
        }
    }
    public static void main(String[] args) {
        binarytreeusinglist b= new binarytreeusinglist();
        Node root=null;
        String status="a";
        while(!status.equals("s")){
            System.out.println("Enter the value to be inserted");
            value=sc.nextInt();
            root=b.insertNode(root, value);
            System.out.println("BInary tree after insertion ");
            b.levelbylevel(root);
            System.out.println("\n Enter s to stop or any other charachter to continue");
            status=sc.next();
        }
        b.maxminNode(root);
        }
    }
