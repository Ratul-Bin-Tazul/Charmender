package sample;


import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CloseWindow {
    public static boolean exit=false;

    public static boolean showCloseAlert() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));


        Text exitText = new Text("Are you sure you want to exit CHAT BOT?");
        exitText.getStyleClass().add("exitText");

        HBox lowerHBox = new HBox(10);
        lowerHBox.setAlignment(Pos.CENTER_RIGHT);

        JFXButton exitBtn = new JFXButton("_Exit");
        exitBtn.setButtonType(JFXButton.ButtonType.RAISED);
        exitBtn.getStyleClass().add("sendBtn");
        JFXButton cancelBtn = new JFXButton("Cancel");
        cancelBtn.setButtonType(JFXButton.ButtonType.RAISED);
        cancelBtn.getStyleClass().add("sendBtn");

        lowerHBox.getChildren().addAll(exitBtn,cancelBtn);

        vBox.getChildren().addAll(exitText,lowerHBox);

        exitBtn.setOnAction(e -> {
            exit = true;
            window.close();
        });

        cancelBtn.setOnAction(e -> {
            window.close();
        });

        Scene scene = new Scene(vBox,400,90);
        scene.getStylesheets().add("sample/Stylesheet.css");
        window.setScene(scene);
        window.getIcons().add(new Image("Img/chatbot_icon.png"));
        window.showAndWait();
        return exit;
    }
}
