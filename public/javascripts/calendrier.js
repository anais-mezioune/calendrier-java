(function($){
	
	   $('.modal-trigger').click(function () {
	       var id_selector = $(this).attr("data-id");
	       
	      $("#id_date").val(id_selector);
	   });
})(jQuery);