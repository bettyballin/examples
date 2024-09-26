import discord
from discord.ext import commands

bot = commands.Bot(command_prefix='!')

@bot.event
async def on_guild_channel_delete(channel):
    channel = channel

bot.run('YOUR_BOT_TOKEN_HERE')