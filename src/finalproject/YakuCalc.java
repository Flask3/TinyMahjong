package finalproject;

import java.util.ArrayList;
import java.util.Collections;

public class YakuCalc {
	
	Player player;
	int OneNineAmount=0;
	ArrayList<String> Yaku = new ArrayList();
	ArrayList<String> HanList = new ArrayList();
	ArrayList<mahjong> doraList = new ArrayList();
	int han = 0;
	int index = 0;
	int point = 0;
	int dora = 0;
	int doraamount = 0;
	int uradoraamount = 0;
	YakuCalc(Player player1, ArrayList<mahjong> doraList, int dora){
		this.player=player1;
		this.doraList=doraList;
		this.dora=dora;
		Yaku.clear();
		han=0;
		doraamount = 0;
		uradoraamount=0;
	}
	
	public void dora() {
		for (int i=0; i<dora; i++)
		{
			System.out.print(doraList.get(2*i).getName() + " ");
			
			for (int j=0; j<player.PlayerCards.size(); j++) 
			{
				if (doraList.get(2*i).getcardOrder()==34)
				{
					if (player.PlayerCards.get(j).getcardOrder()==0)
					{
						doraamount++;
					}
				}
				else
				{
					if (player.PlayerCards.get(j).getcardOrder()==doraList.get(2*i).getcardOrder()+1)
					{
						doraamount++;
					}
				}
			}
			for (int j=0; j<player.ChiPongGangCards.size(); j++) 
			{
				if (doraList.get(2*i).getcardOrder()==34)
				{
					if (player.ChiPongGangCards.get(j).getcardOrder()==0)
					{
						doraamount++;
					}
				}
				else
				{
					if (player.ChiPongGangCards.get(j).getcardOrder()==doraList.get(2*i).getcardOrder()+1)
					{
						doraamount++;
					}
				}
			}
		}
		
		if (doraamount!=0) {
			Yaku.add("寶牌");
			HanList.add(doraamount + "番");
			han+=doraamount;
		}
		
	}
	
	public void uradora() {
		if (player.RiChi)
		{
			for (int i=0; i<dora; i++)
			{
				System.out.print(doraList.get(2*i+1).getName() + " ");
				if (doraList.get(2*i).getcardOrder()==34)
				{
				for (int j=0; j<player.PlayerCards.size(); j++) 
				{
					if (player.PlayerCards.get(j).getcardOrder()==0)
					{
						uradoraamount++;
					}
				}
				}
				else
				{
					for (int j=0; j<player.PlayerCards.size(); j++) 
					{
						if (player.PlayerCards.get(j).getcardOrder()==doraList.get(2*i+1).getcardOrder()+1)
						{
							uradoraamount++;
						}
					}
				}
				
					if (doraList.get(2*i).getcardOrder()==34)
					{
					for (int j=0; j<player.ChiPongGangCards.size(); j++) 
					{
						if (player.ChiPongGangCards.get(j).getcardOrder()==0)
						{
							uradoraamount++;
						}
					}
					}
					else
					{
						for (int j=0; j<player.ChiPongGangCards.size(); j++) 
						{
							if (player.ChiPongGangCards.get(j).getcardOrder()==doraList.get(2*i+1).getcardOrder()+1)
							{
								uradoraamount++;
							}
						}
					}
			}
		}
		if (uradoraamount!=0) {
			Yaku.add("裏寶牌");
			han+=uradoraamount;
			HanList.add(uradoraamount + "番");
		}
	}
	
	public void ZhungJia() {
		if (player.Zhuang)
		{
			Yaku.add("莊家");
			han++;
			HanList.add("1番");
		}
	}
	public int getpoint() {
		point = 1000*(han+1);
		return point;
	}
	
	public void Calc() {
		if (!GokuShiMuSou())
		{
		NoOneNine();  //斷么九
		SevenPairs(); //七對子
		MenSenZhiMo(); //門前清自摸和
		YiBeiKou_and_ErBeiKou(); //一杯口&二杯口
		SanYenPai(); //三元牌 (中發白)
		HaiDiLaoYueAndHeiDiLaoYu(); //海底撈月 & 河底撈魚
		SanSokuSameStream(); //三色同順
		SanSokuSameTriplet(); //三色同刻
		YiChiTongGuang(); //一氣通貫
		DaiDai(); //對對和
		SanAnKotsu(); //三暗刻
		SanGang(); //三槓子
		ChuanDaiOneNine(); //純全帶么九 & 混全帶么九
		ThreeYuan(); //小三仙 & 大三仙
		LaoTou(); //混老頭 & 清老頭
		SameColor(); //清一色 & 混一色 & 字一色 &綠一色
		FourAnKotsu(); //四暗刻
		FourShi(); //小四喜 & 大四喜
		FourGang(); //四槓子
		RiChi();
		dora();
		uradora();
		ComputerWins();

		}
		else
		{
			ComputerWins();
			Yaku.add("國士無雙");
			HanList.add("12番");
			han+=12;
		}
		
		System.out.print("\n ChiCardsInOrder: ");
		System.out.println(player.ChiCardsInOrder);		
		System.out.print("PongCardsInOrder: ");
		System.out.println(player.PongCardsInOrder);
		System.out.print("GangCardsInOrder: ");
		System.out.println(player.GangCardsInOrder);
		System.out.print("SelfGangCardsInOrder: ");
		System.out.println(player.SelfGangCardsInOrder);
		System.out.print("HuCardsStream: ");
		System.out.println(player.HuCardsStream);
		System.out.print("HuCardsTriplet: ");
		System.out.println(player.HuCardsTriplet);
		System.out.print("Pair: ");
		System.out.println(player.HuCardsPair[0]);
	}
	
	public void getHan() {
		System.out.print(han + "番");
	}
	
	public void RiChi() {
		//立直 1翻
		if (player.RiChi)
		{
			Yaku.add("立直");
			HanList.add("1番");
			han++;
		}
	}

	public boolean GokuShiMuSou() {
		int yea=0;
		int yea1=0;
		for (int i=0; i<player.CardTypeNumber.length;i++)
		{
			if (i==0 || i==8 || i==9 || i==17 || i==18 || i==26 || 
				i==27 || i==28 || i==29 || i==30 || i==31 || i==32 || i==33)
			{
				if (player.CardTypeNumber[i]>=1) yea++;
				if (player.CardTypeNumber[i]>=2) yea1++;
			}
			else if (player.CardTypeNumber[i]==0) yea++;
		}
		if (yea==34 && yea1==1) 
			{
			return true;
			}
		else return false;
		

	}
	
	
	public void NoOneNine() {
		//斷么九 1翻
		for (int i=0; i<player.CardTypeNumber.length; i++)
		{
			if (i==0 || i==8 || i==9 || i==17 || i==18 || i==26 || 
				i==27 || i==28 || i==29 || i==30 || i==31 || i==32 || i==33)
			{
				if (player.CardTypeNumber[i]!=0)
					OneNineAmount++;
			}
		}
		
		for (int i=0; i<player.ChiPongGangCards.size(); i++)
		{
			int k = player.ChiPongGangCards.get(i).getcardOrder();
			if (k==0 || k==8 || k==9 || k==17 || k==18 || k==26 || 
					k==27 || k==28 || k==29 || k==30 || k==31 || k==32 || k==33)
			{
				OneNineAmount++;
			}
		}
		
		if (OneNineAmount==0)
		{
			Yaku.add("斷么九");
			HanList.add("1番");
			han++;
		}
	}
	
	public boolean CheckMenSen() {
		// 檢查門前清
		if (player.ChiPongGangCards.size()==0)
			return true;
		else if (player.ChiPongGangCards.size()%4 == 0 && player.ChiPongGangCards.size()/4 == player.SelfGangCardsInOrder.size())
			return true;
		else return false;
	}
	
	public boolean CheckSevenPairs() {
		// 檢查七對子
		int PairAmount = 0;
		for (int i=0; i<player.CardTypeNumber.length; i++)
		{
			if (player.CardTypeNumber[i]==2)
			{
				PairAmount++;
			}
		}
		
		
		if (PairAmount==7)
			{
			return true;
			}
		else
			return false;
	}
	
	public void SevenPairs() {
		//七對子 2翻
		int pairsamount=0;
		for (int i=0; i<player.CardTypeNumber.length; i++)
		{
			if (player.CardTypeNumber[i]==2) pairsamount++;
		}
		
		if (pairsamount==7) 
			{
				Yaku.add("七對子");
				HanList.add("2番");
				han+=2;
			}
	}
	
	public void MenSenZhiMo() {
		//門前清自摸和 1翻
		if (CheckMenSen()==true && player.Zhimo==true)
		{
			Yaku.add("門前清自摸和");
			HanList.add("1番");
			han++;
		}
	}
	
	public void PingHu() {
		//平胡 1翻
		int DaZhiAmount = 0;
		for (int i=27; i<player.CardTypeNumber.length; i++)
		{
			if (player.CardTypeNumber[i]>0)
				DaZhiAmount++;
		}
		if (player.HuCardsTriplet.size()==0 && DaZhiAmount==0 && CheckMenSen()==true)
		{
			Yaku.add("平胡");
			HanList.add("1番");
			han++;
		}
	}
	
	public void YiBeiKou_and_ErBeiKou() {
		//一杯口 1翻
		//二杯口 3翻
		int BeiKouAmount=0;
		for (int i=0; i<player.HuCardsStream.size()-1; i++)
		{
			if (player.HuCardsStream.get(i) == player.HuCardsStream.get(i+1))
			{
				BeiKouAmount++;
			}
		}
		
		if (BeiKouAmount==1)
		{
			Yaku.add("一杯口");
			HanList.add("1番");
			han++;
		}
		else if (BeiKouAmount==2)
		{
			Yaku.add("二杯口");
			HanList.add("3番");
			han+=3;
		}
	}
	public void SanYenPai() {
		//東南西北中發白 各1翻

		if (player.HuCardsTriplet.contains(27) || player.PongCardsInOrder.contains(27)|| player.GangCardsInOrder.contains(27) || player.SelfGangCardsInOrder.contains(27))
		{
			Yaku.add("字牌東");
			HanList.add("1番");
			han++;
		}
		if (player.HuCardsTriplet.contains(28) || player.PongCardsInOrder.contains(28) || player.GangCardsInOrder.contains(28) || player.SelfGangCardsInOrder.contains(28))
		{
			Yaku.add("字牌南");
			HanList.add("1番");
			han++;
		}
		if (player.HuCardsTriplet.contains(29) || player.PongCardsInOrder.contains(29)|| player.GangCardsInOrder.contains(29) || player.SelfGangCardsInOrder.contains(29))
		{
			Yaku.add("字牌西");
			HanList.add("1番");
			han++;
		}
		if (player.HuCardsTriplet.contains(30) || player.PongCardsInOrder.contains(30)|| player.GangCardsInOrder.contains(30) || player.SelfGangCardsInOrder.contains(30))
		{
			Yaku.add("字牌北");
			HanList.add("1番");
			han++;
		}
		if (player.HuCardsTriplet.contains(31) || player.PongCardsInOrder.contains(31)|| player.GangCardsInOrder.contains(31) || player.SelfGangCardsInOrder.contains(31))
		{
			Yaku.add("風牌中");
			HanList.add("1番");
			han++;
		}
		if (player.HuCardsTriplet.contains(32) || player.PongCardsInOrder.contains(32) || player.GangCardsInOrder.contains(32) || player.SelfGangCardsInOrder.contains(32))
		{
			Yaku.add("風牌發");
			HanList.add("1番");
			han++;
		}
		if (player.HuCardsTriplet.contains(33) || player.PongCardsInOrder.contains(33)|| player.GangCardsInOrder.contains(33) || player.SelfGangCardsInOrder.contains(33))
		{
			Yaku.add("風牌白");
			HanList.add("1番");
			han++;
		}
	}
	
	public void RinShangKaiHua() {
		//嶺上開花 1翻
		if (player.RinShang==true && player.Zhimo==true)
		{
			Yaku.add("嶺上開花");
			HanList.add("1番");
			han++;
		}
	}
	
	public void HaiDiLaoYueAndHeiDiLaoYu() {
		//海底撈月 1翻
		//河底撈魚 1翻
		if (player.HaiDiLaoYue==true)
		{
			Yaku.add("海底撈月");
			HanList.add("1番");
			han++;
		}
		else if (player.HeiDiLaoYu==true)
		{
			Yaku.add("河底撈魚");
			HanList.add("1番");
			han++;
		}
	}
	
	public void SanSokuSameStream()
	{
		//3色同順 2翻 副露-1翻
		ArrayList<Integer> Combined = new ArrayList<Integer>();
		for (int i=0; i<player.HuCardsStream.size(); i++)
		{
			Combined.add(player.HuCardsStream.get(i));
		}
		
		for (int i=0; i<player.ChiCardsInOrder.size(); i++)
		{
			Combined.add(player.ChiCardsInOrder.get(i));
		}
		
		for (int i=0; i<7; i++)
		{
			int SameStreamAmount = 0;
			for (int j=i; j<24; j=j+9)
			{
				for (int k=0; k<Combined.size(); k++)
				{
					if (Combined.get(k)==j)
						SameStreamAmount++;
				}
				if (SameStreamAmount==3)
				{
					Yaku.add("三色同順");
					if (CheckMenSen()==false)
						{
							han++;
							HanList.add("1番");
						}
					else
						{
							han+=2;
							HanList.add("2番");
						}
					break;
				}
			}
		}
	}
	
	public void SanSokuSameTriplet()
	{
		//3色同刻 2翻
		
		ArrayList<Integer> Combined = new ArrayList<Integer>();
		for (int i=0; i<player.HuCardsTriplet.size(); i++)
		{
			Combined.add(player.HuCardsTriplet.get(i));
		}
		
		for (int i=0; i<player.PongCardsInOrder.size(); i++)
		{
			Combined.add(player.PongCardsInOrder.get(i));
		}
		
		
		for (int i=0; i<9; i++)
		{
			int SameTripletAmount = 0;
			for (int j=i; j<24; j=j+9)
			{
				for (int k=0; k<Combined.size(); k++)
				{
					if (Combined.get(k)==j)
						SameTripletAmount++;
				}
				if (SameTripletAmount==3)
				{
					Yaku.add("三色同刻");
					han+=2;
					HanList.add("2番");
					break;
				}
			}
		}
	}
	
	public void YiChiTongGuang() {
		//一氣通貫 2翻  副露-1翻
		ArrayList<Integer> Combined = new ArrayList<Integer>();

		for (int i=0; i<player.HuCardsStream.size(); i++)
		{
			Combined.add(player.HuCardsStream.get(i));
		}
		
		for (int i=0; i<player.ChiCardsInOrder.size(); i++)
		{
			Combined.add(player.ChiCardsInOrder.get(i));
		}
		Combined.add(-1);
		
		
		for (int i=0; i<3; i++)
		{
			int check = 0;
			for (int j=0; j<Combined.size()-1; j++)
			{
				if (Combined.get(j) == Combined.get(j+1)) continue;
				if (Combined.get(j)==9*i || Combined.get(j)==9*i + 3 || Combined.get(j) == 9*i + 6)
				{
					check++;
				}
			}
			if (check==3)
			{
				Yaku.add("一氣通貫");
				if (CheckMenSen()==false)
				{
					han++;
					HanList.add("1番");
				}
				else
				{
					han+=2;
					HanList.add("2番");
				}
			}
		}
	}
	
	
	public void DaiDai()
	{
		//對對和 2翻
		if (!CheckSevenPairs())
		{
			if (player.HuCardsStream.size()==0 && player.ChiCardsInOrder.size()==0)
			{
				Yaku.add("對對和");
				HanList.add("2番");
				han+=2;
			}
		}
	}
	
	public void SanAnKotsu() {
		//三暗刻 2翻
		if (player.HuCardsTriplet.size()==3 || player.HuCardsTriplet.size()+player.SelfGangCardsInOrder.size()==3)
		{
			Yaku.add("三暗刻");
			HanList.add("2番");
			han+=2;
		}
	}
	
	public void SanGang() {
		//三槓子 2翻
		if (player.GangCardsInOrder.size()+player.SelfGangCardsInOrder.size()==3)
		{
			Yaku.add("三槓子");
			HanList.add("2番");
			han+=2;
		}
	}
	
	public void ChuanDaiOneNine() {
		//混全帶么九 2翻 副露-1翻
		//純全帶么九 3翻 副露-2翻
		ArrayList<Integer> NotOneNine=new ArrayList<Integer>();
		
		
		if (!CheckSevenPairs())
		{
		if (player.HuCardsPair[0]!=0 &&
				player.HuCardsPair[0]!=8 &&
				player.HuCardsPair[0]!=9 &&
				player.HuCardsPair[0]!=17 &&
				player.HuCardsPair[0]!=18 &&
				player.HuCardsPair[0]!=26 )
		{
			if (player.HuCardsPair[0]!=27 &&
					player.HuCardsPair[0]!=28 &&
					player.HuCardsPair[0]!=29 &&
					player.HuCardsPair[0]!=30 &&
					player.HuCardsPair[0]!=31 &&
					player.HuCardsPair[0]!=32 &&
					player.HuCardsPair[0]!=33)
						NotOneNine.add(1);
			else NotOneNine.add(2);
					
		}
		for (int i=0; i<player.HuCardsStream.size(); i++)
		{
			if (player.HuCardsStream.get(i)!=0 &&
				player.HuCardsStream.get(i)!=6 &&
				player.HuCardsStream.get(i)!=9 &&
				player.HuCardsStream.get(i)!=15 &&
				player.HuCardsStream.get(i)!=18 &&
				player.HuCardsStream.get(i)!=24)
			{
				NotOneNine.add(1);
			}
				
		}
		
		for (int i=0; i<player.ChiCardsInOrder.size(); i++)
		{
			if (player.ChiCardsInOrder.get(i)!=0 &&
					player.ChiCardsInOrder.get(i)!=6 &&
					player.ChiCardsInOrder.get(i)!=9 &&
					player.ChiCardsInOrder.get(i)!=15 &&
					player.ChiCardsInOrder.get(i)!=18 &&
					player.ChiCardsInOrder.get(i)!=24)
				{
					NotOneNine.add(1);
				}
		}
		
		for (int i=0; i<player.HuCardsTriplet.size(); i++)
		{
			if (player.HuCardsTriplet.get(i)!=0 &&
					player.HuCardsTriplet.get(i)!=8 &&
					player.HuCardsTriplet.get(i)!=9 &&
					player.HuCardsTriplet.get(i)!=17 &&
					player.HuCardsTriplet.get(i)!=18 &&
					player.HuCardsTriplet.get(i)!=26)
				{
					NotOneNine.add(1);
				}
		}
		
		for (int i=0; i<player.PongCardsInOrder.size(); i++)
		{
			if (player.PongCardsInOrder.get(i)!=0 &&
					player.PongCardsInOrder.get(i)!=8 &&
					player.PongCardsInOrder.get(i)!=9 &&
					player.PongCardsInOrder.get(i)!=17 &&
					player.PongCardsInOrder.get(i)!=18 &&
					player.PongCardsInOrder.get(i)!=26)
				{
				if (player.PongCardsInOrder.get(i)!=27 &&
						player.PongCardsInOrder.get(i)!=28 &&
						player.PongCardsInOrder.get(i)!=29 &&
						player.PongCardsInOrder.get(i)!=30 &&
						player.PongCardsInOrder.get(i)!=31 &&
						player.PongCardsInOrder.get(i)!=32 &&
						player.PongCardsInOrder.get(i)!=33 )
						NotOneNine.add(1);
					else NotOneNine.add(2);
				}
		}
		
		for (int i=0; i<player.GangCardsInOrder.size(); i++)
		{
			if (player.GangCardsInOrder.get(i)!=0 &&
					player.GangCardsInOrder.get(i)!=8 &&
					player.GangCardsInOrder.get(i)!=9 &&
					player.GangCardsInOrder.get(i)!=17 &&
					player.GangCardsInOrder.get(i)!=18 &&
					player.GangCardsInOrder.get(i)!=26)
				{
				if (player.GangCardsInOrder.get(i)!=27 &&
					player.GangCardsInOrder.get(i)!=28 &&
					player.GangCardsInOrder.get(i)!=29 &&
					player.GangCardsInOrder.get(i)!=30 &&
					player.GangCardsInOrder.get(i)!=31 &&
					player.GangCardsInOrder.get(i)!=32 &&
					player.GangCardsInOrder.get(i)!=33 )
					NotOneNine.add(1);
				else NotOneNine.add(2);
				
				}
		}
		
		for (int i=0; i<player.SelfGangCardsInOrder.size(); i++)
		{
			if (player.SelfGangCardsInOrder.get(i)!=0 &&
					player.SelfGangCardsInOrder.get(i)!=8 &&
					player.SelfGangCardsInOrder.get(i)!=9 &&
					player.SelfGangCardsInOrder.get(i)!=17 &&
					player.SelfGangCardsInOrder.get(i)!=18 &&
					player.SelfGangCardsInOrder.get(i)!=26)
				{
				if (player.SelfGangCardsInOrder.get(i)!=27 &&
						player.SelfGangCardsInOrder.get(i)!=28 &&
						player.SelfGangCardsInOrder.get(i)!=29 &&
						player.SelfGangCardsInOrder.get(i)!=30 &&
						player.SelfGangCardsInOrder.get(i)!=31 &&
						player.SelfGangCardsInOrder.get(i)!=32 &&
						player.SelfGangCardsInOrder.get(i)!=33 )
						NotOneNine.add(1);
					else NotOneNine.add(2);
				}
		}

		if (NotOneNine.size()==0)
		{
			Yaku.add("純全帶么九");
			if (CheckMenSen()==true)
			{
				han+=3;
				HanList.add("3番");
			}
			else 
			{
				han+=2;
				HanList.add("2番");
			}
		}
		else 
			{
			if (!NotOneNine.contains(1))
			
			{
			Yaku.add("混全帶么九");
			if (CheckMenSen()==true)
			{
				han+=2;
				HanList.add("2番");
			}
			else
			{
				han++;
				HanList.add("1番");
			}
			}
		}
		
		}
	}
	
	public void ThreeYuan()
	{
		//小三元 2翻
		//大三元 12翻
		ArrayList<Integer> Combined = new ArrayList<Integer>();
		//Combined.add(player.HuCardsPair[0]);
		for (int i=0; i<player.HuCardsTriplet.size(); i++)
		{
			Combined.add(player.HuCardsTriplet.get(i));
		}
		
		for (int i=0; i<player.PongCardsInOrder.size(); i++)
		{
			Combined.add(player.PongCardsInOrder.get(i));
		}
		for (int i=0; i<player.GangCardsInOrder.size(); i++)
		{
			Combined.add(player.GangCardsInOrder.get(i));
		}
		
		for (int i=0; i<player.SelfGangCardsInOrder.size(); i++)
		{
			Combined.add(player.SelfGangCardsInOrder.get(i));
		}
		
		int check=0;
		int check1=0;
		for (int i=0; i<Combined.size(); i++)
		{
			if (Combined.get(i)==31 || Combined.get(i)==32 || Combined.get(i)==33)
			check++;
		}
		
		if (player.HuCardsPair[0]==31 || player.HuCardsPair[0]==32 || player.HuCardsPair[0]==33)
			check1++;
		
		if (check==2 && check1==1)
		{
			Yaku.add("小三元");
			han+=2;
			HanList.add("2番");
		}
		else if (check==3 && check1==0)
		{
			Yaku.add("大三元");
			han+=12;
			HanList.add("3番");
		}
	}
	
	public void LaoTou()
	{
		//清老頭 12翻
		//混老頭 2翻
		if (!CheckSevenPairs())
		{
		if (player.HuCardsStream.size()==0 && player.ChiCardsInOrder.size()==0)
		{
			ArrayList<Integer> Combined = new ArrayList<Integer>();
			ArrayList<Integer> check = new ArrayList<Integer>();
			for (int i=0; i<player.HuCardsTriplet.size(); i++)
			{
				Combined.add(player.HuCardsTriplet.get(i));
			}
			
			for (int i=0; i<player.PongCardsInOrder.size(); i++)
			{
				Combined.add(player.PongCardsInOrder.get(i));
			}
			for (int i=0; i<player.GangCardsInOrder.size(); i++)
			{
				Combined.add(player.GangCardsInOrder.get(i));
			}
			
			for (int i=0; i<player.SelfGangCardsInOrder.size(); i++)
			{
				Combined.add(player.SelfGangCardsInOrder.get(i));
			}
			Combined.add(player.HuCardsPair[0]);
			
			for (int i=0; i<Combined.size(); i++)
			{
				if (Combined.get(i)!=0 && Combined.get(i)!=8 &&
						Combined.get(i)!=9 && Combined.get(i)!=17 &&
						Combined.get(i)!=18 && Combined.get(i)!=26)
				{
					if (Combined.get(i)!=27 && Combined.get(i)!=28 &&
						Combined.get(i)!=29 && Combined.get(i)!=30 && 
						Combined.get(i)!=31 && Combined.get(i)!=32 &&
						Combined.get(i)!=33)
					{
						check.add(1);
					}
					else check.add(2);
				}		
			}
			
			System.out.print(check);
			if (check.size()==0)
			{
				Yaku.add("清老頭");
				han+=12;
				HanList.add("12番");
			}
			else if (!check.contains(1))
			{
				Yaku.add("混老頭");
				han+=2;
				HanList.add("2番");
			}
			
		}
		}
	}
	
	public void SameColor() {
		//清一色 6翻 副露5翻
		//混一色 3翻 副露2翻
		//字一色 12翻
		
		//如果是7對子
		if (CheckSevenPairs())
		{
			int Man = 0;
			int Tiao = 0;
			int Tong = 0;
			int Zhi = 0;
			for (int i=0; i<player.PlayerCards.size(); i++)
			{
				if (0<=player.PlayerCards.get(i).getcardOrder() && player.PlayerCards.get(i).getcardOrder() <= 8)
					Man++;
				else if (9<=player.PlayerCards.get(i).getcardOrder() && player.PlayerCards.get(i).getcardOrder() <= 17)
					Tiao++;
				else if (18<=player.PlayerCards.get(i).getcardOrder() && player.PlayerCards.get(i).getcardOrder() <= 26)
					Tong++;
				else if (27<=player.PlayerCards.get(i).getcardOrder() && player.PlayerCards.get(i).getcardOrder() <= 34)
					Zhi++;
			}
			
			//有大字
			if (Zhi!=0)
			{
				//混一色
				 if (Man==0 && Tiao==0 ||
					 Man==0 && Tong==0 ||
					 Tiao==0 && Tong==0)
				 {
					 Yaku.add("混一色");
					 han+=3;
					 HanList.add("3番");
				 }
			}
			else if (Zhi==0)
			{
				 if (Man==0 && Tiao==0 ||
						 Man==0 && Tong==0 ||
						 Tiao==0 && Tong==0)
					 {
						 Yaku.add("清一色");
						 han+=6;
						 HanList.add("6番");
					 }
			}
		}
		
		else if (!CheckSevenPairs())
		{
		ArrayList<Integer> Combined = new ArrayList<Integer>();
		ArrayList<Integer> check = new ArrayList<Integer>();
		
		for (int i=0; i<player.HuCardsStream.size(); i++)
		{
			Combined.add(player.HuCardsStream.get(i));
		}
		
		for (int i=0; i<player.ChiCardsInOrder.size(); i++)
		{
			Combined.add(player.ChiCardsInOrder.get(i));
		}
		
		for (int i=0; i<player.HuCardsTriplet.size(); i++)
		{
			Combined.add(player.HuCardsTriplet.get(i));
		}
		
		for (int i=0; i<player.PongCardsInOrder.size(); i++)
		{
			Combined.add(player.PongCardsInOrder.get(i));
		}
		for (int i=0; i<player.GangCardsInOrder.size(); i++)
		{
			Combined.add(player.GangCardsInOrder.get(i));
		}
		
		for (int i=0; i<player.SelfGangCardsInOrder.size(); i++)
		{
			Combined.add(player.SelfGangCardsInOrder.get(i));
		}
		Combined.add(player.HuCardsPair[0]);
		
		for (int i=0; i<Combined.size(); i++)
		{
			if (0<= Combined.get(i) && Combined.get(i) <= 8)
				check.add(0);
			else if (9<= Combined.get(i) && Combined.get(i) <= 17)
				check.add(1);
			else if (18<= Combined.get(i) && Combined.get(i) <=26)
				check.add(2);
			else if (27<= Combined.get(i))
				check.add(3);
		}
		
		System.out.print("check: ");
		System.out.print(check);
		
		
		
		//只有大字
		if (check.contains(3)&&!check.contains(0)
				&&!check.contains(2)
				&&!check.contains(1))
		{
			Yaku.add("字一色");
			han+=12;
			HanList.add("12番");
		}
		
		//沒有大字
		else if (!check.contains(3))
		{
			if (!check.contains(2) && !check.contains(0) || 
					!check.contains(1) && !check.contains(2) || 
					!check.contains(1) && !check.contains(0))
			{
				//如果只有條子
				if (!check.contains(1) && !check.contains(0))
				{
					//如果沒有1條 5條 7條 9條
					if (player.CardTypeNumber[18] ==0 &&
						player.CardTypeNumber[22] ==0 &&
						player.CardTypeNumber[24] ==0 &&
						player.CardTypeNumber[26] ==0)
					{
						Yaku.add("綠一色");
						han+=12;
						HanList.add("12番");
					}
					//如果有
					else
					{
						Yaku.add("清一色");
						if (CheckMenSen())
							{
								han+=6;
								HanList.add("6番");
							}
						
						else
							{
								han+=5;
								HanList.add("5番");
							}
					}
				}
				//只有萬&筒
				else{
					Yaku.add("清一色");
					if (CheckMenSen())
					{
						han+=6;
						HanList.add("6番");
					}
					else
					{
						HanList.add("5番");
						han+=5;
					}
				}
			}
		}
		else if (check.contains(3)) //大字+其中一種
		{
			if (!check.contains(2) && !check.contains(0) || 
					!check.contains(1) && !check.contains(2) || 
					!check.contains(1) && !check.contains(0))
			{
				Yaku.add("混一色");
				if (CheckMenSen())
				{
					han+=3;
					HanList.add("3番");
				}
				else
				{
					HanList.add("2番");
					han+=2;
				}
			}
		}
		}
	}
	
	public void FourAnKotsu()
	{
		//四暗刻 12翻
		if (player.HuCardsTriplet.size() + player.SelfGangCardsInOrder.size() == 4)
		{
			Yaku.add("四暗刻");
			han+=12;
			HanList.add("12番");
		}
		
	}
	
	public void FourShi()
	{
		//小四喜 12翻
		//大四喜 12翻
		
		ArrayList<Integer> Combined = new ArrayList<Integer>();

		for (int i=0; i<player.HuCardsTriplet.size(); i++)
		{
			Combined.add(player.HuCardsTriplet.get(i));
		}
		
		for (int i=0; i<player.PongCardsInOrder.size(); i++)
		{
			Combined.add(player.PongCardsInOrder.get(i));
		}
		
		for (int i=0; i<player.GangCardsInOrder.size(); i++)
		{
			Combined.add(player.GangCardsInOrder.get(i));
		}
				
		for (int i=0; i<player.SelfGangCardsInOrder.size(); i++)
		{
			Combined.add(player.SelfGangCardsInOrder.get(i));
		}
			
		int check=0;
		int check1=0;
		for (int i=0; i<Combined.size(); i++)
		{
			if (Combined.get(i)==27 || Combined.get(i)==28 || Combined.get(i)==29 || Combined.get(i)==30)
				check++;
		}
			
		if (player.HuCardsPair[0]==27 || player.HuCardsPair[0]==28 || player.HuCardsPair[0]==29 || player.HuCardsPair[0]==30)
			check1++;
				
		if (check==3 && check1==1)
		{
			Yaku.add("小四喜");	
			HanList.add("12番");
			han+=12;
		}
		else if (check==4 && check1==0)
		{
			Yaku.add("大四喜");
			HanList.add("12番");
			han+=12;
		}		
		
	}
	
	public void FourGang() {
		//四槓子 12翻
		if (player.GangCardsInOrder.size()+player.SelfGangCardsInOrder.size()==4)
		{
			Yaku.add("四槓子");
			HanList.add("12番");
			han+=12;
		}
	}
	
	public void NineLotusLight() {
		//九蓮寶燈 12翻
		if (player.CardTypeNumber[0]>=3 &&
			player.CardTypeNumber[8]>=3 &&
			player.CardTypeNumber[1]>=1 &&
			player.CardTypeNumber[2]>=1 &&
			player.CardTypeNumber[3]>=1 &&
			player.CardTypeNumber[4]>=1 &&
			player.CardTypeNumber[5]>=1 &&
			player.CardTypeNumber[6]>=1 &&
			player.CardTypeNumber[7]>=1 )
			{
				Yaku.add("九蓮寶燈");
				HanList.add("12番");
				han+=12;
			}
	}
	
	public void ComputerWins() {
		//電腦胡牌 1番
		if (player.bot) {
			Yaku.add("電腦胡牌");
			HanList.add("1番");
			han+=1;
		}
			
	}
	
	public void printYaku()
	{
		if (Yaku.size()==0) System.out.println("無役");
		else
		System.out.print(Yaku);
	}
	
	public void addindex() {
		this.index++;
	}
	
}
