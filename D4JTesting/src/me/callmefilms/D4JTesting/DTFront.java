package me.callmefilms.D4JTesting;

import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.util.DiscordException;

public class DTFront {
	
	public static final IDiscordClient bot = createClient("Mzk3OTgwNjEwOTA1NTA1Nzk1.DS336w.Y6zNHeCHhBx4smgk0bgcOWjhrrI", true);
	public static final Colors colors = new Colors();
	
	public static void main(String[] args) {
		EventDispatcher dis = bot.getDispatcher();
		dis.registerListener(new BotListener());
	}
	
	public static IDiscordClient createClient(String token, boolean login) {
		ClientBuilder clientBuilder = new ClientBuilder();
		clientBuilder.withToken(token);
		try {
			if(login) {
				return clientBuilder.login();
			} else {
				return clientBuilder.build();
			}
		} catch(DiscordException e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	Test
	
}
