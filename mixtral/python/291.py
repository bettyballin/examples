import discord
from discord.ext import commands
from cryptography.fernet import Fernet

bot = commands.Bot(command_prefix='!')

@bot.command()
async def encrypt(ctx):
    user = ctx.author
    await user.send("Please enter the message to encrypt.")

    def message_check(m):
        return m.author == ctx.author and m.channel == ctx.author.dm_channel

    response = await bot.wait_for('message', check=message_check)

    # Save key for later use
    fernetKey = Fernet.generate_key()

    encodedMessage = response.content.encode('utf-8')

    cipherSuite = Fernet(fernetKey)

    encryptedData = cipherSuite.encrypt(encodedMessage)

    await ctx.author.send("This is your encrypted message:")
    await ctx.author.send(encryptedData.decode())

    # Send the key securely
    await user.send("Here's your decryption key, keep it safe!")
    await user.send(fernetKey.decode())

    print(encryptedData)

bot.run('YOUR_BOT_TOKEN')