/*!
 * Bootstrap v3.2.0 (http://getbootstrap.com)
 * Copyright 2011-2014 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */

jQuery(document).ready(function($) {
	var options = {
		$AutoPlay : true,
		$AutoPlayInterval : 4000,
		$SlideDuration : 500,
		$DragOrientation : 3,
		$ThumbnailNavigatorOptions : {
			$Class : $JssorThumbnailNavigator$,
			$ChanceToShow : 2,
			$Loop : 2,
			$SpacingX : 3,
			$SpacingY : 3,
			$DisplayPieces : 6,
			$ParkingPosition : 204,
			$ArrowNavigatorOptions : {
				$Class : $JssorArrowNavigator$,
				$ChanceToShow : 2,
				$AutoCenter : 2,
				$Steps : 6
			}
		}
	};
	
	var jssor_slider1 = new $JssorSlider$("slider1_container", options);
	function ScaleSlider() {
		var parentWidth = jssor_slider1.$Elmt.parentNode.clientWidth;
		if (parentWidth)
			jssor_slider1.$SetScaleWidth(Math.min(parentWidth, 980));
		else
			window.setTimeout(ScaleSlider, 30);
	}
	ScaleSlider();
	if (!navigator.userAgent.match(/(iPhone|iPod|iPad|BlackBerry|IEMobile)/)) {
		$(window).bind('resize', ScaleSlider);
	}
});
/* My code */
function lockOpen() {
	$("#lockOpen").fadeOut();
	$("#lockClose").fadeIn();
//	$(".lockClose").addStyle("opacity:10;");
//	$(".sidebarMenu").addStyle("margin-left:-50px;background-color:red;");

};
function lockClose() {
	$("#lockClose").fadeOut();
	$("#lockOpen").fadeIn();

};

function detailButton(id) {
	$("#overlay").fadeIn();
	$("#cadre").fadeIn();
	var myID = id;
};

function allActivite() {
	$("#allAct").fadeIn();
	$("#appAct").fadeOut();
	$("#recAct").fadeOut();
	$("#parAct").fadeOut();
	$("#gouvAct").fadeOut();
};
function rechercheActivite() {
	$("#allAct").fadeOut();
	$("#appAct").fadeOut();
	$("#recAct").fadeIn();
	$("#parAct").fadeOut();
	$("#gouvAct").fadeOut();

};
function apprentissageActivite() {
	$("#allAct").fadeOut();
	$("#appAct").fadeIn();
	$("#recAct").fadeOut();
	$("#parAct").fadeOut();
	$("#gouvAct").fadeOut();

};

function partenaireActivite() {
	$("#allAct").fadeOut();
	$("#appAct").fadeOut();
	$("#recAct").fadeOut();
	$("#parAct").fadeIn();
	$("#gouvAct").fadeOut();

};
function gouvernanceActivite() {
	$("#allAct").fadeOut();
	$("#appAct").fadeOut();
	$("#recAct").fadeOut();
	$("#parAct").fadeOut();
	$("#gouvAct").fadeIn();

};
function allEtudiant() {
	$("#allEtud").fadeIn();
	$("#natEtud").fadeOut();
	$("#femEtud").fadeOut();
	$("#regEtud").fadeOut();
};
function natEtudiant() {
	$("#allEtud").fadeOut();
	$("#natEtud").fadeIn();
	$("#femEtud").fadeOut();
	$("#regEtud").fadeOut();
};
function regEtudiant() {
	$("#allEtud").fadeOut();
	$("#natEtud").fadeOut();
	$("#femEtud").fadeOut();
	$("#regEtud").fadeIn();
};
function femEtudiant() {
	$("#allEtud").fadeOut();
	$("#natEtud").fadeOut();
	$("#femEtud").fadeIn();
	$("#regEtud").fadeOut();
};
function allPublication() {
	$("#all").fadeIn();
	$("#these").fadeOut();
	$("#memoire").fadeOut();
	$("#article").fadeOut();
};
function thesePublication() {
	$("#all").fadeOut();
	$("#these").fadeIn();
	$("#memoire").fadeOut();
	$("#article").fadeOut();
};
function memoirePublication() {
	$("#all").fadeOut();
	$("#these").fadeOut();
	$("#memoire").fadeIn();
	$("#article").fadeOut();
};
function articlePublication() {
	$("#all").fadeOut();
	$("#these").fadeOut();
	$("#memoire").fadeOut();
	$("#article").fadeIn();
};
/* End my code */

$(function() {
	$('a[href*=#]:not([href=#])').click(
			function() {
				if (location.pathname.replace(/^\//, '') == this.pathname
						.replace(/^\//, '')
						&& location.hostname == this.hostname) {
					var target = $(this.hash);
					target = target.length ? target : $('[name='
							+ this.hash.slice(1) + ']');
					if (target.length) {
						$('html,body').animate({
							scrollTop : target.offset().top
						}, 1000);
						return false;
					}
				}
			});
});

selectnav('nav', {
	label : '-Navigation-',
	nested : true,
	indent : '-'
});
selectnav('nav2', {
	label : '-Navigation-',
	nested : true,
	indent : '-'
});

$('.dateShow').datepicker({
	format : "dd/mm/yyyy"
});