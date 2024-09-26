public class Temp1778 {
    enum State {
        UNLOCKED, LOCKED, UNINITIALIZED
    }

    enum Error {
        NO_ERROR, LOCKED, UNINITIALIZED
    }

    private static Error mError = Error.NO_ERROR;

    public static void main(String[] args) {
        Temp1778 temp = new Temp1778();
        System.out.println(temp.state());
    }

    public State state() {
        execute('t');
        switch (mError) {
            case NO_ERROR:
                return State.UNLOCKED;
            case LOCKED:
                return State.LOCKED;
            case UNINITIALIZED:
                return State.UNINITIALIZED;
            default:
                throw new AssertionError(mError);
        }
    }

    private void execute(char c) {
        // Dummy implementation just for the sake of example
        if (c == 't') {
            mError = Error.NO_ERROR;
        }
    }
}