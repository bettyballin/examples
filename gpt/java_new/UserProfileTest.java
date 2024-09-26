import org.easymock.EasyMock;
import org.junit.Test;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;
import javax.persistence.EntityManager;

public class UserProfileTest {

    @Test(expected = SecurityException.class)
    public void testGetAsObjectThrowsSecurityException() {
        // Arrange
        EntityManager mockEntityManager = EasyMock.createMock(EntityManager.class);
        FacesContext mockFacesContext = EasyMock.createMock(FacesContext.class);
        UIComponent mockUiComponent = EasyMock.createMock(UIComponent.class);
        long someLongValue = 123L;
        EasyMock.expect(mockEntityManager.find(UserProfile.class, someLongValue))
                .andThrow(new SecurityException());
        EasyMock.replay(mockEntityManager);

        // Act
        mockEntityManager.find(UserProfile.class, someLongValue);
    }
}