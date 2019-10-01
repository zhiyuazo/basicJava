package util;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.Border;
 
public class CircleProgressBar extends JPanel {
 
    private int minimumProgress;
 
    private int maximumProgress;
 
    private int progress;
 
    private String progressText;
 
    private Color backgroundColor;
 
    private Color foregroundColor;
 
    public CircleProgressBar() {
        minimumProgress = 0;
        maximumProgress = 100;
        progressText = "0%";
    }
 
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2d = (Graphics2D) g;
        // ���������
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        int fontSize = 0;
        if (getWidth() >= getHeight()) {
            x = (getWidth() - getHeight()) / 2 + 25;
            y = 25;
            width = getHeight() - 50;
            height = getHeight() - 50;
            fontSize = getWidth() / 8;
        } else {
            x = 25;
            y = (getHeight() - getWidth()) / 2 + 25;
            width = getWidth() - 50;
            height = getWidth() - 50;
            fontSize = getHeight() / 8;
        }
        graphics2d.setStroke(new BasicStroke(20.0f));
        graphics2d.setColor(backgroundColor);
        graphics2d.drawArc(x, y, width, height, 0, 360);
        graphics2d.setColor(foregroundColor);
        graphics2d.drawArc(x, y, width, height, 90,
                -(int) (360 * ((progress * 1.0) / (maximumProgress - minimumProgress))));
        graphics2d.setFont(new Font("����", Font.BOLD, fontSize));
        FontMetrics fontMetrics = graphics2d.getFontMetrics();
        int digitalWidth = fontMetrics.stringWidth(progressText);
        int digitalAscent = fontMetrics.getAscent();
        graphics2d.setColor(foregroundColor);
        graphics2d.drawString(progressText, getWidth() / 2 - digitalWidth / 2, getHeight() / 2 + digitalAscent / 2);
    }
 
    public int getProgress() {
        return progress;
    }
 
    public void setProgress(int progress) {
        if (progress >= minimumProgress && progress <= maximumProgress)
            this.progress = progress;
        if (progress > maximumProgress)
            this.progress = maximumProgress;
 
        this.progressText = String.valueOf(progress + "%");
 
        this.repaint();
    }
 
    public Color getBackgroundColor() {
        return backgroundColor;
    }
 
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.repaint();
    }
 
    public Color getForegroundColor() {
        return foregroundColor;
    }
 
    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        this.repaint();
    }
    
    
    public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("����Բ�ν�����");
		f.setSize(500,500);
		f.setLocation(300,300);
		f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CircleProgressBar cpb = new CircleProgressBar();
		cpb.setProgress(0);
		JButton  b = new JButton();
		b.setPreferredSize(new Dimension(120,80));
		f.add(cpb,BorderLayout.CENTER);
		f.add(b,BorderLayout.SOUTH);
		f.setVisible(true);
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SwingWorker() {
					@Override
					protected Object doInBackground() throws Exception {
						for(int i = 0 ; i <100; i ++) {
							cpb.setProgress(i+1);
							cpb.setForeground(ColorUtil.getByPercentage(i+1));
							Thread.sleep(100);
						}
						return null;
					}
				}.execute();
			}
		});
	}
}