import asyncio
from asyncua import Server, CustomUserManager

async def main():
    user_manager = CustomUserManager()
    server = Server(user_manager=user_manager)
    await server.init()
    server.set_endpoint("opc.tcp://localhost:4840/freeopcua/server/")
    await server.start()

asyncio.run(main())