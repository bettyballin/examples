public function chargeAmountFromCard($cardDetails)
{
    $paymentIntent = \Stripe\PaymentIntent::create([
        'amount' => $cardDetails['amount'] * 100,
        'currency' => $cardDetails['currency_code'],
        'description' => $cardDetails['item_name'],
        // Verify your customer exists in Stripe.
        'customer' => '<CUSTOMER-ID>',
    ]);

    return $paymentIntent;
}