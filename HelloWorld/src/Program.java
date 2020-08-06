public class Program {
	
	public static void rotund(double x) {
		System.out.println((int)(x + 0.5));
	}
	
	public static void main(String[] args) {
		rotund(12.5);
		
		/*// problema 3
		System.out.println( (double) ( (int) ( (double)104348.e6/33215 ) ) / 1.e6);
		// problema 4
		int f=60;
		System.out.println(f+"F = "+ (int)( (f-32)*5./9 )+"C" );
		// problema 5 - sol 1 (care nu e buna :)) )
		int a=232,b=232;
		System.out.println( (boolean)(a!=b));
		// problema 5 - sol 2 (care nu e buna :)) )
		a=232; b=232;
		System.out.println( (boolean) ( (double) (a/b)!=1 ) );
		// problema 6*/
	}
}
