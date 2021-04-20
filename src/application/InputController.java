package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InputController implements Initializable{
	
	ObservableList<String> colorList = FXCollections.observableArrayList("Green", "Red", "Blue", "Yellow");
	int playerCount = 4;
	GameStorage store = new GameStorage();

	@FXML Button change;
	
	@FXML Button p2;
	
	@FXML Button p3;
	
	@FXML Button p4;
	
	@FXML TextField text1;
	
	@FXML ComboBox<String> box1;
	
	@FXML TextField text2;
	
	@FXML ComboBox<String> box2;
	
	@FXML Label label3;
	
	@FXML TextField text3;
	
	@FXML ComboBox<String> box3;
	
	@FXML Label label4;
	
	@FXML TextField text4;
	
	@FXML ComboBox<String> box4;
	
	@FXML 
	private void scenePress(ActionEvent event) throws IOException 
	{
		store.setPlayerCount(playerCount);
		Players[] playerArray = new Players[playerCount];
		if (playerCount == 2)
		{
			playerArray[0] = new Players(text1.getText(), box1.getValue());
			playerArray[1] = new Players(text2.getText(), box2.getValue());
		}
		else if (playerCount == 3)
		{
			playerArray[0] = new Players(text1.getText(), box1.getValue());
			playerArray[1] = new Players(text2.getText(), box2.getValue());
			playerArray[2] = new Players(text3.getText(), box3.getValue());
		}
		else if (playerCount == 4)
		{
			playerArray[0] = new Players(text1.getText(), box1.getValue());
			playerArray[1] = new Players(text2.getText(), box2.getValue());
			playerArray[2] = new Players(text3.getText(), box3.getValue());
			playerArray[3] = new Players(text4.getText(), box4.getValue());
		}	
		store.setPlayerArray(playerArray);
		
		Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource("application/BoardGame.fxml"));
		Scene boardScene = new Scene(root2);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(boardScene);
		window.show();
	}
	
	@FXML 
	private void player2Button(ActionEvent event)
	{
		label3.setVisible(false);
		text3.setVisible(false);
		box3.setVisible(false);
		
		label4.setVisible(false);
		text4.setVisible(false);
		box4.setVisible(false);
		
		playerCount = 2;
	}
	
	@FXML 
	private void player3Button(ActionEvent event) 
	{
		label3.setVisible(true);
		text3.setVisible(true);
		box3.setVisible(true);
		
		label4.setVisible(false);
		text4.setVisible(false);
		box4.setVisible(false);
		
		playerCount = 3;
	}
	
	@FXML 
	private void player4Button(ActionEvent event)
	{
		label3.setVisible(true);
		text3.setVisible(true);
		box3.setVisible(true);
		
		label4.setVisible(true);
		text4.setVisible(true);
		box4.setVisible(true);
		
		playerCount = 4;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		box1.getItems().addAll("Green", "Red", "Blue", "Yellow");
		box2.getItems().addAll("Green", "Red", "Blue", "Yellow");
		box3.getItems().addAll("Green", "Red", "Blue", "Yellow");
		box4.getItems().addAll("Green", "Red", "Blue", "Yellow");
		
	/*	GameStorage store = new GameStorage();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter amount of players: ");
		store.setPlayerCount(input.nextInt());
		ArrayList<Integer> randomArray = new ArrayList<Integer>();
		Random r = new Random();
		
		for (int y = 0; y < store.getPlayerArray().length; y++)
		{
			randomArray.add(y);
		}
		
		for (int x = 0; x < store.getPlayerArray().length; x++)
		{
			System.out.println("Enter the players name: ");
			String name = input.next();
			System.out.println("Enter the players color: ");
			String color = input.next();
			int currentRand = r.nextInt(randomArray.size());
			store.getPlayerArray()[randomArray.get(currentRand)] = new Players(name, color);
			randomArray.remove(currentRand);
		}
		*/
		
	}

}
