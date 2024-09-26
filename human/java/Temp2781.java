public class Temp2781 {
    public static void main(String[] args) {
        System.out.println("openssl asn1parse -i -in ecpub.der -inform DER -dump");
        System.out.println("0:d=0  hl=2 l=  89 cons: SEQUENCE");
        System.out.println("2:d=1  hl=2 l=  19 cons:  SEQUENCE");
        System.out.println("4:d=2  hl=2 l=   7 prim:   OBJECT            :id-ecPublicKey");
        System.out.println("13:d=2  hl=2 l=   8 prim:   OBJECT            :prime256v1");
        System.out.println("23:d=1  hl=2 l=  66 prim:  BIT STRING");
        System.out.println("  0000 - 00 04 d0 ee 64 61 7b 90-48 a2 a9 5f b5 a3 da 67   ....da{.H.._...g");
        System.out.println("  0010 - 53 56 91 e0 cf 5b b8 85-3e 05 0c b9 e6 95 c3 8d   SV...[..>.......");
        System.out.println("  0020 - 26 ab d7 ee 47 94 38 61-1e cd 07 e6 90 0b 3d 4a   &...G.8a......=J");
        System.out.println("  0030 - 6a df c5 d5 9f f3 11 91-53 00 ff 0e 91 93 49 44   j.......S.....ID");
        System.out.println("  0040 - 4c 58");
    }
}