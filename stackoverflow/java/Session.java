import java.util.List;

public interface SessionRepository {
    List<Session> getAllSessions(Object principal, boolean includeExpiredSessions);
}

public class Session {}