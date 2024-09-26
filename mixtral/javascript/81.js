MyCollection.allow({
  insert: function(userId) {
    return Roles.userIsInRole(userId, 'admin');
  },

  update: function(userId, doc) {
    if (Roles.userIsInRole(userId, 'admin')) {
      return true;
    } else {
      return userId === doc.ownerId;
    }
  }
});