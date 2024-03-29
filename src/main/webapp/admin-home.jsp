
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <!-- color scheme -->
    <link id="colors" href="css/colors/scheme-01.css" rel="stylesheet" type="text/css" />
    <link href="css/coloring.css" rel="stylesheet" type="text/css" />

    <style>
        .containers{
            height: 350px;
            width: 430px;
            position: relative;
        }
        .containers .wrappers21{
            position: relative;
            height: 300px;
            width: 100%;
            border-radius: 10px;
            background: #fff;
            border: 2px dashed #c2cdda;
            display: flex;
            align-items: center;
            justify-content: center;
            overflow: hidden;
        }
        .wrappers21.active{
            border: none;
        }
        .wrappers21 .images{
            position: absolute;
            height: 100%;
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .wrappers21 img{
            height: 100%;
            width: 100%;
            object-fit: cover;
        }
        .wrappers21 .icon{
            font-size: 100px;
            color: #aaafac;
        }
        .wrappers21 .text{
            font-size: 20px;
            font-weight: 500;
            color: #5B5B7B;
        }
        .wrappers21 #cancel-btn21 i{
            position: absolute;
            font-size: 20px;
            right: 15px;
            top: 15px;
            color: #aaafac;
            cursor: pointer;
            display: none;
        }
        .wrappers21.active:hover #cancel-btn21 i{
            display: block;
        }
        .wrappers21 #cancel-btn21 i:hover{
            color: #e74c3c;
        }
        .wrappers21 .file-name{
            position: absolute;
            bottom: 0px;
            width: 100%;
            padding: 8px 0;
            font-size: 18px;
            color: #fff;
            display: none;
            background: linear-gradient(135deg,#aaafac 0%,#aaafac 100%);
        }
        .wrappers21.active:hover .file-name{
            display: block;
        }
        .containers #custom-btn{
            margin-top: 30px;
            display: block;
            width: 100%;
            height: 50px;
            border: none;
            outline: none;
            border-radius: 25px;
            color: #fff;
            font-size: 18px;
            font-weight: 500;
            letter-spacing: 1px;
            text-transform: uppercase;
            cursor: pointer;
            background: linear-gradient(135deg,#aaafac 0%,#aaafac 100%);
        }
        ***********************************

        .containers .wrappers22{
            position: relative;
            height: 300px;
            width: 100%;
            border-radius: 10px;
            background: #fff;
            border: 2px dashed #c2cdda;
            display: flex;
            align-items: center;
            justify-content: center;
            overflow: hidden;
        }
        .wrappers22.active{
            border: none;
        }
        .wrappers22 .images{
            position: absolute;
            height: 100%;
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .wrappers22 img{
            height: 100%;
            width: 100%;
            object-fit: cover;
        }
        .wrappers22 .icon{
            font-size: 100px;
            color: #aaafac;
        }
        .wrappers22 .text{
            font-size: 20px;
            font-weight: 500;
            color: #5B5B7B;
        }
        .wrappers22 #cancel-btn22 i{
            position: absolute;
            font-size: 20px;
            right: 15px;
            top: 15px;
            color: #aaafac;
            cursor: pointer;
            display: none;
        }
        .wrappers22.active:hover #cancel-btn22 i{
            display: block;
        }
        .wrappers22 #cancel-btn22 i:hover{
            color: #e74c3c;
        }
        .wrappers22 .file-name{
            position: absolute;
            bottom: 0px;
            width: 100%;
            padding: 8px 0;
            font-size: 18px;
            color: #fff;
            display: none;
            background: linear-gradient(135deg,#aaafac 0%,#aaafac 100%);
        }
        .wrappers22.active:hover .file-name{
            display: block;
        }

    </style>
</head>

<body>
<div id="wrapper">
    <div id="preloader">
        <div class="preloader1"></div>
    </div>
    <!-- header begin -->
    <header class="transparent header-light scroll-light">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="de-flex sm-pt10">
                        <div class="de-flex-col">
                            <div class="de-flex-col">
                                <!-- logo begin -->
                                <div id="logo">
                                    <a href="index.jsp">
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
                                <a href="login.jsp" class="btn-main"><i class="fa fa-sign-in"></i><span>Log In</span></a>
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

        <!-- section Functions open-->
        <section id="section-intro">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="text-center">
                            <h2>Functions</h2>
                            <div class="small-border bg-color-2"></div>
                        </div>
                    </div>

                        <div class="container" style="text-align: center">
                            <div class="row">
                                <div class="col-md-4 mb60">

                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-primary" onclick="cleanNews()" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                        News
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">News</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form method="post" action="ServletOlympics" name="contactForm"  enctype="multipart/form-data"  id='news' class="form-border">
                                                            <input type="hidden" name="command" value="News">
                                                        <input type="hidden" id="actionNews" name="action" value="uploading">
                                                            <input type="hidden" id="idNews" name="id" value="0">
                                                        <div class="row">

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>News Title:</label>
                                                                    <input type='text' name='newsTitle' id='newsTitle' class="form-control" value="${user_acc.full_name}">
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>Image:</label>
                                                                    <input type='text' name='Image' id='imageNew' class="form-control" value="${user_acc.email}">
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>Date:</label>
                                                                    <input type='datetime-local' name='date' id='dateNews' class="form-control" placeholder="select Date">
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>Context:</label>
                                                                    <textarea type='text' name='context' id='contextNews' class="form-control"></textarea>
                                                                </div>
                                                            </div>
                                                            <div class="containers">
                                                                <div class="wrappers21">
                                                                    <div class="images">
                                                                        <img id="image21" src="" alt="">
                                                                    </div>
                                                                    <div class="content">
                                                                        <div class="icon">
                                                                            <i class="fas fa-cloud-upload-alt"></i>
                                                                        </div>
                                                                        <div class="text">
                                                                            No file chosen, yet!
                                                                        </div>
                                                                    </div>
                                                                    <div id="cancel-btn21">
                                                                        <i class="fas fa-times"></i>
                                                                    </div>
                                                                    <div class="file-name">
                                                                        File name here
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="col-md-12">

                                                                <div id='mail_success' class='success'>Your message has been sent successfully.</div>
                                                                <div id='mail_fail' class='error'>Sorry, error occured this time sending your message.</div>
                                                                <div class="clearfix"></div>

                                                            </div>

                                                        </div>
                                                        <input id="default-btn21" name="image" type="file" hidden>
                                                    </form>
                                                </div>

                                                <div class="modal-footer">
                                                    <button class="btn btn-secondary" name="21" onclick="defaultBtnActive()" type="button">Choose an image</button>
                                                    <button type="button" onclick="document.getElementById('news').submit()" class="btn btn-primary">Upload</button>
                                                </div>

                                            </div>
                                        </div>
                                    </div>

                                    <script>
                                        const wrapper = document.querySelector(".wrappers21");
                                        const fileName = document.querySelector(".file-name21");
                                        const defaultBtn = document.querySelector("#default-btn21");
                                        const customBtn = document.querySelector("#custom-btn21");
                                        const cancelBtn = document.querySelector("#cancel-btn21 i");
                                        const img = document.getElementById("image21");
                                       /// let regExp = /[0-9a-zA-Z\^\&\'\@\{\}\[\]\,\$\=\!\-\#\(\)\.\%\+\~\_ ]+$/;
                                        function defaultBtnActive(){
                                            defaultBtn.click();
                                        }
                                        defaultBtn.addEventListener("change", function(){
                                            const file = this.files[0];
                                            if(file){
                                                const reader = new FileReader();
                                                reader.onload = function(){
                                                    const result = reader.result;
                                                    img.src = result;
                                                    wrapper.classList.add("active");
                                                }
                                                cancelBtn.addEventListener("click", function(){
                                                    img.src = "";
                                                    wrapper.classList.remove("active");
                                                })
                                                reader.readAsDataURL(file);
                                            }
                                            if(this.value){
                                                let valueStore = this.value.match(regExp);
                                                fileName.textContent = valueStore;
                                            }
                                        });
                                    </script>


                                </div>

                                <div class="col-md-4 mb60">

                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" onclick="cleanEvent()" data-bs-target="#staticBackdrop">
                                        Event
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="staticBackdrop" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdropLabel">Event</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>

                                                    <form method="post" action="ServletOlympics" enctype="multipart/form-data"  name="contactForm" id='event' class="form-border">
                                                        <div class="modal-body">
                                                            <input type="hidden" name="command" value="Event">
                                                        <input type="hidden" name="action"  id="actionEvent" value="uploading">
                                                            <input type="hidden" name="id" id="idEvent" value="uploading">
                                                        <div class="row">

                                                            <div class="col-md-6">
                                                                <div class="field-set" class="dropdown style-2" >
                                                                    <label>Event Title:</label>
                                                                    <div id="item_category2" class="dropdown style-2" >
                                                                        <input name="eventTitle" class="inputing" id="sport_id2" value="Athletics" hidden>
                                                                        <a href="#" class="btn-selector" id="sportEvent" style="color: #6b6b6b">Athletics</a>
                                                                        <ul class="d-col-3">
                                                                            <li><span>Archery</span></li>
                                                                            <li><span>Athletics</span></li>
                                                                            <li><span>Artistic swimming</span></li>
                                                                            <li><span>Badminton</span></li>
                                                                            <li><span>Basketball</span></li>
                                                                            <li><span>Baseball</span></li>
                                                                            <li><span>Curling</span></li>
                                                                            <li><span>Canoe</span></li>
                                                                            <li><span>Diving</span></li>
                                                                            <li><span>Equestrian</span></li>
                                                                            <li><span>Football</span></li>
                                                                            <li><span>Fencing</span></li>
                                                                            <li><span>Futsal</span></li>
                                                                            <li><span>Gymnastics</span></li>
                                                                            <li><span>Golf</span></li>
                                                                            <li><span>Handball</span></li>
                                                                            <li><span>Hockey</span></li>
                                                                            <li><span>Ice hockey</span></li>
                                                                            <li><span>Judo</span></li>
                                                                            <li><span>Karate</span></li>
                                                                            <li><span>Luge</span></li>
                                                                            <li><span>Mountain bike</span></li>
                                                                            <li><span>Nordic combined</span></li>
                                                                            <li><span>Road cycling</span></li>
                                                                            <li><span>Rowing</span></li>
                                                                            <li><span>Rugby</span></li>
                                                                            <li><span>Shooting</span></li>
                                                                            <li><span>Sailing</span></li>
                                                                            <li><span>Surfing</span></li>
                                                                            <li><span>tennis</span></li>
                                                                            <li><span>Volleyball</span></li>
                                                                            <li><span>Water polo</span></li>
                                                                            <li><span>Wrestling</span></li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>Date:</label>
                                                                    <input type='datetime-local' name='date' id='dateEvent' class="form-control" placeholder="Select date">
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>Location:</label>
                                                                    <input type='text' name='location' id='locationEvent' class="form-control">
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>Context:</label>
                                                                    <input type='text' name='context' id='contextEvent' class="form-control">
                                                                </div>
                                                            </div>

                                                            <div class="containers">
                                                                <div class="wrappers22">
                                                                    <div class="images">
                                                                        <img id="image22" src="" alt="">
                                                                    </div>
                                                                    <div class="content">
                                                                        <div class="icon">
                                                                            <i class="fas fa-cloud-upload-alt"></i>
                                                                        </div>
                                                                        <div class="text">
                                                                            No file chosen, yet!
                                                                        </div>
                                                                    </div>
                                                                    <div id="cancel-btn22">
                                                                        <i class="fas fa-times"></i>
                                                                    </div>
                                                                    <div class="file-name">
                                                                        File name here
                                                                    </div>
                                                                </div>
                                                            </div>



                                                        </div>
                                                            <input id="default-btn22" name="image" type="file" hidden>
                                                </div>
                                                    </form>
                                                <div class="modal-footer">
                                                    <button class="btn btn-secondary" onclick="defaultBtnActive2()">Choose an image</button>
                                                    <button type="button" onclick="document.getElementById('event').submit()" class="btn btn-primary">Upload</button>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <script>
                                        const wrapper22 = document.querySelector(".wrappers22");
                                        const fileName22 = document.querySelector(".file-name22");
                                        const defaultBtn22 = document.querySelector("#default-btn22");
                                        const customBtn22 = document.querySelector("#custom-btn22");
                                        const cancelBtn22 = document.querySelector("#cancel-btn22 i");
                                        const img22 = document.getElementById("image22");
                                        let regExp = /[0-9a-zA-Z\^\&\'\@\{\}\[\]\,\$\=\!\-\#\(\)\.\%\+\~\_ ]+$/;

                                        function defaultBtnActive2(){
                                            defaultBtn22.click();
                                        }

                                        function dgf(){
                                            alert("2");
                                        }
                                        defaultBtn22.addEventListener("change", function(){
                                            const file = this.files[0];
                                            if(file){
                                                const reader = new FileReader();
                                                reader.onload = function(){
                                                    const result = reader.result;
                                                    img22.src = result;
                                                    wrapper22.classList.add("active");
                                                }
                                                cancelBtn22.addEventListener("click", function(){
                                                    img22.src = "";
                                                    wrapper22.classList.remove("active");
                                                })
                                                reader.readAsDataURL(file);
                                            }
                                            if(this.value){
                                                let valueStore = this.value.match(regExp);
                                                fileName22.textContent = valueStore;
                                            }
                                        });
                                    </script>


                                </div>


                                <div class="col-md-4 mb60">

                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" onclick="cleanResults()" data-bs-target="#exampleModalToggle2">
                                        Results
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="exampleModalToggle2" tabindex="-1" aria-labelledby="exampleModalToggle2Label" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalToggle2Label">Results</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form method="post" action="ServletOlympics" name="contactForm" enctype="multipart/form-data"  id='contact_form2' class="form-border">
                                                        <input type="hidden" name="command" value="Results">
                                                        <input type="hidden" name="action" id="actionResults" value="uploading">
                                                        <input type="hidden" name="id" id="idResults" value="uploading">
                                                        <div class="row">

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>Sports Title:</label>
                                                                    <input type='text' name='sportTitle' id='resultsSport' class="form-control" value="${user_acc.full_name}">
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>winner's name:</label>
                                                                    <input type='text' name='winnersName' id='winnerResults' class="form-control" value="${user_acc.email}">
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>Country:</label>
                                                                    <input type='text' name='country' id='countryResults' class="form-control">
                                                                </div>
                                                            </div>

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>Medal:</label>
                                                                    <input type='text' name='medal' id='medalResults' class="form-control">
                                                                </div>
                                                            </div>

                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                                    <button type="button" onclick="document.getElementById('contact_form2').submit()" class="btn btn-primary">Upload</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>




                                </div>

                                <div class="col-md-4 mb60">

                                    <!-- Button trigger modal -->
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" onclick="cleanBroadcast()" data-bs-target="#staticBackdrop1">
                                        Broadcast
                                    </button>

                                    <!-- Modal -->
                                    <div class="modal fade" id="staticBackdrop1" tabindex="-1" aria-labelledby="staticBackdrop1Label" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="staticBackdrop1Label">Broadcast</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>

                                                    <form method="post" action="ServletOlympics" name="contactForm" id='contact_form3' class="form-border">
                                                        <div class="modal-body">
                                                        <input type="hidden" name="command" value="Broadcast">
                                                        <input type="hidden" name="action" id="actionBroadcast" value="uploading">
                                                        <input type="hidden" name="id" id="idBroadcast"  value="0">
                                                        <div class="row">

                                                            <div class="col-md-6">
                                                                <div class="field-set">
                                                                    <label>Broadcast Name:</label>
                                                                    <input type='text' name='broadcast' id='broadcast' class="form-control" value="${user_acc.full_name}">
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <div class="field-set" class="dropdown style-2" >
                                                                    <label>Sport:</label>
                                                                    <div id="item_category" class="dropdown style-2" >
                                                                    <input name="sport" id="sport_id" value="Athletics" hidden>
                                                                        <a href="#" class="btn-selector" id="sportBroadcast" style="color: #6b6b6b">Athletics</a>
                                                                        <ul class="d-col-3">
                                                                            <li><span>Archery</span></li>
                                                                            <li><span>Athletics</span></li>
                                                                            <li><span>Artistic swimming</span></li>
                                                                            <li><span>Badminton</span></li>
                                                                            <li><span>Basketball</span></li>
                                                                            <li><span>Baseball</span></li>
                                                                            <li><span>Curling</span></li>
                                                                            <li><span>Canoe</span></li>
                                                                            <li><span>Diving</span></li>
                                                                            <li><span>Equestrian</span></li>
                                                                            <li><span>Football</span></li>
                                                                            <li><span>Fencing</span></li>
                                                                            <li><span>Futsal</span></li>
                                                                            <li><span>Gymnastics</span></li>
                                                                            <li><span>Golf</span></li>
                                                                            <li><span>Handball</span></li>
                                                                            <li><span>Hockey</span></li>
                                                                            <li><span>Ice hockey</span></li>
                                                                            <li><span>Judo</span></li>
                                                                            <li><span>Karate</span></li>
                                                                            <li><span>Luge</span></li>
                                                                            <li><span>Mountain bike</span></li>
                                                                            <li><span>Nordic combined</span></li>
                                                                            <li><span>Road cycling</span></li>
                                                                            <li><span>Rowing</span></li>
                                                                            <li><span>Rugby</span></li>
                                                                            <li><span>Shooting</span></li>
                                                                            <li><span>Sailing</span></li>
                                                                            <li><span>Surfing</span></li>
                                                                            <li><span>tennis</span></li>
                                                                            <li><span>Volleyball</span></li>
                                                                            <li><span>Water polo</span></li>
                                                                            <li><span>Wrestling</span></li>
                                                                        </ul>
                                                                    </div>
                                                            </div>
                                                        </div>
                                                        </div>

                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                                    <button type="submit" class="btn btn-primary">Upload</button>
                                                </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>

                                </div>



                            </div>
                        </div>
                </div>
            </div>
        </section>
        <!-- section Functions close-->

        <!-- section User Tables open-->
        <section id="section-why-choose-us" class="no-top">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-12">
                        <div class="text-center">
                            <h2>Users</h2>
                            <div class="small-border bg-color-2"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">

                                    <h5 class="mt-0">Account Users</h5>
                                    <p class="sub-header">Inline edit like a spreadsheet, toolbar column with edit button only and without focus on first input.</p>
                                    <div class="table-responsive">
                                        <table class="table table-centered mb-0" id="btn-editable">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Email</th>
                                                <th>Country</th>
                                                <th>Something</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>Tiger Nixon</td>
                                                <td>Email@gmail.com</td>
                                                <td>Country name</td>
                                                <td>2011/04/25</td>
                                                <td>
                                                    <button type="button" class="btn btn-primary btn-sm"><i class="fa fa-pencil fa-lg"></i></button>
                                                    <button type="button" class="btn btn-danger btn-sm"><i class="fa fa-trash fa-lg"></i></button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>2</td>
                                                <td>Garrett Winters</td>
                                                <td>Email@gmail.com</td>
                                                <td>Country name</td>
                                                <td>2011/07/25</td>
                                                <td>
                                                    <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModalToggl" class="btn btn-primary btn-sm"><i class="fa fa-pencil fa-lg"></i></button>
                                                    <button type="button" class="btn btn-danger btn-sm"><i class="fa fa-trash fa-lg"></i></button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>3</td>
                                                <td>Ashton Cox</td>
                                                <td>Email@gmail.com</td>
                                                <td>Country name</td>
                                                <td>2009/01/12</td>
                                                <td>
                                                    <button type="button" class="btn btn-primary btn-sm"><i class="fa fa-pencil fa-lg"></i></button>
                                                    <button type="button" class="btn btn-danger btn-sm"><i class="fa fa-trash fa-lg"></i></button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>4</td>
                                                <td>Cedric Kelly</td>
                                                <td>Email@gmail.com</td>
                                                <td>Country name</td>
                                                <td>2012/03/29</td>
                                                <td>
                                                    <button type="button" class="btn btn-primary btn-sm"><i class="fa fa-pencil fa-lg"></i></button>
                                                    <button type="button" class="btn btn-danger btn-sm"><i class="fa fa-trash fa-lg"></i></button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>5</td>
                                                <td>Airi Satou</td>
                                                <td>Email@gmail.com</td>
                                                <td>Country name</td>
                                                <td>2008/11/28</td>
                                                <td>Edit icons</td>
                                            </tr>
                                            <tr>
                                                <td>6</td>
                                                <td>Brielle Williamson</td>
                                                <td>Email@gmail.com</td>
                                                <td>Country name</td>
                                                <td>2012/12/02</td>
                                                <td>
                                                    <button type="button" class="btn btn-primary btn-sm"><i class="fa fa-pencil fa-lg"></i></button>
                                                    <button type="button" class="btn btn-danger btn-sm"><i class="fa fa-trash fa-lg"></i></button>
                                                </td>
                                            </tr>
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
        <!-- section User Tables close-->

        <!-- section news Tables open-->
        <section id="section-locations" class="no-top">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-12">
                        <div class="text-center">
                            <h2>News</h2>
                            <div class="small-border bg-color-2"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">

                                    <h5 class="mt-0">News Table</h5>
                                    <p class="sub-header">Inline edit like a spreadsheet, toolbar column with edit button only and without focus on first input.</p>
                                    <div class="table-responsive">
                                        <table class="table table-centered mb-0" id="table-news">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>News title</th>
                                                <th>Image</th>
                                                <th>Context</th>
                                                <th>Date</th>
                                                <th style="display:none;">id</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                            <c:forEach var="news" items="${newsInfo}">
                                                <c:set var="countRepre" value="${countRepre+1}" scope="page"/>
                                            <tr>
                                                <td>${countRepre}</td>
                                                <td>${news.newsTitle}</td>
                                                <td>Image</td>
                                                <td>${news.context}</td>
                                                <td>${news.date}</td>
                                                <td style="display:none;">${news.id}</td>
                                                <td>
                                                    <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModal" onclick="editNews(this)" class="btn btn-primary btn-sm"><i class="fa fa-pencil fa-lg"></i></button>
                                                    <button type="button" id="${news.id}" onclick="deleteNews(this.id);" class="btn btn-danger btn-sm"><i class="fa fa-trash fa-lg"></i></button>
                                                </td>
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
        <!-- section news Tables close-->

        <!-- section Event Tables open-->
        <section id="section-studio-type" class="no-top">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-12">
                        <div class="text-center">
                            <h2>Events</h2>
                            <div class="small-border bg-color-2"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">

                                    <h5 class="mt-0">Events Table</h5>
                                    <p class="sub-header">Inline edit like a spreadsheet, toolbar column with edit button only and without focus on first input.</p>
                                    <div class="table-responsive">
                                        <table class="table table-centered mb-0" id="">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Event title</th>
                                                <th>Image</th>
                                                <th>Location</th>
                                                <th>Date</th>
                                                <th>context</th>
                                                <th style="display:none;">id</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                            <c:set var="countRepre2" value="0" scope="page"/>
                                        <c:forEach var="event" items="${eventInfo}">
                                            <c:set var="countRepre2" value="${countRepre2+1}" scope="page"/>
                                            <tr>
                                                <td>${countRepre2}</td>
                                                <td>${event.eventTitle}</td>
                                                <td>image</td>
                                                <td>${event.location}</td>
                                                <td>${event.date}</td>
                                                <td>${event.context}</td>
                                                <td style="display:none;">${event.id}</td>
                                                <td>
                                                    <button type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="editEvent(this)"  class="btn btn-primary btn-sm"><i class="fa fa-pencil fa-lg"></i></button>
                                                    <button type="button" id="${event.id}" onclick="deleteEvent(this.id);" class="btn btn-danger btn-sm"><i class="fa fa-trash fa-lg"></i></button>
                                                </td>
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
        <!-- section news Tables close-->

        <!-- section Results Tables open-->
        <section id="section-results" class="no-top">
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
                                        <table class="table table-centered mb-0" id="result">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Sport title</th>
                                                <th>winner</th>
                                                <th>Country</th>
                                                <th>Medal</th>
                                                <th style="display:none;">id</th>
                                                <th>Action</th>
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
                                                <td>${results.medal}</td>
                                                <td style="display:none;">${results.id}</td>
                                                <td>
                                                    <button type="button" data-bs-toggle="modal" data-bs-target="#exampleModalToggle2" onclick="editResults(this)"  class="btn btn-primary btn-sm"><i class="fa fa-pencil fa-lg"></i></button>
                                                    <button type="button" id="${results.id}" onclick="deleteResults(this.id);" class="btn btn-danger btn-sm"><i class="fa fa-trash fa-lg"></i></button>
                                                </td>
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
        <!-- section Results Tables close-->

        <!-- section broadcast Tables open-->
        <section id="section-broadcast" class="no-top">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-12">
                        <div class="text-center">
                            <h2>Broadcast</h2>
                            <div class="small-border bg-color-2"></div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">

                                    <h5 class="mt-0">Broadcast Table</h5>
                                    <p class="sub-header">Inline edit like a spreadsheet, toolbar column with edit button only and without focus on first input.</p>
                                    <div class="table-responsive">
                                        <table class="table table-centered mb-0" id="broadcast1">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Broadcast Name</th>
                                                <th>Sports Name</th>
                                                <th style="display:none;">id</th>
                                                <th>Action</th>
                                            </tr>
                                            </thead>

                                            <tbody>
                                            <c:set var="countRepre4" value="0" scope="page"/>
                                            <c:forEach var="broadcast" items="${broadcastInfo}">
                                                <c:set var="countRepre4" value="${countRepre4+1}" scope="page"/>
                                            <tr>
                                                <td>${countRepre4}</td>
                                                <td>${broadcast.broadcastName}</td>
                                                <td>${broadcast.sportName}</td>
                                                <td style="display:none;">${broadcast.id}</td>
                                                <td>
                                                    <button type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop1" onclick="editBroadcast(this)" class="btn btn-primary btn-sm"><i class="fa fa-pencil fa-lg"></i></button>
                                                    <button type="button" id="${broadcast.id}" onclick="deleteBroadcast(this.id);" class="btn btn-danger btn-sm"><i class="fa fa-trash fa-lg"></i></button>
                                                </td>
                                            </tr>
                                            </c:forEach>
                                            </tbody>s
                                        </table>
                                    </div> <!-- end .table-responsive-->
                                </div> <!-- end card-body -->
                            </div> <!-- end card -->
                        </div> <!-- end col -->
                    </div> <!-- end row -->
                </div>
            </div>
        </section>
        <!-- section broadcast Tables close-->





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
                                <a href="index.jsp">
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


    <!--- deleting info-->
    <form style="display:none;" id="deleteResults" method="post" action="ServletOlympics">
        <input type="hidden" name="command" value="deleteResults">
        <input type="hidden" name="user_type" value="${userInfo.user_type}">
        <input type="hidden" name="id" id="id_results" value="">
    </form>
    <form style="display:none;" id="deleteEvent" method="post" action="ServletOlympics">
        <input type="hidden" name="command" value="deleteEvent">
        <input type="hidden" name="user_type" value="${userInfo.user_type}">
        <input type="hidden" name="id" id="id_event" value="">
    </form>
    <form style="display:none;" id="deleteNews" method="post" action="ServletOlympics">
        <input type="hidden" name="command" value="deleteNews">
        <input type="hidden" name="user_type" value="${userInfo.user_type}">
        <input type="hidden" name="id" id="id_news" value="">
    </form>
    <form style="display:none;" id="deleteBroadcast" method="post" action="ServletOlympics">
        <input type="hidden" name="command" value="deleteBroadcast">
        <input type="hidden" name="user_type" value="${userInfo.user_type}">
        <input type="hidden" name="id" id="id_broadcast" value="">
    </form>

<script>

    function deleteBroadcast(id_ts){
        document.getElementById('id_broadcast').value=id_ts;
        document.getElementById('deleteBroadcast').submit();
    }
    function deleteResults(id_ts){
        document.getElementById('id_results').value=id_ts;
        document.getElementById('deleteResults').submit();
    }
    function deleteEvent(id_ts){
        document.getElementById('id_event').value=id_ts;
        document.getElementById('deleteEvent').submit();
    }

   function deleteNews(id_ts){
        document.getElementById('id_news').value=id_ts;
        document.getElementById('deleteNews').submit();
    }

    function editNews(ctl) {
        _row = $(ctl).parents("tr");
        var cols = _row.children("td");
        $("#idNews").val($(cols[5]).text());
        $("#newsTitle").val($(cols[1]).text());
        $("#contextNews").val($(cols[3]).text());
        $("#dateNews").val($(cols[4]).text());
        $("#actionNews").val("updating");
    }
    function cleanNews(){
        $("#idNews").val('0');
        $("#newsTitle").val(null);
        $("#contextNews").val(null);
        $("#dateNews").val(null);
        $("#actionNews").val("uploading");
    }

    function editResults(ctl) {
        _row = $(ctl).parents("tr");
        var cols = _row.children("td");
        $("#idResults").val($(cols[5]).text());
        $("#resultsSport").val($(cols[1]).text());
        $("#winnerResults").val($(cols[2]).text());
        $("#countryResults").val($(cols[3]).text());
        $("#medalResults").val($(cols[4]).text());
        $("#actionResults").val("updating");
    }
    function cleanResults(){
        $("#idResults").val('0');
        $("#resultsSport").val(null);
        $("#winnerResults").val(null);
        $("#countryResults").val(null);
        $("#medalResults").val(null);
        $("#actionResults").val("uploading");
    }

    function editEvent(ctl) {
        _row = $(ctl).parents("tr");
        var cols = _row.children("td");
        $("#idEvent").val($(cols[6]).text());
        $("#sportEvent").html($(cols[1]).text());
        $("#sport_id2").val($(cols[1]).text());
        $("#locationEvent").val($(cols[3]).text());
        $("#dateEvent").val($(cols[4]).text());
        $("#contextEvent").val($(cols[5]).text());
        $("#actionEvent").val("updating");
    }
    function cleanEvent(){
        $("#idEvent").val('0');
        $("#sport_id2").val("Athletics");
        $("#sportEvent").html("Athletics");
        $("#locationEvent").val(null);
        $("#dateEvent").val(null);
        $("#contextEvent").val(null);
        $("#actionEvent").val("uploading");
    }

    function editBroadcast(ctl) {
        _row = $(ctl).parents("tr");
        var cols = _row.children("td");
        $("#idBroadcast").val($(cols[3]).text());
        $("#broadcast").val($(cols[1]).text());
        $("#sportBroadcast").html($(cols[2]).text());
        $("#sport_id").val($(cols[2]).text());
        $("#actionBroadcast").val("updating");
    }
    function cleanBroadcast(){
        $("#idBroadcast").val('0');
        $("#broadcast").val(null);
        $("#sportBroadcast").html("Athletics");
        $("#sport_id").val("Athletics");
        $("#actionBroadcast").val("uploading");
    }
</script>


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
<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>

<script>
    flatpickr("input[type=datetime-local]", {});
</script>



</body>

</html>
