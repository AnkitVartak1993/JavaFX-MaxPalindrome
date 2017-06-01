import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene;
import javafx.scene.layout.GridPane; 
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class MaxPalindrome extends Application {

	@Override
	public void start(Stage stage)
	{
		//creating labels and input fields
		String maxPalFinal="Result : ";
		Label result = new Label( maxPalFinal);
		Text text1 = new Text("Minimum number");
		Text text2 = new Text("Maximum number");
		TextField textField1 = new TextField();
		TextField textField2 = new TextField();  
		
		// creating button
		Button button1 = new Button("Search Maximum Palindrome"); 
		
		
		// Configuring Gridpane
		GridPane gridPane = new GridPane();
		gridPane.setMinSize(500, 500);
	    gridPane.setPadding(new Insets(10, 10, 10, 10)); 
	    gridPane.setVgap(5); 
	    gridPane.setHgap(5);
	    gridPane.setAlignment(Pos.CENTER);
		
	    gridPane.add(result,1,0);
	    gridPane.add(text1, 0, 1); 
	    gridPane.add(textField1, 1, 1); 
	    gridPane.add(text2, 0, 2);       
	    gridPane.add(textField2, 1, 2);
	    gridPane.add(button1, 1, 3); 
	    
	    //Creating scene object
	    Scene scene = new Scene(gridPane); 
	    
	    //giving name to stage
	    stage.setTitle("Maximum Palindrome");
	    
	    //Adding scene to the stage
	    stage.setScene(scene);
	    
	    //Displaying contents of stage
	    stage.show(); 
	    
	    //Button event on pressing search button by User
	    button1.setOnAction((ActionEvent e) -> {
	    	
	    	// Storing user inputs in strings
	    	String txt1 = textField1.getText().toString();
	    	String txt2 = textField2.getText().toString();
	    	int lowNum ;
	    	int highNum;
	    	
	    	//checkInput method to check if both the inputs are correct
	    	boolean numValid= checkInput(txt1, txt2);
	    	
	    	//if both inputs are correct then calling MaxPal
	    	if (numValid)
    	    {
    	    	lowNum =Integer.parseInt(txt1);
    	    	    highNum = Integer.parseInt(txt2);
    	    	     System.out.println(maxPalFinal);
    	    	     
    	    	     //Setting result label to the final answer.
    	    	    result.setText("Result : "+ MaxPal(lowNum,highNum) );
    	    	    
    	    }
	    	
	    	
	    	
	    	
	    });
	    
	    
	}
	//input validation checker method
	public boolean checkInput(String txt1, String txt2)
	{
		boolean f1=     txt1.matches("[0-9]+");
		boolean f2=     txt2.matches("[0-9]+");
		if (! (f1 && f2 ))
		 { 
			
            giveWarning("Please make sure to enter only natural numbers!");
          	f1 = false;	 

		 }
		if( (txt1.length()<10 && txt2.length()<10 ) &&  ( Double.parseDouble(txt1) <= 2147483647  &&    Double.parseDouble(txt2) <=2147483647   ))
		 {
		     if (Double.parseDouble(txt1)>Double.parseDouble(txt2))
		     {
		    	 f1= false;
		    	 giveWarning( "Please make sure That lower bound is less than Max Bound!");
		     }

		 }
		else {
			 f1= false;
		 giveWarning("Number shouldn't be greater than 2147483647");
		 
		 }
		return f1;
	}
	
	//Alert generator method
	public void giveWarning(String msg)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
	       alert.setTitle("Wrong Input");
	       alert.setHeaderText("Wrong Input Warning");
	       alert.setContentText(msg);
	       alert.showAndWait();
		
	}
	
	//Method to calculate maximum palindrome in given range
	public String MaxPal(int num1 , int num2)
	   {
		int maxPal = 0;
		  
		   
		   
	       int sum , temp , rem;
	   for(int i=num1;i<=num2;i++)
		{
			   sum=0;
			   temp=i;
			
			   		while(temp>0)
			   		{
				
			   			rem=temp%10;
			   			temp=temp/10;
			   			sum=(sum*10)+rem;
			   		}
			
			   		if(i==sum)
			   		{
			   			maxPal = i;
			   		}
		
	   }
	   
	   if (maxPal==0)
		   return "Not Found!";
	   else
	   return Integer.toString(maxPal);
	  }
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
