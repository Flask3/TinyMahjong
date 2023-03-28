package finalproject;

import java.io.IOException;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.layout.AnchorPane;

public class StartPageControl {
	
	@FXML
	Button GameStart;
	@FXML
	Button Option;
	@FXML
	Button GameEnd;
	@FXML
	 Pane CountScorePane;
	@FXML
	 HBox DoraBox2;
	@FXML
	 HBox UraDoraBox;
	@FXML
	 HBox PlayerCardBox;
	@FXML
	 HBox PlayerChiPongGangBox;
	@FXML
	 HBox TheLastBox;
	@FXML
	 HBox TotalBox;
	@FXML
	 HBox TotalPointBox;
	@FXML
	 VBox YakuBox;
	@FXML
	 VBox HanListBox;
	@FXML
	 Button Back;
	@FXML
	 ImageView PingJ;
	
	RecentBigHu RBH = new RecentBigHu();
	
	public void initialize() {
		
		RecentBigHu RBH = this.RBH;
		Image gs = new Image(getClass().getResourceAsStream("buttonimage/GameStart.png"),200,100,false,false);
		ImageView GameStartImage = new ImageView(gs);
		Image gs_1 = new Image(getClass().getResourceAsStream("buttonimage/GameStart_1.png"),200,100,false,false);
		ImageView GameStartImage_1 = new ImageView(gs_1);
		
		Image op = new Image(getClass().getResourceAsStream("buttonimage/Option.png"),200,100,false,false);
		ImageView OptionImage = new ImageView(op);
		Image op_1 = new Image(getClass().getResourceAsStream("buttonimage/Option_1.png"),200,100,false,false);
		ImageView OptionImage_1 = new ImageView(op_1);
		
		Image ge = new Image(getClass().getResourceAsStream("buttonimage/GameEnd.png"),200,100,false,false);
		ImageView GameEndImage = new ImageView(ge);
		Image ge_1 = new Image(getClass().getResourceAsStream("buttonimage/GameEnd_1.png"),200,100,false,false);
		ImageView GameEndImage_1 = new ImageView(ge_1);
		
		Image back = new Image(getClass().getResourceAsStream("buttonimage/BackToMenu.png"),200,100,false,false);
		ImageView BackImage = new ImageView(back);
		Image back_1 = new Image(getClass().getResourceAsStream("buttonimage/BackToMenu_1.png"),200,100,false,false);
		ImageView BackImage_1 = new ImageView(back_1);
		
		
		GameStart.setGraphic(GameStartImage);
		GameStart.setBackground(null);
		
		Option.setGraphic(OptionImage);
		Option.setBackground(null);
		
		GameEnd.setGraphic(GameEndImage);
		GameEnd.setBackground(null);
		
		Back.setGraphic(BackImage);
		Back.setBackground(null);
		
		Back.setOnMouseEntered(e->{
			Back.setGraphic(BackImage_1);
		});
		Back.setOnMouseExited(e->{
			Back.setGraphic(BackImage);
		});
		
		GameStart.setOnMouseEntered(e->{
			GameStart.setGraphic(GameStartImage_1);
		});
		GameStart.setOnMouseExited(e->{
			GameStart.setGraphic(GameStartImage);
		});
		
		Option.setOnMouseEntered(e->{
			Option.setGraphic(OptionImage_1);
		});
		Option.setOnMouseExited(e->{
			Option.setGraphic(OptionImage);
		});
		
		GameEnd.setOnMouseEntered(e->{
			GameEnd.setGraphic(GameEndImage_1);
		});
		GameEnd.setOnMouseExited(e->{
			GameEnd.setGraphic(GameEndImage);
		});
	}
	
	public EventHandler<KeyEvent> OnKeyPressed = (e)->{
		
		/*按下E的時候會轉*/
		if(e.getCode()==KeyCode.E) {
			 Timeline PingJ_roll = new Timeline (new KeyFrame(Duration.millis(1), (ee)-> {
			            PingJ.setRotate(PingJ.getRotate()+1);
			        })
			    );
			  PingJ_roll.setCycleCount(360);
			  PingJ_roll.play();
			}
	};
	
	
	public void PressStart() throws IOException {
	FXMLLoader loaddder = new FXMLLoader(getClass().getResource("PlayField.fxml"));
    Parent playfield = loaddder.load();
    Scene PlayFieldScene = new Scene(playfield);
    StartPage.mainStage.setScene(PlayFieldScene);

}
	public ArrayList<Image> setImageList_84x128()
	{
		ArrayList<Image> imageList = new ArrayList<Image>();
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1014.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1015.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1016.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1017.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1018.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1019.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1020.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1021.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1022.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1023.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1024.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1025.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1026.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1027.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1028.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1029.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1030.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1031.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1001.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1002.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1003.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1004.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1005.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1006.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1007.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1008.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1009.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1032.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1033.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1034.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1035.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1010.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1011.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1012.png"),26.25,40,false,false));
		imageList.add(new Image(getClass().getResourceAsStream("images_84x128/1013.png"),26.25,40,false,false));

		return imageList;
	}
	public void PressOption()
	{
		
	}
	
	public void PressBack()
	{
		CountScorePane.setVisible(false);
		Back.setVisible(false);
		PlayerCardBox.getChildren().clear();
		PlayerChiPongGangBox.getChildren().clear();
		TheLastBox.getChildren().clear();
		YakuBox.getChildren().clear();
		HanListBox.getChildren().clear();
		TotalBox.getChildren().clear();
		TotalPointBox.getChildren().clear();
	}
	
	public void PressPingJ() throws IOException
	{
		System.out.print("HEY" + RBH.BigHuCards);
		if (RBH.BigHuCards.size()==0)
		{
			System.out.print("我");
			RBH.input();
		}
		System.out.print(RBH.hanList);
		CountScorePane.setVisible(true);
		Back.setVisible(true);
		ShowPlayerCardsBox();
		ShowPlayerChiPongGangBox();
		ShowTheLastBox();
		ShowCalculateScoreBox();
	}
	
	

public void ShowPlayerCardsBox()
{
	
	for (int i=0; i<RBH.BigHuCards.size(); i++)
	{

		PlayerCardBox.getChildren().add(new ImageView(setImageList_84x128().get(RBH.BigHuCards.get(i))));

	}
}

public void ShowPlayerChiPongGangBox() {
	
	for (int i=0; i<RBH.ChiPongGangCards.size(); i++)
	{
		PlayerChiPongGangBox.getChildren().add(new ImageView(setImageList_84x128().get(RBH.ChiPongGangCards.get(i))));

	}
}

public void ShowTheLastBox() {
	
	TheLastBox.getChildren().add(new ImageView(setImageList_84x128().get(RBH.thelastone)));

}

//public void ShowDoraBox2() {
//	for (int i=0; i<this.dora; i++)
//	{
//		DoraBox2.getChildren().add(new ImageView(setImageList_84x128().get(this.DoraList.get(2*i).getcardOrder())));
//	}
//	
//	for (int i=this.dora; i<5; i++)
//	{
//		DoraBox2.getChildren().add(new ImageView(setImageList_84x128().get(34)));
//	}
//}

//public void ShowUraDora(Player player) {
//	if (player.RiChi)
//	{
//	for (int i=0; i<this.dora; i++)
//	{
//		UraDoraBox.getChildren().add(new ImageView(setImageList_84x128().get(this.DoraList.get(2*i+1).getcardOrder())));
//	}
//	
//	for (int i=this.dora; i<5; i++)
//	{
//		UraDoraBox.getChildren().add(new ImageView(setImageList_84x128().get(34)));
//	}
//	}
//	
//	else
//	{
//		for (int i=0; i<5; i++)
//		{
//			UraDoraBox.getChildren().add(new ImageView(setImageList_84x128().get(34)));
//		}
//	}
//}

public void ShowCalculateScoreBox() {
	
	for (int i=0; i<RBH.Yaku.size();i++)
	{
		Text t = new Text(RBH.Yaku.get(i));
		t.setFont(Font.font("華康采風體W3", 25));
		Text tt = new Text(RBH.hanList.get(i));
		tt.setFont(Font.font("華康采風體W3", 25));
		CountScorePane.getChildren().addAll(t,tt);
		YakuBox.getChildren().add(t);
		HanListBox.getChildren().add(tt);
	}
	
	Text t = new Text(RBH.han + "番");
	t.setFont(Font.font("華康采風體W3",40));
	
	TotalBox.getChildren().add(t);
	
	Text tt = new Text(String.valueOf(1000+RBH.han*1000));
	tt.setFont(Font.font("華康采風體W3",60));
	
	TotalPointBox.getChildren().add(tt);
}


	public void PressExit() {
		StartPage.mainStage.close();
	}
	
	
}
