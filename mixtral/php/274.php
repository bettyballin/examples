<?php
require 'vendor/autoload.php';
use PayPal\Rest\ApiContext;
use PayPal\Auth\OAuthTokenCredential;
use PayPal\Api\Payment;
use PayPal\Api\Amount;
use PayPal\Api\ItemList;
use PayPal\Api\Item;

$clientID = 'YOUR_CLIENT_ID';
$clientSecret = 'YOUR_CLIENT_SECRET';
$total = 10.99;
$productName = 'Test Product';
$unitPrice = 10.99;

// Set up API context
$api = new ApiContext(
    new OAuthTokenCredential($clientID, $clientSecret)
);

// Create a payment
try {
  $payment = Payment::create($api, [
      "intent" => "sale",
      "payer" => ["payment_method"=>"paypal"],
      "redirect_urls" => ["return_url"=>"http://your-site.com/success", "cancel_url"=>"http://your-site.com/failure"],
      "transactions" => [[
        "amount" => [
          "total" => $total,
          "currency" => 'USD'
        ],
        "item_list" => [
          "items" => [[
            "name" => $productName,
            "price" => $unitPrice,
            "quantity" => 1
          ]]
        ]
      ]]
  ]);

  // Redirect
  header('Location: ' . $payment->getApprovalLink());
  exit;
} catch (Exception $e) {
  echo 'Error: ', $e->getMessage(), "\n";
}