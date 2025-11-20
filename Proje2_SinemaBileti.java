Ad Soyad: Şevval Yıldız
Öğrenci NO: 250541025
import java.util.Scanner;

public class SinemaBileti {

    // 1. Hafta sonu mu?
    public static boolean isWeekend(int gun) {
        return gun == 6 || gun == 7;   // 6=Ctesi, 7=Pazar
    }

    // 2. Matine mi? (12:00 öncesi)
    public static boolean isMatinee(int saat) {
        return saat < 12;
    }

    // 3. Temel fiyat hesapla
    public static double calculateBasePrice(int gun, int saat) {
        boolean weekend = isWeekend(gun);
        boolean matinee = isMatinee(saat);

        if (weekend) {
            if (matinee) return 55;
            else return 85;
        } else {
            if (matinee) return 45;
            else return 65;
        }
    }

    // 4. İndirim hesapla
    public static double calculateDiscount(int yas, int meslek, int gun) {
        double indirimOrani = 0;

        // ---- YAŞ İNDİRİMLERİ ----
        if (yas >= 65) indirimOrani = 0.30;
        else if (yas < 12) indirimOrani = 0.25;

        // ---- MESLEK İNDİRİMLERİ ----
        else if (meslek == 1) { // öğrenci
            if (gun >= 1 && gun <= 4) indirimOrani = 0.20; // pzt-perş
            else indirimOrani = 0.15; // cuma-pazar
        }
        else if (meslek == 2 && gun == 3) { // öğretmen ve Çarşamba
            indirimOrani = 0.35;
        }

        return indirimOrani;
    }

    // 5. Film türü ekstra
    public static double getFormatExtra(int filmTuru) {
        switch (filmTuru) {
            case 2: return 25; // 3D
            case 3: return 35; // IMAX
            case 4: return 50; // 4DX
            default: return 0; // 2D
        }
    }

    // 6. Final fiyat hesaplama
    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru) {
        double base = calculateBasePrice(gun, saat);
        double discount = calculateDiscount(yas, meslek, gun);
        double discounted = base - (base * discount);
        double extra = getFormatExtra(filmTuru);
        return discounted + extra;
    }

    // 7. Bilet çıktısı oluştur
    public static void generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru) {
        double base = calculateBasePrice(gun, saat);
        double discountRate = calculateDiscount(yas, meslek, gun);
        double discountAmount = base * discountRate;
        double discounted = base - discountAmount;
        double extra = getFormatExtra(filmTuru);
        double total = discounted + extra;

        System.out.println("\n=== BILET BILGILERI ===");
        System.out.println("Gun           : " + gun);
        System.out.println("Saat          : " + saat);
        System.out.println("Yas           : " + yas);
        System.out.println("Meslek        : " + meslek);
        System.out.println("Film Turu     : " + filmTuru);
        System.out.println("-------------------------------");
        System.out.println("Temel Fiyat   : " + base + " TL");
        System.out.println("Indirim       : " + (discountAmount) + " TL");
        System.out.println("Ekstra Format : " + extra + " TL");
        System.out.println("TOPLAM        : " + total + " TL");
    }

    // MAIN
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Gun (1=Pzt ... 7=Paz): ");
        int gun = sc.nextInt();

        System.out.print("Saat (8-23): ");
        int saat = sc.nextInt();

        System.out.print("Yas: ");
        int yas = sc.nextInt();

        System.out.print("Meslek (1=Ogrenci, 2=Ogretmen, 3=Diger): ");
        int meslek = sc.nextInt();

        System.out.print("Film Turu (1=2D, 2=3D, 3=IMAX, 4=4DX): ");
        int filmTuru = sc.nextInt();

        generateTicketInfo(gun, saat, yas, meslek, filmTuru);
    }
}
