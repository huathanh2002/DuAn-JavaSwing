/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

/**
 *
 * @author natsu
 */
public class InHoaDon {

    public void generateInvoice(String fileName, HoaDon hoaDon, List<HoaDonChiTiet> chiTietHoaDonList) {
        try {
            // Tạo một tệp PDF mới
            PDDocument document = new PDDocument();

            // Thêm trang vào tệp PDF
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Load font từ tệp truetype (ttf)
            PDType0Font font = PDType0Font.load(document, new File("C:/Users/natsu/Downloads/Unicode/Unicode/times.ttf"));

            // Thêm thông tin hóa đơn và chi tiết hóa đơn vào tệp PDF
            addInvoiceInfo(document, hoaDon, font);
            addInvoiceDetails(document, chiTietHoaDonList, font);
            addPaymentInfo(document,chiTietHoaDonList, hoaDon, font);

            // Ghi tệp PDF vào đĩa
            document.save(new File(fileName));
            document.close();

            System.out.println("Tệp PDF được tạo thành công.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addInvoiceInfo(PDDocument document, HoaDon hoaDon, PDType0Font font) throws IOException {
        PDPage page = document.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        float margin = 50;
        float yStart = page.getMediaBox().getHeight() - margin;
        float yPosition = yStart;
        float fontSize = 12f;

        contentStream.setFont(font, fontSize);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);

        // Thử thay "Đ" thành "D"
        contentStream.showText("HOA DON MUA HANG");

        contentStream.endText();

        contentStream.setFont(font, fontSize);
        yPosition -= 2 * fontSize;
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText("Mã hóa đon: " + hoaDon.getId());
        contentStream.newLineAtOffset(0, -fontSize);
        contentStream.showText("Nhân viên: " + hoaDon.getNv().getHoTen());
        contentStream.newLineAtOffset(0, -fontSize);
        contentStream.showText("Khách hàng: " + hoaDon.getKh().getTen());
        contentStream.newLineAtOffset(0, -fontSize);
        contentStream.showText("Ngày thanh toán: " + hoaDon.getNgayThanhToan().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        contentStream.newLineAtOffset(0, -fontSize);
        contentStream.showText("Phương thức thanh toán: " + hoaDon.getPttt());
        contentStream.endText();

        contentStream.close();
    }

    private void addInvoiceDetails(PDDocument document, List<HoaDonChiTiet> chiTietHoaDonList, PDType0Font font) throws IOException {
        PDPage page = document.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);

        float margin = 50;
        float yStartTable = page.getMediaBox().getHeight() - 200;
        float bottomMargin = 70;
        float yPositionTable = yStartTable;
        float tableHeight = 50;
        float fontSize = 10f;

        // Vẽ đường kẻ bảng
        contentStream.setLineWidth(1f);
        contentStream.moveTo(margin, yStartTable);
        contentStream.lineTo(margin + 500, yStartTable);
        contentStream.stroke();

        // Vẽ tiêu đề bảng
        float yPositionTitle = yStartTable - 7;
        contentStream.setFont(font, fontSize);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPositionTitle);
        contentStream.showText("STT");
        contentStream.newLineAtOffset(50, 0);
        contentStream.showText("Sản phẩm");
        contentStream.newLineAtOffset(150, 0);
        contentStream.showText("Số lượng");
        contentStream.newLineAtOffset(100, 0);
        contentStream.showText("Đơn giá");
        contentStream.newLineAtOffset(100, 0);
        contentStream.showText("Thành tiền");
        contentStream.endText();

        // Vẽ dòng kẻ dưới tiêu đề bảng
        contentStream.setLineWidth(1f);
        contentStream.moveTo(margin, yPositionTitle - 5);
        contentStream.lineTo(margin + 500, yPositionTitle - 5);
        contentStream.stroke();

        // Bắt đầu text mode ngoài vòng lặp
        contentStream.beginText();

        // Vẽ dòng dữ liệu
        float tableRowHeight = 20;

        for (int i = 0; i < chiTietHoaDonList.size(); i++) {
            HoaDonChiTiet chiTiet = chiTietHoaDonList.get(i);
            contentStream.setFont(font, fontSize);

            // Di chuyển vị trí của dòng dữ liệu dựa trên chiều cao của nó
            yPositionTable -= tableRowHeight;

            contentStream.newLineAtOffset(margin, yPositionTable);
            contentStream.showText(String.valueOf(i + 1));
            contentStream.newLineAtOffset(50, 0);
            contentStream.showText(chiTiet.getSanPham().getTenSP());
            contentStream.newLineAtOffset(150, 0);
            contentStream.showText(String.valueOf(chiTiet.getSoLuong()));
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(formatCurrency(chiTiet.getDonGia()));
            contentStream.newLineAtOffset(100, 0);
            contentStream.showText(formatCurrency(chiTiet.getSoLuong() * chiTiet.getDonGia()));

            // Kết thúc text mode cho mỗi lần lặp
            contentStream.endText();
            // Bắt đầu text mode cho lần lặp tiếp theo (nếu có)
            contentStream.beginText();
        }

        // Kết thúc text mode sau khi vòng lặp
        contentStream.endText();

        contentStream.close();
    }

    private void addPaymentInfo(PDDocument document,List<HoaDonChiTiet> chiTietHoaDonList, HoaDon hoaDon, PDType0Font font) throws IOException {
        PDPage page = document.getPage(0);
        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);

        float margin = 50;
        float yPosition = page.getMediaBox().getHeight() - 300;
        float fontSize = 12f;

        // Tính toán chiều cao của bảng chi tiết
        float tableHeight = calculateTableHeight(chiTietHoaDonList, margin, fontSize);

        // Giãn cách giữa bảng chi tiết và phần thông tin thanh toán
        float spacing = 10;

        yPosition -= (tableHeight + spacing);

        contentStream.setFont(font, fontSize);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText("THANH TOÁN");
        contentStream.endText();

        contentStream.setFont(font, fontSize);
        yPosition -= 2 * fontSize;
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText("Tổng tiền hóa đơn : " + formatCurrency(hoaDon.getTienHoaDon()));
        contentStream.newLineAtOffset(0, -fontSize);
        contentStream.showText("Tổng tiền phải trả: " + formatCurrency(hoaDon.getTongTien()));
        contentStream.newLineAtOffset(0, -fontSize);
        contentStream.showText("Tiền khách đưa: " + formatCurrency(hoaDon.getTienKhachDua()));
        contentStream.newLineAtOffset(0, -fontSize);
        contentStream.showText("Tiền thừa: " + formatCurrency(hoaDon.getTienThua()));
        contentStream.endText();

        contentStream.close();
    }

    private float calculateTableHeight(List<HoaDonChiTiet> chiTietHoaDonList, float margin, float fontSize) {
        float tableRowHeight = 20;
        float tableHeight = 2 * fontSize; // Chiều cao của tiêu đề bảng

        // Tính toán chiều cao dựa trên số lượng sản phẩm trong chi tiết hóa đơn
        tableHeight += chiTietHoaDonList.size() * tableRowHeight;

        return tableHeight;
    }

    private String formatCurrency(double value) {
        NumberFormat currencyFormat = new DecimalFormat("#,##0.00");
        return currencyFormat.format(value);
    }
}
