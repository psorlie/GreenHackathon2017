package greenHackaton2017.java.model;

public class Day {
	private Integer opening;
	private Integer closing;
	
	public Day(Integer opening, Integer closing){
		this.opening = opening;
		this.closing = closing;
	}
	
	public Integer getOpening() {
		return this.opening;
	}
	
	public Integer getClosing() {
		return this.closing;
	}
	
	public void setOpening(Integer opening) {
		this.opening = opening;
	}
	
	public void setClosing(Integer closing) {
		this.closing = closing;
	}
}
