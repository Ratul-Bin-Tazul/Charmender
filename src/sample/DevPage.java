package sample;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DevPage {


    public static void showDevPage() {


        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);

        ImageView dp = new ImageView(new Image("Img/dp.png"));
        dp.setId("dp");
        dp.setPreserveRatio(true);
        dp.setFitHeight(120);
        //dp.setFitWidth(100);

        Text devName = new Text("Ratul Bin Tazul");
        devName.setId("devName");
        devName.getStyleClass().add("dev");

        Text tagLine = new Text("Super Hero in day, Coder by night");
        tagLine.setId("tagLine");

        Text brac = new Text("BRAC University \n" +
                "Cse Department");
        brac.getStyleClass().add("institute");

        Text ndc = new Text("Notredamian");
        ndc.getStyleClass().add("institute");
        Text lab = new Text("Laboratorian");
        lab.getStyleClass().add("institute");

        vBox.getChildren().addAll(dp,devName,tagLine,brac,ndc,lab);

        Scene scene = new Scene(vBox,600,500);
        scene.getStylesheets().add("sample/devPageStyle.css");
        Stage window = new Stage();
        window.setScene(scene);
        window.show();
    }
}
