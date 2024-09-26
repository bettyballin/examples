String.prototype.cleanHTML = function() {
  return this.replace(/&/g, '&amp;')
             .replace(/</g, '&lt;')
             .replace(/>/g, '&gt;')
             .replace(/"/g, '&quot;')
             .replace(/'/g, '&#039;');
}

String.prototype.clean = function() {
  return this.replace(/<\/?[^>]+(>|$)/g, '');
}

let content = $(this).html().cleanHTML().clean();
let setContentId = Math.floor(Math.random()*10000);
let commentHtml = '&lt;pre name="comment" type="text/plain"&gt;&lt;comment-content set-content="'+setContentId+'"&gt;&lt;/comment-content&gt;&lt;/pre&gt;';
$(this).html(commentHtml);

function setUserCommentHtml(content) {
  return content;
}

$('comment-content[set-content="'+setContentId+'"]').html(setUserCommentHtml(content.clean()));