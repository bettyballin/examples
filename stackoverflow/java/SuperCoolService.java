public interface SuperCoolService extends CoolService {

    Object resolve(int attribute);
}

@Service
@Qualifier("service1")
public interface UltraCoolService extends CoolService {

    Object resolve(int attribute);
}