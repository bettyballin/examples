from asyncua import Server
from asyncua.common.user_token_policies104 import UserNameIdentityToken
import asyncio

async def main():
    server = Server()

    await server.init()
    server.set_endpoint("opc.tcp://0.0.0.0:4840/freeopcua/server/")

    # create users
    user_admin = await server.create_new_user("Admin", "password")

    policy_id = "Basic256Sha256"

    token1 = UserNameIdentityToken(
        policyId="Basic256Sha256",
        userName="Admin",
        password="password",
        displayName={"en-US": "Administrator"},
        rolePermissions=[],
        privileges=["Read", "Write"]
    )

    await server.add_user(token1)

    user2 = await server.create_new_user("Guest", "password")

    token2 = UserNameIdentityToken(
        policyId="Basic256Sha256",
        userName="Guest",
        password="password",
        displayName={"en-US": "Guest"},
        rolePermissions=[],
        privileges=[]
    )

    await server.add_user(token2)

    async with server:
        print("Server started. Press Ctrl+C to exit")
        await asyncio.sleep(float('inf'))

asyncio.run(main())