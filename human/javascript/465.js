// Since we are not in a Chrome extension environment, 
// we can't directly use chrome.history API. 
// We can simulate it using the following code:

function chromeMock() {
    this.history = {
        search: function(params, callback) {
            // Simulating the search results
            let data = [
                { url: 'https://www.google.com' },
                { url: 'https://www.youtube.com' },
                { url: 'https://www.github.com' },
                { url: 'https://www.stackoverflow.com' },
                { url: 'https://www.reddit.com' },
                { url: 'https://www.facebook.com' },
                { url: 'https://www.instagram.com' },
                { url: 'https://www.twitter.com' },
                { url: 'https://www.pinterest.com' },
                { url: 'https://www.tiktok.com' }
            ];
            callback(data);
        }
    };
}

let chrome = new chromeMock();

chrome.history.search({text: '', maxResults: 10}, function(data) {
    data.forEach(function(page) {
        console.log(page.url);
    });
});