function ClosePopUp(objBhID) {
    var pageName = window.location.pathname;
    var modalPopupBehavior = $find(objBhID);

    if (modalPopupBehavior != null && modalPopupBehavior !== 'undefined') {
        modalPopupBehavior.hide();
    }

    // Validate and sanitize query string parameters
    const urlParams = new URLSearchParams(window.location.search);
    const partnerId = urlParams.get('partnerid');

    if (objBhID === "bhThankMsg" && pageName === "/Projects/Comm.aspx") {
        // Check for null undefined or empty values
        const isPartnerIdValid = partnerId !== null && partnerId !== '';

        if (isPartnerIdValid) {
            const id = urlParams.get('ID');
            window.location = `/Projects/Comm.aspx?Id=${encodeURIComponent(id)}&partnerid=${encodeURIComponent(partnerId)}`;
        } else {
            // If partner ID is not valid redirect without it
            const id = urlParams.get('ID');
            window.location = `/Projects/Comm.aspx?Id=${encodeURIComponent(id)}`;
        }
    }
}