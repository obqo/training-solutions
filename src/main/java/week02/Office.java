package week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }

    public void printNames() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    public void printNamesReverse() {
        for (int i = meetingRooms.size()-1; i >= 0; i--) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEventNames() {
        for (int i = 0; i < meetingRooms.size(); i += 2) {
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas() {
        for (MeetingRoom meetingRoom : meetingRooms) {
            System.out.println("A tárgyaló neve: " + meetingRoom.getName() + " hossza: " + meetingRoom.getLength() + " szélessége: " + meetingRoom.getWidth() + " területe: " + meetingRoom.getArea());
        }
    }

    public void printMeetingRoomsWithName(String name) {
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (name.equals(meetingRoom.getName())) {
                System.out.println("A beolvasott tárgyaló adatai: " + " hossza: " + meetingRoom.getLength() + " szélessége: " + meetingRoom.getWidth() + " területe: " + meetingRoom.getArea());
            }
        }
    }

    public void printMeetingRoomsContains(String part) {
        System.out.println("A keresett tárgyalók adatai: ");
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getName().toLowerCase().indexOf(part.toLowerCase()) > -1) {
                System.out.println(" hossza: " + meetingRoom.getLength() + " szélessége: " + meetingRoom.getWidth() + " területe: " + meetingRoom.getArea());
            }
        }
    }

    public void printAreasLargerThan(int area) {
        System.out.println("A keresett tárgyalók adatai: ");
        for (MeetingRoom meetingRoom : meetingRooms) {
            if (meetingRoom.getArea() > area) {
                System.out.println(" hossza: " + meetingRoom.getLength() + " szélessége: " + meetingRoom.getWidth() + " területe: " + meetingRoom.getArea());
            }
        }
    }

}
