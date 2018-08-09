package cn.dw.oa.demo;

public class SequenceNumber {

	private Integer seqNum = 0;
	
	public void setSeqNum(Integer seqNum) {
		this.seqNum = seqNum;
	}
	
	public Integer getSeqNum() {
		return seqNum;
	}
	
	public int getNextNum() {
		return ++seqNum;
	}
	
	public static void main(String[] args) {
		SequenceNumber sequenceNumber = new SequenceNumber();
		TestClient testClient1 = new TestClient(sequenceNumber);
		TestClient testClient2 = new TestClient(sequenceNumber);
		TestClient testClient3 = new TestClient(sequenceNumber);
		testClient1.start();
		testClient2.start();
		testClient3.start();
	}
	
	private static class TestClient extends Thread {
		
		private SequenceNumber sn;
		public TestClient(SequenceNumber sn) {
			this.sn = sn;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + sn.getNextNum());
			}
		}
		
	}

}
