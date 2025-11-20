Ad Soyad: Şevval Yıldız
Öğrenci NO: 250541025
import java.util.Scanner;

public class RestoranSiparis {

    // 1) ANA YEMEK FİYATI
    public static double getMainDishPrice(int secim) {
        switch (secim) {
            case 1: return 85;
            case 2: return 120;
            case 3: return 110;
            case 4: return 65;
            default: return 0;
        }
    }

    // 2) BAŞLANGIÇ FİYATI
    public static double getAppetizerPrice(int secim) {
        switch (secim) {
            case 1: return 25;
            case 2: return 45;
            case 3: return 55;
            default: return 0;
        }
    }

    // 3) İÇECEK FİYATI
    public static double getDrinkPrice(int secim) {
        switch (secim) {
            case 1: return 15;
            case 2: return 12;
            case 3: return 35;
            case 4: return 25;
            default: return 0;
        }
    }

    // 4) TATLI FİYATI
    public static double getDessertPrice(int secim) {
        switch (secim) {
            case 1: return 65;
            case 2: return 55;
            case 3: return 35;
            case 4: return 25;
            default: return 0;
        }
    }

    // 5) COMBO MENÜ? (ana, içecek, tatlı varsa true)
    public static boolean isComboOrder(boolean ana, boolean icecek, boolean tatli) {
        return ana && icecek && tatli;
    }

    // 6) HAPPY HOUR? (14–17 arası)
    public static boolean isHappyHour(int saat) {
        return saat >= 14 && saat <= 17;
    }

    // 7) İNDİRİM HESABI
    public static double calculateDiscount(double tutar, boolean combo, boolean ogrenci, int saat) {
        double totalDiscount = 0;

        // COMBO: %15
        if (combo) {
            totalDiscount += tutar * 0.15;
        }

        // 200 TL üzeri: %10
        if (tutar >= 200) {
            totalDiscount += tutar * 0.10;
        }

        // ÖĞRENCİ: hafta içi %10
        if (ogrenci) {
            totalDiscount += tutar * 0.10;
        }

        return totalDiscount;
    }

    // 8) BAHŞİŞ %10
    public static double calculateServiceTip(double tutar) {
        return tutar * 0.10;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ana Yemek (1-4): ");
        int ana = sc.nextInt();

        System.out.println("Başlangıç (0-3): ");
        int bas = sc.nextInt();

        System.out.println("İçecek (0-4): ");
        int ice = sc.nextInt();

        System.out.println("Tatlı (0-4): ");
        int tat = sc.nextInt();

        System.out.println("Saat (8-23): ");
        int saat = sc.nextInt();

        System.out.print("Öğrenci misiniz? (E/H): ");
        char ogr = sc.next().toUpperCase().charAt(0);
        boolean ogrenci = (ogr == 'E');

        // Fiyat hesaplama
        double toplam = 0;

        if (ana != 0) toplam += getMainDishPrice(ana);
        if (bas != 0) toplam += getAppetizerPrice(bas);
        if (ice != 0) toplam += getDrinkPrice(ice);
        if (tat != 0) toplam += getDessertPrice(tat);

        System.out.println("Ara toplam: " + toplam + " TL");

        // combo kontrolü
        boolean combo = isComboOrder(ana != 0, ice != 0, tat != 0);

        // HAPPY HOUR (sadece içeceğe %20)
        double happyDiscount = 0;
        if (isHappyHour(saat) && ice != 0) {
            happyDiscount = getDrinkPrice(ice) * 0.20;
            System.out.println("Happy Hour indirimi: -" + happyDiscount + " TL");
        }

        // Ana indirim
        double genelIndirim = calculateDiscount(toplam, combo, ogrenci, saat);

        System.out.println("Genel indirimler: -" + genelIndirim + " TL");

        double odenecek = toplam - genelIndirim - happyDiscount;

        System.out.println("Toplam: " + odenecek + " TL");

        double bahsis = calculateServiceTip(odenecek);
        System.out.println("Bahşiş önerisi (%10): " + bahsis + " TL");
    }
}
