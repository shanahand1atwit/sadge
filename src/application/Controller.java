package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Controller implements Initializable{
	int currentTurn = 0;
	Deck roll = new Deck();
	
	@FXML Text name1;
	
	@FXML Text name2;
	
	@FXML Text name3;
	
	@FXML Text name4;
	
	@FXML TextArea question;
	
	@FXML Label label3;
	
	@FXML Label label4;
	
	@FXML Polygon arrow1;
	
	@FXML Polygon arrow2;
	
	@FXML Polygon arrow3;
	
	@FXML Polygon arrow4;
	
	@FXML Button choice1;
	
	@FXML Button choice2;
	
	@FXML GridPane Ggrid;
	
	@FXML GridPane Rgrid;
	
	@FXML GridPane Bgrid;
	
	@FXML GridPane Ygrid;
	
	@FXML ImageView Gpiece1;
	
	@FXML ImageView Gpiece2;
	
	@FXML ImageView Gpiece3;
	
	@FXML ImageView Gpiece4;
	
	@FXML ImageView Rpiece1;
	
	@FXML ImageView Rpiece2;
	
	@FXML ImageView Rpiece3;
	
	@FXML ImageView Rpiece4;
	
	@FXML ImageView Bpiece1;
	
	@FXML ImageView Bpiece2;
	
	@FXML ImageView Bpiece3;
	
	@FXML ImageView Bpiece4;
	
	@FXML ImageView Ypiece1;
	
	@FXML ImageView Ypiece2;
	
	@FXML ImageView Ypiece3;
	
	@FXML ImageView Ypiece4;
	
	@FXML GridPane RStart;
	
	@FXML GridPane GStart;
	
	@FXML GridPane BStart;
	
	@FXML GridPane YStart;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Board gameBoard = new Board();
		boolean exit = false;		
		GameStorage store = new GameStorage();
		
		if (store.getPlayerArray().length == 2)
		{
			name1.setText(store.getPlayerArray()[0].getName() + " - " + store.getPlayerArray()[0].getColor());
			name2.setText(store.getPlayerArray()[1].getName() + " - " + store.getPlayerArray()[1].getColor());
			label3.setVisible(false);
			label4.setVisible(false);
			name3.setVisible(false);
			name4.setVisible(false);
		}
		else if (store.getPlayerArray().length == 3)
		{
			name1.setText(store.getPlayerArray()[0].getName() + " - " + store.getPlayerArray()[0].getColor());
			name2.setText(store.getPlayerArray()[1].getName() + " - " + store.getPlayerArray()[1].getColor());
			name3.setText(store.getPlayerArray()[2].getName() + " - " + store.getPlayerArray()[2].getColor());
			label4.setVisible(false);
			name4.setVisible(false);
		}
		else if (store.getPlayerArray().length == 4)
		{
			name1.setText(store.getPlayerArray()[0].getName() + " - " + store.getPlayerArray()[0].getColor());
			name2.setText(store.getPlayerArray()[1].getName() + " - " + store.getPlayerArray()[1].getColor());
			name3.setText(store.getPlayerArray()[2].getName() + " - " + store.getPlayerArray()[2].getColor());
			name4.setText(store.getPlayerArray()[3].getName() + " - " + store.getPlayerArray()[3].getColor());
		}
		
		setArrow();
		doTurn(store);
	}
	
	public void turnIncrement(GameStorage g)
	{
		if (currentTurn == (g.getPlayerArray().length-1))
		{
			currentTurn = 0;
		}
		else
		{
			currentTurn++;
		}
	}
	
	public void doTurn(GameStorage g)
	{
		int currentDraw = roll.draw();
		if (roll.deckSize() == 0)
		{
			roll.shuffle();
		}
		//int currentDraw = 1;
		//System.out.println("Current Turn Count: " + currentTurn);
		//System.out.println("Current Player Name: " + g.getPlayerArray()[currentTurn].getName());
		if (currentDraw == 1)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 1. Pick a piece to start.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				startBegin(g.getPlayerArray(), currentTurn, g);
			}
			else if (g.getPlayerArray()[currentTurn].hasStart() && !g.getPlayerArray()[currentTurn].hasBeginning())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 1. Would you like start a piece or move a piece 1 space?");
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice1.setText("Start a piece");
				choice2.setText("Move a piece");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 1. Pick a piece to start.");
						choice1.setVisible(false);
						choice2.setVisible(false);
						startBegin(g.getPlayerArray(), currentTurn, g);
					}
				});
				choice2.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 1. Pick a piece to move 1 space.");
						choice1.setVisible(false);
						choice2.setVisible(false);
						moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 1. Pick a piece to move 1 space.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 2)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 2. Pick a piece to start.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				startBegin(g.getPlayerArray(), currentTurn, g);
			}
			else if (g.getPlayerArray()[currentTurn].hasStart() && !g.getPlayerArray()[currentTurn].hasBeginning())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 2. Would you like start a piece or move a piece 2 spaces?");
				choice1.setVisible(true);
				choice2.setVisible(true);
				choice1.setText("Start a piece");
				choice2.setText("Move a piece");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 2. Pick a piece to start.");
						choice1.setVisible(false);
						choice2.setVisible(false);
						startBegin(g.getPlayerArray(), currentTurn, g);
					}
				});
				choice2.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 2. Pick a piece to move 2 spaces.");
						choice1.setVisible(false);
						choice2.setVisible(false);
						moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 2. Pick a piece to move 2 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 3)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 3. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 3. Pick a piece to move 3 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 4)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 4. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 4. Pick a piece to move 4 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 5)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 5. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 5. Pick a piece to move 5 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 6)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 6. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 6. Pick a piece to move 6 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 7)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 7. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 7. Pick a piece to move 7 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 8)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 8. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 8. Pick a piece to move 8 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 9)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 9. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 9. Pick a piece to move 9 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 10)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 10. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 10. Pick a piece to move 10 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 11)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 11. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 11. Pick a piece to move 11 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 12)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 12. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a 12. Pick a piece to move 12 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
		else if (currentDraw == 0)
		{
			if (!g.getPlayerArray()[currentTurn].hasBoard())
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a SORRY. They can't move any pieces.");
				choice1.setVisible(true);
				choice1.setText("Ok");
				choice1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						choice1.setVisible(false);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			else
			{
				question.setText(g.getPlayerArray()[currentTurn].getName() + " drew a SORRY. Pick a piece to move 13 spaces.");
				choice1.setVisible(false);
				choice2.setVisible(false);
				moveSpace(g.getPlayerArray(), currentTurn, g, currentDraw);
			}
		}
	}
	
	public void stopAllClick()
	{
		Gpiece1.setDisable(true);
		Gpiece2.setDisable(true);
		Gpiece3.setDisable(true);
		Gpiece4.setDisable(true);
		
		Rpiece1.setDisable(true);
		Rpiece2.setDisable(true);
		Rpiece3.setDisable(true);
		Rpiece4.setDisable(true);
		
		Bpiece1.setDisable(true);
		Bpiece2.setDisable(true);
		Bpiece3.setDisable(true);
		Bpiece4.setDisable(true);
		
		Ypiece1.setDisable(true);
		Ypiece2.setDisable(true);
		Ypiece3.setDisable(true);
		Ypiece4.setDisable(true);
	}
	
	public void setArrow()
	{
		if (currentTurn == 0)
		{
			arrow1.setVisible(true);
			arrow2.setVisible(false);
			arrow3.setVisible(false);
			arrow4.setVisible(false);
		}
		else if (currentTurn == 1)
		{
			arrow1.setVisible(false);
			arrow2.setVisible(true);
			arrow3.setVisible(false);
			arrow4.setVisible(false);
		}
		else if (currentTurn == 2)
		{
			arrow1.setVisible(false);
			arrow2.setVisible(false);
			arrow3.setVisible(true);
			arrow4.setVisible(false);
		}
		else if (currentTurn == 3)
		{
			arrow1.setVisible(false);
			arrow2.setVisible(false);
			arrow3.setVisible(false);
			arrow4.setVisible(true);
		}
	}
	
	public void startBegin(Players[] pa, int ct, GameStorage g)
	{
		if (pa[ct].getColor().equals("Green"))
		{
			if (pa[ct].isStart(0))
			{
				Gpiece1.setDisable(false);
				Gpiece1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						GStart.getChildren().remove(Gpiece1);
						pa[ct].playerPawns[0].setBeginning();
						Ggrid.add(Gpiece1, 0, (14-pa[ct].playerPawns[0].getLocation()));
						stopAllClick();
						landOn(pa, ct, 0);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(1))
			{
				Gpiece2.setDisable(false);
				Gpiece2.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						GStart.getChildren().remove(Gpiece2);
						pa[ct].playerPawns[1].setBeginning();
						Ggrid.add(Gpiece2, 0, (14-pa[ct].playerPawns[1].getLocation()));
						stopAllClick();
						landOn(pa, ct, 1);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(2))
			{
				Gpiece3.setDisable(false);
				Gpiece3.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						GStart.getChildren().remove(Gpiece3);
						pa[ct].playerPawns[2].setBeginning();
						Ggrid.add(Gpiece3, 0, (14-pa[ct].playerPawns[2].getLocation()));
						stopAllClick();
						landOn(pa, ct, 2);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(3))
			{
				Gpiece4.setDisable(false);
				Gpiece4.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						GStart.getChildren().remove(Gpiece4);
						pa[ct].playerPawns[3].setBeginning();
						Ggrid.add(Gpiece4, 0, (14-pa[ct].playerPawns[3].getLocation()));
						stopAllClick();
						landOn(pa, ct, 3);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
		}
		else if (pa[ct].getColor().equals("Red"))
		{
			if (pa[ct].isStart(0))
			{
				Rpiece1.setDisable(false);
				Rpiece1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						RStart.getChildren().remove(Rpiece1);
						pa[ct].playerPawns[0].setBeginning();
						Rgrid.add(Rpiece1, (pa[ct].playerPawns[0].getLocation()-15), 0);
						stopAllClick();
						landOn(pa, ct, 0);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(1))
			{
				Rpiece2.setDisable(false);
				Rpiece2.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						RStart.getChildren().remove(Rpiece2);
						pa[ct].playerPawns[1].setBeginning();
						Rgrid.add(Rpiece2, (pa[ct].playerPawns[1].getLocation()-15), 0);
						stopAllClick();
						landOn(pa, ct, 1);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(2))
			{
				Rpiece3.setDisable(false);
				Rpiece3.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						RStart.getChildren().remove(Rpiece3);
						pa[ct].playerPawns[2].setBeginning();
						Rgrid.add(Rpiece3, (pa[ct].playerPawns[2].getLocation()-15), 0);
						stopAllClick();
						landOn(pa, ct, 2);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(3))
			{
				Rpiece4.setDisable(false);
				Rpiece4.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						RStart.getChildren().remove(Rpiece4);
						pa[ct].playerPawns[3].setBeginning();
						Rgrid.add(Rpiece4, (pa[ct].playerPawns[3].getLocation()-15), 0);
						stopAllClick();
						landOn(pa, ct, 3);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
		}
		else if (pa[ct].getColor().equals("Blue"))
		{
			if (pa[ct].isStart(0))
			{
				Bpiece1.setDisable(false);
				Bpiece1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						BStart.getChildren().remove(Bpiece1);
						pa[ct].playerPawns[0].setBeginning();
						Bgrid.add(Bpiece1, 0, (pa[ct].playerPawns[0].getLocation()-30));
						stopAllClick();
						landOn(pa, ct, 0);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(1))
			{
				Bpiece2.setDisable(false);
				Bpiece2.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						BStart.getChildren().remove(Bpiece2);
						pa[ct].playerPawns[1].setBeginning();
						Bgrid.add(Bpiece2, 0, (pa[ct].playerPawns[1].getLocation()-30));
						stopAllClick();
						landOn(pa, ct, 1);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(2))
			{
				Bpiece3.setDisable(false);
				Bpiece3.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						BStart.getChildren().remove(Bpiece3);
						pa[ct].playerPawns[2].setBeginning();
						Bgrid.add(Bpiece3, 0, (pa[ct].playerPawns[2].getLocation()-30));
						stopAllClick();
						landOn(pa, ct, 2);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(3))
			{
				Bpiece4.setDisable(false);
				Bpiece4.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						BStart.getChildren().remove(Bpiece4);
						pa[ct].playerPawns[3].setBeginning();
						Bgrid.add(Bpiece4, 0, (pa[ct].playerPawns[3].getLocation()-30));
						stopAllClick();
						landOn(pa, ct, 3);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
		}
		else if (pa[ct].getColor().equals("Yellow"))
		{
			if (pa[ct].isStart(0))
			{
				Ypiece1.setDisable(false);
				Ypiece1.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						YStart.getChildren().remove(Ypiece1);
						pa[ct].playerPawns[0].setBeginning();
						Ygrid.add(Ypiece1, (14-(pa[ct].playerPawns[0].getLocation()-45)), 0);
						stopAllClick();
						landOn(pa, ct, 0);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(1))
			{
				Ypiece2.setDisable(false);
				Ypiece2.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						YStart.getChildren().remove(Ypiece2);
						pa[ct].playerPawns[1].setBeginning();
						Ygrid.add(Ypiece2, (14-(pa[ct].playerPawns[1].getLocation()-45)), 0);
						stopAllClick();
						landOn(pa, ct, 1);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(2))
			{
				Ypiece3.setDisable(false);
				Ypiece3.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						YStart.getChildren().remove(Ypiece3);
						pa[ct].playerPawns[2].setBeginning();
						Ygrid.add(Ypiece3, (14-(pa[ct].playerPawns[2].getLocation()-45)), 0);
						stopAllClick();
						landOn(pa, ct, 2);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
			if (pa[ct].isStart(3))
			{
				Ypiece4.setDisable(false);
				Ypiece4.setOnMousePressed((e)->{
					if (e.getButton()==MouseButton.PRIMARY)
					{
						YStart.getChildren().remove(Ypiece4);
						pa[ct].playerPawns[3].setBeginning();
						Ygrid.add(Ypiece4, (14-(pa[ct].playerPawns[3].getLocation()-45)), 0);
						stopAllClick();
						landOn(pa, ct, 3);
						turnIncrement(g);
						setArrow();
						doTurn(g);
					}
				});
			}
		}
	}
	
	public void removeFromGrid(ImageView pc)
	{
		if (Ggrid.getChildren().contains(pc))
		{
			Ggrid.getChildren().remove(pc);
		}
		else if (Rgrid.getChildren().contains(pc))
		{
			Rgrid.getChildren().remove(pc);
		}
		else if (Bgrid.getChildren().contains(pc))
		{
			Bgrid.getChildren().remove(pc);
		}
		else if (Ygrid.getChildren().contains(pc))
		{
			Ygrid.getChildren().remove(pc);
		}
	}
	
	public void moveThruGrids(Players[] pa, int ct, GameStorage g, int r, ImageView pc, int i)
	{
		pc.setOnMousePressed((e)->{
			if (e.getButton()==MouseButton.PRIMARY)
			{
				removeFromGrid(pc);
				
				pa[ct].playerPawns[i].goFoward(r);
				
				if (pa[ct].playerPawns[0].getLocation() >= 0 &&
						pa[ct].playerPawns[i].getLocation() <= 14)
				{
					Ggrid.add(pc, 0, (14-pa[ct].playerPawns[i].getLocation()));
				}
				else if (pa[ct].playerPawns[i].getLocation() >= 15 &&
						pa[ct].playerPawns[i].getLocation() <= 29)
				{
					Rgrid.add(pc, (pa[ct].playerPawns[i].getLocation()-15), 0);
				}
				else if (pa[ct].playerPawns[i].getLocation() >= 30 &&
						pa[ct].playerPawns[i].getLocation() <= 44)
				{
					Bgrid.add(pc, 0, (pa[ct].playerPawns[i].getLocation()-30));
				}
				else if (pa[ct].playerPawns[i].getLocation() >= 45 &&
						pa[ct].playerPawns[i].getLocation() <= 59)
				{
					Ygrid.add(pc, (14-(pa[ct].playerPawns[i].getLocation()-45)), 0);
				}
		
				stopAllClick();
				landOn(pa, ct, i);
				turnIncrement(g);
				setArrow();
				doTurn(g);
			}
		});
	}
	
	public void landOn(Players[] pa, int ct, int i)
	{
		for (int z = 0; z < pa.length; z++)
		{
			for (int x = 0; x < pa[z].getPawnSize(); x++)
			{
				if (pa[z].playerPawns[x].getLocation() == pa[ct].playerPawns[i].getLocation() && 
						pa[z].getColor() != pa[ct].getColor())
				{
					pa[z].playerPawns[x].setStart();		
					System.out.println(pa[z].playerPawns[x].getLocation());
					if (pa[z].playerPawns[x].getLocation() == 80)
					{
						if(x == 0)
						{
							removeFromGrid(Gpiece1);
							GStart.add(Gpiece1, 0, 1);
						}
						else if (x == 1)
						{
							removeFromGrid(Gpiece2);
							GStart.add(Gpiece2, 0, 0);
						}
						else if (x == 2)
						{
							removeFromGrid(Gpiece3);
							GStart.add(Gpiece3, 1, 1);
						}
						else if (x == 3)
						{
							removeFromGrid(Gpiece4);
							GStart.add(Gpiece4, 1, 0);
						}
					}
					else if (pa[z].playerPawns[x].getLocation() == 81)
					{
						if(x == 0)
						{
							removeFromGrid(Rpiece1);
							RStart.add(Rpiece1, 0, 0);
						}
						else if (x == 1)
						{
							removeFromGrid(Rpiece2);
							RStart.add(Rpiece2, 1, 0);
						}
						else if (x == 2)
						{
							removeFromGrid(Rpiece3);
							RStart.add(Rpiece3, 0, 1);
						}
						else if (x == 3)
						{
							removeFromGrid(Rpiece4);
							RStart.add(Rpiece4, 1, 1);
						}
					}
					else if (pa[z].playerPawns[x].getLocation() == 82)
					{
						if(x == 0)
						{
							removeFromGrid(Bpiece1);
							BStart.add(Bpiece1, 1, 0);
						}
						else if (x == 1)
						{
							removeFromGrid(Bpiece2);
							BStart.add(Bpiece2, 1, 1);
						}
						else if (x == 2)
						{
							removeFromGrid(Bpiece3);
							BStart.add(Bpiece3, 0, 0);
						}
						else if (x == 3)
						{
							removeFromGrid(Bpiece4);
							BStart.add(Bpiece4, 0, 1);
						}
					}
					else if (pa[z].playerPawns[x].getLocation() == 83)
					{
						if(x == 0)
						{
							removeFromGrid(Ypiece1);
							YStart.add(Ypiece1, 1, 1);
						}
						else if (x == 1)
						{
							removeFromGrid(Ypiece2);
							YStart.add(Ypiece2, 0, 1);
						}
						else if (x == 2)
						{
							removeFromGrid(Ypiece3);
							YStart.add(Ypiece3, 1, 0);
						}
						else if (x == 3)
						{
							removeFromGrid(Ypiece4);
							YStart.add(Ypiece4, 0, 0);
						}
					}
				}
			}
		}
	}
	
	public void moveSpace(Players[] pa, int ct, GameStorage g, int r)
	{
		if (pa[ct].getColor().equals("Green"))
		{
			if (pa[ct].isStart(0) || pa[ct].hasInfront(0, r))
			{
				Gpiece1.setDisable(true);
			}
			else
			{
				Gpiece1.setDisable(false);
				moveThruGrids(pa, ct, g, r, Gpiece1, 0);
			}
			
			if (pa[ct].isStart(1) || pa[ct].hasInfront(1, r))
			{
				Gpiece2.setDisable(true);
			}
			else
			{
				Gpiece2.setDisable(false);
				moveThruGrids(pa, ct, g, r, Gpiece2, 1);
			}
			
			if (pa[ct].isStart(2) || pa[ct].hasInfront(2, r))
			{
				Gpiece3.setDisable(true);
			}
			else
			{
				Gpiece3.setDisable(false);
				moveThruGrids(pa, ct, g, r, Gpiece3, 2);
			}
			
			if (pa[ct].isStart(3) || pa[ct].hasInfront(3, r))
			{
				Gpiece4.setDisable(true);
			}
			else
			{
				Gpiece4.setDisable(false);
				moveThruGrids(pa, ct, g, r, Gpiece4, 3);
			}
		}
		else if (pa[ct].getColor().equals("Red"))
		{
			if (pa[ct].isStart(0) || pa[ct].hasInfront(0, r))
			{
				Rpiece1.setDisable(true);
			}
			else
			{
				Rpiece1.setDisable(false);
				moveThruGrids(pa, ct, g, r, Rpiece1, 0);
			}
			
			if (pa[ct].isStart(1) || pa[ct].hasInfront(1, r))
			{
				Rpiece2.setDisable(true);
			}
			else
			{
				Rpiece2.setDisable(false);
				moveThruGrids(pa, ct, g, r, Rpiece2, 1);
			}
			
			if (pa[ct].isStart(2) || pa[ct].hasInfront(2, r))
			{
				Rpiece3.setDisable(true);
			}
			else
			{
				Rpiece3.setDisable(false);
				moveThruGrids(pa, ct, g, r, Rpiece3, 2);
			}
			
			if (pa[ct].isStart(3) || pa[ct].hasInfront(3, r))
			{
				Rpiece4.setDisable(true);
			}
			else
			{
				Rpiece4.setDisable(false);
				moveThruGrids(pa, ct, g, r, Rpiece4, 3);
			}
		}
		else if (pa[ct].getColor().equals("Blue"))
		{
			if (pa[ct].isStart(0) || pa[ct].hasInfront(0, r))
			{
				Bpiece1.setDisable(true);
			}
			else
			{
				Bpiece1.setDisable(false);
				moveThruGrids(pa, ct, g, r, Bpiece1, 0);
			}
			
			if (pa[ct].isStart(1) || pa[ct].hasInfront(1, r))
			{
				Bpiece2.setDisable(true);
			}
			else
			{
				Bpiece2.setDisable(false);
				moveThruGrids(pa, ct, g, r, Bpiece2, 1);
			}
			
			if (pa[ct].isStart(2) || pa[ct].hasInfront(2, r))
			{
				Bpiece3.setDisable(true);
			}
			else
			{
				Bpiece3.setDisable(false);
				moveThruGrids(pa, ct, g, r, Bpiece3, 2);
			}
			
			if (pa[ct].isStart(3) || pa[ct].hasInfront(3, r))
			{
				Bpiece4.setDisable(true);
			}
			else
			{
				Bpiece4.setDisable(false);
				moveThruGrids(pa, ct, g, r, Bpiece4, 3);
			}
		}
		else if (pa[ct].getColor().equals("Yellow"))
		{
			if (pa[ct].isStart(0) || pa[ct].hasInfront(0, r))
			{
				Ypiece1.setDisable(true);
			}
			else
			{
				Ypiece1.setDisable(false);
				moveThruGrids(pa, ct, g, r, Ypiece1, 0);
			}
			
			if (pa[ct].isStart(1) || pa[ct].hasInfront(1, r))
			{
				Ypiece2.setDisable(true);
			}
			else
			{
				Ypiece2.setDisable(false);
				moveThruGrids(pa, ct, g, r, Ypiece2, 1);
			}
			
			if (pa[ct].isStart(2) || pa[ct].hasInfront(2, r))
			{
				Ypiece3.setDisable(true);
			}
			else
			{
				Ypiece3.setDisable(false);
				moveThruGrids(pa, ct, g, r, Ypiece3, 2);
			}
			
			if (pa[ct].isStart(3) || pa[ct].hasInfront(3, r))
			{
				Ypiece4.setDisable(true);
			}
			else
			{
				Ypiece4.setDisable(false);
				moveThruGrids(pa, ct, g, r, Ypiece4, 3);
			}
		}
	}
}