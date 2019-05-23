package com.aca.chatBot;

import com.aca.chatBot.helper.calculator.Calculator;
import com.aca.chatBot.helper.ticTacToe.Game;
import com.aca.chatBot.ui.UserInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ChatBotMeneger {
    private ChatBot chatBot;
    private UserInterface ui = new UserInterface();
    private String enteredKey;
    private String games[] = {"TicTacToe", "Calculator"};
    private List<String> listOfGames = Arrays.asList(games);



    public void setAnswers() {
        chatBot = new ChatBot();
        chatBot.chat.put("hello", dayTime());
        chatBot.chat.put("hi", dayTime());
        chatBot.chat.put("how are you?", "Fine, and you?");
        chatBot.chat.put("I am well", "What would you like to do?");
        chatBot.chat.put("calculate", "Calculator");
        chatBot.chat.put("play", "TicTacToe");
        chatBot.chat.put("bye", "Have a nice day");
    }

    private void addQuestion(String question, String answer) {
        chatBot.chat.put(question, answer);
        try {
            String filename = "C:\\Users\\Gevorg\\IdeaProjects\\chatBot\\resource\\newKeys.txt";
            FileWriter fw = new FileWriter(filename, true);
            fw.write(question + "-" + answer + "\n");
            fw.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public String getAnswer(String question) {
        enteredKey = question;
        for (String key : chatBot.chat.keySet()) {
            if ((question.toLowerCase()).contains(key)
                    || key.contains(question.toLowerCase())) {
                return chatBot.chat.get(key);
            }
        }

        ui.print("Dear user we don't yet have the instruction you entered, \n" +
                "but we can update our program.Please write some information about new command");
        addQuestion(question, ui.input());
        return null;
    }

    public void execute(String answer) {
        String args[] = {"args"};
        if (listOfGames.contains(answer)) {
            switch (answer) {
                case "Calculator":
                    Calculator.main(args);
                    break;
                case "TicTacToe":
                    Game.main(args);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        if (answer == null)
            ui.print("Accepted new command");
        else
            ui.print(answer);
    }

    public boolean isFinished() {
        return enteredKey.equals("bye") ? true : false;
    }

    String dayTime() {
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String dayTime = "Good ";

        if (hour >= 1 && hour <= 12)
            dayTime += "morning";
        else if (hour > 12 && hour <= 16)
            dayTime += "afternoon ";
        else if (hour > 16 && hour <= 21)
            dayTime += "evening";
        else
            dayTime += "night";

        return dayTime;
    }
}
