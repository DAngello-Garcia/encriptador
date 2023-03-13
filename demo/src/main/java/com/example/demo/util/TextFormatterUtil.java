package com.example.demo.util;

import javafx.scene.control.TextFormatter;

public class TextFormatterUtil {
    public static TextFormatter.Change integerFormat(TextFormatter.Change change){
        return (change.getText().matches("[0-9]*")) ? change:null;
    }
}
