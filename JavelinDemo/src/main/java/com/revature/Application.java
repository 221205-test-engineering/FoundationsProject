package com.revature;

import io.javalin.Javalin;

public class Application {



    public static void main(String[] args) {
//        System.out.println("Hello Program");
        Javalin app = Javalin.create();

            app.start(8880);


    }

}
