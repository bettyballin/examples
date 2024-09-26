public class Main32 {
    public static void main(String[] args) {
        Person p = new Person("John");
        String name = p.getName();
        int nSplit = name.length() / 3;
        String nFirstCut = name.substring(0, nSplit);
        String nSecondCut = name.substring(nSplit, 2 * nSplit);
        String nThirdCut = name.substring(2 * nSplit);

        char obcChar1 = getRandomCharacter();
        char obcChar2 = getRandomCharacter();
        char obcChar3 = getRandomCharacter();

        String nObcName = nSecondCut + obcChar1 + nFirstCut + obcChar2 + nThirdCut + obcChar3;
        System.out.println(nObcName);
    }

    private static char getRandomCharacter() {
        return (char) ('a' + Math.random() * ('z' - 'a' + 1));
    }

    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}