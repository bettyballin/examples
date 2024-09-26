
// dataProvider.js
import fetchWrapper from './fetchWrapper';

const dataProvider = {
  getList: (resource, params) => {
    // Use fetchWrapper instead of fetch
    return fetchWrapper(`your
