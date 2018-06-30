$(document).ready(() => {
    let dialogTarget = $("[dialog-target]");
    dialogTarget.click(() => {
        let dialog = $(dialogTarget.attr("dialog-target"));
        dialog.css("display", "block");
        let dialogBox = $(".dialog-box");
        let width = dialogBox.width();
        dialogBox.css("margin-left", "-" + width / 2 + "px");
    });

    let dialogDismiss = $("[dialog-dismiss]");
    dialogDismiss.click(() => {
        let dialog = $(dialogDismiss.attr("dialog-dismiss"));
        dialog.css("display", "none");
    });


    let account = $("#account");
    let accountMenu = $("#account-menu");
    let menuDown = $("#menu-down");
    let menuStart = null;
    let menuStop = null;
    account.mouseover(() => {
        if (menuStop !== null) {
            clearTimeout(menuStop);
        }
        menuStart = setTimeout(() => {
            menuDown.css("transform", "rotate(180deg)");
            accountMenu.css("display", "block");
        }, 200);
    });

    account.mouseout(() => {
        if (menuStart !== null) {
            clearTimeout(menuStart);
        }
        menuStop = setTimeout(() => {
            menuDown.css("transform", "rotate(0deg)");
            accountMenu.css("display", "none");
        }, 400);
    });
});