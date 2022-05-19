package main;

import java.io.File;

import gui.ChangeMode;
import gui.MenuPane;
import gui.SelectMenu;
import gui.UltimatePane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import logic.BerserkerHero;
import logic.FatManHero;
import logic.KnightHero;

public class NewMain extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		String musicFile = "q.mp3";
		Media sound = new Media(getClass().getClassLoader().getResource(musicFile).toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.play();
		KnightHero my1 = new KnightHero();
		BerserkerHero my2 = new BerserkerHero();
		FatManHero my3 = new FatManHero();

		UltimatePane c1 = new UltimatePane(my1, arg0, 6000);
		UltimatePane c2 = new UltimatePane(my2, arg0, 6000);
		UltimatePane c3 = new UltimatePane(my3, arg0, 6000);
		UltimatePane c4 = new UltimatePane(my1, arg0, 4000);
		UltimatePane c5 = new UltimatePane(my2, arg0, 4000);
		UltimatePane c6 = new UltimatePane(my3, arg0, 4000);
		UltimatePane c7 = new UltimatePane(my1, arg0, 2000);
		UltimatePane c8 = new UltimatePane(my2, arg0, 2000);
		UltimatePane c9 = new UltimatePane(my3, arg0, 2000);

		Scene game1 = new Scene(c1.getRoot(), 820, 600);
		Scene game2 = new Scene(c2.getRoot(), 820, 600);
		Scene game3 = new Scene(c3.getRoot(), 820, 600);
		Scene game4 = new Scene(c4.getRoot(), 820, 600);
		Scene game5 = new Scene(c5.getRoot(), 820, 600);
		Scene game6 = new Scene(c6.getRoot(), 820, 600);
		Scene game7 = new Scene(c7.getRoot(), 820, 600);
		Scene game8 = new Scene(c8.getRoot(), 820, 600);
		Scene game9 = new Scene(c9.getRoot(), 820, 600);

		SelectMenu sm1 = new SelectMenu(game1, game2, game3, arg0, c1.getTimeline(), c2.getTimeline(),
				c3.getTimeline());
		SelectMenu sm2 = new SelectMenu(game4, game5, game6, arg0, c4.getTimeline(), c5.getTimeline(),
				c6.getTimeline());
		SelectMenu sm3 = new SelectMenu(game7, game8, game9, arg0, c7.getTimeline(), c8.getTimeline(),
				c9.getTimeline());

		Scene chScene1 = new Scene(sm1, 820, 600);
		Scene chScene2 = new Scene(sm2, 820, 600);
		Scene chScene3 = new Scene(sm3, 820, 600);

		ChangeMode cm = new ChangeMode(chScene1, chScene2, chScene3, arg0);
		Scene modeScene = new Scene(cm, 820, 600);
		MenuPane menu = new MenuPane(chScene1, arg0, modeScene);
		Scene smenu = new Scene(menu, 820, 600);

		arg0.setResizable(false);
		arg0.setTitle("Radiant game");
		arg0.setScene(smenu);
		arg0.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
