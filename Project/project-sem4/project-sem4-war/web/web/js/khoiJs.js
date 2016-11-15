function makeMenutabActive( pos, tab ) {
    $("ul#menutab" + tab + ">li" + ":nth-child(" + pos + ") a").addClass("active");
}

$("document").ready( function() {
	var brand_margin_left = 0;
	var brand_pause = false;
	var brand_width = $( "ul.brand_icons li" ).css("width").replace( "px", "" );
	brand_width = parseInt( brand_width ) + 100;
	
	$( "ul.brand_icons" ).mouseenter( function() {
		brand_pause = true;
	} );
	
	$( "ul.brand_icons" ).mouseleave( function() {
		brand_pause = false;
	} );
	
	setInterval( function() {
		if( !brand_pause ) {
			brand_margin_left = brand_margin_left + 1;
			if( brand_margin_left <= brand_width ) {
				$( "ul.brand_icons" ).css( "marginLeft", "-" + brand_margin_left + "px" );
			} else {
				brand_width = $( "ul.brand_icons li" ).css("width");
				brand_margin_left = 0;
				brand_width = $( "ul.brand_icons li" ).css("width").replace( "px", "" );
				brand_width = parseInt( brand_width ) + 100;
				
				$( "ul.brand_icons li:first-child" ).appendTo( "ul.brand_icons" );
			}	
		}
	}, 20 );
	
	$( ".khoi-cart-btn" ).click( function() {
		if( $( ".khoi-fixed-banner" ) .css( "left" ).localeCompare( "-400px" ) == 0 ) {
			$( ".khoi-fixed-banner" ).addClass( "right-reversed" );
			$( ".khoi-fixed-banner" ).removeClass( "left-reversed" );
			$( ".khoi-cart-btn" ).addClass( "rotate-start" );
			$( ".khoi-cart-btn" ).removeClass( "rotate-end" );
		} else {
			$( ".khoi-fixed-banner" ).addClass( "left-reversed" );
			$( ".khoi-fixed-banner" ).removeClass( "right-reversed" );
			$( ".khoi-cart-btn" ).addClass( "rotate-end" );
			$( ".khoi-cart-btn" ).removeClass( "rotate-start" );
		}
	} );
	
} );