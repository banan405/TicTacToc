package lab6;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException ;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tic extends Application implements EventHandler<ActionEvent>  {
	public Button button[][];
	public int who = 0; //0 = o and 1 is X
	public GridPane pane;
	int turn =0;
	public TicClass game;
	public Button startAgain;
	
	public int clickWho() {
		
		return who;
	}
	public void clickWhoAfter() {
		if(who==0) {
			who=1;
		}else {
			who=0;
		}
	}
 static void main(String[] arg) throws  IOException {
		launch(arg);
}
 public void handle(ActionEvent event) {
		
		Image o = new Image("file:image/o.jpg");
		Image x = new Image("file:image/x.jpg");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(event.getSource()==button[i][j]) {
					game.Clickboard(who,i, j);
					if(who==0){
						button[i][j].setGraphic(new ImageView(o));
					
					}else{
						button[i][j].setGraphic(new ImageView(x));
					}
				
					button[i][j].setDisable(true);
					clickWhoAfter();
					if(2==game.checkWinner()) { // not win
						turn++;
						if(turn==9) {
							Stage alarm = new Stage();
							Pane pane = new Pane();
							
							Text t = new Text(50,50,"Tie!!");
							t.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
							
							pane.getChildren().add(t);
							
							Scene n = new Scene(pane,200,100);
							
							alarm.setScene(n);
							alarm.show();
							
						}
						continue;
					
						
					}else if(game.checkWinner()==0){ // o is winner
						
						Stage alarm = new Stage();
						Pane pane = new Pane();
						
						Text t = new Text(50,50,"O is Winner!");
						t.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
						pane.getChildren().add(t);
								
							
						
						
						Scene n = new Scene(pane,200,100);
						alarm.setScene(n);
						alarm.show();
					
						block();
					}else { // x is winner
						Stage alarm = new Stage();
						Pane pane = new Pane();
						
						Text t = new Text(50,50,"X is Winner!");
					t.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 20));
					
				
					
						pane.getChildren().add(t);
					
					
						Scene n = new Scene(pane,200,100);
						alarm.setScene(n);
						alarm.show();
						
				
						block();
					}
				}
			}
		}	
 }
	
	
	public void block() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				
				
					button[i][j].setDisable(true);
					
				
			}
		}
	}
	public void cleanup(Stage pp) throws  IOException {
		reStart(pp);
		
	}
	public void reStart(Stage primaryStage) throws  IOException {
		try {
			primaryStage.close();
			Stage newStage = new Stage();
			startGame(newStage);
			
		}catch(InvocationTargetException e){
			
		}
		
	}
	public void startGame(Stage primaryStage) throws  IOException,InvocationTargetException  {
	turn=0;
		 game = new TicClass();
		 startAgain =  new Button("Start Again?");
		 pane = new GridPane();
		 Image none = new Image("file:image/n.jpg");
		 
		
			button = new Button[3][3];
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					button[i][j] = new Button();
					button[i][j].setGraphic(new ImageView(none));
					button[i][j].setOnAction(this);
					pane.add(button[i][j],j, i);
				}
			}

			Scene scene = new Scene(pane, 410	, 410);
			
			
		
			pane.add(startAgain,2,4);
			
			
			startAgain.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent e) {
				
				try {
					reStart(primaryStage);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				}
				
			});

		
			
			primaryStage.setTitle("Tic Tac Toe Board"); // Set title for stage
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage
	}
	public void start(Stage primaryStage)  throws  IOException,InvocationTargetException {
		startGame(primaryStage);

	}
	
}
