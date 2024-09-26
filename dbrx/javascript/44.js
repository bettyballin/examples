const roles = ["admin", "moderator", "user"]; // example array of roles

if (jQuery.inArray("admin", roles) !== -1) {
    console.log("User has admin rights.");
    // Show/hide/enable/disable whatever you need.
} else {
    console.log("Regular users don’t have access to these features.");
    // Hide or disable links/buttons/etc
}