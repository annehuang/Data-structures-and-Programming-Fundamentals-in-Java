	public class Node<E>{
		E value;
		Node next;

		public Node(E value){
			this.value = value;
		}
		
		public Node(E value, Node next)
		{
			this.value = value;
			this.next = next;
		}

		public Node intersect(Node that)
		{
			int n = 0;
			int n2 = 0;

			Node ptr = this;
			Node ptr2 = that;
			while (ptr.next != null){
				n++;
				ptr = ptr.next;
			}
			while (ptr2.next != null){
				n2++;
				ptr2 = ptr2.next;
			}
			if (ptr != ptr2) return null;

			int diff = n - n2;

			ptr = this;
			ptr2 = that;

			if (diff < 0){ // list 2 is longer
				diff = Math.abs(diff);
				while (diff > 0){
					ptr2 = ptr2.next;
					diff--;
				}
			}
			else if (diff > 0){
				while (diff > 0){
					ptr = ptr.next;
					diff--;
				}
			}

			while (ptr != ptr2){
				ptr = ptr.next; ptr2 = ptr2.next;
			}

			return ptr;
		}

		public static void main(String[] args){
			Node<Integer> head = new Node(5);
			head.next = new Node(6);
			head.next.next = new Node(65);
			head.next.next.next = new Node(4);

			Node<Integer> head2 = new Node(1);
			head2.next = new Node(2);
			head2.next.next = new Node(3);

			Node<Integer> ptr = head.intersect(head2);
			if (ptr == null) System.out.println("null");

			head.next.next.next = head2.next;
			ptr = head.intersect(head2);
			System.out.println(ptr.value);
		}
	}

