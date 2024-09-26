
// Assuming the URL is "www.example.com?VariableId1=Value1&VariableId2=Value2"

// Access the URL parameters
const queryString = window.location.search;

// The queryString would be "?VariableId1=Value1&VariableId2=Value2"
const urlParams = new URLSearchParams(queryString);

// Get specific variables
const variableId1 = urlParams.get('VariableId1');
const variableId2 = urlParams.get('VariableId2');

