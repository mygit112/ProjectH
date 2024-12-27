package GUI.component;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

import GUI.Panel.MenuItem;
import Model.EventMenuSelected;

public class ListMenu<E extends Object> extends JList<E> {
	
	private final DefaultListModel model;
	private int selectedIndex = -1;
	private int overIndex = -1;
	private EventMenuSelected event;
	
	public void addEventMenuSelected(EventMenuSelected event) {
		this.event = event;
	}
	
	public ListMenu() {
		model = new DefaultListModel<E>();
		setModel(model);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 if (SwingUtilities.isLeftMouseButton(e)) {
					 int index = locationToIndex(e.getPoint());
					 Object o = model.getElementAt(index);
					 if (o instanceof MenuComponent) {
						 MenuComponent menu = (MenuComponent) o;
						 if (menu.getType() == MenuComponent.MenuType.MENU) {
							 selectedIndex = index;
							 if(event != null) {
								 event.selected(index);
							 }
						 }
					 } else {
						 selectedIndex = index;
					 }
					 repaint();
				 }
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				overIndex = -1;
				repaint();
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				int index = locationToIndex(e.getPoint());
				if(index != overIndex) {
					Object o = model.getElementAt(index);
					if(o instanceof MenuComponent) {
						MenuComponent menu = (MenuComponent) o;
						if(menu.getType() == MenuComponent.MenuType.MENU) {
							overIndex = index;
						}else {
							overIndex = -1;
						}
						repaint();
					}
				}
			}
		});
	}
	
	public ListCellRenderer<? super E> getCellRenderer(){
		return new DefaultListCellRenderer() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				MenuComponent data;
				if(value instanceof MenuComponent) {
					data = (MenuComponent) value;
				}else {
					data = new MenuComponent("", value + "", MenuComponent.MenuType.EMPTY);
				}
				MenuItem item = new MenuItem(data);
				item.setSelected(selectedIndex == index);
				item.setOver(overIndex == index);
				return item;
			}
		};
	}
	
	public void addItem(MenuComponent data) {
		model.addElement(data);
	}
}
