package dev.ev1dent.konversation.events;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class onReadyEvent extends ListenerAdapter {
    @Override
    public void onReady (@NotNull ReadyEvent event){
        super.onReady(event);
        System.out.println("Bot Ready...");
    }
}
