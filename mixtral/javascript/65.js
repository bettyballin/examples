const observer = new MutationObserver((mutations) => {
    mutations.forEach(()=>{
        $("#yourElement").css("webkitFilter", "grayscale(1)");
     });
});

observer.observe($("#yourElement")[0], { attributes: true, childList: false, subtree: false });