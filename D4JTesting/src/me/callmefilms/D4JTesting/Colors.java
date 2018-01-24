package me.callmefilms.D4JTesting;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

import sx.blah.discord.handle.obj.IRole;

public class Colors {
	
	private HashMap<Long, Timer> timers;
	private HashMap<IRole, Color> roles;
	private boolean isStopped;
	
	public Colors() {
		this.timers = new HashMap<Long, Timer>();
		this.roles = new HashMap<IRole, Color>();
		this.isStopped = false;
	}
	
	public HashMap<IRole, Color> getRoles() {
		return this.roles;
	}
	
	public boolean isStopped() {
		return this.isStopped;
	}
	
	public void addRole(IRole role) {
		this.roles.put(role, role.getColor());
		this.timers.put(role.getLongID(), new Timer());
		this.timers.get(role.getLongID()).schedule(new ColorChange(role), 0, 10);
	}
	
	public void removeRole(IRole role) {
		this.timers.get(role.getLongID()).cancel();
		this.timers.get(role.getLongID()).purge();
		role.changeColor(this.roles.get(role));
		this.roles.remove(role);
	}
	
	public void stopTimers() {
		for(int i = 0; i < this.timers.size(); i++) {
			this.timers.get(this.timers.keySet().toArray()[i]).cancel();
			this.timers.get(this.timers.keySet().toArray()[i]).purge();
			this.timers.remove(this.timers.keySet().toArray()[i]);
		}
		for(int i = 0; i < this.roles.size(); i++) {
			IRole targRole = (IRole) this.roles.keySet().toArray()[i];
			targRole.changeColor(this.roles.get(targRole));
		}
		this.isStopped = true;
	}
	
	public void restartTimers() {
		for(int i = 0; i < this.roles.size(); i++) {
			IRole role = (IRole) this.roles.keySet().toArray()[i];
			this.timers.put(role.getLongID(), new Timer());
			this.timers.get(this.timers.keySet().toArray()[i]).schedule(new ColorChange((IRole) this.roles.keySet().toArray()[i]), 0, 250);
		}
		this.isStopped = false;
	}

}
