import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by edgar971 on 7/13/15.
 */
public class LinesPanel extends JPanel {
    //variables to hold the coordinate points
    private Point pointA = null, pointB;

    //constructor
    public LinesPanel() {
        //create new listener
        LineListener listener = new LineListener();
        //add mouse listener
        addMouseListener(listener);
        //add motion listener
        addMouseMotionListener(listener);

        //set bg color
        setBackground(Color.black);
        //set window size
        setPreferredSize(new Dimension(500, 300));

    }

    protected void paintComponent(Graphics page) {
        super.paintComponent(page);
        page.setColor(Color.yellow);
        //if the points are not null
        if(pointA != null && pointB != null) {
            //draw the line
            page.drawLine(pointA.x, pointA.y,pointB.x,pointB.y);
        }
    }

    private class LineListener implements MouseListener, MouseMotionListener {
        //capture the initial click

        public void mousePressed(MouseEvent event) {
            //get the point and assign it
            pointA = event.getPoint();
        }
        //get point b when dragged
        public void mouseDragged(MouseEvent event) {
            pointB = event.getPoint();
            //repaint the screen when dragged to display new line position
            repaint();
        }

        public void mouseClicked(MouseEvent event) {}
        public void mouseReleased(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
        public void mouseMoved(MouseEvent event) {}
    }
}
