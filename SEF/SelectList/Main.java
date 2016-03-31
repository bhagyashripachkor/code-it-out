package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

@SuppressWarnings({ "unchecked", "rawtypes" })
@Override
  public void start(Stage stage) {
    stage.setTitle("Select List Exercise");
    Scene scene = new Scene(new Group(), 450, 250);

    TextField selectedCountry = new TextField("");
    TextField selectedIndex = new TextField("");
    final Button button = new Button ("Quit");

    ObservableList<String> country =
		    FXCollections.observableArrayList(
		    		"- no country selected - ",
					"Abkhazia", "Afghanistan", "Albania", "Algeria", "Andorra",
					"Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia",
					"Austria", "Azerbaijan", "Bahamas, The", "Bahrain", "Bangladesh",
					"Barbados", "Belarus", "Belgium", "Belize", "Benin",
					"Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil",
					"Brunei", "Bulgaria", "Burkina Faso", "Burma", "Burundi",
					"Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Republic",
					"Chad", "Chile", "China", "China (Taiwan), Republic of ", "Colombia",
					"Comoros", "Congo, Democratic Republic of the", "Congo, Republic of the", "Cook Islands", "Costa Rica",
					"Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark",
					"Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador",
					"Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia",
					"Estonia", "Ethiopia", "Fiji", "France", "Gabon",
					"Gambia, The", "Georgia", "Germany", "Ghana", "Greece",
					"Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
					"Haiti", "Honduras", "Hungary", "Iceland", "India",
					"Indonesia", "Iran", "Iraq", "Ireland", "Israel",
					"Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan",
					"Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South",
					"Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia",
					"Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein",
					"Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi",
					"Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
					"Mauritania", "Mauritius", "Mexico", "Micronesia, Federated States of", "Moldova",
					"Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique",
					"Myanmar (Burma)", "Nagorno-Karabakh ", "Namibia", "Nauru", "Nepal",
					"Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria",
					"Niue", "Northern Cyprus ", "Norway", "Oman", "Pakistan",
					"Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay",
					"Peru", "Philippines", "Poland", "Portugal", "Qatar",
					"Romania", "Russia", "Rwanda", "Sahrawi Arab Democratic Republic", "Saint Kitts and Nevis",
					"Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "São Tomé and Príncipe",
					"Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone",
					"Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia",
					"Somaliland", "South Ossetia", "South Sudan", "Spain", "Sri Lanka",
					"Sudan", "Sudan, South", "Suriname", "Swaziland", "Sweden",
					"Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand",
					"Timor-Leste", "Togo", "Tonga", "Transnistria", "Trinidad and Tobago",
					"Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda",
					"Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay",
					"Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam",
					"Yemen", "Zambia", "Zimbabwe"
		    );

    ArrayList<String> recent = new ArrayList<String>();

    //combo-box event handler
	ComboBox countryComboBox = new ComboBox(country);
    countryComboBox.setEditable(true);

    countryComboBox.valueProperty().addListener(new ChangeListener<String>() {
        @Override public void changed(ObservableValue ov, String oldValue, String newValue) {
        	int index = countryComboBox.getSelectionModel().getSelectedIndex();
        	selectedCountry.setText(newValue);
        	selectedIndex.setText(String.valueOf(index));
        	//String r = newValue;
        	addRecent(recent,newValue);
        	 ObservableList<String> newList =
        			    FXCollections.observableArrayList(country);
        	 newList.addAll(0,recent);
        	countryComboBox.setItems(newList);
        }
    });

    //quit button event handler
    button.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            stage.close();
        }
    });

    //to display the country names selected by user
    new AutoCompleteComboBoxListener<>(countryComboBox);

    //Displaying the output window
    GridPane grid = new GridPane();
    grid.setVgap(4);
    grid.setHgap(10);
    grid.setPadding(new Insets(5, 5, 5, 5));
    countryComboBox.setValue("- no country selected -");
    grid.add(new Label("Select Country: "), 0, 0);
    grid.add(countryComboBox, 1, 0);
    grid.add(new Label("Selected country: "), 0, 2);
    grid.add(selectedCountry, 1, 2);
    grid.add(new Label("Country Index: "), 0, 4);
    grid.add(selectedIndex, 1, 4);
    grid.add(button, 1, 6);

    Group root = (Group) scene.getRoot();
    root.getChildren().add(grid);
    stage.setScene(scene);
    stage.show();

  }


public ArrayList<String> addRecent(ArrayList<String> recent, String name){
if(recent.size() == 0){
	recent.add(0,name);
	recent.add(1,"-----------");

}
else if(recent.contains(name)){
	int index = recent.indexOf(name);
	for (int i = index; i > 0; i--){
		String temp = recent.get(i);
		recent.set(i, recent.get(i-1));
		recent.set(i-1, temp);

	}
}
else if(recent.size()==2){
	recent.set(1, recent.get(0));
	recent.set(0, name);
	recent.add(recent.size(),"---------");
}
else if(recent.size()==3){
	recent.set(2,recent.get(1));
	recent.set(1, recent.get(0));
	recent.set(0, name);
	recent.add(recent.size(),"---------");
}
else{
	recent.set(2,recent.get(1));
	recent.set(1, recent.get(0));
	recent.set(0, name);
}
	return recent;

}


}
