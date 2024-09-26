const timeNow = useMemo(() => new Date().toUTCString(), []);

const query = query(
  postRef,
  where("tags", "array-contains-any", ["Event"]),
  where("publishDate", "<=", Timestamp.fromDate(new Date(timeNow))),
  orderBy("publishDate", "desc"),
  limit(4)
);