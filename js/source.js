$(document).ready(function() {
    resizeFrame(document.getElementsByClassName('document'));
    githubFeed("Reline");
});

window.onresize = function() {
    resizeFrame(document.getElementsByClassName('document'));
};

function resizeFrame(f) {
    if (f != null) {
        for (var i = 0; i < f.length; i++) {
            f[i].style.height = f[i].clientWidth + "px";
        }
    }
}

function objectives() {
    this.open("../objectives", "_self");
}

function projects() {
    this.open("../projects", "_self");
}

function githubFeed($user) { // string param for GitHub username
    $.ajax({
        type: "GET",
        url: "http://cors.io/?u=https://github.com/" + $user + ".atom",
        cache: false,
        dataType: 'xml',
        success: function(result) {
            console.log($user + ".atom loaded");

            var atom = $("<span />", { html: result.firstChild }).text();
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

            $("#github-container").addClass("github-container");

        },
        error: function (err) {
            console.log("AJAX error in request: " + JSON.stringify(err, null, 2));
        },
        async: true
    })
}