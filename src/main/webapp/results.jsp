<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <title>CoSpace - Coworking Space Website Template</title>
    <link rel="icon" href="images/icon.png" type="image/gif" sizes="16x16">
    <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="CoSpace - Coworking Space Website Template" name="description" />
    <meta content="" name="keywords" />
    <meta content="" name="author" />
    <!-- CSS Files
    ================================================== -->
    <link id="bootstrap" href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link id="bootstrap-grid" href="css/bootstrap-grid.min.css" rel="stylesheet" type="text/css" />
    <link id="bootstrap-reboot" href="css/bootstrap-reboot.min.css" rel="stylesheet" type="text/css" />
    <link href="css/animate.css" rel="stylesheet" type="text/css" />
    <link href="css/owl.carousel.css" rel="stylesheet" type="text/css" />
    <link href="css/owl.theme.css" rel="stylesheet" type="text/css" />
    <link href="css/owl.transitions.css" rel="stylesheet" type="text/css" />
    <link href="css/magnific-popup.css" rel="stylesheet" type="text/css" />
    <link href="css/jquery.countdown.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <!-- color scheme -->
    <link id="colors" href="css/colors/scheme-01.css" rel="stylesheet" type="text/css" />
    <link href="css/coloring.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="wrapper">
    <div id="preloader">
        <div class="preloader1"></div>
    </div>
    <!-- header begin -->
    <header class="transparent scroll-light">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="de-flex sm-pt10">
                        <div class="de-flex-col">
                            <div class="de-flex-col">
                                <!-- logo begin -->
                                <div id="logo">
                                    <a href="index.html">
                                        <img alt="" class="logo" src="images/logo-light.png" />
                                        <img alt="" class="logo-2" src="images/logo.png" />
                                    </a>
                                </div>
                                <!-- logo close -->
                            </div>
                            <div class="de-flex-col">
                            </div>
                        </div>
                        <div class="de-flex-col header-col-mid">
                            <!-- mainmenu begin -->
                            <ul id="mainmenu">
                                <li>
                                    <a href="index.jsp">Home<span></span></a>
                                </li>
                                <li>
                                    <a href="locations.html">Stream<span></span></a>
                                    <ul>
                                        <li><a href="locations.html">Streaming now</a></li>
                                        <li><a href="search-result.html">Highlights</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="news.jsp">News<span></span></a>
                                </li>
                                <li>
                                    <a href="events.html">Events<span></span></a>
                                </li>
                                <li>
                                    <a href="schedules.jsp">Schedules<span></span></a>

                                </li>
                            </ul>
                        </div>
                        <div class="de-flex-col">
                            <div class="menu_side_area">
                                <a href="login.html" class="btn-main"><i class="fa fa-sign-in"></i><span>Log In</span></a>
                                <span id="menu-btn"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- header close -->
    <!-- content begin -->
    <div class="no-bottom no-top" id="content">
        <div id="top"></div>

        <!-- section begin -->
        <section id="subheader" class="text-light" data-bgimage="url(images/background/subheader.jpg) top">
            <div class="center-y relative text-center">
                <div class="container">
                    <div class="row">

                        <div class="col-md-12 text-center">
                            <h1>Results</h1>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
        </section>
        <!-- section close -->

        <!-- section begin -->
        <section id="section-locations" class="no-top">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-12">
                        <div class="text-center">
                            <h2>Results</h2>
                            <div class="small-border bg-color-2"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">

                                    <h5 class="mt-0">Results Table</h5>
                                    <p class="sub-header">Inline edit like a spreadsheet, toolbar column with edit button only and without focus on first input.</p>
                                    <div class="table-responsive">
                                        <table class="table table-centered mb-0" id="table-news">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Sports Name</th>
                                                <th>Winner's name</th>
                                                <th>Country</th>
                                                <th>Merdal</th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                            <c:set var="countRepre3" value="0" scope="page"/>
                                            <c:forEach var="results" items="${resultsInfo}">
                                            <c:set var="countRepre3" value="${countRepre3+1}" scope="page"/>
                                                <tr>
                                                    <td>${countRepre3}</td>
                                                    <td>${results.sportTitle}</td>
                                                    <td>${results.winnersName}</td>
                                                    <td>${results.country}</td>


                                                    <td>
                                                        <img src="images/${results.country}.jpg" class="rounded-circle" alt="">
                                                        <span>${results.country}</span>
                                                    </td>
                                                    <td>${results.medal}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div> <!-- end .table-responsive-->
                                </div> <!-- end card-body -->
                            </div> <!-- end card -->
                        </div> <!-- end col -->
                    </div> <!-- end row -->
                </div>
            </div>
        </section>

    </div>
    <!-- content close -->

    <a href="#" id="back-to-top"></a>

    <!-- footer begin -->
    <footer class="footer-light">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-xs-1">
                    <div class="widget">
                        <h5>Plans</h5>
                        <ul>
                            <li><a href="#">Private Office</a></li>
                            <li><a href="#">Coworking Space</a></li>
                            <li><a href="#">Virtual Office</a></li>
                            <li><a href="#">Meeting Room</a></li>
                            <li><a href="#">Dedicated Desk</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-1">
                    <div class="widget">
                        <h5>Company</h5>
                        <ul>
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">News</a></li>
                            <li><a href="#">Jobs</a></li>
                            <li><a href="#">Franchise</a></li>
                            <li><a href="#">Contact</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-1">
                    <div class="widget">
                        <h5>Events</h5>
                        <ul>
                            <li><a href="#">Jump Start Your Bussines</a></li>
                            <li><a href="#">Web Development Meet Up</a></li>
                            <li><a href="#">Envato Summer Meet Up</a></li>
                            <li><a href="#">Dribbble Meet Up Sydney</a></li>
                            <li><a href="#">International Education Expo</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 col-xs-1">
                    <div class="widget">
                        <h5>Newsletter</h5>
                        <p>Signup for our newsletter to get the latest news in your inbox.</p>
                        <form action="blank.php" class="row form-dark" id="form_subscribe" method="post" name="form_subscribe">
                            <div class="col text-center">
                                <input class="form-control" id="txt_subscribe" name="txt_subscribe" placeholder="enter your email" type="text" /> <a href="#" id="btn-subscribe"><i class="arrow_right bg-color-secondary"></i></a>
                                <div class="clearfix"></div>
                            </div>
                        </form>
                        <div class="spacer-10"></div>
                        <small>Your email is safe with us. We don't spam.</small>
                    </div>
                </div>
            </div>
        </div>
        <div class="subfooter">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="de-flex">
                            <div class="de-flex-col">
                                <a href="index.html">
                                    <img alt="" class="f-logo" src="images/logo.png" /><span class="copy">&copy; Copyright 2021 - CoSpace by Designesia</span>
                                </a>
                            </div>
                            <div class="de-flex-col">
                                <div class="social-icons">
                                    <a href="#"><i class="fa fa-facebook fa-lg"></i></a>
                                    <a href="#"><i class="fa fa-twitter fa-lg"></i></a>
                                    <a href="#"><i class="fa fa-linkedin fa-lg"></i></a>
                                    <a href="#"><i class="fa fa-pinterest fa-lg"></i></a>
                                    <a href="#"><i class="fa fa-rss fa-lg"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- footer close -->

</div>


<!-- Javascript Files
================================================== -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.isotope.min.js"></script>
<script src="js/easing.js"></script>
<script src="js/owl.carousel.js"></script>
<script src="js/OwlCarousel2Thumbs.min.js"></script>
<script src="js/validation.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/enquire.min.js"></script>
<script src="js/jquery.plugin.js"></script>
<script src="js/jquery.countTo.js"></script>
<script src="js/jquery.countdown.js"></script>
<script src="js/jquery.lazy.min.js"></script>
<script src="js/jquery.lazy.plugins.min.js"></script>
<script src="js/jquery.smartsticky.min.js"></script>
<script src="js/designesia.js"></script>


</body>

</html>