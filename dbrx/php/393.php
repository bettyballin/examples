$payment_intent = \Stripe\PaymentIntent::create([
  'amount' => $amount,
  'currency' => $currency_code,
  'confirmation_method' => 'manual',
  'confirm' => true
]);