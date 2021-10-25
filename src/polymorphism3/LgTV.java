package polymorphism3;

public class LgTV implements TV{
	public LgTV() {
		System.out.println("LgTV 객체 생성");
	}
	public void powerOn() {
		System.out.println("LgTV 전원 키기");
	}
	public void powerOff() {
		System.out.println("LgTV 전원 끄기");
		}
	public void volumeUp() {
		System.out.println("LgTV 볼륨 키우기");
	}
	public void volumeDown() {
		System.out.println("LgTV 볼륨 줄이기");
	}
}
