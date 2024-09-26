function asJson(options = {}) {
  return Object.assign(
    super({
      include: {
        attributesToInclude: true
      }
    }),
    {
      permissions: {
        canCreate: user.canCreate(),
        canDelete: user.canDelete(),
        canUpdate: user.canUpdate()
      }
    }
  );
}