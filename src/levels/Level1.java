package levels;

import components.BackgroundLarge;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import components.Component;
import components.Crystal;
import components.Platform1;
import components.Platform2;
import components.Platform3;

import java.util.ArrayList;

public class Level1 extends JPanel {
	private JLayeredPane lp;
	private BackgroundLarge bg;
	private ArrayList<Component> platforms;

	public Level1() {
		super();
		this.setLayout(null);
		this.setBounds(0, 0, 2400, 600);

		this.lp = new JLayeredPane();
		this.bg = new BackgroundLarge();

		this.lp.setBounds(0, 0, 2400, 600);
		this.lp.add(bg, JLayeredPane.DEFAULT_LAYER);

		platforms = new ArrayList<>();
		platforms.add(new Platform2(80, 480)); //1
		platforms.add(new Platform1(300, 380)); //2
		platforms.add(new Platform3(480, 460));//3
		platforms.add(new Platform1(580, 230));//4
		platforms.add(new Platform2(700, 400));//5

		platforms.add(new Platform3(1000, 460));//6
		platforms.add(new Platform1(890, 300));//7
		platforms.add(new Platform1(1300, 400));//8
		platforms.add(new Platform3(1140, 200));//9
		platforms.add(new Platform1(1450, 270));//10
		platforms.add(new Platform2(1750, 360));//11
		platforms.add(new Platform2(2050, 300));//12

		platforms.add(new Crystal(605, 200));//cr1 4
		platforms.add(new Crystal(1090, 400));//cr2 6
		platforms.add(new Crystal(1500, 270));//cr3 10
		platforms.add(new Crystal(2140, 300));//cr4 12

		for (Component c : platforms) {
			lp.add(c, JLayeredPane.PALETTE_LAYER);
		}

		this.add(lp);
	}


	public ArrayList<Component> getPlatforms() {
		return platforms;
	}
}