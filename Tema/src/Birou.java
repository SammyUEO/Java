//
public class Birou {
	
	public final Sertar x;
	public final Sertar y;
	public int L, H, l;
	
	public Birou(Sertar x, Sertar y ) {
		this.x = x;
		this.y =y;
		
		if(x.l>y.l) {
			this.l = x.l;
		}else {
			this.l =y.l;
		}
		if(x.L>y.L) {
			this.L = x.L;
		}else {
			this.L =y.L;
		}
		this.H = x.H + y.H;
		
	}
	public void Print() {
		System.out.println("Sertar 1: ");
		this.x.Print();
		System.out.println("Sertar 2: ");
		this.y.Print();
		System.out.println("dimensiuni birou: " + this.l + " l + " + this.L + " L + " + this.H + " H ");
	}
}
