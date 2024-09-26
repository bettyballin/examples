from asyncua import Server, ua
import asyncio

async def main():
    # Initialize the server
    server = Server()
    await server.init()

    # Set up user manager with admin and regular users
    from asyncua.security.user_manager import UserManager
    um = UserManager(server)
    um.add_user('admin', 'password')
    um.add_user('user', 'password')

    # Grant full access to the "admin" user only
    server.set_security_policy(ua.SecurityPolicy.Basic256Sha256, ua.MessageSecurityMode.SignAndEncrypt)
    admin_node_id = await um.get_user_node_id('admin')
    for node in await server.nodes.objects.get_children():
        await node.add_access_right(admin_node_id, ua.AccessLevel.CurrentRead | ua.AccessLevel.CurrentWrite)

    # Continue with your server setup
    async with server:
        print("Server started. Press Ctrl+C to exit")
        await asyncio.create_task(server.run_forever())

if __name__ == '__main__':
    asyncio.run(main())