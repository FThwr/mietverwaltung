package menu;

import action.Action;

public class MenuEntry {
	
	private String name;
	private String [] location = null; // Array der Untermenuepunkte
	private Action action = null;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getLocation() {
		return location;
	}

	public void setLocation(String[] location) {
		this.location = location;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public MenuEntry (String name, String [] location) {
		this.name = name;
		this.location = location; // Untermenuepunkte
	}
	
	public MenuEntry (String name, Action action) {
		this.name = name;
		this.action = action;
	}

}
