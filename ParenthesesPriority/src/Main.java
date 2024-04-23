public class Main {
	public static void main(String[] args) {
		System.out.println();
		System.out.println(Bracket.getOrder("(Hello((Hi(WHy(This))Hi1)hi2)) (second(innerS)) (third(innerT))"));
		System.out.println();
		System.out.println(Bracket.getOrder("(12(34((56)(78(90)))) (AB(CD)) (EF))"));
		System.out.println();
	}
}