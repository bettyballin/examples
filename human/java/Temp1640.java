public class Temp1640 {
    public static void main(String[] args) {
        System.out.println("Executable Java code.");
        printRules();
    }

    public static void printRules() {
        System.out.println("{");
        System.out.println("   \"rules\": {");
        System.out.println("      \"notes\": {");
        System.out.println("         \"$noteId\": {");
        System.out.println("            \".read\": \"data.root().child('sharedNotes').child($noteId).child(auth.uid).exists()\"");
        System.out.println("         }");
        System.out.println("      }");
        System.out.println("   }");
        System.out.println("}");
    }
}