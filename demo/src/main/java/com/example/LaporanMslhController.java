package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LaporanMslhController {

    @FXML
    private TableView<Item> tableView;

    @FXML
    private TableColumn<Item, Integer> columnNo;

    @FXML
    private TableColumn<Item, String> columnDeskripsi;

    @FXML
    private TableColumn<Item, String> columnLokasi;

    @FXML
    public void initialize() {
        columnNo.setCellValueFactory(new PropertyValueFactory<>("no"));
        columnDeskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        columnLokasi.setCellValueFactory(new PropertyValueFactory<>("lokasi"));

        loadCSVData();
    }

    private void loadCSVData() {
        String csvFile = "data.csv"; // Adjust the path to your CSV file
        String line;
        String csvSplitBy = ",";

        ObservableList<Item> data = FXCollections.observableArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] items = line.split(csvSplitBy);
                if (items.length == 3) {
                    Item item = new Item(Integer.parseInt(items[0]), items[1], items[2]);
                    data.add(item);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tableView.setItems(data);
    }

    public static class Item {
        private final Integer no;
        private final String deskripsi;
        private final String lokasi;

        public Item(Integer no, String deskripsi, String lokasi) {
            this.no = no;
            this.deskripsi = deskripsi;
            this.lokasi = lokasi;
        }

        public Integer getNo() {
            return no;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public String getLokasi() {
            return lokasi;
        }
    }
}
