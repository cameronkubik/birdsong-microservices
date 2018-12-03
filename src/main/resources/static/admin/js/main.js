var Page = {
    Events: {
        bindEventHandlers: function () {
            this.bindConcessionPage();
        },
        bindConcessionPage: function () {
            $("#tabs").find(".nav-link").click(function(e) {
                //logic
            });
        }
    },
    
    load: function () {
        this.Events.bindEventHandlers();
    }
}

$( document ).ready(function() {
    Page.load();
});