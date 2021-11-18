package polymorphism3;

public class TVUser {

	public static void main(String[] args) {
		TV tv = TVFactory.getTV(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}

}
