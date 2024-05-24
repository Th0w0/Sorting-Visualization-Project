package OOP.Group2.Visualizer.graphicsElements.canvas;

import java.awt.Canvas;
import java.awt.Graphics;

import OOP.Group2.Visualizer.graphicsElements.color.colorConcept;
public class myCanvas extends Canvas{
    public static final long serialVersionUID = 2L;

	private VisualizerProvider listener;

	public myCanvas(VisualizerProvider listener){
		super();
		this.listener = listener;
	}

    public void paint(Graphics g)
    {
        super.paint(g);
		clear(g);

		listener.onDrawArray();
    }


	public void clear(Graphics g)
	{
		g.setColor(colorConcept.CANVAS_BACKGROUND);
        g.fillRect(0, 0, getWidth(), getHeight());
	}


	public interface VisualizerProvider
	{
		void onDrawArray();
	}

}
