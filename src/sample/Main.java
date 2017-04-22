package sample;

import com.jfoenix.controls.*;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerBasicCloseTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



public class Main extends Application {


    public BorderPane borderPane;
    public GetAns getAns;
    public StringRefiner refiner;

    public String ques,ans,temp;
    public ScrollPane scrollPane;
    public VBox vBox;
    public Boolean sound;
    public double vBoxH;
    public static Scene secondPageScene,scene;
    public String userName="";
    public JFXHamburger hamburger;
    public HamburgerBasicCloseTransition hamburgerTransition;
    public JFXDrawer drawer;
    public JFXDrawersStack drawersStack;
    public Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {


        System.out.println("File loc ->"+this.getClass().getProtectionDomain().getCodeSource().getLocation());
        //Speak speak = new Speak();

            window = primaryStage;

            getAns = new GetAns();
            refiner = new StringRefiner();



//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("sample.fxml"));
//        Parent root = loader.load();
//        loader.getController();

        //Chat Page
            borderPane = new BorderPane();


            //top
        //top left
        BorderPane topSection = new BorderPane();
            HBox topSectionLeft = new HBox(10);
            topSection.setPadding(new Insets(10));


            JFXButton voiceBtn = new JFXButton();
            voiceBtn.getStyleClass().add("voiceBtn");
            voiceBtn.setRipplerFill(Color.web("#000000"));
            voiceBtn.setButtonType(JFXButton.ButtonType.RAISED);
            voiceBtn.setGraphic(new ImageView("Img/ic_volume_off_black_24dp_1x.png"));
            sound=false;
            voiceBtn.setOnAction(e -> {
                boolean b = !sound;
                sound = b;
                if(sound)
                    voiceBtn.setGraphic(new ImageView("Img/ic_volume_up_black_24dp_1x.png"));
                else
                    voiceBtn.setGraphic(new ImageView("Img/ic_volume_off_black_24dp_1x.png"));
            });
            topSectionLeft.getChildren().addAll(voiceBtn);

            //top section right
        HBox topSectionRight = new HBox(10);
        topSectionRight.setAlignment(Pos.CENTER_RIGHT);
        topSectionRight.setPadding(new Insets(10));

        //creaing drawer
        VBox drawerVBox = new VBox(7);
        drawerVBox.getStyleClass().add("drawerVBox");
        JFXButton teachBtn = new JFXButton("Teach");
        teachBtn.setOnAction(e -> {
            TeachMe.showTeachWindow("");
        });
        teachBtn.getStyleClass().add("drawer-btn");
        JFXButton aboutDev = new JFXButton("About Developer");
        aboutDev.setOnAction(e -> {
            DevPage.showDevPage();
        });
        aboutDev.getStyleClass().add("drawer-btn");
        JFXButton exit = new JFXButton("Exit");
        exit.setOnAction(e -> {
            close();
        });
        exit.getStyleClass().add("drawer-btn");
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            close();
        });
        drawerVBox.getChildren().addAll(teachBtn,aboutDev,exit);

        drawer = new JFXDrawer();
        drawer.setSidePane(drawerVBox);
        drawer.setDirection(JFXDrawer.DrawerDirection.RIGHT);
        drawer.setOverLayVisible(false);
        //drawer.setContent(drawersStack);

        drawer.setDefaultDrawerSize(200);
        drawer.setSidePane(drawerVBox);
//		topDrawer.setContent(rightDrawer);
        drawer.setOverLayVisible(false);
        drawer.setResizableOnDrag(true);

        drawer.setPrefHeight(350);





        hamburger = new JFXHamburger();
        hamburgerTransition = new HamburgerBasicCloseTransition(hamburger);
        hamburgerTransition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
            hamburgerTransition.setRate(hamburgerTransition.getRate()*-1);
            hamburgerTransition.play();

            drawersStack.toggle(drawer);

        });


        topSectionRight.getChildren().addAll(hamburger);
            topSection.setLeft(topSectionLeft);
            topSection.setRight(topSectionRight);

            //center
            HBox hBox = new HBox(10);
            hBox.setPadding(new Insets(10));
            ImageView botImg = new ImageView("Img/dragonite.png");
            botImg.setFitWidth(70);
            botImg.setFitHeight(70);
            Label fBot = new Label("Hi there "+userName);

            //fBot.getStyleClass().add("label-user");
            hBox.getChildren().addAll(botImg,fBot);


            vBox = new VBox(10);
            vBox.setPadding(new Insets(15));


        //vBox.setMaxHeight(460);
            vBox.getChildren().addAll(hBox);
            scrollPane = new ScrollPane();
            scrollPane.setContent(vBox);
            scrollPane.setFitToWidth(true);
            scrollPane.setPrefHeight(450);
            scrollPane.setMaxHeight(450);
            scrollPane.getStyleClass().add("bottom-section");
            //scrollPane.setVvalue(1.0);

        drawersStack = new JFXDrawersStack();
        drawersStack.setContent(scrollPane);


            //bottom

            HBox bottomSection = new HBox(10);
            bottomSection.setPadding(new Insets(10));
            //bottomSection.getStyleClass().add("bottom-section");

            JFXTextField quesInput = new JFXTextField();
            quesInput.setFocusColor(Color.web("#09b6bc"));
        quesInput.setPromptText("Enter your message...");
        quesInput.setPrefWidth(510);

            JFXButton button = new JFXButton("Send");
            button.setButtonType(JFXButton.ButtonType.RAISED);
            button.getStyleClass().add("sendBtn");


            bottomSection.getChildren().addAll(quesInput,button);


            //setting BorderPane
            borderPane.setTop(topSection);
            borderPane.setCenter(drawersStack);
            borderPane.setBottom(bottomSection);


            primaryStage.setTitle("Charmender");

            scene = new Scene(borderPane, 610, 510);
            scene.getStylesheets().add("sample/Stylesheet.css");


//        //Second page
//
//        VBox secondPage = new VBox();
//        secondPage.setAlignment(Pos.CENTER);
//
//        HBox secondPageHBox = new HBox(10);
//        secondPageHBox.setAlignment(Pos.CENTER);
//        secondPageHBox.setPadding(new Insets(10));
//
//        TextField userNameInput = new TextField();
//        userNameInput.setPromptText("Enter your Name...");
//        userNameInput.getStyleClass().add("username-input");
//        JFXButton nameBtn = new JFXButton("Submit");
//        nameBtn.getStyleClass().add("sendBtn");
//        nameBtn.setOnAction(e -> {
//            this.userName = userNameInput.getText();
//            primaryStage.setScene(scene);
//
//        });
//        secondPageHBox.getChildren().addAll(userNameInput,nameBtn);
//
//        secondPage.getChildren().addAll(secondPageHBox);
//
//        secondPageScene = new Scene(secondPage,600,500);


        //System.out.print(Controller.getQues());
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene splashScene = new Scene(root, 600, 500);
        primaryStage.setScene(splashScene); //dont touch this scene
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image("Img/chatbot_icon.png"));
            primaryStage.show();


            //Send button Clicked
        button.setOnAction(e -> {
            vBoxH+=200;
            scrollPane.setVvalue(vBoxH);
            System.out.println(vBoxH+"btn clc");

            ques = quesInput.getText();
            quesInput.clear();
            addUserLabel(ques);
            temp = refiner.refineString(ques);
            ans = getAns.ans(temp);

            if(ans.equals("not found")) {
                ans = TeachMe.showTeachWindow(ques);
            }
            addBotLabel(ans);
            scrollScreen();

            //speak.sayIt(ans,sound);


        });

    }



    public static void main(String[] args) {

        launch(args);
    }

    public void addUserLabel(String userText) {

        HBox hBox = new HBox(10);
        Label user = new Label(userText);
        user.setPadding(new Insets(10));
        user.getStyleClass().add("label-user");
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.getChildren().add(user);
        vBox.getChildren().add(hBox);


    }
    public void addBotLabel(String botText) {

        HBox hBox = new HBox(10);
        Label user = new Label(botText);
        user.setPadding(new Insets(10));
        //user.getStyleClass().add("label-user");
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().add(user);
        vBox.getChildren().add(hBox);



    }

    public void scrollScreen() {
        System.out.println(vBox.getHeight()+ " met");

        //To automatically scroll to the bottom of the chat
        DoubleProperty hProperty = new SimpleDoubleProperty();
        hProperty.bind(this.vBox.heightProperty()); // bind to Hbox width chnages
        vBoxH = 100;
        hProperty.addListener((v,oldValue,newValue) -> {
            System.out.println(vBox.getHeight()+" sc");
            vBoxH+=100;
            scrollPane.setVvalue(this.vBox.getHeight());
        }) ;


    }

    public void close() {
        boolean exit = CloseWindow.showCloseAlert();

        if(exit)
            window.close();
    }
}
