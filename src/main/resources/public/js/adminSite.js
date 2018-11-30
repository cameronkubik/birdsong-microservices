var AdminSite = {
    Content: {
        load: function () {
            console.log("SUCCESS");
            this.bindEventListeners();
            this.setupDatepickers();
        },

        bindEventListeners: function () {
            $(".date").hide();

			$(".future").click(function(){
				$(".date").show();
            });
            
			$(".current").click(function(){
				$(".date").hide();
			});

			$('#showingTable').DataTable({
				"columnDefs": [
			        { "orderable": false, "targets": 3 },
			        { "width": "15%", "targets": 3}
		        ]
		    });
        },

        setupDatepickers: function () {
            var date_input = $('input[name="date"]'); //our date input has the name "date"
            var container=$('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
            var options={
                format: 'mm/dd/yyyy',
                container: container,
                todayHighlight: true,
                autoclose: true,
                orientation: 'top'
            };

		    date_input.datepicker(options);
        }
    },

    Pages: {
        load: function () {
            var baseUrl = "localhost:8081";
            var homeUrl = "/content/get-home-screen";
            var boxUrl = "/content/get-box-office--screen";
            var concessionUrl = "/content/get-concession-screen";
            var aboutUrl = "/content/get-about-us-screen";

            homeScreenResponse = AdminSite.Util.httpGetAsync(baseUrl + homeUrl);
            boxScreenResponse = AdminSite.Util.httpGetAsync(baseUrl + boxUrl);
            concessionScreenResponse = AdminSite.Util.httpGetAsync(baseUrl + concessionUrl);
            aboutScreenResponse = AdminSite.Util.httpGetAsync(baseUrl + aboutUrl);

            debugger;
        },

        Home: {
            load: function () {

            }
        }
    },

    Util: {
        httpGetAsync: function (url, callback) {
            var xmlHttp = new XMLHttpRequest();
            // handle response
			xmlHttp.onreadystatechange = function() {
					if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
							callback(xmlHttp.response);
            }
            
			xmlHttp.open("GET", theUrl, true); // true for asynchronous
			xmlHttp.send(null);
        }
    },

    load: function () {
        this.Content.load();
        this.Pages.load();
    }
}

$(document).ready(function() {
    AdminSite.load();

    console.log("HIT");
});