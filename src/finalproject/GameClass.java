package finalproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;
import javafx.util.Pair;

public class GameClass {
	int currentplayer = 0;
	int checkstatus = 0;
	int currentround = 0;
	Player[] playerlist = new Player[4];
	ArrayList<Button> btnList = new ArrayList<Button>();
	ArrayList<mahjong> DoraList = new ArrayList<mahjong>();
	Stack<mahjong> grandriver = new Stack<mahjong>();
	int times = 0;
	int dora = 1;
	ArrayList<HBox> ChiPongGangBoxList = new ArrayList<HBox>();
	mapmahjong map = new mapmahjong();
	createmahjong create = new createmahjong();
	GridPane[] riverpanelist = new GridPane[4]; 
	HBox ButtonBox = new HBox();
	Button button_hu = new Button();
	Button button_chi = new Button();
	Button button_pong = new Button();
	Button button_cancel = new Button();
	Button button_zhimo = new Button();
	Button button_selfgang = new Button();
	Button button_gang = new Button();
	Button button_newgame = new Button();
	Button button_richi = new Button();
	Text RemainCardAmount = new Text();
	Pane AnchorPane = new Pane();
	HBox ChiPane = new HBox();
	HBox dorabox = new HBox();
	 Pane CountScorePane = new Pane();
	 HBox DoraBox2 = new HBox();
	 HBox UraDoraBox = new HBox();
	 HBox PlayerCardBox = new HBox();
	 HBox PlayerChiPongGangBox = new HBox();
	 HBox TheLastBox = new HBox();
	 HBox TotalBox = new HBox();
	 HBox TotalPointBox = new HBox();
	 VBox YakuBox = new VBox();
	 VBox HanListBox = new VBox();
	 ImageView gray = new ImageView();
	 Text liug = new Text();
	 HBox TingPaiBox = new HBox();
	 
	Image p = new Image(getClass().getResourceAsStream("actionimage/pong.png"),200,200,false,false);
	ImageView PongImage = new ImageView(p);
	Image c = new Image(getClass().getResourceAsStream("actionimage/chi.png"),200,200,false,false);
	ImageView ChiImage = new ImageView(c);
	Image g = new Image(getClass().getResourceAsStream("actionimage/gang.png"),200,200,false,false);
	ImageView GangImage = new ImageView(g);
	Image z = new Image(getClass().getResourceAsStream("actionimage/zhimo.png"),200,200,false,false);
	ImageView ZhimoImage = new ImageView(z);
	Image h = new Image(getClass().getResourceAsStream("actionimage/hu.png"),200,200,false,false);
	ImageView HuImage = new ImageView(h);
	Image r = new Image(getClass().getResourceAsStream("actionimage/richi.png"),200,200,false,false);
	ImageView RichiImage = new ImageView(r);
	Image rp = new Image(getClass().getResourceAsStream("actionimage/richipan.png"),123.5,12,false,false);
	ImageView richipan = new ImageView(rp);
	ImageView richipan1 = new ImageView(rp);
	ImageView richipan2 = new ImageView(rp);
	ImageView richipan3 = new ImageView(rp);
	Text TingPaiText = new Text("聽牌：");
	
	void init(Player[] playerlist, ArrayList<Button> btnList, GridPane[] riverpanelist
			, Button button_hu, Button button_chi, Button button_pong,
			Button button_cancel, Button button_zhimo, Button button_selfgang,
			Button button_newgame, Button button_gang, Text RemainCardAmount, Pane AnchorPane
			, HBox ChiPane, ArrayList<HBox> ChiPongGangBoxList, HBox ButtonBox, Button button_richi, HBox dorabox
			, Pane CountScorePane, HBox DoraBox2, HBox UraDoraBox, HBox PlayerCardBox, HBox PlayerChiPongGangBox,
	 HBox TheLastBox, HBox TotalBox, HBox TotalPointBox, VBox YakuBox, VBox HanListBox, ImageView gray, Text liug
	 , HBox TingPaiBox){
		this.playerlist = playerlist;
		this.btnList = btnList;
		this.riverpanelist = riverpanelist;
		this.button_hu = button_hu;
		this.button_chi = button_chi;
		this.button_pong = button_pong;
		this.button_cancel = button_cancel;
		this.button_zhimo = button_zhimo;
		this.button_selfgang = button_selfgang;
		this.button_gang = button_gang;
		this.RemainCardAmount = RemainCardAmount;
		this.AnchorPane = AnchorPane;
		this.button_newgame = button_newgame;
		this.ChiPane = ChiPane;
		this.ChiPongGangBoxList = ChiPongGangBoxList;
		this.ButtonBox = ButtonBox;
		this.button_richi = button_richi;
		this.dorabox = dorabox;
		this.CountScorePane = CountScorePane;
		this.PlayerCardBox = PlayerCardBox;
		this.PlayerChiPongGangBox = PlayerChiPongGangBox;
		this.TheLastBox = TheLastBox;
		this.TotalBox = TotalBox;
		this.DoraBox2 = DoraBox2;
		this.UraDoraBox = UraDoraBox;
		this.TotalPointBox = TotalPointBox;
		this.YakuBox = YakuBox;
		this.HanListBox = HanListBox;
		this.gray = gray;
		this.liug = liug;
		this.TingPaiBox = TingPaiBox;
	};
	
	
public void creategame() {
	setrichipan();
	//發牌
//	int[] uhhuh = {9,10,11,13,14,15,17,17,17,24,24,26,26};
//	
//	for (int i=0; i<uhhuh.length; i++)
//	{
//		playerlist[0].PlayerCards.add(create.createmahjong(map.KeyAndNames.get(uhhuh[i])));
//		
//	}
//	
//	for (int i=uhhuh.length-1; i>=0; i--)
//	{
//		map.KeyAndNames.remove(uhhuh[i]);
//	}
	
	
	
	map.ShuffleMap(); //洗他
	this.dora=1;
	DoraList.clear();
	//Add Dora Card to Dora List
	for (int i=map.KeyAndNames.size()-14; i<map.KeyAndNames.size()-4; i++)
	{
		DoraList.add(create.createmahjong(map.KeyAndNames.get(i)));
	}
	
	for (int i=0; i<13; i++)
		{
			playerlist[0].PlayerCards.add(create.createmahjong(map.KeyAndNames.get(0)));
			map.KeyAndNames.remove(0);
			playerlist[1].PlayerCards.add(create.createmahjong(map.KeyAndNames.get(0)));
			map.KeyAndNames.remove(0);
			playerlist[2].PlayerCards.add(create.createmahjong(map.KeyAndNames.get(0)));
			map.KeyAndNames.remove(0);
			playerlist[3].PlayerCards.add(create.createmahjong(map.KeyAndNames.get(0)));
			map.KeyAndNames.remove(0);
		}
		
		//排序
		playerlist[0].sortCards();
		playerlist[1].sortCards();
		playerlist[2].sortCards();
		playerlist[3].sortCards();
		
	setDoraImage();	
	System.out.print("Dora: ");
	for (int i=0; i<DoraList.size(); i++)
	{
		System.out.print(DoraList.get(i).getName());
	}
	System.out.println();
}


public void nextone()
{
	/*
	 * 下一位的函數
	 */
	
	currentplayer++;
	if (currentplayer==4)
	{
		currentplayer=0;
	}
}

public void disablebuttons() {
	for (int i=0; i<btnList.size(); i++)
	{
		btnList.get(i).setDisable(true);
	}
}

public void enablebuttons() {
	for (int i=0; i<btnList.size(); i++)
	{
		btnList.get(i).setDisable(false);
	}
}

//印牌的函數
public void printcards() {
	System.out.print("Player1的牌:");
	for (int i=0; i<playerlist[0].PlayerCards.size(); i++)
	{		
		System.out.print(" " + playerlist[0].PlayerCards.get(i).getName());
	}
	System.out.print("\n");
	System.out.print("Player2的牌:");
	for (int i=0; i<playerlist[1].PlayerCards.size(); i++)
	{
		System.out.print(" " + playerlist[1].PlayerCards.get(i).getName());
	}
	System.out.print("\n");
	System.out.print("Player3的牌:");
	for (int i=0; i<playerlist[2].PlayerCards.size(); i++)
	{
		System.out.print(" " + playerlist[2].PlayerCards.get(i).getName());

	}
	System.out.print("\n");
	System.out.print("Player4的牌:");
	for (int i=0; i<playerlist[3].PlayerCards.size(); i++)
	{
		System.out.print(" " + playerlist[3].PlayerCards.get(i).getName());

	}
	System.out.print("\n");
	System.out.print("\n");
	System.out.print("Player1的河:");
	for (int i=0; i<playerlist[0].river.size(); i++)
	{		
		System.out.print(" " + playerlist[0].river.get(i).getName());
	}
	System.out.print("\n");
	System.out.print("Player2的河:");
	for (int i=0; i<playerlist[1].river.size(); i++)
	{		
		System.out.print(" " + playerlist[1].river.get(i).getName());
	}
	System.out.print("\n");
	System.out.print("Player3的河:");
	for (int i=0; i<playerlist[2].river.size(); i++)
	{		
		System.out.print(" " + playerlist[2].river.get(i).getName());
	}
	System.out.print("\n");
	System.out.print("Player4的河:");
	for (int i=0; i<playerlist[3].river.size(); i++)
	{		
		System.out.print(" " + playerlist[3].river.get(i).getName());
	}
	System.out.print("\n");
	System.out.print("\n");
	
	System.out.print("全部的河:");
	for (int i=0; i<grandriver.size(); i++)
	{		
		System.out.print(" " + grandriver.get(i).getName());
	}
	System.out.print("\n");
	System.out.print("\n");
	
	System.out.print("Player1的吃碰槓:");
	for (int i=0; i<playerlist[0].ChiPongGangCards.size(); i++)
	{		
		System.out.print(" " + playerlist[0].ChiPongGangCards.get(i).getName());
	}
	System.out.print("\n");
	System.out.print("Player2的吃碰槓:");
	for (int i=0; i<playerlist[1].ChiPongGangCards.size(); i++)
	{
		System.out.print(" " + playerlist[1].ChiPongGangCards.get(i).getName());
	}
	System.out.print("\n");
	System.out.print("Player3的吃碰槓:");
	for (int i=0; i<playerlist[2].ChiPongGangCards.size(); i++)
	{
		System.out.print(" " + playerlist[2].ChiPongGangCards.get(i).getName());

	}
	System.out.print("\n");
	System.out.print("Player4的吃碰槓:");
	for (int i=0; i<playerlist[3].ChiPongGangCards.size(); i++)
	{
		System.out.print(" " + playerlist[3].ChiPongGangCards.get(i).getName());

	}
	System.out.print("\n");
	System.out.print("\n");
}

public void game() {

	for (int i=0; i<playerlist.length; i++)
	{
		if (playerlist[i].Zhuang)
			currentplayer=i;
	}
	/*
	 * 基本上是給第一位玩家發牌
	 * 如果第一位玩家是自己的話 就要把最後一個button秀出來
	 */
	if (currentplayer==0)
	{
		btnList.get(13).setVisible(true);
	}
	else
	{
		btnList.get(13).setVisible(false);
	}
	
	
	playerlist[currentplayer].addCards(create.createmahjong(map.KeyAndNames.get(0)));
	setbuttonImage(playerlist[0], setCardTypeList(), setImageList_60x60());
	map.KeyAndNames.remove(0);
	printcards();
	playerlist[currentplayer].setCardTypeNumber(setCardTypeList());
	
	/*
	 * 如果能槓就要秀出槓
	 * 如果能自摸就秀出自摸
	 */

	if (playerlist[currentplayer].ZhiMo(playerlist[currentplayer].PlayerCards, setCardTypeList()) == true)
	{
		checkstatus++;
		ShowButtonBox();
		AddBtn_Zhimo();
		ShowBtn_Cancel();
	}
	
	System.out.println("現在能立直了嗎: " + playerlist[currentplayer].RiChiable(setCardTypeList()));
	if (!playerlist[currentplayer].RiChi && playerlist[currentplayer].RiChiable(setCardTypeList()))
	{
		if (currentplayer==0)
		{
			ShowButtonBox();
			AddBtn_Richi();
			ShowBtn_Cancel();
		}
		else if (playerlist[currentplayer].Zhimo==false)
		{
			RiChi(playerlist[currentplayer]);
		}
	}
	
	if (playerlist[currentplayer].self_gangable() == true)
	{
		if (currentplayer==0)
		{
			ShowButtonBox();
			AddBtn_SelfGang();
			ShowBtn_Cancel();
		}
	}
	
	RemainCardAmount.setFont(Font.font("華康采風體W3",23));
	RemainCardAmount.setText("餘" + String.valueOf(map.KeyAndNames.size()-14));
	
	if (currentplayer!=0 && checkstatus==0)
	{
		BotThrowCard();
	}
}


final public void ShowButtonBox() {
	ButtonBox.setVisible(true);
}

public void HideButtonBox() {
	ButtonBox.setVisible(false);
}

public void ClearButtonBox() {
	ButtonBox.getChildren().clear();
}

public void AddBtn_Zhimo() {
	ButtonBox.getChildren().add(button_zhimo);
}

public void AddBtn_Hu() {
	ButtonBox.getChildren().add(button_hu);
}

public void AddBtn_Pong() {
	ButtonBox.getChildren().add(button_pong);
}

public void AddBtn_Chi() {
	ButtonBox.getChildren().add(button_chi);
}

public void AddBtn_Gang() {
	ButtonBox.getChildren().add(button_gang);
}

public void AddBtn_SelfGang() {
	ButtonBox.getChildren().add(button_selfgang);
}

public void AddBtn_Richi() {
	ButtonBox.getChildren().add(button_richi);
}

public void ShowBtn_Cancel() {
	button_cancel.setVisible(true);
}

public void HideBtn_Cancel() {
	button_cancel.setVisible(false);
}



public ArrayList<mahjong> CloneHu(Player player)
{
	/*
	 * clone = Player.PlayerCards + grandriver.peek
	 */
	ArrayList<mahjong> clone = new ArrayList<mahjong>();
	clone = (ArrayList<mahjong>) player.PlayerCards.clone();

	clone.add(grandriver.peek());
	
	return clone;
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

public ArrayList<Image> setImageList_60x60()
{
	ArrayList<Image> imageList = new ArrayList<Image>();
	imageList.add(new Image(getClass().getResourceAsStream("images/man1.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man2.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man3.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man4.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man5.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man6.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man7.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man8.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man9.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin1.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin2.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin3.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin4.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin5.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin6.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin7.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin8.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin9.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo1.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo2.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo3.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo4.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo5.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo6.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo7.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo8.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo9.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/wind-east.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/wind-south.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/wind-west.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/wind-north.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/dragon-chun.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/dragon-green.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/dragon-haku.png"),50,50,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/face-down-128px.png"),50,50,false,false));

	return imageList;
}

public ArrayList<Image> setImageList()
{
	ArrayList<Image> imageList = new ArrayList<Image>();
	imageList.add(new Image(getClass().getResourceAsStream("images/man1.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man2.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man3.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man4.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man5.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man6.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man7.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man8.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/man9.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin1.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin2.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin3.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin4.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin5.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin6.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin7.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin8.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/pin9.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo1.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo2.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo3.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo4.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo5.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo6.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo7.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo8.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/bamboo9.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/wind-east.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/wind-south.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/wind-west.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/wind-north.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/dragon-chun.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/dragon-green.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/dragon-haku.png"),40,40,false,false));
	imageList.add(new Image(getClass().getResourceAsStream("images/face-down-128px.png"),40,40,false,false));

	return imageList;
}

public void setDoraImage()
{
	dorabox.getChildren().clear();
	
	for (int i=0; i<this.dora; i++)
	{
		dorabox.getChildren().add(new ImageView(setImageList_84x128().get(this.DoraList.get(2*i).getcardOrder())));
	}
	
	for (int i=this.dora; i<5; i++)
	{
		dorabox.getChildren().add(new ImageView(setImageList_84x128().get(34)));
	}
}

public String[] setCardTypeList()
{
	String[] CardTypeList = {"1萬", "2萬", "3萬", "4萬", "5萬", "6萬", "7萬", "8萬", "9萬",
					"1筒", "2筒", "3筒", "4筒", "5筒", "6筒", "7筒", "8筒", "9筒",
					"1條", "2條", "3條", "4條", "5條", "6條", "7條", "8條", "9條",
					"東風", "南風", "西風", "北風", "紅中", "發財", "白板", "暗槓"};
	return CardTypeList;
}


public void setbuttonImage(Player player, String[] CardTypeList, ArrayList<Image> imageList)
{
	/*
	 * 設自己的牌button的圖片的method
	 * 理論上只有player1會用到吧
	 */
	for (int i=0; i<player.PlayerCards.size(); i++)
	{
		for (int j=0; j<imageList.size(); j++)
		{
			if (player.PlayerCards.get(i).getName().equals(CardTypeList[j]))
				{
					btnList.get(i).setGraphic(new ImageView(imageList.get(j)));
					break;
				}
		}
	}
}

public void setriverImage(Player player, String[] CardTypeList, ArrayList<Image> imageList, GridPane[] riverpanelist) 
{
	/*
	 * 設河的圖片
	 * 這就大家都會用到了
	 */
	for (int i=0; i<player.river.size(); i++)
	{
		for (int j=0; j<imageList.size(); j++)
		{
			if (player.river.get(i).getName().equals(CardTypeList[j]))
				{
					riverpanelist[currentplayer].add(new ImageView(imageList.get(j)), i%6 , i/6);
					break;
				}
		}
	}
}

public void setChiPongGangBoxImage(Player player, String[] CardTypeList, ArrayList<Image> imageList)
{
	/*
	 * 設置吃碰槓的圖片的函數
	 * 大家應該都會用到，但還沒寫其他3人的case
	 * 
	 * 更新: 我寫了
	 */
	int index=-1;
	for (int i=0; i<playerlist.length; i++)
	{
		if (player==playerlist[i])
			{
				index=i;
				break;
			}
	}
	ChiPongGangBoxList.get(index).getChildren().clear();
	for (int i=0; i<player.ChiPongGangCards.size(); i++)
	{
		for (int j=0; j<imageList.size(); j++)
		{
			if (player.ChiPongGangCards.get(i).getName().equals(CardTypeList[j]))
				{
					ChiPongGangBoxList.get(index).getChildren().add(new ImageView(imageList.get(j)));
					break;
				}
		}
	}
}

public void BotThrowCard() {
	if (playerlist[currentplayer].JustRiChi)
	{
		for (int i=0; i<playerlist[currentplayer].PlayerCards.size(); i++)
		{
			if (playerlist[currentplayer].PlayerRichiOptions.get(0).getcardOrder() == 
					playerlist[currentplayer].PlayerCards.get(i).getcardOrder())
				throwCardProcess(i);
		}
	}
	else
	throwCardProcess(playerlist[currentplayer].ThrowCardLogic(
			playerlist[currentplayer].PlayerCards, playerlist[currentplayer].CardTypeNumber, setCardTypeList()));
}

public void RiChi(Player player) {
	player.JustRiChi=true;
	
	if (player==playerlist[0])
	{
		int index=-1;
		for (int i=0; i<player.PlayerRichiOptions.size(); i++)
		{
			for (int j=index+1; j<btnList.size(); j++)
			{

				if (player.PlayerCards.get(j).getcardOrder()==player.PlayerRichiOptions.get(i).getcardOrder())
				{
					index=j;
					System.out.print(index);
					btnList.get(j).setDisable(false);
				}
				else btnList.get(j).setDisable(true);
			}
		}
	}
	System.out.println("嘿我立直了");
}


public void throwCardProcess(int a)
{
	/*
	 * 丟牌環節：
	 * 1. 丟牌
	 *  1.1 如果立直就丟摸到的
	 * 2. 排序該玩家的牌
	 * 3. 新增手手的圖片 
	 * 	3.1 要按照現在打牌的人轉手手的角度
	 * 4. 進Timeline
	 * 	4.1 秀出丟牌動畫 
	 * 5. 丟牌完的動畫之後buttonlist最後一張牌消失 + 該玩家的河reset圖片
	 * 6. 接著進接下來的判斷
	 */
	
	System.out.println("CurrentPlayer能夠立直嗎? : " + playerlist[currentplayer].RiChiable(setCardTypeList()));
	System.out.println("CurrentPlayer立直了嗎? : " + playerlist[currentplayer].RiChi);
	
	if (!playerlist[currentplayer].RiChi && !playerlist[currentplayer].JustRiChi)
	{
		//如果還沒立直
		grandriver.add(playerlist[currentplayer].PlayerCards.get(a));
		playerlist[currentplayer].throwCards(playerlist[currentplayer].PlayerCards.get(a)); //丟牌
	}
	else if (playerlist[currentplayer].RiChi)
	{
		//如果立了
		grandriver.add(playerlist[currentplayer].PlayerCards.get(playerlist[currentplayer].PlayerCards.size()-1));
		playerlist[currentplayer].throwCards(playerlist[currentplayer].PlayerCards.get(playerlist[currentplayer].PlayerCards.size()-1)); //丟牌
	}
	else if (!playerlist[currentplayer].RiChi && playerlist[currentplayer].JustRiChi)
	{
		//如果正要立直
		playerlist[currentplayer].JustRiChi=false;
		playerlist[currentplayer].RiChi=true;
		
		AnchorPane.getChildren().add(RichiImage);
		setActionImage(RichiImage, playerlist[currentplayer]);
		//立直棒出現
		if (currentplayer==0)
		showrichipan(richipan);
		else if (currentplayer==1)
		showrichipan(richipan1);
		else if (currentplayer==2)
		showrichipan(richipan2);
		else if (currentplayer==3)
		showrichipan(richipan3);
		
		grandriver.add(playerlist[currentplayer].PlayerCards.get(a));
		playerlist[currentplayer].throwCards(playerlist[currentplayer].PlayerCards.get(a)); //丟牌
		
	}


	playerlist[currentplayer].sortCards(); 
	

	Image h = new Image(getClass().getResourceAsStream("images/hand.png"));
	ImageView hand = new ImageView(h);
	AnchorPane.getChildren().add(hand);
	if (currentplayer==0)
	{
	hand.setLayoutX(btnList.get(a).getLayoutX());
	hand.setLayoutY(550);
	}
	else if (currentplayer==1)
	{
		hand.setRotate(-90);
		hand.setLayoutX(647);
		hand.setLayoutY(156);
	}
	else if (currentplayer==2)
	{
		hand.setRotate(180);
		hand.setLayoutX(283);
		hand.setLayoutY(14);
	}
	else
	{
		hand.setRotate(90);
		hand.setLayoutX(0);
		hand.setLayoutY(156);
	}
	
	
	Timeline handmove = new Timeline(new KeyFrame(Duration.millis(1),
			(ee)-> 
			{
				
				times++;
				// X : i%6 
				if (currentplayer==0) {
				hand.setLayoutX(hand.getLayoutX() +
				(
						(
								riverpanelist[currentplayer].getLayoutX()
								+
								(playerlist[currentplayer].river.size()%6)*25
								
						)
						 
						- btnList.get(a).getLayoutX()-25)/ 500);
				
				// Y : i/6
				
				hand.setLayoutY(hand.getLayoutY() + 
					(
						(
						riverpanelist[currentplayer].getLayoutY()
						+
						(playerlist[currentplayer].river.size()/6)*17
						)
						
						- btnList.get(a).getLayoutY()-17)/ 500);
				}
				else if (currentplayer==1)
				{
					hand.setLayoutX(hand.getLayoutX() +
							(
									(
											riverpanelist[currentplayer].getLayoutX()
											+
											(playerlist[currentplayer].river.size()%6)*25
											
									)
									 
									- 647 -25)/ 500);
							
							// Y : i/6
							
							hand.setLayoutY(hand.getLayoutY() + 
								(
									(
									riverpanelist[currentplayer].getLayoutY()
									+
									(playerlist[currentplayer].river.size()/6)*17
									)
									
									- 156 -17)/ 500);
							
				}
				else if (currentplayer==2)
				{
					hand.setLayoutX(hand.getLayoutX() +
							(
									(
											riverpanelist[currentplayer].getLayoutX()
											+
											(playerlist[currentplayer].river.size()%6)*25
											
									)
									 
									- 283 -25)/ 500);
							
							// Y : i/6
							
							hand.setLayoutY(hand.getLayoutY() + 
								(
									(
									riverpanelist[currentplayer].getLayoutY()
									+
									(playerlist[currentplayer].river.size()/6)*17
									)
									
									- 14 -17)/ 500);
							
				}
				else if (currentplayer==3)
				{
					hand.setLayoutX(hand.getLayoutX() +
							(
									(
											riverpanelist[currentplayer].getLayoutX()
											+
											(playerlist[currentplayer].river.size()%6)*25
											
									)
									 
									- 0-25)/ 500);
							
							// Y : i/6
							
							hand.setLayoutY(hand.getLayoutY() + 
								(
									(
									riverpanelist[currentplayer].getLayoutY()
									+
									(playerlist[currentplayer].river.size()/6)*17
									)
									
									- 156-17)/ 500);
							
				}
				
				if (times==500)
				{
					hand.setVisible(false);
					
				}

			}));
	handmove.setCycleCount(500);

	handmove.setOnFinished(event-> {
		btnList.get(btnList.size()-1).setVisible(false); 

		setriverImage(playerlist[currentplayer], setCardTypeList(), setImageList(), riverpanelist);
		 TheCheck();
				
		times=0;
	});
	
	handmove.play();
	
}

public void TheCheck() {
	//我
	if (currentplayer==0) {
		disablebuttons();
		setbuttonImage(playerlist[0], setCardTypeList(), setImageList_60x60());
		if (playerlist[1].HuAble(CloneHu(playerlist[1]), setCardTypeList()))
		{
			checkstatus++;
			Hu(playerlist[1]);
		}
		else if (playerlist[2].HuAble(CloneHu(playerlist[2]), setCardTypeList()))
		{
			checkstatus++;
			Hu(playerlist[2]);
		}
		else if (playerlist[3].HuAble(CloneHu(playerlist[3]), setCardTypeList()))
		{
			checkstatus++;
			Hu(playerlist[3]);
		}
		//再看碰
		else if (playerlist[1].pongable(grandriver.peek()) && !playerlist[1].RiChi)
		{
			Pong(playerlist[1]);
			checkstatus++;
		}
		else if (playerlist[2].pongable(grandriver.peek()) && !playerlist[2].RiChi)
		{
			Pong(playerlist[2]);
			checkstatus++;
		}
		else if (playerlist[3].pongable(grandriver.peek()) && !playerlist[3].RiChi)
		{
			Pong(playerlist[3]);
			checkstatus++;
		}
		//再看吃
		else if (playerlist[1].chiable(grandriver.peek(), setCardTypeList())!=0 && !playerlist[1].RiChi)
		{
			checkstatus++;
			Chi_GetKeyAndValue(getChiOption(playerlist[1]), 0, playerlist[1]);
		}
	}

	//2號位
	else if (currentplayer==1)
	{
			//先看胡
		if (playerlist[2].HuAble(CloneHu(playerlist[2]), setCardTypeList()))
		{
			checkstatus++;
			Hu(playerlist[2]);
		}
		else if (playerlist[3].HuAble(CloneHu(playerlist[3]), setCardTypeList()))
		{
			checkstatus++;
			Hu(playerlist[3]);
		}
		else if (playerlist[0].HuAble(CloneHu(playerlist[0]), setCardTypeList()))
		{
			ShowButtonBox();
			AddBtn_Hu();
			ShowBtn_Cancel();
			checkstatus++;
			
		}
		
		//如果沒人胡牌再看碰
		else 
			{
			if (playerlist[2].pongable(grandriver.peek())&& !playerlist[2].RiChi)
			
		{
			Pong(playerlist[2]);
			checkstatus++;
		}
		else if (playerlist[3].pongable(grandriver.peek()) && !playerlist[3].RiChi)
		{
			Pong(playerlist[3]);
			checkstatus++;
		}
		else if  (playerlist[0].pongable(grandriver.peek())==true && !playerlist[0].RiChi)
			
			{
				ShowButtonBox();
				AddBtn_Pong();
				ShowBtn_Cancel();
				checkstatus++;
			}
		//再看吃
		else  if (playerlist[2].chiable(grandriver.peek(), setCardTypeList())!=0 && !playerlist[2].RiChi)
			{
				checkstatus++;
				Chi_GetKeyAndValue(getChiOption(playerlist[2]), 0, playerlist[2]);
			}
			
			}
	}
	//3號位
	else if (currentplayer==2) {
		//先看胡
		if (playerlist[1].HuAble(CloneHu(playerlist[1]), setCardTypeList()))
		{
			checkstatus++;
			Hu(playerlist[1]);
		}
		else if (playerlist[3].HuAble(CloneHu(playerlist[3]), setCardTypeList()))
		{
			checkstatus++;
			Hu(playerlist[3]);
		}
		else if (playerlist[0].HuAble(CloneHu(playerlist[0]), setCardTypeList()))
		{
			ShowButtonBox();
			AddBtn_Hu();
			ShowBtn_Cancel();
			checkstatus++;
		}
		//再看碰
		else if (playerlist[1].pongable(grandriver.peek()) && !playerlist[1].RiChi)
		{
			Pong(playerlist[1]);
			checkstatus++;
		}
		else if (playerlist[3].pongable(grandriver.peek()) && !playerlist[3].RiChi)
		{
			Pong(playerlist[3]);
			checkstatus++;
		}
		else if  (playerlist[0].pongable(grandriver.peek())==true && !playerlist[0].RiChi)
		{
			ShowButtonBox();
			AddBtn_Pong();
			ShowBtn_Cancel();
			checkstatus++;
		}
		//再看吃
		else if (playerlist[3].chiable(grandriver.peek(), setCardTypeList())!=0 && !playerlist[3].RiChi)
		{
			checkstatus++;
			Chi_GetKeyAndValue(getChiOption(playerlist[3]), 0, playerlist[3]);
		}
	}
	//3號位
	else if (currentplayer==3)
	{
		if (playerlist[1].HuAble(CloneHu(playerlist[1]), setCardTypeList()))
		{
			checkstatus++;
			Hu(playerlist[1]);
		}
		else if (playerlist[2].HuAble(CloneHu(playerlist[2]), setCardTypeList()))
		{
			checkstatus++;
			Hu(playerlist[2]);
		}
		else if (playerlist[0].HuAble(CloneHu(playerlist[0]), setCardTypeList()) ||
				playerlist[0].pongable(grandriver.peek())==true ||
				playerlist[0].chiable(grandriver.peek(), setCardTypeList())!=0)
		{
			if (playerlist[0].HuAble(CloneHu(playerlist[0]), setCardTypeList()))
			{
				ShowButtonBox();
				AddBtn_Hu();
				ShowBtn_Cancel();
				checkstatus++;
			}
			if (playerlist[0].pongable(grandriver.peek())==true && !playerlist[0].RiChi)
			{
				ShowButtonBox();
				AddBtn_Pong();
				ShowBtn_Cancel();
				checkstatus++;
			}
			//再看吃
			if (playerlist[0].chiable(grandriver.peek(), setCardTypeList())!=0 && !playerlist[0].RiChi)
			{
				ShowButtonBox();
				AddBtn_Chi();
				ShowBtn_Cancel();
				checkstatus++;
			}
		}
		//再看碰
		else if (playerlist[1].pongable(grandriver.peek()) && !playerlist[1].RiChi)
		{
			Pong(playerlist[1]);
			checkstatus++;
		}
		else if (playerlist[2].pongable(grandriver.peek()) && !playerlist[2].RiChi)
		{
			Pong(playerlist[2]);
			checkstatus++;
		}

	}
	if (currentplayer!=0)
	{
		if (playerlist[0].gangable(grandriver.peek())==true && !playerlist[0].RiChi)
		{
			ShowButtonBox();
			AddBtn_Gang();
			ShowBtn_Cancel();
			checkstatus++;
		}
	}

	System.out.println("checkstatus: " + checkstatus);

	if (checkstatus==0) //如果checkstatus = 0 也就是沒有碰或胡或槓或吃
	{
		if (currentplayer==0)
		{
			if (playerlist[currentplayer].TingPai(playerlist[currentplayer].PlayerCards, setCardTypeList()))
			{
				TingPaiBox.getChildren().clear();
				
				TingPaiText.setFont(Font.font("華康采風體W3", 30));
				TingPaiBox.getChildren().add(TingPaiText);
				TingPaiBox.setVisible(true);
				for (int i=0; i<playerlist[currentplayer].PlayerTingCards.size(); i++)
				{
					for (int j=0; j<setCardTypeList().length; j++)
					{
						if (playerlist[currentplayer].PlayerTingCards.get(i).getcardOrder()==j)
							{
								TingPaiBox.getChildren().add(new ImageView(setImageList_60x60().get(j)));
								break;
							}
					}
				}
			}
			
		}
		GiveCardToNextOne();
	}
}

public void ShowNextRoundButton() {
	button_newgame.setVisible(true);
	button_newgame.setOpacity(0);
	Timeline shownextroundbtn = new Timeline(new KeyFrame(Duration.millis(100), (ee)-> {
		button_newgame.setOpacity(button_newgame.getOpacity()+0.25);
	}));
	shownextroundbtn.setCycleCount(4);
	shownextroundbtn.play();

}
public void GiveCardToNextOne() {
	/*
	 * 接下來要發牌給下一位了
	 * 0. 當前玩家更新手牌每張的張數: setCardTypeNumber(setCardTypeList());
	 * 1. 流局了嗎?
	 *    1.1 Y : 流局
	 *    1.2 N : 下一位 (nextone())
	 * 2. 發牌給下一位，且把牌庫頂的那張從牌庫頂刪掉
	 * 3. 如果接下來輪到我，要把btnList的最後一個秀出來
	 * 	  3.1 如果接下來輪到我 or 下家，要更新手牌的圖片
	 * 4. check是否能槓  & 自摸 & 立直
	 */
	
	playerlist[currentplayer].setCardTypeNumber(setCardTypeList());
	
	if (map.KeyAndNames.size()==14)
	{
		gray.setVisible(true);
		gray.setOpacity(0);
		Timeline oops = new Timeline(new KeyFrame(Duration.millis(200), (ee)-> {
			gray.setOpacity(gray.getOpacity()+0.1);
		}));
		
		oops.setCycleCount(6);
		oops.play();
		oops.setOnFinished(e->{
			liug.setVisible(true);
			liug.setText("流局");
			liug.setFont(Font.font("華康采風體W3",50));
			liug.setFill(Color.PURPLE);
			ShowNextRoundButton();
		});
	}
	else
	{
		nextone();
	
	playerlist[currentplayer].addCards(create.createmahjong(map.KeyAndNames.get(0))); //給下個玩家發牌
	map.KeyAndNames.remove(0); //牌庫刪掉最前面那個
	playerlist[currentplayer].setCardTypeNumber(setCardTypeList());
	
	System.out.println("我是從TheCheck()來的喔");
	printcards(); //先show出來不然我不知道

	if (currentplayer==0 || currentplayer==1) //如果b=0 也就是第4個玩家打完牌了 或是b=1 也就是第1個玩家打完牌了 就set button
	{
		setbuttonImage(playerlist[0], setCardTypeList(), setImageList_60x60());
	}

	RemainCardAmount.setText("餘" + String.valueOf(map.KeyAndNames.size()-14));
	

	
	if (playerlist[currentplayer].ZhiMo(playerlist[currentplayer].PlayerCards, setCardTypeList()) == true)
	{
		if (currentplayer==0)
		{
			ShowButtonBox();
			AddBtn_Zhimo();
			ShowBtn_Cancel();
			checkstatus++;
		}
		else
		{
			checkstatus++;
			Zhimo(playerlist[currentplayer]);
		}
	}
	
	//如果能夠立直
	if (!playerlist[currentplayer].RiChi && playerlist[currentplayer].RiChiable(setCardTypeList()))
	{
		if (currentplayer==0)
		{
			ShowButtonBox();
			AddBtn_Richi();
			ShowBtn_Cancel();
		}
		else if (playerlist[currentplayer].Zhimo==false)
		{
			RiChi(playerlist[currentplayer]);
		}
	}
	
	if (playerlist[currentplayer].self_gangable() == true)
	{
		//只讓自己槓 電腦不槓
		if (currentplayer==0)
		{
			ShowButtonBox();
			AddBtn_SelfGang();
			ShowBtn_Cancel();
			checkstatus++;
		}	
	}
	

	if (currentplayer==0) 
	{
		System.out.println("Currentplayer: " + currentplayer);
		btnList.get(btnList.size()-1).setVisible(true);
		enablebuttons();
		if (playerlist[currentplayer].RiChi && checkstatus==0)
		{ //如果立了
			disablebuttons();
			throwCardProcess(playerlist[currentplayer].PlayerCards.size()-1);
		}
	}
	else if (currentplayer==1 || currentplayer==2 || currentplayer==3)
		{
			if(checkstatus==0)
			{
				System.out.println("Currentplayer: " + currentplayer);
				BotThrowCard();
			}
		}
	}
}

public void Hu(Player player) {
	/*
	 * 胡牌的method (+按胡牌的method)
	 *1. 全部的Button都隱形 
	 *2. 要把ButtonBox的東西都刪了
	 *3. 幫自己的卡+grandriver最上面那一張 (判斷胡牌用)
	 *4. 如果是最後一張的話就是河底撈月
	 *5.算台
	 *6. show你贏了的button出來
	 */
	TingPaiBox.setVisible(false);
	player.PlayerCards.add(grandriver.peek());
	player.setCardTypeNumber(setCardTypeList());
	if (map.KeyAndNames.size()==14)
	{
		player.HeiDiLaoYu=true;
	}
	
	System.out.println(player.HuCardsStream);
	System.out.println(player.HuCardsTriplet);
	System.out.println(player.HuCardsPair[0]);
	
	//胡牌動畫
	AnchorPane.getChildren().add(HuImage);
	HuImage.setOpacity(0);
	
	Timeline showhu = new Timeline(new KeyFrame(Duration.millis(40),
			(ee)-> {
				setHuAndZhimoImage(HuImage, player);
			}
			));
	showhu.setCycleCount(50);
	showhu.play();
	showhu.setOnFinished(ee->{
		AnchorPane.getChildren().remove(HuImage);

		YakuCalc YakuCalc = new YakuCalc(player, DoraList, dora);
		
		YakuCalc.Calc();
		YakuCalc.printYaku();
		YakuCalc.getHan();
		
		if (player==playerlist[0])
		{
			RecentBigHu RBH = new RecentBigHu();
			
			RBH.setyakucalc(YakuCalc);
			RBH.setoutputstring();
			try {
				RBH.input();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (RBH.highesthan<=YakuCalc.han)
			{
				try {
					RBH.output();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		playerlist[currentplayer].PlayerPoints-=YakuCalc.getpoint();
		player.PlayerPoints+=YakuCalc.getpoint();
		ShowResult(player, YakuCalc);

	});
	
	
}


public void setrichipan() {
	if (!AnchorPane.getChildren().contains(richipan))
		AnchorPane.getChildren().add(richipan);
	if (!AnchorPane.getChildren().contains(richipan1))
		AnchorPane.getChildren().add(richipan1);
	if (!AnchorPane.getChildren().contains(richipan2))
		AnchorPane.getChildren().add(richipan2);
	if (!AnchorPane.getChildren().contains(richipan3))
		AnchorPane.getChildren().add(richipan3);
	
	
		richipan.setLayoutX(337.5);
		richipan.setLayoutY(375.5);
		richipan.setOpacity(0);
		
		richipan1.setLayoutX(419);
		richipan1.setLayoutY(294);
		richipan1.setRotate(-90);
		richipan1.setOpacity(0);
		
		richipan2.setLayoutX(337.5);
		richipan2.setLayoutY(375.5-163.5);
		richipan2.setOpacity(0);
		
		richipan3.setLayoutX(419-163.5);
		richipan3.setLayoutY(294);
		richipan3.setRotate(-90);
		richipan3.setOpacity(0);

	
}

public void showrichipan(ImageView richipan) {
	
Timeline showrichipan = new Timeline(new KeyFrame(Duration.millis(40),
		(e)-> {
			if (richipan.getOpacity()<1)
	richipan.setOpacity(richipan.getOpacity()+0.15);
}));
showrichipan.setCycleCount(10);
showrichipan.play();
//這裡放立直的動畫
Timeline showrichi = new Timeline(new KeyFrame(Duration.millis(40),
		(ee)-> {
			moveActionImage(RichiImage, playerlist[currentplayer]);
		}
		));
showrichi.setCycleCount(20);
showrichi.play();
showrichi.setOnFinished(e->{
	AnchorPane.getChildren().remove(RichiImage);

	
});
}

public void setActionImage(ImageView i, Player player)
{
	if (player==playerlist[0])
	{
		i.setLayoutX(250);
		i.setLayoutY(600);
	}
	else if (player==playerlist[1])
	{
		i.setLayoutX(800);
		i.setLayoutY(150);
	}
	else if (player==playerlist[2])
	{
		i.setLayoutX(250);
		i.setLayoutY(-200);
	}
	else if (player==playerlist[3])
	{
		i.setLayoutX(-200);
		i.setLayoutY(150);
	}
}

public void setHuAndZhimoImage(ImageView i, Player player)
{
	if (player==playerlist[0])
	{
		i.setLayoutX(250);
		i.setLayoutY(350);
	}
	else if (player==playerlist[1])
	{
		i.setLayoutX(550);
		i.setLayoutY(150);
	}
	else if (player==playerlist[2])
	{
		i.setLayoutX(250);
		i.setLayoutY(50);
	}
	else if (player==playerlist[3])
	{
		i.setLayoutX(50);
		i.setLayoutY(150);
	}
	
	if(i.getOpacity()<=1)
	{
		i.setOpacity(i.getOpacity()+0.15);
	}
}

public void moveActionImage(ImageView i, Player player) 
{
	if (player==playerlist[0])
	{
		if (i.getLayoutY()>=330)
		{
			i.setLayoutY(i.getLayoutY()-30);
		}
	}
	else if (player==playerlist[1])
	{
		if (i.getLayoutX()>=530)
		{
			i.setLayoutX(i.getLayoutX()-30);
		}
	}
	else if (player==playerlist[2])
	{
		if (i.getLayoutY()<=70)
		{
			i.setLayoutY(i.getLayoutY()+30);
		}
	}
	else if (player==playerlist[3])
	{
		if (i.getLayoutX()<=70)
		{
			i.setLayoutX(i.getLayoutX()+30);
		}
	}
}

public void Pong(Player player) {
	
	/*
	 * 碰牌的method
	 * 1. 碰牌的玩家的ChiPongGangCards要+3次 grandriver最上面的牌
	 * 2. 碰牌的玩家的PongCardsInOrder要加上碰的那張牌的Order 
	 * 3. 碰牌的玩家的卡要刪掉2個grandriver最上面的那張牌
	 * 4. 碰牌的玩家要把ChiPongGangBox更新
	 * 5.grandriver刪掉碰掉的牌
	 * 6.當前玩家（也就是打出這張牌的玩家）的river要刪掉打掉的這張牌
	 * 	6.1 然後更新river圖片
	 * 7.當前玩家變成碰牌的玩家
	 * 8.清除checkstatus
	 */
	AnchorPane.getChildren().add(this.PongImage);
	setActionImage(this.PongImage, player);
	
	Timeline showpong = new Timeline(new KeyFrame(Duration.millis(40),
			(ee)-> {
				moveActionImage(this.PongImage, player);
			}
			));
	showpong.setCycleCount(20);
	showpong.play();
	showpong.setOnFinished(ee->{
		AnchorPane.getChildren().remove(this.PongImage);
		player.ChiPongGangCards.add(grandriver.peek());
		player.ChiPongGangCards.add(grandriver.peek());
		player.ChiPongGangCards.add(grandriver.peek());
		

		int index=0;
		for (int i=0; i<player.PlayerCards.size(); i++)
		{
			if (grandriver.peek().getName().equals(player.PlayerCards.get(i).getName()))
			{
				index = i;
				break;
			}
		}
		player.PongCardsInOrder.add(player.PlayerCards.get(index).getcardOrder());
		player.PlayerCards.remove(index);
		player.PlayerCards.remove(index);

		setChiPongGangBoxImage(player, setCardTypeList(), setImageList_84x128());
		
		if (player==playerlist[0]) {
			enablebuttons();
		btnList.get(btnList.size()-2).setVisible(false);
		btnList.get(btnList.size()-3).setVisible(false);
		btnList.remove(btnList.size()-1);
		btnList.remove(btnList.size()-1);
		btnList.remove(btnList.size()-1);
		
		setbuttonImage(playerlist[0], setCardTypeList(), setImageList_60x60());
		}
		
		grandriver.pop();
		playerlist[currentplayer].river.pop();
		riverpanelist[currentplayer].getChildren().clear();
		setriverImage(playerlist[currentplayer], setCardTypeList(), setImageList(), riverpanelist);
		
		System.out.println("我是從Pong()來的喔");
		printcards();
		
		for (int i=0; i<playerlist.length; i++)
		{
			if (playerlist[i]==player)
				{
					currentplayer = i;
					break;
				}
		}
		

		checkstatus=0;
		
		if (currentplayer!=0)
		{
			BotThrowCard();
		}
	});
	
	
}

public void Zhimo(Player player) {
	TingPaiBox.setVisible(false);
	player.setCardTypeNumber(setCardTypeList());
	player.Zhimo=true;
	
	if (map.KeyAndNames.size()==14)
	{
		player.HaiDiLaoYue=true;
	}
	
	AnchorPane.getChildren().add(ZhimoImage);
	ZhimoImage.setOpacity(0);
	
	Timeline showzhimo = new Timeline(new KeyFrame(Duration.millis(40),
			(ee)-> {
				setHuAndZhimoImage(ZhimoImage, player);
			}
			));
	showzhimo.setCycleCount(50);
	showzhimo.play();
	showzhimo.setOnFinished(ee->{

		AnchorPane.getChildren().remove(ZhimoImage);
		YakuCalc YakuCalc = new YakuCalc(player, DoraList, dora);
		
		YakuCalc.Calc();
		YakuCalc.getHan();
		YakuCalc.printYaku();
		if (player==playerlist[0])
		{
			RecentBigHu RBH = new RecentBigHu();
			
			RBH.setyakucalc(YakuCalc);
			RBH.setoutputstring();
			try {
				RBH.input();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (RBH.highesthan<=YakuCalc.han)
			{
				try {
					RBH.output();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		playerlist[currentplayer].PlayerPoints-=YakuCalc.getpoint();
		player.PlayerPoints+=YakuCalc.getpoint();
		ShowResult(player, YakuCalc);
	});
}

public void ShowResult(Player player, YakuCalc YakuCalc) {

	setrichipan();
	gray.setVisible(true);
	gray.setOpacity(0.6);
	CountScorePane.setVisible(true);
	ShowPlayerCardsBox(player);
	ShowPlayerChiPongGangBox(player);
	ShowTheLastBox(player);
	ShowDoraBox2();
	ShowUraDora(player);
	ShowCalculateScoreBox(YakuCalc);
}

public void ShowPlayerCardsBox(Player player)
{
	for (int i=0; i<player.PlayerCards.size()-1; i++)
	{
		for (int j=0; j<setImageList_84x128().size(); j++)
		{
			if (player.PlayerCards.get(i).getName().equals(setCardTypeList()[j]))
				{
					PlayerCardBox.getChildren().add(new ImageView(setImageList_84x128().get(j)));
					break;
				}
		}
	}
}

public void ShowPlayerChiPongGangBox(Player player) {
	for (int i=0; i<player.ChiPongGangCards.size(); i++)
	{
		for (int j=0; j<setImageList_84x128().size(); j++)
		{
			if (player.ChiPongGangCards.get(i).getName().equals(setCardTypeList()[j]))
				{
					PlayerChiPongGangBox.getChildren().add(new ImageView(setImageList_84x128().get(j)));
					break;
				}
		}
	}
}

public void ShowTheLastBox(Player player) {
	for (int j=0; j<setImageList_84x128().size(); j++)
	{
		if (player.PlayerCards.get(player.PlayerCards.size()-1).getName().equals(setCardTypeList()[j]))
			{
				TheLastBox.getChildren().add(new ImageView(setImageList_84x128().get(j)));
				break;
			}
	}
}

public void ShowDoraBox2() {
	for (int i=0; i<this.dora; i++)
	{
		DoraBox2.getChildren().add(new ImageView(setImageList_84x128().get(this.DoraList.get(2*i).getcardOrder())));
	}
	
	for (int i=this.dora; i<5; i++)
	{
		DoraBox2.getChildren().add(new ImageView(setImageList_84x128().get(34)));
	}
}

public void ShowUraDora(Player player) {
	if (player.RiChi)
	{
	for (int i=0; i<this.dora; i++)
	{
		UraDoraBox.getChildren().add(new ImageView(setImageList_84x128().get(this.DoraList.get(2*i+1).getcardOrder())));
	}
	
	for (int i=this.dora; i<5; i++)
	{
		UraDoraBox.getChildren().add(new ImageView(setImageList_84x128().get(34)));
	}
	}
	
	else
	{
		for (int i=0; i<5; i++)
		{
			UraDoraBox.getChildren().add(new ImageView(setImageList_84x128().get(34)));
		}
	}
}

public void ShowCalculateScoreBox(YakuCalc YakuCalc) {
	
	Timeline showyaku = new Timeline(new KeyFrame(Duration.millis(800), (ee)-> {
		
		if (YakuCalc.Yaku.size()!=0)
		{
		Text t = new Text(YakuCalc.Yaku.get(YakuCalc.index));
		t.setFont(Font.font("華康采風體W3", 25));
		Text tt = new Text(YakuCalc.HanList.get(YakuCalc.index));
		tt.setFont(Font.font("華康采風體W3", 25));
		AnchorPane.getChildren().addAll(t,tt);
		YakuBox.getChildren().add(t);
		HanListBox.getChildren().add(tt);
		YakuCalc.addindex();
		}
	}));
	
	showyaku.setCycleCount(YakuCalc.Yaku.size());
	showyaku.play();
	
	showyaku.setOnFinished(e->{
		Timeline showtotalbox = new Timeline(new KeyFrame(Duration.millis(800),(ee)->{

				Text t = new Text(YakuCalc.han + "番");
				t.setFont(Font.font("華康采風體W3",40));
				
				TotalBox.getChildren().add(t);
		}));
		showtotalbox.setCycleCount(1);
		showtotalbox.play();
		showtotalbox.setOnFinished(ee->{
			Timeline showtotalpointbox = new Timeline(new KeyFrame(Duration.millis(800),(eee)->{

				Text t = new Text(String.valueOf(YakuCalc.getpoint()));
				t.setFont(Font.font("華康采風體W3",60));
				
				TotalPointBox.getChildren().add(t);
		}));
		showtotalpointbox.setCycleCount(1);
		showtotalpointbox.play();
		showtotalpointbox.setOnFinished(eeee->{
			ShowNextRoundButton();
		});
			
		});

		

	});
}
public ArrayList<Pair<String, String>> getChiOption(Player player) {
	ArrayList<Pair<String, String>> ChiOption = new ArrayList();
	int Case = player.chiable(grandriver.peek(), setCardTypeList());
	
	if (Case==1) //1萬 1條 1筒
		ChiOption.add(new Pair<>(setCardTypeList()[grandriver.peek().getcardOrder()+1], setCardTypeList()[grandriver.peek().getcardOrder()+2]));
	else if (Case==2) //9萬 9條 9筒
		ChiOption.add(new Pair<>(setCardTypeList()[grandriver.peek().getcardOrder()-2], setCardTypeList()[grandriver.peek().getcardOrder()-1]));
	else if (Case==3) //2萬 2條 2筒
	{
		player.setCardTypeNumber(setCardTypeList());
		if (player.CardTypeNumber[grandriver.peek().getcardOrder()-1] >=1 && player.CardTypeNumber[grandriver.peek().getcardOrder()+1] >=1)
		{
			ChiOption.add(new Pair<>(setCardTypeList()[grandriver.peek().getcardOrder()-1], setCardTypeList()[grandriver.peek().getcardOrder()+1]));
		}
		
		if (player.CardTypeNumber[grandriver.peek().getcardOrder()+1] >=1 && player.CardTypeNumber[grandriver.peek().getcardOrder()+2] >=1)
		{
			ChiOption.add(new Pair<>(setCardTypeList()[grandriver.peek().getcardOrder()+1], setCardTypeList()[grandriver.peek().getcardOrder()+2]));
		}
	}
	else if (Case==4) //8萬 8條 8筒
	{
		player.setCardTypeNumber(setCardTypeList());
		if (player.CardTypeNumber[grandriver.peek().getcardOrder()-1] >=1 && player.CardTypeNumber[grandriver.peek().getcardOrder()-2] >=1)
		{
			ChiOption.add(new Pair<>(setCardTypeList()[grandriver.peek().getcardOrder()-2], setCardTypeList()[grandriver.peek().getcardOrder()-1]));
		}
		
		if (player.CardTypeNumber[grandriver.peek().getcardOrder()-1] >=1 && player.CardTypeNumber[grandriver.peek().getcardOrder()+1] >=1)
		{
			ChiOption.add(new Pair<>(setCardTypeList()[grandriver.peek().getcardOrder()-1], setCardTypeList()[grandriver.peek().getcardOrder()+1]));
		}
		

	}
	else if (Case==5) //3~7萬筒條
	{
		player.setCardTypeNumber(setCardTypeList());
		if (player.CardTypeNumber[grandriver.peek().getcardOrder()-1] >=1 && player.CardTypeNumber[grandriver.peek().getcardOrder()-2] >=1)
		{
			ChiOption.add(new Pair<>(setCardTypeList()[grandriver.peek().getcardOrder()-2], setCardTypeList()[grandriver.peek().getcardOrder()-1]));
		}
		
	
		if (player.CardTypeNumber[grandriver.peek().getcardOrder()-1] >=1 && player.CardTypeNumber[grandriver.peek().getcardOrder()+1] >=1)
		{
			ChiOption.add(new Pair<>(setCardTypeList()[grandriver.peek().getcardOrder()-1], setCardTypeList()[grandriver.peek().getcardOrder()+1]));
		}
		

		if (player.CardTypeNumber[grandriver.peek().getcardOrder()+1] >=1 && player.CardTypeNumber[grandriver.peek().getcardOrder()+2] >=1)
		{
			ChiOption.add(new Pair<>(setCardTypeList()[grandriver.peek().getcardOrder()+1], setCardTypeList()[grandriver.peek().getcardOrder()+2]));
		}
	}
	
	return ChiOption;
}

public void Chi_GetKeyAndValue(ArrayList<Pair<String, String>> ChiOption, int KeyIndex, Player player)
{
	/*
	 * 這裡基本上是把傳入的player(也就是要吃的那個人)的ChiPongGangCards和PlayerCards
	 * 以及ChiCardsInOrder做更改
	 * 
	 * 總之先找到第一張牌 -> ChiPongGangCards add -> PlayerCards Remove
	 * ->找到第二張牌 -> ChiPongGangCards add -> PlayerCards Remove
	 * ->ChiPongGangCards add (grandriver.peek()) 也就是加河最頂端的那一張
	 * 
	 * ChiCardsInOrder add 總之是你剛剛家的三張裡面最小的cardOrder的那一張的cardOrder
	 * 然後重設吃牌玩家的ChiPongGangImage
	 * 
	 * grandriver pop
	 * 丟牌的人的河pop + reset Image
	 */

	ChiPane.setVisible(false);
	ChiPane.getChildren().clear();
	AnchorPane.getChildren().add(ChiImage);
	setActionImage(ChiImage, player);
	Timeline showchi = new Timeline(new KeyFrame(Duration.millis(40),
			(ee)-> {
				moveActionImage(ChiImage, player);
			}
			));
	showchi.setCycleCount(20);
	showchi.play();
	showchi.setOnFinished(ee->{
		AnchorPane.getChildren().remove(ChiImage);
		
		int index1=-1;
		int index2=-1;
		for (int i=0; i<player.PlayerCards.size(); i++)
		{
			if (ChiOption.get(KeyIndex).getKey().equals(player.PlayerCards.get(i).getName()))
			{
				index1 = i;
				break;
			}
		}
		player.ChiPongGangCards.add(player.PlayerCards.get(index1));
		player.PlayerCards.remove(index1);

		for (int i=0; i<player.PlayerCards.size(); i++)
		{
			if (ChiOption.get(KeyIndex).getValue().equals(player.PlayerCards.get(i).getName()))
			{
				index2 = i;
				break;
			}
		}
		
		player.ChiPongGangCards.add(player.PlayerCards.get(index2));
		player.PlayerCards.remove(index2);
		

		player.ChiPongGangCards.add(grandriver.peek());
		
		player.ChiCardsInOrder.add(Math.min
				(player.ChiPongGangCards.get(player.ChiPongGangCards.size()-1).getcardOrder(), 
						Math.min(player.ChiPongGangCards.get(player.ChiPongGangCards.size()-2).getcardOrder(),
								player.ChiPongGangCards.get(player.ChiPongGangCards.size()-3).getcardOrder())
				));
		
		setChiPongGangBoxImage(player, setCardTypeList(), setImageList_84x128());

		if (player==playerlist[0]) {
			enablebuttons();
		btnList.get(btnList.size()-2).setVisible(false);
		btnList.get(btnList.size()-3).setVisible(false);
		
		btnList.remove(btnList.size()-1);
		btnList.remove(btnList.size()-1);
		btnList.remove(btnList.size()-1);
		
		setbuttonImage(player, setCardTypeList(), setImageList_60x60());
		}
		
		player.setCardTypeNumber(setCardTypeList());
		grandriver.pop();
		playerlist[currentplayer].river.pop();
		riverpanelist[currentplayer].getChildren().clear();
		setriverImage(playerlist[currentplayer], setCardTypeList(), setImageList(), riverpanelist);
		
		System.out.println("我是從Chi_GetKeyAndValue()來的喔");
		printcards();
		for (int i=0; i<playerlist.length; i++)
		{
			if (playerlist[i]==player)
				{
					currentplayer = i;
					break;
				}
		}
		

		checkstatus=0;
		if (currentplayer!=0)
		{
			BotThrowCard();
		}
	});
	
	
}

public void Gang(Player player) {
	
	
	Timeline showgang = new Timeline(new KeyFrame(Duration.millis(1),
			(ee)-> {
				
			}
			));
	showgang.setCycleCount(800);
	showgang.play();
	showgang.setOnFinished(ee->{
		dora++;
		setDoraImage();
		player.ChiPongGangCards.add(grandriver.peek());
		player.ChiPongGangCards.add(grandriver.peek());
		player.ChiPongGangCards.add(grandriver.peek());
		player.ChiPongGangCards.add(grandriver.peek());
		setChiPongGangBoxImage(player, setCardTypeList(), setImageList_84x128());

		int index=0;
		for (int i=0; i<player.PlayerCards.size(); i++)
		{
			if (grandriver.peek().getName().equals(player.PlayerCards.get(i).getName()))
			{
				index = i;
				break;
			}
		}
		player.GangCardsInOrder.add(player.PlayerCards.get(index).getcardOrder());

		player.PlayerCards.remove(index);
		player.PlayerCards.remove(index);
		player.PlayerCards.remove(index);
		grandriver.pop();
		playerlist[currentplayer].river.pop();
		riverpanelist[currentplayer].getChildren().clear();
		setriverImage(playerlist[currentplayer], setCardTypeList(), setImageList(), riverpanelist);
		
		if(player==playerlist[0])
		{
			btnList.get(btnList.size()-2).setVisible(false);
			btnList.get(btnList.size()-3).setVisible(false);
			btnList.get(btnList.size()-4).setVisible(false);
			
			btnList.remove(btnList.size()-1);
			btnList.remove(btnList.size()-1);
			btnList.remove(btnList.size()-1);
			
			setbuttonImage(playerlist[0], setCardTypeList(), setImageList_60x60());
			btnList.get(btnList.size()-1).setVisible(true);
		}
		
		for (int i=0; i<playerlist.length; i++)
		{
			if (playerlist[i]==player)
				{
					currentplayer = i;
					break;
				}
		}
		
		checkstatus = 0;
		

		GiveCardToNextOneGangVersion();
	});
}

public ArrayList<Integer> getGangOptionList(Player player){
	ArrayList<Integer> GangOption = new ArrayList();
	player.setCardTypeNumber(setCardTypeList());


	
	for (int i=0; i<34; i++)
	{
		if (player.CardTypeNumber[i]==4)
		{
			GangOption.add(i);
		}
	}
	
	return GangOption;
}

public void GetGangOption(ArrayList<Integer> GangOption, int index, Player player)
{
	
	HideButtonBox();
	ClearButtonBox();
	HideBtn_Cancel();
	
	ChiPane.setVisible(false);
	ChiPane.getChildren().clear();
	AnchorPane.getChildren().add(GangImage);
	setActionImage(GangImage, player);
	Timeline showselfgang = new Timeline(new KeyFrame(Duration.millis(1),
			(ee)-> {
				moveActionImage(GangImage, player);
			}
			));
	showselfgang.setCycleCount(800);
	showselfgang.play();
	showselfgang.setOnFinished(ee->{
		dora++;
		setDoraImage();
		AnchorPane.getChildren().remove(GangImage);
		
		/*
		 * 暗槓的部分
		 * 槓的人先sortCards
		 * 然後把槓的牌+2個進去ChiPongGangCards +2個暗槓牌
		 * PlayerCards remove 4個
		 * ChiPongGangBox要reset image
		 */
		player.sortCards();
		for (int i=0; i<player.PlayerCards.size(); i++)
		{
			if (player.PlayerCards.get(i).getcardOrder() == GangOption.get(index))
			{
				mahjong facedown = new mahjong();
				facedown.name="暗槓";
				player.ChiPongGangCards.add(player.PlayerCards.get(i));
				player.ChiPongGangCards.add(facedown);
				player.ChiPongGangCards.add(facedown);
				player.ChiPongGangCards.add(player.PlayerCards.get(i));
				player.SelfGangCardsInOrder.add(player.PlayerCards.get(i).getcardOrder());
				player.PlayerCards.remove(i);
				player.PlayerCards.remove(i);
				player.PlayerCards.remove(i);
				player.PlayerCards.remove(i);
				break;
			}
		}
		
		if (player==playerlist[0]) {
			
		btnList.get(btnList.size()-1).setVisible(false);
		btnList.get(btnList.size()-2).setVisible(false);
		btnList.get(btnList.size()-3).setVisible(false);
		btnList.get(btnList.size()-4).setVisible(false);
		
		btnList.remove(btnList.size()-1);
		btnList.remove(btnList.size()-1);
		btnList.remove(btnList.size()-1);
		}
		
		
		checkstatus = 0;
		
		
		setChiPongGangBoxImage(player, setCardTypeList(), setImageList_84x128());
//		黑瑞峰
//		我想要洗澡
//		可是Scott洗不完
//		你可以到外面喜
//		有道理
//		可是好麻煩
//		嘿文龍
//		嘿
//		我原本要打遠
//		然後發現這裡更遠
//		exactly!
//		\partial u/
		playerlist[currentplayer].sortCards();
		GiveCardToNextOneGangVersion();
	});
}

public void GiveCardToNextOneGangVersion() {
	playerlist[currentplayer].addCards(create.createmahjong(map.KeyAndNames.get(map.KeyAndNames.size()-1))); //給下個玩家從後面數來那張牌
	map.KeyAndNames.remove(map.KeyAndNames.size()-1); //牌庫刪掉最前面那個
	playerlist[currentplayer].setCardTypeNumber(setCardTypeList());
	
	System.out.println("我是從GetGangOption()來的喔");
	printcards(); //先show出來不然我不知道
	
	if (currentplayer==0) {
		if (!playerlist[currentplayer].RiChi)
		enablebuttons();
	btnList.get(btnList.size()-1).setVisible(true);
	setbuttonImage(playerlist[0], setCardTypeList(), setImageList_60x60());
	}
	
	RemainCardAmount.setText("餘" + String.valueOf(map.KeyAndNames.size()-14));
	

	
	//先判斷自摸

		if (playerlist[currentplayer].ZhiMo(playerlist[currentplayer].PlayerCards, setCardTypeList()) == true)

		{
			playerlist[currentplayer].RinShang = true;
			if (currentplayer==0)
			{
				ShowButtonBox();
				AddBtn_Zhimo();
				ShowBtn_Cancel();
				checkstatus++;
			}
			else
			{
				Zhimo(playerlist[currentplayer]);
			}
		}
	
	System.out.println("現在能立直了嗎: " + playerlist[currentplayer].RiChiable(setCardTypeList()));
	
	if (!playerlist[currentplayer].RiChi && playerlist[currentplayer].RiChiable(setCardTypeList()))
	{
		if (currentplayer==0)
		{
			ShowButtonBox();
			AddBtn_Richi();
			ShowBtn_Cancel();
		}
		else if (playerlist[currentplayer].Zhimo==false)
		{
			RiChi(playerlist[currentplayer]);
		}
	
	}	
	
	if (playerlist[currentplayer].self_gangable() == true)
	{
		if (currentplayer==0)
		{
			ShowButtonBox();
			AddBtn_SelfGang();
			ShowBtn_Cancel();
			checkstatus++;
		}	
	}
	
		
	if (currentplayer==0) 
	{
		enablebuttons();
		System.out.println("Currentplayer: " + currentplayer);
		btnList.get(btnList.size()-1).setVisible(true);
		if (playerlist[currentplayer].RiChi && checkstatus==0)
		{
			throwCardProcess(playerlist[currentplayer].PlayerCards.size()-1);
		}
	}
	else if (currentplayer==1 || currentplayer==2 || currentplayer==3)
		{
			if (checkstatus==0)
			{
				System.out.println("Currentplayer: " + currentplayer);
				BotThrowCard();
			}
		}
	}


}