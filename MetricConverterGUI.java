import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MetricConverterGUI extends Application {

    private Button convertButton;
    private TextField userInput;
    private Label outputLabel;
    
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();

        HBox inputBox = new HBox();
        Label inputLabel = new Label("Enter the value in meters: ");
        userInput = new TextField();
        inputBox.getChildren().addAll(inputLabel, userInput);

        HBox buttonBox = new HBox();
        convertButton = new Button("Convert");
        buttonBox.getChildren().addAll(convertButton);

        HBox outputBox = new HBox();
        Label outputLabelTitle = new Label("The value in centimeters is: ");
        outputLabel = new Label("");
        outputBox.getChildren().addAll(outputLabelTitle, outputLabel);

        root.getChildren().addAll(inputBox, buttonBox, outputBox);
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setTitle("Metric Converter");
        primaryStage.setScene(scene);
        primaryStage.show();

        convertButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String input = userInput.getText();
                double meters = Double.parseDouble(input);
                double centimeters = meters * 100;
                outputLabel.setText("" + centimeters);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}