package org.harrydev.discordx.Utils;

public class MoreUtils {
    public static boolean testForPing(String msg){
        return msg.toLowerCase().contains("@everyone") || msg.toLowerCase().contains("@here");
    }
}
