package com.bichpormak;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderDemo {

    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);
        final String path = in.nextLine();

        try (FileReader fileReader = new FileReader(path)) {

        } catch (IOException e) {
            System.out.println("Файла такого нет");
        }

    }

}