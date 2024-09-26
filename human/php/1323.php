<?php
class Cart {
    public $productId;
    public $userId;
    public $actualPrice;
    public $price;

    public function save() {
        // Your database logic here
        echo "Cart saved successfully!";
    }
}

class Request {
    public $productId;
    public $price;
}

class User {
    public $id;
}

class Product {
    public $actualPrice;
}

// Initialize objects
$request = new Request;
$request->productId = 1;
$request->price = 10.99;

$user = new User;
$user->id = 1;

$product = new Product;
$product->actualPrice = 9.99;

// Your code here
$cart = new Cart;
$cart->productId = $request->productId;
$cart->userId = $user->id;
$cart->actualPrice = $product->actualPrice;
$cart->price = $request->price;
$cart->save();
?>