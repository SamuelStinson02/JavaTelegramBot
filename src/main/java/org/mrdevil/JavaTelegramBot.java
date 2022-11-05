package org.mrdevil;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class JavaTelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "S02_JavaTelegram_bot";
    }

    @Override
    public String getBotToken() {
        return "5754756703:AAGsuwnQowqZGPmxHm81dE123_6Pb0NNY_A";
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();

            if (message.hasText()){
                String text = message.getText();

                if (text.equals("/start")){
                    System.out.println(message.getFrom().getFirstName() +
                            " ha iniciado el bot.");

                    SendMessage response = new SendMessage();
                    response.setText("Welcome to this test bot");
                    response.setChatId(String.valueOf(message.getChatId()));

                    try {
                        execute(response);
                    }catch (TelegramApiException e){
                        e.printStackTrace();
                    }
                } else if (text.equals("/hilove")){
                    SendMessage response = new SendMessage();
                    response.setText("Hi my lovely love");
                    response.setChatId(String.valueOf(message.getChatId()));

                    try {
                        execute(response);
                    }catch (TelegramApiException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}
