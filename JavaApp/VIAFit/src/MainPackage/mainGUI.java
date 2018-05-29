package MainPackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class mainGUI extends JFrame
{
private JPanel main;
private JPanel bigArea;
private JPanel events;
private JPanel topFrame;
private JPanel home;
private JPanel member;
private JPanel instructor;
private JPanel event;
private JPanel ongoingPanel;
private JPanel upcomingPanel;
private JPanel homeNorth;
private JPanel homeCenter;
private JPanel homeSouth;
private JPanel homeNorthCenterAlign;
private JPanel memberAlign;
private JPanel instructorAlign;
private JPanel eventAlign;
private JPanel homeCorner;
private JPanel memberAlign2;
private JPanel instructorAlign2;
private JPanel eventAlign2;
private JPanel homeAlign;
private JPanel homeAlign2;
private JPanel homeCenterAlign;
private JPanel homeCenterAlign2;

private JLabel ongoingEventsLabel;
private JLabel upcomingEventsLabel;
private JLabel memberLabel;
private JLabel instructorLabel;
private JLabel eventLabel;
private JLabel homeLabel;

private JTextField ongoingEvents;
private JTextField upcomingEvents;
private JTextField bigInfoBox;
private JTextField search;

private JButton memberNew;
private JButton memberAll;
private JButton instructorNew;
private JButton instructorAll;
private JButton eventNew;
private JButton eventAll;
private JButton upcomingDetails;
private JButton ongoingDetails;
private JButton homeDetails;
private JButton homeHome;

private JComboBox<String> searchOption;

private JMenuBar menubar;

private JMenu fileMenu;
private JMenu aboutMenu;

private JMenuItem exitButton;
private JMenuItem versionButton;

private ImageIcon vialogo;

public mainGUI()
{
   super("ViaFit Fitness center V. 1.0");
   
   //Initialising
   main = new JPanel();
   events = new JPanel();
   topFrame = new JPanel();
   home = new JPanel();
   member = new JPanel();
   instructor = new JPanel();
   event = new JPanel();
   ongoingPanel = new JPanel();
   upcomingPanel  = new JPanel();
   homeNorth = new JPanel();
   homeCenter = new JPanel();
   homeSouth = new JPanel();
   bigArea = new JPanel();
   homeNorthCenterAlign = new JPanel();
   memberAlign = new JPanel();
   instructorAlign = new JPanel();
   eventAlign = new JPanel();
   homeCorner = new JPanel();
   memberAlign2 = new JPanel();
   instructorAlign2 = new JPanel();
   eventAlign2 = new JPanel();
   homeAlign = new JPanel();
   homeAlign2 = new JPanel();
   homeCenterAlign = new JPanel();
   homeCenterAlign2 = new JPanel();
   
   ongoingEventsLabel = new JLabel("On-going events");
   upcomingEventsLabel = new JLabel("Upcoming events");
   memberLabel = new JLabel("Member");
   instructorLabel = new JLabel("Instructor");
   eventLabel = new JLabel("Event");
   ongoingEvents = new JTextField();
   upcomingEvents = new JTextField();
   homeLabel = new JLabel();
   
   bigInfoBox = new JTextField();
   search = new JTextField("Search");
   
   memberNew = new JButton("New member");
   memberAll = new JButton("Show all");
   instructorNew = new JButton("New instructor");
   instructorAll = new JButton("Show all");
   eventNew = new JButton("New event");
   eventAll = new JButton("Show all");
   upcomingDetails = new JButton("Details");
   ongoingDetails = new JButton("Details");
   homeDetails = new JButton("Details");
   homeHome = new JButton("Home");
   
   String[] options = {"Member", "Instructor", "Event"}; 
   searchOption = new JComboBox<String>(options); 
   
   menubar = new JMenuBar();
   
   fileMenu = new JMenu("File");
   aboutMenu = new JMenu("About");
   
   exitButton = new JMenuItem("Exit");
   versionButton = new JMenuItem("Version: 1.0 (DONT FUCKING COMPLAIN, yet");
   
   vialogo = new ImageIcon("img/vialogoah.gif");
   
   
   //adding borders
     Color col1 = new Color(100, 100, 255);
     Color grey = new Color(220, 220, 220);
     member.setBorder(new LineBorder(grey, 1));
     instructor.setBorder(new LineBorder(grey, 1));
     event.setBorder(new LineBorder(grey, 1));
     
   //setting borders to see how it looks in GUI ----------------------- Delete later!
     //   events.setBorder(new LineBorder(col1, 1));
     //   ongoingPanel.setBorder(new LineBorder(col1, 1));
     //   upcomingPanel.setBorder(new LineBorder(col1, 1));
     //   member.setBorder(new LineBorder(col1 , 1));
     //   instructor.setBorder(new LineBorder(col1 , 1));
     //   event.setBorder(new LineBorder(col1 , 1));
     //   bigInfoBox.setBorder(new LineBorder(col1, 1));
     //   main.setBorder(new LineBorder(col1, 1));
     //   home.setBorder(new LineBorder(col1, 1));
     //   homeCenter.setBorder(new LineBorder(col1, 1));
   
   
   //Visual updates to textFields and labels
   ongoingEventsLabel.setFont(new Font(ongoingEventsLabel.getFont().getFamily(), Font.BOLD, 30));
   upcomingEventsLabel.setFont(new Font(upcomingEventsLabel.getFont().getFamily(), Font.BOLD, 30));
   memberLabel.setFont(new Font(memberLabel.getFont().getFamily(), Font.BOLD, 35));
   instructorLabel.setFont(new Font(instructorLabel.getFont().getFamily(), Font.BOLD, 35));
   eventLabel.setFont(new Font(eventLabel.getFont().getFamily(), Font.BOLD, 35));
   homeLabel.setFont(new Font(homeLabel.getFont().getFamily(), Font.BOLD, 30));
   search.setFont(new Font(homeLabel.getFont().getFamily(), Font.PLAIN, 17));
   searchOption.setFont(new Font(homeLabel.getFont().getFamily(), Font.PLAIN, 17));
   homeDetails.setFont(new Font(homeLabel.getFont().getFamily(), Font.BOLD, 14));
   
   
   //adding stuff to the menuBar
   fileMenu.add(exitButton);
   aboutMenu.add(versionButton);
   menubar.add(fileMenu);
   menubar.add(aboutMenu);
   
   //adding panels to events frame
   events.setLayout(new BoxLayout(events, BoxLayout.Y_AXIS));
   events.add(ongoingPanel);
   events.add(upcomingPanel);
   ongoingPanel.setLayout(new BoxLayout(ongoingPanel, BoxLayout.Y_AXIS));
   upcomingPanel.setLayout(new BoxLayout(upcomingPanel, BoxLayout.Y_AXIS));
   ongoingPanel.add(ongoingEventsLabel);
   ongoingPanel.add(ongoingEvents);
   upcomingPanel.add(upcomingEventsLabel);
   upcomingPanel.add(upcomingEvents);
   ongoingPanel.add(ongoingDetails);
   upcomingPanel.add(upcomingDetails);
         //setting size of panels and fields in JPanel events (Left side)
   events.setPreferredSize(new Dimension(380, 1080));
   ongoingPanel.setMinimumSize(new Dimension(380, 370));
   ongoingPanel.setMaximumSize(new Dimension(380, 370));
   upcomingPanel.setMinimumSize(new Dimension(380, 370));
   upcomingPanel.setMaximumSize(new Dimension(380, 370));
   ongoingEventsLabel.setPreferredSize(new Dimension(380, 70));
   upcomingEventsLabel.setPreferredSize(new Dimension(380, 70));
   ongoingEvents.setPreferredSize(new Dimension(380, 160));
   upcomingEvents.setPreferredSize(new Dimension(380, 160));
   
   //adding buttons to home panel
//   homeCorner.setLayout(new GridLayout(2, 1));
   homeHome.setPreferredSize(new Dimension(250, 25));
   homeAlign.add(homeHome);
   homeLabel.setIcon(vialogo);
   homeAlign2.add(homeLabel);
   homeCorner.add(homeAlign2);
//   homeCorner.add(homeAlign);
   
   //adding buttons to member panel
   member.setLayout(new GridLayout(2, 1));
   memberAlign2.add(memberLabel);
   memberNew.setPreferredSize(new Dimension(150, 25));
   memberAll.setPreferredSize(new Dimension(150, 25));
   member.add(memberAlign2);
   member.add(memberAlign);
   memberAlign.add(memberNew);
   memberAlign.add(memberAll);
   
   //adding buttons to instructor panel
   instructor.setLayout(new GridLayout(2, 1));
   instructorAlign2.add(instructorLabel);
   instructor.add(instructorAlign2);
   instructor.add(instructorAlign);
   instructorNew.setPreferredSize(new Dimension(150, 25));
   instructorAll.setPreferredSize(new Dimension(150, 25));
   instructorAlign.add(instructorNew);
   instructorAlign.add(instructorAll);
   
   //adding buttons to event panel
   event.setLayout(new GridLayout(2, 1));
   eventAlign2.add(eventLabel);
   event.add(eventAlign2);
   event.add(eventAlign);
   eventNew.setPreferredSize(new Dimension(150, 25));
   eventAll.setPreferredSize(new Dimension(150, 25));
   eventAlign.add(eventNew);
   eventAlign.add(eventAll);
  
   //adding panels to top frame
   topFrame.setLayout(new BoxLayout(topFrame, BoxLayout.X_AXIS));
   topFrame.add(homeCorner);
   topFrame.add(member);
   topFrame.add(instructor);
   topFrame.add(event);
   topFrame.setPreferredSize(new Dimension(900, 130));
   
   //adding panels to homeNorth frame
   homeNorth.setLayout(new BoxLayout(homeNorth, BoxLayout.Y_AXIS));
   homeNorthCenterAlign.setLayout(new FlowLayout());
   homeNorthCenterAlign.add(search);
   homeNorthCenterAlign.add(searchOption);
   homeNorthCenterAlign.setBorder(new EmptyBorder(40, 0, 40, 0));
   search.setPreferredSize(new Dimension(400, 45));
   searchOption.setPreferredSize(new Dimension(125, 44));
   homeNorth.add(homeNorthCenterAlign);
   
   
   //adding panels to homeCenter frame
   homeCenter.setLayout(new BoxLayout(homeCenter, BoxLayout.Y_AXIS));
   homeCenterAlign2.add(bigInfoBox);
   homeCenter.add(homeCenterAlign2);
   bigInfoBox.setPreferredSize(new Dimension(1400, 700));
   bigInfoBox.setEnabled(false);
   homeDetails.setPreferredSize(new Dimension(125, 35));
   homeCenterAlign.add(homeDetails);
   homeCenter.add(homeCenterAlign);
   
   //adding panels to homeSouth frame
   
   //adding panels to home frame
   home.setLayout(new BorderLayout());
   home.setPreferredSize(new Dimension(900, 100));
   home.add(homeNorth, BorderLayout.NORTH);
   home.add(homeCenter, BorderLayout.CENTER);
   home.add(homeSouth, BorderLayout.SOUTH);
   
   //adding panels to bigArea panel
   bigArea.setLayout(new BorderLayout());
   bigArea.add(topFrame, BorderLayout.NORTH);
   bigArea.add(home, BorderLayout.CENTER);
   
   //adding panels to the main frame
   main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
   main.add(events);
   main.add(bigArea);
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   setJMenuBar(menubar);
   add(main);
   setSize(1366, 768);
   setResizable(false);
   setVisible(true);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLocationRelativeTo(null);
}
}