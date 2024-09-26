function userHasPaid() {
    // logic to check if user has paid
    return true; // or false
}

function redirect(url) {
    window.location.href = url;
}

function provideDownload() {
    // logic to provide download
    console.log("Download provided");
}

const sales_page = "/sales-page";

if (!userHasPaid()) {
    redirect(sales_page);
} else {
    provideDownload();
}