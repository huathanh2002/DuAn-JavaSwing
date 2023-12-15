/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package reponsitory;

import java.util.List;
import model.NhanVienModel;

/**
 *
 * @author THANH
 */
public interface NhanVienITF {
    List<NhanVienModel> getAll();
    List<NhanVienModel> search(String a);
    public int add(NhanVienModel nv);
    public int update(NhanVienModel nv,String id);
    public int delete(String id);
    public int checkMa(String ma);
    public List<NhanVienModel> timTen(String ten);
    public  String idNV(String tenCV);
    public int upNghiViec(String id);
}
