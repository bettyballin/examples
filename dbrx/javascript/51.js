// On the server only
Meteor.publish('mycollection', function () {
  if (Roles.userIsInRole(this.userId, ['view-all', 'default-group'])) {
    // If user is in view-all role return all documents
    return MyCollection.find();
  } else {
    // Otherwise restrict to owned documents
    const selector = { userId: this.userId };
    return MyCollection.find(selector);
  }
});