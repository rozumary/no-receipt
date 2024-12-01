/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movie.ticket.booking.system;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DashboardController implements Initializable {

    @FXML
    private Button addMovies_btn;

    @FXML
    private Button addMovies_clearBtn;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_date;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_duration;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_genre;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_movieTitle;

    @FXML
    private DatePicker addMovies_date;

    @FXML
    private Button addMovies_deleteBtn;

    @FXML
    private TextField addMovies_duration;

    @FXML
    private AnchorPane addMovies_form;

    @FXML
    private TextField addMovies_genre;

    @FXML
    private ImageView addMovies_imageView;

    @FXML
    private Button addMovies_import;

    @FXML
    private Button addMovies_insertBtn;

    @FXML
    private TextField addMovies_movieTitle;

    @FXML
    private TextField addMovies_search;

    @FXML
    private TableView<moviesData> addMovies_tableView;

    @FXML
    private Button addMovies_updateBtn;

    @FXML
    private Button availableMovies_btn;

    @FXML
    private Button availableMovies_buyBtn;

    @FXML
    private Button availableMovies_clearBtn;

    @FXML
    private TableColumn<moviesData, String> availableMovies_col_genre;

    @FXML
    private TableColumn<moviesData, String> availableMovies_col_movieTitle;

    @FXML
    private TableColumn<moviesData, String> availableMovies_col_showingDate;

    @FXML
    private Label availableMovies_date;

    @FXML
    private AnchorPane availableMovies_form;

    @FXML
    private Label availableMovies_genre;

    @FXML
    private ImageView availableMovies_imageView;

    @FXML
    private Label availableMovies_movieTitle;

    @FXML
    private Label availableMovies_normalClass_price;

    @FXML
    private Spinner<Integer> availableMovies_normalClass_quantity;

    @FXML
    private Button availableMovies_receiptBtn;

    @FXML
    private Button availableMovies_refundBtn;

    @FXML
    private Button availableMovies_selectMovie;

    @FXML
    private Label availableMovies_specialClass_price;

    @FXML
    private Spinner<Integer> availableMovies_specialClass_quantity;

    @FXML
    private TableView<moviesData> availableMovies_tableView;

    @FXML
    private Label availableMovies_title;

    @FXML
    private Label availableMovies_total;

    @FXML
    private FontAwesomeIconView close;

    @FXML
    private Button customers_btn;

    @FXML
    private Button customers_clearBtn;

    @FXML
    private TableView<customerData> customer_tableView;

    @FXML
    private TableColumn<customerData, String> customers_col_date;

    @FXML
    private TableColumn<customerData, String> customers_col_genre;

    @FXML
    private TableColumn<customerData, String> customers_col_movieTitle;

    @FXML
    private TableColumn<customerData, String> customers_col_ticketNumber;

    @FXML
    private TableColumn<customerData, String> customers_col_time;

    @FXML
    private Label customers_date;

    @FXML
    private Button customers_deleteBtn;

    @FXML
    private AnchorPane customers_form;

    @FXML
    private Label customers_genre;

    @FXML
    private Label customers_movieTitle;

    @FXML
    private TextField customers_search;

    @FXML
    private Label customers_ticketNumber;

    @FXML
    private Label customers_time;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_totalEarnings;

    @FXML
    private Label dashboard_totalSoldTicket;

    @FXML
    private Label dashboard_availableMovies;

    @FXML
    private Button editScreening_btn;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_current;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_duration;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_genre;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_movieTitle;

    @FXML
    private ComboBox<?> editScreening_current;

    @FXML
    private Button editScreening_deleteBtn;

    @FXML
    private AnchorPane editScreening_form;

    @FXML
    private ImageView editScreening_imageView;

    @FXML
    private TextField editScreening_search;

    @FXML
    private TableView<moviesData> editScreening_tableView;

    @FXML
    private Label editScreening_title;

    @FXML
    private Button editScreening_updateBtn;

    @FXML
    private FontAwesomeIconView minimize;

    @FXML
    private Button signout;

    @FXML
    private AnchorPane topForm;

    @FXML
    private Label username;

    @FXML
   void logout(ActionEvent event) {
    String username = getData.username;

    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Logout Confirmation");
    alert.setHeaderText(null);
    alert.setContentText("Are you sure you want to log out, " + username + "?");

    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent() && result.get() == ButtonType.OK) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setFullScreen(true);
            stage.setFullScreenExitHint(""); 


            stage.centerOnScreen();

            root.setOnMousePressed(mouseEvent -> {
                x = mouseEvent.getSceneX();
                y = mouseEvent.getSceneY();
            });

            root.setOnMouseDragged(mouseEvent -> {
                stage.setX(mouseEvent.getScreenX() - x);
                stage.setY(mouseEvent.getScreenY() - y);
            });

            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

    private Image image;

    private double x = 0;
    private double y = 0;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private SpinnerValueFactory<Integer> spinner1;
    private SpinnerValueFactory<Integer> spinner2;

    private float price1 = 0;
    private float price2 = 0;
    private float total = 0;
    private int qty1 = 0;
    private int qty2 = 0;

    private int totalMovies;

   public void totalAvailableMovies() {
    String sql = "SELECT COUNT(*) FROM movie WHERE current = 'Showing'";  
    
    connect = database.connectDb();
    
    try {
        prepare = connect.prepareStatement(sql);
        result = prepare.executeQuery();
        
        if (result.next()) {
            totalMovies = result.getInt(1);  
        }
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    public void displayTotalAvailableMovies() {

        totalAvailableMovies();
        dashboard_availableMovies.setText(String.valueOf(totalMovies));
    }

    private double totalEarnings;

    public void totalEarnings() {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "SELECT SUM(total) FROM customer WHERE date = ?";  

        connect = database.connectDb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setDate(1, sqlDate);  
            result = prepare.executeQuery();

            if (result.next()) {
                totalEarnings = result.getDouble(1);  
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayTotalEarnings() {
        totalEarnings();
        dashboard_totalEarnings.setText("₱" + String.valueOf(totalEarnings));
    }

    private int soldTicket;

    public void countTicket() {

        String sql = "SELECT count(id) FROM  customer";

        connect = database.connectDb();

        try {

            customerData customerD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                soldTicket = result.getInt("count(id)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayTotalSoldTicket() {
        countTicket();
        dashboard_totalSoldTicket.setText(String.valueOf(soldTicket));
    }

    public ObservableList<customerData> customerList() {
        ObservableList<customerData> customerL = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer";

        connect = database.connectDb();
        try {

            customerData customerD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                customerD = new customerData(result.getInt("id"),
                        result.getString("type"),
                        result.getString("movieTitle"),
                        result.getInt("quantity"),
                        result.getDouble("total"),
                        result.getDate("date"),
                        result.getTime("time"));

                customerL.add(customerD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerL;
    }

    public ObservableList<customerData> custList;

    public void showCustomerList() {
        custList = customerList();

        customers_col_ticketNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        customers_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        customers_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        customers_col_time.setCellValueFactory(new PropertyValueFactory<>("time"));

        customer_tableView.setItems(custList);
    }

    public void selectCustomerList() {

        customerData custD = customer_tableView.getSelectionModel().getSelectedItem();
        int num = customer_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < - 1) {
            return;
        }
        customers_ticketNumber.setText(String.valueOf(custD.getId()));
        customers_movieTitle.setText(custD.getTitle());
        customers_date.setText(String.valueOf(custD.getDate()));
        customers_time.setText(String.valueOf(custD.getTime()));
    }

    public void clearCustomer() {
        customers_ticketNumber.setText("");
        customers_movieTitle.setText("");
        customers_date.setText("");
        customers_time.setText("");
    }

    public void deleteCustomer() {
        customerData custD = customer_tableView.getSelectionModel().getSelectedItem();
        if (custD == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Delete Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please select a customer to delete.");
            alert.showAndWait();
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirm Deletion");
        confirm.setHeaderText(null);
        confirm.setContentText("Are you sure you want to delete this customer?");
        Optional<ButtonType> result = confirm.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            try {

                String sql = "DELETE FROM customer WHERE id = ?";
                connect = database.connectDb();
                prepare = connect.prepareStatement(sql);
                prepare.setInt(1, custD.getId());
                prepare.executeUpdate();

                custList.remove(custD);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Deletion Successful");
                alert.setHeaderText(null);
                alert.setContentText("Customer deleted successfully!");
                alert.showAndWait();

                clearCustomer();

            } catch (Exception e) {
                e.printStackTrace();

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Failed to delete customer.");
                alert.showAndWait();
            }
        }
    }

    public void searchCustomer() {
        String searchQuery = customers_search.getText().toLowerCase();

        if (searchQuery.isEmpty()) {
            custList = customerList();
        } else {
            ObservableList<customerData> filteredList = FXCollections.observableArrayList();

            for (customerData cust : customerList()) {
                if (String.valueOf(cust.getId()).toLowerCase().contains(searchQuery)
                        || cust.getTitle().toLowerCase().contains(searchQuery)
                        || String.valueOf(cust.getDate()).toLowerCase().contains(searchQuery)
                        || String.valueOf(cust.getTime()).toLowerCase().contains(searchQuery)) {
                    filteredList.add(cust);
                }
            }

            custList = filteredList;
        }

        customer_tableView.setItems(custList);
    }
    
    public void receipt() {
    }

    private int num;
    private int qty;

    public void buy() {
        String sql = "INSERT INTO customer (type, movieTitle, quantity, total, date, time) VALUES (?, ?, ?, ?, ?, ?)";
        connect = database.connectDb();

        String type = null;

        if (price1 > 0) {
            type = "Special Class";
        } else if (price2 > 0 && price1 == 0) {
            type = "Normal Class";
        } else if (price2 > 0 && price1 > 0) {
            type = "Special and Normal Class";
        }

        Date date = new Date();
        java.sql.Date setDate = new java.sql.Date(date.getTime());
        java.sql.Time setTime = new java.sql.Time(date.getTime());

        try {

            LocalTime localTime = LocalTime.now();

            Time time = Time.valueOf(localTime);

            qty = qty1 + qty2;

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, type);
            prepare.setString(2, availableMovies_movieTitle.getText());
            prepare.setInt(3, qty);
            prepare.setDouble(4, total);
            prepare.setDate(5, setDate);
            prepare.setTime(6, setTime);

            Alert alert;

            if (availableMovies_imageView.getImage() == null || availableMovies_movieTitle.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first!");
                alert.showAndWait();
            } else if (price1 == 0 && price2 == 0) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please indicate the quantity of ticket that you want to purchase.");
                alert.showAndWait();
            } else {
                prepare.executeUpdate();

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Successful");
                alert.setHeaderText(null);
                alert.setContentText("Successfully purchased!");
                alert.showAndWait();

                String sql1 = "SELECT * FROM customer";
                prepare = connect.prepareStatement(sql1);
                result = prepare.executeQuery();

                int num = 0;
                while (result.next()) {
                    num = result.getInt("id");
                }

                String sql2 = "INSERT INTO customer_info (id, customer_id, type, total, movieTitle, quantity) VALUES (?, ?, ?, ?, ?, ?)";
                prepare = connect.prepareStatement(sql2);
                prepare.setInt(1, num);
                prepare.setInt(2, num);
                prepare.setString(3, type);
                prepare.setString(4, String.valueOf(total));
                prepare.setString(5, availableMovies_movieTitle.getText());
                prepare.setInt(6, qty);
                prepare.executeUpdate();

                clearPurchaseTicketInfo();
            }
        } catch (Exception e) {
            e.printStackTrace();

            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("An error occurred!");
            errorAlert.setContentText("Details: " + e.getMessage());
            errorAlert.showAndWait();
        }
    }

    public void clearPurchaseTicketInfo() {
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

        availableMovies_specialClass_quantity.setValueFactory(spinner1);
        availableMovies_normalClass_quantity.setValueFactory(spinner2);

        availableMovies_specialClass_price.setText("₱0.0");
        availableMovies_normalClass_price.setText("₱0.0");
        availableMovies_total.setText("₱0.0");

        availableMovies_imageView.setImage(null);
        availableMovies_title.setText("");
    }

    public void showSpinnerValue() {

        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

        availableMovies_specialClass_quantity.setValueFactory(spinner1);
        availableMovies_normalClass_quantity.setValueFactory(spinner2);

    }

    public void getSpinnerValue(MouseEvent event) {

        qty1 = availableMovies_specialClass_quantity.getValue();
        qty2 = availableMovies_normalClass_quantity.getValue();

        price1 = (qty1 * 360);
        price2 = (qty2 * 180);

        total = (price1 + price2);

        availableMovies_specialClass_price.setText("₱" + String.valueOf(price1));
        availableMovies_normalClass_price.setText("₱" + String.valueOf(price2));

        availableMovies_total.setText("₱" + String.valueOf(total));

    }

    public ObservableList<moviesData> availableMoviesList() {

        ObservableList<moviesData> listAvMovies = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie WHERE current = 'Showing'";

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {
                movD = new moviesData(result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current"));

                listAvMovies.add(movD);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        return listAvMovies;
    }

    private ObservableList<moviesData> availableMoviesList;

    public void showAvailableMovies() {

        availableMoviesList = availableMoviesList();

        availableMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        availableMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        availableMovies_col_showingDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        availableMovies_tableView.setItems(availableMoviesList);
    }

    public void selectAvailableMovies() {
        moviesData movD = availableMovies_tableView.getSelectionModel().getSelectedItem();

        int num = availableMovies_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < - 1) {

            return;

        }
        availableMovies_title.setText(movD.getTitle());
        availableMovies_genre.setText(movD.getGenre());
        availableMovies_date.setText(String.valueOf(movD.getDate()));

        getData.path = movD.getImage();
        getData.title = movD.getTitle();
    }

    public void selectMovie() {

        Alert alert;

        if (availableMovies_title.getText().isEmpty()
                || availableMovies_genre.getText().isEmpty()
                || availableMovies_date.getText().isEmpty()) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first!");
            alert.showAndWait();
        } else {

            String uri = "file:" + getData.path;

            image = new Image(uri, 225, 231, false, true);

            availableMovies_imageView.setImage(image);

            availableMovies_movieTitle.setText(getData.title);

            availableMovies_title.setText("");
            availableMovies_genre.setText("");
            availableMovies_date.setText("");

        }
    }

    private String[] currentList = {"Showing", "End Showing"};

    public void comboBox() {
        List<String> listCurrent = new ArrayList<>();

        for (String data : currentList) {
            listCurrent.add(data);

        }
        ObservableList listC = FXCollections.observableArrayList(listCurrent);
        editScreening_current.setItems(listC);

    }

    public void updateEditScreening() {
        String sql = "UPDATE movie SET current = '" + editScreening_current.getSelectionModel().getSelectedItem()
                + "' WHERE movieTitle = '" + editScreening_title.getText() + "'";

        connect = database.connectDb();

        try {

            if (editScreening_title.getText().isEmpty() || editScreening_imageView.getImage() == null
                    || editScreening_current.getSelectionModel().isEmpty()) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first!");
                alert.showAndWait();
            } else {
                statement = connect.createStatement();
                statement.executeUpdate(sql);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Successful");
                alert.setHeaderText(null);
                alert.setContentText("Movie screening updated successfully!");
                alert.showAndWait();

                showEditScreening();
                clearEditScreening();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private ObservableList<moviesData> editScreeningL;

    public void clearEditScreening() {
        editScreening_title.setText("");
        editScreening_imageView.setImage(null);
        editScreening_current.getSelectionModel().clearSelection();
    }

    public void searchEditScreening() {
        FilteredList<moviesData> filter = new FilteredList<>(editScreeningL, e -> true);

        editScreening_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateMoviesData -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String keySearch = newValue.toLowerCase();

                if (predicateMoviesData.getTitle().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getGenre().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getDuration().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getDate().toString().contains(keySearch)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<moviesData> sortedData = new SortedList<>(filter);
        sortedData.comparatorProperty().bind(editScreening_tableView.comparatorProperty());
        editScreening_tableView.setItems(sortedData);
    }

    public void selectEditScreening() {
        moviesData movD = editScreening_tableView.getSelectionModel().getSelectedItem();
        int num = editScreening_tableView.getSelectionModel().getFocusedIndex();

        if (num >= 0) {
            String uri = "file:" + movD.getImage();
            image = new Image(uri, 246, 258, false, true);
            editScreening_imageView.setImage(image);

            editScreening_title.setText(movD.getTitle());
        }
    }

    private ObservableList<moviesData> editScreeningList() {
        ObservableList<moviesData> editScreeningL = FXCollections.observableArrayList();
        String sql = "SELECT * FROM movie";

        try {
            connect = database.connectDb();
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                moviesData movD = new moviesData(
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current")
                );
                editScreeningL.add(movD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (prepare != null) {
                    prepare.close();
                }
                if (connect != null) {
                    connect.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return editScreeningL;
    }

    public void showEditScreening() {
        editScreeningL = editScreeningList();

        editScreening_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        editScreening_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        editScreening_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        editScreening_col_current.setCellValueFactory(new PropertyValueFactory<>("current"));

        editScreening_tableView.setItems(editScreeningL);
    }

    public void searchAddMovies() {
        FilteredList<moviesData> filter = new FilteredList<>(listAddMovies, e -> true);

        addMovies_search.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicateMoviesData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String keySearch = newValue.toLowerCase();

                if (predicateMoviesData.getTitle().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getGenre().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getDuration().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getDate().toString().contains(keySearch)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<moviesData> sortedData = new SortedList<>(filter);

        sortedData.comparatorProperty().bind(addMovies_tableView.comparatorProperty());

        addMovies_tableView.setItems(sortedData);
    }

    public void importImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*png", "*jpeg", "*jpg"));

        Stage stage = (Stage) addMovies_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);

        if (file != null) {
            image = new Image(file.toURI().toString(), 214, 234, false, true);

            addMovies_imageView.setImage(image);

            getData.path = file.getAbsolutePath();
        }
    }

    public void insertAddMovies() {
        String sql1 = "SELECT * FROM movie WHERE movieTitle = ?";
        String sql2 = "INSERT INTO movie (movieTitle, genre, duration, image, date, current) VALUES (?, ?, ?, ?, ?, ?)";
        connect = database.connectDb();
        Alert alert;

        try {
            if (addMovies_movieTitle.getText().isEmpty()
                    || addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    || addMovies_imageView.getImage() == null
                    || addMovies_date.getValue() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields!");
                alert.showAndWait();
                return;
            }

            prepare = connect.prepareStatement(sql1);
            prepare.setString(1, addMovies_movieTitle.getText());
            result = prepare.executeQuery();

            if (result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(addMovies_movieTitle.getText() + " already exists!");
                alert.showAndWait();
                return;
            }

            prepare = connect.prepareStatement(sql2);
            prepare.setString(1, addMovies_movieTitle.getText());
            prepare.setString(2, addMovies_genre.getText());
            prepare.setString(3, addMovies_duration.getText());

            String uri = getData.path != null ? getData.path.replace("\\", "\\\\") : "";
            prepare.setString(4, uri);
            prepare.setString(5, String.valueOf(addMovies_date.getValue()));

            String currentStatus = "";
            prepare.setString(6, currentStatus);

            int rowsInserted = prepare.executeUpdate();
            if (rowsInserted > 0) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully added new movie!");
                alert.showAndWait();

                clearAddMoviesList();
                showAddMoviesList();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Failed to add the movie.");
                alert.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Database error: " + e.getMessage());
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Unexpected error: " + e.getMessage());
            alert.showAndWait();
        }
    }

    public void updateAddMovies() {
        String uri = getData.path != null ? getData.path.replace("\\", "\\\\") : null;

        String sql = "UPDATE movie SET movieTitle = ?, genre = ?, duration = ?, image = ?, date = ? WHERE movieTitle = ?";
        connect = database.connectDb();
        Alert alert;

        try {

            if (addMovies_movieTitle.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("No movie selected! Please select a movie to update.");
                alert.showAndWait();
                return;
            }

            if (addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    || addMovies_date.getValue() == null
                    || uri == null) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all fields before updating.");
                alert.showAndWait();
                return;
            }

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, addMovies_movieTitle.getText());
            prepare.setString(2, addMovies_genre.getText());
            prepare.setString(3, addMovies_duration.getText());
            prepare.setString(4, uri);
            prepare.setString(5, String.valueOf(addMovies_date.getValue()));
            prepare.setString(6, addMovies_movieTitle.getText());

            int rowsUpdated = prepare.executeUpdate();

            if (rowsUpdated > 0) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Movie details updated successfully!");
                alert.showAndWait();

                clearAddMoviesList();
                showAddMoviesList();

            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Movie update failed. The movie might not exist in the database or there was an issue.");
                alert.showAndWait();
            }
        } catch (Exception e) {

            e.printStackTrace();
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("An unexpected error occurred while updating the movie. Please check the log.");
            alert.showAndWait();
        }
    }

    public void deleteAddMovies() {
        moviesData selectedMovie = addMovies_tableView.getSelectionModel().getSelectedItem();

        if (selectedMovie == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("No movie selected! Please select a movie to delete.");
            alert.showAndWait();
            return;
        }

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setContentText("Are you sure you want to delete the movie: " + selectedMovie.getTitle() + "?");

        confirmationAlert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                String sql = "DELETE FROM movie WHERE movieTitle = ?";
                connect = database.connectDb();

                try {
                    prepare = connect.prepareStatement(sql);
                    prepare.setString(1, selectedMovie.getTitle());
                    int rowsDeleted = prepare.executeUpdate();

                    if (rowsDeleted > 0) {
                        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                        successAlert.setTitle("Information Message");
                        successAlert.setHeaderText(null);
                        successAlert.setContentText("Movie deleted successfully!");
                        successAlert.showAndWait();

                        clearAddMoviesList();
                        showAddMoviesList();
                    } else {
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setTitle("Error Message");
                        errorAlert.setHeaderText(null);
                        errorAlert.setContentText("Failed to delete the movie.");
                        errorAlert.showAndWait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Error Message");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("An error occurred while deleting the movie.");
                    errorAlert.showAndWait();
                }
            }
        });
    }

    public void clearAddMoviesList() {
        addMovies_movieTitle.setText("");
        addMovies_genre.setText("");
        addMovies_duration.setText("");
        addMovies_imageView.setImage(null);
        addMovies_date.setValue(null);
    }

    public ObservableList<moviesData> addMoviesList() {

        ObservableList<moviesData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie";

        connect = database.connectDb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {
                movD = new moviesData(result.getString("movieTitle"),
                        result.getString("genre"), result.getString("duration"),
                        result.getString("image"), result.getDate("date"),
                        result.getString("current"));
                listData.add(movD);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<moviesData> listAddMovies;

    public void showAddMoviesList() {
        listAddMovies = addMoviesList();

        addMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        addMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        addMovies_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addMovies_col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        addMovies_tableView.setItems(listAddMovies);
    }

    public void selectAddMoviesList() {
        moviesData movD = addMovies_tableView.getSelectionModel().getSelectedItem();
        int num = addMovies_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        getData.path = movD.getImage();

        addMovies_movieTitle.setText(movD.getTitle());
        addMovies_genre.setText(movD.getGenre());
        addMovies_duration.setText(movD.getDuration());

        String getDate = String.valueOf(movD.getDate());

        String uri = "file:" + movD.getImage();
        image = new Image(uri, 176, 183, false, true);
        addMovies_imageView.setImage(image);

        addMovies_date.setValue(movD.getDate().toLocalDate());
    }

    public void logout() throws IOException {
        signout.getScene().getWindow().hide();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed(event -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged(event -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
            });

            stage.initStyle(StageStyle.TRANSPARENT);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == dashboard_btn) {

            dashboard_form.setVisible(true);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            displayTotalSoldTicket();
            displayTotalEarnings();
            displayTotalAvailableMovies();

        } else if (event.getSource() == addMovies_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(true);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            showAddMoviesList();

        } else if (event.getSource() == availableMovies_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(true);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            showAvailableMovies();

        } else if (event.getSource() == editScreening_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(true);
            customers_form.setVisible(false);

            showEditScreening();

        } else if (event.getSource() == customers_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(true);

            showCustomerList();
        }
    }

    public void displayUsername() {
        username.setText(getData.username);
    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) topForm.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayUsername();

        showAddMoviesList();

        showEditScreening();

        comboBox();

        showAvailableMovies();

        showSpinnerValue();

        showCustomerList();

        displayTotalSoldTicket();

        displayTotalEarnings();

        displayTotalAvailableMovies();
    }
}
