Ad Soyad : Şevval Yıldız
Öğrenci NO: 250541025
import java.util.Scanner;

public class NotSistemi {

    public static double calculateAverage(double vize, double finalNot, double odev) {
        return (vize * 0.30) + (finalNot * 0.40) + (odev * 0.30);
    }

    public static boolean isPassingGrade(double ortalama) {
        return ortalama >= 50;
    }

    public static String getLetterGrade(double ort) {
        if (ort >= 90) return "A";
        else if (ort >= 80) return "B";
        else if (ort >= 70) return "C";
        else if (ort >= 60) return "D";
        else return "F";
    }

    public static boolean isHonorList(double ort, double vize, double finalNot, double odev) {
        return ort >= 85 && vize >= 70 && finalNot >= 70 && odev >= 70;
    }

    public static boolean hasRetakeRight(double ort) {
        return ort >= 40 && ort < 50;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Vize: ");
        double vize = sc.nextDouble();

        System.out.print("Final: ");
        double finalNot = sc.nextDouble();

        System.out.print("Odev: ");
        double odev = sc.nextDouble();

        double ort = calculateAverage(vize, finalNot, odev);

        System.out.println("\n=== OGRENCI NOT RAPORU ===");
        System.out.println("Vize Notu  : " + vize);
        System.out.println("Final Notu : " + finalNot);
        System.out.println("Odev Notu  : " + odev);
        System.out.println("-----------------------------");
        System.out.printf("Ortalama   : %.1f\n", ort);
        System.out.println("Harf Notu  : " + getLetterGrade(ort));
        System.out.println("Durum      : " + (isPassingGrade(ort) ? "GECTI" : "KALDI"));
        System.out.println("Onur Listesi : " + (isHonorList(ort, vize, finalNot, odev) ? "EVET" : "HAYIR"));
        System.out.println("Butunleme    : " + (hasRetakeRight(ort) ? "VAR" : "YOK"));
    }
}
  
