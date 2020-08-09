package com.example.googlemgamebar;

import android.widget.ImageView;
import android.widget.TextView;

public class SingleRow {
   private int image;
   private String txtgame;

    public SingleRow(int image, String txtgame) {
        this.image = image;
        this.txtgame = txtgame;
    }

    public String getTxtgame() {
        return txtgame;
    }

    public void setTxtgame(String txtgame) {
        this.txtgame = txtgame;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
