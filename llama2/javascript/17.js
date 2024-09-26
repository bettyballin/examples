const responseFromServer = '{"variables":[{"name":"var1","value":"value1"},{"name":"var2","value":"value2"}]}';

const response = JSON.parse(responseFromServer);
const variables = response.variables;

console.log(variables[0].name); 
console.log(variables[0].value);