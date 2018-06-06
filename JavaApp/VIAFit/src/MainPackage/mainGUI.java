package MainPackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
private JPanel homeAlign2;
private JPanel homeCenterAlign;
private JPanel homeCenterAlign2;

private JLabel ongoingEventsLabel;
private JLabel upcomingEventsLabel;
private JLabel memberLabel;
private JLabel instructorLabel;
private JLabel eventLabel;
private JLabel homeLabel;
private JLabel aboveBigInfo;
private JLabel aboveUpcoming;
private JLabel aboveOngoing;

private JTextField search;

private JList<Object> bigInfoBox;
private JScrollPane bigInfoScroll;
private JList<String> ongoingEvents;
private JList<String> upcomingEvents;
private JScrollPane ongoingEventsScroll;
private JScrollPane upcomingEventsScroll;
private DefaultListModel<String> listOngoing;
private DefaultListModel<String> listUpcoming;
private DefaultListModel<Object> listBigInfoBox;


private JButton memberNew;
private JButton memberAll;
private JButton instructorNew;
private JButton instructorAll;
private JButton eventNew;
private JButton eventAll;
private JButton upcomingDetails;
private JButton ongoingDetails;
private JButton homeDetails;
private JButton searchButton;

private String eventString;

private JComboBox<String> searchOption;

private JMenuBar menubar;

private JMenu fileMenu;
private JMenu aboutMenu;

private JMenuItem exitButton;
private JMenuItem about;

private ImageIcon vialogo;

private MyListener myListener;
private MyListSelectionListener listListener;
private FileAdapter fileAdapter;
private EventsList eventsList;
private MembersList membersList;
private InstructorsList instructorsList;


/**
 * Inner action listener class
 * @author sst
 * @version 1.0
 */
private class MyListener implements ActionListener, FocusListener
{
   public void actionPerformed(ActionEvent e)
   {
      if(e.getSource()==about)
      {
         JOptionPane.showMessageDialog(null, "This is a program written by Group 1 for the SEP1 Project.\nMade for ViaFit Fitness Centre.\nVersion 1.0", "About", JOptionPane.PLAIN_MESSAGE);
      }
      if(e.getSource()==exitButton)
      {
         System.exit(0);
      }
      if(e.getSource()==eventNew)
      {
        newEventGUI g = new newEventGUI();
        g.editEventArea(true);
        fileAdapter.updateEventsList();
        fileAdapter.updateClassTypesList();
        if(fileAdapter.getEventsList().getEventsList().size()!=0)
        {
           int biggest = 0;
           for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
           {
              if(fileAdapter.getEventsList().getEventsList().get(i).getEventID()>=biggest)
              {
                 biggest = fileAdapter.getEventsList().getEventsList().get(i).getEventID();
              }
           }
           g.getEventIDInput().setText(biggest+1+"");
        }
        else
        {
           g.getEventIDInput().setText(1+"");
        }
      }
      if(e.getSource()==memberNew)
      {
         newMemberGUI g = new newMemberGUI();
         g.editMemberGUI(true);
         fileAdapter.updateMembersList();
         if(fileAdapter.getMembersList().getMembersList().size()!=0)
         {
            int biggest = 0;
            for(int i = 0;i<fileAdapter.getMembersList().getMembersList().size();i++)
            {
               if(fileAdapter.getMembersList().getMembersList().get(i).getMemberID()>=biggest)
               {
                  biggest = fileAdapter.getMembersList().getMembersList().get(i).getMemberID();
               }
            }
            g.getMemberIDInput().setText(biggest+1+"");
         }
         else
         {
            g.getMemberIDInput().setText(1+"");
         }
      }
      if(e.getSource()==instructorNew)
      {
         newInstructorGUI g = new newInstructorGUI();
         g.editInstructorArea(true);
         fileAdapter.updateInstructorsList();
         if(fileAdapter.getInstructorsList().getInstructorsList().size()!=0)
         {
            int biggest = 0;
            for(int i = 0;i<fileAdapter.getInstructorsList().getInstructorsList().size();i++)
            {
               if(fileAdapter.getInstructorsList().getInstructorsList().get(i).getInstructorID()>=biggest)
               {
                  biggest = fileAdapter.getInstructorsList().getInstructorsList().get(i).getInstructorID();
               }
            }
            g.getInstructorIDInput().setText(biggest+1+"");
         }
         else
         {
            g.getInstructorIDInput().setText(1+"");
         }
      }
      if(e.getSource()==eventAll)
      {
         fileAdapter.updateEventsList();
         listBigInfoBox.clear();
         for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
         {
            listBigInfoBox.addElement(fileAdapter.getEventsList().getEventsList().get(i));
         }
         searchOption.setSelectedIndex(2);
      }
      if(e.getSource()==memberAll)
      {
         fileAdapter.updateMembersList();
         listBigInfoBox.clear();
         for(int i = 0;i<fileAdapter.getMembersList().getMembersList().size();i++)
         {
            listBigInfoBox.addElement(fileAdapter.getMembersList().getMembersList().get(i));
         }
         searchOption.setSelectedIndex(0);
      }
      if(e.getSource()==instructorAll)
      {
         fileAdapter.updateInstructorsList();
         listBigInfoBox.clear();
         for(int i = 0;i<fileAdapter.getInstructorsList().getInstructorsList().size();i++)
         {
            listBigInfoBox.addElement(fileAdapter.getInstructorsList().getInstructorsList().get(i));
         }
         searchOption.setSelectedIndex(1);
      }
      if(e.getSource()==searchButton || e.getSource()==search)
      {
         if(searchOption.getSelectedItem().toString().equals("Member"))
         {
            setTopLabel(searchOption.getSelectedItem().toString());
            fileAdapter.updateMembersList();
            ArrayList<Member> tempFound1 = new ArrayList<Member>();
            if(search.getText().equals("Search"))
            {
               fileAdapter.updateMembersList();
               listBigInfoBox.clear();
               for(int i = 0;i<fileAdapter.getMembersList().getMembersList().size();i++)
               {
                  listBigInfoBox.addElement(fileAdapter.getMembersList().getMembersList().get(i));
               }
               searchOption.setSelectedIndex(0);
            }
            else
            {
            for(int i = 0;i<fileAdapter.getMembersList().getMembersList().size();i++)
            {
               if(fileAdapter.getMembersList().getMembersList().get(i).getName().toLowerCase().contains(search.getText().toLowerCase())
                     || fileAdapter.getMembersList().getMembersList().get(i).getEMail().contains(search.getText()) || fileAdapter.getMembersList().getMembersList().get(i).getPhoneNumber().contains(search.getText()))
               {
                  tempFound1.add(fileAdapter.getMembersList().getMembersList().get(i));
               }               
            }
            
            listBigInfoBox.clear();
            for(int j = 0;j<tempFound1.size();j++)
            {
               listBigInfoBox.addElement(tempFound1.get(j));
            }
            }
         }
         if(searchOption.getSelectedItem().toString().equals("Instructor"))
         {
            setTopLabel(searchOption.getSelectedItem().toString());
            fileAdapter.updateInstructorsList();
            ArrayList<Instructor> tempFound1 = new ArrayList<Instructor>();
            if(search.getText().equals("Search"))
            {
               fileAdapter.updateInstructorsList();
               listBigInfoBox.clear();
               for(int i = 0;i<fileAdapter.getInstructorsList().getInstructorsList().size();i++)
               {
                  listBigInfoBox.addElement(fileAdapter.getInstructorsList().getInstructorsList().get(i));
               }
               searchOption.setSelectedIndex(1);
            }
            else
            {
            for(int i = 0;i<fileAdapter.getInstructorsList().getInstructorsList().size();i++)
            {
               if(fileAdapter.getInstructorsList().getInstructorsList().get(i).getName().toLowerCase().contains(search.getText().toLowerCase()))
               {
                  tempFound1.add(fileAdapter.getInstructorsList().getInstructorsList().get(i));
               }               
            }
            
            listBigInfoBox.clear();
            for(int j = 0;j<tempFound1.size();j++)
            {
               listBigInfoBox.addElement(tempFound1.get(j));
            }
            }
         }
         if(searchOption.getSelectedItem().toString().equals("Event"))
         {
            setTopLabel(searchOption.getSelectedItem().toString());
            fileAdapter.updateEventsList();
            ArrayList<Event> tempFound = new ArrayList<Event>();
            if(search.getText().equals("Search"))
            {
               fileAdapter.updateEventsList();
               listBigInfoBox.clear();
               for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
               {
                  listBigInfoBox.addElement(fileAdapter.getEventsList().getEventsList().get(i));
               }
               searchOption.setSelectedIndex(2);
            }
            else
            {
            for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
            {
               if(fileAdapter.getEventsList().getEventsList().get(i).getClassName().toLowerCase().contains(search.getText().toLowerCase()) || fileAdapter.getEventsList().getEventsList().get(i).getClassTypeString().toLowerCase().contains(search.getText().toLowerCase()))
               {
                  
                  tempFound.add(fileAdapter.getEventsList().getEventsList().get(i));
               }
            }
            
            
            listBigInfoBox.clear();
            for(int j = 0;j<tempFound.size();j++)
            {
               listBigInfoBox.addElement(tempFound.get(j));
            }
         }
         }
      }
      
      if(e.getSource()==homeDetails)
      {
         if(!bigInfoBox.isSelectionEmpty())
         {
         if(searchOption.getSelectedItem().toString().equals("Member"))
         {
            Member temp = (Member)bigInfoBox.getSelectedValue();
            newMemberGUI tempWindow = new newMemberGUI();
            tempWindow.fillWithMember(temp);
         }
         if(searchOption.getSelectedItem().toString().equals("Instructor"))
         {
            Instructor temp = (Instructor)bigInfoBox.getSelectedValue();
            newInstructorGUI tempWindow = new newInstructorGUI();
            tempWindow.fillWithInstructor(temp);
         }
         if(searchOption.getSelectedItem().toString().equals("Event"))
         {
            Event temp = (Event)bigInfoBox.getSelectedValue();
            newEventGUI tempWindow = new newEventGUI();
            tempWindow.fillWithEvent(temp);
         }
         }
      }
      if(e.getSource()==upcomingDetails)
      {
         if(!upcomingEvents.isSelectionEmpty())
         {
         Event temp = null;
         for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
         {
            if(fileAdapter.getEventsList().getEventsList().get(i).toSmallString().equals(upcomingEvents.getSelectedValue()))
            {
               temp = fileAdapter.getEventsList().getEventsList().get(i);
            }
         }
         newEventGUI tempWindow = new newEventGUI();
         tempWindow.fillWithEvent(temp);
         }
      }
      if(e.getSource()==ongoingDetails)
      {
         if(!ongoingEvents.isSelectionEmpty())
         {
         Event temp = null;
         for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
         {
            if(fileAdapter.getEventsList().getEventsList().get(i).toSmallString().equals(ongoingEvents.getSelectedValue()))
            {
               temp = fileAdapter.getEventsList().getEventsList().get(i);
            }
         }
         newEventGUI tempWindow = new newEventGUI();
         tempWindow.fillWithEvent(temp);
         }
      }
      if(e.getSource()==searchOption)
      {
         if(searchOption.getSelectedIndex()==0 && listBigInfoBox.getElementAt(0) instanceof Member)
         {
            setTopLabel(searchOption.getSelectedItem().toString());
         }
         if(searchOption.getSelectedIndex()==1 && listBigInfoBox.getElementAt(0) instanceof Instructor)
         {
            setTopLabel(searchOption.getSelectedItem().toString());
         }
         if(searchOption.getSelectedIndex()==2 && listBigInfoBox.getElementAt(0) instanceof Event)
         {
            setTopLabel(searchOption.getSelectedItem().toString());
         }
      }
   }
   public void setTopLabel(String type)
   {
      if(type.equals("Member"))
      {
         String eventString = "<html><pre style='font-size:11px'>"+"Member name\t       Email\t          Phone number\t          Sign up date\t            ID"+"</pre></html>";
         aboveBigInfo.setText(eventString);
      }
      if(type.equals("Instructor"))
      {
         String eventString = "<html><pre style='font-size:11px'>"+"Instructor name\t\t   ID\t\t  Qualified for:</pre></html>";
         aboveBigInfo.setText(eventString);
      }
      if(type.equals("Event"))
      {
         String eventString = "<html><pre style='font-size:11px'>"+"Event name\t     Type\t    Max members\t\t  Date\t\t           Time"+"</pre></html>";
         aboveBigInfo.setText(eventString);
      }
   }
   
   //FocusListener uses to fire action upon gaining or losing focus
   public void focusGained(FocusEvent e)
   {
      if(e.getSource()==search)
      {
         if(search.getText().equals("Search"))
         {
            search.setText(""); 
         }
         else search.setText(search.getText());
      }
   }
   public void focusLost(FocusEvent e)
   {
      if(e.getSource()==search)
      {
         if(search.getText().equals(""))
         {
            search.setText("Search");
         }
      }
   }
}

/**
 * Inner list listener class
 * @author sst
 * @version 1.0
 */
private class MyListSelectionListener implements ListSelectionListener
{
   public void valueChanged(ListSelectionEvent e)
   {
      if(e.getSource()==ongoingEvents)
      {
         //what should happen here
      }
      if(e.getSource()==upcomingEvents)
      {
         //what should happen here
      }
      if(e.getSource()==bigInfoBox)
      {
         //what should happen here
      }
   }
}



public void showAllofType(String type)
{
   
}


public void updateOnGoingEventsArea()
{
   fileAdapter.updateOnGoingEventsList();
   if(fileAdapter.getOnGoingEventsList()!=null)
   {
      listOngoing = new DefaultListModel<String>();
      for(int i = 0;i<fileAdapter.getOnGoingEventsList().size();i++)
      {
         listOngoing.addElement(fileAdapter.getOnGoingEventsList().get(i).toSmallString());
      }
      ongoingEvents.setModel(listOngoing);
   }
}

public void updateUpcomingEventsArea()
{
   fileAdapter.updateUpComingEventsList();
   if(fileAdapter.getUpComingEventsList()!=null)
   {
      listUpcoming = new DefaultListModel<String>();
      for(int i = 0;i<fileAdapter.getUpComingEventsList().size();i++)
      {
         listUpcoming.addElement(fileAdapter.getUpComingEventsList().get(i).toSmallString());
      }
      upcomingEvents.setModel(listUpcoming);
   }
}


/////////////////////////////////////// GUI /////////////////////////////////////// 


public mainGUI() 
{
   super("ViaFit Fitness centre V. 1.0");
   
   myListener = new MyListener();
   fileAdapter = new FileAdapter();
   eventsList = new EventsList();
   membersList = new MembersList();
   instructorsList = new InstructorsList(); 
   
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
   homeAlign2 = new JPanel();
   homeCenterAlign = new JPanel();
   homeCenterAlign2 = new JPanel();
   
   ongoingEventsLabel = new JLabel("Ongoing events");
   upcomingEventsLabel = new JLabel("Upcoming events");
   memberLabel = new JLabel("Member");
   instructorLabel = new JLabel("Instructor");
   eventLabel = new JLabel("Event");
   homeLabel = new JLabel();
   aboveOngoing = new JLabel("<html><pre style='font-size:11px'>"+"Event name\tAttending members"+"</pre></html>");
   aboveOngoing.setPreferredSize(new Dimension(330,17));
   aboveUpcoming = new JLabel("<html><pre style='font-size:11px'>"+"Event name\tAttending members"+"</pre></html>");
   aboveUpcoming.setPreferredSize(new Dimension(330,17));
   aboveBigInfo = new JLabel("<html><pre style='font-size:11px'>"+"</pre></html>");
   aboveBigInfo.setHorizontalAlignment(SwingConstants.LEFT);
   aboveBigInfo.setMinimumSize(new Dimension(900, 25));
   aboveBigInfo.setMaximumSize(new Dimension(900, 25));
   
   listOngoing = new DefaultListModel<String>();
   ongoingEvents = new JList<String>(listOngoing);
   ongoingEventsScroll = new JScrollPane(ongoingEvents);
   ongoingEvents.addListSelectionListener(listListener);
   
   listUpcoming = new DefaultListModel<String>();
   upcomingEvents = new JList<String>(listUpcoming);
   updateUpcomingEventsArea();
   updateOnGoingEventsArea();
   upcomingEventsScroll = new JScrollPane(upcomingEvents);
   upcomingEvents.addListSelectionListener(listListener);
   
   listBigInfoBox = new DefaultListModel<Object>();
   bigInfoBox = new JList<Object>(listBigInfoBox);
   bigInfoBox.addListSelectionListener(listListener);
   bigInfoScroll = new JScrollPane(bigInfoBox);
   search = new JTextField("Search");
   search.addFocusListener(myListener);
   search.addActionListener(myListener);
   
   memberNew = new JButton("New member");
   memberNew.addActionListener(myListener);
   memberAll = new JButton("Show all");
   memberAll.addActionListener(myListener);
   instructorNew = new JButton("New instructor");
   instructorNew.addActionListener(myListener);
   instructorAll = new JButton("Show all");
   instructorAll.addActionListener(myListener);
   eventNew = new JButton("New event");
   eventNew.addActionListener(myListener);
   eventAll = new JButton("Show all");
   eventAll.addActionListener(myListener);
   upcomingDetails = new JButton("Show event information");
   upcomingDetails.addActionListener(myListener);
   ongoingDetails = new JButton("Show event information");
   ongoingDetails.addActionListener(myListener);
   homeDetails = new JButton("Details");
   homeDetails.addActionListener(myListener);
   searchButton = new JButton("Search");
   searchButton.addActionListener(myListener);
   
   
   String[] options = {"Member", "Instructor", "Event"}; 
   searchOption = new JComboBox<String>(options); 
   searchOption.addActionListener(myListener);
   
   menubar = new JMenuBar();
   
   fileMenu = new JMenu("File");
   aboutMenu = new JMenu("About");
   
   exitButton = new JMenuItem("Exit");
   exitButton.addActionListener(myListener);
   about = new JMenuItem("About");
   about.addActionListener(myListener);
   
   vialogo = new ImageIcon(Main.class.getResource("/imgPackage/logoTransBigger.png"));
   
   
   //adding borders

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
   bigInfoBox.setFont(new Font(bigInfoScroll.getFont().getFamily(), Font.BOLD, 17));
   
   //adding stuff to the menuBar
   fileMenu.add(exitButton);
   aboutMenu.add(about);
   menubar.add(fileMenu);
   menubar.add(aboutMenu);
   
   //adding panels to events frame
   events.setLayout(new BoxLayout(events, BoxLayout.Y_AXIS));
   events.add(ongoingPanel);
   events.add(upcomingPanel);
   ongoingPanel.setLayout(new BoxLayout(ongoingPanel, BoxLayout.Y_AXIS));
   upcomingPanel.setLayout(new BoxLayout(upcomingPanel, BoxLayout.Y_AXIS));
   ongoingPanel.add(ongoingEventsLabel);
   ongoingPanel.add(aboveOngoing);
   ongoingPanel.add(ongoingEventsScroll);
   upcomingPanel.add(upcomingEventsLabel);
   upcomingPanel.add(aboveUpcoming);
   upcomingPanel.add(upcomingEventsScroll);
   ongoingPanel.add(ongoingDetails);
   upcomingPanel.add(upcomingDetails);
         //setting size of panels and fields in JPanel events (Left side)
   events.setPreferredSize(new Dimension(330, 1080));
   ongoingPanel.setMinimumSize(new Dimension(330, 370));
   ongoingPanel.setMaximumSize(new Dimension(330, 370));
   upcomingPanel.setMinimumSize(new Dimension(330, 370));
   upcomingPanel.setMaximumSize(new Dimension(330, 370));
   ongoingPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
   upcomingPanel.setBorder(new EmptyBorder(0, 15, 0, 0));
   ongoingEventsLabel.setPreferredSize(new Dimension(330, 70));
   upcomingEventsLabel.setPreferredSize(new Dimension(330, 70));
   ongoingEventsScroll.setPreferredSize(new Dimension(330, 160));
   ongoingEventsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   ongoingEvents.setVisibleRowCount(-1);
   upcomingEventsScroll.setPreferredSize(new Dimension(330, 155));
   upcomingEventsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   upcomingEvents.setVisibleRowCount(-1);
   
   //adding buttons to home panel
//   homeCorner.setLayout(new GridLayout(2, 1));
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
   homeNorthCenterAlign.add(searchButton);
   homeNorthCenterAlign.setBorder(new EmptyBorder(40, 0, 15, 0));
   search.setPreferredSize(new Dimension(400, 30));
   searchOption.setPreferredSize(new Dimension(125, 30));
   searchButton.setPreferredSize(new Dimension(80, 29));
   homeNorth.add(homeNorthCenterAlign);
   homeNorth.add(aboveBigInfo);
   
   
   //adding panels to homeCenter frame
   homeCenter.setLayout(new BoxLayout(homeCenter, BoxLayout.Y_AXIS));
   homeCenterAlign2.add(bigInfoScroll);
   homeCenter.add(homeCenterAlign2);
   bigInfoScroll.setPreferredSize(new Dimension(900, 400));
   bigInfoScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
   bigInfoBox.setVisibleRowCount(-1);
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
   
   
   
   //method for asking the user to confirm before closing the JFrame
   addWindowListener(new WindowAdapter()
   {
       public void windowClosing(WindowEvent e)
       {
          int yesno = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Confirm closing application", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
          if(yesno == JOptionPane.YES_OPTION)
          {
             System.exit(0);
          }
       }
   });

   
   
   setJMenuBar(menubar);
   add(main);
   setSize(1366, 768);
   setResizable(false);
   setVisible(true);
   setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
   setLocationRelativeTo(null);
}
}
