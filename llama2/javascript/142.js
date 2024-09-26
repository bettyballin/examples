const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp();

const firestore = admin.firestore();
const auth = admin.auth();

exports.uploadImage = functions.storage.object().onFinalize(async (object) => {
  // Get the uploaded file's name and metadata
  const filename = object.name;
  const metadatas = object.metadata;

  // Set the appropriate permissions for the uploaded file
  const permission = await setPermission(filename, metadatas);

  // Return the updated metadata
  return {
    metadata: {
      ...metadatas,
      permission
    }
  };
});

async function setPermission(filename, metadatas) {
  // Check if the user is authenticated
  const user = await auth.getUser(metadatas.uid);

  // If the user is not authenticated return a denied permission
  if (!user) {
    return 'denied';
  }

  // Get the user's uid
  const uid = user.uid;

  // Create a permission for the uploaded file
  const permission = `users/${uid}/permission/${filename}`;

  // Set the permission on the file
  await firestore.collection('permissions').doc(permission).set({
    data: true
  });

  return permission;
}

async function getAuth() {
  return await auth.getUser();
}