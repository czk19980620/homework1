package geektime.concurrent.race;

import java.util.Arrays;

public class SimpleDivideCompute implements ComputeRunnable {

	SimpleShareData ssd;
	int size;
	int offset;
	public SimpleDivideCompute(SimpleShareData ssd, int size, int offset) {
		this.ssd = ssd;
		this.size = size;
		this.offset = offset;
	}
	
	@Override
	public void run() {
		go();

	}

	@Override
	public void go() {
		System.out.println("开始计算随机数: " + size + " " + offset);
		ssd.getScore().subList(offset * size, offset * size + size).sort(null);
		ssd.getCompSig().countDown();;
		//System.out.println("计算随机数完毕: " + size + " " + SimpleShareData.BUFSIZE * size / SimpleShareData.COUNT);
	}
}
