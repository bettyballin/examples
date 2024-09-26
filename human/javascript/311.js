// Make sure you have the meteor and roles packages installed
// meteor add meteor
// meteor add alanning:roles

// Create a new file (e.g. posts.js) and add the following code
Posts = new Meteor.Collection('posts');

Posts.allow({
  update: function(userId, doc, fields, modifier) {
    var currentUser = Meteor.users.findOne(userId),
        isUserAdmin = Roles.userIsInRole(currentUser, 'Admin');
    if (isUserAdmin) {
      console.log("Ok the user is logged in on an admin account, lets allow it to update")
      return true;
    } else {
      console.log("Someone just try to update the document and he isn't logged in into an admin account")
      return false;
    }
  }
});