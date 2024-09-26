
document.addEventListener('DOMContentLoaded', function() {
    var verifyButton = document.getElementById('verify');
    verifyButton.addEventListener('click', function() {
        GetResult();
    });
});

function GetResult() {
    var news = document.getElementById('news').value;
    alert(news);
}

