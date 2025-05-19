package org.example.learn.tomcat.debug;

import java.io.File;

public class MavenDepTest {

    public static void main(String[] args) {
        // cwd -> 项目根目录
        File rootDir = new File("");
        System.out.println("rootDir.getAbsolutePath() = " + rootDir.getAbsolutePath());

        File tomcatLibDir = new File("tomcat/apache-tomcat-9.0.89/lib");
        System.out.println("tomcatLibDir.getAbsolutePath() = " + tomcatLibDir.getAbsolutePath());
        File[] files = tomcatLibDir.listFiles();
        for (File file : files) {
//            System.out.println(file.getName());
            String pattern =
                    "        <dependency>\n" +
                    "            <groupId>tomcat</groupId>\n" +
                    "            <artifactId>%s</artifactId>\n" +
                    "            <version>1.0</version>\n" +
                    "            <scope>system</scope>\n" +
                    "            <systemPath>${project.basedir}/../tomcat/apache-tomcat-9.0.89/lib/%s</systemPath>\n" +
                    "        </dependency>";

            System.out.println(String.format(pattern, file.getName(), file.getName()));
        }
    }
}
