public class RoleDeterminator {
    private final boolean monitorStatus;

    public RoleDeterminator(boolean monitorStatus) {
        this.monitorStatus = monitorStatus;
    }

    public String determineRole() {
        return monitorStatus ? "ROLE_ADMIN" : "ROLE_USER";
    }
}