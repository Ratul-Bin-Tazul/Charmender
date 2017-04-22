package sample;


import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class Controller implements Initializable{



    @FXML
    private Text a;

    @FXML
    private Text c;

    @FXML
    private Text t;

    @FXML
    private Text bot;

    @FXML
    private Text d;

    @FXML
    private Text h;
    @FXML
    private HBox splashHBox;

    //public  Scene scene;
    public Parent root;

    //public Stage stage;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Splash Screen




//          splashHBox = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        splashHBox.setAlignment(Pos.CENTER);
//        splashHBox.getStyleClass().add("splash-box");

        //c = new Text("C");
        FadeTransition fadeinC = new FadeTransition(Duration.seconds(2), c);
        fadeinC.setFromValue(0.0);
        fadeinC.setToValue(1.0);
        //fadeinC.setCycleCount(1);

         //h = new Text("H");
        FadeTransition fadeinH = new FadeTransition(Duration.seconds(0.5),h);
        fadeinH.setFromValue(0.0);
        fadeinH.setToValue(1.0);
        //fadeinC.setCycleCount(1);

         //a = new Text("A");
        FadeTransition fadeinA = new FadeTransition(Duration.seconds(0.5),a);
        fadeinA.setFromValue(0.0);
        fadeinA.setToValue(1.0);
        fadeinA.setCycleCount(1);

         //t = new Text("T");
        FadeTransition fadeinT = new FadeTransition(Duration.seconds(0.5),t);
        fadeinT.setFromValue(0.0);
        fadeinT.setToValue(1.0);
        fadeinT.setCycleCount(1);

         //bot = new Text("BOT");
        FadeTransition fadeinBot = new FadeTransition(Duration.seconds(0.5),bot);
        fadeinBot.setFromValue(0.0);
        fadeinBot.setToValue(1.0);
        fadeinBot.setCycleCount(1);

        FadeTransition fadeinDecoy = new FadeTransition(Duration.seconds(0.5),bot);
        fadeinDecoy.setFromValue(0.0);
        fadeinDecoy.setToValue(1.0);
        fadeinDecoy.setCycleCount(1);


        fadeinC.play();
        fadeinC.setOnFinished(e -> {
            c.setVisible(true);fadeinH.play();System.out.print("c");
            //Speak.sayIt("c",true);
            //playSound("c");

        });
        fadeinH.setOnFinished(e -> {
            h.setVisible(true);fadeinA.play();
            //Speak.sayIt("h",true);
        });
        fadeinA.setOnFinished(e -> {
            a.setVisible(true);fadeinT.play();
            //Speak.sayIt("a",true);
        });
        fadeinT.setOnFinished(e -> {
            t.setVisible(true);fadeinBot.play();System.out.print("e");
            //Speak.sayIt("t",true);
        });
        fadeinBot.setOnFinished(e -> {
            bot.setVisible(true);
            //Speak.sayIt("bot",true);

            fadeinDecoy.play();
        });
        fadeinDecoy.setOnFinished(e -> {
            Stage stage = (Stage) a.getScene().getWindow();
            stage.setScene(Main.scene);
            //stage.close();

        });


        //splashHBox.getChildren().addAll(c,h,a,t,bot);


//        stackPane.getChildren().addAll(splashHBox);
//        Scene splashScene = new Scene(stackPane,600,500);
//        splashScene.getStylesheets().add("sample//Stylesheet.css");


        //Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)e.getSource()).getScene().getWindow();
        // OR
//        stage = (Stage) a.getScene().getWindow();
//        try {
//            root = FXMLLoader.load(getClass().getResource("FXML2.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

        // these two of them return the same stage
        // Swap screen
        //stageTheLabelBelongs.setScene(Main.scene);

    }


    public void playSound(String soundName) {
        String musicFile = "src//Chatbot Sound//"+soundName+".wav";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

    }


//    public static String getQues() {
////        return quesInput.getText().toString();
//    }
}
