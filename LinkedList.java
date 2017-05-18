package hashMap;

// Anne Huang
// A LinkedList class to use in HashMap

public class LinkedList<E> {
	private Node head;

	private class Node<E>{
		String key;
		E value;
		Node next;

		private Node(String key, E value){
			this.key = key;
			this.value = value;
		}
		
		private Node(String key, E value, Node next)
		{
			this.key = key;
			this.value = value;
			this.next = next;
		}

		private void setValue(E value){
			this.value = value;
		}
	}

	public boolean set(String key, E value){
        for (Node x = head; x != null; x = x.next) { //iterate through linkedlist looking for key
            if (key.equals(x.key))
                x.setValue(value);
            	return true;
        }

        if (HashMap.items == HashMap.size)
        	return false;
        
        // if not already in LinkedList
		head = new Node(key, value, head);
		HashMap.items++;

		return true;
	}
	
	public E get(String key){
        for (Node x = head; x != null; x = x.next) { //iterate through linkedlist looking for key
            if (key.equals(x.key))
            	return (E) x.value;
        }
        return null;
	}
	
	public E delete(String key){
		E temp;
		
		if (head == null)
			return null;
		
		if (head.key.equals(key)){
			temp = (E) head.value;
			head = head.next;
			HashMap.items--;
			return temp;
		}
		
		for (Node x = head; x!= null && x.next != null; x = x.next){
			if (x.next.key.equals(key)){
				temp = (E) x.next.value;
				x.next = x.next.next;
				HashMap.items--;
				return temp;
			}
		}	
		return null;
	}

}
