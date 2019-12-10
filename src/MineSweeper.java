import javax.swing.*;
import java.awt.*;
import sweeper.Box;
import sweeper.Coord;
import sweeper.Ranges;


public class MineSweeper extends JFrame {
    private JPanel  panel;
    private final int COLLS = 9;
    private final int ROWS=9;
    private final int IMAGE_SIZE=50;

    public static void main(String[] args) {
        new MineSweeper().setVisible(true);
    }
    private MineSweeper() {

        Ranges.setSize (new Coord (COLLS, ROWS));
        setImages();
        initPanel();
        initFrame();
    }

    private void initPanel () {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoord()) {

                    g.drawImage((Image) Box.values()[(coord.x+coord.y) % Box.values().length].image,
                            coord.x * IMAGE_SIZE,
                            coord.y * IMAGE_SIZE,
                            this);

                }
            }
        };

        panel.setPreferredSize(new Dimension(
                Ranges.getSize().x*IMAGE_SIZE ,
                Ranges.getSize().y*IMAGE_SIZE ));
        add (panel);

    }

    private void initFrame ()
    {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
    }
    private void setImages(){
        for (Box box : Box.values())
            box.image = getImage(box.name().toLowerCase());

    }


    private Image getImage (String name){
        String filename = "img/" +  name + ".png";
        ImageIcon icon  = new   ImageIcon(getClass().getResource(filename));
        return icon.getImage();


    }

}
