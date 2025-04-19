package adapter;

import com.bty.dp.SinhVien;

public class PhanTuOfSinhVien implements PhanTu {
	private SinhVien sinhVien;

	public PhanTuOfSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}

	@Override
	public String getHoTen() {
		
		return sinhVien.getHoDem() + " " + sinhVien.getTen();
	}

	@Override
	public String getLoai() {

		return "SV";
	}

	@Override
	public String getDoUuTien() {
		double dtb10 = sinhVien.getDiemTrungBinh();
		if(dtb10 < 4) return "X";
		else if(dtb10 < 6.5) return "D";
		else if(dtb10 < 7.5) return "C";
		else if(dtb10 < 8.5) return "B";
		else return "A";
	}
	
	
}
