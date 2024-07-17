package com.example.learn.tomcat.war;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
    public static void main(String[] args) throws MalformedURLException {
        File cwd = new File("");
        System.out.println("cwd.getAbsolutePath() = " + cwd.getAbsolutePath());

        File file = new File(cwd.getParent(), "ch01-war/target/classes/bundle");
        URL[] urls = {file.toURI().toURL()};
        ResourceBundle rb = ResourceBundle.getBundle("LocalStrings", Locale.CHINA, new URLClassLoader(urls));
        String title = rb.getString("helloworld.title");
        System.out.println("title = " + title);
    }
}
