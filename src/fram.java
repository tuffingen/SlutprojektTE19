import javax.swing.JFrame;

public class fram extends JFrame {

    fram(){
            this.add(new display());
            this.setTitle("snake");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.pack();
            this.setVisible(true);
            this.setLocationRelativeTo(null);

    }
}
