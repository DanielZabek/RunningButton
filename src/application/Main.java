package application;

import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.event.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Random rnd = new Random();
			Pane root = new Pane();
			Button runningBtn = new Button("CLOSE [X]");
			Scene scene = new Scene(root, 400, 400);
			root.getChildren().add(runningBtn);
			runningBtn.setLayoutX(330);

			EventHandler<MouseEvent> mouseHandler = e -> {
			runningBtn.setLayoutX(rnd.nextDouble() * 330);
			runningBtn.setLayoutY(rnd.nextDouble() * 350);
				
			};

			runningBtn.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseHandler);
			runningBtn.addEventHandler(MouseEvent.MOUSE_MOVED, mouseHandler);

			runningBtn.setOnAction(e -> {

				primaryStage.close();
			});

			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
