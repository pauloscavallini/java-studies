package application;

import application.entities.Comment;
import application.entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Post p1 = new Post(
                sdf.parse("21/06/2018 13:05:44"),
                "Travelling to New Zealand",
                "I'm going to visit this wonderful country!",
                12);

        p1.addComment(new Comment("Have a nice trip"));
        p1.addComment(new Comment("Wow that's awesome!"));

        Post p2 = new Post(
                sdf.parse("28/07/2018 23:14:19"),
                "Good night guys",
                "See you tomorrow",
                12);

        p2.addComment(new Comment("Good night"));
        p2.addComment(new Comment("May the Force be with you"));

        System.out.print(p1);
        System.out.print(p2);
    }
}
