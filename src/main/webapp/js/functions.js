function deleteRecord() {
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Пожалуйста, выберите хотя бы одного пользователя!");
        return;
    }

    var idUserSelected = "";
    for (var i = 0; i < items.length; ++i) {
        idUserSelected = idUserSelected + $(items[i]).attr("value") + ",";
    }

    $("#idUserDisc").val(idUserSelected);
    $('#delete-user-form').submit();
}