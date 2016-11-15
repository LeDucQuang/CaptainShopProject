function make_menu_active(position) {
    if (position == null) {
        position = 1;
    }
    $(".nav-item a:nth-child(" + position + ")").addClass("w3-blue");

}
$(document).ready(function () {
    // Get the Sidenav
    var mySidenav = document.getElementById("mySidenav");

    // Get the DIV with overlay effect
    var overlayBg = document.getElementById("myOverlay");

    // Toggle between showing and hiding the sidenav, and add overlay effect
    function sidenav_open() {
        if (mySidenav.style.display === 'block') {
            mySidenav.style.display = 'none';
            overlayBg.style.display = "none";
        } else {
            mySidenav.style.display = 'block';
            overlayBg.style.display = "block";
        }
    }

    // Close the sidenav with the close button
    function sidenav_close() {
        mySidenav.style.display = "none";
        overlayBg.style.display = "none";
    }

    function hide_nortification() {
        var nortification_table = $(".nortification-table");
        nortification_table.removeClass("w3-animate-right");
        nortification_table.addClass("left-reversed");
        nortification_table.css("right", "-300px");
    }

    function show_nortification() {
        var nortification_table = $(".nortification-table");
        nortification_table.addClass("w3-animate-right");
        nortification_table.removeClass("left-reversed");
        nortification_table.css("right", "0");
    }

    function add_nortification() {
        var nortification_table = $(".nortification-table");
        nortification_table.append(
                '<tr> \
        <td><i class="fa fa-user w3-blue w3-padding-tiny"></i></td> \
        <td>New record, over 90 views.</td> \
		</tr> \
		');
    }

    $("#nortification-btn").click(function () {
        if ($(".nortification-table").css("right") != "0px") {
            show_nortification();
        } else {
            hide_nortification();
        }
    });

    $("#open_nav_btn").click(sidenav_open);

    $(".recent-user ul li span:first-child").click(function () {
        $(this).parent().css("display", "none");
    });
});
		