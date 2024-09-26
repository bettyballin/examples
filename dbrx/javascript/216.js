database.ref(`notes/${noteId}`).once('value', 
    (notSnap) => { 
        if(notSnap.exists()) {
            const notData = notSnap.val();
            // ...
        }
    }, 
    (error) => {
        console.warn(error);
    }
).catch((err) => {console.error(err);});