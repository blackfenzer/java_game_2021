package gui;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuPane extends Pane {
	private Scene chScene;
	private Stage stage;
	private Scene modeScene;

	public MenuPane(Scene chScene, Stage stage, Scene modeScene) {

		this.chScene = chScene;
		this.stage = stage;
		this.modeScene = modeScene;
		this.setPrefSize(1090, 600);

		Image ig = new Image(getClass().getClassLoader().getResource("infinityblade.jpg").toString());
		ImageView img = new ImageView(ig);
		img.setFitWidth(1050);
		img.setFitHeight(600);
		this.getChildren().add(img);

		Title title = new Title("C A M P A I G N");
		title.setTranslateX(232);
		title.setTranslateY(200);
		MenuItem nw = new MenuItem("QUICK PLAY");
		MenuItem ex = new MenuItem("EXIT");
		MenuItem mode = new MenuItem("MODE");
		MenuItem htp = new MenuItem("HOW TO PLAY");

		nw.setOnMouseClicked(e -> {
			newGameHandler();
		});

		mode.setOnMouseClicked(e -> {
			changeModeHandler();
		});

		ex.setOnMouseClicked(e -> {
			exitHandler();
		});

		htp.setOnMouseClicked(e -> {
			showHowToPlay();
		});

		MenuBox vbox = new MenuBox(nw, mode, htp, ex);
		vbox.setTranslateX(305);
		vbox.setTranslateY(300);

		this.getChildren().addAll(title, vbox);

	}

	private static class Title extends StackPane {
		public Title(String name) {
			Rectangle bg = new Rectangle(375, 60);
			bg.setFill(null);

			Text text = new Text(name);
			text.setFill(Color.WHITESMOKE);
			text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 50));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);
		}
	}

	private static class MenuBox extends VBox {
		public MenuBox(MenuItem... items) {
			getChildren().add(createSeperator());

			for (MenuItem item : items) {
				getChildren().addAll(item, createSeperator());
			}
		}

		private Line createSeperator() {
			Line sep = new Line();
			sep.setEndX(210);
			sep.setStroke(Color.DARKGREY);
			return sep;
		}

	}

	private static class MenuItem extends StackPane {
		public MenuItem(String name) {
			LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE,
					new Stop[] { new Stop(0, Color.DARKBLUE), new Stop(0.1, Color.BLACK), new Stop(0.9, Color.BLACK),
							new Stop(1, Color.DARKBLUE)

					});

			Rectangle bg = new Rectangle(200, 30);
			bg.setOpacity(0.4);

			Text text = new Text(name);
			text.setFill(Color.DARKGREY);
			text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, 20));

			setAlignment(Pos.CENTER);
			getChildren().addAll(bg, text);
			setOnMouseEntered(event -> {
				bg.setFill(gradient);
				text.setFill(Color.WHITE);

			});

			setOnMouseExited(event -> {
				bg.setFill(Color.BLACK);
				text.setFill(Color.DARKGREY);
			});

			setOnMousePressed(event -> {
				bg.setFill(Color.DARKVIOLET);

			});

			setOnMouseReleased(event -> {
				bg.setFill(gradient);
			});

		}
	}

	public void newGameHandler() {
		this.stage.setScene(chScene);
	}

	public void exitHandler() {
		Platform.exit();
	}

	public void changeModeHandler() {
		this.stage.setScene(modeScene);
	}

	public void showHowToPlay() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("The Best Instruction");
		alert.setHeaderText("Type Fast And Good Luck!");
		alert.show();
	}

}
