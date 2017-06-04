
public class BitwiseManipulation {

	static int insert(int N, int M, int i, int j){
		
		return (N & (((1<< (i-1)) - 1) | (-1 << j))) | (M << i);
	}
	
	public static void main(String[] args) {		
		// reference: https://docs.oracle.com/javase/8/docs/technotes/guides/language/binary-literals.html
		int N = 0b10000000000;
		int M = 0b10011;
		N = insert(N, M, 2, 6);

		// docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#toBinaryString-int-
		System.out.println(Integer.toBinaryString(N));
	}

}
