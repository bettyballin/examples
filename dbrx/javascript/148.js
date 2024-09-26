const limit = getSubscriptionLimit(user.subscription);
const query = db.collection('members')
    .where('gymId', '==', gym.id)
    .orderBy('lastUpdatedTimestamp', 'desc')
    .limit(limit);

query.get().then((snapshot) => {
  // process the results...
});