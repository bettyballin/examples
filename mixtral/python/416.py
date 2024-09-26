async def on_guild_channel_delete(self, channel):
    entry = await channel.guild.audit_logs(action=discord.AuditLogAction.channel_delete, limit=1).get()
    user = self.client.get_user(int(ID))

    if not isinstance(entry.target, discord.PartialChannel):
        return

    await user.send("User {} deleted channel {} at time {}".format(
        entry.user.name,
        entry.target.mention or "Unknown Channel",
        entry.created_at
    ))