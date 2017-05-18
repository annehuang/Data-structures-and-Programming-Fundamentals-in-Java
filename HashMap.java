// Anne Huang

package hashMap;

public class HashMap<E> {

	// this uses a LinkedList classes which I built (and have included)
	
	private int N = 5;
	private LinkedList<E>[] arr;
	public static int items = 0;       // number of items
	public static int size = 0;      // fixed max number of objects
		
	public HashMap(int size){
		arr = (LinkedList<E>[]) new LinkedList[5];
        for (int i = 0; i < N; i++)
        	arr[i] = new LinkedList<E>();
		this.size = size;
	}
	
	public int hash(String key){
		return key.hashCode() % N;
	}
	
	public boolean set(String key, E value){
		int hash = hash(key);
		LinkedList<E> lst = arr[hash];
		
		return lst.set(key, value);
	}
	
	public E get(String key){
		int hash = hash(key);

		LinkedList<E> lst = arr[hash];
		
		return lst.get(key);
	}
	
	public E delete(String key){
		int hash = hash(key);
		LinkedList<E> lst = arr[hash];
		
		return lst.delete(key);
	}
	
	public float load(){
		return (float) items / size;
	}
	
	public static void main(String[] args) {
		HashMap<Integer> map = new HashMap<Integer>(15);
		map.set("Anne", 5);
		System.out.println(map.get("Anne"));
		map.set("Huang", 4);
		System.out.println(map.get("Huang"));
		System.out.println(map.delete("Anne"));
		System.out.println(map.get("Anne"));
	}

}
