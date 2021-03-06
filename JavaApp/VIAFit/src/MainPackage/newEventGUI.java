package MainPackage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

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
	private JTextField id;

	private DefaultListModel<Instructor> listInstructors;
	private DefaultListModel<String> listMembers;
	private JList<Instructor> attendingInstructorsArea;
	private JList<String> attendingMembersArea;
	private JScrollPane attendingInstructorsAreaScroll;
	private JScrollPane attendingMembersAreaScroll;

	private String[] tempIns =
	{ "Change this later", "Remember to change this" };
	private JComboBox<String> instructorCombo;
	private String[] tempType =
	{ "Change this later", "Remember to change this" };
	private JComboBox<String> typeCombo;
	private String[] tempDura =
	{ "1 hour", "2 hours", "3 hours", "4 hours", "5 hours" };
	private JComboBox<String> duraCombo;
	private String[] tempInsBottom =
	{ "Change this later", "Remember to change this" };
	private JComboBox<String> instructorComboBottom;
	private DefaultComboBoxModel<String> comboModel;
	private DefaultComboBoxModel<String> instructorModel;

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
	private JCheckBoxMenuItem newTypeMenu; 
	private JMenuItem deleteClassType;

	private ImageIcon logo;
	private JLabel logoLabel;
	private MyListener myListener;

	private FileAdapter fileAdapter;
	private EventsList eventsList;
	private InstructorsList instructorsList;
	private ClassTypesList classTypesList;
	private boolean alreadyEvent;

	/**
	 * Inner myListener
	 * 
	 * @author sst
	 * @version 1.0
	 */
	private class MyListener implements ActionListener, FocusListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == close)
			{
				dispose();
			}
			if (e.getSource() == exit)
			{
				dispose();
			}
			if (e.getSource() == about)
			{
				JOptionPane.showMessageDialog(null,
						"This is a program written by Group 1 for the SEP1 Project.\nMade for ViaFit Fitness Centre.\nVersion 1.0",
						"About", JOptionPane.PLAIN_MESSAGE);
			}
			if (e.getSource() == editInfo)
			{
				if (editInfo.isSelected() == true)
				{
					editEventArea(true);
				}
				if (editInfo.isSelected() == false)
				{
					editEventArea(false);
				}
			}
			if (e.getSource() == save)
			{
			   if(checkIfOnlyInts(maxMembersInput.getText()) 
			         && checkIfOnlyInts(startDateDay.getText()) 
			         && checkIfOnlyInts(startDateMonth.getText()) 
			         && checkIfOnlyInts(startDateYear.getText()) 
			         && checkIfOnlyInts(startTimeHour.getText()) 
			         && checkIfOnlyInts(startTimeMinute.getText()) 
			         && !nameInput.getText().equals("") 
			         && ((typeCombo.getSelectedIndex()!=0) || !typeInput.getText().equals(""))
			         && nameInput.getText().length()<20
			         && Integer.parseInt(startTimeHour.getText())<24
			         && Integer.parseInt(startTimeMinute.getText())<60)
			   {
			   ClassType tempType = new ClassType("nothing");
			   if(newTypeMenu.isSelected()==true)
			   {
			      fileAdapter.getClassTypesList().getClassTypesList().add(new ClassType(typeInput.getText()));
			      fileAdapter.saveClassTypesListToBin(fileAdapter.getClassTypesList().getClassTypesList());
			      tempType.setClassName(typeInput.getText());
			   }
			   if(newTypeMenu.isSelected()==false)
			   {
			      tempType = new ClassType(typeCombo.getSelectedItem().toString());   
			   }
				String className = nameInput.getText();
				int maxNumbers = Integer.parseInt(maxMembersInput.getText());
				MyDate startDate = new MyDate(Integer.parseInt(startDateDay.getText()),
						Integer.parseInt(startDateMonth.getText()), Integer.parseInt(startDateYear.getText()));
				MyDate endDate = new MyDate(Integer.parseInt(endDateDay.getText()),
						Integer.parseInt(endDateMonth.getText()), Integer.parseInt(endDateYear.getText()));
				MyClock startTime = new MyClock(Integer.parseInt(startTimeHour.getText()),
						Integer.parseInt(startTimeMinute.getText()), 0);
				String tempDura = duraCombo.getSelectedItem().toString().charAt(0) + "";
				int duration = Integer.parseInt(tempDura);
				MyClock endTime = new MyClock(Integer.parseInt(startTimeHour.getText()) + duration, Integer.parseInt(startTimeMinute.getText()), 0);
				int newEventId = Integer.parseInt(id.getText()+"");
				
				Event temp = new Event(tempType, className, maxNumbers, startDate, endDate, startTime, endTime, newEventId);
				
				if(alreadyEvent)
				{
				   for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
				   {
				      if(id.getText().equals(fileAdapter.getEventsList().getEventsList().get(i).getEventID()+""))
				      {
				         temp = fileAdapter.getEventsList().getEventsList().get(i);
				      }
				   }
				   temp.setClassName(className);
				   temp.setClassType(tempType.toString());
				   temp.setMaxMembers(maxNumbers);
				   temp.setStartTime(startTime);
				   temp.setEndTime(endTime);
				   temp.setStartDate(startDate);
				   temp.setEndDate(endDate);
				   
				   ArrayList<Instructor> tempInstructorsList = new ArrayList<Instructor>();
				   for(int i = 0;i<listInstructors.getSize();i++)
				   {
				      if(!tempInstructorsList.contains(listInstructors.get(i)))
				      {
				         tempInstructorsList.add(listInstructors.getElementAt(i));
				      }
				   }
				   temp.setInstructorsList(tempInstructorsList);
				   fileAdapter.saveEventsListToBin(fileAdapter.getEventsList().getEventsList());
				   fileAdapter.updateEventsList();
				}
				else if(editInfo.isSelected()==true)
				{
				   temp.setEventID(Integer.parseInt(id.getText()+""));
				   fileAdapter.saveEventToAvailableBinList(temp);
				   fileAdapter.updateEventsList();
				}
				dispose();
			   }
			   else JOptionPane.showMessageDialog(null, "Please make sure all fields are filled correctly", "Information missing or wrong", JOptionPane.OK_OPTION);
			}
			if(e.getSource()==addInstructor)
			{
			   if(alreadyEvent)
			   {
			      Instructor temp = null;
			      for(int i = 0;i<fileAdapter.getInstructorsList().getInstructorsList().size();i++)
			      {
			         if(fileAdapter.getInstructorsList().getInstructorsList().get(i).toSmallString().equals(instructorCombo.getSelectedItem()))
			         {
			            temp = fileAdapter.getInstructorsList().getInstructorsList().get(i);
			         }
			      }
			      if(!listInstructors.contains(temp))
			      {
			         listInstructors.addElement(temp);
			      }
			   }
			   else JOptionPane.showMessageDialog(null, "Please save the event before adding and removing instructors");
			}
			
			if(e.getSource()==newTypeMenu)
			{
			   if(newTypeMenu.isSelected()==true)
			   {
			      typeCombo.setVisible(false);
			      typeInput.setVisible(true);
			      addInstructor.setEnabled(false);
			      instructorCombo.setEnabled(false);
			   }
			   if(newTypeMenu.isSelected()==false)
            {
               typeCombo.setVisible(true);
               typeInput.setVisible(false);
               addInstructor.setEnabled(true);
               instructorCombo.setEnabled(true);
            }
			}
			if(e.getSource()==remove)
			{
			   fileAdapter.updateEventsList();
			  int yesno = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this event?", "Confirm before deleting event", JOptionPane.YES_NO_OPTION);
			   if(yesno==JOptionPane.YES_OPTION)
			      {
			         for(int i = 0;i<fileAdapter.getEventsList().getEventsList().size();i++)
			         {
			               if(id.getText().equals(fileAdapter.getEventsList().getEventsList().get(i).getEventID()+""))
			               {
			               fileAdapter.getEventsList().getEventsList().remove(i);
			               fileAdapter.saveEventsListToBin(fileAdapter.getEventsList().getEventsList());
			               fileAdapter.updateEventsList();
			               dispose();
			               }
			         }
			      }
			}
			if(e.getSource()==deleteClassType)
			{
			   
			   for(int i = 0;i<fileAdapter.getClassTypesList().getClassTypesList().size();i++)
			   {
			      if(fileAdapter.getClassTypesList().getClassTypesList().get(i).getClassName().equals(typeCombo.getSelectedItem().toString()))
			      {
			         fileAdapter.getClassTypesList().getClassTypesList().remove(i);
			      }
			   }
			   fileAdapter.saveClassTypesListToBin(fileAdapter.getClassTypesList().getClassTypesList());
			   fileAdapter.updateClassTypesList();
			   updateClassTypeComboBox();
			}
			if(e.getSource()==removeInstructor)
			{
			   if(alreadyEvent)
			   {
			      listInstructors.removeElement(attendingInstructorsArea.getSelectedValue());
			   }
			   else JOptionPane.showMessageDialog(null, "Please save the event before adding and removing instructors");
			}
			if(e.getSource()==typeCombo)
			{
			   ClassType temp = null;
			   for(int i = 0;i<fileAdapter.getClassTypesList().getClassTypesList().size();i++)
			   {
			      if(fileAdapter.getClassTypesList().getClassTypesList().get(i).getClassName().equals(typeCombo.getSelectedItem().toString()))
			      {
			         temp = fileAdapter.getClassTypesList().getClassTypesList().get(i);
			      }
			   }
			   ArrayList<String> tempQualified= new ArrayList<String>();
		      for(int k = 0;k<fileAdapter.getInstructorsList().getInstructorsList().size();k++)
		      {
		         if(fileAdapter.getInstructorsList().getInstructorsList().get(k).getQualifiedClassesList().contains(temp))
		         {
		            tempQualified.add(fileAdapter.getInstructorsList().getInstructorsList().get(k).toSmallString());
		         }
		      }
		      if(tempQualified.size()!=0)
		      {
		         tempIns = tempQualified.toArray(new String[0]);
		      }
		      else 
		      {
		         tempIns = new String[1];
		         tempIns[0] = "No instructors qualified";
		      }
		      instructorModel.removeAllElements();
		      for(int i = 0;i<tempIns.length;i++)
		      {
		         instructorModel.addElement(tempIns[i]);
		      }
		      instructorCombo.setModel(instructorModel);
			}
		}

		// Focus listener
		public void focusGained(FocusEvent e)
		{
			if (e.getSource() == startDateDay)
			{
				if (startDateDay.getText().equals("Day"))
				{
					startDateDay.setText("");
				} else
					startDateDay.setText(startDateDay.getText());
			}
			if (e.getSource() == startDateMonth)
			{
				if (startDateMonth.getText().equals("Month"))
				{
					startDateMonth.setText("");
				} else
					startDateMonth.setText(startDateMonth.getText());
			}
			if (e.getSource() == startDateYear)
			{
				if (startDateYear.getText().equals("Year"))
				{
					startDateYear.setText("");
				} else
					startDateYear.setText(startDateYear.getText());
			}
			if (e.getSource() == endDateDay)
			{
				if (endDateDay.getText().equals("Day"))
				{
					endDateDay.setText("");
				} else
					endDateDay.setText(endDateDay.getText());
			}
			if (e.getSource() == endDateMonth)
			{
				if (endDateMonth.getText().equals("Month"))
				{
					endDateMonth.setText("");
				} else
					endDateMonth.setText(endDateMonth.getText());
			}
			if (e.getSource() == endDateYear)
			{
				if (endDateYear.getText().equals("Year"))
				{
					endDateYear.setText("");
				} else
					endDateYear.setText(endDateYear.getText());
			}
			if (e.getSource() == startTimeHour)
			{
				if (startTimeHour.getText().equals("Hour"))
				{
					startTimeHour.setText("");
				} else
					startTimeHour.setText(startTimeHour.getText());
			}
			if (e.getSource() == startTimeMinute)
			{
				if (startTimeMinute.getText().equals("Minute"))
				{
					startTimeMinute.setText("");
				} else
					startTimeMinute.setText(startTimeMinute.getText());
			}
		}

		public void focusLost(FocusEvent e)
		{
			if (e.getSource() == startDateDay)
			{
			   if(!checkIfOnlyInts(startDateDay.getText()))
			   {
			      JOptionPane.showMessageDialog(null, "Please enter a correct number");
			      startDateDay.requestFocus();
			      startDateDay.setText("");
			   }
				if (startDateDay.getText().equals(""))
				{
					startDateDay.setText("Day");
				}
				endDateDay.setText(startDateDay.getText());
			}
			if (e.getSource() == startDateMonth)
			{
			   if(!checkIfOnlyInts(startDateMonth.getText()))
            {
               JOptionPane.showMessageDialog(null, "Please enter a correct number");
               startDateMonth.requestFocus();
               startDateMonth.setText("");
            }
				if (startDateMonth.getText().equals(""))
				{
					startDateMonth.setText("Month");
				}
				endDateMonth.setText(startDateMonth.getText());
			}
			if (e.getSource() == startDateYear)
			{
			   if(!checkIfOnlyInts(startDateYear.getText()))
            {
               JOptionPane.showMessageDialog(null, "Please enter a correct number");
               startDateYear.requestFocus();
               startDateYear.setText("");
            }
				if (startDateYear.getText().equals(""))
				{
					startDateYear.setText("Year");
				}
				endDateYear.setText(startDateYear.getText());
			}
			if (e.getSource() == endDateDay)
			{
			   if(!checkIfOnlyInts(endDateDay.getText()))
            {
               JOptionPane.showMessageDialog(null, "Please enter a correct number");
               endDateDay.requestFocus();
               endDateDay.setText("");
            }
				if (endDateDay.getText().equals(""))
				{
					endDateDay.setText("Day");
				}
			}
			if (e.getSource() == endDateMonth)
			{
			   if(!checkIfOnlyInts(endDateMonth.getText()))
            {
               JOptionPane.showMessageDialog(null, "Please enter a correct number");
               endDateMonth.requestFocus();
               endDateMonth.setText("");
            }
				if (endDateMonth.getText().equals(""))
				{
					endDateMonth.setText("Month");
				}
			}
			if (e.getSource() == endDateYear)
			{
			   if(!checkIfOnlyInts(endDateYear.getText()))
            {
               JOptionPane.showMessageDialog(null, "Please enter a correct number");
               endDateYear.requestFocus();
               endDateYear.setText("");
            }
				if (endDateYear.getText().equals(""))
				{
					endDateYear.setText("Year");
				}
			}
			if (e.getSource() == startTimeHour)
			{
			   if(!checkIfOnlyInts(startTimeHour.getText()))
            {
               JOptionPane.showMessageDialog(null, "Please enter a correct number");
               startTimeHour.requestFocus();
               startTimeHour.setText("");
            }
				if (startTimeHour.getText().equals(""))
				{
					startTimeHour.setText("Hour");
				}
			}
			if (e.getSource() == startTimeMinute)
			{
			   if(!checkIfOnlyInts(startTimeMinute.getText()))
            {
               JOptionPane.showMessageDialog(null, "Please enter a correct number");
               startTimeMinute.requestFocus();
               startTimeMinute.setText("");
            }
				if (startTimeMinute.getText().equals(""))
				{
					startTimeMinute.setText("Minute");
				}
			}
			if (e.getSource() == maxMembersInput)
         {
            if(!checkIfOnlyInts(maxMembersInput.getText()))
            {
               JOptionPane.showMessageDialog(null, "Please enter a correct number");
               maxMembersInput.requestFocus();
               maxMembersInput.setText("");
            }
         }
			if(e.getSource()==typeInput)
			{
			   if(typeInput.getText().length()>16)
			   {
			      JOptionPane.showMessageDialog(null, "Class type can not be longer than 16 characters");
			      typeInput.setText("");
			      typeInput.requestFocus();
			   }
			}
			if(e.getSource()==nameInput)
         {
            if(nameInput.getText().length()>20)
            {
               JOptionPane.showMessageDialog(null, "Class type can not be longer than 20 characters");
               nameInput.requestFocus();
            }
         }
			if(e.getSource()==this)
			{
			   requestFocus();
			}
		}
	}

	public boolean checkIfOnlyInts(String text)
	{
	   for(int i = 0;i<text.length();i++)
	   {
	      if(!(text.charAt(i)=='1' || text.charAt(i)=='2' || text.charAt(i)=='3' || text.charAt(i)=='4' || text.charAt(i)=='5'
	            || text.charAt(i)=='6' || text.charAt(i)=='7' || text.charAt(i)=='8' || text.charAt(i)=='9' || text.charAt(i)=='0'))
	      {
	         return false;
	      }
	   }
	   return true;
	}
	
	public JTextField getEventIDInput()
	{
	   return id;
	}
	
	public void editEventArea(boolean s)
	{
		if (s == true)
		{
			editInfo.setSelected(true);
			nameInput.setEditable(true);
			typeCombo.setEnabled(true);
			addInstructor.setEnabled(true);
			instructorCombo.setEnabled(true);
			maxMembersInput.setEditable(true);
			startDateDay.setEditable(true);
			startDateMonth.setEditable(true);
			startDateYear.setEditable(true);
//			endDateDay.setEditable(true);
//			endDateMonth.setEditable(true);
//			endDateYear.setEditable(true);
			duraCombo.setEnabled(true);
			startTimeHour.setEditable(true);
			startTimeMinute.setEditable(true);
			removeInstructor.setEnabled(true);
		}
		if (s == false)
		{
			editInfo.setSelected(false);
			nameInput.setEditable(false);
			typeCombo.setEnabled(false);
			maxMembersInput.setEditable(false);
			startDateDay.setEditable(false);
			startDateMonth.setEditable(false);
			startDateYear.setEditable(false);
			endDateDay.setEditable(false);
			endDateMonth.setEditable(false);
			endDateYear.setEditable(false);
			duraCombo.setEnabled(false);
			startTimeHour.setEditable(false);
			startTimeMinute.setEditable(false);
		}
	}
	
	public void fillWithEvent(Event event)
	{
	   alreadyEvent = true;
	   editEventArea(false);
	   nameInput.setText(event.getClassName());
	   maxMembersInput.setText(event.getMaxMembers()+"");
	   id.setText(event.getEventID()+"");
	   for(int i = 0;i<tempType.length;i++)
	   {
	     if(tempType[i].equals(event.getClassTypeString()))
	     {
	        typeCombo.setSelectedIndex(i);
	     }
	   }
	   ArrayList<String> tempQualified= new ArrayList<String>();
	   for(int k = 0;k<fileAdapter.getInstructorsList().getInstructorsList().size();k++)
	   {
	      if(fileAdapter.getInstructorsList().getInstructorsList().get(k).getQualifiedClassesList().contains(event.getClassType()))
	      {
	         tempQualified.add(fileAdapter.getInstructorsList().getInstructorsList().get(k).toSmallString());
	      }
	   }
	   
	   tempIns = tempQualified.toArray(new String[0]);
	   
	   instructorModel.removeAllElements();
	   for(int i = 0;i<tempIns.length;i++)
	   {
	      instructorModel.addElement(tempIns[i]);
	   }
	   instructorCombo.setModel(instructorModel);
	   listInstructors.clear();
	   fileAdapter.updateEventsList();
	   for(int i = 0;i<event.getInstructorsList().size();i++)
	   {
	      listInstructors.addElement(event.getInstructorsList().get(i));
	   }
	   startDateDay.setText(event.getStartDate().getDay()+"");
	   startDateMonth.setText(event.getStartDate().getMonth()+"");
	   startDateYear.setText(event.getStartDate().getYear()+"");
	   endDateDay.setText(event.getEndDate().getDay()+"");
	   endDateMonth.setText(event.getEndDate().getMonth()+"");
	   endDateYear.setText(event.getEndDate().getYear()+"");
	   
	   if(event.getEndTime().getHour()-event.getStarTime().getHour()==1)
	   {
	      duraCombo.setSelectedIndex(0);
	   }
	   if(event.getEndTime().getHour()-event.getStarTime().getHour()==2)
      {
         duraCombo.setSelectedIndex(1);
      }
	   if(event.getEndTime().getHour()-event.getStarTime().getHour()==3)
      {
         duraCombo.setSelectedIndex(2);
      }
	   if(event.getEndTime().getHour()-event.getStarTime().getHour()==4)
      {
         duraCombo.setSelectedIndex(3);
      }
	   if(event.getEndTime().getHour()-event.getStarTime().getHour()==5)
      {
         duraCombo.setSelectedIndex(4);
      }
	   startTimeHour.setText(event.getStarTime().getHour()+"");
	   startTimeMinute.setText(event.getStarTime().getMinute()+"");
	   
	   listMembers.clear();
	   fileAdapter.updateEventsList();
	   for(int i = 0;i<event.getMembersList().size();i++)
	   {
	      listMembers.addElement(event.getMembersList().get(i).toSmallString());
	   }
	}

	public void updateClassTypeComboBox()
	{
		comboModel.removeAllElements();
		for(int i = 0;i<fileAdapter.getClassTypesList().getClassTypesArr().length;i++)
		{
		   comboModel.addElement(fileAdapter.getClassTypesList().getClassTypesArr()[i]);
		}
		typeCombo.setModel(comboModel);
	}

	///////////////////////////////////// GUI
	///////////////////////////////////// ///////////////////////////////////////

	public newEventGUI()
	{
		super("Event - ViaFit Fitness Centre");
		
		classTypesList = new ClassTypesList();
		fileAdapter = new FileAdapter();
		myListener = new MyListener();
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
		dateM = new JLabel("M:");
		dateY = new JLabel("Y:");
		dateEndD = new JLabel("D:");
		dateEndM = new JLabel("M:");
		dateEndY = new JLabel("Y:");
		attendingInstructors = new JLabel("Attending instructors:");
		timeHour = new JLabel("H:");
		timeMinute = new JLabel("M:");
		

		listInstructors = new DefaultListModel<Instructor>();
		listMembers = new DefaultListModel<String>();
		attendingInstructorsArea = new JList<Instructor>(listInstructors);
		attendingMembersArea = new JList<String>(listMembers);
		attendingInstructorsAreaScroll = new JScrollPane(attendingInstructorsArea);
		attendingMembersAreaScroll = new JScrollPane(attendingMembersArea);

		nameInput = new JTextField();
		nameInput.addFocusListener(myListener);
		typeInput = new JTextField();
		typeInput.addFocusListener(myListener);
		maxMembersInput = new JTextField();
		maxMembersInput.addFocusListener(myListener);
		startDateDay = new JTextField("Day");
		startDateDay.addFocusListener(myListener);
		startDateMonth = new JTextField("Month");
		startDateMonth.addFocusListener(myListener);
		startDateYear = new JTextField("Year");
		startDateYear.addFocusListener(myListener);
		endDateDay = new JTextField("Day");
		endDateDay.setEnabled(false);  //Made uneditable cause no support for events over 1 day
		endDateDay.addFocusListener(myListener);
		endDateMonth = new JTextField("Month");
		endDateMonth.setEnabled(false); //Made uneditable cause no support for events over 1 day
		endDateMonth.addFocusListener(myListener);
		endDateYear = new JTextField("Year");
		endDateYear.setEnabled(false);  //Made uneditable cause no support for events over 1 day
		endDateYear.addFocusListener(myListener);
		startTimeHour = new JTextField("Hour");
		startTimeHour.addFocusListener(myListener);
		startTimeMinute = new JTextField("Minute");
		startTimeMinute.addFocusListener(myListener);
		id = new JTextField("");
		
		fileAdapter.updateInstructorsList();
		String[] allInstructors = new String[fileAdapter.getInstructorsList().getInstructorsList().size()];
		for(int k = 0;k<fileAdapter.getInstructorsList().getInstructorsList().size();k++)
      {
         allInstructors[k] = fileAdapter.getInstructorsList().getInstructorsList().get(k).toSmallString();
      }
      tempIns = allInstructors;
		instructorCombo = new JComboBox<String>(tempIns);
		instructorCombo.addActionListener(myListener);
		fileAdapter.updateClassTypesList();
		tempType = fileAdapter.getClassTypesList().getClassTypesArr();
		comboModel = new DefaultComboBoxModel<String>(tempType);
		instructorModel = new DefaultComboBoxModel<String>(tempIns);
		typeCombo = new JComboBox<String>();
		typeCombo.setModel(comboModel);
		typeCombo.addActionListener(myListener);
		duraCombo = new JComboBox<String>(tempDura);
		instructorComboBottom = new JComboBox<String>(tempInsBottom);

		newTypeCheck = new JCheckBox();
		newTypeCheck.addActionListener(myListener);
		weeklyCheck = new JCheckBox();
		weeklyCheck.addActionListener(myListener);

		save = new JButton("Save");
		save.addActionListener(myListener);
		close = new JButton("Close");
		close.addActionListener(myListener);
		addInstructor = new JButton("Add instructor");
		addInstructor.addActionListener(myListener);
		removeInstructor = new JButton("Remove instructor");
		removeInstructor.addActionListener(myListener);

		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		aboutMenu = new JMenu("About");

		remove = new JMenuItem("Delete event");
		remove.addActionListener(myListener);
		exit = new JMenuItem("Exit");
		exit.addActionListener(myListener);
		about = new JMenuItem("About");
		about.addActionListener(myListener);
		editInfo = new JCheckBoxMenuItem("Edit event");
		editInfo.addActionListener(myListener);
		logo = new ImageIcon(Main.class.getResource("/imgPackage/logoTransBigger.png"));
		logoLabel = new JLabel();
		deleteClassType = new JMenuItem("Delete current class type");
		deleteClassType.addActionListener(myListener);
		newTypeMenu = new JCheckBoxMenuItem("Make new class type");
		newTypeMenu.addActionListener(myListener);

		// styling textfields and text
		headLine.setFont(new Font(headLine.getFont().getFamily(), Font.BOLD, 30));

		// adding content to menuBar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		fileMenu.add(exit);
		editMenu.add(editInfo);
		editMenu.addSeparator();
		editMenu.add(newTypeMenu);
		editMenu.add(deleteClassType);
		editMenu.addSeparator();
		editMenu.add(remove);
		aboutMenu.add(about);

		// adding content to the topContainer
		logoLabel.setIcon(logo);
		topContainer.setLayout(new GridLayout(1, 2));
		logoLabel.setBorder(new EmptyBorder(20, 20, 0, 0));
		topContainer.setMinimumSize(new Dimension(750, 90));
		topContainer.setMaximumSize(new Dimension(750, 90));
		headLine.setBorder(new EmptyBorder(50, 0, 0, 0));
		topContainer.add(logoLabel);
		topContainer.add(headLine);

		// adding content to inputContainer
		inputContainer.setBorder(new EmptyBorder(30, 0, 0, 0));
		inputContainer.setPreferredSize(new Dimension(750, 200));
		inputContainer.setLayout(new GridLayout(5, 2));
		inputContainer.add(nameContainer);
		inputContainer.add(maxMembersContainer);
		inputContainer.add(typeContainer);
		inputContainer.add(startDateContainer);
		inputContainer.add(newTypeContainer);
		newTypeContainer.setVisible(false);
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

		// adding contents to smaller containers

		typeContainer.add(type);
		type.setPreferredSize(labels);
		typeContainer.add(typeCombo);
		typeInput.setPreferredSize(labels);
		typeInput.setVisible(false);
		typeContainer.add(typeInput);
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
//		durationContainer.add(weeklyContainer);
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

		// adding content to the outputContainer
		outputContainer.setMinimumSize(new Dimension(750, 180));
		outputContainer.setMaximumSize(new Dimension(750, 180));
		outputContainer.setLayout(new GridLayout(1, 2));
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
		removeInstructorPanel.setLayout(new GridLayout(1, 2));
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

		// adding content the the bottomContainer
		bottomContainer.add(confirmContainer);
		confirmContainer.add(save);
		confirmContainer.add(close);

		// adding content to the main frame
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
