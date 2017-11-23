package greenHackaton2017.java.model;

public class OpeningHours {
	
	final static int MAX_DAY = 5;
	
	private Day[] days = new Day[MAX_DAY];
	
	public synchronized void setDay(int dayNumber, Day day) {
		this.days[dayNumber].setOpening(day.getOpening());
		this.days[dayNumber].setClosing(day.getClosing());
	}
	
	public Day getDay(int dayNumber) {
		return this.days[dayNumber];
	}
	
	public synchronized void setOpeningHourForDay(Day day, int horaire) {
		day.setOpening(horaire);
	}
	
	public Day dayBefore(int dayNumber) {
		int beforeDay = (dayNumber + 1) % MAX_DAY;
		return getDay(beforeDay);
	}
	
	public Day dayAfter(int dayNumber) {
		int afterDay = (dayNumber - 1) % MAX_DAY;
		return getDay(afterDay);
	}
}
