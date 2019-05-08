package com.lab5.airport.controller;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.lab5.airport.model.Airport;
import com.lab5.airport.model.Flight;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainWindowsController implements Initializable {

	  @FXML
	    private AnchorPane anchorPaneRoot;

	    @FXML
	    private VBox vBox;

	    @FXML
	    private HBox Hbox;

	    @FXML
	    private Pane dateHeaderPane;

	    @FXML
	    private Text labDateHeader;

	    @FXML
	    private GridPane gridPane;

	    @FXML
	    private Text dateGrid;

	    @FXML
	    private Text dateCompleteGrid;

	    @FXML
	    private Text airlineGrid;

	    @FXML
	    private Text flightGrid;

	    @FXML
	    private Text cityGrid;

	    @FXML
	    private Text gateGrid;

	    @FXML
	    private Button searchButton;

	    @FXML
	    private Button prevButton;

	    @FXML
	    private Button nextButton;

	    @FXML
	    private Button sortButton;
	    
	    private Airport airport;

	    @FXML
	    void next(ActionEvent event) {

	    }

	    @FXML
	    void prev(ActionEvent event) {

	    }

	    @FXML
	    void search(ActionEvent event) {

	    }

	    @FXML
	    void sort(ActionEvent event) {

	    }

		public void initialize(URL arg0, ResourceBundle arg1) {
			airport = new Airport();
			
			TextInputDialog dialog = new TextInputDialog("");
			dialog.setTitle("Generar datos aleatorios");
			dialog.setHeaderText(null);
			dialog.setContentText("¿Cuantos datos desea generar?");
			// Traditional way to get the response value.
			Optional<String> result = dialog.showAndWait();
			try {
				int number = Integer.parseInt(result.get());
				airport.generateData(number);
				//airport.bubbleSortDate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Flight current = airport.getFlight();
			System.out.println(airport.getFlightNumber());
			for (int i = 0; i < airport.getFlightNumber() && current != null; i++) {
				System.out.println(current.getDateFormated());
				current = current.getNext();
			}
			
			/*Flight current = null;
			for (int i = 1; i < 10; i++) {
				current = airport.getFlight();
				String time = current.getDateFormated();
				gridPane.add(new Text(current.getDate().getHours()+":"+), 0, i);
			}*/
		}

}

