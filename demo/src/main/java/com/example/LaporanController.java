package com.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;


public class LaporanController implements Initializable{

    @FXML
    private ComboBox<String>comboBox;

    @FXML
    void Select(ActionEvent event) {
        String selected = comboBox.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("Pohon", "Jalan Rusak");
        comboBox.setItems(list);
    }
}

