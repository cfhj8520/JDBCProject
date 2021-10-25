package polymorphism3;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
	}
	public void powerOn() {
		System.out.println("SamsungTV 전원 키기");
	}
	public void powerOff() {
		System.out.println("SamsungTV 전원 끄기");
		}
	public void volumeUp() {
		System.out.println("SamsungTV 볼륨 키우기");
	}
	public void volumeDown() {
		System.out.println("SamsungTV 볼륨 줄이기");
	}
}
