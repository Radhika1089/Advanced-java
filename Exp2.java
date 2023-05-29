package MouseEvents;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Exp2 implements MouseListener {
JLabel l;
Exp2(){
JFrame f = new JFrame("Mouse Events");
f.setSize(300,300);
f.setLayout(new FlowLayout());
f.setVisible(true);
l = new JLabel("Mouse Events");
f.add(l);
f.addMouseListener(this);
}
public static void main(String args[]) {
Exp2 a = new Exp2();
}
@Override
public void mouseClicked(MouseEvent e) {
l.setText("Mouse Clicked");
}
@Override
public void mousePressed(MouseEvent e) {
l.setText("Mouse Pressed");
}
@Override
public void mouseReleased(MouseEvent e) {
l.setText("Mouse Released");
}
@Override
public void mouseEntered(MouseEvent e) {
l.setText("Mouse Entered");
}
@Override
public void mouseExited(MouseEvent e) {
l.setText("Mouse Exited");
}
}
