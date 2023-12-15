/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.MauSac;
import reponsitory.MauSacRepository;

/**
 *
 * @author natsu
 */
public class MauSacService {
    private final MauSacRepository mauSacRepository;
    
    public MauSacService() {
        this.mauSacRepository = new MauSacRepository();
    }
    
    public List<MauSac> getAll() {
        return mauSacRepository.getAll();
    }
    
    public Integer addSP(MauSac ms) {
        return mauSacRepository.addSP(ms);
    }
    
    public Integer updateSP(MauSac ms,String id) {
        return mauSacRepository.updateSP(ms, id);
    }
    
    public Integer deleteSP(String ma) {
        return mauSacRepository.deleteSP(ma);
    }
    public List<MauSac> searchName(String name){
        return mauSacRepository.searchName(name);
    }
}
