$(document).ready(function() {
  if (!isMobile()) {
    $('#projects').attr("href", "/projects");
  }
});

window.onresize = function() {
  resizeFrame(document.getElementsByClassName('document'));
  resizeStatic(document.getElementsByClassName('qrcode'));
};

function isMobile() {
  return (/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|ipad|iris|kindle|Android|Silk|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino/i.test(navigator.userAgent)
    || /1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(navigator.userAgent.substr(0,4)));
}

function setAge(birthday) {
  $("#age").html(
    Math.floor(((new Date()) - birthday) / 31556952000)
  );
}

function resizeFrame(f) {
  if (f != null) {
    for (var i = 0; i < f.length; i++) {
      f[i].style.height = f[i].clientWidth + "px";
    }
  }
}

function resizeStatic(s) {
  if (s != null) {
    for (var i = 0; i < s.length; i++) {
      if (window.innerWidth < 950) {
        s[i].style.visibility = "hidden";
      } else {
        s[i].style.visibility = "visible";
        s[i].style.width = window.innerWidth * .08 + "px";
        s[i].style.height = s[i].style.width + "px";
      }
    }
  }
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

      $("#github-container").addClass("atom-container");

    },
    error: function (err) {
      console.error("AJAX error in request: " + JSON.stringify(err, null, 2));
    },
    async: true
  })
}

function gitlabFeed($privateToken) {
  $.ajax({
    type: "GET",
    url: "http://cors.io/?u=https://gitlab.com/dashboard/projects.atom?private_token=" + $privateToken,
    cache: false,
    dataType: 'xml',
    success: function(result) {
      console.log("projects.atom loaded");

      var feed = $("<div>",{html: result.firstChild});
      var gitlabActivity = $("#gitlabActivity");
      gitlabActivity.html(feed);

      var summaries = [];
      $("summary").each(function () {
        summaries.push(this);
      });
      gitlabActivity.html(summaries);

      $('.gitlab a').each(function () {
        var href = $(this).attr('href');

        if (href) {
          href = "https://gitlab.com" + href;
          $(this).attr('href', href);
          $(this).attr('target', "_blank");
        }
      });

      $("#gitlab-container").addClass("atom-container");

    },
    error: function (err) {
      console.error("AJAX error in request: " + JSON.stringify(err, null, 2));
    },
    async: true
  })
}