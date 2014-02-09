package com.clackjones.swingenere.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleFactory {
	 private static Locale currentLocale = Locale.getDefault();
     private static ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", currentLocale);

     public static ResourceBundle getResourceBundle() {
    	 return messages;
     }
     
     public static void main(String args[]) {
    	 ResourceBundle rb = ResourceBundleFactory.getResourceBundle();
    	 System.out.printf("swingenere.title=%s\n", rb.getString("swingenere.title"));
     }
}
