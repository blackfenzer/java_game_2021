package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.BerserkerHero;
import logic.FatManHero;
import logic.KnightHero;
import logic.UnitHero;

public class RightPane extends VBox {
	private Text gameText;
	private int score;
	private UnitHero hero;
	private ImageView view;

	public RightPane(int score, UnitHero hero) {
		this.score = score;
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(15));
		this.hero = hero;
		initializeGameText();
		BackgroundFill bgFill = new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY);
		this.setBackground(new Background(bgFill, null));
		if (this.hero instanceof FatManHero) {
			Image img = new Image(getClass().getClassLoader().getResource("baymax.jpg").toString());
			ImageView view = new ImageView(img);
			view.setFitWidth(150);
			view.setFitHeight(200);
			this.view = view;

		} else if (this.hero instanceof KnightHero) {
			Image img = new Image(getClass().getClassLoader().getResource("saber.jpg").toString());
			ImageView view = new ImageView(img);
			view.setFitWidth(150);
			view.setFitHeight(200);
			this.view = view;
		} else if (this.hero instanceof BerserkerHero) {
			Image img = new Image(getClass().getClassLoader().getResource("berserker.jpg").toString());
			ImageView view = new ImageView(img);
			view.setFitWidth(150);
			view.setFitHeight(200);
			this.view = view;
		}
		this.getChildren().addAll(view, gameText);

	}

	private void initializeGameText() {
		gameText = new Text();
		gameText.setText(hero.getName() + "\nScore : " + this.score + "\nHP : " + hero.getHealth() + "\nATK : "
				+ hero.getAttack() + "\nShield : " + hero.getShield());
		gameText.setStyle("-fx-font: 15 verdana;-fx-background-color: white;-fx-font-weight: bold;");
	}

	public void updateGameText(int score2, UnitHero hero) {
		gameText.setText(hero.getName() + "\nScore : " + score2 + "\nHP : " + hero.getHealth() + "\nATK : "
				+ hero.getAttack() + "\nShield : " + hero.getShield());
	}

	public Text getGameText() {
		return gameText;
	}

	public void setGameText(Text gameText) {
		this.gameText = gameText;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
