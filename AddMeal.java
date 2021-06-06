import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMeal extends JFrame implements ActionListener {

    //Panel declaration
    JPanel topPanel;
    JPanel middlePanel;
    JPanel leftMiddlePanel;
    JPanel rightMiddlePanel;

    //Buttons Declaration
    JButton homeButton;
    JButton submitButton;

    //TextField Declaration
    JTextField nameField;
    JTextField groupField;
    JTextField dateField;
    JTextField dayField;
    JTextField drinkField;

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
        this.setLayout(new BorderLayout());
        this.setIconImage(image.getImage()); // change the icon of image
        this.setVisible(true);// show the frame
        
        //North Layout
        topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 50, 10));

        //Top panel
        JButton homeButton = new JButton("Home");
        homeButton.setBounds(10, 10, 100, 20);
        homeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                homeActionPerformed(evt);
            }
        });
        topPanel.add(homeButton);

        JLabel title = new JLabel();
        title.setText("Create New Meal");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(title);

        middlePanel = new JPanel();
        middlePanel.setPreferredSize(new Dimension(300,300));
        middlePanel.setBackground(Color.BLACK); //remove this background later

        //Food Name
        JLabel nameLabel = new JLabel("Meal Name: ");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        nameLabel.setBounds(30, 50, 80, 25);
        topPanel.add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(100, 50, 165, 25);
        topPanel.add(nameField);

        //Food Group
        JLabel groupLabel = new JLabel("Meal Group: ");
        groupLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        groupLabel.setBounds(30, 100, 80, 25);
        middlePanel.add(groupLabel);
        groupField = new JTextField();
        groupField.setBounds(100, 100, 165, 25);
        middlePanel.add(groupField);

        //Date Field
        JLabel dateLabel = new JLabel("Meal Date: ");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        dateLabel.setBounds(30, 150, 80, 25);
        middlePanel.add(dateLabel);
        dateField = new JTextField();
        dateField.setBounds(100, 150, 165, 25);
        middlePanel.add(dateField);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
    }

    protected void homeActionPerformed(ActionEvent evt) {
        new Home();
        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    //int answer = System.outprintln(JOptionPane.showConfirmDialog(null, "Confirm all details", "Confirm Details", JOptionPane.YES_OPTION);
}