package com.display.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class FontsInterface {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Local Fonts UI");
		JTextPane textPane = new JTextPane();
		StyledDocument doc = textPane.getStyledDocument();
		Style style = textPane.addStyle("font-style", null);
		StyleConstants.setFontSize(style, 18);
		
		JScrollPane scrollPane = new JScrollPane(textPane);
		
		frame.setSize(700, 500);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setMaximumSize(new Dimension(1440, 800));
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Font[] fonts = genv.getAllFonts();
		
		for (int i=0; i < fonts.length; i++) {
			try {
				String fontName = fonts[i].getName();
				StyleConstants.setFontFamily(style, fontName);
				doc.insertString(doc.getLength(), "Hello, World " + "(" + fontName + ")" + "\n", style);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		}

		textPane.setEditable(false);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
