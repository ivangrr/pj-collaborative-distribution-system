package models;

import java.util.List;

public class Demand {
	public String code;
	public String name;
	public String description;
	public List<String> demandBy;
	@Override
	public String toString() {
		return "Demand [code=" + code + ", name=" + name + ", description="
				+ description + ", demandBy=" + demandBy + "]";
	}
}
