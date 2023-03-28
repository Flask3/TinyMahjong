package finalproject;

public class createmahjong {

	public mahjong createmahjong(int a){
		mahjong Mahjong = new mahjong();
		
		Mahjong.order=a;
		
		
		String[] CardTypeList = {"1萬", "2萬", "3萬", "4萬", "5萬", "6萬", "7萬", "8萬", "9萬",
				"1筒", "2筒", "3筒", "4筒", "5筒", "6筒", "7筒", "8筒", "9筒",
				"1條", "2條", "3條", "4條", "5條", "6條", "7條", "8條", "9條",
				"東風", "南風", "西風", "北風", "紅中", "發財", "白板"};

			
			//設置數字
			if (1 <= a && a <= 4 || 37 <= a && a <= 40 || 73 <= a && a<= 76 )          Mahjong.number = 1;
			else if (5 <= a && a <= 8 || 41 <= a && a <= 44 || 77 <= a && a<= 80 )     Mahjong.number = 2;
			else if (9 <= a && a <= 12 || 45 <= a && a <= 48 || 81 <= a && a<= 84 )    Mahjong.number = 3;
			else if (13 <= a && a <= 16 || 49 <= a && a <= 52 || 85 <= a && a<= 88 )   Mahjong.number = 4;
			else if (17 <= a && a <= 20 || 53 <= a && a <= 56 || 89 <= a && a<= 92 )   Mahjong.number = 5;
			else if (21 <= a && a <= 24 || 57 <= a && a <= 60 || 93 <= a && a<= 96 )   Mahjong.number = 6;
			else if (25 <= a && a <= 28 || 61 <= a && a <= 64 || 97 <= a && a<= 100 )  Mahjong.number = 7;
			else if (29 <= a && a <= 32 || 65 <= a && a <= 68 || 101 <= a && a <= 104 )Mahjong.number = 8;
			else if (33 <= a && a <= 36 || 69 <= a && a <= 72 || 105 <= a && a<= 108 ) Mahjong.number = 9;
			else if (109 <= a && a<= 112) {Mahjong.number = -1; Mahjong.name = "東風";}
			else if (113 <= a && a<= 116) {Mahjong.number = -2; Mahjong.name = "南風";}
			else if (117 <= a && a<= 120) {Mahjong.number = -3;	Mahjong.name = "西風";}
			else if (121 <= a && a<= 124) {Mahjong.number = -4; Mahjong.name = "北風";}
			else if (125 <= a && a<= 128) {Mahjong.number = -5; Mahjong.name = "紅中";}
			else if (129 <= a && a<= 132) {Mahjong.number = -6; Mahjong.name = "發財";}
			else if (133 <= a && a<= 136) {Mahjong.number = -7; Mahjong.name = "白板";}
			
			//設置型別
			if (1<=a && a<=36)
				Mahjong.type = "萬";
			else if (37 <= a && a <= 72)
				Mahjong.type = "筒";
			else if (73 <= a && a <= 108)
				Mahjong.type = "條";
			else if (109 <= a && a<= 136)
				Mahjong.type = "風";
			
			//設置名字
			if (1<=a && a <=108)
				Mahjong.name = Mahjong.number + Mahjong.type;
			
			for (int i=0; i<34; i++) //check打出來的麻將的order
			{
				if (Mahjong.getName().equals(CardTypeList[i]))
				{
					Mahjong.cardOrder=i;
					break;
				}
			}
			
			return Mahjong;
		}
}
