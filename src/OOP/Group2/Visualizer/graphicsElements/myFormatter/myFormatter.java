package OOP.Group2.Visualizer.graphicsElements.myFormatter;

import javax.swing.text.NumberFormatter;
import java.text.ParseException;
import java.text.NumberFormat;

public class myFormatter extends NumberFormatter {


	public static final long serialVersionUID = 1L;

	public myFormatter(NumberFormat format)
	{
		super(format);
	}

	public Object stringToValue(String text) throws ParseException
	{
		if ("".equals(text))
			return 0;
		return super.stringToValue(text);
	}


}
