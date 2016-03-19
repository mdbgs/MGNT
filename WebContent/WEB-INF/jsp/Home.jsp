<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="ModelPackage.*"%>
<%@ page import="BeanPackage.*"%>
<%
	User user = (User) request.getSession().getAttribute("user");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CeamiticSEV</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Css include -->
<link rel="stylesheet" href="Assets/css/font-awesome.min.css">
<link rel="stylesheet" href="Assets/fonts/HelveticaNeue/font.css">
<link rel="stylesheet" href="Assets/css/style.css" media="screen">
<link rel="shortcut icon" type="image/x-icon" href="Assets/images/slideshow/logoceamitic.png" sizes="16x16"/>
<link rel="stylesheet" href="Assets/css/responsive.css" media="screen">
<link rel="stylesheet" href="Assets/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="Assets/css/nexus.css" rel="stylesheet">
</head>

<body id="scroll_top">
	<!-- First image in the header -->
	<section id="header_area">
	<div class="fix header_bottom_area">
		<div class="myHeader row">
			<div class=" cl-xs-10">
				<!-- Carousel Slideshow -->
				<div id="carousel-example" class="carousel slide"
					data-ride="carousel">
					<!-- Carousel Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example" data-slide-to="1"></li>
						<li data-target="#carousel-example" data-slide-to="2"></li>
						<li data-target="#carousel-example" data-slide-to="3"></li>
					</ol>
					<div class="clearfix"></div>
					<!-- End Carousel Indicators -->
					<!-- Carousel Images -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="Assets/images/slideshow/logoceamitic.png">
						</div>
						<div class="item">
							<img src="Assets/images/slideshow/logoceamitic.png">
						</div>
						<div class="item">
							<img src="Assets/images/slideshow/logoceamitic.png">
						</div>
						<div class="item">
							<img src="Assets/images/slideshow/logoceamitic.png">
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section id="header_bottom_area"></section>
	<section id="content_area">
	<div class="content center">
		<div class="main_menu row">
			<nav>
			<ul id="nav2">
				<div class="col-xs-9">
					<li><a href="home">Accueil</a></li>
					<li><a href="listeEtudiant">Etudiant</a></li>
					<li><a href="activite">Activités</a></li>
					<li><a href="indicateur">Indicateurs</li>
					<li><a href="publication">Publication</a></li>
					<li><a href="stage">Stage</a></li>
				</div>
				<div class="col-xs-2 ">
					<%
						if (user == null) {
							System.out.println("Utilisateur inexistant!!!");
					%>
					<li><a href="connexion"> Se connecter</a></li>
					<%
						} else {
					%>
					<li><a href=""> Se Déconnecter</a></li>
					<%
						}
					%></div>
			</ul>
			</nav>
		</div>
		<div class="fix main_content_area row">
			<div class="fix home_main_content">
				<div class="main_contentBis floatleft">
					<div class="fix main_content_container">
						<div class="fix single_content_latest_post floatleft">
							<a>A PROPOS</a>
							<div class="fix single_latest_post"></div>
							<div class="fix single_latest_post">
								<div class="fix latest_post_title floatright">
									<p>Cher visiteur,<br /> bientôt vous aurez les mots du coordonateurs!</p>
								</div>
								<div class="fix latest_post_img floatleft">
									<img src="Assets/images/Pr_lo.JPG" alt="" />
								</div>
							</div>
							<div class="fix single_latest_post"><a>ACTUALITE</a> </div>
							<div class="fix single_latest_post">
								<div class="fix latest_post_img floatleft">
									<img src="Assets/images/blog_post_img.png" alt="" />
								</div>
								<div class="fix latest_post_title floatright">
									<h2>
										<a href="">première information</a>
									</h2>
									<span>August 4 2010</span>
									<p>Mettre le commentaire...</p>
									<a href="">détail</a>
								</div>
							</div>
							<div class="fix single_latest_post">
								<div class="fix latest_post_img floatleft">
									<img src="Assets/images/blog_post_img.png" alt="" />
								</div>
								<div class="fix latest_post_title floatright">
									<h2>
										<a href="">deuxième information</a>
									</h2>
									<span>August 4 2010</span>
									<p>Mettre le commentaire...</p>
									<a href="">détail</a>
								</div>
							</div>
							
						</div>
					</div>
				</div>
				<div class="sidebar floatright">
					<div class="fix single_sidebar">
						<form class="row" role="search">
							<div class="div col-xs-8">
								<input type="text" class="form-control" placeholder="Rechercher">
							</div>
							<button type="submit" class="MySearch btn btn-info col-xs-4">Valider</button>
						</form>

					</div>
					<div class="fix single_sidebar"></div>
					<div class="fix single_sidebar">
							<a>LES POSTES RECENTS</a>
						<ul>
							<li><a href="">En attente de post</a></li>
							<li><a href="">En attente de post</a></li>
							<li><a href="">En attente de post</a></li>
							<li><a href="">En attente de post</a></li>
							<li><a href="">En attente de post</a></li>
						</ul>
					</div>


					<div class="fix single_sidebar ">
				
							<a>ETUDIANTS</a>
							<ul>
								<li><a href="">Post pour étudiant</a></li>
								<li><a href="">Post pour étudiant</a></li>
								<li><a href="">Post pour étudiant</a></li>
								<li><a href="">Post pour étudiant</a></li>
							</ul>
					</div>
				</div>
			</div>
			<div class="fix scroll_to_top">
				<a href="#scroll_top" class="floatright">Remonter </a>
			</div>
		</div>
	</div>
	</section>
	<section id="footer_top_area">
	<div class="fix footer_top center">
		<div class="fix footer_top_container">
			<div>
				<ul class="col-xs-12">
					<li class="col-xs-2 myFooter"><a href=""><span>A
								propos</span></a></li>
					<li class="col-xs-2 myFooter"><a href=""><span>Nous
								contacter</span></a></li>
					<li class="col-xs-2 myFooter"><a href=""><span>Aide</span></a></li>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<section id="footer_bottom_area">
	<div class="fix footer_bottom center">
		<div class="fix copyright floatleft">
			<p>&#169 2015 CEAMITIC</p>
		</div>
		<div class="fix footer_bottom_text floatright">
			<p>
				<a href="http://www.ceamitic.sn" title="Site web du centre"
					target="_blank">www.ceamitic.sn</a>
			</p>
		</div>
	</div>
	</section>
	<script src="http://code.jquery.com/jquery.js"></script>
	<!-- Jessor slider Start-->
	<script type="text/javascript" src="Assets/js/jssor.core.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.utils.js"></script>
	<script type="text/javascript" src="Assets/js/jssor.slider.js"></script>
	<script>
		jQuery(document)
				.ready(
						function($) {
							var options = {
								$AutoPlay : true, //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
								$AutoPlayInterval : 4000, //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
								$SlideDuration : 500, //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
								$DragOrientation : 3, //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)

								$ThumbnailNavigatorOptions : {
									$Class : $JssorThumbnailNavigator$, //[Required] Class to create thumbnail navigator instance
									$ChanceToShow : 2, //[Required] 0 Never, 1 Mouse Over, 2 Always

									$Loop : 2, //[Optional] Enable loop(circular) of carousel or not, 0: stop, 1: loop, 2 rewind, default value is 1
									$SpacingX : 3, //[Optional] Horizontal space between each thumbnail in pixel, default value is 0
									$SpacingY : 3, //[Optional] Vertical space between each thumbnail in pixel, default value is 0
									$DisplayPieces : 6, //[Optional] Number of pieces to display, default value is 1
									$ParkingPosition : 204, //[Optional] The offset position to park thumbnail,

									$ArrowNavigatorOptions : {
										$Class : $JssorArrowNavigator$, //[Requried] Class to create arrow navigator instance
										$ChanceToShow : 2, //[Required] 0 Never, 1 Mouse Over, 2 Always
										$AutoCenter : 2, //[Optional] Auto center arrows in parent container, 0 No, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
										$Steps : 6
									}
								}
							};

							var jssor_slider1 = new $JssorSlider$(
									"slider1_container", options);

							//responsive code begin
							//you can remove responsive code if you don't want the slider scales while window resizes
							function ScaleSlider() {
								var parentWidth = jssor_slider1.$Elmt.parentNode.clientWidth;
								if (parentWidth)
									jssor_slider1.$SetScaleWidth(Math.min(
											parentWidth, 980));
								else
									window.setTimeout(ScaleSlider, 30);
							}

							ScaleSlider();

							if (!navigator.userAgent
									.match(/(iPhone|iPod|iPad|BlackBerry|IEMobile)/)) {
								$(window).bind('resize', ScaleSlider);
							}
						});
	</script>
	<!-- JS -->
	<script type="text/javascript" src="Assets/js/selectnav.min.js"></script>
	<script type="text/javascript" src="Assets/js/jquery.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="Assets/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			$("#pop").popover({
				placement : 'bottom'
			});
		});
	</script>
	<script type="text/javascript">
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
	</script>
	<script type="text/javascript">
		$(function() {
			$('a[href*=#]:not([href=#])')
					.click(
							function() {
								if (location.pathname.replace(/^\//, '') == this.pathname
										.replace(/^\//, '')
										&& location.hostname == this.hostname) {
									var target = $(this.hash);
									target = target.length ? target
											: $('[name=' + this.hash.slice(1)
													+ ']');
									if (target.length) {
										$('html,body').animate({
											scrollTop : target.offset().top
										}, 1000);
										return false;
									}
								}
							});
		});
	</script>

</body>
</html>
