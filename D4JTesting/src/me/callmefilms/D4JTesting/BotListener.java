package me.callmefilms.D4JTesting;

import java.io.IOException;

import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.impl.events.guild.role.RoleUpdateEvent;
import sx.blah.discord.handle.obj.IRole;

public class BotListener {
	
	@EventSubscriber
	public void onMessageEvent(MessageReceivedEvent event) {
		if(event.getMessage().getContent().toLowerCase().startsWith("~")) {
			try {
				CommandProcessor.processCommand(event.getMessage(), "~");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
	
//	@EventSubscriber
//	public void onGuildEvent(RoleUpdateEvent event) {
//		IRole changed = event.getRole();
//		IRole oldRole = event.getOldRole();
//		IRole newRole = event.getNewRole();
//		event.getGuild().getChannels().get(0).sendMessage("Test 1");
//	}
	
}
