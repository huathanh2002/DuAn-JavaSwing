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
public class Size {
    private String id,maSize,tenSize;

    public Size() {
    }

    public Size(String maSize, String tenSize) {
        this.maSize = maSize;
        this.tenSize = tenSize;
    }

    public Size(String id, String maSize, String tenSize) {
        this.id = id;
        this.maSize = maSize;
        this.tenSize = tenSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    @Override
    public String toString() {
        return getTenSize();
    }
   public Object[] toDataRow(){
       return new Object[]{this.maSize,this.tenSize};
   }
}
