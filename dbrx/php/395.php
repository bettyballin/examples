<?php
require 'vendor/autoload.php';

$stripe = new \Stripe\StripeClient('YOUR_STRIPE_SECRET_KEY');
$id = 'PAYMENT_INTENT_ID';

$payment_intent = $stripe->paymentIntents->retrieve($id);

if ($payment_intent->status === "succeeded") {
  // Payment succeeded!
  echo "Payment succeeded!";
} else {
  echo "Payment failed.";
}
?>