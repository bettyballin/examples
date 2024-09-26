import * as functions from 'firebase-functions';
import { initializeApp } from 'firebase-admin/app';
const app = initializeApp();
const db = app.firestore();

export const deleteDataSets = functions.firestore.document('deletion_requests/{docId}').onCreate(async (snap, context) => {
  try {
    // Get the document data
    const docData = snap.data();

    if (!docData || !docData.setAId || !docData.subSetAId || !docData.setBId || !docData.subSetBId) {
      console.error('Invalid deletion request');
      return;
    }

    // Initialize a batch write
    const batch = db.batch();

    // Delete data-set A and its sub-sets
    const setADocRef = db.collection(`data-set-a/${context.auth.uid}/sub-set-a`).doc(docData.setAId);
    batch.delete(setADocRef);

    if (docData.subSetAId) {
      const subSetADocRef = db.collection(`data-set-a/${context.auth.uid}/sub-set-a/${docData.setAId}`).doc(docData.subSetAId);
      batch.delete(subSetADocRef);
    }

    // Delete data-set B and its sub-sets
    const setBDocRef = db.collection(`data-set-b/${context.auth.uid}/sub-set-b`).doc(docData.setBId);
    batch.delete(setBDocRef);

    if (docData.subSetBId) {
      const subSetBDocRef = db.collection(`data-set-b/${context.auth.uid}/sub-set-b/${docData.setBId}`).doc(docData.subSetBId);
      batch.delete(subSetBDocRef);
    }

    // Commit the batch
    await batch.commit();
  } catch (error) {
    console.error('Error deleting data sets:', error);
  }
});