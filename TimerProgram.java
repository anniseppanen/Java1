public class Timer {
	private int minutes = 0;
	private int seconds = 0;
	public void addSeconds(int addition) {
		if (addition > 0 && addition < 59) {
			if (seconds + addition < 60) {
				seconds += addition;
			} else if (seconds + addition >= 60) {
				minutes += 1;
				seconds = seconds + addition - 60;
			}
		}
	}
	public void reset() {
		minutes = 0;
		seconds = 0;
	}
	public String toString() {
		if (seconds < 10) {
			return minutes + ":0" + seconds;
		} else {
			return minutes + ":" + seconds;
		}
	}
}

public class TimerProgram {
	public static void main(String[] args) {
		Timer t = new Timer();
		t.addSeconds(50);
		t.addSeconds(25);
		System.out.println(t);
		t.addSeconds(50);
		System.out.println(t);
		t.addSeconds(-3);
		t.addSeconds(65);
		System.out.println(t);
		t.reset();
		t.addSeconds(55);
		t.addSeconds(55);
		t.addSeconds(55);
		t.addSeconds(55);
		System.out.println(t);
	}
}
