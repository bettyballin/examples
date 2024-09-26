<?php

// Initialize session
session_start();

// Assuming you have an authentication system in place
$auth = new stdClass();
$auth->id = 1; // Replace with actual user ID

// Get the current user ID
$user_id = $auth->id;

// Check if the blog_posts session variable is set
if (!isset($_SESSION['blog_posts'])) {
    $_SESSION['blog_posts'] = array();
}

// Check if the user has exceeded the limit
if (isset($_SESSION['blog_posts'][$user_id]) && $_SESSION['blog_posts'][$user_id] >= 3) {
    // Prevent further blog posts for the day
    return false;
}

// Increment the number of blog posts made by the user
$_SESSION['blog_posts'][$user_id] = isset($_SESSION['blog_posts'][$user_id]) ? $_SESSION['blog_posts'][$user_id] + 1 : 1;

// Allow the user to make a new blog post
return true;

?>