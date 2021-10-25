package polymorphism3;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv = TVFactory.getTV(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
