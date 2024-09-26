/**
 * @param url the url to post to
 * @param data formatted JSON string.
 */
function download(url, data) {
  var f = $('<form>')
    .prop('method', 'post')
    .prop('action', url)
    .css('display', 'none')
    .append($('<input type="text" name="data">').val(data));

  $('body').append(f);
  f.submit();
  f.remove();
}