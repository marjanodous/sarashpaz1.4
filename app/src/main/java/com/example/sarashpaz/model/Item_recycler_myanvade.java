package com.example.sarashpaz.model;

public class Item_recycler_myanvade {
    private int uAvatar;
    private String uName;

    public Item_recycler_myanvade(int uAvatar, String uName) {
        this.uAvatar = uAvatar;
        this.uName = uName;

    }

    public int getuAvatar() {
        return uAvatar;
    }

    public void setuAvatar(int uAvatar) {
        this.uAvatar = uAvatar;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }


}
