package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CenterPane extends VBox {
	private final String demonURL = "slime.png";

	public CenterPane() {
		ImageView imageView = new ImageView(new Image(getClass().getClassLoader().getResource(demonURL).toString()));
		BackgroundFill bgFill = new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY);
		this.setBackground(new Background(bgFill, null));
		imageView.setFitHeight(450);
		imageView.setFitWidth(300);
		BorderPane borderpane = new BorderPane();
		borderpane.setPrefHeight(600);
		borderpane.setPrefWidth(450);
		borderpane.setCenter(imageView);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(borderpane);
	}
}
