Meteor.publish('lists', function() {
  var user = Meteor.users.findOne(this.userId);
  if (user && user.profile && user.profile.group) {
    return Lists.find({ group: user.profile.group });
  } else {
    this.ready();
  }
});