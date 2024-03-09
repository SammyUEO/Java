
public class Main {

	public static void main(String[] args) {
		Sertar x = new Sertar(10,30,20);
		x.Print();
		Sertar y = new Sertar(20,40,10);
		y.Print();
		Birou Sammy = new Birou(x, y);
		Sammy.Print();
	}
	
}
