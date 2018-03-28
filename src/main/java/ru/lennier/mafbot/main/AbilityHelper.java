package ru.lennier.mafbot.main;

import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.objects.MessageContext;
import ru.lennier.mafbot.config.BotCommand;

import java.util.function.Consumer;

public class AbilityHelper {

    public static Ability getAbilityByCommand(BotCommand command, Consumer<MessageContext> consumer) {
        return Ability.builder()
                .name(command.getName())
                .info(command.getDescription())
                .locality(command.getLocality())
                .privacy(command.getPrivacy())
                .action(consumer)
                .build();
    }

}
