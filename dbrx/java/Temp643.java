public class Temp643 {
    public static void main(String[] args) {
        ISampleService sampleService = new SampleServiceImpl();
        System.out.println(sampleService.doIt());
    }

    public interface ISampleService {
        boolean doIt();
    }

    public static class SampleServiceImpl implements ISampleService {
        @Override
        public boolean doIt() {
            return true;
        }
    }
}