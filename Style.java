import java.awt.*;
import java.awt.event.*;

class Style extends Frame
{
	int type=Font.PLAIN,s=14;
	String f= "";
    String [] size = { "14", "16", "18", "20", "22", "24","28" };
	String [] fontp = { "Arial" , "TimesRoman", "Courier"  };
	Label lbl1 = new Label("Select the size");
	Label lbl2 = new Label("Select font-type");
	Checkbox chkbold = new Checkbox("BOLD");
	Checkbox chkitalic = new Checkbox("ITALIC");
	Choice chsize = new Choice();
	Choice chfont = new Choice();
	Label lblmsg = new Label("Text Demo");
	
	Style()
	{
		super("Styling the text");
		setLayout(null);
		lbl1.setBounds(50,50,100,50);
		lbl2.setBounds(200,50,100,50);
		chsize.setBounds(50,120,100,50);
		chfont.setBounds(200,120,100,50);
		chkbold.setBounds(80,150,80,40);
		chkitalic.setBounds(80,200,80,40);
		lblmsg.setBounds(100,250,200,200);
		Font g = new Font(f,type,s);
		lblmsg.setFont( g );
		
		add(lbl1);
		add(lbl2);
		add(chsize);
		add(chfont);
		add(lblmsg);
		add(chkbold);
		add(chkitalic);
		
		for(int i=0;i<size.length;i++)
			chsize.add(size[i]);
		
		for(int i=0;i<fontp.length;i++)
			chfont.add(fontp[i]);
		
		chsize.addItemListener( new ListListener() );
		chfont.addItemListener( new ListListener() );
		chkbold.addItemListener( new ListListener() );
		chkitalic.addItemListener( new ListListener() );
		addWindowListener(new Win());
		
		setSize(500,500);
		setVisible(true);
	}
	
	class ListListener implements ItemListener
	{
	public void itemStateChanged(ItemEvent ev)
	{
				String si=chsize.getSelectedItem();
				String fo=chfont.getSelectedItem();
				s=Integer.parseInt(si);
				f=fo;
				
				if(chkbold.getState() && chkitalic.getState())
				{
					type=Font.BOLD+Font.ITALIC;
				}
				else if(chkbold.getState())
				{
					type=Font.BOLD;
				}
				else if(chkitalic.getState())
				{
					type=Font.ITALIC;
				}
				else
				{
					type=Font.PLAIN;
				}
					
			Font g = new Font(f,type,s);
			lblmsg.setFont( g );
		}
	}
	
	class Win extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args )
	{
		Style k = new Style();
	}
}