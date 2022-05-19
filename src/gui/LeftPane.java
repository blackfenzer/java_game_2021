package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.UnitHero;
import skill.BoostAttack;
import skill.Heal;
import skill.ShieldUp;

public class LeftPane extends VBox {
	private Button boostAttackButton;
	private Button healButton;
	private Button shieldUpButton;
	private UnitHero unitHero;
	private RightPane rightPane;
	private BoostAttack boostAttack;
	private Heal heal;
	private ShieldUp shieldUp;
	private int score;

	public LeftPane(UnitHero unitHero, RightPane rightPane, int score) {
		this.unitHero = unitHero;
		this.rightPane = rightPane;
		this.score = score;
		boostAttack = new BoostAttack();
		heal = new Heal();
		shieldUp = new ShieldUp();
		VBox leftBar = new VBox();
		this.initialzeBoostAttackButton();
		this.initialzeHealButton();
		this.initialzeShieldUpAttackButton();
		leftBar.setSpacing(20);
		leftBar.getChildren().addAll(boostAttackButton, healButton, shieldUpButton);
		leftBar.setPadding(new Insets(20));
		BackgroundFill bgFill = new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY);
		this.setBackground(new Background(bgFill, null));
		this.setAlignment(Pos.CENTER);
		this.getChildren().add(leftBar);
	}

	public Button getBoostAttackButton() {
		return boostAttackButton;
	}

	public void setBoostAttackButton(Button boostAttackButton) {
		this.boostAttackButton = boostAttackButton;
	}

	public Button getHealButton() {
		return healButton;
	}

	public void setHealButton(Button healButton) {
		this.healButton = healButton;
	}

	public Button getShieldUpButton() {
		return shieldUpButton;
	}

	public void setShieldUpButton(Button shieldUpButton) {
		this.shieldUpButton = shieldUpButton;
	}

	private void initialzeBoostAttackButton() {
		boostAttackButton = new Button("Boost Attack : " + boostAttack.getTimes());
		boostAttackButton.setMaxSize(600, 2000);
		boostAttackButton.setAlignment(Pos.CENTER_LEFT);
		Image img = new Image("purple.jpeg");
		ImageView view = new ImageView(img);
		view.setFitHeight(20);
		view.setPreserveRatio(true);
		boostAttackButton.setStyle("-fx-font: 14 verdana;-fx-background-color: magenta;-fx-font-weight: bold; ");
		boostAttackButton.setGraphic(view);
		boostAttackButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (boostAttack.getTimes() > 0) {
					boostAttackButtonHandler();
					boostAttack.setTimes(boostAttack.getTimes() - 1);
					boostAttackButton.setText("Boost Attack : " + boostAttack.getTimes());
					;
				}
			}
		});
	}

	private void boostAttackButtonHandler() {
		unitHero.setAttack(unitHero.getAttack() + 10);
		this.rightPane.updateGameText(rightPane.getScore(), unitHero);
	}

	private void initialzeHealButton() {
		healButton = new Button("Heal Potions : " + heal.getTimes());
		healButton.setMaxSize(600, 2000);
		healButton.setAlignment(Pos.CENTER_LEFT);
		Image img = new Image("red.png");
		ImageView view = new ImageView(img);
		view.setFitHeight(20);
		view.setPreserveRatio(true);
		healButton.setStyle("-fx-font: 14 verdana;-fx-background-color: salmon;-fx-font-weight: bold; ");
		healButton.setGraphic(view);
		healButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (heal.getTimes() > 0) {
					healButtonHandler();
					heal.setTimes(heal.getTimes() - 1);
					healButton.setText("Heal Potions : " + heal.getTimes());
				}

			}
		});
	}

	public BoostAttack getBoostAttack() {
		return boostAttack;
	}

	public void setBoostAttack(BoostAttack boostAttack) {
		this.boostAttack = boostAttack;
	}

	public Heal getHeal() {
		return heal;
	}

	public void setHeal(Heal heal) {
		this.heal = heal;
	}

	public ShieldUp getShieldUp() {
		return shieldUp;
	}

	public void setShieldUp(ShieldUp shieldUp) {
		this.shieldUp = shieldUp;
	}

	private void healButtonHandler() {
		unitHero.setHealth(unitHero.getHealth() + 10);
		this.rightPane.updateGameText(rightPane.getScore(), unitHero);
	}

	private void initialzeShieldUpAttackButton() {
		shieldUpButton = new Button("Shielding Up : " + shieldUp.getTimes());
		shieldUpButton.setMaxSize(600, 2000);
		shieldUpButton.setAlignment(Pos.CENTER_LEFT);
		Image img = new Image("blue.jpeg");
		ImageView view = new ImageView(img);
		view.setFitHeight(20);
		view.setPreserveRatio(true);
		shieldUpButton.setStyle("-fx-font: 14 verdana;-fx-background-color: deepskyblue;-fx-font-weight: bold; ");
		shieldUpButton.setGraphic(view);
		shieldUpButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (shieldUp.getTimes() > 0) {
					shieldUpButtonHandler();
					shieldUp.setTimes(shieldUp.getTimes() - 1);
					shieldUpButton.setText("Shielding Up : " + shieldUp.getTimes());
				}

			}
		});
	}

	private void shieldUpButtonHandler() {
		unitHero.setShield(unitHero.getShield() + 10);
		this.rightPane.updateGameText(rightPane.getScore(), unitHero);
	}

}