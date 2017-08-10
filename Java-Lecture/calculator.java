import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.scene.shape.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.event.*;


public class calculator extends Application
{
    private Label labelX,labelY,equals;
    private Button add, subtract, multiply, divide;
    private TextField tfx, tfy, answer;
    private FlowPane fp;
    private Scene scene;
    /*public static void main(String args [])
    {
        launch(args);
    }*/
    public void init(){
        System.out.println("Program starts!");
    }
    public void stop(){}
    public void start(Stage primarystage)
    {
        primarystage.setTitle("Calculator");
        fp = new FlowPane(15,15);
        fp.setAlignment(Pos.CENTER);

        labelX = new Label("Enter x : ");
        tfx = new TextField();

        labelY = new Label("Enter y : ");
        tfy = new TextField();

        equals = new Label("=");

        answer = new TextField();

        tfx.setPrefColumnCount(4);
        tfy.setPrefColumnCount(4);
        answer.setPrefColumnCount(4);

        answer.setEditable(false);

        add = new Button("+");
        subtract = new Button("-");
        multiply = new Button("*");
        divide = new Button("/");

        fp.getChildren().addAll(labelX,tfx,add,subtract,multiply,divide,labelY,tfy,equals,answer);

        AddActionHandler a = new AddActionHandler();
        add.setOnAction(a);

        SubtractActionHandler b = new SubtractActionHandler();
        subtract.setOnAction(b);

        MultiplyActionHandler c = new MultiplyActionHandler();
        multiply.setOnAction(c);

        DivideActionHandler d = new DivideActionHandler();
        divide.setOnAction(d);

        scene = new Scene(fp,500,500);
        primarystage.setScene(scene);
        primarystage.setResizable(false);
        primarystage.show();  
    } 
    private class AddActionHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            answer.setText(" " + ((Double.parseDouble(tfx.getText())) + (Double.parseDouble(tfy.getText()))));
        }
    }
    private class SubtractActionHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            answer.setText(" " + ((Double.parseDouble(tfx.getText())) - (Double.parseDouble(tfy.getText()))));
        }
    }
    private class MultiplyActionHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            answer.setText(" " + ((Double.parseDouble(tfx.getText())) * (Double.parseDouble(tfy.getText()))));
        }
    }
    private class DivideActionHandler implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent e)
        {
            answer.setText(" " + ((Double.parseDouble(tfx.getText())) / (Double.parseDouble(tfy.getText()))));
        }
    }
}
 
