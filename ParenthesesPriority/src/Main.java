import bracket.Bracket;

public class Main {
	public static void main(String[] args) {
		System.out.println();
		System.out.println(Bracket.getOrder("(Hello((Hi(WHy(This))Hi1)hi2)) (second(innerS)) (third(innerT))"));
		System.out.println();
		System.out.println(Bracket.getOrder("(1+2+(4-3+((5 +7)-(6+8+(18-9))))+(7-7+(5*6))-(1-2))/2"));
		System.out.println();
	}
}