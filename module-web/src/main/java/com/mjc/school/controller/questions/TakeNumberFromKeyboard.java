package com.mjc.school.controller.questions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TakeNumberFromKeyboard {

    public int takeNumberFromKeyboard() throws IOException {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedreader.readLine());
    }
}
