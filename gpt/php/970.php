
// Install HTMLPurifier through Composer
composer require ezyang/htmlpurifier

// Use HTMLPurifier in your controller to clean the input
public function store(Request $request)
{
    $purifier = new \HTMLPurifier();

    // Get the dirty HTML from TinyMCE
    $dirtyHtml = $request->input('content');

    // Clean the HTML
    $cleanHtml = $purifier->purify($dirtyHtml);

    // Store the clean HTML in the database
    // ...
}

