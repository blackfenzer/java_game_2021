package gui;

import java.io.FileNotFoundException;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import logic.Boss;
import logic.Dictionary;
import logic.UnitHero;

public class UltimatePane {
	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}

	private BorderPane root;
	private RightPane rightPane;
	private TopPane topPane;
	private LeftPane leftPane;
	private CenterPane centerPane;
	public int score = 0, c = 0, level = 1, speed = 6000;
	public String word1, word2, word3;
	public Stage stage;
	private Timeline timeline;
	private AnimationTimer timer;

	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}

	public UltimatePane(UnitHero kh, Stage stage, int speed) throws FileNotFoundException {
		this.stage = stage;

		this.speed = speed;
		Dictionary wordList = new Dictionary("dictionary.txt");
		int randInt1 = 1 + (int) (Math.random() * ((1000 - 1) + 1));
		int randInt2 = 1 + (int) (Math.random() * ((1000 - 1) + 1));
		int randInt3 = 1 + (int) (Math.random() * ((1000 - 1) + 1));
		timeline = new Timeline();
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(false);
		Boss demon = new Boss(level);
		word1 = wordList.getWordList().get(randInt1);
		word2 = wordList.getWordList().get(randInt2);
		word3 = wordList.getWordList().get(randInt3);
		topPane = new TopPane(demon);
		rightPane = new RightPane(score, kh);
		leftPane = new LeftPane(kh, rightPane, score);
		centerPane = new CenterPane();
		StackPane stackPane = new StackPane();

		Label lbl = new Label("Center");
		lbl.setStyle("-fx-font-weight: bold");

		HBox stack = new HBox();
		stack.setSpacing(60);
		stack.setAlignment(Pos.CENTER);

		Text text1 = new Text(word1);
		VBox a = new VBox(text1);
		text1.setStyle("-fx-font: 16 verdana;-fx-font-weight: bold;");
		text1.setFill(Color.SANDYBROWN);

		Text text2 = new Text(word2);
		VBox b = new VBox(text2);
		text2.setStyle("-fx-font: 16 verdana;-fx-font-weight: bold;");
		text2.setFill(Color.SANDYBROWN);

		Text text3 = new Text(word3);
		VBox c = new VBox(text3);
		text3.setStyle("-fx-font: 16 verdana;-fx-font-weight: bold;");
		text3.setFill(Color.SANDYBROWN);

		TextField textField = new TextField();
		textField.setPrefWidth(200);
		textField.setPrefHeight(25);
		textField.setEditable(true);
		textField.setStyle("-fx-font: 14 verdana;-fx-background-color: white;-fx-font-weight: bold;");
		textField.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				if (textField.getText().equals(word1)) {
					score++;
					if (score % 5 == 0) {
						int r = 1 + (int) (Math.random() * ((3 - 1) + 1));
						if (r == 1) {
							leftPane.getHeal().setTimes(leftPane.getHeal().getTimes() + 1);
							leftPane.getHealButton().setText("Heal Potions : " + leftPane.getHeal().getTimes());
						} else if (r == 2) {
							leftPane.getBoostAttack().setTimes(leftPane.getBoostAttack().getTimes() + 1);
							leftPane.getBoostAttackButton()
									.setText("Boost Attack : " + leftPane.getBoostAttack().getTimes());
						} else if (r == 3) {
							leftPane.getShieldUp().setTimes(leftPane.getBoostAttack().getTimes() + 1);
							leftPane.getShieldUpButton().setText("Shielding Up : " + leftPane.getShieldUp().getTimes());
						}
					}

					textField.clear();

					a.setVisible(false);
					kh.attack(demon);
					if (demon.getHealth() == 0) {
						level = level + 1;
						demon.levelUp(level);

					}
					topPane.updateGameText(demon);
					topPane.getBoss().setLevel(level);
					rightPane.setScore(score);
					rightPane.updateGameText(score, kh);

				}
				if (textField.getText().equals(word2)) {
					score++;

					if (score % 5 == 0) {
						int r = 1 + (int) (Math.random() * ((3 - 1) + 1));
						if (r == 1) {
							leftPane.getHeal().setTimes(leftPane.getHeal().getTimes() + 1);
							leftPane.getHealButton().setText("Heal Potions : " + leftPane.getHeal().getTimes());
						} else if (r == 2) {
							leftPane.getBoostAttack().setTimes(leftPane.getBoostAttack().getTimes() + 1);
							leftPane.getBoostAttackButton()
									.setText("Boost Attack : " + leftPane.getBoostAttack().getTimes());
						} else if (r == 3) {
							leftPane.getShieldUp().setTimes(leftPane.getBoostAttack().getTimes() + 1);
							leftPane.getShieldUpButton().setText("Shielding Up : " + leftPane.getShieldUp().getTimes());

						}
					}
					rightPane.setScore(score);
					rightPane.updateGameText(score, kh);
					textField.clear();

					b.setVisible(false);
					kh.attack(demon);
					if (demon.getHealth() == 0) {
						level = level + 1;
						demon.levelUp(level);

					}
					topPane.updateGameText(demon);
					topPane.getBoss().setLevel(level);
					rightPane.setScore(score);
					rightPane.updateGameText(score, kh);
				}
				if (textField.getText().equals(word3)) {
					score++;
					if (score % 5 == 0) {
						int r = 1 + (int) (Math.random() * ((3 - 1) + 1));
						if (r == 1) {
							leftPane.getHeal().setTimes(leftPane.getHeal().getTimes() + 1);
							leftPane.getHealButton().setText("Heal Potions : " + leftPane.getHeal().getTimes());
						} else if (r == 2) {
							leftPane.getBoostAttack().setTimes(leftPane.getBoostAttack().getTimes() + 1);
							leftPane.getBoostAttackButton()
									.setText("Boost Attack : " + leftPane.getBoostAttack().getTimes());
						} else if (r == 3) {
							leftPane.getShieldUp().setTimes(leftPane.getBoostAttack().getTimes() + 1);
							leftPane.getShieldUpButton().setText("Shielding Up : " + leftPane.getShieldUp().getTimes());

						}
					}

					rightPane.setScore(score);
					rightPane.updateGameText(score, kh);
					textField.clear();

					c.setVisible(false);

					kh.attack(demon);
					if (demon.getHealth() == 0) {
						level = level + 1;
						demon.levelUp(level);

					}

					topPane.updateGameText(demon);
					topPane.getBoss().setLevel(level);
					rightPane.setScore(score);
					rightPane.updateGameText(score, kh);

				}

			}
		});
		HBox bottomPane = new HBox();
		bottomPane.getChildren().add(textField);
		bottomPane.setAlignment(Pos.CENTER);
		bottomPane.setPadding(new Insets(10));
		BackgroundFill bgFill = new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY);
		bottomPane.setBackground(new Background(bgFill, null));

		stack.getChildren().addAll(a, b, c);
		stackPane.getChildren().addAll(centerPane, stack);
		root = new BorderPane();
		root.setTop(topPane);
		root.setBottom(bottomPane);
		root.setLeft(leftPane);
		root.setRight(rightPane);
		root.setCenter(stackPane);

		timer = new AnimationTimer() {
			@Override
			public void handle(long l) {

			}
		};
		KeyValue keyValueY1 = new KeyValue(a.translateYProperty(), 500);
		KeyValue keyValueY2 = new KeyValue(b.translateYProperty(), 500);
		KeyValue keyValueY3 = new KeyValue(c.translateYProperty(), 500);
		Duration d = Duration.millis(speed);

		Alert alert = new Alert(AlertType.WARNING);
		alert.setHeaderText("Game End!");

		EventHandler onFinished1 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				if (a.isVisible() == true) {
					kh.setHealth(kh.getHealth() - kh.attacked(demon.getAttack()));
					rightPane.setScore(score);
					rightPane.updateGameText(score, kh);

				}

				int randInt1 = 1 + (int) (Math.random() * ((1000 - 1) + 1));
				word1 = wordList.getWordList().get(randInt1);
				text1.setText(word1);
				a.setVisible(true);
				if (kh.getHealth() == 0) {
					alert.setContentText("You Lose!\n" + "Your score is : " + rightPane.getScore() + "\nBoss Level : "
							+ topPane.getBoss().getLevel() + "\nTry again next time.");
					alert.show();
					timeline.stop();
				}

			}
		};

		EventHandler onFinished2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				if (b.isVisible() == true) {
					kh.setHealth(kh.getHealth() - kh.attacked(demon.getAttack()));
					rightPane.setScore(score);
					rightPane.updateGameText(score, kh);

				}

				int randInt2 = 1 + (int) (Math.random() * ((1000 - 1) + 1));
				word2 = wordList.getWordList().get(randInt2);
				text2.setText(word2);
				b.setVisible(true);
				if (kh.getHealth() == 0) {
					alert.setContentText("You Lose!\n" + "Your score is : " + rightPane.getScore() + "\nBoss Level : "
							+ topPane.getBoss().getLevel() + "\nTry again next time.");
					alert.show();
					timeline.stop();
				}
			}
		};

		EventHandler onFinished3 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				if (c.isVisible() == true) {
					kh.setHealth(kh.getHealth() - kh.attacked(demon.getAttack()));
					rightPane.setScore(score);
					rightPane.updateGameText(score, kh);

				}

				int randInt3 = 1 + (int) (Math.random() * ((1000 - 1) + 1));
				word3 = wordList.getWordList().get(randInt3);
				text3.setText(word3);
				c.setVisible(true);
				if (kh.getHealth() == 0) {
					alert.setContentText("You Lose!\n" + "Your score is : " + rightPane.getScore() + "\nBoss Level : "
							+ topPane.getBoss().getLevel() + "\nTry again next time.");
					alert.show();
					timeline.stop();
				}
			}
		};

		KeyFrame keyFrame1 = new KeyFrame(d, onFinished1, keyValueY1);
		KeyFrame keyFrame2 = new KeyFrame(d, onFinished2, keyValueY2);
		KeyFrame keyFrame3 = new KeyFrame(d, onFinished3, keyValueY3);
		timeline.getKeyFrames().addAll(keyFrame1, keyFrame2, keyFrame3);

		timer.start();

	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}