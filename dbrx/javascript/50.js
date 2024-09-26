// On both client and server
const MyCollection = new Mongo.Collection('mycollection');

MyCollection.allow({
  insert(userId, doc) {
    // Only admins can create documents
    return Roles.userIsInRole(userId, 'admin');
  },
  update(userId, doc, fields, modifier) {
    // Check if the user is an admin or document owner
    const isAdmin = Roles.userIsInRole(userId, 'admin');
    const isOwner = userId === doc.userId;
    return isAdmin || isOwner;
  },
  remove(userId, doc) {
    // Only admins can delete documents
    return Roles.userIsInRole(userId, 'admin');
  }
});