package application;

import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Sorry Board.fxml"));
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean exit = false;
		System.out.println("Enter amount of players: ");
		int playerCount = input.nextInt();
		Players[] playerArray = new Players[playerCount];
		for (int x = 0; x < playerArray.length; x++)
		{
			System.out.println("Enter the players name: ");
			String name = input.next();
			System.out.println("Enter the players color: ");
			String color = input.next();
			playerArray[x] = new Players(name, color);
		}
		
		launch(args);
		
		Deck roll = new Deck();
		{
			movement(roll.draw());
		}
		while (exit == true);
		
	}
	
	public static void testReset(Deck d)
	{
		if (d.deckSize() == 0)
		{
			d.shuffle();
		}
	}
	
	public static void movement(int d)
	{
		if (d == 1)
		{
			
		}
		else if (d == 2)
		{
			
		}
		else if (d == 3)
		{
			
		}
		else if (d == 4)
		{
			
		}
		else if (d == 5)
		{
			
		}
		else if (d == 6)
		{
			
		}
		else if (d == 7)
		{
			
		}
		else if (d == 8)
		{
			
		}
		else if (d == 9)
		{
			
		}
		else if (d == 10)
		{
			
		}
		else if (d == 11)
		{
			
		}
		else if (d == 12)
		{
			
		}
		else if (d == 13)
		{
			
		}
	}
}
