MyCollection.deny({
  remove(userId, doc) {
    if (Roles.userIsInRole(userId, 'admin'))
      // Allow admins
      return false;
    else
      // Deny non-admins who are not the owner
      return userId !== doc?.ownerId;
  }
});