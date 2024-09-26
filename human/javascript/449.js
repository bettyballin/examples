function ClosePopUp(objBhID) {
    var pageName = window.location.pathname;
    var modalPopupBehavior = $find(objBhID);
    if (modalPopupBehavior != null && modalPopupBehavior != 'undefined') {
        modalPopupBehavior.hide();
    }
    if (objBhID == 'bhThankMsg' && pageName == '/Projects/Comm.aspx') {
        var objPartnerID = $('#myDynamicData').data('partnerId');
        var id = $('#myDynamicData').data('id');
        if (objPartnerID) {
            window.location = '/Projects/Comm.aspx?Id=' + encodeURIComponent(id) + '&partnerid=' + encodeURIComponent(objPartnerID);                
        }
        else {
            window.location = '/Projects/Comm.aspx?Id=' + encodeURIComponent(id);
        }
    }
}