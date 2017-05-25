/*
*	############################################################################
*	
*	Repute Shop - Responsive Multipurpose Bootstrap Theme
*	---------------------------------------------------------------------
*
*	Version		1.1 (following main theme version)
*	Author		The Develovers
*	Copyright	Copyright 2015 The Develovers
*
*	############################################################################
*/

$(document).ready(function() {

	/*----------------------------/
	/* HERO UNIT
	/*---------------------------*/

	// create array of pagination title
	var paginationTitle = [];

	$('#carousel-home .carousel-inner .item').each(function(i) {
		paginationTitle.push($(this).attr('data-pagination-title'));
	});

	// initialize slider with custom paging
	if($('#carousel-home').length > 0) {
		$('#carousel-home .carousel-inner').slick({
			speed: 800,
			dots: true,
			fade: true,
			autoplay: true,
			autoplaySpeed: 2500,
			prevArrow: '<button type="button" data-role="none" class="carousel-control left slick-prev">Previous</button>',
			nextArrow: '<button type="button" data-role="none" class="carousel-control right slick-next">Next</button>',
			customPaging: function(slider, i) {
				return '<button type="button" data-role="none">' + paginationTitle[i] + '</button>';
			},
		});
	}


	/*----------------------------/
	/* PRODUCT CAROUSEL
	/*---------------------------*/

	if($('.product-carousel').length > 0) {
		initProductCarousel();
	}

	function initProductCarousel(element) {
		$('.product-carousel').slick({
			infinite: true,
			slidesToShow: 4,
			slidesToScroll: 1,
			responsive: [
				{
					breakpoint: 992,
					settings: {
						slidesToShow: 2,
					}
				},
				{
					breakpoint: 480,
					settings: "unslick"
				}
			]
		});
	}


	/*----------------------/
	/* SINGLE PRODUCT PAGE
	/*----------------------*/

	/* product image gallery */
	if($("a[rel^='gallery']").length > 0) {
		$("a[rel^='gallery']").prettyPhoto({
			social_tools: false,
			show_title: false,
			opacity: 0.3,
			markup: '<div class="pp_pic_holder"> \
						<div class="pp_content_container"> \
							<a class="pp_close" href="#" title="Close">&times</a> \
							<div class="pp_content"> \
								<div class="pp_loaderIcon"></div> \
								<div class="pp_fade"> \
									<a href="#" class="pp_expand" title="Expand the image">Expand</a> \
									<div class="pp_hoverContainer"> \
										<a class="pp_next" href="#"><i class="fa fa-angle-right"></i></a> \
										<a class="pp_previous" href="#"><i class="fa fa-angle-left"></i></a> \
									</div> \
									<div id="pp_full_res"></div> \
									<div class="pp_details"> \
										<div class="pp_nav"> \
											<a href="#" class="pp_arrow_previous">Previous</a> \
											<p class="currentTextHolder">0/0</p> \
											<a href="#" class="pp_arrow_next">Next</a> \
										</div> \
										<p class="pp_description"></p> \
										{pp_social} \
									</div> \
								</div> \
							</div> \
						</div> \
					</div> \
					<div class="pp_overlay"></div>',
		});
	};

	/* stock availability demo */
	if( $('#product-single-form').length > 0 ) {
		$('#product-single-form').on('change', function() {
			var selectedColor = $('#var-color').val();

			if( selectedColor != 'light' ) { // for demo purpose only
				$('.stock-indicator.unavailable').removeClass('hide');
				$('.stock-indicator.available').addClass('hide');
			} else {
				$('.stock-indicator.unavailable').addClass('hide');
				$('.stock-indicator.available').removeClass('hide');
			}
		})
	}

	/* quantity field */
	if($('.input-range').length > 0) {
		$('.input-range').ionRangeSlider({
			type: "double",
			min: 0,
			max: 500,
			from: 100,
			to: 400,
			prefix: '$'
		});
	}


	/*----------------------------/
	/* CHECKOUT STEPS
	/*---------------------------*/

	/* checkout wizard */
	if($('#checkout-wizard').length > 0) {

	    setUpAddressValidation();

		$('#checkout-wizard')
		.wizard()
		.on('changed.fu.wizard', function(e, data) {
			if($('#btn-checkout-next').hasClass('btn-paynow')) {
				$('#btn-checkout-next').removeClass('btn-paynow');
			}

			if(data.step == 1) { // if step at shopping cart
                window.location.href = "/cart";
			} else if(data.step == 2) { // if step at shipping
                $('#btn-back-to-cart').removeClass('hide-first');
                $('#btn-checkout-next').removeClass('hide-first');
                $('#btn-checkout-prev').addClass('hide-first');
                $('#btn-checkout-submit').addClass('hide-first');
			} else if(data.step == 3) { // if at payment
                $('#btn-back-to-cart').addClass('hide-first');
                $('#btn-checkout-next').addClass('hide-first');
				$('#btn-checkout-prev').removeClass('hide-first');
                $('#btn-checkout-submit').removeClass('hide-first');
            }
		})
		.on('actionclicked.fu.wizard', function(e, data) {
			// validation process for 'next' direction only
			if($('#checkout-form').length > 0 && data.direction == 'next') {
				var parsleyForm = $('#checkout-form').parsley();
				parsleyForm.validate();

				if(!parsleyForm.isValid())
					return false;
			}
		})
		.on('finished.fu.wizard', function(e) {
			if($('#form-payment').length > 0) {
				var parsleyForm = $('#form-payment').parsley();
				parsleyForm.validate();
			}

			if(!parsleyForm.isValid())
				return false;

			alert('Thanks for your purchase');
		});
	}

	if($('#checkout-form').length > 0) {
		$('#checkout-form').on('change', function() {
			deliveryMethodSelected();
			addressSelected();
			setUpAddressValidation();
		});
	}

    function setUpAddressValidation() {
        if($('#new-address-radio').is(':checked') && $('#radio-express').is(':checked')) {
            $('#newAddressCountry').attr('required', true);
            $('#newAddressCity').attr('required', true);
            $('#newAddressStreet').attr('required', true);
            $('#newAddressApartmentNumber').attr('required', true);
            $('#newAddressZipCode').attr('required', true);
        } else {
            $('#newAddressCountry').attr('required', false);
            $('#newAddressCity').attr('required', false);
            $('#newAddressStreet').attr('required', false);
            $('#newAddressApartmentNumber').attr('required', false);
            $('#newAddressZipCode').attr('required', false);
        }
    }

    function addressSelected() {
        if($('#new-address-radio').is(':checked')) {
            $('.new-address-box').slideDown();
        } else {
            $('.new-address-box').slideUp();
        }
    }

	function deliveryMethodSelected() {
		if($('#radio-express').is(':checked')) {
			$('.express-delivery-box').slideDown();
			$('.self-pickup-box').slideUp();
		} else {
			$('.express-delivery-box').slideUp();
			$('.self-pickup-box').slideDown();
		}
	}

    if($('#storefront-form').length > 0) {
        $('#storefront-form').on('change', function() {
            storefrontTypeSelected();
        });
    }

    function storefrontTypeSelected() {
        if($('#radio-top-ten').is(':checked')) {
            $('.top-ten-box').slideDown();
            $('.custom-list-box').slideUp();
        } else {
            $('.top-ten-box').slideUp();
            $('.custom-list-box').slideDown();
        }
    }

	/* shop by category navigation toggle */
	$('.shop-by-category .category-toggle').on('click', function(e) {
		e.preventDefault();
	});

	responseCategoryToggle();
	$(window).bind("resize", responseCategoryToggle);

	function responseCategoryToggle() {
		if( $(window).width() <= 992) {
		
			$('.shop-by-category .category-toggle').clickToggle(
				function() {
					$(this).parent().addClass('open');
				},
				function() {
					$(this).parent().removeClass('open');
				}
			);
		}
	}


	/*----------------------------/
	/* LOGIN PAGE
	/*---------------------------*/

	if( $('.btn-login-help').length > 0 ) {
		$('.btn-login-help').popover({
			container: 'body',
			placement: 'right',
			trigger: 'focus',
			html: true,
			title: 'Problem Signing?',
			content: 'Please find helpful links below that match best with your signing problems.' +
			'<ul>' +
			'<li><a href="#">I forgot my login email</a></li>' +
			'<li><a href="#">How to secure your account?</a></li>' +
			'<li><a href="#">Go to help center</a></li>' +
			'</ul>'
		});
	}
});

// toggle function
$.fn.clickToggle = function( f1, f2 ) {
	return this.each( function() {
		var clicked = false;
		$(this).bind('click', function() {
			if(clicked) {
				clicked = false;
				return f2.apply(this, arguments);
			}

			clicked = true;
			return f1.apply(this, arguments);
		});
	});

}