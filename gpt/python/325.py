
@bot.command()
async def encrypt(ctx):
    user = ctx.author
    await user.send("Please enter the message to encrypt.")
    response = await bot.wait_for('message', check=message_check(channel=ctx.author.dm_channel))
    message = response.content
    encoded = message.encode()
    key = Fernet.generate_key()
    f = Fernet(key)
    encrypted = f.encrypt(encoded)
    await ctx.author.send("This is your encrypted message:")
    await ctx.author.send(base64.urlsafe_b64
