from discord.ext import commands
from cryptography.fernet import Fernet

bot = commands.Bot(command_prefix='!')

@bot.command()
async def decrypt(ctx):
    # Get the key
    fernetKey = Fernet.generate_key().decode('utf-8')
    await ctx.send(fernetKey)

bot.run('YOUR_BOT_TOKEN')