package factory.before;

public class Customer {
	private String name;
	private Long arrivedAt;
	private Long fixTime;

	private Long waitTime;

	public Customer(String name, Long arrivedAt, Long fixTime) {
		this.name = name;
		this.arrivedAt = arrivedAt;
		this.fixTime = fixTime;
	}

	public String getName() {
		return name;
	}

	public Long getArrivedAt() {
		return arrivedAt;
	}

	public Long getFixTime() {
		return fixTime;
	}

	public Long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(Long waitTime) {
		this.waitTime = waitTime;
	}

	@Override
	public String toString() {
		return name + ", 도착 시간: "
			+ arrivedAt + "분, 소요시간: "
			+ fixTime;
	}
}
