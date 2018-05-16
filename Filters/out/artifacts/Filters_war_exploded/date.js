function callback(response){
    $("#date").html(response.date);
}

function ajax_post() {
    $.post(
      "/date",
      null,
      callback,
      "json"
    );
}

setInterval(ajax_post(), 1000);