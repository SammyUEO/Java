import java.util.Scanner;

public class Probleme {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void problema1() {
		int nr = scan.nextInt();
		if(nr<1 || nr>10) {
			System.out.println("INVALID");
		}
		else {
			if (nr>5) {
				System.out.println("ADMIS");}
				else {
					System.out.println("RESPINS");
				}
			}
		}
	public static void problema2() {
		int nr = scan.nextInt();
		switch(nr){
		case 1:{
			System.out.println("UNU");
			break;
			}
		case 2:{
			System.out.println("DOI");
			break;
			}
		case 3:{
			System.out.println("TREI");
			break;
			}
		case 4:{
			System.out.println("PATRU");
			break;
			}
		case 5:{
			System.out.println("CINCI");
			break;
			}
		default :{
			System.out.println("INVALID");
			}
		}
	}
	public static void problema3() {
		int nr1 = scan.nextInt();
		int nr2 = scan.nextInt();
		
		if(nr1%2==0 && nr2%2==0 ) {
			System.out.println((nr1+nr2)/2);
		}
		else {
			if(nr1%2==1 && nr2%2==1) {
				System.out.println(nr1*nr2);
			}
			else {
				System.out.println(nr1+nr2);
			}
		}
	}
	public static void problema4() {
		int nr1 = scan.nextInt();
		int nr2 = scan.nextInt();
		int nr3 = scan.nextInt();
		
		int min = Math.min(nr1, nr2);
		System.out.println(Math.min(nr3, min));
	}
	public static void problema5() {
		int nr = scan.nextInt();
		
		int sum=0,a=0;
		for(int i=0; i<nr; i++) {
			sum = sum + a;
			a = a+2;
			
		}
		System.out.println(sum);
	}
	public static void problema6() {
		int nr = scan.nextInt();
		
		int sum=0,a=1;
		for(int i=0; i<nr; i++) {
			sum = sum + a;
			a = a+2;
			
		}
		System.out.println(sum);
	}
	public static void problema7() {
		int nr =scan.nextInt();
		
		int sum=0;
		for(int i=0;i<nr;i++) {
			int n = scan.nextInt();
			sum = sum + n;
		}
		System.out.println(sum/nr);
	}
	public static void problema8() {
		int nr = scan.nextInt();
		int fact = 1;
		for (int i=1; i<=nr; i++) {
			fact = fact*i;
		}
		System.out.println(fact);
	}
	public static void problema9() {
		int nr = scan.nextInt();
		boolean prim = true;
		
		if (nr>1) {
			for(int i=2;nr>=i*i;i++) {
				if(nr%i==0) {
					prim=false;
				}
			}
		}
		if(prim) {
			System.out.println("nr este prim");
		}else {
			System.out.println("nr nu este prim");
		}
	}
	public static void problema10() {
		
		boolean prim = false;
		int nr = 1000;
		
		while(prim == false) {
			nr++;
			prim = true;
			for(int i =2; nr>=i*i; i++) {
				if(nr%i==0) {
					prim=false;
				}
			}
		}
		System.out.println(nr);
	}
	public static void problema11() {
		int nr = scan.nextInt();
		for(int i=1; i<=nr; i++) {
			if(nr%i==0) {
				System.out.println(i);
			}
		}
	}
	public static void problema12() {
		int nr = scan.nextInt();
		for (int i=1;i<=nr;i++)
		{
			boolean prim = false;
			if (nr%i==0)
				{
				prim=true;
				for(int j=2;j*j<=i;j++)
					{
					if(i%j==0)
						prim=false;
					
					}
				}
			if (prim)
				System.out.println(i);
		}
	}
	public static void problema13() {
		for(int i=0; i<1000; i=i+17) {
			for(int j=0; j<1000; j=j+19) {
				if(i+j==1000) {
					System.out.println(i + "," + j);
				}
			}
		}
	}
	public static void problema14() {
		for(int i=1;i<1000;i++) {
			int j =1000-i;
			if((i%17==0 || i%13==0) && (j%19==0 || j%7==0)) {
				System.out.println(i + "," + j);
			}
		}
	}
	public static void problema15() {
		for(int a=0;a<10;a++) {
			for (int b=0; b<10;b++) {
				if((3020 + a*100 +b)%9==0) {
					System.out.println(3020 + a*100 +b);
				}
			}
		}
	}
	public static void problema16() {
		int nr = scan.nextInt();
		int ogl = 0;
		
		while (nr>0) {
			ogl=ogl*10+nr%10;
			nr=nr/10;
		}
		while(ogl>0) {
			
			System.out.print(ogl%10 + " ");
			ogl = ogl/10;
		}
		
	}
	public static void problema17() {
		int nr = scan.nextInt();
		int max = 0;
		
		while (nr>0)
		{
			if (nr%10>max) {
				max=nr%10;
			}
			nr = nr/10;
			
		}
		System.out.println(max);
	}
	public static void problema18()
	{
		int nr = scan.nextInt();
		int min = 9;
		
		while (nr>0)
		{
			if (nr%10<min) {
				min=nr%10;
			}
			nr=nr/10;
		}
		System.out.println(min);
	}
	public static void problema19()
	{
		int nr = scan.nextInt();
		int ogl = 0;
		while (nr>0)
		{
			ogl=ogl*10+nr%10;
			nr=nr/10;
		}
		System.out.println(ogl);
	}
	public static void problema20()
	{
		int nr = scan.nextInt();
		int ogl = 0,verify=nr;
		while (nr>0)
		{
			ogl=ogl*10+nr%10;
			nr=nr/10;
		}
		if(ogl==verify)
			System.out.println("este palindrom");
		else
			System.out.println("nu este palidrom");
	}
	
}

