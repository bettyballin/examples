import discord
from discord.ext import commands

class MyClient(commands.Bot):
    async def on_guild_channel_delete(self, channel):
        # rest of your code
        print(f"Channel {channel.name} deleted")

client = MyClient(command_prefix='!')

client.run('YOUR_BOT_TOKEN')