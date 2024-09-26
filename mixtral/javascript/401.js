const collectionRef = collection(db, `users/${user?.uid}/kids`);
const data = await getDocs(collectionRef);
setKids(data.docs.map((doc) => ({ ...doc.data(), id: doc.id })));