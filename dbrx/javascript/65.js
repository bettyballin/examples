const user = Meteor.user();
if (user) {
  const { _id } = user;
  // Only allow updating 'name' and 'surname'
  Meteor.users.update(
    { _id },
    { $set: { 'profile.name': name, 'profile.surname': surname } }
  );
}