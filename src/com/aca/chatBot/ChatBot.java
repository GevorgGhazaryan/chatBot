package com.aca.chatBot;

import com.aca.chatBot.ui.UserInterface;

import java.util.HashMap;
import java.util.Map;

public class ChatBot {
    public Map<String, String> chat = new HashMap<>();
    private ChatBotMeneger chatBotMeneger;
    private String question;
    private String answer;

    public ChatBot() {
        chatBotMeneger = new ChatBotMeneger();
    }

    public void start() {
        chatBotMeneger.setAnswers();
        UserInterface userInterface = new UserInterface();
        do {
            question = userInterface.input();
            answer = chatBotMeneger.getAnswer(question);
            chatBotMeneger.execute(answer);
        }
        while (!chatBotMeneger.isFinished());
    }
}
