package com.ecobike;

import com.ecobike.cli.Application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Application app = new Application(new Scanner(System.in), System.out);
        app.run();
    }
}
