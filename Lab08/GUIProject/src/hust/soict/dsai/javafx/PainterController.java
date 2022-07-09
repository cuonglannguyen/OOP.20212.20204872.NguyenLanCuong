package hust.soict.dsai.javafx;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class PainterController {
    @FXML
    private javafx.scene.layout.VBox VBox;
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
    	Rectangle clip = new Rectangle();
    	clip.widthProperty().bind(drawingAreaPane.widthProperty());
    	clip.heightProperty().bind(drawingAreaPane.heightProperty());
    	drawingAreaPane.setClip(clip);
    	drawingAreaPane.getChildren().add(newCircle);
    	

    }

}