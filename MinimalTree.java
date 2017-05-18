/********************
Anne Huang

This is my solution to problems 4.2 and 4.5 from Gayle Laakman McDowell, Cracking the Coding Interview, 6th Edition. Palto Alto: CareerCup, 2016.
p. 109.


************************/

// builds a binary search tree recursively

public class MinimalTree {

	private Node root;
	
	class Node {
		MinimalTree left;
		MinimalTree right;
		int data;
	}
	
	// takes as input an already sorted array of ints
	public MinimalTree(int[] arr, int beg, int end){
		
		root = new Node();
		// base
		if (beg == end){
			// null left and right
			root.data = arr[beg];
			System.out.println(root.data);
			return;
		}
		else if (beg + 1 == end){ // for the case that there's an even number of elements
			root.data = arr[beg];
			System.out.println(root.data);
			root.right = new MinimalTree(arr, end, end);
			return;
		}
		
		int mid = beg + (end - beg) / 2;

		int median = arr[mid];
		
		root.data = median;
		System.out.println(root.data);
		root.left = new MinimalTree(arr, beg, mid - 1);

		root.right = new MinimalTree(arr, mid + 1,end);
	}
	
	public boolean foo(MinimalTree root, int min, int max){ // validates tree

	// calls recursively

		// base cases
		// no left child
		if (root.root.left == null){
			if (root.root.right == null)
				return true;
			if (root.root.right.root.data < root.root.data){
				return false;
			} // close if
			// if it gets to this point it means that root.right is not null. Thus, we still have to call it recursively.
			
			if (foo(root.root.right, root.root.data, max)){
				if (root.root.right.root.data >= min)
					return root.root.right.root.data <= max; // done recursing
				return false;
			}
			return false;
		} // close if
	
		// check min, max
		// no right child
		if (root.root.right == null){
			if (root.root.left.root.data > root.root.data){
				return false;
			}
			
			if (foo(root.root.left, min, root.root.data)){
				if (root.root.left.root.data >= min)
					return root.root.left.root.data <= max; // done recursing
				return false;
			}
			return false;
		}

		// main case: has both left and right child
		if (root.root.left.root.data > root.root.data || root.root.right.root.data < root.root.data){
			return false;
		}

		if (foo(root.root.left, min, root.root.data)){
			if (root.root.left.root.data >= min){
				if (root.root.left.root.data <= max){
					if (foo(root.root.right, root.root.data, max)){
						if (root.root.right.root.data >= min)
							return root.root.right.root.data <= max; // done recursing
						return false;
					}
					return false;
				}
				return false;
			}
			return false;	
		}
		return false;

	} // close function

	public static void main(String[] args) {
	// test cases
		//int [] arr = {0, 1, 2, 3, 4, 5, 6};
		//int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};


		// test cases for trees that are wrong
		/*int [] arr1 = {3, 2, 1};
		int [] arr2 = {3, 2, 3};
		int [] arr3 = {1, 2, 1};
		int [] arr4 = {1};

		MinimalTree t = new MinimalTree(arr1, 0, arr1.length - 1);
		System.out.println(t.foo(t, t.root.data, t.root.data));

		t = new MinimalTree(arr2, 0, arr2.length - 1);
		System.out.println(t.foo(t, t.root.data, t.root.data));

		t = new MinimalTree(arr3, 0, arr3.length - 1);
		System.out.println(t.foo(t, t.root.data, t.root.data)); 

		t = new MinimalTree(arr4, 0, arr4.length - 1);
		System.out.println(t.foo(t, t.root.data, t.root.data));
		*/

		// test case from p. 247
		int [] arr = {10, 25, 20, 30};
		MinimalTree t = new MinimalTree(arr, 0, arr.length - 1);

		System.out.println(t.foo(t, t.root.data, t.root.data));		

	} // close main

}
