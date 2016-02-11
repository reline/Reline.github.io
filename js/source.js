$(document).ready(function() {
    resizeFrame(document.getElementById('resume'));
    githubFeed("Reline");
});

window.onresize = function() {
    resizeFrame(document.getElementById('resume'));
};

function resizeFrame(f) {
    f.style.height = f.clientWidth + "px";
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
        },
        error: function (err) {
            var githubActivity = $("#githubActivity");
            githubActivity.html(JSON.stringify(err, null, 2));
            console.log("AJAX error in request: " + JSON.stringify(err, null, 2));
        },
        async: true
    })
}