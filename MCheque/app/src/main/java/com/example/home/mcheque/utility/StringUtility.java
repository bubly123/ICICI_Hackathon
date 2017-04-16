package com.example.home.mcheque.utility;


import android.text.Html;
import android.text.Spanned;

public class StringUtility {
    public static Spanned getColoredSpannedText(String text, String color) {
       ;
        Spanned input =  Html.fromHtml("<font color=" + color + ">" + text + "</font>") ;
        return input;
    }
}
