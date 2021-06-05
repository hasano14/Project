import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddMeal extends JFrame{

    ImageIcon image = new ImageIcon("Images/OPERA.png"); // program icon
    
    public AddMeal(){
        initializeComponents();
    }

    private void initializeComponents(){
        // initialize components
        this.setTitle("Create Meal Diary"); // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close program on x
        this.setResizable(false); // set resizable
        this.setBounds(300, 90, 900, 600);
        this.setIconImage(image.getImage()); // change the icon of image
        this.setVisible(true);// show the frame
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 50, 10));
        topPanel.setLayout(new GridLayout(0, 1));

        //Top panel
        JButton home = new JButton("Home");
        home.setBounds(20, 20, 100, 20);
        topPanel.add(home);
        JLabel title = new JLabel();
        title.setText("Create New Meal");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        
        topPanel.add(title);


        JPanel middlePanel = new JPanel();
        middlePanel.setBounds(450, 380, 820, 600);

        JLabel name = new JLabel(" Meal Name");
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(100, 20);
        name.setLocation(10, 40);
        this.add(topPanel, BorderLayout.NORTH);
    }
}