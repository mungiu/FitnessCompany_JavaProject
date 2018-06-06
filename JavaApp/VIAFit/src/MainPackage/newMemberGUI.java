package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
   private JLabel showOnly;
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
   private JComboBox<String> classTypeInput;
   
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
   
   private MyListener myListener;
   private FileAdapter fileAdapter;
   private EventsList eventsList;
   private MembersList membersList;
   private ClassTypesList classTypesList;
   private boolean alreadyMember;
   
   
   
   
   private class MyListener implements ActionListener, FocusListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(e.getSource()==close)
         {
            dispose();
         }
         if(e.getSource()==exit)
         {
            dispose();
         }
         if(e.getSource()==about)
         {
            JOptionPane.showMessageDialog(null, "This is a program written by Group 1 for the SEP1 Project.\nMade for ViaFit Fitness Centre.\nVersion 1.0", "About", JOptionPane.PLAIN_MESSAGE);
         }
         if(e.getSource()==editInfo)
         {
            if(editInfo.getState()==true)
            {
               editMemberGUI(true);
            }
            if(editInfo.getState()==false)
            {
               editMemberGUI(false);
            }
         }
         if(e.getSource()==signUp)
         {
            fileAdapter.getEventsList();
            Member temp = null;
            for(int i = 0;i<fileAdapter.getMembersList().getMembersList().size();i++)
            {
               if(fileAdapter.getMembersList().getMembersList().get(i).getMemberID()==Integer.parseInt(memberIDInput.getText()))
               {
                  temp = fileAdapter.getMembersList().getMembersList().get(i);
               }
            }
            if(!allEvents.getSelectedValue().getMembersList().contains(temp))
                  {
                     allEvents.getSelectedValue().getMembersList().add(temp);
                  }
               fileAdapter.saveEventsListToBin(fileAdapter.getEventsList().getEventsList());
               fileAdapter.updateEventsList();
               
               //update box to show the added
               listSignedUp.clear();
               for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
               {
                  if(fileAdapter.getEventsList().getEventsList().get(i).getMembersList().contains(temp))
                  {
                     listSignedUp.addElement(fileAdapter.getEventsList().getEventsList().get(i));
                  }
               }
               listModel.clear();
               for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
               {
                  if(classTypeInput.getSelectedItem().toString().equals("Choose Event Type"))
                  {
                     listModel.addElement(fileAdapter.getEventsList().getEventsList().get(i));
                  }
                  if(fileAdapter.getEventsList().getEventsList().get(i).getClassType().equals(classTypeInput.getSelectedItem().toString()))
                  {
                     listModel.addElement(fileAdapter.getEventsList().getEventsList().get(i));
                  }
               }
         }
         if(e.getSource()==removeFrom)
         {
            Member temp = null;
            for(int i = 0;i<fileAdapter.getMembersList().getMembersList().size();i++)
            {
               if(fileAdapter.getMembersList().getMembersList().get(i).getMemberID()==Integer.parseInt(memberIDInput.getText()))
               {
                  temp = fileAdapter.getMembersList().getMembersList().get(i);
               }
            }
           allSignedUpForArea.getSelectedValue().getMembersList().remove(temp);
           fileAdapter.saveEventsListToBin(fileAdapter.getEventsList().getEventsList());
           fileAdapter.updateEventsList();
           //update box to remove the event
           listSignedUp.clear();
           for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
           {
              if(fileAdapter.getEventsList().getEventsList().get(i).getMembersList().contains(temp))
              {
                 listSignedUp.addElement(fileAdapter.getEventsList().getEventsList().get(i));
              }
           }
           listModel.clear();
           for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
           {
              if(classTypeInput.getSelectedItem().toString().equals("Choose Event Type"))
              {
                 listModel.addElement(fileAdapter.getEventsList().getEventsList().get(i));
              }
              if(fileAdapter.getEventsList().getEventsList().get(i).getClassType().equals(classTypeInput.getSelectedItem().toString()))
              {
                 listModel.addElement(fileAdapter.getEventsList().getEventsList().get(i));
              }
           }
         }
         if(e.getSource()==save)
         {
            Member tempMember = null;
            fileAdapter.updateMembersList();
            if(alreadyMember==true)
            {
               for(int i = 0;i<fileAdapter.getMembersList().getMembersList().size();i++)
               {
                  if(fileAdapter.getMembersList().getMembersList().get(i).getMemberID()==Integer.parseInt(memberIDInput.getText()))
                  {
                     tempMember = fileAdapter.getMembersList().getMembersList().get(i);
                  }
               }
              tempMember.setName(nameInput.getText());
              if(membershipTypeInput.getSelectedIndex()==0)
              {
                 tempMember.setIsPremium(true);
              }
              tempMember.setEMail(emailInput.getText());
              tempMember.setPhoneNumber(phoneInput.getText());
              tempMember.setMemberSince(new MyDate(Integer.parseInt(membershipSinceInputDay.getText()), Integer.parseInt(membershipSinceInputMonth.getText()), Integer.parseInt(membershipSinceInputYear.getText())));
              
              fileAdapter.saveMembersListToBin(fileAdapter.getMembersList().getMembersList());
              fileAdapter.updateMembersList();
            }
            else 
            {
            
            String name = nameInput.getText();
            boolean type = false;
            if(membershipTypeInput.getSelectedIndex()==0)
            {
               type = true;
            }
            MyDate memberSince = new MyDate(Integer.parseInt(membershipSinceInputDay.getText()), Integer.parseInt(membershipSinceInputMonth.getText()), Integer.parseInt(membershipSinceInputYear.getText()));
            String email = emailInput.getText();
            String phone = phoneInput.getText();
            int newMemberId = Integer.parseInt(memberIDInput.getText()+"");
            tempMember = new Member(name, email, phone, type, newMemberId);
            tempMember.setMemberSince(memberSince);
            fileAdapter.saveMemberToAvailableBinList(tempMember);
            fileAdapter.updateMembersList();
            }
            dispose();
         }
         if(e.getSource()==remove)
         {
            fileAdapter.updateMembersList();
            int yesno = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this member?", "Confirm before deleting member", JOptionPane.YES_NO_OPTION);
            if(yesno==JOptionPane.YES_OPTION)
               {
                  for(int i = 0;i<fileAdapter.getMembersList().getMembersList().size();i++)
                  {
                        if(fileAdapter.getMembersList().getMembersList().get(i).getMemberID()==Integer.parseInt(memberIDInput.getText()))
                        {
                        fileAdapter.getMembersList().getMembersList().remove(i);
                        fileAdapter.saveMembersListToBin(fileAdapter.getMembersList().getMembersList());
                        fileAdapter.updateMembersList();
                        dispose();
                        }
                  }
               }
         }
         if(e.getSource()==classTypeInput)
         {
            listModel.clear();
            for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
            {
               if(classTypeInput.getSelectedItem().toString().equals("Choose Event Type"))
               {
                  listModel.addElement(fileAdapter.getEventsList().getEventsList().get(i));
               }
               if(fileAdapter.getEventsList().getEventsList().get(i).getClassType().equals(classTypeInput.getSelectedItem().toString()))
               {
                  listModel.addElement(fileAdapter.getEventsList().getEventsList().get(i));
               }
            }
         }
      }

      //Focus listener
      public void focusGained(FocusEvent e)
      {
         if(e.getSource()==membershipSinceInputDay)
         {
            if(membershipSinceInputDay.getText().equals("Day"))
            {
               membershipSinceInputDay.setText("");
            }
            else membershipSinceInputDay.setText(membershipSinceInputDay.getText());
         }
         if(e.getSource()==membershipSinceInputMonth)
         {
            if(membershipSinceInputMonth.getText().equals("Month"))
            {
               membershipSinceInputMonth.setText("");
            }
            else membershipSinceInputMonth.setText(membershipSinceInputMonth.getText());
         }
         if(e.getSource()==membershipSinceInputYear)
         {
            if(membershipSinceInputYear.getText().equals("Year"))
            {
               membershipSinceInputYear.setText("");
            }
            else membershipSinceInputYear.setText(membershipSinceInputYear.getText());
         }
      }
      public void focusLost(FocusEvent e)
      {
         if(e.getSource()==membershipSinceInputDay)
         {
            if(membershipSinceInputDay.getText().equals(""))
            {
               membershipSinceInputDay.setText("Day");
            }
         }
         if(e.getSource()==membershipSinceInputMonth)
         {
            if(membershipSinceInputMonth.getText().equals(""))
            {
               membershipSinceInputMonth.setText("Month");
            }
         }
         if(e.getSource()==membershipSinceInputYear)
         {
            if(membershipSinceInputYear.getText().equals(""))
            {
               membershipSinceInputYear.setText("Year");
            }
         }
      }
   }
   
   public JTextField getMemberIDInput()
   {
      return memberIDInput;
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   public void fillWithMember(Member member)
   {
      fileAdapter.updateEventsList();
      fileAdapter.updateClassTypesList();
      fileAdapter.updateMembersList();
      alreadyMember = true;
      editMemberGUI(false);
      nameInput.setText(member.getName());
      if(member.getIsPremium())
      {
        membershipTypeInput.setSelectedIndex(0);
      }
      else membershipTypeInput.setSelectedIndex(1);
      membershipSinceInputDay.setText(member.getMemberSince().getDay()+"");
      membershipSinceInputMonth.setText(member.getMemberSince().getMonth()+"");
      membershipSinceInputYear.setText(member.getMemberSince().getYear()+"");
      memberIDInput.setText(member.getMemberID()+"");
      emailInput.setText(member.getEMail());
      phoneInput.setText(member.getPhoneNumber());
      
      
      for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
      {
         if(fileAdapter.getEventsList().getEventsList().get(i).getMembersList().contains(member))
         {
            listSignedUp.addElement(fileAdapter.getEventsList().getEventsList().get(i));
         }
      }
      for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
      {
         if(classTypeInput.getSelectedItem().toString().equals("Choose Event Type"))
         {
            listModel.addElement(fileAdapter.getEventsList().getEventsList().get(i));
         }
         if(fileAdapter.getEventsList().getEventsList().get(i).getClassType().equals(classTypeInput.getSelectedItem().toString()))
         {
            listModel.addElement(fileAdapter.getEventsList().getEventsList().get(i));
         }
      }
   }
  
      public void editMemberGUI(boolean s)
      {
         if(s==false)
         {
            editInfo.setSelected(false);
            nameInput.setEnabled(false);
            membershipTypeInput.setEnabled(false);
            emailInput.setEnabled(false);
            phoneInput.setEnabled(false);
            membershipSinceInputDay.setEnabled(false);
            membershipSinceInputMonth.setEnabled(false);
            membershipSinceInputYear.setEnabled(false);
         }
         if(s==true)
         {
            editInfo.setSelected(true);
            nameInput.setEnabled(true);
            membershipTypeInput.setEnabled(true);
            emailInput.setEnabled(true);
            phoneInput.setEnabled(true);
            membershipSinceInputDay.setEnabled(true);
            membershipSinceInputMonth.setEnabled(true);
            membershipSinceInputYear.setEnabled(true);
         }
      }
   
/////////////////////////////////////// GUI ///////////////////////////////////////
   
   public newMemberGUI() 
   {   
   super("Member - ViaFit Fitness centre");
   
   classTypesList = new ClassTypesList();
   myListener = new MyListener();
   fileAdapter = new FileAdapter();
   eventsList = new EventsList();
   membersList = new MembersList();
   
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
   showOnly = new JLabel("Show events of type:");
   allSignedupForLabel = new JLabel("Signed up for:");
   
   nameInput = new JTextField();
   memberIDInput = new JTextField("");
   memberIDInput.setEditable(false);
   emailInput = new JTextField();
   new MyDate();
   membershipSinceInputDay = new JTextField(MyDate.today().getDay()+"");
   membershipSinceInputDay.setEditable(false);
   membershipSinceInputDay.addFocusListener(myListener);
   membershipSinceInputMonth = new JTextField(MyDate.today().getMonth()+"");
   membershipSinceInputMonth.setEditable(false);
   membershipSinceInputMonth.addFocusListener(myListener);
   membershipSinceInputYear = new JTextField(MyDate.today().getYear()+"");
   membershipSinceInputYear.setEditable(false);
   membershipSinceInputYear.addFocusListener(myListener);
   phoneInput = new JTextField();
   
   listModel = new DefaultListModel<Event>();
   allEvents = new JList<Event>(listModel);
   allEventsScroll = new JScrollPane(allEvents);
   listSignedUp = new DefaultListModel<Event>();
   allSignedUpForArea = new JList<Event>(listSignedUp);
   allSignedUpForScroll = new JScrollPane(allSignedUpForArea);
   
   String[] temp = {"Premium", "Standard"};
   membershipTypeInput = new JComboBox<String>(temp);
   fileAdapter.updateClassTypesList();
   classTypeInput = new JComboBox<String>(fileAdapter.getClassTypesList().getClassTypesArr());
   classTypeInput.addActionListener(myListener);
   
   save = new JButton("Save");
   save.addActionListener(myListener);
   close = new JButton("Close");
   close.addActionListener(myListener);
   signUp = new JButton("Sign up for event");
   signUp.addActionListener(myListener);
   removeFrom = new JButton("Remove from event");
   removeFrom.addActionListener(myListener);
   
   menuBar = new JMenuBar();
   
   fileMenu = new JMenu("File");
   editMenu = new JMenu("Edit");
   aboutMenu = new JMenu("About");
   
   remove = new JMenuItem("Delete member");
   remove.addActionListener(myListener);
   exit = new JMenuItem("Exit");
   exit.addActionListener(myListener);
   about = new JMenuItem("About");
   about.addActionListener(myListener);
   editInfo = new JCheckBoxMenuItem("Edit member");
   editInfo.addActionListener(myListener);
   
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
   allEventsbox.add(showOnly);
   allEventsbox.add(classTypeInput);
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
