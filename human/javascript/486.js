const valid_until = new Date(Date.now() + 3600000); // expires in 1 hour
const admin_client = {
  generateSecuredApiKey: (key, options) => {
    return `${key}_${options.validUntil.getTime()}`;
  }
};
const search_client = {
  generateSecuredApiKey: (key, options) => {
    return `${key}_${options.validUntil.getTime()}`;
  }
};

var from_admin_api_key = admin_client.generateSecuredApiKey('ADMIN_KEY', {validUntil: valid_until});
var from_search_api_key = search_client.generateSecuredApiKey('ONLY_SEARCH_KEY', {validUntil: valid_until});

console.log(from_admin_api_key);
console.log(from_search_api_key);