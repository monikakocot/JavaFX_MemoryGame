package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.*;


public class Main extends Application {

    //5 For counting 'click'
    int counter = 0;
    List<Button> buttonList = new ArrayList<>();
    int lastIndex;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 0.Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));// - on pur game we ude code not .fxml file

        // 0. Main Pane
        primaryStage.setTitle("Memory Game");
        FlowPane flow = new FlowPane();
        flow.setVgap(8);
        flow.setHgap(4);
        // 2. id for pictures


        for (int i = 1; i <= 8; i++) {
            Button button = new Button("");
            //int imageId = i<=4 ? i:i-4; // putting pictures on the places


            int imageId;
            if (i == 1) {
                imageId = i;

                button.setPrefHeight(120);
                button.setPrefWidth(120);
                button.setId(String.valueOf(imageId));
                buttonList.add(button);
            } else if (i == 2) {
                imageId = i;

                button.setPrefHeight(120);
                button.setPrefWidth(120);
                button.setId(String.valueOf(imageId));
                buttonList.add(button);
            }else if (i == 3) {
                imageId = i - 1;

                button.setPrefHeight(120);
                button.setPrefWidth(120);
                button.setId(String.valueOf(imageId));
                buttonList.add(button);
            }else if (i == 4) {
                    imageId = i-1;

                    button.setPrefHeight(120);
                    button.setPrefWidth(120);
                    button.setId(String.valueOf(imageId));
                    buttonList.add(button);
            }else if (i == 5) {
                imageId = i-2;

                button.setPrefHeight(120);
                button.setPrefWidth(120);
                button.setId(String.valueOf(imageId));
                buttonList.add(button);
            }else if (i == 6) {
                imageId = i-2;

                button.setPrefHeight(120);
                button.setPrefWidth(120);
                button.setId(String.valueOf(imageId));
                buttonList.add(button);
            }else if (i == 7) {
                imageId = i-6;

                button.setPrefHeight(120);
                button.setPrefWidth(120);
                button.setId(String.valueOf(imageId));
                buttonList.add(button);
            }else if (i == 8) {
                imageId = i - 4;

                button.setPrefHeight(120);
                button.setPrefWidth(120);
                button.setId(String.valueOf(imageId));
                buttonList.add(button);
            }
            
                //3.  Put action after click

            button.setOnAction(event -> {
                //5 Counting the clicks
                counter++;

                // 4. Show the picture after click
                Button clickedButton = (Button) event.getSource();
                Image image = new Image(getClass().getResourceAsStream("/" + clickedButton.getId() + ".png"));
                clickedButton.setGraphic(new ImageView(image));

                //5 counting clicks + the ability to click after guessing 2 of the same images
                if (counter % 2 == 0) {

                    if (buttonList.get(lastIndex).getId().equals(clickedButton.getId())) {
                        clickedButton.setDisable(true);
                        buttonList.get(lastIndex).setDisable(true);
                    } else {
                        buttonList.get(lastIndex).setGraphic(null);
                        counter = 1;
                    }

                }

                lastIndex = buttonList.indexOf(clickedButton);
                System.out.println(lastIndex);


                System.out.println("I'm clicked :D");
            });

            flow.getChildren().add(button);

        }

        primaryStage.setScene(new Scene(flow, 500, 300)); // 0. I change root (because not from sample.fxml on my flow
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
