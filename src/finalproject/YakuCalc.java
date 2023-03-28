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
			Yaku.add("�_�P");
			HanList.add(doraamount + "�f");
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
			Yaku.add("���_�P");
			han+=uradoraamount;
			HanList.add(uradoraamount + "�f");
		}
	}
	
	public void ZhungJia() {
		if (player.Zhuang)
		{
			Yaku.add("���a");
			han++;
			HanList.add("1�f");
		}
	}
	public int getpoint() {
		point = 1000*(han+1);
		return point;
	}
	
	public void Calc() {
		if (!GokuShiMuSou())
		{
		NoOneNine();  //�_�\�E
		SevenPairs(); //�C��l
		MenSenZhiMo(); //���e�M�ۺN�M
		YiBeiKou_and_ErBeiKou(); //�@�M�f&�G�M�f
		SanYenPai(); //�T���P (���o��)
		HaiDiLaoYueAndHeiDiLaoYu(); //�������� & �e������
		SanSokuSameStream(); //�T��P��
		SanSokuSameTriplet(); //�T��P��
		YiChiTongGuang(); //�@��q�e
		DaiDai(); //���M
		SanAnKotsu(); //�T�t��
		SanGang(); //�T�b�l
		ChuanDaiOneNine(); //�¥��a�\�E & �V���a�\�E
		ThreeYuan(); //�p�T�P & �j�T�P
		LaoTou(); //�V���Y & �M���Y
		SameColor(); //�M�@�� & �V�@�� & �r�@�� &��@��
		FourAnKotsu(); //�|�t��
		FourShi(); //�p�|�� & �j�|��
		FourGang(); //�|�b�l
		RiChi();
		dora();
		uradora();
		ComputerWins();

		}
		else
		{
			ComputerWins();
			Yaku.add("��h�L��");
			HanList.add("12�f");
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
		System.out.print(han + "�f");
	}
	
	public void RiChi() {
		//�ߪ� 1½
		if (player.RiChi)
		{
			Yaku.add("�ߪ�");
			HanList.add("1�f");
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
		//�_�\�E 1½
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
			Yaku.add("�_�\�E");
			HanList.add("1�f");
			han++;
		}
	}
	
	public boolean CheckMenSen() {
		// �ˬd���e�M
		if (player.ChiPongGangCards.size()==0)
			return true;
		else if (player.ChiPongGangCards.size()%4 == 0 && player.ChiPongGangCards.size()/4 == player.SelfGangCardsInOrder.size())
			return true;
		else return false;
	}
	
	public boolean CheckSevenPairs() {
		// �ˬd�C��l
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
		//�C��l 2½
		int pairsamount=0;
		for (int i=0; i<player.CardTypeNumber.length; i++)
		{
			if (player.CardTypeNumber[i]==2) pairsamount++;
		}
		
		if (pairsamount==7) 
			{
				Yaku.add("�C��l");
				HanList.add("2�f");
				han+=2;
			}
	}
	
	public void MenSenZhiMo() {
		//���e�M�ۺN�M 1½
		if (CheckMenSen()==true && player.Zhimo==true)
		{
			Yaku.add("���e�M�ۺN�M");
			HanList.add("1�f");
			han++;
		}
	}
	
	public void PingHu() {
		//���J 1½
		int DaZhiAmount = 0;
		for (int i=27; i<player.CardTypeNumber.length; i++)
		{
			if (player.CardTypeNumber[i]>0)
				DaZhiAmount++;
		}
		if (player.HuCardsTriplet.size()==0 && DaZhiAmount==0 && CheckMenSen()==true)
		{
			Yaku.add("���J");
			HanList.add("1�f");
			han++;
		}
	}
	
	public void YiBeiKou_and_ErBeiKou() {
		//�@�M�f 1½
		//�G�M�f 3½
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
			Yaku.add("�@�M�f");
			HanList.add("1�f");
			han++;
		}
		else if (BeiKouAmount==2)
		{
			Yaku.add("�G�M�f");
			HanList.add("3�f");
			han+=3;
		}
	}
	public void SanYenPai() {
		//�F�n��_���o�� �U1½

		if (player.HuCardsTriplet.contains(27) || player.PongCardsInOrder.contains(27)|| player.GangCardsInOrder.contains(27) || player.SelfGangCardsInOrder.contains(27))
		{
			Yaku.add("�r�P�F");
			HanList.add("1�f");
			han++;
		}
		if (player.HuCardsTriplet.contains(28) || player.PongCardsInOrder.contains(28) || player.GangCardsInOrder.contains(28) || player.SelfGangCardsInOrder.contains(28))
		{
			Yaku.add("�r�P�n");
			HanList.add("1�f");
			han++;
		}
		if (player.HuCardsTriplet.contains(29) || player.PongCardsInOrder.contains(29)|| player.GangCardsInOrder.contains(29) || player.SelfGangCardsInOrder.contains(29))
		{
			Yaku.add("�r�P��");
			HanList.add("1�f");
			han++;
		}
		if (player.HuCardsTriplet.contains(30) || player.PongCardsInOrder.contains(30)|| player.GangCardsInOrder.contains(30) || player.SelfGangCardsInOrder.contains(30))
		{
			Yaku.add("�r�P�_");
			HanList.add("1�f");
			han++;
		}
		if (player.HuCardsTriplet.contains(31) || player.PongCardsInOrder.contains(31)|| player.GangCardsInOrder.contains(31) || player.SelfGangCardsInOrder.contains(31))
		{
			Yaku.add("���P��");
			HanList.add("1�f");
			han++;
		}
		if (player.HuCardsTriplet.contains(32) || player.PongCardsInOrder.contains(32) || player.GangCardsInOrder.contains(32) || player.SelfGangCardsInOrder.contains(32))
		{
			Yaku.add("���P�o");
			HanList.add("1�f");
			han++;
		}
		if (player.HuCardsTriplet.contains(33) || player.PongCardsInOrder.contains(33)|| player.GangCardsInOrder.contains(33) || player.SelfGangCardsInOrder.contains(33))
		{
			Yaku.add("���P��");
			HanList.add("1�f");
			han++;
		}
	}
	
	public void RinShangKaiHua() {
		//���W�}�� 1½
		if (player.RinShang==true && player.Zhimo==true)
		{
			Yaku.add("���W�}��");
			HanList.add("1�f");
			han++;
		}
	}
	
	public void HaiDiLaoYueAndHeiDiLaoYu() {
		//�������� 1½
		//�e������ 1½
		if (player.HaiDiLaoYue==true)
		{
			Yaku.add("��������");
			HanList.add("1�f");
			han++;
		}
		else if (player.HeiDiLaoYu==true)
		{
			Yaku.add("�e������");
			HanList.add("1�f");
			han++;
		}
	}
	
	public void SanSokuSameStream()
	{
		//3��P�� 2½ ���S-1½
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
					Yaku.add("�T��P��");
					if (CheckMenSen()==false)
						{
							han++;
							HanList.add("1�f");
						}
					else
						{
							han+=2;
							HanList.add("2�f");
						}
					break;
				}
			}
		}
	}
	
	public void SanSokuSameTriplet()
	{
		//3��P�� 2½
		
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
					Yaku.add("�T��P��");
					han+=2;
					HanList.add("2�f");
					break;
				}
			}
		}
	}
	
	public void YiChiTongGuang() {
		//�@��q�e 2½  ���S-1½
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
				Yaku.add("�@��q�e");
				if (CheckMenSen()==false)
				{
					han++;
					HanList.add("1�f");
				}
				else
				{
					han+=2;
					HanList.add("2�f");
				}
			}
		}
	}
	
	
	public void DaiDai()
	{
		//���M 2½
		if (!CheckSevenPairs())
		{
			if (player.HuCardsStream.size()==0 && player.ChiCardsInOrder.size()==0)
			{
				Yaku.add("���M");
				HanList.add("2�f");
				han+=2;
			}
		}
	}
	
	public void SanAnKotsu() {
		//�T�t�� 2½
		if (player.HuCardsTriplet.size()==3 || player.HuCardsTriplet.size()+player.SelfGangCardsInOrder.size()==3)
		{
			Yaku.add("�T�t��");
			HanList.add("2�f");
			han+=2;
		}
	}
	
	public void SanGang() {
		//�T�b�l 2½
		if (player.GangCardsInOrder.size()+player.SelfGangCardsInOrder.size()==3)
		{
			Yaku.add("�T�b�l");
			HanList.add("2�f");
			han+=2;
		}
	}
	
	public void ChuanDaiOneNine() {
		//�V���a�\�E 2½ ���S-1½
		//�¥��a�\�E 3½ ���S-2½
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
			Yaku.add("�¥��a�\�E");
			if (CheckMenSen()==true)
			{
				han+=3;
				HanList.add("3�f");
			}
			else 
			{
				han+=2;
				HanList.add("2�f");
			}
		}
		else 
			{
			if (!NotOneNine.contains(1))
			
			{
			Yaku.add("�V���a�\�E");
			if (CheckMenSen()==true)
			{
				han+=2;
				HanList.add("2�f");
			}
			else
			{
				han++;
				HanList.add("1�f");
			}
			}
		}
		
		}
	}
	
	public void ThreeYuan()
	{
		//�p�T�� 2½
		//�j�T�� 12½
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
			Yaku.add("�p�T��");
			han+=2;
			HanList.add("2�f");
		}
		else if (check==3 && check1==0)
		{
			Yaku.add("�j�T��");
			han+=12;
			HanList.add("3�f");
		}
	}
	
	public void LaoTou()
	{
		//�M���Y 12½
		//�V���Y 2½
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
				Yaku.add("�M���Y");
				han+=12;
				HanList.add("12�f");
			}
			else if (!check.contains(1))
			{
				Yaku.add("�V���Y");
				han+=2;
				HanList.add("2�f");
			}
			
		}
		}
	}
	
	public void SameColor() {
		//�M�@�� 6½ ���S5½
		//�V�@�� 3½ ���S2½
		//�r�@�� 12½
		
		//�p�G�O7��l
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
			
			//���j�r
			if (Zhi!=0)
			{
				//�V�@��
				 if (Man==0 && Tiao==0 ||
					 Man==0 && Tong==0 ||
					 Tiao==0 && Tong==0)
				 {
					 Yaku.add("�V�@��");
					 han+=3;
					 HanList.add("3�f");
				 }
			}
			else if (Zhi==0)
			{
				 if (Man==0 && Tiao==0 ||
						 Man==0 && Tong==0 ||
						 Tiao==0 && Tong==0)
					 {
						 Yaku.add("�M�@��");
						 han+=6;
						 HanList.add("6�f");
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
		
		
		
		//�u���j�r
		if (check.contains(3)&&!check.contains(0)
				&&!check.contains(2)
				&&!check.contains(1))
		{
			Yaku.add("�r�@��");
			han+=12;
			HanList.add("12�f");
		}
		
		//�S���j�r
		else if (!check.contains(3))
		{
			if (!check.contains(2) && !check.contains(0) || 
					!check.contains(1) && !check.contains(2) || 
					!check.contains(1) && !check.contains(0))
			{
				//�p�G�u�����l
				if (!check.contains(1) && !check.contains(0))
				{
					//�p�G�S��1�� 5�� 7�� 9��
					if (player.CardTypeNumber[18] ==0 &&
						player.CardTypeNumber[22] ==0 &&
						player.CardTypeNumber[24] ==0 &&
						player.CardTypeNumber[26] ==0)
					{
						Yaku.add("��@��");
						han+=12;
						HanList.add("12�f");
					}
					//�p�G��
					else
					{
						Yaku.add("�M�@��");
						if (CheckMenSen())
							{
								han+=6;
								HanList.add("6�f");
							}
						
						else
							{
								han+=5;
								HanList.add("5�f");
							}
					}
				}
				//�u���U&��
				else{
					Yaku.add("�M�@��");
					if (CheckMenSen())
					{
						han+=6;
						HanList.add("6�f");
					}
					else
					{
						HanList.add("5�f");
						han+=5;
					}
				}
			}
		}
		else if (check.contains(3)) //�j�r+�䤤�@��
		{
			if (!check.contains(2) && !check.contains(0) || 
					!check.contains(1) && !check.contains(2) || 
					!check.contains(1) && !check.contains(0))
			{
				Yaku.add("�V�@��");
				if (CheckMenSen())
				{
					han+=3;
					HanList.add("3�f");
				}
				else
				{
					HanList.add("2�f");
					han+=2;
				}
			}
		}
		}
	}
	
	public void FourAnKotsu()
	{
		//�|�t�� 12½
		if (player.HuCardsTriplet.size() + player.SelfGangCardsInOrder.size() == 4)
		{
			Yaku.add("�|�t��");
			han+=12;
			HanList.add("12�f");
		}
		
	}
	
	public void FourShi()
	{
		//�p�|�� 12½
		//�j�|�� 12½
		
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
			Yaku.add("�p�|��");	
			HanList.add("12�f");
			han+=12;
		}
		else if (check==4 && check1==0)
		{
			Yaku.add("�j�|��");
			HanList.add("12�f");
			han+=12;
		}		
		
	}
	
	public void FourGang() {
		//�|�b�l 12½
		if (player.GangCardsInOrder.size()+player.SelfGangCardsInOrder.size()==4)
		{
			Yaku.add("�|�b�l");
			HanList.add("12�f");
			han+=12;
		}
	}
	
	public void NineLotusLight() {
		//�E���_�O 12½
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
				Yaku.add("�E���_�O");
				HanList.add("12�f");
				han+=12;
			}
	}
	
	public void ComputerWins() {
		//�q���J�P 1�f
		if (player.bot) {
			Yaku.add("�q���J�P");
			HanList.add("1�f");
			han+=1;
		}
			
	}
	
	public void printYaku()
	{
		if (Yaku.size()==0) System.out.println("�L��");
		else
		System.out.print(Yaku);
	}
	
	public void addindex() {
		this.index++;
	}
	
}
