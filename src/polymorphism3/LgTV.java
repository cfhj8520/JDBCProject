package polymorphism3;

public class LgTV implements TV{
	public LgTV() {
		System.out.println("LgTV ��ü ����");
	}
	public void powerOn() {
		System.out.println("LgTV ���� Ű��");
	}
	public void powerOff() {
		System.out.println("LgTV ���� ����");
		}
	public void volumeUp() {
		System.out.println("LgTV ���� Ű���");
	}
	public void volumeDown() {
		System.out.println("LgTV ���� ���̱�");
	}
}
