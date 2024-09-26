
const algoliasearch = require('algoliasearch');

// Initialize the client with your Algolia application id (APP) and Admin API key (ADMIN_KEY)
const client = algoliasearch('APP', 'ADMIN_KEY');

// Define the parameters for the secured API key
const params = {
  // You can add any search parameters here, for example:
  // filters: 'attribute:value',
  validUntil: Math.floor(Date.now() / 1000) + 3600, // 1 hour validity
};

// Generate the secured API key
const securedApiKey = client.generateSecuredApiKey('ADMIN_KEY', params);

