Meteor.publish('myCollection', function(docId) {
  const doc = MyCollection.findOne({ _id: docId });

  if (!Roles.userIsInRole(this.userId, ['admin']) && this.userId !== doc?.ownerId)
    return [];

  else
    // Send the document to client
    return MyCollection.find();
});