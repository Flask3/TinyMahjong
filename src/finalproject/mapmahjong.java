package finalproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*把麻將的136張存進map裡面
 * 
 * 
 */

public class mapmahjong {
	public Map<Integer, String> mahjongmap = new HashMap<Integer, String>();
 	public ArrayList<Integer> KeyAndNames = new ArrayList<Integer>();
	/*
	 * 生成一副麻將
	 */
	void createmahjong() {

 	mahjongmap.clear();
 	KeyAndNames.clear();
 	
	int keynumber=0;
	String[] dazhi = {"東風", "南風", "西風", "北風", "紅中", "發財", "白皮"};
	
	for (int i=1; i<10; i++)
	{
		for (int j=0; j<4; j++)
		{
			String type = "萬";
			mahjongmap.put(++keynumber, i + type + j);
		}
	}
	
	for (int i=1; i<10; i++)
	{
		for (int j=0; j<4; j++)
		{
			
			String type = "筒";
			mahjongmap.put(++keynumber, i + type + j);
		}
	}
	
	for (int i=1; i<10; i++)
	{
		for (int j=0; j<4; j++)
		{
			String type = "條";
			mahjongmap.put(++keynumber, i + type + j);
		}
	}
	
	for (int i=0; i<7; i++)
	{
		for (int j=0; j<4; j++)
		{
			mahjongmap.put(++keynumber, dazhi[i] + j);
		}
	}
	/*
	 * 並且把他加進KeyAndNames這個ArrayList裡面
	 * KeyAndNames的型別是Integer
	 */
	
		KeyAndNames.addAll(mahjongmap.keySet());
		
		//然後洗牌
		
		
	}
	
	public void ShuffleMap()
	{
		Collections.shuffle(KeyAndNames);
	}

		

}
