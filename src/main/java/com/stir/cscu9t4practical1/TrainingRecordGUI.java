// GUI and main program for the Training Record updated by shermina on 12.24
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

	private JTextField name = new JTextField(30);
	private JTextField day = new JTextField(2);
	private JTextField month = new JTextField(2);
	private JTextField year = new JTextField(4);
	private JTextField hours = new JTextField(2);
	private JTextField mins = new JTextField(2);
	private JTextField secs = new JTextField(2);
	private JTextField dist = new JTextField(4);
	private JTextField terrain = new JTextField(2);
	private JTextField tempo = new JTextField(2);
	private JTextField Repetitions = new JTextField(2);
	private JTextField Recovery = new JTextField(2);
	private JTextField where = new JTextField(2);
	private JLabel labn = new JLabel(" Name:");
	private JLabel labd = new JLabel(" Day:");
	private JLabel labm = new JLabel(" Month:");
	private JLabel labt = new JLabel(" Terrain:");
	private JLabel labte = new JLabel(" Tempo:");
	private JLabel labp = new JLabel(" pool:");
	private JLabel labge = new JLabel(" Recovery:");
	private JLabel labnum = new JLabel(" Repetitions:");
	private JLabel laby = new JLabel(" Year:");
	private JLabel labh = new JLabel(" Hours:");
	private JLabel labmm = new JLabel(" Mins:");
	private JLabel labs = new JLabel(" Secs:");
	private JLabel labdist = new JLabel(" Distance (km):");
	private JButton addR = new JButton("Add");
	private JButton findbydate = new JButton("Find all by date");
	private JButton lookUpByDate = new JButton("Look Up");
	private JButton removeRecord = new JButton("Remove Record");

	private TrainingRecord myAthletes = new TrainingRecord();

	private JTextArea outputArea = new JTextArea(5, 50);

	public static void main(String[] args) {
		TrainingRecordGUI applic = new TrainingRecordGUI();
	} // main

	// set up the GUI
	public TrainingRecordGUI() {
		super("Training Record");
		setLayout(new FlowLayout());
		add(labn);
		add(name);
		name.setEditable(true);
		add(labd);
		add(day);
		day.setEditable(true);
		add(labm);
		add(month);
		month.setEditable(true);
		add(laby);
		add(year);
		year.setEditable(true);
		add(labh);
		add(hours);
		hours.setEditable(true);
		add(labmm);
		add(mins);
		mins.setEditable(true);
		add(labs);
		add(secs);
		terrain.setEditable(true);
		add(labt);
		add(terrain);
		tempo.setEditable(true);
		add(labte);
		add(tempo);
		Repetitions.setEditable(true);
		add(labp);
		add(Repetitions);
		Recovery.setEditable(true);
		add(labge);
		add(Recovery);
		where.setEditable(true);
		add(labnum);
		add(where);
		secs.setEditable(true);
		add(labdist);
		add(dist);
		dist.setEditable(true);
		add(addR);
		addR.addActionListener(this);
		add(findbydate);
		findbydate.addActionListener(this);
		add(lookUpByDate);
		lookUpByDate.addActionListener(this);
		add(removeRecord);
		removeRecord.addActionListener(this);
		add(outputArea);
		outputArea.setEditable(false);
		setSize(720, 200);
		setVisible(true);
		blankDisplay();

		// To save typing in new entries while testing, uncomment
		// the following lines (or add your own test cases)

	} // constructor

	// listen for and respond to GUI events
	public void actionPerformed(ActionEvent event) {
		String message = "";
		if (event.getSource() == addR) {
			message = addEntry("generic");
		}
		if (event.getSource() == findbydate) {
			message = lookupall();
		}
		if (event.getSource() == lookUpByDate) {
			message = lookupEntry();
		}
		if (event.getSource() == removeRecord) {
			message = removeRecord();
		}
		outputArea.setText(message);
		blankDisplay();
	} // actionPerformed

	public String addEntry(String what) {
		String message = "Record added\n";
		System.out.println("Adding " + what + " entry to the records");
		String n = name.getText();
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		float km = java.lang.Float.parseFloat(dist.getText());
		int h = Integer.parseInt(hours.getText());
		int mm = Integer.parseInt(mins.getText());
		int s = Integer.parseInt(secs.getText());
		String terrain = name.getText();
		String tempo = name.getText();
		int re = Integer.parseInt(Recovery.getText());
		int rep = Integer.parseInt(Repetitions.getText());
		String where = name.getText();

		Entry e = new Entry(n, d, m, y, h, mm, s, km);
		myAthletes.addEntry(e);
		return message;
	}

	public String lookupEntry() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		String message = myAthletes.lookupEntry(d, m, y);
		return message;
	}

	public String lookupall() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		String message = myAthletes.lookupall(d, m, y);
		return message;
	}

	public String removeRecord() {
		String n = (name.getText());
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		String message = myAthletes.removeRecord(n, d, m, y);
		return message;
	}

	public void blankDisplay() {
		name.setText("");
		day.setText("");
		month.setText("");
		year.setText("");
		hours.setText("");
		mins.setText("");
		secs.setText("");
		terrain.setText("");
		tempo.setText("");
		Recovery.setText("");
		Repetitions.setText("");
		where.setText("");

	}// blankDisplay
		// Fills the input fields on the display for testing purposes only

	public void fillDisplay(Entry ent) {
		name.setText(ent.getName());
		day.setText(String.valueOf(ent.getDay()));
		month.setText(String.valueOf(ent.getMonth()));
		year.setText(String.valueOf(ent.getYear()));
		hours.setText(String.valueOf(ent.getHour()));
		mins.setText(String.valueOf(ent.getMin()));
		secs.setText(String.valueOf(ent.getSec()));
		dist.setText(String.valueOf(ent.getDistance()));
		terrain.setText(ent.getName());
		tempo.setText(ent.getName());
		Recovery.setText(String.valueOf(ent.getDistance()));
		Repetitions.setText(String.valueOf(ent.getDistance()));
		where.setText(ent.getName());

	}

} // TrainingRecordGUI
