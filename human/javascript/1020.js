// assume 'database' and 'userId' are defined variables
fetch(`/databases/${database}/documents/Devices/${userId}`)
  .then(response => response.json())
  .then(data => console.log(data.cashier_id));