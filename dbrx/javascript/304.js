import { useMemo } from 'react';
import { Timestamp, query, where, orderBy, limit } from 'firebase/firestore';

const postRef = // assuming you have a reference to your Firestore collection

const timeNow = useMemo(() => Timestamp.now(), []);

const query = query(
  postRef,
  where("tags", "array-contains-any", ["Event"]),
  where("publishDate", "<=", timeNow),
  orderBy("publishDate", "desc"),
  limit(4)
);