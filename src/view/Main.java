package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bty.dp.CongNhan;
import com.bty.dp.CongNhanReader;
import com.bty.dp.SinhVien;
import com.bty.dp.SinhVienReader;

import adapter.PhanTu;
import adapter.PhanTuOfCongNhan;
import adapter.PhanTuOfSinhVien;

public class Main {

	public static void main(String[] args) throws IOException {
		SinhVienReader sinhVienReader = new SinhVienReader();
		List<SinhVien> dsSV = sinhVienReader.readFromFile("txt/sv.txt");
		
		CongNhanReader congNhanReader = new CongNhanReader();
		List<CongNhan> dsCN = congNhanReader.readFromFile("txt/cn.txt");
		
		List<PhanTu> dsPT = new ArrayList<PhanTu>();
		
		for(SinhVien sv : dsSV) {
			dsPT.add(new PhanTuOfSinhVien(sv));
		}
		for(CongNhan cn : dsCN) {
			dsPT.add(new PhanTuOfCongNhan(cn));
		}
		
//		for(PhanTu pt : dsPT) {
//			System.out.println(pt.getHoTen() + " " + pt.getLoai() + " " + pt.getDoUuTien());
//		}
		
		for(int i = 0; i <= dsPT.size() - 2; i++) {
			for(int j = i+1; j <= dsPT.size() - 1; j++) {
				if(dsPT.get(i).getDoUuTien().compareTo(dsPT.get(j).getDoUuTien()) > 0) {
					PhanTu tmp = dsPT.get(i);
					dsPT.set(i, dsPT.get(j));
					dsPT.set(j, tmp);
				}
			}
		}
		System.out.printf("%-5s%-20s%-5s%-10s\n", "STT", "Họ tên", "Loại", "Độ ưu tiên");
		for(int i = 0; i < dsPT.size(); i++) {
			PhanTu pt = dsPT.get(i);
			System.out.printf("%-5d%-20s%-5s%-10s\n", i+1, pt.getHoTen(), pt.getLoai(), pt.getDoUuTien());
		}
	}
}
