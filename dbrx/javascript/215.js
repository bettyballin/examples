database.ref(`notes/${noteId}`).once('value', (dataSnapshot) => {
    const noteData = dataSnapshot.val();
    // ...
}, (error) => {
    console.warn(error);
}).catch((err) => {
    console.error(err);
});