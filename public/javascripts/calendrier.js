(function($){
	
	//Handles the carousel thumbnails
	   $('[id^=date_]').click(function () {
	       var id_selector = $(this).attr("id");
	       
	       try {
	           var id = /_(\d+)$/.exec(id_selector)[1];
	           console.log(id_selector, id);
	           alert(id);
	       } catch (e) {
	           console.log('Regex failed!', e);
	       }
	   });
})(jQuery);