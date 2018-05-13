package ru.gosha;

import ru.gosha.SG_Muwa.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        OpenFile openFile = new OpenFile();
        System.out.println(openFile.Open("/Users/georgijfalileev/Downloads/Example2.xlsx"));
        System.out.println(openFile.Open("/Users/georgijfalileev/Downloads/Example1.xls"));

    }
}


