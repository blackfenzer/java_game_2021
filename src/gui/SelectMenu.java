package gui;

import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class SelectMenu extends StackPane {
	private Scene mainScene;
	private Stage stage;

	public SelectMenu(Scene g1, Scene g2, Scene g3, Stage stage, Timeline t1, Timeline t2, Timeline t3) {

		this.stage = stage;
		HBox h = new HBox();
		VBox v1 = new VBox();
		v1.setAlignment(Pos.CENTER);
		Button b1 = new Button("Knight Hero");
		b1.setStyle("-fx-font: 14 verdana;-fx-background-color: white;-fx-font-weight: bold;");
		Image img = new Image(getClass().getClassLoader().getResource("saber.jpg").toString());
		ImageView view1 = new ImageView(img);
		view1.setFitWidth(285);
		view1.setFitHeight(400);
		Text info1 = new Text("When this hero attack\nGain 1 sheild each time");
		info1.setFill(Color.WHITE);
		info1.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		info1.setTextAlignment(TextAlignment.CENTER);
		v1.getChildren().addAll(view1, b1, info1);
		v1.setSpacing(20);
		b1.setOnMouseClicked(e -> {
			this.stage.setScene(g1);
			t1.play();
		});

		VBox v2 = new VBox();
		v2.setAlignment(Pos.CENTER);
		Button b2 = new Button("Berserker");
		b2.setStyle("-fx-font: 14 verdana;-fx-background-color: white;-fx-font-weight: bold;");
		Image img2 = new Image(getClass().getClassLoader().getResource("berserker.jpg").toString());
		ImageView view2 = new ImageView(img2);
		view2.setFitWidth(270);
		view2.setFitHeight(400);
		Text info2 = new Text("Everytime this hero changes hp\nthis hero gain 10 attack");
		info2.setFill(Color.WHITE);
		info2.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		info2.setTextAlignment(TextAlignment.CENTER);
		v2.getChildren().addAll(view2, b2, info2);
		v2.setSpacing(20);
		b2.setOnMouseClicked(e -> {
			this.stage.setScene(g2);
			t2.play();
		});

		VBox v3 = new VBox();
		v3.setAlignment(Pos.CENTER);
		Button b3 = new Button("Fatman");
		b3.setStyle("-fx-font: 14 verdana;-fx-background-color: white;-fx-font-weight: bold;");
		Image img3 = new Image(getClass().getClassLoader().getResource("baymax.jpg").toString());
		ImageView view3 = new ImageView(img3);
		view3.setFitWidth(265);
		view3.setFitHeight(400);
		Text info3 = new Text("Start with 1000 Hp\n   ");
		info3.setFill(Color.WHITE);
		info3.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		info3.setTextAlignment(TextAlignment.CENTER);
		v3.getChildren().addAll(view3, b3, info3);
		v3.setSpacing(20);
		b3.setOnMouseClicked(e -> {
			this.stage.setScene(g3);
			t3.play();
		});
		Image war = new Image("war.jpg");
		ImageView warView = new ImageView(war);
		warView.setFitWidth(1000);
		warView.setFitHeight(800);
		h.getChildren().addAll(v1, v2, v3);
		this.getChildren().addAll(warView, h);

	}

	public Scene getMainScene() {
		return mainScene;
	}

	public void setMainScene(Scene mainScene) {
		this.mainScene = mainScene;
	}

}
