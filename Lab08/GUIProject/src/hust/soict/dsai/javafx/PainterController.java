package hust.soict.dsai.javafx;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;


    @FXML
    private RadioButton eraser;

    @FXML
    private ToggleGroup identical;

    @FXML
    private RadioButton pen;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();

    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Color color;
    	if (((RadioButton) identical.getSelectedToggle()).equals(pen))
{				color = Color.BLACK;}
    	else {
    		color = Color.WHITE;
    	}
    	Circle newCircle = new Circle(event.getX(),event.getY(), 4, color);
    	
    	drawingAreaPane.getChildren().add(newCircle);
    	

    }

}