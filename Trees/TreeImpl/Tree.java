import java.util.*;
public class Tree {
	public static void main(String[] args){
		List<Integer> nums = Arrays.asList(14, 35, 10, 19, 31, 42);

		Node head = new Node(27);

		for (Integer num : nums){
			head.add(new Node(num));
		}

		System.out.println("====IN ORDER====");
		printInOrder(head);
		System.out.println("====PRE ORDER====");
		printPreOrder(head);
		System.out.println("====POST ORDER====");
		printPostOrder(head);
	}

	public static void printInOrder(Node node){
		if (node == null){
			return;
		}
		printInOrder(node.left);
		System.out.println(node.data);
		printInOrder(node.right);
	}

	public static void printPreOrder(Node node){
		if (node == null){
			return;
		}
		System.out.println(node.data);
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

	public static void printPostOrder(Node node){
		if (node == null){
			return;
		}
		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.println(node.data);
	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data){
		this.data = data;
	}

	public void add(Node node){
		if (node.data > data){
			if (this.right == null){
				this.right = node;
				return;
			} else {
				this.right.add(node);
			}
		} else {
			if (this.left == null){
				this.left = node;
				return;
			} else {
				this.left.add(node);
			}
		}
	}
}