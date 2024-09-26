var windowLoc = window.location.pathname;

switch (windowLoc) {
    case "/info.php":
        console.log("Info page");
        break;
    case "/alert.php":
        console.log("Alert page");
        break;
    default:
        console.log("Unknown page");
}