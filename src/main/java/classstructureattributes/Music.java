package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song song = new Song();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Favourite music band:");
        song.band = scanner.nextLine();
        System.out.println("Favourite music title:");
        song.title = scanner.nextLine();
        System.out.println("Favourite music length (min)");
        song.length = scanner.nextInt();

        System.out.println(song.band + " - " + song.title + " (" + song.length*60 + " s)");
    }
}
