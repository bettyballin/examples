// This JavaScript code simulates the given SQL code.
// It assumes that the data is stored in a JavaScript object called 'Fruits_DB'.

const Fruits_DB = {
  Fruits_Schema: {
    Fruits: [
      { name: 'Apple', country: 'USA' },
      { name: 'Banana', country: 'INDIA' },
      { name: 'Cherry', country: 'USA' },
      { name: 'Date', country: 'INDIA' }
    ]
  }
};

function CURRENT_ROLE() {
  // This function returns the current role.
  // For demonstration purposes, it is hardcoded here.
  return 'REGION1_ROLE'; // or 'REGION2_ROLE'
}

function GRANT_SELECT_ON_REGIONAL_VIEW(role) {
  // This function grants select access on REGIONAL_VIEW to the given role.
  // For demonstration purposes, it is a no-op here.
}

function REGIONAL_VIEW() {
  const country = CURRENT_ROLE() === 'REGION1_ROLE' ? 'USA' : 'INDIA';
  const result = Fruits_DB.Fruits_Schema.Fruits.filter(fruit => fruit.country === country);
  return result;
}

// Grant access to REGIONAL_VIEW to REGIONAL ROLES
GRANT_SELECT_ON_REGIONAL_VIEW('REGION1_ROLE');
GRANT_SELECT_ON_REGIONAL_VIEW('REGION2_ROLE');

// Test REGIONAL_VIEW
console.log(REGIONAL_VIEW());