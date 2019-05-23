package com.aca.chatBot.ui;

import java.util.Scanner;

public class UserInterface {
    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void print(Object object) {
        System.out.println(object);
    }

}
