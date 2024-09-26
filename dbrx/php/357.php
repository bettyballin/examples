<?php

use Parsedown\Parsedown;
use HTMLPurifier\HTMLPurifier;
use HTMLPurifier_Config;

class YourController extends Controller
{
    public function store(Request $request)
    {
        // Validate the request...
        $validatedData = $request->validate([
            'content' => 'required|string',
        ]);

        $content = $request->input('content');

        // Sanitize content with HTML Purifier.
        $purifier_config = HTMLPurifier_Config::createDefault();
        $purifier = new HTMLPurifier($purifier_config);
        $sanitized_content = $purifier->purify($content);

        // Store the sanitized data in your database...
        YourModel::create([
            'content' => $sanitized_content,
        ]);

        return redirect()->back()->with('success', 'Content stored successfully!');
    }
}