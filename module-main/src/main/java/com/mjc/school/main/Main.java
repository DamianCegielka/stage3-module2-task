package com.mjc.school.main;

import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.impl.BaseControllerImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BaseController mainController = new BaseControllerImpl();
        ((BaseControllerImpl) mainController).mainController();
    }
}
