import win32security
import ntsecuritycon as con
import os
import getpass

file_name = r"F:\\path\\to\\your\\usb\\"

try:
    sd = win32security.GetFileSecurity(
        file_name,
        win32security.DACL_SECURITY_INFORMATION
    )

except Exception as e:
    print("Error getting security descriptor:", str(e))

else:
    dacl = sd.GetSecurityDescriptorDacl()

    ace_count = dacl.GetAceCount()

    for i in range(0, ace_count):
        try:
            dacl.DeleteAce(0)

        except Exception as e:
            print("Error deleting ACE:", str(e))

    # Get currently logged-in user
    username = getpass.getuser()

    domain, userx = win32security.LookupAccountName(None, username)

    try:
        dacl.AddAccessAllowedAceEx(
            con.ACL_REVISION,
            0x1 | 0x8,
            1179785,
            userx
        )

    except Exception as e:
        print("Error adding ACE:", str(e))