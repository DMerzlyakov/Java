package program.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import program.Main;
import program.models.Person;
import program.utils.DateUtil;

public class PersonOverviewController{
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label birthdayLabel;
    @FXML
    private Label postalCodeLabel;

    private Main mainApp;

    public PersonOverviewController(){}
    @FXML
    private void initialize(){
        System.out.println(123123213);
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());

        showPersonDetails(null);

        personTable.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, oldValue, newValue) -> showPersonDetails(newValue))
        );
    }

    @FXML
    private void handleDeleteAction(){
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >=0){
            personTable.getItems().remove(selectedIndex);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("ОШИБКА");
            alert.setHeaderText("Пользователи не выбраны");
            alert.setContentText("Пожалуйста выберите пользователя");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewPerson(){


        Person tmp = mainApp.showPersonAddDialog();
        if (tmp != null){
            mainApp.setPersonData(tmp);
//            showPersonDetails(tmp);
        }


    }

    private void showPersonDetails(Person person){
        if(person != null){
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            cityLabel.setText(person.getCity());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
        }else{
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
            birthdayLabel.setText("");
            postalCodeLabel.setText("");

        }
    }
    public void setMain(Main mainApp){
        this.mainApp = mainApp;
        personTable.setItems(mainApp.getPersonData());
    }


    @FXML
    private  void editPersonData(){

        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >=0) {
            Person buf = personTable.getItems().get(selectedIndex);
            mainApp.showPersonEditDialog(buf);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("ОШИБКА");
            alert.setHeaderText("Пользователи не выбраны");
            alert.setContentText("Пожалуйста выберите пользователя");

            alert.showAndWait();
        }
    }
}
