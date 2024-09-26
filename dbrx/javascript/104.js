// Assuming this is a Meteor.js code snippet
Meteor.startup(() => {
  BrowserPolicy.content.allowOriginForAll('blob:');
});