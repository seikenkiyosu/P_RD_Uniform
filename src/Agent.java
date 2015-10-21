import java.util.Random;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Agent {
	public boolean DoA;	//生きてるか否か
	public int
		timer_L,	//Lifeのタイマ
		timer_v,	//virusのタイマ
		timer_s;	//shieldのタイマ
	
	public double 
		x,		//位置
		y,
		dx,		//速度
		dy;
	
	//コンストラクタ	
	public Agent () {
		Random R = new Random();
		//初期化
		DoA = R.nextBoolean();		//はじめに生きてるかはランダムに設定
		timer_L = R.nextInt(P_RD_Uniform.t_max);
		timer_v = R.nextInt(P_RD_Uniform.t_virus);
		timer_s = R.nextInt(P_RD_Uniform.t_shld);
	}

	//メソッド
	public boolean IsLeader () {
		return DoA ? true : false;
	}
	
	public void MoveAction () {

	}
}
