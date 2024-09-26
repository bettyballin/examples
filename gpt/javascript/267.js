
Object.defineProperty(window, 'hasPerms', {
  get: function() {
    // Some logic to determine if the user has permissions
    return checkUserPermissions();
  },
  set: function(value) {
    // This could be empty, or log an attempt to set the property, or anything really.
    console.warn('Attempt to set hasPerms detected');
  },
  configurable: false // This makes it harder to redefine or delete the property.
});

