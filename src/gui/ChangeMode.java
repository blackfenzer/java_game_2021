package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.KnightHero;

public class ChangeMode extends StackPane {
	private Stage stage;
	public KnightHero k;
	private Scene chScene1;
	private Scene chScene2;
	private Scene chScene3;

	public ChangeMode(Scene chScene1, Scene chScene2, Scene chScene3, Stage stage) {
		this.chScene1 = chScene1;
		this.chScene2 = chScene2;
		this.chScene3 = chScene3;
		this.stage = stage;

		Button b1 = new Button("Easy");
		b1.setStyle("-fx-font: 18 verdana; -fx-background-color: springgreen;-fx-font-weight: bold;");
		b1.setPadding(new Insets(20));
		b1.setOnMouseClicked(e -> {
			this.stage.setScene(this.chScene1);
		});

		Button b2 = new Button("Medium");
		b2.setStyle("-fx-font: 18 verdana; -fx-background-color: gold;-fx-font-weight: bold;");
		b2.setPadding(new Insets(20));
		b2.setOnMouseClicked(e -> {
			this.stage.setScene(this.chScene2);
		});

		Button b3 = new Button("Hard");
		b3.setStyle("-fx-font: 18 verdana; -fx-background-color: crimson;-fx-font-weight: bold;");
		b3.setPadding(new Insets(20));
		b3.setOnMouseClicked(e -> {
			this.stage.setScene(this.chScene3);
		});
		Image noni = new Image("noni.jpeg");
		ImageView noniView = new ImageView(noni);

		HBox h = new HBox();
		h.getChildren().addAll(b1, b2, b3);
		h.setSpacing(20);
		h.setAlignment(Pos.CENTER);
		this.getChildren().addAll(noniView, h);
	}

}
