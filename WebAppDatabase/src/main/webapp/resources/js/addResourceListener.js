$(document).ready(function() {
    var $form = $("#addResource");
    $form.on('submit', function(e) {
        e.preventDefault(); // stop default form submission
        $.ajax({  // form submission via ajax
            url: $form.attr('action'), // form submission url
            // contentType: 'application/json',
            type: 'POST', // request type
            dataType: 'json', // data type
            data: $form.serialize(), // get all data from the form
            success: function(result) {
                window.location.replace("localhost:8080/resources");
                console.log(result); // response back from server in case of success
            },
            error: function(xhr, resp, text) { // response back from server in case of failure
                console.log(xhr, resp, text);
            }
        })
    });
});