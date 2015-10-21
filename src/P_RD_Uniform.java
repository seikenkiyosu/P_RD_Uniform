import java.util.Random;

public class P_RD_Uniform {
	public static final int 
//		FIELD_SIZE = 100,				//フィールドサイズ
		REMOVE_LINK_PROBABILITY = 50,	//ランダムの場合に何％でリンクを消すか
//		DISTANCE_FOR_INTERACTION = 1, 	//交流するための距離
		
		N = 1000,						//個体数の上限値
		Delta = 30,						//最大次数の上限値 
		
		n = 50,							//個体数
		delta = 4,						//グラフの最大次数
		s = 12,							//タイマの上限値
	
		t_max = 50,					//ライフタイマの上限値
		t_virus = 20,					//ウイルスタイマの上限値
		t_shld = 100;					//シールドタイマの上限値
	
	public static void main (String args[]) {
		//初期化
		Graph graph = new Graph(n, Graph.RANDOM);
		Agent[] agent = new Agent[n];
		for (int i = 0; i < n; i++) agent[i] = new Agent();
		

//		graph.ShowGraph();
		
		int CT = 0, HT = 0;
		boolean CT_count_flag = true, HT_count_flag = false;
		
		while (true) {
			int leadercounter = 0;
			for (int i = 0; i < n; i++) {
				if (agent[i].IsLeader()) leadercounter++;
			}
//			System.out.println("the number of leaders = " + leadercounter);
			
			
			
			
			
			if (leadercounter == 1) { 
				if (CT_count_flag) System.out.println("CT = " + CT);
				CT_count_flag = false; 
				HT_count_flag = true; 
				break;
			}
			
//			if (IsSafeConfiguration(agent)) { 
//				if (CT_count_flag) System.out.println("CT = " + CT);
//				CT_count_flag = false; 
//				HT_count_flag = true; 
//				break;
//			}
			
			//維持時間終了
			if (!CT_count_flag && leadercounter != 1) { 
				break; 
			}
//			if (!CT_count_flag && !IsSafeConfiguration(agent)) { 
//				break; 
//			}
			
			
			
			
			
			
			//initiatorとresponderを決める
			Random R = new Random();
			int initiator = -1, responder = -1;
			while (initiator == responder) { 
				initiator = R.nextInt(n);
				responder = R.nextInt(n);
			}
			
			//交流できるなら交流
			if (graph.List[initiator][responder]) {
				Interaction.interaction(agent[initiator], agent[responder]);
				if (CT_count_flag) CT++;
				if (HT_count_flag) HT++;
			}
		}

		System.out.println("HT = " + HT);

	}
	
	
	//安定状況かの判別
//	private static boolean IsSafeConfiguration(Agent agent[]){
//		//最小のidとそのノードを見つける
//		int min = LID_MAX+1;
//		Agent v_min = null;
//		for (int i = 0; i < n; i++) 
//			if (min > agent[i].var) {
//				min = agent[i].var;
//				v_min = agent[i];
//			}
//		
//		//v.lid = id(v_min)かどうか
//		for(int i=0; i < n; i++) 
//			if (agent[i].lid != v_min.var) {
////				for( int j = 0; j < n; j++) System.out.print(agent[j].lid + "\t");
////				System.out.println("\n");
//				return false; 
//			}
//		
//		//セーフタイムかどうか
//		for(int i=0; i < n; i++)
//			if(agent[i].timer < n/2){
//				return false;
//			}
//		
//		//v_min.timer = t_maxかどうか
//		if (v_min.timer != s) {
//			return false; 
//		}
//		
//		//全部条件満たしてたらtrueを返す
//		return true;
//	}
	
//	//距離を返す
//	private static double distance (Agent initiator, Agent responder) {
//		return Math.sqrt( (initiator.x - responder.x)*(initiator.x - responder.x)-(initiator.y - responder.y)*(initiator.y - responder.y) );
//	}
}
