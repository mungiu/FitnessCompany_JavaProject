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
	private DefaultListModel<Member> listMembers;
	private JList<Instructor> attendingInstructorsArea;
	private JList<Member> attendingMembersArea;
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
	private MyListener myListener;

	private FileAdapter fileAdapter;

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
			   ClassType tempType = new ClassType("nothing");
			   if(newTypeCheck.isSelected()==true)
			   {
			      fileAdapter.getAllClassTypeList().add(new ClassType(typeInput.getText()));
			      fileAdapter.saveClassTypesListToBin(fileAdapter.getAllClassTypeList());
			      tempType.setClassName(typeInput.getText());
			   }
			   if(newTypeCheck.isSelected()==false)
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
				MyClock endTime = new MyClock(Integer.parseInt(startTimeHour.getText()) + duration, 0, 0);
				
				Event temp = new Event(tempType, className, maxNumbers, startDate, endDate, startTime, endTime);
				
				if(editInfo.isSelected()==true && !id.getText().equals(""))
				{
				   for(int i = 0;i<fileAdapter.getEventsList().size();i++)
				   {
				      if(id.getText().equals(fileAdapter.getEventsList().get(i).getEventID()+""))
				      {
				         temp = fileAdapter.getEventsList().get(i);
				      }
				   }
				   temp.setClassName(className);
				   temp.setClassType(tempType.toString());
				   temp.setMaxMembers(maxNumbers);
				   temp.setStartTime(startTime);
				   temp.setEndTime(endTime);
				   temp.setStartDate(startDate);
				   temp.setEndDate(endDate);
				   fileAdapter.saveEventsListToBin(fileAdapter.getEventsList());
				   fileAdapter.updateEventsList();
				}
				else if(editInfo.isSelected()==false && id.getText().equals(""))
				{
				   fileAdapter.saveEventToAvailableBinList(temp);
				}    
				dispose();
			}
			if(e.getSource()==addInstructor)
			{
			   ArrayList<Event> tempAllEvents = fileAdapter.getEventsList();
			   for(int i = 0;i<tempAllEvents.size();i++)
			   {
			      if(tempAllEvents.get(i).getClassName().equals(nameInput.getText()) && tempAllEvents.get(i).getClassType().equals(typeCombo.getSelectedItem().toString()))
			      {
			         fileAdapter.getEventsList().get(i).assignInstructorToEvent((Instructor)instructorComboBottom.getSelectedItem());
			      }
			   }
			}
			
			if(e.getSource()==newTypeCheck)
			{
			   if(newTypeCheck.isSelected()==true)
			   {
			      typeCombo.setVisible(false);
			      typeInput.setVisible(true);
			   }
			   if(newTypeCheck.isSelected()==false)
            {
               typeCombo.setVisible(true);
               typeInput.setVisible(false);
            }
			}
			if(e.getSource()==remove)
			{
			  int yesno = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this event?", "Confirm before deleting event", JOptionPane.YES_NO_OPTION);
			   if(yesno==JOptionPane.YES_OPTION)
			      {
			         for(int i = 0;i<fileAdapter.getEventsList().size();i++)
			         {
			               if(id.getText().equals(fileAdapter.getEventsList().get(i).getEventID()+""))
			               {
			               fileAdapter.getEventsList().remove(i);
			               fileAdapter.saveEventsListToBin(fileAdapter.getEventsList());
			               fileAdapter.updateEventsList();
			               dispose();
			               }
			         }
			      }
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
				if (startDateDay.getText().equals(""))
				{
					startDateDay.setText("Day");
				}
			}
			if (e.getSource() == startDateMonth)
			{
				if (startDateMonth.getText().equals(""))
				{
					startDateMonth.setText("Month");
				}
			}
			if (e.getSource() == startDateYear)
			{
				if (startDateYear.getText().equals(""))
				{
					startDateYear.setText("Year");
				}
			}
			if (e.getSource() == endDateDay)
			{
				if (endDateDay.getText().equals(""))
				{
					endDateDay.setText("Day");
				}
			}
			if (e.getSource() == endDateMonth)
			{
				if (endDateMonth.getText().equals(""))
				{
					endDateMonth.setText("Month");
				}
			}
			if (e.getSource() == endDateYear)
			{
				if (endDateYear.getText().equals(""))
				{
					endDateYear.setText("Year");
				}
			}
			if (e.getSource() == startTimeHour)
			{
				if (startTimeHour.getText().equals(""))
				{
					startTimeHour.setText("Hour");
				}
			}
			if (e.getSource() == startTimeMinute)
			{
				if (startTimeMinute.getText().equals(""))
				{
					startTimeMinute.setText("Minute");
				}
			}
		}
	}

	
	
	
	
	
	
	
	
	
	public void editEventArea(boolean s)
	{
		if (s == true)
		{
			editInfo.setSelected(true);
			nameInput.setEditable(true);
			typeCombo.setEnabled(true);
			newTypeCheck.setEnabled(true);
			addInstructor.setEnabled(true);
			instructorCombo.setEnabled(true);
			maxMembersInput.setEditable(true);
			startDateDay.setEditable(true);
			startDateMonth.setEditable(true);
			startDateYear.setEditable(true);
			endDateDay.setEditable(true);
			endDateMonth.setEditable(true);
			endDateYear.setEditable(true);
			duraCombo.setEnabled(true);
			weeklyCheck.setEnabled(true);
			startTimeHour.setEditable(true);
			startTimeMinute.setEditable(true);
			removeInstructor.setEnabled(true);
		}
		if (s == false)
		{
			editInfo.setSelected(false);
			nameInput.setEditable(false);
			typeCombo.setEnabled(false);
			newTypeCheck.setEnabled(false);
			maxMembersInput.setEditable(false);
			startDateDay.setEditable(false);
			startDateMonth.setEditable(false);
			startDateYear.setEditable(false);
			endDateDay.setEditable(false);
			endDateMonth.setEditable(false);
			endDateYear.setEditable(false);
			duraCombo.setEnabled(false);
			weeklyCheck.setEnabled(false);
			startTimeHour.setEditable(false);
			startTimeMinute.setEditable(false);
		}
	}
	
	public void fillWithEvent(Event event)
	{
	   editEventArea(false);
	   nameInput.setText(event.getClassName());
	   maxMembersInput.setText(event.getMaxMembers()+"");
	   id.setText(event.getEventID()+"");
	   for(int i = 0;i<tempType.length;i++)
	   {
	     if(tempType[i].equals(event.getClassType()))
	     {
	        typeCombo.setSelectedIndex(i);
	     }
	   }
	   String[] allInstructors = new String[fileAdapter.getInstructorsList().size()];
	   for(int k = 0;k<fileAdapter.getInstructorsList().size();k++)
	   {
	      allInstructors[0] = fileAdapter.getInstructorsList().get(k).toString();
	   }
	   tempIns = allInstructors;
	   
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
	      listMembers.addElement(event.getMembersList().get(i));
	   }
	}

	public boolean isAnyInfoChanged()
	{
		// adapter file needed to check whether something is changed from adapter file
		// to current fields
		return true; // delete this
	}

	///////////////////////////////////// GUI
	///////////////////////////////////// ///////////////////////////////////////

	public newEventGUI()
	{
		super("Event - ViaFit Fitness Centre");

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
		listMembers = new DefaultListModel<Member>();
		attendingInstructorsArea = new JList<Instructor>(listInstructors);
		attendingMembersArea = new JList<Member>(listMembers);
		attendingInstructorsAreaScroll = new JScrollPane(attendingInstructorsArea);
		attendingMembersAreaScroll = new JScrollPane(attendingMembersArea);

		nameInput = new JTextField();
		typeInput = new JTextField();
		maxMembersInput = new JTextField();
		startDateDay = new JTextField("Day");
		startDateDay.addFocusListener(myListener);
		startDateMonth = new JTextField("Month");
		startDateMonth.addFocusListener(myListener);
		startDateYear = new JTextField("Year");
		startDateYear.addFocusListener(myListener);
		endDateDay = new JTextField("Day");
		endDateDay.addFocusListener(myListener);
		endDateMonth = new JTextField("Month");
		endDateMonth.addFocusListener(myListener);
		endDateYear = new JTextField("Year");
		endDateYear.addFocusListener(myListener);
		startTimeHour = new JTextField("Hour");
		startTimeHour.addFocusListener(myListener);
		startTimeMinute = new JTextField("Minute");
		startTimeMinute.addFocusListener(myListener);
		id = new JTextField();

		instructorCombo = new JComboBox<String>(tempIns);
		tempType = fileAdapter.getAllClassTypes();
		typeCombo = new JComboBox<String>(tempType);
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
		logo = new ImageIcon("img/logoTransBigger.png");
		logoLabel = new JLabel();

		// styling textfields and text
		headLine.setFont(new Font(headLine.getFont().getFamily(), Font.BOLD, 30));
		Color col1 = new Color(1, 1, 255);

		// adding content to menuBar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);
		fileMenu.add(exit);
		editMenu.add(editInfo);
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
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
