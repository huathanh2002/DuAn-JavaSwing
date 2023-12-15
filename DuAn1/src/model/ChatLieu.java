/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author natsu
 */
public class ChatLieu {
    private String id,maChatLieu,tenChatLieu;

    public ChatLieu() {
    }
 public ChatLieu(String maChatLieu, String tenChatLieu) {
        this.maChatLieu = maChatLieu;
        this.tenChatLieu = tenChatLieu;
    }
    public ChatLieu(String id, String maChatLieu, String tenChatLieu) {
        this.id = id;
        this.maChatLieu = maChatLieu;
        this.tenChatLieu = tenChatLieu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    @Override
    public String toString() {
        return getTenChatLieu();
    }


}
