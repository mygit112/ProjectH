package GUI.component;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MenuComponent {
	private String icon;
	private String name;
	private MenuType type;
	
	public MenuComponent(String icon, String name, MenuType type) {
		this.icon = icon;
		this.name = name;
		this.type = type;
	}
	
	public MenuComponent() {}
	
	public static enum MenuType{
		TITLE, MENU, EMPTY
	}

	public String getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}

	public MenuType getType() {
		return type;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(MenuType type) {
		this.type = type;
	}
	
	public Icon toIcon() {
		// return new ImageIcon(getClass().getResource("C:\\Users\\Admin\\Desktop\\doctor.png"));
		return new ImageIcon(getClass().getResource("/Entity/" + icon + ".png"));
	}
	
	
}
