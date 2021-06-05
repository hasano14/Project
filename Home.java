import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame {

    // Images Handlers
    ImageIcon image = new ImageIcon("Images/OPERA.png"); // program icon
    public static int choices = 0;

    public Home() {
        initializeComponents();
    }

    public void initializeComponents() {

        // initialize components
        this.setTitle("Meal Diary"); // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close program on x
        this.setResizable(false); // set resizable
        this.setBounds(300, 90, 900, 600);
        this.setIconImage(image.getImage()); // change the icon of image
        this.setVisible(true);// show the frame

        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 50, 10));
        topPanel.setLayout(new GridLayout(0, 1));

        JLabel title = new JLabel();
        title.setText("Meal Diary");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(title);

        JPanel middlePanel = new JPanel();
        middlePanel.setBounds(450, 380, 820, 600);

        JButton create = new JButton("Create");
        create.setFont(new Font("Arial", Font.PLAIN, 15));
        create.setFocusable(false);
        create.setSize(100, 20);
        create.setLocation(10, 40);
        create.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        middlePanel.add(create);

        JButton view = new JButton("View");
        view.setFont(new Font("Arial", Font.PLAIN, 15));
        view.setFocusable(false);
        view.setSize(100, 20);
        view.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        middlePanel.add(view);

        JButton update = new JButton("Update");
        update.setFont(new Font("Arial", Font.PLAIN, 15));
        update.setFocusable(false);
        update.setSize(100, 20);
        update.setLocation(300, 50);
        update.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        middlePanel.add(update);

        JButton delete = new JButton("Delete");
        delete.setFont(new Font("Arial", Font.PLAIN, 15));
        delete.setFocusable(false);
        delete.setSize(100, 20);
        delete.setLocation(300, 55);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        middlePanel.add(delete);

        JButton search = new JButton("Search");
        search.setFont(new Font("Arial", Font.PLAIN, 15));
        search.setFocusable(false);
        search.setSize(100, 20);
        search.setLocation(300, 60);
        search.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }

        });
        middlePanel.add(search);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);

    }

    protected void searchActionPerformed(ActionEvent evt) {
    }

    protected void deleteActionPerformed(ActionEvent evt) {
    }

    protected void updateActionPerformed(ActionEvent evt) {
    }

    protected void viewActionPerformed(ActionEvent evt) {
    }

    // Create new meal
    protected void createActionPerformed(ActionEvent evt) {
        new AddMeal();
        dispose();
    }

    public void mainMenu() {
    }

    public void addFrame() {
        System.out.println("Testing2");
        this.setBounds(300, 90, 900, 600);
        this.setIconImage(image.getImage()); // change the icon of image
        this.setTitle("Meal Diary"); // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close program on x
        this.setResizable(false); // set resizable
        this.setVisible(true);// show the frame
    }

}
