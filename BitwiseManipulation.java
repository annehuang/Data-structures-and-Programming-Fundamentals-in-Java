// demonstrating bitwise manipulation in Java.
public class BitwiseManipulation {

	/* This is my solution to problem 5.1 from Gayle Laakman McDowell, Cracking the Coding Interview, 6th Edition. Palto Alto: CareerCup, 2016. p. 115. */
	static int insert(int N, int M, int i, int j){
		
		return (N & (((1<< (i-1)) - 1) | (-1 << j))) | (M << i);
	}

	// This is my solution to Problem 5.6, p. 116
	static int convert(int A, int B){
		int xor = A ^ B;
		int count = 0;
		while (xor != 0){
			if ((xor & 1) == 1) count++;
			xor >>>= 1;
		}
		return count;
	}
	
	// This is my solution to 5.7
	static int swap(int num){
		int oddShift = (num & 0xAAAAAAA) >>> 1;
		int evenShift = (num & 0x55555555) << 1;
		return oddShift | evenShift;
	}
	
	public static void main(String[] args) {		
		// reference: https://docs.oracle.com/javase/8/docs/technotes/guides/language/binary-literals.html
		int N = 0b10000000000;
		int M = 0b10011;
		N = insert(N, M, 2, 6);

		// docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#toBinaryString-int-
		System.out.println(Integer.toBinaryString(N));
		
		System.out.println(convert(29, 15));
	}

}
