package OOP.Group2.Visualizer.graphicsElements.bars;
//Each bar = cột trong frame
import java.awt.Color;
import java.awt.Graphics;

import OOP.Group2.Visualizer.graphicsElements.color.colorConcept;

public class bars {
    private final int MARGIN = 1;
	private int x, y, width, value;
	private Color color;

	// y: the bottom left corner
	public bars(int x, int y, int width, int value, Color color)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.value = value;
		this.color = color;
	}


	public void draw(Graphics g)
	{
		g.setColor(color);
		g.fillRect(x + MARGIN, y-value, width - MARGIN * 2, value);
	}


	public void clear(Graphics g)
	{
		// clear the space
		g.setColor(colorConcept.CANVAS_BACKGROUND);
		g.fillRect(x + MARGIN, y-value, width - MARGIN * 2, value);
	}


	public void setValue(int value) { this.value = value; }

	public int getValue() { return value; }

	public void setColor(Color color) { this.color = color; }

	public Color getColor() { return color; }
}
