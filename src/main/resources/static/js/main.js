var Page = {
    Events: {
        bindEventHandlers: function () {
            this.bindConcessionPage();
        },
        bindConcessionPage: function () {
            $("#whateverContainer").find(".classOfButton").click(function(e) {
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