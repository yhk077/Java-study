import java.util.Scanner;
class Fraction{
	private int fz;
	private int fm;
	
	public Fraction (int a,int b){
		this.fz = a;
		this.fm = b;
		zdgy(fz,fm);
		huajian();
	}
	
	public int zdgy(int a,int b) {
		while(b!=0) {
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	public void huajian() {
		int x = zdgy(fz,fm);
		fz /= x;
		fm /= x;
	}
	
	public double toDouble() {
		return(double) fz/fm;
	}
	
	public Fraction plus(Fraction r){
		int newfz = this.fm*r.fz+this.fz*r.fm;
		int newfm = this.fm*r.fm;
		return new Fraction(newfz,newfm);
	}
	
	public Fraction multiply(Fraction r) {
		int newfz2 = this.fz*r.fz;
		int newfm2 = this.fm*r.fm;
		return new Fraction(newfz2,newfm2);
	}
	
	public void print() {
		if(fz == fm) {
			System.out.println("1");
		}
		else if(fm == 1){
			System.out.println(fz);
		}
		else {
			System.out.println(fz + "/" +fm);
		}
	}
}

public class homework3_24_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(),in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
	}

}
