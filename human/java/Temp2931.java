public class Temp2931 {
    public static void main(String[] args) {
        String[] loadList = {
            "druid-hdfs-storage",
            "druid-kafka-indexing-service",
            "druid-datasketches",
            "druid-basic-security"
        };

        for (String extension : loadList) {
            System.out.println(extension);
        }
    }
}