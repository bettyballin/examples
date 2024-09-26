var paymentRequest = new window.PaymentRequest([
  {
    supportedMethods: ['basic-card'],
    data: {
      supportedNetworks: ['visa', 'mastercard'],
      supportedTypes: ['credit', 'debit']
    }
  }
], {
  total: {
    label: 'Total',
    amount: {
      currency: 'USD',
      currencySystem: 'urn:iso:std:iso:4217',
      value: 10.00
    }
  }
}, 'https://a95b214e.ngrok.io/myUrlHere');