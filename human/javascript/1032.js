$(function () {
    var alerts = $('ul.alert').wrap('<div />');
    alerts.prepend('<a class="close" data-dismiss="alert" href="#">×</a>');
    alerts.alert();
});