package finalproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*��±N��136�i�s�imap�̭�
 * 
 * 
 */

public class mapmahjong {
	public Map<Integer, String> mahjongmap = new HashMap<Integer, String>();
 	public ArrayList<Integer> KeyAndNames = new ArrayList<Integer>();
	/*
	 * �ͦ��@�Ƴ±N
	 */
	void createmahjong() {

 	mahjongmap.clear();
 	KeyAndNames.clear();
 	
	int keynumber=0;
	String[] dazhi = {"�F��", "�n��", "�護", "�_��", "����", "�o�]", "�ե�"};
	
	for (int i=1; i<10; i++)
	{
		for (int j=0; j<4; j++)
		{
			String type = "�U";
			mahjongmap.put(++keynumber, i + type + j);
		}
	}
	
	for (int i=1; i<10; i++)
	{
		for (int j=0; j<4; j++)
		{
			
			String type = "��";
			mahjongmap.put(++keynumber, i + type + j);
		}
	}
	
	for (int i=1; i<10; i++)
	{
		for (int j=0; j<4; j++)
		{
			String type = "��";
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
	 * �åB��L�[�iKeyAndNames�o��ArrayList�̭�
	 * KeyAndNames�����O�OInteger
	 */
	
		KeyAndNames.addAll(mahjongmap.keySet());
		
		//�M��~�P
		
		
	}
	
	public void ShuffleMap()
	{
		Collections.shuffle(KeyAndNames);
	}

		

}
