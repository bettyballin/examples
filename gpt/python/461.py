
import asyncio
from asyncua import Server, ua
from asyncua.server.users import UserRole

async def main():
    # ... your existing code ...

    # Set up user manager and specify user roles
    await server.user_manager.set_user_manager(user_manager)
    server.user_manager.add_user('admin', 'adminpassword', UserRole.Admin)
    server.user_manager.add_user('user', 'userpassword', UserRole.User)
    
    # ... your existing code ...

    # Adjust permissions for user and admin roles
    # For instance, admin can write and user can only read
    await myvar.set_permissions({UserRole.Admin: ['read', 'write'], UserRole.User: ['read']})
    await mystruct.set_permissions({UserRole.Admin: ['read', 'write'], UserRole.User: ['read']})

    # ... your existing code ...

async def user_manager(isession, username, password):
    if username == 'admin' and password == 'adminpassword':
        return True
    elif username == 'user' and password
