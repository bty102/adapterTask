package adapter;

import java.time.LocalDate;

import com.bty.dp.CongNhan;

public class PhanTuOfCongNhan implements PhanTu {

	private CongNhan congNhan;

	public PhanTuOfCongNhan(CongNhan congNhan) {
		this.congNhan = congNhan;
	}

	@Override
	public String getHoTen() {

		return congNhan.getHoTen();
	}

	@Override
	public String getLoai() {

		return "CN";
	}

	@Override
	public String getDoUuTien() {
		LocalDate now = LocalDate.now();
		int soNamThamNien = now.getYear() - congNhan.getNgayVaoLam().getYear() + 1;
		if(soNamThamNien < 2) return "X";
		else if(soNamThamNien < 5) return "D";
		else if(soNamThamNien < 10) return "C";
		else if(soNamThamNien < 20) return "B";
		else return "A";
	}
	
}
