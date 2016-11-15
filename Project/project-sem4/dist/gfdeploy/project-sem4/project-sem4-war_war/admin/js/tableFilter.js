$(document).ready(function () {
    function filter_bill(query_string, filter_table) {
        query_string = query_string.toUpperCase();
        filter_table = document.querySelectorAll(filter_table)[0];
        var filter_row = filter_table.querySelectorAll("tbody tr");

        for (var i = 0; i < filter_row.length; i++) {
            if (query_string.length > 0) {
                var ok = false;
                var filter_field = filter_row[i].querySelectorAll("td");

                for (var j = 0; j < filter_field.length; j++) {
                    if (filter_field[j].innerHTML.toUpperCase().indexOf(query_string) > -1) {
                        ok = true;
                        break;
                    }
                }

                if (!ok) {
                    filter_row[i].style.display = "none";
                } else {
                    filter_row[i].style.display = "table-row";
                }
            } else {
                filter_row[i].style.display = "table-row";
            }
        }
    }

    var filter_input = $(".filter-input");
    filter_input.keyup(function() {        
        filter_bill(this.value, "#" + filter_input.attr("data-filter"));
    });
});