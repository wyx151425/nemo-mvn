$(document).ready(() => {
    $("#login-btn").click(() => {
        $.ajax({
            url: "@{/users/login}",
            dataType: "json",
            type: "post",
            contentType: "application/json",
            data: {
                mobilePhoneNumber: "1525360357",
                password: "wyx151425"
            },
            async: true,
            success: function (data) {

            }
        });
    });
});