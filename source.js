$(document).ready(function() {
    $("body").load("underconstruction.html")
});

$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "http://cors.io/?u=https://github.com/Reline.atom",
        // dataType: "html",
        cache: false,
        success: function(result) {
            console.log("Reline.atom loaded");

            var xmlString = $("<span />", { html: result }).text();

            $("#githubActivity").html(xmlString);
        },
        async: true
    })
});