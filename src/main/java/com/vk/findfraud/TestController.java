package com.vk.findfraud;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestController extends Frame {

	public Polygon mypolygon = new Polygon();

	public void paint(Graphics g) {
		Graphics2D ga = (Graphics2D) g;
		ga.setPaint(Color.red);
		ga.drawPolygon(mypolygon);
	}

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {

		// System.out.print("Enter a string : ");
		// Scanner scanner = new Scanner(System.in);
		// String inputString = scanner.nextLine();
		//
		// Scanner s = new Scanner(System.in);
		// System.out.print("Enter a character : ");
		// char find = s.next().charAt(0);
		//
		// int count = 0;
		// for (int i = 0; i < inputString.length(); i++) {
		// if (find == inputString.charAt(i)) {
		// count++;
		// }
		// }
		//
		// System.out.print("Character count " + count);

		// String str = "Welcome to Beginnersbook";
		// String reversed = reverseString(str);
		// System.out.println("The reversed string is: " + reversed);
		// pattern();

		// String command = "notepad.exe";
		// Runtime run = Runtime.getRuntime();
		// run.exec(command);
		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// // Create an instance of Robot class
		// Robot robot = new Robot();
		//
		// // Press keys using robot. A gap of
		// // of 500 mili seconds is added after
		// // every key press
		// robot.keyPress(KeyEvent.VK_H);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_E);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_L);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_L);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_O);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_SPACE);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_F);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_R);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_O);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_M);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_SPACE);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_G);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_E);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_E);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_K);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_S);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_F);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_O);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_R);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_G);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_E);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_E);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_K);
		// Thread.sleep(500);
		// robot.keyPress(KeyEvent.VK_S);

		// drawTriangle();
		// drawRectangeles();
		robot();
	}

	public static void drawRectangeles() {

		List<Integer> srcpoints = new ArrayList<Integer>();
		srcpoints.add(25);
		srcpoints.add(50);
		srcpoints.add(50);
		srcpoints.add(50);
		srcpoints.add(50);
		srcpoints.add(100);
		srcpoints.add(25);
		srcpoints.add(100);
		// srcpoints.add(75);
		// srcpoints.add(150);

		TestController frame = new TestController();
		for (int i = 0; i < srcpoints.size(); i++) {
			int x = srcpoints.get(i++);
			int y = srcpoints.get(i);
			frame.mypolygon.addPoint(x, y);
		}

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	public static void drawTriangle() {

		List<Integer> srcpoints = new ArrayList<Integer>();
		srcpoints.add(50);
		srcpoints.add(100);
		srcpoints.add(100);
		srcpoints.add(50);
		srcpoints.add(150);
		srcpoints.add(100);
		srcpoints.add(75);
		srcpoints.add(srcpoints.get(1));
		// srcpoints.add(75);
		// srcpoints.add(150);

		TestController frame = new TestController();
		for (int i = 0; i < srcpoints.size(); i++) {
			int x = srcpoints.get(i++);
			int y = srcpoints.get(i);
			frame.mypolygon.addPoint(x, y);
		}

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	// }

	public char maxCount(String val) {

		// int maxcount = 0;

		int result = 0;

		for (int i = 0; i < val.length(); i++) {

		}

		return val.charAt(result);
	}

	public static void pattern() {

		String value = "54321";

		int pos = value.length() - 1;
		for (int i = 0; i < value.length(); i++) {

			for (int j = 0; j < value.length(); j++) {
				if (pos == j) {
					System.out.print("*");
				} else {
					System.out.print(value.charAt(j));
				}
			}
			pos--;
			System.out.println();
		}

	}

	public static String reverseString(String str) {

		if (str.isEmpty()) {
			return str; // Calling Function Recursively
		}

		return reverseString(str.substring(1)) + str.charAt(0);
	}

	public static void robot() {

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < 12; j++) {

				if (i == 0 && j == 6) {
					System.out.print("*");
				} else if (i == 1 && (j == 5 || j == 7)) {
					System.out.print("*");
				} else if (i == 2 && (j == 4 || j == 8)) {
					System.out.print("*");
				} else if (i == 3 && (j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 12; j++) {

				if (j == 7 || j == 6) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}

			System.out.println();
		}

		for (int i = 0; i < 6; i++) {

			for (int j = 0; j < 12; j++) {

				if (j == 0 || j == 1 || j == 11 || j == 12) {
					System.out.print(" ");
				} else {
					if (i == 0 || i == 5) {
						System.out.print("*");
					} else {
						if (j == 2 || j == 10) {
							System.out.print("*");
						} else {
							System.out.print(" ");
						}
					}
				}
			}
			System.out.println(" ");
		}

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 12; j++) {

				if (j == 4 || j == 8) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}

			System.out.println();
		}

	}
}
