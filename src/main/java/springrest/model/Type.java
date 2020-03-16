package springrest.model;

public enum Type {
	ADMIN ("admin"),
	USER ("user")
	;
	
	private final String typeValue;
	
	Type(String typeValue) {
		this.typeValue = typeValue;
	}
	
	public String getType() {
		return this.typeValue;
	}
}
