package Bot;

import Users.Subscribes;
import Users.UsersInfo;
import WeatherParsing.WeatherGet;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.util.*;

public class Bot extends TelegramLongPollingBot {

    static Subscribes subscribes = new Subscribes();
    static UsersInfo users = new UsersInfo();

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }

    public void dailyMailing() {
        TimerTask myTimerTask = new TimerTask() {

            @Override
            public void run() {
                Map<Long, Float[]> data = subscribes.getData();
                for (Map.Entry<Long, Float[]> item : data.entrySet()) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.enableMarkdown(true);
                    sendMessage.setChatId(item.getKey());
                    try {
                        sendMessage.setText(WeatherGet.getWeather(item.getValue()[0], item.getValue()[1], 1));
                        execute(sendMessage);
                    } catch (IOException | TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Timer timer = new Timer();
        Calendar tomorrow = new GregorianCalendar();
        Calendar result = new GregorianCalendar(
                tomorrow.get(Calendar.YEAR),
                tomorrow.get(Calendar.MONTH),
                tomorrow.get(Calendar.DATE+1),
                10,
                tomorrow.get(Calendar.MINUTE),
                tomorrow.get(Calendar.SECOND));
        Long delay = result.getTime().getTime() - tomorrow.getTime().getTime();

        timer.schedule(myTimerTask, delay, 1000 * 60 * 60 * 24);

    }

    public void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(text);
        try {
            setButton(sendMessage);
            execute(sendMessage);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message.hasText()) {
            switch (message.getText()) {
                case "/help":
                    sendMsg(message, "/subscribe - подписка на ежедневную рассылку в 10:00 \nПеред /subscibe необходимо запросить погоду по геолокации\n" +
                            "\n/unsubscribe - отписка от ежедневную рассылкы в 10:00" +
                            "\n\nКак получить прогноз погоды?\nПросто отправьте свою геолокацию и получите прогноз на ближайшие два дня");
                    break;
                case "/start":
                    sendMsg(message, "Добро пожаловать!" +
                            "\nЯ могу присылать погоду на ближайшие два дня" +
                            "\n\nОтправь мне свою геолокацию и ты получешь мой прогноз" +
                            "\n\nС помощью команды /help ты можешь узнать о других возможностях");
                    break;
                case "/subscribe":
                    sendMsg(message, "Вы подписались на ежедневную рассылку\n Хорошей вам погоды!");
                    subscribes.addSubscribe(message.getChatId());
                    dailyMailing();
                    break;
                case "/unsubscribe":
                    sendMsg(message, "Вы отписались от ежедневной рассылки\n Хорошей вам погоды!");
                    subscribes.removeSubscribe(message.getChatId());
                    break;
            }
        } else if (message.hasLocation()) {
            Float lon = message.getLocation().getLongitude();
            Float lat = message.getLocation().getLatitude();
            try {
                sendMsg(message, WeatherGet.getWeather(lat, lon, 2));
                users.addUser(message.getChatId(),lat, lon);
            } catch (IOException e) {
                sendMsg(message, "Город не найден");
            }
        }
    }

    public void setButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("/help"));
        keyboardRow1.add(new KeyboardButton("/subscribe"));
        keyboardRowList.add(keyboardRow1);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public String getBotUsername() {

        return "Know the Weather";
    }

    public String getBotToken() {
        return "1396867402:AAFKdN9qV69xEin4vmk1kcsbKTOfqH87qQc";
    }
}