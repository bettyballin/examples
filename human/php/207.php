<?php

// Define a route for adding an item to the cart
Route::get('/cart/add/{id}', function ($id) {
    // Verify prices and quantities
    $product = Product::find($id);
    if (!$product) {
        return response()->json(['error' => 'Product not found'], 404);
    }
    $cart = session()->get('cart', []);
    if (isset($cart[$id])) {
        $cart[$id]['quantity']++;
    } else {
        $cart[$id] = [
            'name' => $product->name,
            'price' => $product->price,
            'quantity' => 1,
        ];
    }
    session()->put('cart', $cart);
    return response()->json(['message' => 'Product added to cart successfully']);
});

?>