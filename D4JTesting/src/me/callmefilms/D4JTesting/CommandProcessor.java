package me.callmefilms.D4JTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.Permissions;

public class CommandProcessor {
	
	public static void processCommand(IMessage message, String prefix) throws IOException {
		IUser sender = message.getAuthor();
		IChannel channel = message.getChannel();
		IGuild guild = message.getGuild();
		
		String[] command = message.getContent().replaceFirst(prefix, "").split(" ");
		
		switch(command[0].toLowerCase()) {
		case "ping":
			channel.sendMessage("pong!");
			break;
		case "avatar":
			if(command.length == 2) {
				command[1] = command[1].replaceAll("[<>@!]", "");
				for(char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
					if(command[1].toUpperCase().indexOf(alphabet) >= 0) {
						channel.sendMessage(command[1] + " is not a valid user.");
						return;
					}
				}
				IUser user = guild.getUserByID(Long.parseLong(command[1]));
				channel.sendMessage(user.mention() + "'s avatar: " + user.getAvatarURL());
				message.delete();
				return;
			} else {
				channel.sendMessage("Please enter valid arguments. '" + prefix + "avatar <user>'");
			}
			break;
		case "color":
			if(!sender.getPermissionsForGuild(message.getGuild()).contains(Permissions.ADMINISTRATOR)) {
				channel.sendMessage(sender.mention() + ", you lack the correct permissions to do this.");
				return;
			}
			if(command.length < 2) {
				channel.sendMessage("Correct usage: ~color <role>");
				return;
			} else if(command[1].equalsIgnoreCase("stop")) {
				if(DTFront.colors.isStopped()) {
					message.delete();
					channel.sendMessage("The color changes are already disabled.");
				} else {
					DTFront.colors.stopTimers();
					message.delete();
					channel.sendMessage("Stopped all color changes");
					return;
				}
			} else if(command[1].equalsIgnoreCase("restart")) {
				if(DTFront.colors.isStopped()) {
					DTFront.colors.restartTimers();
					message.delete();
					channel.sendMessage("Restarted all color changes");
					return;
				} else {
					message.delete();
					channel.sendMessage("The color changes are still enabled");
				}
			} else {
				command[1] = command[1].replaceAll("[<>@!]", "");
				for(char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
					if(command[1].toUpperCase().indexOf(alphabet) >= 0) {
						channel.sendMessage("Could not find role " + command[1]);
						return;
					}
				}
				Long roleID = Long.parseLong(command[1].substring(1));
				IRole role = guild.getRoleByID(roleID);
				
				if(DTFront.colors.getRoles().containsKey(role)) {
					DTFront.colors.removeRole(role);
					message.delete();
					channel.sendMessage(role.mention() + " is no longer a colorful role.");
				} else {
					Calendar calendar = Calendar.getInstance();
				    calendar.set(
				       Calendar.DAY_OF_WEEK,
				       Calendar.MONDAY
				    );
				    calendar.set(Calendar.HOUR_OF_DAY, 15);
				    calendar.set(Calendar.MINUTE, 40);
				    calendar.set(Calendar.SECOND, 0);
				    calendar.set(Calendar.MILLISECOND, 0);
				    
				    DTFront.colors.addRole(role);
				    
				    message.delete();
				    channel.sendMessage(role.mention() + " is now a colorful role.");
				}
			}
			break;
		case "logusers":
			channel.sendMessage("Logging users");
			File botDir = new File("records");
			if(!botDir.exists()) {
				botDir.mkdirs();
			}
			File users = new File(botDir.getPath() + File.separator + "users.txt");
			if(!users.exists()) {
				try {
					users.createNewFile();
				} catch (IOException e) {
					System.out.println("Error: Could not create file: \"" + botDir.getPath() + File.separator + "users.txt\"");
					e.printStackTrace();
				}
			}
			Scanner scan;
			try {
				scan = new Scanner(users);
			} catch (FileNotFoundException e) {
				System.out.println("Error: Could not create scanner for: \"" + botDir.getPath() + File.separator + "users.txt\"");
				e.printStackTrace();
			}
			try {
				FileWriter writer = new FileWriter("records" + File.separator + "users.txt", true);
				Formatter format = new Formatter(writer);
//				BufferedWriter writer = new BufferedWriter(new FileWriter("records" + File.separator + "users.txt", true));
				List<IUser> userList = guild.getUsers();
				for(int i = 0; i < userList.size(); i++) {
//					channel.sendMessage("Logging user " + userList.get(i).getName());
					format.format("%s", userList.get(i).getName() + "#" + userList.get(i).getDiscriminator() + "\n");
//					writer.append(userList.get(i).getName() + "#" + userList.get(i).getDiscriminator() + "\n");
				}
				format.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error: Could not create a formatter for \"records" + File.separator + "users.txt\"");
				e.printStackTrace();
				return;
			}
		}
	}
	
}