import javax.persistence.EntityManager;

public class YourClassName {
    private EntityManager entityManager;

    public YourClassName(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void refreshUserAccount(Object userAccountBean) {
        entityManager.refresh(userAccountBean);
    }

    // Other methods...
}