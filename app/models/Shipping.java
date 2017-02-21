package models;

public class Shipping {
	public String code;
	public String name;
	public String description;
	public String type;
	
	@Override
	public String toString() {
		return "Shipping [code=" + code + ", name=" + name + ", description="
				+ description + ", type=" + type + "]";
	}
}
