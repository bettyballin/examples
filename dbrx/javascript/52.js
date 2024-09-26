// On the client only
Template.myTemplate.helpers({
  myDocuments() {
    if (Roles.userIsInRole(Meteor.userId(), ['view-all', 'default-group'])) {
      // If user is in view-all role return all documents
      return MyCollection.find();
    } else {
      // Otherwise restrict to owned documents
      const selector = { userId: Meteor.userId() };
      return MyCollection.find(selector);
    }
  }
});