package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label; 
import javafx.scene.control.TextField; 
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.util.ResourceBundle;

public class LaporanController implements Initializable{

    @FXML
    private AnchorPane Laporan;

    @FXML
    private ComboBox<String> ComboList;
    private String[] kategori = {"Pohon", "Jalan Rusak", "Kemacetan", "Kecelakaan", "Parkir Liar"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ComboList.getItems().addAll(kategori);
    }

    /*public void getKategori(ActionEvent event) {
        String kategori = ComboList.getValue();
    } */

    
    


}

