package com.alarm;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime alarmTime = null;
		String filePath = "Meeting Place.wav";

		while(alarmTime == null){

			try{
				System.out.print("Enter an alarm time (HH:MM:ss): ");
				String inputTime = scanner.nextLine();

				alarmTime = LocalTime.parse(inputTime, formatter);
				System.out.println("Alarm set for "+ alarmTime);


			}catch (DateTimeParseException e){
				System.out.println("Invalid format. Please use HH:MM:ss");
			}


		}

		AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
		Thread alarmThread = new Thread(alarmClock);
		alarmThread.start();



	}

}
