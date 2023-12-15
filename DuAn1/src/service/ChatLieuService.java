/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.ChatLieu;
import reponsitory.ChatLieuRepository;

/**
 *
 * @author natsu
 */
public class ChatLieuService {

    private final ChatLieuRepository chatLieuRepository;

    public ChatLieuService() {
        this.chatLieuRepository = new ChatLieuRepository();
    }

    public List<ChatLieu> getAll() {
        return chatLieuRepository.getAll();
    }

    public Integer addSP(ChatLieu cl) {
        return chatLieuRepository.addSP(cl);
    }

    public Integer updateSP(ChatLieu cl, String id) {
        return chatLieuRepository.updateSP(cl, id);
    }

    public Integer deleteSP(String ma) {
        return chatLieuRepository.deleteSP(ma);
    }
    
       public List<ChatLieu> timcl(String ChatLieu){
        return chatLieuRepository.timcl(ChatLieu);
    }
}
