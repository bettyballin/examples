import win32security
import ntsecuritycon as con
import getpass

usb_drive = r'F:\\'

# Get current security descriptor and DACL for the USB drive.
sd = win32security.GetFileSecurity(usb_drive, win32security.DACL_SECURITY_INFORMATION)
dacl = sd.GetSecurityDescriptorDacl()

# Remove all existing ACEs from dacl
ace_count = dacl.GetAceCount()
for i in range(0, ace_count):
    dacl.DeleteAce(0)

# Add a new read-only access allowed Ace for the current user.
user, domain, type = win32security.LookupAccountName("", getpass.getuser())
dacl.AddAccessAllowedAceEx(win32security.ACL_REVISION_DS, con.GENERIC_READ | con.FILE_GENERIC_READ, user)

# Set updated DACL back to security descriptor and apply it on the USB drive.
sd.SetSecurityDescriptorDacl(1, dacl, 0)
win32security.SetFileSecurity(usb_drive, win32security.DACL_SECURITY_INFORMATION, sd)