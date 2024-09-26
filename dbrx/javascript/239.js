const { t, v1 } = event.request.headers.get('Stripe-Signature').split(',').reduce((acc, x) => {
  const [k, v] = x.split('=');
  return { ...acc, [k]: v };
}, {});

// Ensure no line breaks or whitespaces in the body
const payload = JSON.stringify(event.request.body);

await verifySignature(payload, `t=${t}&v1=${v1}&tolerance=300`);