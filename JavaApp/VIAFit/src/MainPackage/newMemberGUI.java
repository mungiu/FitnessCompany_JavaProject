package MainPackage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class newMemberGUI extends JFrame
{
   private JPanel main;
   private JPanel inputContainer;
   private JPanel outputContaner;
   private JPanel inputLine1;
   private JPanel inputLine2;
   private JPanel inputLine3;
   private JPanel inputLine4;
   private JPanel inputLine5;
   private JPanel inputLine6;
   private JPanel topContainer;
   private JPanel confirmContainer;
   private JPanel attendedAlign;
   
   private JLabel name;
   private JLabel memberID;
   private JLabel membershipType;
   private JLabel email;
   private JLabel membershipSince;
   private JLabel phone;
   private JLabel logoLabel;
   private JLabel headLine;
   private JLabel attendedEvents;
   
   private JTextField nameInput;
   private JTextField memberIDInput;
   private JTextField emailInput;
   private JTextField membershipSinceInputDay;
   private JTextField membershipSinceInputMonth;
   private JTextField membershipSinceInputYear;
   private JTextField phoneInput;
   private JTextArea allEvents;
   private JScrollPane allEventsScroll;
   private JTextField membershipTypeInput;
   
   private JButton save;
   private JButton cancel;
   
   private JMenuBar menuBar;
   
   private JMenu fileMenu;
   private JMenu editMenu;
   private JMenu aboutMenu;
   
   private JMenuItem exit;
   private JMenuItem about;
   private JCheckBoxMenuItem editInfo;
   
   private ImageIcon logo;
   
   public newMemberGUI() 
   {   
   super("Member - ViaFit Fitness centre");
   
   main = new JPanel();
   inputContainer = new JPanel();
   outputContaner = new JPanel();
   inputLine1 = new JPanel();
   inputLine2 = new JPanel();
   inputLine3 = new JPanel();
   inputLine4 = new JPanel();
   inputLine5 = new JPanel();
   inputLine6 = new JPanel();
   topContainer = new JPanel();
   confirmContainer = new JPanel();
   attendedAlign = new JPanel();
   
   name = new JLabel("Name:");
   memberID = new JLabel("Member ID:");
   membershipType = new JLabel("Membership type:");
   email = new JLabel("Email:");
   membershipSince = new JLabel("Member since:");
   phone = new JLabel("Phone:");
   logoLabel = new JLabel();
   headLine = new JLabel("Member information");
   attendedEvents = new JLabel("Attended events:");
   
   nameInput = new JTextField();
   memberIDInput = new JTextField();
   emailInput = new JTextField();
   membershipSinceInputDay = new JTextField("Day");
   membershipSinceInputMonth = new JTextField("Month");
   membershipSinceInputYear = new JTextField("Year");
   phoneInput = new JTextField();
   allEvents = new JTextArea(10, 20);
   allEventsScroll = new JScrollPane();
   membershipTypeInput = new JTextField();
   
   save = new JButton("Save");
   cancel = new JButton("Cancel");
   
   menuBar = new JMenuBar();
   
   fileMenu = new JMenu("File");
   editMenu = new JMenu("Edit");
   aboutMenu = new JMenu("About");
   
   exit = new JMenuItem("Exit");
   about = new JMenuItem("Version whatever, get lost");
   editInfo = new JCheckBoxMenuItem("Edit member");
   
   logo = new ImageIcon("img/logoTransBigger.png");
   
   
   //styling the text and labels
   headLine.setFont(new Font(headLine.getFont().getFamily(), Font.BOLD, 30));
   
   //adding content to the menuBar
   fileMenu.add(exit);
   editMenu.add(editInfo);
   aboutMenu.add(about);
   menuBar.add(fileMenu);
   menuBar.add(editMenu);
   menuBar.add(aboutMenu);
   
   //adding content to the topContainer
   logoLabel.setIcon(logo);
   topContainer.setLayout(new GridLayout(1, 2));
   logoLabel.setBorder(new EmptyBorder(20, 20, 0, 0));
   topContainer.setMinimumSize(new Dimension(800, 300));
   topContainer.setMaximumSize(new Dimension(800, 300));
   headLine.setBorder(new EmptyBorder(50, 0, 0, 0));
   topContainer.add(logoLabel);
   topContainer.add(headLine);
   
   //adding content to the inputContainer
   inputContainer.setLayout(new GridLayout(3, 2));
   inputContainer.setBorder(new EmptyBorder(30, 0, 0, 0));
   inputContainer.setMinimumSize(new Dimension(750, 150));
   inputContainer.setMaximumSize(new Dimension(750, 150));
   inputLine1.add(name);
   inputLine1.add(nameInput);
   inputLine2.add(memberID);
   inputLine2.add(memberIDInput);
   inputLine3.add(membershipType);
   inputLine3.add(membershipTypeInput);
   inputLine4.add(email);
   inputLine4.add(emailInput);
   inputLine5.add(membershipSince);
   inputLine5.add(membershipSinceInputDay);
   inputLine5.add(membershipSinceInputMonth);
   inputLine5.add(membershipSinceInputYear);
   inputLine6.add(phone);
   inputLine6.add(phoneInput);
   inputContainer.add(inputLine1);
   inputContainer.add(inputLine2);
   inputContainer.add(inputLine3);
   inputContainer.add(inputLine4);
   inputContainer.add(inputLine5);
   inputContainer.add(inputLine6);
   
   Dimension labels = new Dimension(102, 25);
   name.setPreferredSize(labels);
   memberID.setPreferredSize(labels);
   membershipType.setPreferredSize(labels);
   membershipSince.setPreferredSize(labels);
   email.setPreferredSize(labels);
   phone.setPreferredSize(labels);
   
   Dimension fields = new Dimension(192, 25);
   Dimension dateFields = new Dimension(61, 25);
   nameInput.setPreferredSize(fields);
   memberIDInput.setPreferredSize(fields);
   emailInput.setPreferredSize(fields);
   phoneInput.setPreferredSize(fields);
   membershipSinceInputDay.setPreferredSize(dateFields);
   membershipSinceInputMonth.setPreferredSize(dateFields);
   membershipSinceInputYear.setPreferredSize(dateFields);
   membershipTypeInput.setPreferredSize(fields);
  
   //adding content to the outputContainer
   allEventsScroll.setPreferredSize(new Dimension(677, 250));
   allEventsScroll.add(allEvents);
   allEventsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   allEvents.setEditable(false);
   outputContaner.add(allEventsScroll);
   
   //adding content to the confirmContainer
   confirmContainer.add(save);
   confirmContainer.add(cancel);
   
   //adding the JLabel attendedEvents
   attendedAlign.add(attendedEvents);
   
   //adding content to the main frame
   main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
   main.add(topContainer);
   main.add(inputContainer);
   main.add(attendedAlign);
   main.add(outputContaner);
   main.add(confirmContainer);
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   setJMenuBar(menuBar);
   add(main);
   setSize(800, 600);
   setResizable(false);
   setVisible(true);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLocationRelativeTo(null);
   }
}
