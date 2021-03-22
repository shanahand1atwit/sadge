package application;

public class Main {
	public static void main(String[] args) {
		Deck test = new Deck();
		System.out.println(test.cards);
		System.out.println(test.draw());
		System.out.println(test.cards);
	}
}
