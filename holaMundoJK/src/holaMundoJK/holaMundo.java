package holaMundoJK;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class holaMundo extends Application {

	@Override
	public void start(Stage stage) {

		Label label = new Label("Hola, JavaFX!");
		label.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

		StackPane root = new StackPane(label);
		Scene scene = new Scene(root, 400, 300);

		stage.setTitle("Mi primera ventana");
		stage.setScene(scene);

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}