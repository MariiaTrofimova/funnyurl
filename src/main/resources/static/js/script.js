/*document.getElementsByTagName("h1")[0].style.fontSize = "6vw";*/

function myFunction() {
    /* Get the text field */
    let copyText = document.getElementById("shortUrl");

    /* Select the text field */
    copyText.select();

    /* Copy the text inside the text field */
    document.execCommand("copy");
    /*navigator.clipboard.writeText('copy');*/

    /* Alert the copied text */
    /*    alert("Copied the text: " + copyText.value);*/
}