//import java.util.Random;
//
//interface notepadPlugin {
//	void Init();
//	void Play();
//	void Stop();
//}
//
//class RandomNumber implements notepadPlugin {
//
//	@Override
//	public void Init() {
//		System.out.println("i nitiate.");
//		
//	}
//
//	@Override
//	public void Play() {
//		System.out.println("Make Number.");
//		makeRandomNumber();
//		
//	}
//
//	@Override
//	public void Stop() {
//		System.out.println("stop.");
//		
//	}
//	
//	private void makeRandomNumber() {
//		Random rd = new Random();
//		int number = rd.nextInt(100);
//		System.out.println(number);
//	}
//}
//
//public class InterfacePrac {
//
//	public static void main(String[] args) {
//		notepadPlugin[] pads = new notepadPlugin[10];
//		pads[0] = new RandomNumber();
//		pads[0].Init();
//		pads[0].Play();
//		pads[0].Stop();
//		
//
//	}
//
//}
