public interface MyCondition {
    boolean matches();
}

public class MyTrueCondition implements MyCondition {
    @Override
    public boolean matches() {
        return true;
    }
}

public class MyFalseCondition implements MyCondition {
    private final MyTrueCondition trueCondition;

    public MyFalseCondition(MyTrueCondition trueCondition) {
        this.trueCondition = trueCondition;
    }

    @Override
    public boolean matches() {
        return !trueCondition.matches();
    }
}

// Assuming Condition, ConditionContext, and AnnotatedTypeMetadata are part of the environment/framework
public class OnMyTrueCondition implements Condition {
    private final MyCondition myCondition;

    public OnMyTrueCondition(MyCondition myCondition) {
        this.myCondition = myCondition;
    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return myCondition.matches();
    }
}