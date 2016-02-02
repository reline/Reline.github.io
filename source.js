$(document).ready(function() {
    // $("body").load("underconstruction.html");

    githubFeed("Reline");
});

function githubFeed($user) { // string param for GitHub username
    $.ajax({
        type: "GET",
        url: "http://cors.io/?u=https://github.com/" + $user + ".atom",
        cache: false,
        success: function(result) {
            console.log($user + ".atom loaded");

            var atom = $("<span />", { html: result }).text();
            var githubActivity = $("#githubActivity");
            githubActivity.html(atom);
            var children = githubActivity.children();
            githubActivity.html(children);

            $('.github a').each(function () {
                var href = $(this).attr('href');

                if (href) {
                    href = "https://github.com" + href;
                    $(this).attr('href', href);
                    $(this).attr('target', "_blank");
                }
            });
        },
        error: function (err) {
            console.log("AJAX error in request: " + JSON.stringify(err, null, 2));
        },
        async: true
    })
}