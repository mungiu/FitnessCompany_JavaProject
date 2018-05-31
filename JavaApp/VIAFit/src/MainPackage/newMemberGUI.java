package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
   private JPanel outputLeft;
   private JPanel outputRight;
   private JPanel allEventsbox;
   private JPanel allSignedUpForbox;
   private JPanel allEventsButtonBox;
   private JPanel SignUpForButtonbox;
   private JPanel removeFromBox;
   private JPanel leftAreaFrame;
   private JPanel rightAreaFrame;
   
   private JLabel name;
   private JLabel memberID;
   private JLabel membershipType;
   private JLabel email;
   private JLabel membershipSince;
   private JLabel phone;
   private JLabel logoLabel;
   private JLabel headLine;
   private JLabel attendedEvents;
   private JLabel dateD;
   private JLabel dateM;
   private JLabel dateY;
   private JLabel allEventsLabel;
   private JLabel allSignedupForLabel;
   
   private JTextField nameInput;
   private JTextField memberIDInput;
   private JTextField emailInput;
   private JTextField membershipSinceInputDay;
   private JTextField membershipSinceInputMonth;
   private JTextField membershipSinceInputYear;
   private JTextField phoneInput;
   
   private JList<Event> allEvents;
   private DefaultListModel<Event> listModel;
   private JScrollPane allEventsScroll;
   private JList<Event> allSignedUpForArea;
   private DefaultListModel<Event> listSignedUp;
   private JScrollPane allSignedUpForScroll;
   
   private JComboBox<String> membershipTypeInput;
   
   private JButton save;
   private JButton close;
   private JButton removeFrom;
   private JButton signUp;
   
   private JMenuBar menuBar;
   
   private JMenu fileMenu;
   private JMenu editMenu;
   private JMenu aboutMenu;
   
   private JMenuItem remove;
   private JMenuItem exit;
   private JMenuItem about;
   private JCheckBoxMenuItem editInfo;
   
   private ImageIcon logo;
   private ButtonListener buttonListener;
   
   
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource()==close)
         {
            dispose();
         }
      }
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
/////////////////////////////////////// GUI ///////////////////////////////////////
   
   public newMemberGUI() 
   {   
   super("Member - ViaFit Fitness centre");
   
   buttonListener = new ButtonListener();
   
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
   leftAreaFrame = new JPanel();
   rightAreaFrame = new JPanel();
   removeFromBox = new JPanel();
   outputLeft = new JPanel();
   outputRight = new JPanel();
   allEventsbox = new JPanel();
   SignUpForButtonbox = new JPanel();
   allSignedUpForbox = new JPanel();
   
   name = new JLabel("Name:");
   memberID = new JLabel("Member ID:");
   membershipType = new JLabel("Membership type:");
   email = new JLabel("Email:");
   membershipSince = new JLabel("Member since:");
   phone = new JLabel("Phone:");
   logoLabel = new JLabel();
   headLine = new JLabel("Member information");
   attendedEvents = new JLabel("Attended events:");
   dateD = new JLabel("D:");
   dateM = new JLabel("M:");
   dateY = new JLabel("Y:");
   allEventsLabel = new JLabel("All events:");
   allSignedupForLabel = new JLabel("Signed up for:");
   
   nameInput = new JTextField();
   memberIDInput = new JTextField();
   emailInput = new JTextField();
   membershipSinceInputDay = new JTextField("Day");
   membershipSinceInputMonth = new JTextField("Month");
   membershipSinceInputYear = new JTextField("Year");
   phoneInput = new JTextField();
   
   listModel = new DefaultListModel<Event>();
   allEvents = new JList<Event>(listModel);
   allEventsScroll = new JScrollPane(allEvents);
   listSignedUp = new DefaultListModel<Event>();
   allSignedUpForArea = new JList<Event>(listSignedUp);
   allSignedUpForScroll = new JScrollPane(allSignedUpForArea);
   
   String[] temp = {"Premium", "Standard"};
   membershipTypeInput = new JComboBox<String>(temp);
   
   save = new JButton("Save");
   save.addActionListener(buttonListener);
   close = new JButton("Close");
   close.addActionListener(buttonListener);
   signUp = new JButton("Sign up for event");
   signUp.addActionListener(buttonListener);
   removeFrom = new JButton("Remove from event");
   removeFrom.addActionListener(buttonListener);
   
   menuBar = new JMenuBar();
   
   fileMenu = new JMenu("File");
   editMenu = new JMenu("Edit");
   aboutMenu = new JMenu("About");
   
   remove = new JMenuItem("Delete member");
   exit = new JMenuItem("Exit");
   about = new JMenuItem("Version whatever, get lost");
   editInfo = new JCheckBoxMenuItem("Edit member");
   
   logo = new ImageIcon("img/logoTransBigger.png");
   
   
   //styling the text and labels
   headLine.setFont(new Font(headLine.getFont().getFamily(), Font.BOLD, 30));
   
   //adding content to the menuBar
   fileMenu.add(exit);
   editMenu.add(editInfo);
   editMenu.add(remove);
   aboutMenu.add(about);
   menuBar.add(fileMenu);
   menuBar.add(editMenu);
   menuBar.add(aboutMenu);
   
   //adding content to the topContainer
   logoLabel.setIcon(logo);
   topContainer.setLayout(new GridLayout(1, 2));
   logoLabel.setBorder(new EmptyBorder(20, 20, 0, 0));
   topContainer.setMinimumSize(new Dimension(800, 180));
   topContainer.setMaximumSize(new Dimension(800, 180));
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
   inputLine5.add(dateD);
   inputLine5.add(membershipSinceInputDay);
   inputLine5.add(dateM);
   inputLine5.add(membershipSinceInputMonth);
   inputLine5.add(dateY);
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
   Dimension dateFields = new Dimension(45, 25);
   nameInput.setPreferredSize(fields);
   memberIDInput.setPreferredSize(fields);
   emailInput.setPreferredSize(fields);
   phoneInput.setPreferredSize(fields);
   membershipSinceInputDay.setPreferredSize(dateFields);
   membershipSinceInputMonth.setPreferredSize(dateFields);
   membershipSinceInputYear.setPreferredSize(dateFields);
   membershipTypeInput.setPreferredSize(fields);
  
   //adding content to the outputContainer
   outputContaner.setBorder(new EmptyBorder(10, 0, 0, 0));
   allEventsScroll.setPreferredSize(new Dimension(300, 150));
   allEventsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   allEvents.setVisibleRowCount(-1);
   allSignedUpForScroll.setPreferredSize(new Dimension(300, 150));
   allSignedUpForScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   allSignedUpForArea.setVisibleRowCount(-1);
   outputContaner.setLayout(new GridLayout(1,2));
   outputContaner.add(outputLeft);
   outputContaner.add(outputRight);
   outputLeft.setLayout(new BoxLayout(outputLeft, BoxLayout.Y_AXIS));
   outputRight.setLayout(new BoxLayout(outputRight, BoxLayout.Y_AXIS));
   
   outputLeft.add(allEventsbox);
   allEventsbox.add(allEventsLabel);
   outputLeft.add(leftAreaFrame);
   leftAreaFrame.add(allEventsScroll);
   outputLeft.add(SignUpForButtonbox);
   SignUpForButtonbox.add(signUp);
   
   outputRight.add(allSignedUpForbox);
   allSignedUpForbox.add(allSignedupForLabel);
   outputRight.add(rightAreaFrame);
   rightAreaFrame.add(allSignedUpForScroll);
   outputRight.add(removeFromBox);
   removeFromBox.add(removeFrom);
   
   //adding content to the confirmContainer
   confirmContainer.add(save);
   confirmContainer.add(close);
 
   
   
   //adding content to the main frame
   main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
   main.add(topContainer);
   main.add(inputContainer);
   main.add(outputContaner);
   main.add(confirmContainer);
   
   
   
   
   
   setJMenuBar(menuBar);
   add(main);
   setSize(800, 600);
   setResizable(false);
   setVisible(true);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setLocationRelativeTo(null);
   }
}
