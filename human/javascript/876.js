function ROLES_REGIONS(CURRENT_ROLE, COUNTRY) {
  let result = [];
  let count = 0;

  function processRow(row) {
    let role = row.CURRENT_ROLE;

    if (role === 'GLOBAL_ROLE') {
      result.push({ COUNTRY: row.COUNTRY });
    } else if (role === 'REGION1_ROLE') {
      while (count === 0) {
        result.push({ COUNTRY: 'USA' });
        result.push({ COUNTRY: 'AUSTRALIA' });
        count = 1;
      }
    } else if (role === 'REGION2_ROLE') {
      while (count === 0) {
        result.push({ COUNTRY: 'INDIA' });
        result.push({ COUNTRY: 'ITALY' });
        count = 1;
      }
    }
  }

  function initialize() {
    count = 0;
  }

  initialize();
  processRow({ CURRENT_ROLE: CURRENT_ROLE, COUNTRY: COUNTRY });
  return result;
}

// Test the function
console.log(ROLES_REGIONS('GLOBAL_ROLE', 'SPAIN'));
console.log(ROLES_REGIONS('REGION1_ROLE', ''));
console.log(ROLES_REGIONS('REGION2_ROLE', ''));