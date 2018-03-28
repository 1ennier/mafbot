package ru.lennier.mafbot.main;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import ru.lennier.mafbot.config.BotCommand;

public class Bot extends AbilityBot {

    private static final String VERSION = "Mafbot for Telegram v0.1 beta (based on LightStar Mafia IRC Bot v1.00 Final)";

    private static int creatorId;
    private static String botToken;
    private static String botUsername;

    private Bot() {
        super(botToken, botUsername);
    }

    public static void main(String[] args) {
        initByArgs(args);
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            botsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private static void initByArgs(String[] args) {
        if (args == null || args.length != 3) {
            throw new RuntimeException("Incorrect initial arguments. Usage: Bot <creatorId> <botToken> <botUsername>");
        }
        creatorId = Integer.parseInt(args[0]);
        botToken = args[1];
        botUsername = args[2];
    }

    @Override
    public int creatorId() {
        return creatorId;
    }

    public Ability showVersion() {
        return AbilityHelper.getAbilityByCommand(BotCommand.VERSION, ctx -> silent.send(VERSION, ctx.chatId()));
    }

}
