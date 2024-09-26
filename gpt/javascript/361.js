
// *** SUBSCRIPTION */
database.ref(`access_notes/${uid}`).on('value', (myNotAccessSnaps) => {
  let subscrPromises = [];
  let collectedNotes = {};

  // Collect all categories we have access to
  myNotAccessSnaps.forEach((accessSnap) => {
    const noteId = accessSnap.key;
    subscrPromises.push(
      database.ref(`notes/${noteId}`)
      .once('value').
