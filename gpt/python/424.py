
class MyCog(commands.Cog):
    def __init__(self, bot):
        self.bot = bot

    @commands.Cog.listener()
    async def on_guild_channel_delete(self, channel):
        entry = await channel.guild.audit_logs(action=discord.AuditLogAction.channel_delete, limit=1).get()
        user = self.bot.get_user(int(ID))
        await user.send(
            "User {} deleted channel {} at time {}".format(entry.user.name, channel.name, entry.created_at)
        )

