package com.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class LaporanController implements Initializable{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> myChoiceBox;
    private String[] kategori = {"Pohon", "Jalan Rusak"};

    @FXML
    void initialize() {
        assert myChoiceBox != null : "fx:id=\"myChoiceBox\" was not injected: check your FXML file 'Laporan.fxml'.";

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        myChoiceBox.getItems().addAll(kategori);
        //throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

}

