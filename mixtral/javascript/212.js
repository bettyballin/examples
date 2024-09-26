exports.updateUserAccess = functions.firestore
  .document('Users/{userId}')
  .onUpdate((change, context) => {
    const newValue = change.after.data();

    // Check if the 'accessRoles' field has been updated
    if (newValue && Array.isArray(newValue['accessRoles'])) {
      return admin
        .auth()
        .setCustomUserClaims(context.params.userId, { access: newValue['accessRoles'] })
        .then(() => console.log(`Updated custom claims for user ${context.params.userId}`));
    }

    // If the 'accessRoles' field hasn't been updated or is not an array
    return Promise.resolve();
  });