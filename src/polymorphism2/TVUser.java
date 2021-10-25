package polymorphism2;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
