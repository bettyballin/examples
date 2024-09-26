
Meteor.publish('lists', function() {
    var user = Meteor.users.findOne(this.userId);
    // Check if the user exists and has a group set
    if (user && user.profile && user.profile.group) {
        // Return the cursor for lists that belong to the user's group
        return Lists.find({ group: user.profile.group });
    } else {
        // Return no data if the group is undefined or the user doesn't exist
        return this
