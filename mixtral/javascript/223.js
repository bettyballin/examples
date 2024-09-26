function isMemberAuthenticated(memberId) {
  // logic to check if member is authenticated
  // for demonstration purposes, memberId is considered authenticated if it's not empty
  return memberId !== '';
}

function isGymAuthenticated() {
  // logic to check if gym is authenticated
  // for demonstration purposes, gym is considered authenticated
  return true;
}

function getSubscriptionLimit() {
  let limit = 50;
  // logic to check for upgraded subscription and update limit accordingly
  // for demonstration purposes, subscription is considered upgraded
  limit += 50;
  return limit;
}

function match(memberId, query) {
  let authenticated = isMemberAuthenticated(memberId) ||
    (isGymAuthenticated() &&
     query.orderBy === 'createdAt' &&
     query.limit <= getSubscriptionLimit());

  return authenticated;
}

// usage example
let memberId = 'exampleMemberId';
let query = { orderBy: 'createdAt', limit: 50 };

let result = match(memberId, query);
console.log(result); // true or false