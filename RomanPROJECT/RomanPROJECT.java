import java.util.Scanner;

public class RomanPROJECT {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int c=-1;
		int n;
		String RO;
		while (c!=0)
		{
			do
			{
				System.out.println("what do you want to convert:");
				System.out.println("1.Arabic to roman");
				System.out.println("2.roman to Arabic");
				System.out.println("0.end the program");
				
				c= s.nextInt();
				if(c<0 || c>2)
				{
					System.out.println("INVALID");
				}
			}while (c<0 || c>2);
			if(c==1)
			{
				do {
					System.out.println("Enter a number between 0 and 100000:"); 
					n = s.nextInt();
					if(n<0 || n>99999) 
					{
						System.out.println("INVALID");
					}
				}while(n<0 || n>99999); 
				RO = Roman(n); 
				System.out.println(RO);
			}
			else
			{
				if(c!=0)
				{
					do {
						System.out.println("Enter a Roman numeral between 0 and 100000:"); 
						RO = s.next();
						RO = RO.toUpperCase();
						RO = RO.trim();
						n = Arabic(RO);
						if(RO.equals(Roman(n).trim()))
						{
							if (n<0 || n>99999)
							{
								System.out.println("INVALID");
							}
							else
							{
								System.out.println(n);
							}
						}
						else
						{
							System.out.println("INVALID");
						}
					}while(n<0 || n>99999);
				}
				else
				{
					System.out.println("END OF PROGRAM");
				}
			}

		}

	}

	public static String Roman(int n)
	{
		String RO="";
		int a=0;
		int k=10000; 
		String t = "", u = "" , w= "";

		while (k>=1)
		{

			switch (k)
			{
			case 10000: u = "(L)" ; t = "(X)"; w= "(C)"; 
			break;
			case 1000: u = "(V)" ; t = "M"; w= "(X)";
			break;
			case 100: u = "D" ; t = "C"; w= "M";
			break;
			case 10: u = "L" ; t = "X"; w= "C";
			break;
			case 1: u = "V" ; t = "I"; w= "X";
			break;
			}

			a= n/k;
			switch (a)
			{
			case 1: RO = RO + t;
			break;
			case 2: RO = RO + t + t;
			break;
			case 3: RO = RO + t + t + t;
			break;
			case 4: RO = RO + t + u;
			break;
			case 5: RO = RO + u;
			break;
			case 6: RO = RO + u + t;
			break;
			case 7: RO = RO + u + t + t;
			break;
			case 8: RO = RO + u + t + t + t;
			break;
			case 9: RO = RO + t + w;
			default: 
				break;
			}
			n= n-(a*k);
			k=k/10;
		}

		return RO;
	}

	public static int Arabic(String RO)
	{
		char a;
		int n=0;
		for (int i=0 ; i<RO.length() ; i++)
		{
			a = RO.charAt(i);
			switch (RO.charAt(i))
			{
			case 'M':
				if ((i+1)<RO.length())
				{
					if(RO.charAt((i+1))=='(')
					{
						switch (RO.charAt(i+2))
						{
						case 'V': n=n+4000;
						i=i+3;
						break;
						case 'X': n=n+9000;
						i=i+3;
						break;
						default :
							break;
						}
					}
					else
					{
						n=n+1000;
					}
				}
				else
				{
					n=n+1000;
				}
			break;
			case '(': 

				switch (RO.charAt(i+1))
				{
				case 'V': n = n + 5000;
				i=i+2;
				break;
				case 'X':  
					if ((i+3)<RO.length())
					{
						if(RO.charAt(i+3)=='(') 
						{
							switch (RO.charAt(i+4))  
							{
							case 'L': n=n+40000;  
							i=i+5;
							break;
							case 'C': n=n+90000;  
							i=i+5;
							break;
							default :n=n+10000; 
							i=i+2;
							break;
							}
						}
						else
						{
							n=n+10000; 
							i=i+2;
						}
					}
					else
					{
						n=n+10000; 
						i=i+2;
					}
				break;
				case 'L': n = n + 50000; 
				i=i+2;
				break;
				case 'C': n = n + 100000; 
				i=i+2;
				break;
				default :
					break;
				}

				break;
			case 'C':
				if ((i+1)<RO.length())
				{
					switch (RO.charAt(i+1))
					{
					case 'D': n = n + 400;
					i=i+1;
					break;
					case 'M': n = n + 900;
					i=i+1;
					break;
					default : n = n + 100;
					break;
					}
				}
				else
				{
					n = n + 100;
				}

			break;
			case 'D': n= n+ 500;
			break;
			case 'X':
				if ((i+1)<RO.length())
				{
					switch (RO.charAt(i+1))
					{
					case 'L': n = n + 40;
					i=i+1;
					break;
					case 'C': n = n + 90;
					i=i+1;
					break;
					default : n = n + 10;
					break;
					}
				}
				else
				{
					n = n + 10;
				}
			break;
			case 'L': n= n+ 50;
			break;
			case 'V': n= n+ 5;
			break;
			case 'I':
				if ((i+1)<RO.length())
				{
					switch (RO.charAt(i+1))
					{
					case 'V': n = n + 4;
					i=i+1;
					break;
					case 'X': n = n + 9;
					i=i+1;
					break;
					default : n = n + 1;
					break;
					}
				}
				else
				{
					n = n + 1;
				}
			break;
			default:
			break;
			}
		}
		return n;
	}

}