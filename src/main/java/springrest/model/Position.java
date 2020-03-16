package springrest.model;

public enum Position {
	STUDENT ("student"),
	FACULTY ("faculty"),
	STAFF   ("staff")
	;
	
	private final String positionValue;
	
	Position(String positionValue) {
		this.positionValue = positionValue;
	}
	
	public String getPosition() {
		return this.positionValue;
	}
	
}
