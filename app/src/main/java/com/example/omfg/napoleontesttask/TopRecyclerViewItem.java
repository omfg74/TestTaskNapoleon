package com.example.omfg.napoleontesttask;

import android.media.Image;
import android.widget.ImageView;
import android.widget.TextView;

public class TopRecyclerViewItem {

    public String textView;
    public Image imageView;

    public String getTextView() {
        return textView;
    }

    public Image getImageView() {
        return imageView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }

    public void setImageView(Image imageView) {
        this.imageView = imageView;
    }
}
