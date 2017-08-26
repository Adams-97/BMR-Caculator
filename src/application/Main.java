package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane grid = new GridPane();
			
			
			Label title = new Label();
			title.setText("BMR Caculator");
			title.setStyle("-fx-font-size: 18;");
			grid.add(title, 5, 0,5, 5);
			
			ToggleGroup tog = new ToggleGroup();
			
			RadioButton rbM = new RadioButton();
			rbM.setToggleGroup(tog);
		    rbM.setSelected(true);
			grid.add(rbM, 5, 50);
			
			RadioButton rbF = new RadioButton();
			rbF.setToggleGroup(tog);
			grid.add(rbF, 7, 50);
		
			Label TxM = new Label();
			TxM.setText("Male");
			grid.add(TxM, 6, 50);
		
			Label TxF = new Label();
			TxF.setText("Female");
			grid.add(TxF, 8, 50);
			
			
			Label TxAge = new Label();
			TxAge.setText("    Age: ");
			grid.add(TxAge, 0, 40);
					
					
			Label TxGender = new Label();
			TxGender.setText("    Gender: ");
			grid.add(TxGender, 0, 50);
			
			Label H = new Label();
			H.setText("    Height: ");
			grid.add(H, 0, 60);
			
			Label W = new Label();
			W.setText("    Weight: ");
			grid.add(W, 0, 70);
		
			
	
			TextField TbAge = new TextField();
			grid.add(TbAge, 5, 40,5,1);
			
			TextField TbH = new TextField();
			grid.add(TbH, 5, 60,5,1);
			
			TextField TbW = new TextField();
			grid.add(TbW, 5, 70,5,1);

					
			Button btn = new Button("Caculate");
			grid.add(btn, 0, 80, 5,1);
		
			Label out = new Label();
			grid.add(out, 5, 100, 5, 1);
			
			btn.setOnAction((ActionEvent event) -> {
				try{
				double h = Double.parseDouble(TbH.getText())*6.25;
				double w = Double.parseDouble(TbW.getText())*10;
				double a = Double.parseDouble(TbAge.getText())*5;
				double bmrM =w+h-a+5;
				double bmrF = w+h-a-161;
				double roundM = Math.round(bmrM*100.0)/100.0;
				double roundF = Math.round(bmrF*100.0)/100.0;
				if(h>0 && w>0 && a>0 && rbM.isSelected()){
					out.setText("BMR= " +Double.toString(roundM) + " Calories" );
				}
				else if(h>0 && w>0 && a>0 && rbF.isSelected()){
					out.setText("BMR= " + Double.toString(roundF) + " Calories" );
				}
				else
				{
				
					out.setText("Failed, please input a positve value");
				}
				}
           catch(Exception e){
        	   out.setStyle("-fx-text-fill: red; -fx-font-size: 16;");
        	   out.setText("Please only input numbers!");
        	   
            }
			}
			
			);
			
			
			Scene scene = new Scene(grid,270,310);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
