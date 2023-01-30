package com.mjc.school.controller.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TakeStringFromKeyboard {
    public String takeStringFromKeyboard() throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedreader.readLine();
    }
}
