(function($){
	
	   $('.modal-trigger').click(function () {
	       var id_selector = $(this).attr("data-id");
	       
	      $("#id_date").val(id_selector);
	   });
	   
	   $('.evenement').click(function () {
	       
		   display($(this).find(".description-evenement"));
	   });
})(jQuery);

function display(content){
	var content = content;
	if ($(content).css('display') == "none"){
		$(content).css('display', 'block');
    } else{
    	$(content).css("display", "none");
    }
};