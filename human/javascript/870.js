const resource = { data: { fieldId: '100000000000000001' } };

if (parseInt(resource.data.fieldId) > 100000000000000000) {
  console.log('Allowed');
} else {
  console.log('Not Allowed');
}