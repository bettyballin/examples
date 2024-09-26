const admin = require('firebase-admin');
admin.initializeApp();

async function updateStorageRules() {
  const rulesString = `
    service cloud.firestore {
      match /databases/{database}/documents {
        // Your custom rules here.
      }
    }`;

  try {
    await admin.securityRules().releaseFirestoreRulesetFromSource(rulesString);
    
    console.log('Successfully updated Firestore security rules.');
  } catch (error) {
    console.error(`Error updating Firestore security rules: ${error}`);
  }
}

updateStorageRules();