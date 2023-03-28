package finalproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Player {

	Player(boolean bot) {
		this.bot=bot;
	}

	
	public String Playername="";
	public int PlayerPoints = 20000;
	public ArrayList<mahjong> PlayerCards = new ArrayList<mahjong>();
	public Stack<mahjong> river = new Stack<mahjong>();
	public ArrayList<mahjong> ChiPongGangCards = new ArrayList<mahjong>();
	public int[] CardTypeNumber = new int[34];
	public boolean Zhimo = false;
	public ArrayList<Integer> HuCardsStream = new ArrayList<Integer>();
	public ArrayList<Integer> HuCardsTriplet = new ArrayList<Integer>();
	public int[] HuCardsPair = new int[1];
	public boolean RinShang = false;
	public boolean HaiDiLaoYue = false;
	public boolean HeiDiLaoYu = false;
	public boolean JustRiChi = false;
	public boolean RiChi = false;
	public boolean bot = false;
	public boolean Zhuang = false;
	public ArrayList<Integer> ChiCardsInOrder = new ArrayList<Integer>();
	public ArrayList<Integer> PongCardsInOrder = new ArrayList<Integer>();
	public ArrayList<Integer> GangCardsInOrder = new ArrayList<Integer>();
	public ArrayList<Integer> SelfGangCardsInOrder = new ArrayList<Integer>();
	public ArrayList<mahjong> PlayerTingCards = new ArrayList<mahjong>();
	public ArrayList<mahjong> PlayerRichiOptions = new ArrayList<mahjong>();
	
	
	public void clearAll() {
		PlayerCards.clear();
		river.clear();
		ChiPongGangCards.clear();
		Zhimo = false;
		HuCardsStream.clear();
		HuCardsTriplet.clear();
		RinShang=false;
		HaiDiLaoYue=false;
		HeiDiLaoYu = false;
		ChiCardsInOrder.clear();
		PongCardsInOrder.clear();
		GangCardsInOrder.clear();
		SelfGangCardsInOrder.clear();
		RiChi=false;
		
	}
	
	public String getPlayerName() {
		return Playername;
	}
	
	public int getPlayerPoints() {
		return PlayerPoints;
	}
	
	public void addCards(mahjong a){
		PlayerCards.add(a);
	}
	
	public void throwCards(mahjong a) {
		PlayerCards.remove(a);
		river.add(a);
	}
	
	public void setCardTypeNumber(String[] CardTypeList) {
		Arrays.fill(CardTypeNumber, 0);
		
		for (int i=0; i<34; i++) //這個for迴圈是把每種手牌的數量加進CardTypeNumber裡
		{
			for (int j=0; j<PlayerCards.size(); j++)
			{
				if (PlayerCards.get(j).getName().equals(CardTypeList[i])) 
				CardTypeNumber[i]++;
			}
		}
	}
	
	public ArrayList<mahjong> sortCards(){
		Comparator<mahjong> c = new Comparator<mahjong>()
		{
			@Override
			public int compare(mahjong o1, mahjong o2) {
				if (o1.order>o2.order)
					return 1;
				else
					return -1;
			}
		};
		PlayerCards.sort(c);
		return PlayerCards;
	}
	/*
	 * 這三個是check打出來的牌能不能吃碰槓，可以就回傳true，不能就回傳false
	 */
	
	
	public boolean pongable(mahjong m)
	{
		
		/*
		 * 邏輯：
		 * 1. check手上的牌有的種類數量
		 * 2. 有2張現在打出來的牌就回傳true
		 * 
		 */
		int amount=0;
		for (int i=0; i<PlayerCards.size(); i++)
		{
			if (m.getName().equals(PlayerCards.get(i).getName()))
			{
				amount++;
			}
		}
		
		if (amount>=2) return true;
		else return false;
	}
	
	public int chiable(mahjong m, String[] CardTypeList)
	{
		setCardTypeNumber(CardTypeList);
		
		if (m.cardOrder>=27) return 0;
		else
		{
			switch (m.cardOrder%9) 
			{
				case 0: //1萬 1筒 1條
					if (CardTypeNumber[m.cardOrder+1] >=1 && CardTypeNumber[m.cardOrder+2] >=1) 
						return 1; 
						break;
				case 8: //9萬 9筒 9條
					if (CardTypeNumber[m.cardOrder-1] >=1 && CardTypeNumber[m.cardOrder-2] >=1) 
						return 2;
						break;
				case 1: //2萬 2筒 2條
					if ((CardTypeNumber[m.cardOrder-1] >=1 && CardTypeNumber[m.cardOrder+1] >=1 ) 
							|| (CardTypeNumber[m.cardOrder+1] >=1 && CardTypeNumber[m.cardOrder+2] >=1) ) 
						return 3; 
						break;
				case 7: //8萬 8筒 8條
					if ((CardTypeNumber[m.cardOrder-1] >=1 && CardTypeNumber[m.cardOrder+1] >=1 ) 
							|| (CardTypeNumber[m.cardOrder-1] >=1 && CardTypeNumber[m.cardOrder-2] >=1) ) 
						return 4; 
						break;
				default:
					if ((CardTypeNumber[m.cardOrder-1] >=1 && CardTypeNumber[m.cardOrder+1] >=1 ) || 
							(CardTypeNumber[m.cardOrder-1] >=1 && CardTypeNumber[m.cardOrder-2] >=1) || 
							(CardTypeNumber[m.cardOrder+1] >=1 && CardTypeNumber[m.cardOrder+2] >=1) ) 
						return 5; 
						break;
			}
		}
		
		return 0;
	}
	
	public boolean gangable(mahjong m)
	{
		/*
		 * 邏輯：
		 * 1. check手上的牌有的種類數量
		 * 2. 有3張現在打出來的牌就回傳true
		 * 
		 */
		int amount=0;
		for (int i=0; i<PlayerCards.size(); i++)
		{
			if (m.getName().equals(PlayerCards.get(i).getName()))
			{
				amount++;
			}
		}
		
		if (amount>=3) return true;
		else return false;
	}
	
	public boolean self_gangable()
	{
		/*
		 * 邏輯：
		 * 1. check手上的牌有的種類數量
		 * 2. 有4張現在打出來的牌就回傳true
		 * 
		 */
		for (int i=0; i<34; i++)
		{
			if (this.CardTypeNumber[i]==4)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean ZhiMo(ArrayList<mahjong> a, String[] CardTypeList)
	{
		if (HuAble(a, CardTypeList) == true) return true;
		else return false;
	}
	
	public boolean HuAble(ArrayList<mahjong> a, String[] CardTypeList)
	{
		this.HuCardsStream.clear();
		this.HuCardsTriplet.clear();
		/*
		 * 邏輯：
		 * 1. 先記錄所有的牌種類的張數
		 * 2.接著進入for(0~33)迴圈：
		 * 3.把對子拿走(張數>2)
		 * 4.先取刻子再取順 OR 先取順再取刻子 (做兩種的原因是因為可能有刻子卡在順子中間這種問題)
		 * 5.做完迴圈之後如果全部的牌都被拿光，代表可以胡
		 *
		 */
		final int[] zero = new int[34]; 
		Arrays.fill(zero, 0); //都是0的陣列
		
		int[] CardTypeNumber2 = zero.clone(); //用來放卡片種類數量的陣列
		//[0]就是1萬, [1]就是2萬...以此類推
		
		for (int i=0; i<34; i++) //這個for迴圈是把每種手牌的數量加進CardTypeNumber裡
		{
			for (int j=0; j<a.size(); j++)
			{
				if (a.get(j).getName().equals(CardTypeList[i])) 
				CardTypeNumber2[i]++;
			}
		}
		
		
		

		
		//國士無雙
		int yea=0;
		int yea1=0;
		for (int i=0; i<CardTypeNumber2.length;i++)
		{
			if (i==0 || i==8 || i==9 || i==17 || i==18 || i==26 || 
				i==27 || i==28 || i==29 || i==30 || i==31 || i==32 || i==33)
			{
				if (CardTypeNumber2[i]>=1) yea++;
				if (CardTypeNumber2[i]>=2) yea1++;
			}
			else if (CardTypeNumber2[i]==0) yea++;
		}
		if (yea==34 && yea1==1) 
			{
			return true;
			}
		
		//七對子
		int PairAmount = 0;
		for (int i=0; i<CardTypeNumber.length; i++)
		{
			if (CardTypeNumber2[i]==2)
			{
				PairAmount++;
			}
		}
		
		
		if (PairAmount==7)
			{
			return true;
			}
		else
		{
		for (int i=0; i<34; i++)
		{
			for (int checkround=0; checkround<2; checkround++)
			{
				int[] pair = new int[1];
				ArrayList<Integer> triplets = new ArrayList();
				ArrayList<Integer> stream = new ArrayList();
				
				int[] copy = CardTypeNumber2.clone();
				if (copy[i]>=2)
				{
					copy[i] -= 2;
					pair[0] = i;
				
				
				//checkround1 : 先取刻子再取順子
				if (checkround==0)
				{
					//取刻子
					for (int j=0; j<34; j++)
					{
						if (copy[j]>=3) 
							{
								copy[j]-=3;
								triplets.add(j);
							}
					}
					
					//取順子
					for (int type=0; type<3; type++)
					{
						for (int number=0; number<7;)
						{
							if (copy[9*type+number]>=1 && copy[9*type+number+1]>=1 && copy[9*type+number+2]>=1)
							{
								copy[9*type+number]-=1;
								copy[9*type+number+1]-=1;
								copy[9*type+number+2]-=1;
								stream.add(9*type+number);
							}
							else number++;
						}
					}
				
				}
				//checkround2: 先取順子再取刻子
				else if (checkround==1)
				{
					//取順子
					for (int type=0; type<3; type++)
					{
						for (int number=0; number<7;)
						{
							if (copy[9*type+number]>=1 && copy[9*type+number+1]>=1 && copy[9*type+number+2]>=1)
							{
								copy[9*type+number]-=1;
								copy[9*type+number+1]-=1;
								copy[9*type+number+2]-=1;
								stream.add(9*type+number);
							}
							else number++;
						}
					}
					
					//取刻子
					for (int j=0; j<34; j++)
					{
						if (copy[j]>=3) 
						{
							copy[j]-=3;
							triplets.add(j);
						}
					}
				}
				
				if (Arrays.equals(copy,zero)) 
					{
					for (int u=0; u<stream.size(); u++)
					{
						this.HuCardsStream.add(stream.get(u));
					}
					for (int u=0; u<triplets.size(); u++)
					{
						this.HuCardsTriplet.add(triplets.get(u));
					}
					HuCardsPair[0] = pair[0];
					return true;
					}
			}
			
			
		}}
		
		return false;
	}
	}
	
	
	public int ThrowCardLogic(ArrayList<mahjong> Cards, int[] CardNumber, String[] CardTypeList) {		
		//第一輪: 單張大字
		System.out.println("*******************");
		for (int i=0; i<Cards.size(); i++) {
			System.out.print(Cards.get(i).getName() + " ");
		}
		System.out.println();
		System.out.println("*******************");
		
		
		for (int i=0; i<Cards.size(); i++) {
			if (Cards.get(i).cardOrder>=27)
			{
				if (CardNumber[Cards.get(i).getcardOrder()]>=2)
					continue;
				else 
				{
					System.out.println("1");
					return ReturnedValue(Cards.get(i));
				}
			}
		}
		
		//第二輪: 沒靠張的
		for (int i=0; i<Cards.size(); i++) {
			//先判斷是不是大字
			if (Cards.get(i).getcardOrder()<=26)
			{
				if (CardNumber[Cards.get(i).getcardOrder()]==1)
				{
				//數字為1的部分
					if (Cards.get(i).getcardOrder()%9==0)
					{
						if (CardNumber[Cards.get(i).getcardOrder()+1]>=1 ||
								CardNumber[Cards.get(i).getcardOrder()+2]>=1)
							continue;
						else
							{
							System.out.println("2-1");
							return ReturnedValue(Cards.get(i));
							}
					}
				//數字為2的部分
				else if (Cards.get(i).getcardOrder()%9==1)
				{
					if (CardNumber[Cards.get(i).getcardOrder()-1]>=1 ||
							CardNumber[Cards.get(i).getcardOrder()+1]>=1 ||						
							CardNumber[Cards.get(i).getcardOrder()+2]>=1)
						continue;
					else 
					{
						System.out.println("2-2");return ReturnedValue(Cards.get(i));
					}
					
				}
				
				//數字為8的部分
				else if (Cards.get(i).getcardOrder()%9==7)
				{
					if (CardNumber[Cards.get(i).getcardOrder()-2]>=1 ||
							CardNumber[Cards.get(i).getcardOrder()-1]>=1 ||						
							CardNumber[Cards.get(i).getcardOrder()+1]>=1)
						continue;
					{System.out.println("2-1");return ReturnedValue(Cards.get(i));
			}
				}
				//數字為9的部分
				else if (Cards.get(i).getcardOrder()%9==8)
				{
					if (CardNumber[Cards.get(i).getcardOrder()-2]>=1 ||
							CardNumber[Cards.get(i).getcardOrder()-1]>=1)
						continue;
					else return ReturnedValue(Cards.get(i));
				}
				
				else
				{
					if (CardNumber[Cards.get(i).getcardOrder()-2]>=1 ||
							CardNumber[Cards.get(i).getcardOrder()-1]>=1 ||
							CardNumber[Cards.get(i).getcardOrder()+1]>=1 ||
							CardNumber[Cards.get(i).getcardOrder()+2]>=1)
						continue;
					else return ReturnedValue(Cards.get(i));
				}
				
				}}
			}
		
		
		
		//第三輪: 跳過順子 & 刻子 回來loop
		ArrayList<mahjong> copy = new ArrayList();
		int[] copy_CardTypeNumber = new int[34];
		copy = (ArrayList<mahjong>) Cards.clone();
		
		
		String[] copy_CardTypeList = CardTypeList.clone();
		
		
		Arrays.fill(copy_CardTypeNumber, 0);
		
		for (int k=0; k<34; k++) //這個for迴圈是把每種手牌的數量加進copy_CardTypeNumber裡
		{
			for (int j=0; j<copy.size(); j++)
			{
				if (copy.get(j).getName().equals(CardTypeList[k])) 
				copy_CardTypeNumber[k]++;
			}
		}
		
		for (int i=0; i<copy.size(); i++) {
			{
				if (copy.get(i).getcardOrder()>=27)
				{
					if (copy_CardTypeNumber[copy.get(i).getcardOrder()]==3)
					{
						copy.remove(i);
						copy.remove(i);
						copy.remove(i);
						for (int k=0; k<34; k++) //這個for迴圈是把每種手牌的數量加進copy_CardTypeNumber裡
						{
							copy_CardTypeNumber[k]=0;
							for (int j=0; j<copy.size(); j++)
							{
								if (copy.get(j).getName().equals(CardTypeList[k])) 
								copy_CardTypeNumber[k]++;
							}
						}
						return ThrowCardLogic(copy, copy_CardTypeNumber, copy_CardTypeList);
	
					}
				}
				else if (copy.get(i).getcardOrder()<=26)
				{
					//刻子
					if (copy_CardTypeNumber[copy.get(i).getcardOrder()]==3)
					{
						int RemovedOrder = copy.get(i).getcardOrder();
						copy.remove(i); //remove現在這一張
						
						for (int j=0; j<copy.size(); j++)
						{
							if (copy.get(j).getcardOrder()==RemovedOrder)
							{
								copy.remove(j);
								break;
							}
						}
						
						for (int j=0; j<copy.size(); j++)
						{
							if (copy.get(j).getcardOrder()==RemovedOrder)
							{
								copy.remove(j);
								break;
							}
						}
						
						for (int k=0; k<34; k++) //這個for迴圈是把每種手牌的數量加進copy_CardTypeNumber裡
						{
							copy_CardTypeNumber[k]=0;
							for (int j=0; j<copy.size(); j++)
							{
								if (copy.get(j).getName().equals(CardTypeList[k])) 
								copy_CardTypeNumber[k]++;
							}
						}
						return ThrowCardLogic(copy, copy_CardTypeNumber, copy_CardTypeList);

					}
					else
					{ //順子
					
						if (copy_CardTypeNumber[copy.get(i).getcardOrder()+1]>=1 &&
								copy_CardTypeNumber[copy.get(i).getcardOrder()+2]>=1)
						{
							int RemovedOrder = copy.get(i).getcardOrder();
							copy.remove(i); //remove現在這一張
							
							for (int j=0; j<copy.size(); j++)
							{
								if (copy.get(j).getcardOrder()==RemovedOrder+1)
								{
									copy.remove(j);
									break;
								}
							}
							
							for (int j=0; j<copy.size(); j++)
							{
								if (copy.get(j).getcardOrder()==RemovedOrder+2)
								{
									copy.remove(j);
									break;
								}
							}
							
//							for (int j=0; j<copy.size(); j++)
//							{
//								System.out.print(copy.get(j).getName() + " ");
//							}
//							System.out.println();
							for (int k=0; k<34; k++) //這個for迴圈是把每種手牌的數量加進copy_CardTypeNumber裡
							{
								copy_CardTypeNumber[k]=0;
								for (int j=0; j<copy.size(); j++)
								{
									if (copy.get(j).getName().equals(CardTypeList[k])) 
									copy_CardTypeNumber[k]++;
								}
							}
							return ThrowCardLogic(copy, copy_CardTypeNumber, copy_CardTypeList);	

						}
					
				}
			}
		}
		}
		
		//第四輪: 拆邊張中洞
		
				for (int i=0; i<Cards.size(); i++) {
					//先判斷是不是大字
					if (Cards.get(i).getcardOrder()<=26)
					{
						//數字為1的部分
						if (Cards.get(i).getcardOrder()%9==0)
						{
							//1的話不管是只靠2或只靠3都是邊張中洞，所以只要不同時存在就得打
							if (CardNumber[Cards.get(i).getcardOrder()+1]>=1 ^
									CardNumber[Cards.get(i).getcardOrder()+2]>=1)
								return ReturnedValue(Cards.get(i));
							else continue;
						}

						//數字為9的部分
						else if (Cards.get(i).getcardOrder()%9==8)
						{
							//9和1的邏輯類似
							if (CardNumber[Cards.get(i).getcardOrder()-2]>=1 ^
									CardNumber[Cards.get(i).getcardOrder()-1]>=1)
								return ReturnedValue(Cards.get(i));
							else continue;
							
						}
						//數字為2的部分
						else if (Cards.get(i).getcardOrder()%9==1)
						{
							//2的話如果沒有3就打掉
							if (CardNumber[Cards.get(i).getcardOrder()+1]==0)
								return ReturnedValue(Cards.get(i));
							else continue;
						}
						
						//數字為8的部分
						else if (Cards.get(i).getcardOrder()%9==7)
						{
							//8的話沒有7就打掉
							if (CardNumber[Cards.get(i).getcardOrder()-1]==0)
								return ReturnedValue(Cards.get(i));
							else continue;
						}
						
						else
						{
							if (
								CardNumber[Cards.get(i).getcardOrder()-1]==0 &&
								CardNumber[Cards.get(i).getcardOrder()+1]==0)
								return ReturnedValue(Cards.get(i));
							else continue;
						}
					}
				}
				
				
		/*
		 * 會到這裡來的就只剩對子 or 缺兩頭
		 */
		
		//第五輪: 打掉不是對子的
		for (int i=0; i<Cards.size(); i++)
		{
			if (copy_CardTypeNumber[Cards.get(i).getcardOrder()]==2) continue;
			else return ReturnedValue(Cards.get(i));
			
		}
		
		//再來會到這裡的就是拔掉刻子和順子之後全部都是對子的牌型了
		
		return ReturnedValue(Cards.get(0));
	}
	
	public int ReturnedValue(mahjong m) {
		int index=-1;
		for (int i=0; i<PlayerCards.size(); i++) {
			if (m.getcardOrder() == PlayerCards.get(i).getcardOrder())
			{
				index=i;
				break;
			}
				
		}
		System.out.println("丟進來的牌為: " + m.getName());
		System.out.println("ReturnedValue: " + index);
		return index;
		
	}
	
	//聽牌
	public boolean TingPai(ArrayList<mahjong> a, String[] CardTypeList) {
	PlayerTingCards.clear();
	ArrayList<mahjong> PlayerCardsClone = new ArrayList<mahjong>();
	createmahjong create = new createmahjong();
	
	for (int i=0; i<a.size(); i++)
	{
		PlayerCardsClone.add(a.get(i));
	}
	
	for (int i=0; i<34; i++)
	{
		
		mahjong m = create.createmahjong(i*4+1);
		PlayerCardsClone.add(m);
		
		if (this.HuAble(PlayerCardsClone, CardTypeList)) 
			{
				PlayerTingCards.add(m);
			}
		
		PlayerCardsClone.remove(m);
		
//		for (int j=0; j<PlayerCardsClone.size(); j++)
//		{
//			System.out.print(PlayerCardsClone.get(j).getName() + " ");
//		}
		//System.out.println();
	}
	
	if (PlayerTingCards.size()!=0) return true;
	else return false;
	}
	
	public boolean RiChiable(String[] CardTypeList) {
		PlayerRichiOptions.clear();
		if (ChiPongGangCards.size()!=0 && this.SelfGangCardsInOrder.size()==0) return false;
		else {
			ArrayList<mahjong> PlayerCardsClone = new ArrayList<mahjong>();
			
			for (int i=0; i<PlayerCards.size(); i++)
			{
				PlayerCardsClone.add(PlayerCards.get(i));
			}
			
			for (int i=0; i<14; i++)
			{
				mahjong m = PlayerCardsClone.get(0);
				PlayerCardsClone.remove(0);
				
				if (this.TingPai(PlayerCardsClone, CardTypeList))
				{
					this.PlayerRichiOptions.add(m);
				}
				
				PlayerCardsClone.add(m);
			}
			
			for (int i=0; i<PlayerRichiOptions.size(); i++)
			{
				System.out.print(PlayerRichiOptions.get(i).getName());
			}
			if (this.PlayerRichiOptions.size()==0) return false;
			else return true;
		}
	}
//	public static void main(String[] args) {
//		String[] CardTypeList = {"1萬", "2萬", "3萬", "4萬", "5萬", "6萬", "7萬", "8萬", "9萬",
//				"1筒", "2筒", "3筒", "4筒", "5筒", "6筒", "7筒", "8筒", "9筒",
//				"1條", "2條", "3條", "4條", "5條", "6條", "7條", "8條", "9條",
//				"東風", "南風", "西風", "北風", "紅中", "發財", "白板"};
//		
//		Player player = new Player();
//		createmahjong create = new createmahjong();
//		mapmahjong map = new mapmahjong();
//		
//		map.createmahjong(); //做一副牌
//		
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(0)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(4)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(8)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(12)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(16)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(20)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(24)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(28)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(32)));
//		
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(36)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(40)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(44)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(45)));
//		player.PlayerCards.add(create.createmahjong(map.KeyAndNames.get(48)));
//		
//		System.out.print(HuAble(player.PlayerCards, CardTypeList));
//	}
}
