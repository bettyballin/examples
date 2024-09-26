let counter = 0;
let links = ["link1", "link2", "link3"]; // replace with your links
let banner_div = document.getElementById("banner_div"); // replace with your div id

function cycle() {
    if (counter == links.length) {
        counter = 0;
    }
    else if (counter < links.length) {
        banner_div.innerHTML = links[counter];
        //increase counter
        counter++;
        var timeoutId = setTimeout(cycle, 8000);
        if (timeoutId !== null) {
            //clearTimeout(timeoutId); // this line clears the timeout, remove it if you want the cycle to continue
        }
    }
}

cycle();