package MainPackage;

import java.awt.Color;
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

public class newInstructorGUI extends JFrame
{

	private JPanel main;
	private JPanel input;
	private JPanel line1Left;
	private JPanel line1Right;
	private JPanel line2Left;
	private JPanel line7;
	private JPanel line3Left;
	private JPanel line3Right;
	private JPanel line4;
	private JPanel line5;
	private JPanel line6;
	private JPanel topContainer;
	private JPanel inputContainer;
	private JPanel line8;
	private JPanel nameContainer;
	private JPanel instructorContainer;
	private JPanel qualifiedAlign;
	private JPanel allclasstypesAlign;
	private JPanel taughtAreaPanel;
	private JPanel contain;
	private JPanel taughtPanel;
	private JPanel confirmContainer;

	private JLabel name;
	private JLabel instructor;
	private JLabel qualifiedfor;
	private JLabel classtypes;
	private JLabel taughtEvents;

	private JButton add;
	private JButton remove;
	private JButton save;
	private JButton close;

	private JTextField nameInput;
	private JTextField instructorInput;

	private JList<ClassType> qualifiedArea;
	private JList<ClassType> classtypesArea;
	private JList<Event> taughteventsArea;
	private DefaultListModel<ClassType> listQualifiedModel;
	private DefaultListModel<ClassType> listClassTypesModel;
	private DefaultListModel<Event> listTaughtEvents;

	private JScrollPane qualifiedScroll;
	private JScrollPane classtypesScroll;
	private JScrollPane taughtEventsScroll;

	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu aboutMenu;
	private JMenuItem exit;
	private JMenuItem removeIns;
	private JMenuItem about;
	private JCheckBoxMenuItem editInstructor;

	private ImageIcon logo;
	private JLabel logoLabel;
	private JLabel headLine;
	private MyListener myListener;

	private FileAdapter fileAdapter;

	private boolean alreadyInstructor;

	/**
	 * Inner buttonListener
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
			if (e.getSource() == editInstructor)
			{
				if (editInstructor.getState() == true)
				{
					editInstructorArea(true);
				}
				if (editInstructor.getState() == false)
				{
					editInstructorArea(false);
				}
			}
			if (e.getSource() == removeIns)
			{
				int yesno = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this instructor?",
						"Confirm before deleting instructor", JOptionPane.YES_NO_OPTION);
				if (yesno == JOptionPane.YES_OPTION)
				{
					Instructor temp = null;
					fileAdapter.updateInstructorsList();
					for (int i = 0; i < fileAdapter.getInstructorsList().getInstructorsList().size(); i++)
					{
						if (fileAdapter.getInstructorsList().getInstructorsList().get(i).getInstructorID() == Integer
								.parseInt(instructorInput.getText()))
						{
							temp = fileAdapter.getInstructorsList().getInstructorsList().get(i);
							fileAdapter.getInstructorsList().getInstructorsList().remove(i);
							fileAdapter.saveInstructorsListToBin(fileAdapter.getInstructorsList().getInstructorsList());
							fileAdapter.updateInstructorsList();
							for (int k = 0; k < fileAdapter.getEventsList().getEventsList().size(); k++)
							{
								if (fileAdapter.getEventsList().getEventsList().get(k).getInstructorsList()
										.contains(temp))
								{
									fileAdapter.getEventsList().getEventsList().get(k).getInstructorsList()
											.remove(temp);
									fileAdapter.saveEventsListToBin(fileAdapter.getEventsList().getEventsList());
									fileAdapter.updateEventsList();
								}
							}
						}
					}
					dispose();
				}
			}
			if (e.getSource() == save)
			{
				Instructor temp = null;
				fileAdapter.updateInstructorsList();
				if (alreadyInstructor == true)
				{
					for (int i = 0; i < fileAdapter.getInstructorsList().getInstructorsList().size(); i++)
					{
						if (fileAdapter.getInstructorsList().getInstructorsList().get(i).getInstructorID() == Integer
								.parseInt(instructorInput.getText()))
						{
							temp = fileAdapter.getInstructorsList().getInstructorsList().get(i);
						}
					}
					temp.setName(nameInput.getText());
					ArrayList<ClassType> tempList = new ArrayList<ClassType>();
					for (int i = 0; i < qualifiedArea.getModel().getSize(); i++)
					{
						tempList.add(qualifiedArea.getModel().getElementAt(i));
					}
					temp.setQualifiedList(tempList);
					fileAdapter.saveInstructorsListToBin(fileAdapter.getInstructorsList().getInstructorsList());
					fileAdapter.updateInstructorsList();
				} else
				{
					String name = nameInput.getText();
					int id = Integer.parseInt(instructorInput.getText() + "");
					ArrayList<ClassType> tempList = new ArrayList<ClassType>();
					for (int i = 0; i < qualifiedArea.getModel().getSize(); i++)
					{
						tempList.add(qualifiedArea.getModel().getElementAt(i));
					}
					temp = new Instructor(name, id, tempList);
					fileAdapter.saveInstructorToAvailableBinList(temp);
					fileAdapter.updateInstructorsList();
				}
				dispose();
			}
			if (e.getSource() == add)
			{
				if (alreadyInstructor == true)
				{
					if (!listQualifiedModel.contains(classtypesArea.getSelectedValue()))
					{
						listQualifiedModel.addElement(classtypesArea.getSelectedValue());
					}
				} else
				{
					JOptionPane.showMessageDialog(null,
							"Please save the instructor before adding and removing classes");
				}
			}
			if (e.getSource() == remove)
			{
				if (alreadyInstructor == true)
				{
					listQualifiedModel.removeElement(qualifiedArea.getSelectedValue());
				} else
				{
					JOptionPane.showMessageDialog(null,
							"Please save the instructor before adding and removing classes");
				}
			}
		}

		public void focusGained(FocusEvent e)
		{

		}

		public void focusLost(FocusEvent e)
		{
			if (nameInput.getText().length() > 25)
			{
				JOptionPane.showMessageDialog(null, "Class type can not be longer than 25 characters");
				nameInput.requestFocus();
			}
		}

	}

	/**
	 * Changing the Instructor JFrame to editable or uneditable
	 * 
	 * @author sst
	 * @param boolean
	 *            s
	 * @version 1.0
	 */
	public void editInstructorArea(boolean s)
	{
		if (s == true)
		{
			editInstructor.setSelected(true);
			nameInput.setEditable(true);
			remove.setEnabled(true);
			add.setEnabled(true);
		}
		if (s == false)
		{
			editInstructor.setSelected(false);
			nameInput.setEditable(false);
		}
	}

	public void fillWithInstructor(Instructor instructor)
	{
		fileAdapter.updateClassTypesList();
		fileAdapter.updateEventsList();
		fileAdapter.updateInstructorsList();
		alreadyInstructor = true;
		editInstructorArea(false);
		nameInput.setText(instructor.getName());
		instructorInput.setText(instructor.getInstructorID() + "");

		for (int i = 0; i < fileAdapter.getEventsList().getEventsList().size(); i++)
		{
			if (fileAdapter.getEventsList().getEventsList().get(i).getInstructorsList().contains(instructor))
			{
				listTaughtEvents.addElement(fileAdapter.getEventsList().getEventsList().get(i));
			}
		}
		for (int i = 0; i < fileAdapter.getInstructorsList().getInstructorsList().size(); i++)
		{
			if (fileAdapter.getInstructorsList().getInstructorsList().get(i).equals(instructor))
			{
				for (int k = 0; k < fileAdapter.getInstructorsList().getInstructorsList().get(i)
						.getQualifiedClassesList().size(); k++)
				{
					listQualifiedModel.addElement(fileAdapter.getInstructorsList().getInstructorsList().get(i)
							.getQualifiedClassesList().get(k));
				}
			}
		}
	}

	public JTextField getInstructorIDInput()
	{
		return instructorInput;
	}

	///////////////////////////////////// GUI
	///////////////////////////////////// ///////////////////////////////////////

	public newInstructorGUI()
	{

		super("Instructor - ViaFit Fitness centre");

		fileAdapter = new FileAdapter();
		myListener = new MyListener();
		main = new JPanel();
		line1Left = new JPanel();
		line1Right = new JPanel();
		line2Left = new JPanel();
		line7 = new JPanel();
		line3Left = new JPanel();
		line3Right = new JPanel();
		line4 = new JPanel();
		line5 = new JPanel();
		line6 = new JPanel();
		input = new JPanel();
		topContainer = new JPanel();
		inputContainer = new JPanel();
		line8 = new JPanel();
		nameContainer = new JPanel();
		instructorContainer = new JPanel();
		qualifiedAlign = new JPanel();
		allclasstypesAlign = new JPanel();
		taughtPanel = new JPanel();
		taughtAreaPanel = new JPanel();
		contain = new JPanel();
		confirmContainer = new JPanel();

		name = new JLabel("Name:");
		instructor = new JLabel("Instructor ID:");
		qualifiedfor = new JLabel("Qualified for:");
		classtypes = new JLabel("All class types:");
		taughtEvents = new JLabel("Taught events:");

		add = new JButton("Add to qualified");
		add.addActionListener(myListener);
		remove = new JButton("Remove from qualified");
		remove.addActionListener(myListener);
		save = new JButton("Save");
		save.addActionListener(myListener);
		close = new JButton("Close");
		close.addActionListener(myListener);

		nameInput = new JTextField();
		nameInput.addFocusListener(myListener);
		instructorInput = new JTextField();
		instructorInput.setEnabled(false);

		listClassTypesModel = new DefaultListModel<ClassType>();
		fileAdapter.updateClassTypesList();
		if (fileAdapter.getClassTypesList().getClassTypesList() != null)
		{
			for (int i = 0; i < fileAdapter.getClassTypesList().getClassTypesList().size(); i++)
			{
				listClassTypesModel.addElement(fileAdapter.getClassTypesList().getClassTypesList().get(i));
			}
		}

		listQualifiedModel = new DefaultListModel<ClassType>();
		qualifiedArea = new JList<ClassType>(listQualifiedModel);
		classtypesArea = new JList<ClassType>(listClassTypesModel);
		listTaughtEvents = new DefaultListModel<Event>();
		taughteventsArea = new JList<Event>(listTaughtEvents);

		qualifiedScroll = new JScrollPane(qualifiedArea);
		classtypesScroll = new JScrollPane(classtypesArea);
		taughtEventsScroll = new JScrollPane(taughteventsArea);

		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		aboutMenu = new JMenu("About");
		exit = new JMenuItem("Exit");
		exit.addActionListener(myListener);
		removeIns = new JMenuItem("Delete instructor");
		removeIns.addActionListener(myListener);
		about = new JMenuItem("About");
		about.addActionListener(myListener);
		editInstructor = new JCheckBoxMenuItem("Edit instructor");
		editInstructor.addActionListener(myListener);

		logo = new ImageIcon(Main.class.getResource("/imgPackage/logoTransBigger.png"));
		logoLabel = new JLabel();
		headLine = new JLabel("Instructor information");

		// styling text and fields
		headLine.setFont(new Font(headLine.getFont().getFamily(), Font.BOLD, 30));

		// adding content to the inputContainer frame
		inputContainer.setLayout(new GridLayout(1, 2));
		inputContainer.setBorder(new EmptyBorder(30, 0, 0, 0));
		inputContainer.setMinimumSize(new Dimension(750, 70));
		inputContainer.setMaximumSize(new Dimension(750, 70));
		nameContainer.add(name);
		nameContainer.add(nameInput);
		nameContainer.setMinimumSize(new Dimension(300, 50));
		nameContainer.setMaximumSize(new Dimension(300, 50));
		line1Left.setLayout(new BoxLayout(line1Left, BoxLayout.Y_AXIS));
		line1Left.add(nameContainer);
		qualifiedAlign.add(qualifiedfor);
		inputContainer.add(line1Left);

		instructorContainer.add(instructor);
		instructorContainer.add(instructorInput);
		instructorContainer.setMinimumSize(new Dimension(300, 50));
		instructorContainer.setMaximumSize(new Dimension(300, 50));
		line1Right.setLayout(new BoxLayout(line1Right, BoxLayout.Y_AXIS));
		line1Right.add(instructorContainer);
		allclasstypesAlign.add(classtypes);
		inputContainer.add(line1Right);

		line5.setLayout(new GridLayout(1, 2));
		qualifiedScroll.setPreferredSize(new Dimension(300, 100));
		qualifiedScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		qualifiedArea.setVisibleRowCount(-1);
		line3Left.add(qualifiedScroll);
		line6.setLayout(new BoxLayout(line6, BoxLayout.Y_AXIS));
		qualifiedAlign.setMinimumSize(new Dimension(300, 30));
		qualifiedAlign.setMaximumSize(new Dimension(300, 30));
		line6.add(qualifiedAlign);
		line6.add(line3Left);
		line8.add(remove);
		line6.add(line8);
		line5.add(line6);

		classtypesScroll.setPreferredSize(new Dimension(300, 100));
		classtypesScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		classtypesArea.setVisibleRowCount(-1);
		line3Right.add(classtypesScroll);
		line7.setLayout(new BoxLayout(line7, BoxLayout.Y_AXIS));
		allclasstypesAlign.setMinimumSize(new Dimension(300, 30));
		allclasstypesAlign.setMaximumSize(new Dimension(300, 30));
		line7.add(allclasstypesAlign);
		line7.add(line3Right);
		line4.add(add);
		line7.add(line4);
		line5.setMinimumSize(new Dimension(750, 200));
		line5.setMaximumSize(new Dimension(750, 200));
		line5.add(line7);

		Dimension labels = new Dimension(80, 25);
		name.setPreferredSize(labels);
		instructor.setPreferredSize(labels);

		Dimension fields = new Dimension(190, 25);
		nameInput.setPreferredSize(fields);
		instructorInput.setPreferredSize(fields);

		// adding the taughtEvents
		contain.setLayout(new BoxLayout(contain, BoxLayout.Y_AXIS));
		taughtPanel.add(taughtEvents);
		taughtPanel.setMinimumSize(new Dimension(600, 30));
		taughtPanel.setMaximumSize(new Dimension(600, 30));
		contain.add(taughtPanel);
		contain.add(taughtAreaPanel);
		taughtAreaPanel.add(taughtEventsScroll);
		taughtEventsScroll.setPreferredSize(new Dimension(600, 120));
		taughtEventsScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		taughteventsArea.setVisibleRowCount(-1);

		// adding content to the topContainer
		logoLabel.setIcon(logo);
		topContainer.setLayout(new GridLayout(1, 2));
		logoLabel.setBorder(new EmptyBorder(20, 20, 0, 0));
		topContainer.setMinimumSize(new Dimension(750, 90));
		topContainer.setMaximumSize(new Dimension(750, 90));
		headLine.setBorder(new EmptyBorder(50, 0, 0, 0));
		topContainer.add(logoLabel);
		topContainer.add(headLine);

		// adding buttons to confirmContainer
		confirmContainer.add(save);
		confirmContainer.add(close);

		// adding content to the main frame
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(topContainer);
		main.add(inputContainer);
		main.add(line5);
		main.add(contain);
		main.add(confirmContainer);

		// adding content to the menuBar
		fileMenu.add(exit);
		editMenu.add(editInstructor);
		editMenu.add(removeIns);
		aboutMenu.add(about);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(aboutMenu);

		setJMenuBar(menuBar);
		add(main);
		setSize(800, 600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
