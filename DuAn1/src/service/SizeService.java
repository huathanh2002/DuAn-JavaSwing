/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import model.Size;
import reponsitory.SizeRepository;

/**
 *
 * @author natsu
 */
public class SizeService {
    private final SizeRepository sizeRepository;
    
    public SizeService() {
        this.sizeRepository = new SizeRepository();
    }
    
    public List<Size> getAll() {
        return sizeRepository.getAll();
    }
    
    public Integer addSP(Size s) {
        return sizeRepository.addSP(s);
    }
    
    public Integer updateSP(Size s,String id) {
        return sizeRepository.updateSP(s,id);
    }
    
    public Integer deleteSP(String ma) {
        return sizeRepository.deleteSP(ma);
    }
    public Size getMaSize(String ma){
        return sizeRepository.getMaSize(ma);
    }
}
