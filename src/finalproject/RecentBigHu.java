package finalproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class RecentBigHu {
	ArrayList<Integer> BigHuCards = new ArrayList<>();
	ArrayList<Integer> ChiPongGangCards = new ArrayList<>();
	ArrayList<String> Yaku = new ArrayList<>();
	ArrayList<String> hanList = new ArrayList<>();
	int han=0;
	int thelastone = -1;
	YakuCalc BigHuCalc;
	String inputstring = "";
	String outputstring = "";
	int highesthan = 0;
	
	
	void setyakucalc(YakuCalc YakuCalc) {
		this.BigHuCalc = YakuCalc;
	}
	
	void setoutputstring() {
		//も礟 -1 窱篵礟 -1 も礟程眎礟 -1 场贺 -1 场礷计 -1 羆礷计
		for (int i=0; i<BigHuCalc.player.PlayerCards.size()-1; i++)
		{
			outputstring = outputstring + BigHuCalc.player.PlayerCards.get(i).getcardOrder() + " ";
		}
		
		outputstring = outputstring + "-1 ";
		
		for (int i=0; i<BigHuCalc.player.ChiPongGangCards.size()-1; i++)
		{
			outputstring = outputstring + BigHuCalc.player.ChiPongGangCards.get(i).getcardOrder() + " ";
		}
		
		outputstring = outputstring + "-1 ";
		
		outputstring = outputstring + BigHuCalc.player.PlayerCards.get(BigHuCalc.player.PlayerCards.size()-1).getcardOrder() + " -1 ";
		
		
		for (int i=0; i<BigHuCalc.Yaku.size(); i++)
		{
			outputstring = outputstring + BigHuCalc.Yaku.get(i) + " ";
		}
		
		outputstring = outputstring + "-1 ";
		
		for (int i=0; i<BigHuCalc.HanList.size(); i++)
		{
			outputstring = outputstring + BigHuCalc.HanList.get(i) + " ";
		}
		
		outputstring = outputstring + "-1 ";
		
		outputstring = outputstring + BigHuCalc.han;
		
	}
	
	void input() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Lee\\\\Desktop\\\\Java盡\\\\final\\\\src\\\\finalproject\\\\bighu.txt");  //硂柑块翴
		byte[] allbytes = fis.readAllBytes();
		fis.close();
		inputstring = new String(allbytes, "UTF-8");
		String[] contentArr = inputstring.split(" ");
		
		if(contentArr[0].length()-2>=0) 
		{
		if(contentArr[0].charAt(contentArr[0].length()-2)>='0' && contentArr[0].charAt(contentArr[0].length()-2)<='9' )
			contentArr[0] = contentArr[0].substring(contentArr[0].length()-2);
		else
			contentArr[0] = contentArr[0].substring(contentArr[0].length()-1);
		
		}
		else
			contentArr[0] = contentArr[0].substring(contentArr[0].length()-1);
		
		System.out.print("и琌0" + contentArr[0]);
		
		for (int i=0; i<contentArr.length; i++)
		{
			System.out.print("HEY" + contentArr + " ");
		}
		for (int i=0; i<contentArr.length; i++)
		{
			System.out.print(contentArr[i] + "\n");
		}
		
		this.highesthan = Integer.valueOf(contentArr[contentArr.length-1]);
		int index=0;
		
		//も礟
		for (int i=index; i<contentArr.length; i++)
		{
			if (Integer.valueOf(contentArr[i])==-1)
			{
				index=i+1;
				break;
			}
			else
			this.BigHuCards.add(Integer.valueOf(contentArr[i]));
		}
		
		//窱礟
		for (int i=index; i<contentArr.length; i++)
		{
			if (Integer.valueOf(contentArr[i])==-1)
			{
				index=i+2;
				break;
			}
			else
			this.ChiPongGangCards.add(Integer.valueOf(contentArr[i]));
		}
		
		thelastone = Integer.valueOf(contentArr[index-1]);
		//contentArr[14]琌程眎も礟
		//+yaku
		for (int i=index; i<contentArr.length; i++)
		{
			if (contentArr[i].equals("-1"))
			{
				index=i+1;
				break;
			}
			else
			this.Yaku.add(contentArr[i]);
		}
		
		//+han
		for (int i=index; i<contentArr.length; i++)
		{
			if (contentArr[i].equals("-1"))
			{
				index=i+1;
				break;
			}
			else
			this.hanList.add(contentArr[i]);
		}
		
		han=Integer.valueOf(contentArr[contentArr.length-1]);
		
		for (int i=0; i<Yaku.size(); i++)
		{
			System.out.println(Yaku.get(i));
		}
	}
	
	void output() throws IOException {
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Lee\\Desktop\\Java盡\\final\\src\\finalproject\\bighu.txt"); //硂柑块翴
		
		
		String[] outputstringarr = outputstring.split("\n"); 
		
		for (int i=0; i<outputstringarr.length; i++)
		{
			fos.write(outputstringarr[i].getBytes("UTF-8"));
		}
		fos.close();
	}
}
