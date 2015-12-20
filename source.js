$(document).ready(function() {
    $("body").load("underconstruction.html");

    $.ajax({
        type: "GET",
        url: "http://cors.io/?u=https://github.com/Reline.atom",
        cache: false,
        success: function(result) {
            console.log("Reline.atom loaded");

            var atom = $("<span />", { html: result }).text();
            var githubActivity = $("#githubActivity");
            githubActivity.html(atom);
            var children = githubActivity.children();
            githubActivity.html(children);

            $('a').each(function () {
                var href = $(this).attr('href');

                if (href) {
                    href = "https://github.com" + href;
                    $(this).attr('href', href);
                }
            });
        },
        async: true
    })
});

function getAllMethods(object) {
    return Object.getOwnPropertyNames(object).filter(function(property) {
        return typeof object[property] == 'function';
    });
}