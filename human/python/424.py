import discord
from discord.ext import commands
from cryptography.fernet import Fernet

bot = commands.Bot(command_prefix='!')

@bot.command()
async def encrypt(ctx):
    user = ctx.author
    await user.send("Please enter the message to encrypt.")
    def check(msg):
        return msg.author == ctx.author and msg.channel == ctx.author.dm_channel
    response = await bot.wait_for('message', check=check)
    message = response.content
    encoded = message.encode()
    key = Fernet.generate_key()
    f = Fernet(key)
    encrypted = f.encrypt(encoded)
    await ctx.author.send("This is your encrypted message:")
    await ctx.author.send(encrypted.decode())
    await ctx.author.send("This is the key to decrypt the message:")
    await ctx.author.send(key.decode())

@bot.command()
async def decrypt(ctx):
    user = ctx.author
    await user.send("Please enter the encrypted message.")
    def check(msg):
        return msg.author == ctx.author and msg.channel == ctx.author.dm_channel
    response = await bot.wait_for('message', check=check)
    encrypted = response.content.encode()
    await user.send("Please enter the decryption key:")
    response = await bot.wait_for('message', check=check)
    key = response.content.encode()
    f = Fernet(key)
    decrypted = f.decrypt(encrypted)
    decoded = decrypted.decode()
    await user.send(decoded)
    print(decoded)

bot.run('YOUR_BOT_TOKEN')