package sample;


import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TeachMe {
    //private String ques,ans;

    public static String ans;
    public static String showTeachWindow(String ques) {
        StoreAns storeAns = new StoreAns();
        Main main = new Main();
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Please Teach Me!");

        BorderPane borderPane = new BorderPane();

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));

        VBox headingVBox = new VBox(10);
        headingVBox.setAlignment(Pos.CENTER);
        Text heading1 = new Text("I don't know what to say.");
        heading1.getStyleClass().add("heading");
        Text heading2 = new Text("Please teach me! ");
        heading2.getStyleClass().add("heading");
        headingVBox.getChildren().addAll(heading1,heading2);

        Label ifYouSay = new Label("If You say :");
        TextArea quesText = new TextArea();
        quesText.setText(ques);

        Label iSay = new Label("I reply with :");
        TextArea ansText = new TextArea();
        ansText.requestFocus();

        //teach button
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));
        hBox.setAlignment(Pos.CENTER_RIGHT);
        JFXButton teachBtn = new JFXButton("Teach");
        teachBtn.getStyleClass().add("sendBtn");
        teachBtn.setOnAction(e -> {
           String q = quesText.getText();
           String a = ansText.getText();
           ans = a;
           q = StringRefiner.refineString(q);
           boolean success = storeAns.insert(q,a);

           if(success)
               window.close();

        });

        hBox.getChildren().add(teachBtn);
        vBox.getChildren().setAll(headingVBox,ifYouSay,quesText,iSay,ansText,hBox);

        Scene scene = new Scene(vBox,400,400);
        scene.getStylesheets().add("sample/Stylesheet.css");
        window.setScene(scene);
        window.showAndWait();

        return ans;


    }
}
