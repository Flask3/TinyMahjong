package finalproject;

import java.util.ArrayList;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;

public class Playfield {
	Player Player1 = new Player(false);
	Player Player2 = new Player(true);
	Player Player3 = new Player(true);
	Player Player4 = new Player(true);
	int ZhuangJia = -1;
	GridPane[] riverpanelist = new GridPane[4];
	ArrayList<Button> btnList = new ArrayList<Button>();
	
	@FXML
	 Pane AnchorPane;
	@FXML
	 Button button1;
	@FXML
	 Button button2;
	@FXML
	 Button button3;
	@FXML
	 Button button4;
	@FXML
	 Button button5;
	@FXML
	 Button button6;
	@FXML
	 Button button7;
	@FXML
	 Button button8;
	@FXML
	 Button button9;
	@FXML
	 Button button10;
	@FXML
	 Button button11;
	@FXML
	 Button button12;
	@FXML
	 Button button13;
	@FXML
	 Button button14;
	@FXML
	 GridPane riverpane;
	@FXML
	 GridPane riverpane2;
	@FXML
	 GridPane riverpane3;
	@FXML
	 GridPane riverpane4;
	@FXML
	 Text RemainCardAmount;
	@FXML 
	 Button button_hu;
	@FXML
	 Button button_pong;
	@FXML
	 Button button_cancel;
	@FXML
	 HBox Player1ChiPongGangBox;
	@FXML
	 HBox Player2ChiPongGangBox;
	@FXML
	 HBox Player3ChiPongGangBox;
	@FXML
	 HBox Player4ChiPongGangBox;
	@FXML
	 Button button_zhimo;
	@FXML
	 Button button_chi;
	@FXML
	 HBox ChiPane;
	@FXML
	 Button button_gang;
	@FXML
	 Button button_selfgang;
	@FXML 
	 Text CurrentRound;
	@FXML
	 Button button_newgame;
	@FXML
	 HBox ButtonBox;
	@FXML
	 Button button_richi;
	@FXML
	 HBox dorabox;
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
	 ImageView gray;
	@FXML
	 Text liug;
	@FXML
	 Text Player1Points;
	@FXML
	 Text Player2Points;
	@FXML
	 Text Player3Points;
	@FXML
	 Text Player4Points;
	@FXML
	 Button FinalButton;
	@FXML
	 ImageView table_mid;
	@FXML 
	 HBox TingPaiBox;
	
	Player[] playerlist = new Player[4];
	ArrayList<HBox> ChiPongGangBoxList = new ArrayList<HBox>();
	

	GameClass GameClass = new GameClass();
	
	
	@FXML
	public void initialize() {
		
		ZhuangJia++;
		if (ZhuangJia==4)
		{
			ZhuangJia=0;
		}
		
		table_mid.setRotate(ZhuangJia*(-90));
		liug.setVisible(false);
		gray.setVisible(false);
		CountScorePane.setVisible(false);
		TotalPointBox.getChildren().clear();
		UraDoraBox.getChildren().clear();
		PlayerCardBox.getChildren().clear();
		PlayerChiPongGangBox.getChildren().clear();
		TheLastBox.getChildren().clear();
		DoraBox2.getChildren().clear();
		YakuBox.getChildren().clear();
		HanListBox.getChildren().clear();
		TotalBox.getChildren().clear();
		

		
		ButtonBox.getChildren().clear();
		
		playerlist[0] = Player1;
		playerlist[1] = Player2;
		playerlist[2] = Player3;
		playerlist[3] = Player4;
		
		playerlist[ZhuangJia].Zhuang=true;
		
		
		
		
		
		btnList.clear();
		btnList.add(button1);
		btnList.add(button2);
		btnList.add(button3);
		btnList.add(button4);
		btnList.add(button5);
		btnList.add(button6);
		btnList.add(button7);
		btnList.add(button8);
		btnList.add(button9);
		btnList.add(button10);
		btnList.add(button11);
		btnList.add(button12);
		btnList.add(button13);
		btnList.add(button14);
		
		for (int i=0; i<btnList.size(); i++)
		{
			btnList.get(i).setVisible(true);
		}
		
		ChiPongGangBoxList.clear();
		ChiPongGangBoxList.add(Player1ChiPongGangBox);
		ChiPongGangBoxList.add(Player2ChiPongGangBox);
		ChiPongGangBoxList.add(Player3ChiPongGangBox);
		ChiPongGangBoxList.add(Player4ChiPongGangBox);
		
		Player2ChiPongGangBox.setRotate(-90);
		Player3ChiPongGangBox.setRotate(180);
		Player4ChiPongGangBox.setRotate(90);
		
		for (int i=0; i<playerlist.length; i++)
		{
			playerlist[i].clearAll();
			ChiPongGangBoxList.get(i).getChildren().clear();

		}
		button1.setOnMouseEntered(ee->{
			button1.setLayoutY(button1.getLayoutY()-10);
		});
		button1.setOnMouseExited(ee->{
			button1.setLayoutY(button1.getLayoutY()+10);
		});
		button2.setOnMouseEntered(ee->{
			button2.setLayoutY(button2.getLayoutY()-10);
		});
		button2.setOnMouseExited(ee->{
			button2.setLayoutY(button2.getLayoutY()+10);
		});
		button3.setOnMouseEntered(ee->{
			button3.setLayoutY(button3.getLayoutY()-10);
		});
		button3.setOnMouseExited(ee->{
			button3.setLayoutY(button3.getLayoutY()+10);
		});
		button4.setOnMouseEntered(ee->{
			button4.setLayoutY(button4.getLayoutY()-10);
		});
		button4.setOnMouseExited(ee->{
			button4.setLayoutY(button4.getLayoutY()+10);
		});
		button5.setOnMouseEntered(ee->{
			button5.setLayoutY(button5.getLayoutY()-10);
		});
		button5.setOnMouseExited(ee->{
			button5.setLayoutY(button5.getLayoutY()+10);
		});
		button6.setOnMouseEntered(ee->{
			button6.setLayoutY(button6.getLayoutY()-10);
		});
		button6.setOnMouseExited(ee->{
			button6.setLayoutY(button6.getLayoutY()+10);
		});
		button7.setOnMouseEntered(ee->{
			button7.setLayoutY(button7.getLayoutY()-10);
		});
		button7.setOnMouseExited(ee->{
			button7.setLayoutY(button7.getLayoutY()+10);
		});
		button8.setOnMouseEntered(ee->{
			button8.setLayoutY(button8.getLayoutY()-10);
		});
		button8.setOnMouseExited(ee->{
			button8.setLayoutY(button8.getLayoutY()+10);
		});
		button9.setOnMouseEntered(ee->{
			button9.setLayoutY(button9.getLayoutY()-10);
		});
		button9.setOnMouseExited(ee->{
			button9.setLayoutY(button9.getLayoutY()+10);
		});
		button10.setOnMouseEntered(ee->{
			button10.setLayoutY(button10.getLayoutY()-10);
		});
		button10.setOnMouseExited(ee->{
			button10.setLayoutY(button10.getLayoutY()+10);
		});
		button11.setOnMouseEntered(ee->{
			button11.setLayoutY(button11.getLayoutY()-10);
		});
		button11.setOnMouseExited(ee->{
			button11.setLayoutY(button11.getLayoutY()+10);
		});
		button12.setOnMouseEntered(ee->{
			button12.setLayoutY(button12.getLayoutY()-10);
		});
		button12.setOnMouseExited(ee->{
			button12.setLayoutY(button12.getLayoutY()+10);
		});
		button13.setOnMouseEntered(ee->{
			button13.setLayoutY(button13.getLayoutY()-10);
		});
		button13.setOnMouseExited(ee->{
			button13.setLayoutY(button13.getLayoutY()+10);
		});
		button14.setOnMouseEntered(ee->{
			button14.setLayoutY(button14.getLayoutY()-10);
		});
		button14.setOnMouseExited(ee->{
			button14.setLayoutY(button14.getLayoutY()+10);
		});
		

		Image p = new Image(getClass().getResourceAsStream("buttonimage/pong.png"),100,50,false,false);
		ImageView PongImage = new ImageView(p);
		Image p_1 = new Image(getClass().getResourceAsStream("buttonimage/pong_1.png"),100,50,false,false);
		ImageView PongImage_1 = new ImageView(p_1);
		
		Image c = new Image(getClass().getResourceAsStream("buttonimage/chi.png"),100,50,false,false);
		ImageView ChiImage = new ImageView(c);
		Image c_1 = new Image(getClass().getResourceAsStream("buttonimage/chi_1.png"),100,50,false,false);
		ImageView ChiImage_1 = new ImageView(c_1);
		
		Image g = new Image(getClass().getResourceAsStream("buttonimage/gang.png"),100,50,false,false);
		ImageView GangImage = new ImageView(g);
		Image g_1 = new Image(getClass().getResourceAsStream("buttonimage/gang_1.png"),100,50,false,false);
		ImageView GangImage_1 = new ImageView(g_1);
		
		Image z = new Image(getClass().getResourceAsStream("buttonimage/zhimo.png"),100,50,false,false);
		ImageView ZhimoImage = new ImageView(z);
		Image z_1 = new Image(getClass().getResourceAsStream("buttonimage/zhimo_1.png"),100,50,false,false);
		ImageView ZhimoImage_1 = new ImageView(z_1);
		
		Image h = new Image(getClass().getResourceAsStream("buttonimage/hu.png"),100,50,false,false);
		ImageView HuImage = new ImageView(h);
		Image h_1 = new Image(getClass().getResourceAsStream("buttonimage/hu_1.png"),100,50,false,false);
		ImageView HuImage_1 = new ImageView(h_1);
		
		Image r = new Image(getClass().getResourceAsStream("buttonimage/richi.png"),100,50,false,false);
		ImageView RichiImage = new ImageView(r);
		Image r_1 = new Image(getClass().getResourceAsStream("buttonimage/richi_1.png"),100,50,false,false);
		ImageView RichiImage_1 = new ImageView(r_1);
		
		Image cc = new Image(getClass().getResourceAsStream("buttonimage/cancel.png"),100,50,false,false);
		ImageView CancelImage = new ImageView(cc);
		Image cc_1 = new Image(getClass().getResourceAsStream("buttonimage/cancel_1.png"),100,50,false,false);
		ImageView CancelImage_1 = new ImageView(cc_1);
		
		Image n = new Image(getClass().getResourceAsStream("buttonimage/nextround.png"),100,50,false,false);
		ImageView NextRoundImage = new ImageView(n);
		Image n_1 = new Image(getClass().getResourceAsStream("buttonimage/nextround_1.png"),100,50,false,false);
		ImageView NextRoundImage_1 = new ImageView(n_1);
		
		Image back = new Image(getClass().getResourceAsStream("buttonimage/BackToMenu_2.png"),200,100,false,false);
		ImageView BackImage = new ImageView(back);
		Image back_1 = new Image(getClass().getResourceAsStream("buttonimage/BackToMenu_3.png"),200,100,false,false);
		ImageView BackImage_1 = new ImageView(back_1);
		
		button_pong.setBackground(null);
		button_chi.setBackground(null);
		button_gang.setBackground(null);
		button_zhimo.setBackground(null);
		button_hu.setBackground(null);
		button_richi.setBackground(null);
		button_cancel.setBackground(null);
		button_selfgang.setBackground(null);
		button_newgame.setBackground(null);
		FinalButton.setBackground(null);
		
		button_pong.setGraphic(PongImage);
		button_chi.setGraphic(ChiImage);
		button_gang.setGraphic(GangImage);
		button_zhimo.setGraphic(ZhimoImage);
		button_hu.setGraphic(HuImage);
		button_richi.setGraphic(RichiImage);
		button_cancel.setGraphic(CancelImage);
		button_selfgang.setGraphic(GangImage);
		button_newgame.setGraphic(NextRoundImage);
		FinalButton.setGraphic(BackImage);
		
		FinalButton.setOnMouseEntered(e->{
			FinalButton.setGraphic(BackImage_1);
		});
		FinalButton.setOnMouseExited(e->{
			FinalButton.setGraphic(BackImage);
		});
		
		button_newgame.setOnMouseEntered(e->{
			button_newgame.setGraphic(NextRoundImage_1);
		});

		button_newgame.setOnMouseExited(e->{
			button_newgame.setGraphic(NextRoundImage);
		});
		
		button_pong.setOnMouseEntered(e->{
			button_pong.setGraphic(PongImage_1);
		});

		button_pong.setOnMouseExited(e->{
			button_pong.setGraphic(PongImage);
		});
		
		button_chi.setOnMouseEntered(e->{
			button_chi.setGraphic(ChiImage_1);
		});

		button_chi.setOnMouseExited(e->{
			button_chi.setGraphic(ChiImage);
		});
		
		button_gang.setOnMouseEntered(e->{
			button_gang.setGraphic(GangImage_1);
		});

		button_gang.setOnMouseExited(e->{
			button_gang.setGraphic(GangImage);
		});
		

		button_selfgang.setOnMouseEntered(e->{
			button_selfgang.setGraphic(GangImage_1);
		});
		
		button_selfgang.setOnMouseExited(e->{
			button_selfgang.setGraphic(GangImage);
		});
		
		button_zhimo.setOnMouseExited(e->{
			button_zhimo.setGraphic(ZhimoImage);
		});
		
		button_zhimo.setOnMouseEntered(e->{
			button_zhimo.setGraphic(ZhimoImage_1);
		});

		button_hu.setOnMouseExited(e->{
			button_hu.setGraphic(HuImage);
		});
		
		button_hu.setOnMouseEntered(e->{
			button_hu.setGraphic(HuImage_1);
		});

		button_richi.setOnMouseExited(e->{
			button_richi.setGraphic(RichiImage);
		});
		
		button_richi.setOnMouseEntered(e->{
			button_richi.setGraphic(RichiImage_1);
		});
		
		button_cancel.setOnMouseExited(e->{
			button_cancel.setGraphic(CancelImage);
		});
		
		button_cancel.setOnMouseEntered(e->{
			button_cancel.setGraphic(CancelImage_1);
		});

		riverpanelist[0] = riverpane;
		riverpanelist[1] = riverpane2;
		riverpanelist[2] = riverpane3;
		riverpanelist[3] = riverpane4;
		
		for(int i=0; i<riverpanelist.length; i++)
		{
			riverpanelist[i].getChildren().clear();
		}
		
		 //做一副牌
		
		riverpane2.setRotate(-90);
		riverpane3.setRotate(180);
		riverpane4.setRotate(90);
		
		
		GameClass.currentround++;
		GameClass.currentplayer=0;
		GameClass.checkstatus=0;
		

		GameClass.grandriver.clear();
		GameClass.init(playerlist, btnList, riverpanelist
				, button_hu, button_chi, button_pong, button_cancel, button_zhimo,
				button_selfgang, button_newgame, button_gang, RemainCardAmount, AnchorPane, ChiPane, ChiPongGangBoxList, ButtonBox, button_richi, dorabox, 
				CountScorePane,  DoraBox2,  UraDoraBox,  PlayerCardBox,  PlayerChiPongGangBox,
				  TheLastBox, TotalBox,  TotalPointBox, YakuBox, HanListBox, gray, liug, TingPaiBox);
		
			
		SetRoundText();
		BackgroundImage table = new BackgroundImage(new Image(getClass().getResourceAsStream("images/table.png"),800,600,false,false), null, null, null, null);
		GameClass.AnchorPane.setBackground(new Background(table));
		GameClass.map.createmahjong();
		GameClass.creategame();
		GameClass.game();
		
		Player1Points.setFont(Font.font("華康采風體W3",14));
		Player2Points.setFont(Font.font("華康采風體W3",14));
		Player3Points.setFont(Font.font("華康采風體W3",14));
		Player4Points.setFont(Font.font("華康采風體W3",14));
		
		Player1Points.setFill(Color.BLUE);
		Player2Points.setFill(Color.BLUE);
		Player3Points.setFill(Color.BLUE);
		Player4Points.setFill(Color.BLUE);
		
		Player1Points.setText(String.valueOf(GameClass.playerlist[0].PlayerPoints));
		Player2Points.setText(String.valueOf(GameClass.playerlist[1].PlayerPoints));
		Player3Points.setText(String.valueOf(GameClass.playerlist[2].PlayerPoints));
		Player4Points.setText(String.valueOf(GameClass.playerlist[3].PlayerPoints));

	    }


public void PressHu(ActionEvent e) {

	GameClass.ClearButtonBox();
	GameClass.HideBtn_Cancel();
	
	GameClass.Hu(Player1);

}

public void PressPong(ActionEvent e) {

	GameClass.HideButtonBox();
	GameClass.ClearButtonBox();
	GameClass.HideBtn_Cancel();
	
	GameClass.Pong(playerlist[0]);	

	
	
}

public void PressZhimo(ActionEvent e)
{
	GameClass.ClearButtonBox();
	GameClass.HideBtn_Cancel();
	
	GameClass.checkstatus=0;
	
	GameClass.Zhimo(Player1);
	
	
}

public void PressRichi(ActionEvent e)
{
	GameClass.HideButtonBox();
	GameClass.ClearButtonBox();
	GameClass.HideBtn_Cancel();
	
	GameClass.RiChi(Player1);
}



public void PressChi(ActionEvent e)
{
	
	GameClass.HideButtonBox();
	GameClass.ClearButtonBox();
	GameClass.HideBtn_Cancel();
	
	if (GameClass.getChiOption(Player1).size()==1)
	{
		GameClass.Chi_GetKeyAndValue(GameClass.getChiOption(Player1), 0, Player1);
	}
	else if (GameClass.getChiOption(Player1).size()>=2)
	{
		/*
		 * 這邊以下都是new button之類的了
		 */
		ChiPane.setVisible(true);
		if (GameClass.getChiOption(Player1).size()==2)
		{
			Image o = new Image(getClass().getResourceAsStream("images/OptionSelect.png"),175,100,false,false);
			ImageView OptionSelect = new ImageView(o);
			OptionSelect.setLayoutX(ChiPane.getLayoutX()-20);
			OptionSelect.setLayoutY(ChiPane.getLayoutY()-32);
			GameClass.AnchorPane.getChildren().add(OptionSelect);
			
			Button ChiOption1 = new Button();
			Button ChiOption2 = new Button();
			ChiOption1.setBackground(null);
			ChiOption2.setBackground(null);
			HBox ChiBox1 = new HBox();
			HBox ChiBox2 = new HBox();
			
			ChiPane.getChildren().addAll(ChiOption1, ChiOption2);
			
			for (int j=0; j<GameClass.setImageList().size(); j++)
			{
				if (GameClass.getChiOption(Player1).get(0).getKey().equals(GameClass.setCardTypeList()[j]))
				ChiBox1.getChildren().add(new ImageView(GameClass.setImageList_84x128().get(j))); 
			}
			
			
			for (int j=0; j<GameClass.setImageList().size(); j++)
			{
				if (GameClass.getChiOption(Player1).get(0).getValue().equals(GameClass.setCardTypeList()[j]))
				ChiBox1.getChildren().add(new ImageView(GameClass.setImageList_84x128().get(j)));
			}
			
			for (int j=0; j<GameClass.setImageList().size(); j++)
			{
				if (GameClass.getChiOption(Player1).get(1).getKey().equals(GameClass.setCardTypeList()[j]))
				ChiBox2.getChildren().add(new ImageView(GameClass.setImageList_84x128().get(j)));
			}
			for (int j=0; j<GameClass.setImageList().size(); j++)
			{
				if (GameClass.getChiOption(Player1).get(1).getValue().equals(GameClass.setCardTypeList()[j]))
				ChiBox2.getChildren().add(new ImageView(GameClass.setImageList_84x128().get(j)));
			}
			
			ChiOption1.setGraphic(ChiBox1);
			ChiOption2.setGraphic(ChiBox2);
			
			ChiOption1.setOnAction
			(
				e1->
				{
					GameClass.AnchorPane.getChildren().remove(OptionSelect);
					GameClass.Chi_GetKeyAndValue(GameClass.getChiOption(Player1), 0, Player1);
				}
			);
			
			ChiOption2.setOnAction
			(
				e1->
				{
					GameClass.AnchorPane.getChildren().remove(OptionSelect);
					GameClass.Chi_GetKeyAndValue(GameClass.getChiOption(Player1), 1, Player1);
				}
			);
		}
		else if (GameClass.getChiOption(Player1).size()==3)
		{
			Button ChiOption1 = new Button();
			Button ChiOption2 = new Button();
			Button ChiOption3 = new Button();
			ChiOption1.setBackground(null);
			ChiOption2.setBackground(null);
			ChiOption3.setBackground(null);
			HBox ChiBox1 = new HBox();
			HBox ChiBox2 = new HBox();
			HBox ChiBox3 = new HBox();

			Image o = new Image(getClass().getResourceAsStream("images/OptionSelect.png"),230,100,false,false);
			ImageView OptionSelect = new ImageView(o);
			OptionSelect.setLayoutX(ChiPane.getLayoutX()-20);
			OptionSelect.setLayoutY(ChiPane.getLayoutY()-32);
			GameClass.AnchorPane.getChildren().add(OptionSelect);

			ChiPane.getChildren().addAll(ChiOption1, ChiOption2, ChiOption3);
			
			
			for (int j=0; j<GameClass.setImageList().size(); j++)
			{
				if (GameClass.getChiOption(Player1).get(0).getKey().equals(GameClass.setCardTypeList()[j]))
				ChiBox1.getChildren().add(new ImageView(GameClass.setImageList_84x128().get(j)));
			}
			for (int j=0; j<GameClass.setImageList().size(); j++)
			{
				if (GameClass.getChiOption(Player1).get(0).getValue().equals(GameClass.setCardTypeList()[j]))
				ChiBox1.getChildren().add(new ImageView(GameClass.setImageList_84x128().get(j)));
			}
			for (int j=0; j<GameClass.setImageList().size(); j++)
			{
				if (GameClass.getChiOption(Player1).get(1).getKey().equals(GameClass.setCardTypeList()[j]))
				ChiBox2.getChildren().add(new ImageView(GameClass.setImageList_84x128().get(j)));
			}
			for (int j=0; j<GameClass.setImageList().size(); j++)
			{
				if (GameClass.getChiOption(Player1).get(1).getValue().equals(GameClass.setCardTypeList()[j]))
				ChiBox2.getChildren().add(new ImageView(GameClass.setImageList_84x128().get(j)));
			}
			for (int j=0; j<GameClass.setImageList().size(); j++)
			{
				if (GameClass.getChiOption(Player1).get(2).getKey().equals(GameClass.setCardTypeList()[j]))
				ChiBox3.getChildren().add(new ImageView(GameClass.setImageList_84x128().get(j)));
			}
			for (int j=0; j<GameClass.setImageList().size(); j++)
			{
				if (GameClass.getChiOption(Player1).get(2).getValue().equals(GameClass.setCardTypeList()[j]))
				ChiBox3.getChildren().add(new ImageView(GameClass.setImageList_84x128().get(j)));
			}
			
			ChiOption1.setGraphic(ChiBox1);
			ChiOption2.setGraphic(ChiBox2);
			ChiOption3.setGraphic(ChiBox3);
			
			ChiOption1.setOnAction
			(
				e1->
				{
					GameClass.AnchorPane.getChildren().remove(OptionSelect);
					GameClass.Chi_GetKeyAndValue(GameClass.getChiOption(Player1), 0, Player1);
				}
			);
			
			ChiOption2.setOnAction
			(
				e1->
				{
					GameClass.AnchorPane.getChildren().remove(OptionSelect);
					GameClass.Chi_GetKeyAndValue(GameClass.getChiOption(Player1), 1, Player1);
				}
			);
			
			ChiOption3.setOnAction
			(
				e1->
				{
					GameClass.AnchorPane.getChildren().remove(OptionSelect);
					GameClass.Chi_GetKeyAndValue(GameClass.getChiOption(Player1), 2, Player1);
				}
			);
		}
		
	}
	
	
}

public void PressGang(ActionEvent e)
{
	GameClass.HideButtonBox();
	GameClass.ClearButtonBox();
	GameClass.HideBtn_Cancel();
	
	GameClass.Gang(Player1);
	

}

public void PressCancel(ActionEvent e)
{
	GameClass.checkstatus=0;
	playerlist[0].RinShang=false;
	int notzhimoandselfgang=0;
	GameClass.HideButtonBox();
	GameClass.ClearButtonBox();
	GameClass.HideBtn_Cancel();
	
	if (Player1.ZhiMo(Player1.PlayerCards, GameClass.setCardTypeList()) == true || Player1.self_gangable() == true || Player1.RiChiable(GameClass.setCardTypeList()))
	{
		notzhimoandselfgang++;
	}
	if (Player1.self_gangable() && Player1.RiChi)
	{
		GameClass.throwCardProcess(playerlist[GameClass.currentplayer].PlayerCards.size()-1);
	}
	if (notzhimoandselfgang==0 || GameClass.currentplayer!=0) //如果不是自摸的話或自己槓排或立直的話
	{
		
		if (GameClass.map.KeyAndNames.size()==14)
		{
			button_newgame.setText("流局");
			GameClass.ClearButtonBox();
			ButtonBox.getChildren().add(button_newgame);
			GameClass.ShowButtonBox();
		}
		else
			{
			GameClass.nextone();
			
		
		playerlist[GameClass.currentplayer].addCards(GameClass.create.createmahjong(GameClass.map.KeyAndNames.get(0))); //給下個玩家發牌
		GameClass.map.KeyAndNames.remove(0); //牌庫刪掉最前面那個
		
		System.out.println("我是從Cancel()來的喔");
		GameClass.printcards(); //先show出來不然我不知道
	
		if (GameClass.currentplayer==0) 
			
			{
				GameClass.enablebuttons();
				btnList.get(btnList.size()-1).setVisible(true); 
			}//如果第4個玩家打完牌了 要把摸到的那張牌的button秀出來

		if (playerlist[GameClass.currentplayer].ZhiMo(playerlist[GameClass.currentplayer].PlayerCards, GameClass.setCardTypeList()) == true)
		{
			if (GameClass.currentplayer==0)
			{
				GameClass.checkstatus++;
				GameClass.ShowButtonBox();
				GameClass.AddBtn_Zhimo();
				GameClass.ShowBtn_Cancel();
			}
			else
			{
				GameClass.Zhimo(playerlist[GameClass.currentplayer]);
			}
		}
		
		if (!playerlist[GameClass.currentplayer].RiChi && playerlist[GameClass.currentplayer].RiChiable(GameClass.setCardTypeList()))
		{
			if (GameClass.currentplayer==0)
			{
				GameClass.ShowButtonBox();
				GameClass.AddBtn_Richi();
				GameClass.ShowBtn_Cancel();
			}
			else if (playerlist[GameClass.currentplayer].Zhimo==false)
			{
				GameClass.RiChi(playerlist[GameClass.currentplayer]);
			}
		}
		
		if (playerlist[GameClass.currentplayer].self_gangable() == true)
		{
			if (GameClass.currentplayer==0)
			{
				GameClass.ShowButtonBox();
				GameClass.AddBtn_SelfGang();
				GameClass.ShowBtn_Cancel();
				GameClass.checkstatus++;
			}
		}
				
			
		
		if (GameClass.currentplayer==0 || GameClass.currentplayer==1) //如果b=0 也就是第4個玩家打完牌了 或是b=1 也就是第1個玩家打完牌了 就set button
		{
			GameClass.setbuttonImage(playerlist[0], GameClass.setCardTypeList(), GameClass.setImageList_60x60());
		}
		else 
		{
			if (GameClass.checkstatus==0)
			{
				GameClass.BotThrowCard();
			}
		}
		
		RemainCardAmount.setText("餘" + String.valueOf(GameClass.map.KeyAndNames.size()-14));
			}
	}

}

public void PressSelfGang(ActionEvent e)
{
	GameClass.HideButtonBox();
	GameClass.HideBtn_Cancel();
	GameClass.ClearButtonBox();
	
	
	if (GameClass.getGangOptionList(Player1).size()==1)
	{
		GameClass.GetGangOption(GameClass.getGangOptionList(Player1), 0, Player1);
	}
	else if (GameClass.getGangOptionList(Player1).size()==2)
	{
		Image o = new Image(getClass().getResourceAsStream("images/OptionSelect.png"),150,100,false,false);
		ImageView OptionSelect = new ImageView(o);
		OptionSelect.setLayoutX(ChiPane.getLayoutX()-20);
		OptionSelect.setLayoutY(ChiPane.getLayoutY()-32);
		GameClass.AnchorPane.getChildren().add(OptionSelect);

		
		Button GangOption1 = new Button();
		Button GangOption2 = new Button();
		GangOption1.setBackground(null);
		GangOption2.setBackground(null);
		
		ChiPane.getChildren().addAll(GangOption1, GangOption2);
		ChiPane.setVisible(true);
		GangOption1.setGraphic(new ImageView(GameClass.setImageList().get(GameClass.getGangOptionList(Player1).get(0))));
		GangOption2.setGraphic(new ImageView(GameClass.setImageList().get(GameClass.getGangOptionList(Player1).get(1))));

		GangOption1.setOnAction
		(
			e1->
			{
				GameClass.AnchorPane.getChildren().remove(OptionSelect);
				GameClass.GetGangOption(GameClass.getGangOptionList(GameClass.playerlist[0]), 0, GameClass.playerlist[0]);
				
			}
		);
		
		GangOption2.setOnAction
		(
			e1->
			{	GameClass.AnchorPane.getChildren().remove(OptionSelect);
				GameClass.GetGangOption(GameClass.getGangOptionList(GameClass.playerlist[0]), 1, GameClass.playerlist[0]);
			}
		);
	}
	else if (GameClass.getGangOptionList(Player1).size()==3)
	{
			Button GangOption1 = new Button();
			Button GangOption2 = new Button();
			Button GangOption3 = new Button();

			GangOption1.setBackground(null);
			GangOption2.setBackground(null);
			GangOption3.setBackground(null);
			
			Image o = new Image(getClass().getResourceAsStream("images/OptionSelect2.png"),210,100,false,false);
			ImageView OptionSelect2 = new ImageView(o);
			OptionSelect2.setLayoutX(ChiPane.getLayoutX()-20);
			OptionSelect2.setLayoutY(ChiPane.getLayoutY()-35);
			GameClass.AnchorPane.getChildren().add(OptionSelect2);
			
			ChiPane.getChildren().addAll(GangOption1, GangOption2, GangOption3);
			ChiPane.setVisible(true);
			GangOption1.setGraphic(new ImageView(GameClass.setImageList().get(GameClass.getGangOptionList(Player1).get(0))));
			GangOption2.setGraphic(new ImageView(GameClass.setImageList().get(GameClass.getGangOptionList(Player1).get(1))));
			GangOption3.setGraphic(new ImageView(GameClass.setImageList().get(GameClass.getGangOptionList(Player1).get(2))));
			
			GangOption1.setOnAction
			(
				e1->
				{
					GameClass.AnchorPane.getChildren().remove(OptionSelect2);
					GameClass.GetGangOption(GameClass.getGangOptionList(GameClass.playerlist[0]), 0, GameClass.playerlist[0]);
					
				}
			);
			
			GangOption2.setOnAction
			(
				e1->
				{
					GameClass.AnchorPane.getChildren().remove(OptionSelect2);
					GameClass.GetGangOption(GameClass.getGangOptionList(GameClass.playerlist[0]), 1, GameClass.playerlist[0]);
				}
			);
			
			GangOption3.setOnAction
			(
				e1->
				{
					GameClass.AnchorPane.getChildren().remove(OptionSelect2);
					GameClass.GetGangOption(GameClass.getGangOptionList(GameClass.playerlist[0]), 2, GameClass.playerlist[0]);
				}
			);
		
	}
	
}

public void PressNewGame(ActionEvent e) throws InterruptedException {
	button_newgame.setVisible(false);
	Thread.sleep(300);
	if (GameClass.currentround<=8)
	{
		GameClass.enablebuttons();
		initialize();
	}
	else
	{
		FinalButton.setVisible(true);
	}
	
}

public void PressFinalButton() {
	StartPage.mainStage.setScene(StartPage.mainScene);
}

public void SetRoundText()
{
	CurrentRound.setFont(Font.font("華康采風體W3",23));
	if (GameClass.currentround<5)
	{
		CurrentRound.setText("東" + GameClass.currentround + "局");
	}
	else if (GameClass.currentround>=5)
	{
		CurrentRound.setText("南" + GameClass.currentround%4 + "局");
	}
}


public void Throw1(ActionEvent e) {
	GameClass.throwCardProcess(0);
}
public void Throw2(ActionEvent e) {
	GameClass.throwCardProcess(1);
}
public void Throw3(ActionEvent e) {
	GameClass.throwCardProcess(2);
}
public void Throw4(ActionEvent e) {
	GameClass.throwCardProcess(3);
}
public void Throw5(ActionEvent e) {
	GameClass.throwCardProcess(4);
}
public void Throw6(ActionEvent e) {
	GameClass.throwCardProcess(5);
}
public void Throw7(ActionEvent e) {
	GameClass.throwCardProcess(6);
}
public void Throw8(ActionEvent e) {
	GameClass.throwCardProcess(7);
}
public void Throw9(ActionEvent e) {
	GameClass.throwCardProcess(8);
}
public void Throw10(ActionEvent e) {
	GameClass.throwCardProcess(9);
}
public void Throw11(ActionEvent e) {
	GameClass.throwCardProcess(10);
}
public void Throw12(ActionEvent e) {
	GameClass.throwCardProcess(11);
}
public void Throw13(ActionEvent e) {
	GameClass.throwCardProcess(12);
}
public void Throw14(ActionEvent e) {
	GameClass.throwCardProcess(13);
}

}
