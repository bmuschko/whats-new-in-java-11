package com.bmuschko.java11.removals.jaf;

import javax.activation.MailcapCommandMap;

public class MailProcessor {
    public void printMimeTypes() {
        MailcapCommandMap mailcapCommandMap = new MailcapCommandMap();
        String[] mimeTypes = mailcapCommandMap.getMimeTypes();

        for (String mime : mimeTypes) {
            System.out.println(mime);
        }
    }
}
