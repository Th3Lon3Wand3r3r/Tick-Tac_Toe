import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Tick_Tac_Toe extends JPanel implements MouseListener {
   char[][] XO = new char[3][3];
   int no;
   int col;
   int row;
   int count;
   String win;

   Tick_Tac_Toe() {
      this.addMouseListener(this);
   }

   public void mouseClicked(MouseEvent e) {
      ++this.no;
      int x = e.getX();
      int y = e.getY();
      this.col = x / (this.getWidth() / 3);
      this.row = y / (this.getHeight() / 3);
      if (this.XO[this.row][this.col] == 0) {
         if (this.no % 2 == 1) {
            this.XO[this.row][this.col] = 'O';
         } else {
            this.XO[this.row][this.col] = 'X';
         }
      }

      for(int i = 0; i < 3; ++i) {
         if (this.XO[i][0] == this.XO[this.row][this.col] && this.XO[i][1] == this.XO[this.row][this.col] && this.XO[i][2] == this.XO[this.row][this.col]) {
            ++this.count;
         } else if (this.XO[0][i] == this.XO[this.row][this.col] && this.XO[1][i] == this.XO[this.row][this.col] && this.XO[2][i] == this.XO[this.row][this.col]) {
            ++this.count;
         } else if (this.XO[0][0] == this.XO[this.row][this.col] && this.XO[1][1] == this.XO[this.row][this.col] && this.XO[2][2] == this.XO[this.row][this.col]) {
            ++this.count;
         } else if (this.XO[0][2] == this.XO[this.row][this.col] && this.XO[1][1] == this.XO[this.row][this.col] && this.XO[2][0] == this.XO[this.row][this.col]) {
            ++this.count;
         }
      }

      if (this.count > 0) {
         this.win = "W";
      }

      this.repaint();
   }

   public void mousePressed(MouseEvent e) {
   }

   public void mouseReleased(MouseEvent e) {
   }

   public void mouseEntered(MouseEvent e) {
   }

   public void mouseExited(MouseEvent e) {
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setFont(new Font("Arial", 0, 100));
      int w = this.getWidth();
      int h = this.getHeight();
      g.drawLine(w / 3, 0, w / 3, h);
      g.drawLine(2 * w / 3, 0, 2 * w / 3, h);
      g.drawLine(0, h / 3, w, h / 3);
      g.drawLine(0, 2 * h / 3, w, 2 * h / 3);
      g.setColor(Color.BLACK);
      if (this.win == "W") {
         g.setColor(Color.RED);
         g.setFont(new Font("Arial", 1, 80));
         g.drawString(this.XO[this.row][this.col] + " WINS", 500, 300);
      }

      g.setColor(Color.BLACK);
      if (this.no == 9) {
         g.setColor(Color.RED);
         g.setFont(new Font("Arial", 1, 80));
         g.drawString("DRAW", 500, 300);
      }

      for(int r = 0; r < 3; ++r) {
         for(int c = 0; c < 3; ++c) {
            if (this.XO[r][c] != 0) {
               int Width = this.getWidth() / 3;
               int Height = this.getHeight() / 3;
               g.drawString(String.valueOf(this.XO[r][c]), c * Width + Width / 2, r * Height + Height / 2);
            }
         }
      }

   }

   public static void main(String[] args) {
      JFrame frame = new JFrame("Background");
      Tick_Tac_Toe GamePanel = new Tick_Tac_Toe();
      frame.add(GamePanel);
      frame.setExtendedState(6);
      frame.setDefaultCloseOperation(3);
      frame.setVisible(true);
   }
}
