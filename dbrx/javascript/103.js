const algoliasearch = require('algoliasearch');

const appId = 'YOUR_APP_ID';
const apiKey = 'YOUR_API_KEY';
const adminIndexName = 'YOUR_ADMIN_INDEX_NAME';
const searchIndexName = 'YOUR_SEARCH_INDEX_NAME';

const adminClient = algoliasearch(appId, apiKey);
const searchClient = algoliasearch(appId, apiKey);

const validUntil = Math.floor(Date.now() / 1000) + 3600;

const fromAdminApiKey = adminClient.generateSecuredApiKey(`APP {filters: 'userToken:from_admin', validUntil: ${validUntil}}`);
const fromSearchApiKey = searchClient.generateSecuredApiKey(`APP {filters: 'userToken:from_search', validUntil: ${validUntil}}`);

const subAdminClient = algoliasearch(appId, fromAdminApiKey);
const subSearchClient = algoliasearch(appId, fromSearchApiKey);

const subAdminIndex = subAdminClient.initIndex(adminIndexName);
const subSearchIndex = subSearchClient.initIndex(searchIndexName);

subAdminIndex.search('dav', function(err, content) {
  console.log(err, content);
});

subSearchIndex.search('dav', function(err, content) {
  console.log(err, content);
});