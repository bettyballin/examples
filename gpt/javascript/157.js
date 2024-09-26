
Meteor.publish('myDocuments', function () {
  if (!this.userId) {
    return this.ready();
  }

  if (Roles.userIsInRole(this.userId, 'admin')) {
    // Admins get access to all documents
    return MyCollection.find({});
  } else {
    // Non-admins only get their own documents
    return MyCollection.find({ owner: this.userId });
  }
});

