
public class MinimalTree {

	private Node root;
	
	class Node {
		MinimalTree left;
		MinimalTree right;
		int data;
	}
	
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
	
	
	public static void main(String[] args) {
// test cases
		int [] arr = {0, 1, 2, 3, 4, 5, 6};
		//int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
		new MinimalTree(arr, 0, arr.length - 1);
	}

}
