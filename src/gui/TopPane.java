package gui;

import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.Boss;

public class TopPane extends HBox {
	private Text bossText;
	private Boss boss;

	public TopPane(Boss boss) throws FileNotFoundException {
		BackgroundFill bgFill = new BackgroundFill(Color.GHOSTWHITE, CornerRadii.EMPTY, Insets.EMPTY);
		this.setBackground(new Background(bgFill, null));
		this.setSpacing(100);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20));
		this.boss = boss;
		this.initializeGameText();
		this.getChildren().add(bossText);
	}

	private void initializeGameText() {
		bossText = new Text();
		bossText.setText(boss.getName() + "\tHP : " + boss.getHealth() + "\tATK : " + boss.getAttack());
		bossText.setStyle("-fx-font: 20 verdana;-fx-background-color: white;-fx-font-weight: bold;");
	}

	public void updateGameText(Boss boss) {
		bossText.setText(boss.getName() + "\tHP : " + boss.getHealth() + "\tATK : " + boss.getAttack());
	}

	public Boss getBoss() {
		return boss;
	}

	public void setBoss(Boss boss) {
		this.boss = boss;
	}

}
