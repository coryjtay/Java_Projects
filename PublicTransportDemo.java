package edu.orangecoastcollege.cs170.ctaylor82.finalexam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PublicTransportDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Scanner cs = new Scanner(System.in);
		ArrayList<PublicTransport> transportList = new ArrayList<>();
		File binaryFile = new File("PublicTransport.dat");
		String provider;
		int passengers, capacity, baseFare, horsepower, firstClassFare;

		System.out.println("~~~~~~~~~~~~ Public Transportation Options ~~~~~~~~~~~~\n");
		if (binaryFile.exists()) {
			try {
				ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(binaryFile));
				transportList = (ArrayList<PublicTransport>) fileReader.readObject();
				fileReader.close();
				for (PublicTransport l : transportList)
					System.out.println(l);

			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("[No data. Please enter public transportation options.]");

		}
		boolean quit = false;
		do {
			Repeat();
			try {
				int option = cs.nextInt();
				switch (option) {
				case 1:
					cs.nextLine();
					System.out.print("What is the provider name for the bus? ");
					provider = cs.nextLine();
					System.out.print("How many passengers are on the bus? ");
					passengers = cs.nextInt();
					System.out.print("What is the total capacity of the bus? ");
					capacity = cs.nextInt();
					System.out.print("Enter the base fare $");
					baseFare = cs.nextInt();
					System.out.print("What is the horsepower of the bus? ");
					horsepower = cs.nextInt();
					System.out.println();
					transportList.add(new Bus(horsepower, provider, passengers, capacity, baseFare));
					for (PublicTransport l : transportList)
						System.out.println(l);
					System.out.println("\nAverage Bus Fare: " + averageBaseFare(transportList));
					System.out.println("Bus with the maximum horsepower: " + findBusWithMaxHorsepower(transportList));
					break;
				case 2:
					cs.nextLine();
					System.out.print("What is the provider name for the train? ");
					provider = cs.nextLine();
					System.out.print("How many passengers are on the train? ");
					passengers = cs.nextInt();
					System.out.print("What is the total capacity of the train? ");
					capacity = cs.nextInt();
					System.out.print("Enter the base fare $");
					baseFare = cs.nextInt();
					System.out.print("Enter the first class fare $");
					firstClassFare = cs.nextInt();
					System.out.println();
					transportList.add(new Train(firstClassFare, provider, passengers, capacity, baseFare));
					for (PublicTransport l : transportList)
						System.out.println(l);
					System.out.println("\nAverage Base Fare: " + averageBaseFare(transportList));
					System.out.println("Bus with the maximum horsepower: " + findBusWithMaxHorsepower(transportList));
					break;
				case 3:
					System.out.println("Travel safely and enjoy your break!");
					quit = true;
					break;
				default:
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Input was invalid, please try again.");
				cs.nextLine();
			} catch (OverCapacityException e) {
				System.out.println(e.getMessage());
			}

		} while (!quit);
		cs.close();

		try {
			ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(binaryFile));
			fileWriter.writeObject(transportList);
			fileWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void Repeat() {
		System.out.println("\n******* Transportation Options Menu *******"
				+ "\nEnter (1) to enter a Bus\nEnter (2) to enter a Train\nEnter (3) to exit");
	}

	public static double averageBaseFare(ArrayList<PublicTransport> transportList) {
		int count = 0, count1 = 0;
		double average = 0;
		for (PublicTransport l : transportList) {
			count += l.getBaseFare();
			count1++;
			average = count / count1;
		}
		return average;
	}

	public static Bus findBusWithMaxHorsepower(ArrayList<PublicTransport> transportList) {
		Bus count = null;
		int max = 0;
		for (PublicTransport l : transportList) {
			if (l instanceof Bus) {
				Bus p = (Bus) l;
				if (p.getHorsepower() > max) {
					count = p;
					max = p.getHorsepower();
				}
			}
		}
		return count;
	}
}
