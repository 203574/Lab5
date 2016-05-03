package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import it.polito.tdp.model.Parola;
import it.polito.tdp.model.Ricerca;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class RuzzleController
{
	Ricerca ricerca = new Ricerca();
	String lettere = new String();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane grid;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl7;

    @FXML
    private Label lbl8;

    @FXML
    private Label lbl9;

    @FXML
    private Label lbl10;

    @FXML
    private Label lbl11;

    @FXML
    private Label lbl12;

    @FXML
    private Label lbl13;

    @FXML
    private Label lbl14;

    @FXML
    private Label lbl15;

    @FXML
    private Label lbl16;


    @FXML
    private Button buttonGenera;

    @FXML
    private ListView<Parola> listResult;
    private 

    @FXML
    void doGenera(ActionEvent event) 
    {
    	listResult.setVisible(false);
    	grid.setVisible(false);
    	StringBuffer sb = new StringBuffer();
    	char v;
    	int k;
    	Random r = new Random(System.currentTimeMillis());
    	for (int i=0; i<16;i++) 
    	{
    		k = r.nextInt(21); 
    		k = k + 97;
    		v = (char) k;
    		sb.append(v); 
    	}
    	lettere = sb.toString();
    	lbl1.setText(lettere.substring(0, 1));
    	lbl2.setText(lettere.substring(1, 2));
    	lbl3.setText(lettere.substring(2, 3));
    	lbl4.setText(lettere.substring(3, 4));
    	lbl5.setText(lettere.substring(4, 5));
    	lbl6.setText(lettere.substring(5, 6));
    	lbl7.setText(lettere.substring(6, 7));
    	lbl8.setText(lettere.substring(7, 8));
    	lbl9.setText(lettere.substring(8, 9));
    	lbl10.setText(lettere.substring(9, 10));
    	lbl11.setText(lettere.substring(10, 11));
    	lbl12.setText(lettere.substring(11, 12));
    	lbl13.setText(lettere.substring(12, 13));
    	lbl14.setText(lettere.substring(13, 14));
    	lbl15.setText(lettere.substring(14, 15));
    	lbl16.setText(lettere.substring(15, 16));
    	grid.setVisible(true);
    	ricerca.doPermutazioni(lettere);
    	ObservableList<Parola> items = FXCollections.observableArrayList(ricerca.getSoluzioni());
    	listResult.setItems(items);
    	listResult.setVisible(true);

    }

    @FXML
    void initialize() 
    {
        assert grid != null : "fx:id=\"grid\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl1 != null : "fx:id=\"lbl1\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl2 != null : "fx:id=\"lbl2\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl3 != null : "fx:id=\"lbl3\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl4 != null : "fx:id=\"lbl4\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl5 != null : "fx:id=\"lbl5\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl6 != null : "fx:id=\"lbl6\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl7 != null : "fx:id=\"lbl7\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl8 != null : "fx:id=\"lbl8\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl9 != null : "fx:id=\"lbl9\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl10 != null : "fx:id=\"lbl10\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl11 != null : "fx:id=\"lbl11\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl12 != null : "fx:id=\"lbl12\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl13 != null : "fx:id=\"lbl13\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl14 != null : "fx:id=\"lbl14\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl15 != null : "fx:id=\"lbl15\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert lbl16 != null : "fx:id=\"lbl16\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert buttonGenera != null : "fx:id=\"buttonGenera\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert listResult != null : "fx:id=\"listResult\" was not injected: check your FXML file 'Ruzzle.fxml'.";
		/*ObservableList<Node> children = grid.getChildren();
		for(Node node :children)
		{
			if(node instanceof Label)
			{
				Label l =(Label)node;
				l.setStyle("-fx-background-color: green");
				
			}
			if(node instanceof Pane)
			{
				Pane l =(Pane)node;
				l.setStyle("-fx-background-color: green");
				
			}
		}*/

        grid.setVisible(false);
        listResult.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Parola>() {
 					@Override
					public void changed(ObservableValue<? extends Parola> observable, Parola oldValue,
							Parola newValue) {
 						ObservableList<Node> children = grid.getChildren();
 						if(oldValue!=null)
	 						for(Integer index:oldValue.getPosizioni()) {
								Node node = children.get(index);
								if(node instanceof Label)
								{
									Label l =(Label)node;
									l.setStyle("-fx-background-color: green; -fx-background-radius: 10px; -fx-label-padding: 10px;");
								}
								
							}
 						if(newValue!=null)
	 						for(Integer index:newValue.getPosizioni()) {
								Node node = children.get(index);
								if(node instanceof Label)
								{
									Label l =(Label)node;
									l.setStyle("-fx-background-color: red; -fx-background-radius: 10px; -fx-label-padding: 10px;");
								}
								
							}
						
					}
            });

    }
}
