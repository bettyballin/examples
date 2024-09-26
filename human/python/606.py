import discord
from discord.ext import commands

client = commands.Bot(command_prefix='!')

@client.event
async def on_guild_channel_delete(channel):
    entry = await channel.guild.audit_logs(action=discord.AuditLogAction.channel_delete, limit=1).get()
    user = client.get_user(int(ID))
    await user.send(
        "User {} deleted channel {} at time {}".format(entry.user.name, channel.name, entry.created_at)
    )

client.run('YOUR_BOT_TOKEN')