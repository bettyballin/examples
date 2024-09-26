public class Temp2546 {
    public static void main(String[] args) {
        String str = "dfdf*Hwwqqw*efgftfg*ldsdsd*lwewwe*o eerrr*mwqqwq*ujk*mjfrem*mert*yfg";
        String decrypt = str.replaceAll("\\w*\\*(\\w)\\w*", "$1");
        System.out.println(decrypt);
    }
}