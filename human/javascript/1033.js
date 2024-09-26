const returnInfo = JSON.parse(sessionStorage.getItem("returnUrl"));
if (returnInfo && validatePageName(returnInfo.pageName)) {
    window.location.href = "/" + returnInfo.pageName;
}

// Define the validatePageName function
function validatePageName(pageName) {
    // Add your validation logic here
    // For example:
    const validPageNames = ["home", "about", "contact"];
    return validPageNames.includes(pageName);
}