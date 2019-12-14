package sample;

import java.text.DecimalFormat;

public class Data {
    double countSoftware = 0;
    double countEnglish = 0;
    double countNeuro = 0;
    double countMusic = 0;
    double countSociology = 0;
    double total = 0;
    double countA = 0;
    double countB = 0;
    double countC = 0;
    double countD = 0;
    double countF = 0;


    Data(double countSoftware, double countEnglish, double countNeuro, double countMusic, double countSociology, double countA,
         double countB, double countC, double countD, double countF) {
        this.countSoftware = countSoftware;
        this.countEnglish = countEnglish;
        this.countNeuro = countNeuro;
        this.countMusic = countMusic;
        this.countSociology = countSociology;
        this.countA = countA;
        this.countB = countB;
        this.countC = countC;
        this.countD = countD;
        this.countF = countF;
    }

    public void setCountSoftware(double countSoftware) {
        this.countSoftware = countSoftware;
    }

    public void setCountEnglish(double countEnglish) {
        this.countEnglish = countEnglish;
    }

    public void setCountNeuro(double countNeuro) {
        this.countNeuro = countNeuro;
    }

    public void setCountMusic(double countMusic) {
        this.countMusic = countMusic;
    }

    public void setCountSociology(double countSociology) {
        this.countSociology = countSociology;
    }

    public void setCountA(double countA) {
        this.countA = countA;
    }

    public void setCountB(double countB) {
        this.countB = countB;
    }

    public void setCountC(double countC) {
        this.countC = countC;
    }

    public void setCountD(double countD) {
        this.countD = countD;
    }

    public void setCountF(double countF) {
        this.countF = countF;
    }

    public double calcData(double value) {
        double total = countSoftware + countEnglish + countNeuro + countMusic + countNeuro;
        double percentValue = (value/total) * 100.0;
        return percentValue;
    }

    public double calcGrades(double value) {
        double total = countA + countB + countC + countD + countF;
        double percentValue = (value/total) * 100.0;
        return percentValue;
    }

}
