
const btn = document.querySelector("#btn");
btn.addEventListener("click", async e => { // Note the use of async
    try {
        // Now we await the Promise returned by loadFile() to get the data
        let data = await window.electronAPI.loadFile();
        document.getElementById("main-content").innerText = data;
    } catch (error) {
        // Handle any errors here
        console.error(error);
        document.getElementById("main-content").innerText = "Error loading file";
    }
});

