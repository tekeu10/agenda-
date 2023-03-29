package viewextends;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Date;
import javax.accessibility.AccessibleContext;
import javax.swing.*;


public class Cell extends JButton {
    
    private Date date;
    private boolean title;
    private boolean istoday;
    
    
    public Cell(){
        setContentAreaFilled(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
    }
    public void astitle(){
       title=true;
    }
    public boolean istitle(){
        return title;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public void currentMonth(boolean act){
        if(act){
            setForeground(new Color(68, 68, 68));
        }else{
            setForeground(new Color(169, 169, 169));
        }
    }
    public void setAsToDay(){
        istoday = true;
        setForeground(Color.WHITE);
    }
    @Override
    protected void paintComponent(Graphics g) {
        if(title){
            g.setColor(new Color(213, 213, 213));
            g.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
        }
        if(istoday){
            Graphics2D g2=(Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(97,49,237));
            int x = getWidth() / 2 - 15;
            int y = getHeight() / 2 - 15;
            g2.fillRoundRect(x,y, 30, 30, 100, 100);
        }
        super.paintComponent(g);
    }
      
}
