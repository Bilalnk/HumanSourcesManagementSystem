package com.kodlama.hrms.Mernis;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexdeneme {

    public static void main(String[] args) {

        String line = "\n" +
                "('BAYBURT ÜNİVERSİTESİ', 69, 1),\n" +
                "('BEYKENT ÜNİVERSİTESİ', 34, 1),\n" +
                "('BEYKOZ ÜNİVERSİTESİ', 34, 1),\n" +
                "('BEZM-İ ÂLEM VAKIF ÜNİVERSİTESİ', 34, 1),\n" +
                "('BİLECİK ŞEYH EDEBALİ ÜNİVERSİTESİ', 11, 1),\n" +
                "('BİNGÖL ÜNİVERSİTESİ', 12, 1),\n" +
                "('BİRUNİ ÜNİVERSİTESİ', 34, 1),\n" +
                "('BİTLİS EREN ÜNİVERSİTESİ', 13, 1),\n" +
                "('BOĞAZİÇİ ÜNİVERSİTESİ', 34, 1),\n" +
                "('BOZOK ÜNİVERSİTESİ', 66, 1),\n" +
                "('BURSA TEKNİK ÜNİVERSİTESİ', 16, 1),\n" +
                "('BÜLENT ECEVİT ÜNİVERSİTESİ', 67, 1),\n" +
                "('CUMHURİYET ÜNİVERSİTESİ', 58, 1),\n" +
                "('ÇAĞ ÜNİVERSİTESİ', 33, 1),\n" +
                "('ÇANAKKALE ONSEKİZ MART ÜNİVERSİTESİ', 17, 1),\n" +
                "('ÇANKAYA ÜNİVERSİTESİ', 6, 1),\n" +
                "('ÇANKIRI KARATEKİN ÜNİVERSİTESİ', 18, 1),\n" +
                "('ÇUKUROVA ÜNİVERSİTESİ', 1, 1),\n" +
                "('DİCLE ÜNİVERSİTESİ', 21, 1),\n" +
                "('DOĞU AKDENİZ ÜNİVERSİTESİ', 82, 1),\n" +
                "('DOĞUŞ ÜNİVERSİTESİ', 34, 1),\n" +
                "('DOKUZ EYLÜL ÜNİVERSİTESİ', 35, 1),\n" +
                "('DUMLUPINAR ÜNİVERSİTESİ', 43, 1),\n" +
                "('DÜZCE ÜNİVERSİTESİ', 81, 1),\n" +
                "('EGE ÜNİVERSİTESİ', 35, 1),\n" +
                "('ERCİYES ÜNİVERSİTESİ', 38, 1),\n" +
                "('ERZİNCAN ÜNİVERSİTESİ', 24, 1),\n" +
                "('ERZURUM TEKNİK ÜNİVERSİTESİ', 25, 1),\n" +
                "('ESKİŞEHİR OSMANGAZİ ÜNİVERSİTESİ', 26, 1),\n" +
                "('FARUK SARAÇ TASARIM MESLEK YÜKSEKOKULU', 16, 1),\n" +
                "('FATİH SULTAN MEHMET VAKIF ÜNİVERSİTESİ', 34, 1),\n" +
                "('FIRAT ÜNİVERSİTESİ', 23, 1),\n" +
                "('GALATASARAY ÜNİVERSİTESİ', 34, 1),\n" +
                "('GAZİ ÜNİVERSİTESİ', 6, 1),\n" +
                "('GAZİANTEP ÜNİVERSİTESİ', 27, 1),\n" +
                "('GAZİOSMANPAŞA ÜNİVERSİTESİ', 60, 1),\n" +
                "('GEBZE TEKNİK ÜNİVERSİTESİ', 41, 1),\n" +
                "('GİRESUN ÜNİVERSİTESİ', 28, 1),\n" +
                "('GİRNE AMERİKAN ÜNİVERSİTESİ', 82, 1),\n" +
                "('GİRNE ÜNİVERSİTESİ', 82, 1),\n" +
                "('GÜMÜŞHANE ÜNİVERSİTESİ', 29, 1),\n" +
                "('HACETTEPE ÜNİVERSİTESİ', 6, 1),\n" +
                "('HAKKARİ ÜNİVERSİTESİ', 30, 1),\n" +
                "('HALİÇ ÜNİVERSİTESİ', 34, 1),\n" +
                "('HARRAN ÜNİVERSİTESİ', 63, 1),\n" +
                "('HASAN KALYONCU ÜNİVERSİTESİ', 27, 1),\n" +
                "('HİTİT ÜNİVERSİTESİ', 19, 1),\n" +
                "('IĞDIR ÜNİVERSİTESİ', 76, 1),\n" +
                "('IŞIK ÜNİVERSİTESİ', 34, 1),\n" +
                "('İBN HALDUN ÜNİVERSİTESİ', 34, 1),\n" +
                "('İHSAN DOĞRAMACI BİLKENT ÜNİVERSİTESİ', 6, 1),\n" +
                "('İNÖNÜ ÜNİVERSİTESİ', 44, 1),\n" +
                "('İSKENDERUN TEKNİK ÜNİVERSİTESİ', 31, 1),\n" +
                "('İSTANBUL 29 MAYIS ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL AREL ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL AYDIN ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL AYVANSARAY ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL BİLGİ ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL ESENYURT ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL GEDİK ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL GELİŞİM ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL KAVRAM MESLEK YÜKSEKOKULU', 34, 1),\n" +
                "('İSTANBUL KENT ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL KÜLTÜR ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL MEDENİYET ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL MEDİPOL ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL RUMELİ ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL SABAHATTİN ZAİM ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL ŞEHİR ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL ŞİŞLİ MESLEK YÜKSEKOKULU', 34, 1),\n" +
                "('İSTANBUL TEKNİK ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL TİCARET ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTANBUL YENİ YÜZYIL ÜNİVERSİTESİ', 34, 1),\n" +
                "('İSTİNYE ÜNİVERSİTESİ', 34, 1),\n" +
                "('İZMİR DEMOKRASİ ÜNİVERSİTESİ', 35, 1),\n" +
                "('İZMİR EKONOMİ ÜNİVERSİTESİ', 35, 1),\n" +
                "('İZMİR KATİP ÇELEBİ ÜNİVERSİTESİ', 35, 1),\n" +
                "('İZMİR YÜKSEK TEKNOLOJİ ENSTİTÜSÜ', 35, 1),\n" +
                "('KADİR HAS ÜNİVERSİTESİ', 34, 1),\n" +
                "('KAFKAS ÜNİVERSİTESİ', 36, 1),\n" +
                "('KAHRAMANMARAŞ SÜTÇÜ İMAM ÜNİVERSİTESİ', 46, 1),\n" +
                "('KAPADOKYA ÜNİVERSİTESİ', 50, 1),\n" +
                "('KARABÜK ÜNİVERSİTESİ', 78, 1),\n" +
                "('KARADENİZ TEKNİK ÜNİVERSİTESİ', 61, 1),\n" +
                "('KARAMANOĞLU MEHMETBEY ÜNİVERSİTESİ', 70, 1),\n" +
                "('KASTAMONU ÜNİVERSİTESİ', 37, 1),\n" +
                "('KIBRIS AMERİKAN ÜNİVERSİTESİ', 82, 1),\n" +
                "('KIBRIS İLİM ÜNİVERSİTESİ', 82, 1),\n" +
                "('KIBRIS SOSYAL BİLİMLER ÜNİVERSİTESİ', 82, 1),\n" +
                "('KIRIKKALE ÜNİVERSİTESİ', 71, 1),\n" +
                "('KIRKLARELİ ÜNİVERSİTESİ', 39, 1),\n" +
                "('KİLİS 7 ARALIK ÜNİVERSİTESİ', 79, 1),\n" +
                "('KOCAELİ ÜNİVERSİTESİ', 41, 1),\n" +
                "('KOÇ ÜNİVERSİTESİ', 34, 1),\n" +
                "('KONYA GIDA VE TARIM ÜNİVERSİTESİ', 42, 1),\n" +
                "('KTO KARATAY ÜNİVERSİTESİ', 42, 1),\n" +
                "('LEFKE AVRUPA ÜNİVERSİTESİ', 82, 1),\n" +
                "('MALTEPE ÜNİVERSİTESİ', 34, 1),\n" +
                "('MANİSA CELAL BAYAR ÜNİVERSİTESİ', 45, 1),\n" +
                "('MARDİN ARTUKLU ÜNİVERSİTESİ', 47, 1),\n" +
                "('MARMARA ÜNİVERSİTESİ', 34, 1),\n" +
                "('MEF ÜNİVERSİTESİ', 34, 1),\n" +
                "('MEHMET AKİF ERSOY ÜNİVERSİTESİ', 15, 1),\n" +
                "('MERSİN ÜNİVERSİTESİ', 33, 1),\n" +
                "('MİLLİ SAVUNMA ÜNİVERSİTESİ', 34, 1),\n" +
                "('MİMAR SİNAN GÜZEL SANATLAR ÜNİVERSİTESİ', 34, 1),\n" +
                "('MUĞLA SITKI KOÇMAN ÜNİVERSİTESİ', 48, 1),\n" +
                "('MUNZUR ÜNİVERSİTESİ', 62, 1),\n" +
                "('MUSTAFA KEMAL ÜNİVERSİTESİ', 31, 1),\n" +
                "('MUŞ ALPARSLAN ÜNİVERSİTESİ', 49, 1),\n" +
                "('NAMIK KEMAL ÜNİVERSİTESİ', 59, 1),\n" +
                "('NECMETTİN ERBAKAN ÜNİVERSİTESİ', 42, 1),\n" +
                "('NEVŞEHİR HACI BEKTAŞ VELİ ÜNİVERSİTESİ', 50, 1),\n" +
                "('NİĞDE ÖMER HALİSDEMİR ÜNİVERSİTESİ', 51, 1),\n" +
                "('NİŞANTAŞI ÜNİVERSİTESİ', 34, 1),\n" +
                "('NUH NACİ YAZGAN ÜNİVERSİTESİ', 38, 1),\n" +
                "('OKAN ÜNİVERSİTESİ', 34, 1),\n" +
                "('ONDOKUZ MAYIS ÜNİVERSİTESİ', 55, 1),\n" +
                "('ORDU ÜNİVERSİTESİ', 52, 1),\n" +
                "('ORTA DOĞU TEKNİK ÜNİVERSİTESİ', 6, 1),\n" +
                "('OSMANİYE KORKUT ATA ÜNİVERSİTESİ', 80, 1),\n" +
                "('ÖZYEĞİN ÜNİVERSİTESİ', 34, 1),\n" +
                "('PAMUKKALE ÜNİVERSİTESİ', 20, 1),\n" +
                "('PİRİ REİS ÜNİVERSİTESİ', 34, 1),\n" +
                "('RECEP TAYYİP ERDOĞAN ÜNİVERSİTESİ', 53, 1),\n" +
                "('SABANCI ÜNİVERSİTESİ', 34, 1),\n" +
                "('SAĞLIK BİLİMLERİ ÜNİVERSİTESİ', 34, 1),\n" +
                "('SAKARYA ÜNİVERSİTESİ', 54, 1),\n" +
                "('SANKO ÜNİVERSİTESİ', 27, 1),\n" +
                "('SELÇUK ÜNİVERSİTESİ', 42, 1),\n" +
                "('SİİRT ÜNİVERSİTESİ', 56, 1),\n" +
                "('SİNOP ÜNİVERSİTESİ', 57, 1),\n" +
                "('SÜLEYMAN DEMİREL ÜNİVERSİTESİ', 32, 1),\n" +
                "('ŞIRNAK ÜNİVERSİTESİ', 73, 1),\n" +
                "('TED ÜNİVERSİTESİ', 6, 1),\n" +
                "('TOBB EKONOMİ VE TEKNOLOJİ ÜNİVERSİTESİ', 6, 1),\n" +
                "('TOROS ÜNİVERSİTESİ', 33, 1),\n" +
                "('TRAKYA ÜNİVERSİTESİ', 22, 1),\n" +
                "('TÜRK HAVA KURUMU ÜNİVERSİTESİ', 6, 1),\n" +
                "('TÜRK-ALMAN ÜNİVERSİTESİ', 34, 1),\n" +
                "('UFUK ÜNİVERSİTESİ', 6, 1),\n" +
                "('ULUDAĞ ÜNİVERSİTESİ', 16, 1),\n" +
                "('ULUSLAR ARASI KIBRIS ÜNİVERSİTESİ', 82, 1),\n" +
                "('UŞAK ÜNİVERSİTESİ', 64, 1),\n" +
                "('ÜSKÜDAR ÜNİVERSİTESİ', 34, 1),\n" +
                "('YAKINDOĞU ÜNİVERSİTESİ', 82, 1),\n" +
                "('YALOVA ÜNİVERSİTESİ', 77, 1),\n" +
                "('YAŞAR ÜNİVERSİTESİ', 35, 1),\n" +
                "('YEDİTEPE ÜNİVERSİTESİ', 34, 1),\n" +
                "('YILDIZ TEKNİK ÜNİVERSİTESİ', 34, 1),\n" +
                "('YÜKSEK İHTİSAS ÜNİVERSİTESİ', 6, 1),\n" +
                "('YÜZÜNCÜ YIL ÜNİVERSİTESİ', 65, 1),\n" +
                "('İSTANBUL BİLİM ÜNİVERSİTESİ', 34, 1);";
        String regex = "([^a-zA-Z']+)'*\\1*";
        String[] split = line.split(regex);
        System.out.println(Arrays.asList(split));
    }
}
