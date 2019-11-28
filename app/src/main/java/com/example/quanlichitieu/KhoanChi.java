package com.example.quanlichitieu;

import java.util.Date;

public class KhoanChi {
    private String mNoiDung;
    private String mSoTien;


    public KhoanChi(String mNoiDung, String mSoTien) {
        this.mNoiDung = mNoiDung;
        this.mSoTien = mSoTien;
    }

    public KhoanChi() {
    }

    public String getmNoiDung() {
        return mNoiDung;
    }

    public void setmNoiDung(String mNoiDung) {
        this.mNoiDung = mNoiDung;
    }

    public String getmSoTien() {
        return mSoTien;
    }

    public void setmSoTien(String mSoTien) {
        this.mSoTien = mSoTien;
    }
}
