$allowedViews = [
    "Admin" => Views\Admin::class
    // ...
];

if (array_key_exists($currentPage, $allowedViews)) {
     $viewClass = $allowedViews[$currentPage];
     $content = new $viewClass();
}