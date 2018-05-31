package MainPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class newEventGUI extends JFrame
{
   private JPanel main;
   private JPanel topContainer;
   private JPanel inputContainer;
   private JPanel outputContainer;
   private JPanel nameContainer;
   private JPanel maxMembersContainer;
   private JPanel typeContainer;
   private JPanel startDateContainer;
   private JPanel startDateInputContainer;
   private JPanel endDateContainer;
   private JPanel endDateInputContainer;
   private JPanel startTimeContainer;
   private JPanel removeInstructorPP;
   private JPanel durationContainer;
   private JPanel instructorContainer;
   private JPanel newTypeContainer;
   private JPanel weeklyContainer;
   private JPanel bottomContainer;
   private JPanel attendingInstructorsSmall;
   private JPanel emptyPanel;
   private JPanel attendingInstructorsPanel;
   private JPanel attendingMembersPanel;
   private JPanel attendingMembersSmall;
   private JPanel outerattendingMembersAreaScroll;
   private JPanel outerattendingInstructorsAreaScroll;
   private JPanel confirmContainer;
   private JPanel removeInstructorPanel;
   private JPanel empty;
   
   private JLabel name;
   private JLabel type;
   private JLabel instructor;
   private JLabel maxMembers;
   private JLabel startdate;
   private JLabel enddate;
   private JLabel startTime;
   private JLabel duration;
   private JLabel newType;
   private JLabel weekly;
   private JLabel attendingMembers;
   private JLabel headLine;
   private JLabel dateD;
   private JLabel dateM;
   private JLabel dateY;
   private JLabel dateEndD;
   private JLabel dateEndM;
   private JLabel dateEndY;
   private JLabel attendingInstructors;
   private JLabel timeHour;
   private JLabel timeMinute;
   
   private JTextField nameInput;
   private JTextField typeInput;
   private JTextField maxMembersInput;
   private JTextField startDateDay;
   private JTextField startDateMonth;
   private JTextField startDateYear;
   private JTextField endDateDay;
   private JTextField endDateMonth;
   private JTextField endDateYear;
   private JTextField startTimeHour;
   private JTextField startTimeMinute;
   
   private DefaultListModel<Instructor> listInstructors;
   private DefaultListModel<Member> listMembers;
   private JList<Instructor> attendingInstructorsArea;
   private JList<Member> attendingMembersArea;
   private JScrollPane attendingInstructorsAreaScroll;
   private JScrollPane attendingMembersAreaScroll;
   
   private String[] tempIns = {"Change this later", "Remember to change this"};
   private JComboBox<String> instructorCombo;
   private String[] tempType = {"Change this later", "Remember to change this"};
   private JComboBox<String> typeCombo;
   private String[] tempDura = {"1 hour", "2 hours", "3 hours", "4 hours", "5 hours"};
   private JComboBox<String> duraCombo;
   private String[] tempInsBottom = {"Change this later", "Remember to change this"};
   private JComboBox<String> instructorComboBottom;
   
   private JCheckBox newTypeCheck;
   private JCheckBox weeklyCheck;
   
   private JButton save;
   private JButton close;
   private JButton addInstructor;
   private JButton removeInstructor;
   
   private JMenuBar menuBar;
   
   private JMenu fileMenu;
   private JMenu editMenu;
   private JMenu aboutMenu;
   
   private JMenuItem remove;
   private JMenuItem exit;
   private JMenuItem about;
   private JCheckBoxMenuItem editInfo;
   
   private ImageIcon logo;
   private JLabel logoLabel;
   private ButtonListener buttonListener;
   
   /**
    * Inner buttonListener
    * @author sst
    * @version 1.0
    */
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

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
///////////////////////////////////// GUI ///////////////////////////////////////   
   
   
public newEventGUI()
{
   super("Event - ViaFit Fitness Centre");
 
   buttonListener = new ButtonListener();
   main = new JPanel();
   topContainer = new JPanel();
   inputContainer = new JPanel();
   outputContainer = new JPanel();
   nameContainer = new JPanel();
   maxMembersContainer = new JPanel();
   typeContainer = new JPanel();
   startDateContainer = new JPanel();
   startDateInputContainer = new JPanel();
   endDateContainer = new JPanel();
   endDateInputContainer = new JPanel();
   startTimeContainer = new JPanel();
   removeInstructorPP = new JPanel();
   durationContainer = new JPanel();
   instructorContainer = new JPanel();
   newTypeContainer = new JPanel();
   weeklyContainer = new JPanel();
   bottomContainer = new JPanel();
   attendingInstructorsSmall = new JPanel();
   emptyPanel = new JPanel();
   attendingInstructorsPanel = new JPanel();
   attendingMembersPanel = new JPanel();
   attendingMembersSmall = new JPanel();
   outerattendingMembersAreaScroll = new JPanel();
   outerattendingInstructorsAreaScroll = new JPanel();
   removeInstructorPanel = new JPanel();
   confirmContainer = new JPanel();
   empty = new JPanel();
   
   name = new JLabel("Name:");
   type = new JLabel("Class type:");
   instructor = new JLabel("Instructor:");
   maxMembers = new JLabel("Max members:");
   startdate = new JLabel("Start date:");
   enddate = new JLabel("End date:");
   startTime = new JLabel("Start time:");
   duration = new JLabel("Duration:");
   newType = new JLabel("New class type:");
   weekly = new JLabel("Weekly:");
   attendingMembers = new JLabel("Attending members:");
   headLine = new JLabel("Event information");
   dateD = new JLabel("D:");
   dateM = new JLabel ("M:");
   dateY = new JLabel("Y:");
   dateEndD = new JLabel("D:");
   dateEndM = new JLabel ("M:");
   dateEndY = new JLabel("Y:");
   attendingInstructors = new JLabel("Attending instructors:");
   timeHour = new JLabel("H:");
   timeMinute = new JLabel("M:");
   
   
   listInstructors = new DefaultListModel<Instructor>();
   listMembers = new DefaultListModel<Member>();
   attendingInstructorsArea = new JList<Instructor>(listInstructors);
   attendingMembersArea = new JList<Member>(listMembers);
   attendingInstructorsAreaScroll = new JScrollPane(attendingInstructorsArea);
   attendingMembersAreaScroll = new JScrollPane(attendingMembersArea);
   
   nameInput = new JTextField();
   typeInput = new JTextField();
   maxMembersInput= new JTextField();
   startDateDay= new JTextField("Day");
   startDateMonth= new JTextField("Month");
   startDateYear= new JTextField("Year");
   endDateDay = new JTextField("Day");
   endDateMonth= new JTextField("Month");
   endDateYear= new JTextField("Year");
   startTimeHour= new JTextField("Hours");
   startTimeMinute= new JTextField("Minutes");
 
   instructorCombo = new JComboBox<String>(tempIns);
   typeCombo = new JComboBox<String>(tempType);
   duraCombo = new JComboBox<String>(tempDura);
   instructorComboBottom = new JComboBox<String>(tempInsBottom);
   
   newTypeCheck = new JCheckBox();
   weeklyCheck = new JCheckBox();
   
   save = new JButton("Save");
   save.addActionListener(buttonListener);
   close = new JButton("Close");
   close.addActionListener(buttonListener);
   addInstructor = new JButton("Add instructor");
   addInstructor.addActionListener(buttonListener);
   removeInstructor = new JButton("Remove instructor");
   removeInstructor.addActionListener(buttonListener);
   
   menuBar = new JMenuBar();
   
   fileMenu = new JMenu("File");
   editMenu = new JMenu("Edit");
   aboutMenu = new JMenu("About");
   
   remove = new JMenuItem("Delete event");
   exit = new JMenuItem("Exit");
   about = new JMenuItem("Fuck off, Ron");
   editInfo = new JCheckBoxMenuItem("Edit event");
   logo = new ImageIcon("img/logoTransBigger.png");
   logoLabel = new JLabel();
   
   
   
   
   
   //styling textfields and text
   headLine.setFont(new Font(headLine.getFont().getFamily(), Font.BOLD, 30));
   Color col1 = new Color(1, 1, 255);
   
   //adding content to menuBar
   menuBar.add(fileMenu);
   menuBar.add(editMenu);
   menuBar.add(aboutMenu);
   fileMenu.add(exit);
   editMenu.add(editInfo);
   editMenu.add(remove);
   aboutMenu.add(about);
   
   //adding content to the topContainer
   logoLabel.setIcon(logo);
   topContainer.setLayout(new GridLayout(1, 2));
   logoLabel.setBorder(new EmptyBorder(20, 20, 0, 0));
   topContainer.setMinimumSize(new Dimension(750, 90));
   topContainer.setMaximumSize(new Dimension(750, 90));
   headLine.setBorder(new EmptyBorder(50, 0, 0, 0));
   topContainer.add(logoLabel);
   topContainer.add(headLine);
   
   //adding content to inputContainer
   inputContainer.setBorder(new EmptyBorder(30, 0, 0, 0));
   inputContainer.setPreferredSize(new Dimension(750, 200));
   inputContainer.setLayout(new GridLayout(5, 2));
   inputContainer.add(nameContainer);
   inputContainer.add(maxMembersContainer);
   inputContainer.add(typeContainer);
   inputContainer.add(startDateContainer);
   inputContainer.add(newTypeContainer);
   inputContainer.add(endDateContainer);
   inputContainer.add(instructorContainer);
   inputContainer.add(durationContainer);
   inputContainer.add(emptyPanel);
   inputContainer.add(startTimeContainer);
   startTimeContainer.add(startTime);
   startTime.setPreferredSize(new Dimension(60, 25));
   startTimeContainer.add(timeHour);
   startTimeContainer.add(startTimeHour);
   startTimeHour.setPreferredSize(new Dimension(50, 25));
   startTimeContainer.add(timeMinute);
   startTimeContainer.add(startTimeMinute);
   startTimeMinute.setPreferredSize(new Dimension(50, 25));
   nameContainer.add(name);
   nameContainer.add(nameInput);
   maxMembersContainer.add(maxMembers);
   maxMembersContainer.add(maxMembersInput);
   Dimension labels = new Dimension(102, 25);
   Dimension fields = new Dimension(160, 25);
   nameInput.setPreferredSize(fields);
   maxMembersInput.setPreferredSize(new Dimension(40, 25));
   name.setPreferredSize(labels);
   maxMembers.setPreferredSize(labels);
   
         //adding contents to smaller containers

   typeContainer.add(type);
   type.setPreferredSize(labels);
   typeContainer.add(typeCombo);
   newTypeContainer.add(newType);
   newType.setPreferredSize(labels);
   newTypeContainer.add(newTypeCheck);
   instructorContainer.add(addInstructor);
   instructor.setPreferredSize(labels);
   instructorContainer.add(instructorCombo);
   startDateContainer.add(startdate);
   startdate.setPreferredSize(new Dimension(60, 25));
   startDateContainer.add(startDateInputContainer);
   startDateInputContainer.add(dateD);
   startDateInputContainer.add(startDateDay);
   startDateInputContainer.add(dateM);
   startDateInputContainer.add(startDateMonth);
   startDateInputContainer.add(dateY);
   startDateInputContainer.add(startDateYear);
   endDateContainer.add(enddate);
   enddate.setPreferredSize(new Dimension(60, 25));
   endDateContainer.add(endDateInputContainer);
   endDateInputContainer.add(dateEndD);
   endDateInputContainer.add(endDateDay);
   endDateInputContainer.add(dateEndM);
   endDateInputContainer.add(endDateMonth);
   endDateInputContainer.add(dateEndY);
   endDateInputContainer.add(endDateYear);
   durationContainer.add(duration);
   durationContainer.add(duraCombo);
   durationContainer.add(weeklyContainer);
   weeklyContainer.add(weekly);
   weekly.setPreferredSize(new Dimension(60, 25));
   weeklyContainer.add(weeklyCheck);
   Dimension dates = new Dimension(40, 25);
   startDateDay.setPreferredSize(dates);
   startDateMonth.setPreferredSize(dates);
   startDateYear.setPreferredSize(dates);
   endDateDay.setPreferredSize(dates);
   endDateMonth.setPreferredSize(dates);
   endDateYear.setPreferredSize(dates);
   
   //adding content to the outputContainer
   outputContainer.setMinimumSize(new Dimension(750, 180));
   outputContainer.setMaximumSize(new Dimension(750, 180));
   outputContainer.setLayout(new GridLayout(1,2));
   outputContainer.add(attendingInstructorsPanel);
   attendingInstructorsPanel.setLayout(new BoxLayout(attendingInstructorsPanel, BoxLayout.Y_AXIS));
   attendingInstructorsPanel.add(attendingInstructorsSmall);
   attendingInstructorsSmall.add(attendingInstructors);
   outputContainer.add(attendingMembersPanel);
   attendingMembersPanel.setLayout(new BoxLayout(attendingMembersPanel, BoxLayout.Y_AXIS));
   attendingMembersPanel.add(attendingMembersSmall);
   attendingMembersSmall.add(attendingMembers);
   attendingInstructorsPanel.add(outerattendingInstructorsAreaScroll);
   outerattendingInstructorsAreaScroll.add(attendingInstructorsAreaScroll);
   attendingMembersPanel.add(outerattendingMembersAreaScroll);
   outerattendingMembersAreaScroll.add(attendingMembersAreaScroll);
   removeInstructorPanel.setLayout(new GridLayout(1,2));
   removeInstructorPanel.add(removeInstructorPP);
   removeInstructorPP.add(removeInstructor);
   removeInstructorPanel.add(empty);
   attendingMembersAreaScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   attendingMembersArea.setVisibleRowCount(-1);
   attendingInstructorsAreaScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   attendingInstructorsArea.setVisibleRowCount(-1);
   Dimension box = new Dimension(300, 120);
   attendingInstructorsAreaScroll.setPreferredSize(box);
   attendingMembersAreaScroll.setPreferredSize(box);

   //adding content the the bottomContainer
   bottomContainer.add(confirmContainer);
   confirmContainer.add(save);
   confirmContainer.add(close);
   
   //adding content to the main frame
   main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
   main.add(topContainer);
   main.add(inputContainer);
   main.add(outputContainer);
   main.add(removeInstructorPanel);
   main.add(bottomContainer);
   
   
   
   setJMenuBar(menuBar);
   add(main);
   setSize(800, 600);
   setResizable(false);
   setVisible(true);
   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   setLocationRelativeTo(null);
}
}
