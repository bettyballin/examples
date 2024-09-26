
// Initialize an array to hold all directives
$allDirectives = [];

// Define some CSP directives
$someDirectives = "default-src 'self';";
$someOtherDirectives = "img-src 'self' data:;";

// Add directives to the array
$allDirectives[] = $someDirectives;
$allDirectives[] = $someOtherDirectives;

// Merge directives and remove duplicates
$mergedDirectives = implode(' ', array_unique($allDirectives));

// Set
