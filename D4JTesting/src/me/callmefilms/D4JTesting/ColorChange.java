package me.callmefilms.D4JTesting;

import java.awt.Color;
import java.security.Permissions;
import java.util.Random;
import java.util.TimerTask;

import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;

public class ColorChange extends TimerTask {
	
	private IRole role;
	
	public ColorChange(IRole role) {
		this.role = role;
	}
	
	public void run() {
		IRole r = this.role;
		int red = r.getColor().getRed();
		int green = r.getColor().getGreen();
		int blue = r.getColor().getBlue();
		switch(red) {
		case 255:
			switch(green) {
			case 0:
				System.out.println(r.getColor().getRed() + " " + r.getColor().getGreen() + " " + r.getColor().getBlue());
				r.changeColor(new Color(255, 15, 2));
				System.out.println("Test");
				System.out.println(r.getColor().getRed() + " " + r.getColor().getGreen() + " " + r.getColor().getBlue());
				break;
			case 15:
//				r.changeColor(new Color(255, 30, 3));
				r.changeColor(new Color(254, 76, 9));
				break;
			case 30:
				r.changeColor(new Color(254, 46, 5));
				break;
			case 239:
				r.changeColor(new Color(255, 247, 2));
				break;
			case 247:
//				r.changeColor(new Color(255, 255, 0));
				r.changeColor(new Color(221, 255, 6));
				break;
			case 255:
				r.changeColor(new Color(238, 255, 3));
				break;
			}
			break;
		case 254:
			switch(green) {
			case 46:
				r.changeColor(new Color(254, 61, 7));
				break;
			case 61:
				r.changeColor(new Color(254, 76, 9));
				break;
			case 76:
//				r.changeColor(new Color(254, 91, 10));
				r.changeColor(new Color(254, 121, 14));
				break;
			case 91:
				r.changeColor(new Color(254, 106, 12));
				break;
			case 106:
				r.changeColor(new Color(254, 121, 14));
				break;
			case 121:
//				r.changeColor(new Color(253, 137, 16));
				r.changeColor(new Color(253, 167, 19));
				break;
			case 191:
//				r.changeColor(new Color(254, 199, 12));
				r.changeColor(new Color(254, 223, 7));
				break;
			case 199:
				r.changeColor(new Color(254, 207, 10));
				break;
			case 207:
				r.changeColor(new Color(254, 215, 9));
				break;
			case 215:
				r.changeColor(new Color(254, 223, 7));
				break;
			case 223:
//				r.changeColor(new Color(254, 231, 5));
				r.changeColor(new Color(255, 247, 2));
				break;
			case 231:
				r.changeColor(new Color(255, 239, 3));
				break;
			}
			break;
		case 253:
			switch(green) {
			case 137:
				r.changeColor(new Color(253, 152, 17));
			case 152:
				r.changeColor(new Color(253, 167, 19));
				break;
			case 167:
//				r.changeColor(new Color(253, 175, 17));
				r.changeColor(new Color(254, 191, 14));
				break;
			case 175:
				r.changeColor(new Color(253, 183, 16));
				break;
			case 183:
				r.changeColor(new Color(254, 191, 14));
				break;
			}
			break;
		case 209:
			r.changeColor(new Color(213, 25, 209));
			break;
		case 213:
			r.changeColor(new Color(218, 23, 185));
			break;
		case 218:
			r.changeColor(new Color(223, 20, 162));
			break;
		case 223:
			r.changeColor(new Color(227, 17, 139));
			break;
		case 227:
			r.changeColor(new Color(232, 14, 116));
			break;
		case 232:
			r.changeColor(new Color(236, 11, 93));
			break;
		case 236:
			r.changeColor(new Color(241, 8, 70));
			break;
		case 241:
			r.changeColor(new Color(246, 6, 46));
			break;
		case 246:
			r.changeColor(new Color(250, 3, 23));
			break;
		case 250:
			r.changeColor(new Color(255, 0, 0));
			break;
		case 244:
			r.changeColor(new Color(247, 17, 139));
			break;
		case 247:
			r.changeColor(new Color(255, 0, 0));
			break;
		default:
			switch(green) {
			case 255:
				switch(red) {
				case 238:
					r.changeColor(new Color(221, 255, 6));
					break;
				case 221:
//					r.changeColor(new Color(205, 255, 8));
					r.changeColor(new Color(171, 255, 14));
					break;
				case 205:
					r.changeColor(new Color(188, 255, 11));
					break;
				case 188:
					r.changeColor(new Color(171, 255, 14));
					break;
				case 171:
//					r.changeColor(new Color(154, 255, 17));
					r.changeColor(new Color(104, 255, 25));
					break;
				case 154:
					r.changeColor(new Color(137, 255, 20));
					break;
				case 137:
					r.changeColor(new Color(120, 255, 23));
					break;
				case 120:
					r.changeColor(new Color(104, 255, 25));
					break;
				case 104:
//					r.changeColor(new Color(87, 255, 28));
					r.changeColor(new Color(49, 252, 153));
					break;
				case 87:
					r.changeColor(new Color(70, 255, 31));
				case 70:
					r.changeColor(new Color(66, 254, 51));
					break;
				}
				break;
			case 254:
				switch(red) {
				case 66:
					r.changeColor(new Color(63, 254, 72));
					break;
				case 63:
					r.changeColor(new Color(59, 253, 92));
					break;
				}
				break;
			case 253:
				switch(red) {
				case 59:
					r.changeColor(new Color(56, 253, 112));
					break;
				case 56:
					r.changeColor(new Color(52, 252, 133));
					break;
				}
				break;
			case 252:
				switch(red) {
				case 52:
					r.changeColor(new Color(49, 252, 153));
					break;
				case 49:
//					r.changeColor(new Color(45, 251, 174));
					r.changeColor(new Color(38, 250, 214));
					break;
				}
				break;
			case 251:
				switch(red) {
				case 45:
					r.changeColor(new Color(42, 251, 174));
					break;
				case 42:
					r.changeColor(new Color(38, 250, 214));
					break;
				}
				break;
			case 250:
				switch(red) {
				case 38:
//					r.changeColor(new Color(35, 250, 235));
					r.changeColor(new Color(31, 249, 255));
					break;
				case 35:
					r.changeColor(new Color(31, 249, 255));
					break;
				}
				break;
			default:
				switch(blue) {
				case 255:
					switch(green) {
					case 249:
//						r.changeColor(new Color(31, 227, 255));
						r.changeColor(new Color(31, 205, 255));
						break;
					case 227:
						r.changeColor(new Color(31, 216, 255));
						break;
					case 216:
						r.changeColor(new Color(31, 205, 255));
						break;
					case 205:
//						r.changeColor(new Color(31, 194, 255));
						r.changeColor(new Color(31, 173, 255));
						break;
					case 194:
						r.changeColor(new Color(31, 184, 255));
						break;
					case 184:
						r.changeColor(new Color(31, 173, 255));
						break;
					case 173:
//						r.changeColor(new Color(31, 162, 255));
						r.changeColor(new Color(31, 129, 255));
						break;
					case 162:
						r.changeColor(new Color(31, 151, 255));
						break;
					case 151:
						r.changeColor(new Color(31, 140, 255));
						break;
					case 140:
						r.changeColor(new Color(31, 129, 255));
						break;
					case 129:
//						r.changeColor(new Color(42, 120, 255));
						r.changeColor(new Color(75, 93, 255));
						break;
					case 120:
						r.changeColor(new Color(53, 111, 255));
						break;
					case 111:
						r.changeColor(new Color(64, 102, 255));
						break;
					case 102:
						r.changeColor(new Color(75, 93, 255));
						break;
					case 93:
//						r.changeColor(new Color(86, 84, 255));
						r.changeColor(new Color(118, 58, 255));
						break;
					case 84:
						r.changeColor(new Color(96, 76, 255));
						break;
					case 76:
						r.changeColor(new Color(107, 67, 255));
						break;
					case 67:
						r.changeColor(new Color(118, 58, 255));
						break;
					case 58:
//						r.changeColor(new Color(129, 49, 255));
						r.changeColor(new Color(151, 31, 255));
						break;
					case 49:
						r.changeColor(new Color(140, 40, 255));
						break;
					case 40:
						r.changeColor(new Color(151, 31, 255));
						break;
					default:
						switch(red) {
						case 151:
//							r.changeColor(new Color(156, 31, 255));
							r.changeColor(new Color(175, 31, 255));
							break;
						case 156:
							r.changeColor(new Color(161, 31, 255));
							break;
						case 161:
							r.changeColor(new Color(165, 31, 255));
							break;
						case 165:
							r.changeColor(new Color(170, 31, 255));
							break;
						case 170:
							r.changeColor(new Color(175, 31, 255));
							break;
						case 175:
//							r.changeColor(new Color(180, 31, 255));
							r.changeColor(new Color(194, 31, 255));
							break;
						case 180:
							r.changeColor(new Color(185, 31, 255));
							break;
						case 185:
							r.changeColor(new Color(190, 31, 255));
							break;
						case 190:
							r.changeColor(new Color(194, 31, 255));
							break;
						case 194:
//							r.changeColor(new Color(199, 31, 255));
							r.changeColor(new Color(207, 31, 255));
							break;
						case 199:
							r.changeColor(new Color(204, 31, 255));
							break;
						case 204:
							r.changeColor(new Color(207, 31, 255));
							break;
						case 207:
//							r.changeColor(new Color(211, 31, 255));
							r.changeColor(new Color(224, 31, 255));
							break;
						case 211:
							r.changeColor(new Color(214, 31, 255));
							break;
						case 214:
							r.changeColor(new Color(217, 31, 255));
							break;
						case 217:
							r.changeColor(new Color(221, 31, 255));
							break;
						case 221:
							r.changeColor(new Color(224, 31, 255));
							break;
						case 224:
//							r.changeColor(new Color(228, 31, 255));
							r.changeColor(new Color(238, 31, 255));
							break;
						case 228:
							r.changeColor(new Color(231, 31, 255));
							break;
						case 231:
							r.changeColor(new Color(234, 31, 255));
							break;
						case 234:
							r.changeColor(new Color(238, 31, 255));
							break;
						case 238:
//							r.changeColor(new Color(241, 31, 255));
							r.changeColor(new Color(244, 23, 185));
							break;
						case 241:
							r.changeColor(new Color(209, 28, 232));
							break;
						}
					}
					break;
				default:
					r.changeColor(new Color(255, 0, 0));
					break;
				}
			}
		}
	}
	
}
