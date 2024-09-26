Here is the executable PHP code:


<?php

// Include required libraries
require 'vendor/autoload.php';

use PayPal\Rest\ApiContext;
use PayPal\Auth\OAuthTokenCredential;
use PayPal\Api\Payer;
use PayPal\Api\Amount;
use PayPal\Api\Transaction;
use PayPal\Api\RedirectUrls;
use PayPal\Api\Payment;
use PayPal\Exception\PPConnectionException;

$clientId = 'YOUR_CLIENT_ID';
$clientSecret = 'YOUR_CLIENT_SECRET';

$apiContext = new ApiContext(new OAuthTokenCredential($clientId, $clientSecret));

$payer = new Payer();
$payer->setPaymentMethod("paypal");

// Retrieve the total amount from your session or temporary storage
$total_amount = $_SESSION['total_amount'];

$amount = new Amount();
$amount->setCurrency("USD")
    ->setTotal($total_amount);

$transaction = new Transaction();
$transaction->setAmount($amount)
    ->setDescription("Payment description here");

// Set up redirect URLs for success and failure cases
$redirectUrls = new RedirectUrls();
$redirectUrls->setReturnUrl("http://your-return-url.com/success")
    ->setCancelUrl("http://your-cancel-url.com/cancelled");

// Create a payment object with the above details
$payment = new Payment();
$payment->setIntent("sale")
    ->setPayer($payer)
    ->setTransactions(array($transaction))
    ->setRedirectUrls($redirectUrls);

try {
    $payment->create($apiContext);
} catch (PPConnectionException $ex) {
    echo "Error: " . $ex->getMessage();
}

// Redirect users to PayPal for payment approval
$approvalUrl = $payment->getApprovalLink();

header("Location: {$approvalUrl}");
exit;
?>