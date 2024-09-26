import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Strategy> strategies = new HashMap<>();
        strategies.put("GetByOwner", new GetByOwnerStrategy());
        strategies.put("SomeOther", new SomeOtherStrategy());

        MethodSecurityAccessDecisionManager decisionManager = new MethodSecurityAccessDecisionManager(strategies);

        // Test the decision manager
        decisionManager.executeStrategy("GetByOwner");
        decisionManager.executeStrategy("SomeOther");
    }
}

interface Strategy {
    void execute();
}

class GetByOwnerStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing GetByOwnerStrategy");
    }
}

class SomeOtherStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing SomeOtherStrategy");
    }
}

class MethodSecurityAccessDecisionManager {
    private final Map<String, Strategy> strategyMap;

    public MethodSecurityAccessDecisionManager(Map<String, Strategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public void executeStrategy(String key) {
        Strategy strategy = strategyMap.get(key);
        if (strategy != null) {
            strategy.execute();
        } else {
            throw new IllegalArgumentException("No strategy found for key: " + key);
        }
    }
}