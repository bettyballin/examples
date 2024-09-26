import win32api
import win32con
import win32security
import os

def set_permissions(path, user, permissions):
    sd = win32security.GetFileSecurity(path, win32security.DACL_SECURITY_INFORMATION)
    dacl = sd.GetSecurityDescriptorDacl()
    
    if not dacl:
        dacl = win32security.ACL()

    sid = win32security.LookupAccountName("", user)[0]
    access_mask = {
        "read": (win32con.FILE_GENERIC_READ | win32con.FILE_LIST_DIRECTORY),
        "write": (win32con.FILE_GENERIC_WRITE | win32con.FILE_ADD_FILE | win32con.FILE_APPEND_DATA),
        "full": win32con.GENERIC_ALL
    }[permissions]

    dacl.AddAccessAllowedAce(win32security.ACL_REVISION, access_mask, sid)
    
    sd.SetSecurityDescriptorDacl(1, dacl, 0)
    win32security.SetFileSecurity(path, win32security.DACL_SECURITY_INFORMATION, sd)

set_permissions("MyFolder", os.environ.get("USERNAME"), "read")