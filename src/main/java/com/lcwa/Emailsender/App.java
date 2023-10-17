package com.lcwa.Emailsender;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        GEmailSender gEmailSender = new GEmailSender();
        String to = "ajaypatil02007@gmail.com";
        String from = "ajaypatil01007@gmail.com";
        String subject = "Sending email with attachment using Java";
        String text = "Hi Sir please check my image";
        File file=new File("C:\\Users\\91983\\Downloads\\Ajay_Image.jpeg");
//        boolean b = gEmailSender.sendEmail(to, from, subject, text);
//        if (b) {
//            System.out.println("Email is sent successfully");
//        } else {
//            System.out.println("There is problem in sending email");
//        }
        boolean b=gEmailSender.imageSender(to, from, subject, text, file);
        if (b) {
          System.out.println("Email is sent successfully");
      } else {
          System.out.println("There is problem in sending email");
      }
    }
}
