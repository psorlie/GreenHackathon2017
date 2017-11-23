package greenHackaton2017.java.model;

public class Day {
	private Integer opening;
	private Integer closing;
	
	public Day(Integer opening, Integer closing){
		this.opening = opening;
		this.closing = closing;
	}
	
	public int getOpening() {
		return this.opening;
	}
	
	public int getClosing() {
		return this.closing;
	}
	
	public void setOpening(int opening) {
		this.opening = opening;
	}
	
	public void setClosing(int closing) {
		this.closing = closing;
	}
}
