package com.rum.ksc_back.domain.Ron;

import java.util.ArrayList;
import java.util.HashMap;

public class Pic {
    private int picId;
    private String picUrl;

    public Pic(int picId, String picUrl) {
        this.picId = picId;
        this.picUrl = picUrl;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
