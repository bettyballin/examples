const memberId = 'someMemberId';
const resource = { data: { gym: { subscription: 'someSubscription' } } };
const request = { query: { limit: 10 } };

function isMemberAuthenticated(memberId) {
  // TO DO: implement authentication logic for member
  return true;
}

function isGymAuthenticated() {
  // TO DO: implement authentication logic for gym
  return true;
}

function getSubscriptionLimit(subscription) {
  // TO DO: implement logic to get subscription limit
  return 100;
}

const allowRead = isMemberAuthenticated(memberId) 
                  || (isGymAuthenticated() && request.query.limit <= getSubscriptionLimit(resource.data.gym.subscription));

console.log(allowRead);