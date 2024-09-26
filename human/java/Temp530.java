import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.DefaultMenuModel;

public class Temp530 {
    public static void main(String[] args) {
        // Create a menu model
        MenuModel model = new DefaultMenuModel();

        // Add management submenu
        DefaultSubMenu managementSubMenu = DefaultSubMenu.builder()
                .label("Management") // Replace with "#{msg['header.management']}"
                .build();

        // Check user role (stubbed as true for this example, replace with actual role check)
        boolean isUserInRole = true; // Replace with request.isUserInRole('INTERNO')

        if (isUserInRole) {
            // Add roles submenu
            DefaultSubMenu rolesSubMenu = DefaultSubMenu.builder()
                    .label("Roles") // Replace with "#{msg['header.roles']}"
                    .icon("ui-icon-contact")
                    .build();

            // Add new role menu item
            DefaultMenuItem newRoleItem = DefaultMenuItem.builder()
                    .value("New Role") // Replace with "#{msg['header.newRole']}"
                    .url("/pages/addRole.jsf")
                    .build();
            rolesSubMenu.getElements().add(newRoleItem);

            // Add manage roles menu item
            DefaultMenuItem manageRolesItem = DefaultMenuItem.builder()
                    .value("Manage Roles") // Replace with "#{msg['header.mngRoles']}"
                    .url("/pages/viewRole.jsf")
                    .build();
            rolesSubMenu.getElements().add(manageRolesItem);

            managementSubMenu.getElements().add(rolesSubMenu);
        }

        model.getElements().add(managementSubMenu);

        // For demonstration purposes: print the structure of the menu model
        for (var element : model.getElements()) {
            if (element instanceof DefaultSubMenu) {
                DefaultSubMenu subMenu = (DefaultSubMenu) element;
                System.out.println("Submenu: " + subMenu.getLabel());
                for (var subElement : subMenu.getElements()) {
                    if (subElement instanceof DefaultSubMenu) {
                        DefaultSubMenu innerSubMenu = (DefaultSubMenu) subElement;
                        System.out.println("  Inner Submenu: " + innerSubMenu.getLabel());
                        for (var innerElement : innerSubMenu.getElements()) {
                            if (innerElement instanceof DefaultMenuItem) {
                                DefaultMenuItem item = (DefaultMenuItem) innerElement;
                                System.out.println("    MenuItem: " + item.getValue() + " (URL: " + item.getUrl() + ")");
                            }
                        }
                    }
                }
            }
        }
    }
}