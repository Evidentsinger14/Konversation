package dev.ev1dent.konversation;

import dev.ev1dent.konversation.events.onReadyEvent;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Main {
    public static void main(String[] args) {
        final Dotenv config;
        config = Dotenv.configure().load();

        final String BOT_TOKEN = config.get("BOT_TOKEN");
        JDABuilder jdaBuilder = JDABuilder.createDefault(BOT_TOKEN);

        JDA jda = jdaBuilder
                // Start Intents
                .enableIntents(
                        GatewayIntent.DIRECT_MESSAGE_REACTIONS,
                        GatewayIntent.DIRECT_MESSAGE_TYPING,
                        GatewayIntent.DIRECT_MESSAGES,
                        GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                        GatewayIntent.GUILD_INVITES,
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_MESSAGE_REACTIONS,
                        GatewayIntent.GUILD_MESSAGE_TYPING,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_PRESENCES,
                        GatewayIntent.GUILD_VOICE_STATES,
                        GatewayIntent.GUILD_WEBHOOKS,
                        GatewayIntent.MESSAGE_CONTENT
                )
                // Start add event listeners
                .addEventListeners(
                        new onReadyEvent()
                )
                // Build code into a bot.
                .build();

        // Create your slash commands to be used.
        jda.updateCommands().queue();
        jda.upsertCommand("panel", "this is a slash command").setGuildOnly(true).queue();
        jda.upsertCommand("ping", "this is a slash command").setGuildOnly(true).queue();
    }
}