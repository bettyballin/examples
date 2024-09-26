import { db } from './firebase';
import { query, collection } from 'firebase/firestore';

const promotorsRef = collection(db, `users/${auth.currentUser?.uid}/promotors`);
const q = query(promotorsRef);

// or in one line
const q = query(collection(db, `users/${auth.currentUser?.uid}/promotors`));