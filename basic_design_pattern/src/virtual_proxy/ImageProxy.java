package virtual_proxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageProxy implements Icon{
	ImageIcon  imgIcon;
	URL imgURL;
	Thread retrievalThread;
	boolean retrieving = false;  
	
	public ImageProxy(URL url) {
		imgURL = url;
	}
	
	
	public int getIconWidth() {
		if(imgIcon !=null) {
			return imgIcon.getIconWidth();
		}else {
			return 800;
		}
	}
	
	public int getIconHeight() {
		if(imgIcon !=null) {
			return imgIcon.getIconHeight();
		}else {
			return 600;
		}
	}
	
	public void paintIcon(final  Component c , Graphics g, int x , int y) {
		if(imgIcon != null) {
			imgIcon.paintIcon(c, g, x, y);
		}else {
			g.drawString("Loading CD cover, Please  wait....", x+300, y+190);
			if(!retrieving) {
				retrieving = true ; 
				retrievalThread = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							imgIcon = new ImageIcon(imgURL,"CD Cover");
							c.repaint();
						}catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				});
				retrievalThread.start();
			}
		}
	}

}
