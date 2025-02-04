package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class LaporanMslhController {

    @FXML
    private TableView<Issue> tableView;

    @FXML
    private TableColumn<Issue, String> columnNo;

    @FXML
    private TableColumn<Issue, String> columnJudul;

    @FXML
    private TableColumn<Issue, String> columnKategori;

    @FXML
    private TableColumn<Issue, String> columnLokasi;

    @FXML
    private TableColumn<Issue, String> columnDeskripsi;

    @FXML
    private TableColumn<Issue, String> columnTanggal;

    @FXML
    private Button deleteButton;

    @FXML
    private Button lanjutbButton;

    @FXML
    private Button homeButton;

    private ObservableList<Issue> issueData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        columnNo.setCellValueFactory(new PropertyValueFactory<>("no"));
        columnJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
        columnKategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        columnLokasi.setCellValueFactory(new PropertyValueFactory<>("lokasi"));
        columnDeskripsi.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));
        columnTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));

        loadCSVData();
        tableView.setItems(issueData);

        deleteButton.setOnAction(event -> deleteSelectedIssue());
    }

    @FXML
    void handledetail(ActionEvent event) {
        TableView.TableViewSelectionModel selectionModel = tableView.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        int i = selectionModel.getSelectedIndex();
        String index = Integer.toString(i);
        Path path = Paths.get("indexL.csv");
        try {
            Files.deleteIfExists(path);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        File file = new File("indexL.csv");
        
        try (FileWriter writer = new FileWriter(file, true)) {
            
            writer.write(index);
          

            System.out.println("Data appended to data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            loadPage("detail.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void loadPage(String fxmlFile) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene (root);
            Stage stage = new Stage();
            stage.setScene(scene);    
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleHomeButtonAction() {
        System.out.println("Home button clicked");
        try {
            loadPage("/com/example/HomePagePem.fxml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void loadCSVData() {
        String csvFile = "data.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                Issue issue = new Issue(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5]
                );

                issueData.add(issue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteSelectedIssue() {
        Issue selectedIssue = tableView.getSelectionModel().getSelectedItem();
        if (selectedIssue != null) {
            issueData.remove(selectedIssue);
            tableView.refresh();
            saveAllDataToCSV();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Issue Selected");
            alert.setContentText("Please select an issue in the table.");
            alert.showAndWait();
        }
    }

    private void saveAllDataToCSV() {
        File file = new File("data.csv");

        try (FileWriter writer = new FileWriter(file)) {
            for (Issue issue : issueData) {
                writer.append(issue.getNo()).append(",");
                writer.append(issue.getJudul()).append(",");
                writer.append(issue.getKategori()).append(",");
                writer.append(issue.getLokasi()).append(",");
                writer.append(issue.getDeskripsi()).append(",");
                writer.append(issue.getTanggal()).append("\n");
            }

            System.out.println("Data saved to data.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Issue {
        private String no;
        private String judul;
        private String kategori;
        private String lokasi;
        private String deskripsi;
        private String tanggal;

        public Issue(String no, String judul, String kategori, String lokasi, String deskripsi, String tanggal) {
            this.no = no;
            this.judul = judul;
            this.kategori = kategori;
            this.lokasi = lokasi;
            this.deskripsi = deskripsi;
            this.tanggal = tanggal;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getJudul() {
            return judul;
        }

        public void setJudul(String judul) {
            this.judul = judul;
        }

        public String getKategori() {
            return kategori;
        }

        public void setKategori(String kategori) {
            this.kategori = kategori;
        }

        public String getLokasi() {
            return lokasi;
        }

        public void setLokasi(String lokasi) {
            this.lokasi = lokasi;
        }

        public String getDeskripsi() {
            return deskripsi;
        }

        public void setDeskripsi(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        public String getTanggal() {
            return tanggal;
        }

        public void setTanggal(String tanggal) {
            this.tanggal = tanggal;
        }
    }
}
