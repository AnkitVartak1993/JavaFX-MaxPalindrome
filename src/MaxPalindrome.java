import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene;
import javafx.scene.layout.GridPane; 
import javafx.stage.Stage;
import javafx.scene.control.Label;
public class MaxPalindrome extends Application {

	@Override
	public void start(Stage stage)
	{
		//creating labels and input fields
		String maxPalFinal="Result : ";
		Label result = new Label( maxPalFinal);
		
		
		
		GridPane gridPane = new GridPane();
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
	    gridPane.setVgap(5); 
	    gridPane.setHgap(5);
	    gridPane.setAlignment(Pos.CENTER);
		
	    gridPane.add(result,1,0);
	    
	    Scene scene = new Scene(gridPane); 
	    stage.setTitle("Maximum Palindrome");
	    
	    stage.setScene(scene);
	    stage.show(); 
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
