package org.harrydev.discordx.Extentions;

public class MalformedExtensionException extends RuntimeException{
    public MalformedExtensionException(String errorMessage) {
        super(errorMessage);
    }
}
