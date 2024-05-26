window.onload = function (){
    const form = document.getElementById("form");
    const error = document.getElementById("error");

    form.addEventListener("submit", function (event){
        event.preventDefault();
        const response = grecaptcha.getResponse();
        if (response){
            form.submit();
        } else {
            error.innerHTML = "Vui lòng xác nhận Recaptcha!";
        }
    });
}
