import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public class Temp2955 {
    public static void main(String[] args) {
        // Main method implementation if needed
    }
}

@Service
@Qualifier("service1")
interface SuperCoolService extends CoolService {
    Object resolve(int attribute);
}

@Service
@Qualifier("service2")
interface UltraCoolService extends CoolService {
    Object resolve(int attribute);
}

interface CoolService {
    Object resolve(int attribute);
}