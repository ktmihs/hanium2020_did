<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>전자 헌혈증 관리 서비스</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">



  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column" >

    <!-- Main Content -->
    <div id="content">

      <!-- Topbar -->
      <nav style="background-color: #718FE9; height: 100px;"class="navbar navbar-expand navbar-light  topbar static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
          <i class="fa fa-bars"></i>
        </button>

        <!-- Page Title -->
        <div>
          <h1 class="h3 mb-0 text-gray-200" style="margin-left: 2rem;">Blood donation certificate issuance service</h1>
        </div>
        <!-- End of Page title -->


        <!-- Topbar Search -->
        <!-- <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
          <div class="input-group">
            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
            <div class="input-group-append">
              <button class="btn btn-primary" type="button">
                <i class="fas fa-search fa-sm"></i>
              </button>
            </div>
          </div>
        </form> -->

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

          <!-- Sign up, logout -->
          <div style="width:100%; margin:auto; ">
            <li class="mb-1" style="height: 30%; margin-left: 1rem;  margin-right:1rem; width: 80%;  text-align: center; ">
              <!-- <h4 class=" mb-0 text-gray-200" >  Donate</h4> -->
              <a href="#" class="d-none d-sm-inline-block  w-100  nav-link" style="padding: 0; background-color: #718FE9; color: white;"> <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-200"></i> Profile</a>
            </li>
            <li style="height: 20%; margin-left: 1rem;  width: 80%;    text-align: center; ">
              <!-- <h4 class=" mb-0 text-gray-200" >  Donate</h4> -->
              <a href="#" class="d-none d-sm-inline-block  w-100 nav-link " style="padding: 0; background-color: #718FE9; color: white;"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-200"></i> Logout</a>
            </li>
          </div>

          <div class="topbar-divider d-none d-sm-block"></div>
        </ul>

      </nav>
      <!-- End of Topbar -->

        <!-- Topbar2 -->
        <div class="navbar navbar-expand navbar-light topbar mb-4 shadow" style="background-color:#9FB4F3;">
          <div style="margin-right: 2rem; margin-left: 2rem; width: 150%;  text-align: center; float: left;">
            <h4 class=" mb-0 text-gray-200">  </h4>
          </div>
          <div style="height: 90%;margin-left: 2rem;  width: 150%;  text-align: center; float: left;">
             <a href="/my_blood_list" class="d-none d-sm-inline-block h-100 w-100 btn" style="color: white;"><h4> Enroll</h4></a>
          </div>
          <div style="height: 90%; margin-left: 2rem; width: 150%;  text-align: center; float: left;">
             <a href="/request_list" class="d-none d-sm-inline-block h-100 w-100 btn" style="color: white;"><h4> Donate</h4></a>
          </div>
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
          </div>
          <div style="margin-right: 2rem; margin-left: 2rem; width: 150%; text-align: center; float: left;">
            <h4 class=" mb-0 text-gray-200">  </h4>
          </div>
        </div>
        <!-- End of Topbar2 -->

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <!-- Page Heading -->
        <!-- <div class="d-sm-flex align-items-center justify-content-between mb-4">
          <h1 class="h3 mb-0 text-gray-800">회원가입</h1>

        </div> -->

        <div class="card col-lg-7 o-hidden border-0 shadow-lg my-5"style="margin:auto">
          <div class="card-body p-0" >
            <!-- Nested Row within Card Body -->
            <div class="row">
              <!-- <div class="col-lg-5 d-none d-lg-block bg-register-image"></div> -->
              <div class="col-lg-12">
                <div class="p-5">
                  <div class="text-center">
                    <h3 class="h3 text-gray-900 mb-4" >전자 헌혈증 발급</h3>
                  </div>
                  <hr>
                  <form class="user">
                    <div class="col-md-12">
                      <p align="right">*필수입력사항</p>

                      <div class="form-group row">
                        <div class="col-sm-12 mb-3 mb-sm-0">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">헌혈 증서 번호 *</p>
                          <input type="text" class="form-control form-control-user" id="bdid" placeholder="헌혈 증서 번호">
                        </div>
                      </div>

                      <div class="form-group row">
                        <div class="col-sm-6">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">성명 *</p>
                          <input type="text" class="form-control form-control-user" id="name" placeholder="사용자 실명">
                        </div>
                        <div class="col-sm-6">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">생년월일 *</p>
                          <input type="text" class="form-control form-control-user" id="birth" placeholder="사용자 생년월일">
                        </div>
                      </div>

                      <div class="form-group row">
                        <div class="col-sm-6">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">헌혈 종류 *</p>
                          <select class="dropdown form-control  col-sm-12 mb-sm-0" style="border-radius: 50px; height: 50px;">
                            <div class="dropdown-menu col-sm-6 animated--fade-in" >
                              <option class="dropdown-item" value="general">전혈</option>
                              <option class="dropdown-item" value="particular">성분헌혈</option>
                            </div>
                          </select>
                        </div>

                        <div class="col-sm-6">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">헌혈 용량 *</p>
                          <input type="text" class="form-control form-control-user" id="bdAmount" placeholder="헌혈 용량">
                        </div>
                      </div>

                      <div class="form-group row">
                        <div class="col-sm-6">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">성별 *</p>
                          <select class="dropdown form-control col-sm-12 mb-sm-0" style="border-radius: 50px; height: 50px;" >
                            <div class="dropdown-menu col-sm-6 animated--fade-in" >
                              <option class="dropdown-item" value="woman">여자</option>
                              <option class="dropdown-item" value="man">남자</option>
                            </div>
                          </select>
                        </div>
                      </div>

                      <div class="form-group row">
                        <div class="col-sm-6">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">헌혈 일자 *</p>
                          <input type="text" class="form-control form-control-user" id="bdDate" placeholder="헌혈 일자">
                        </div>
                        <div class="col-sm-6">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">혈액원명 *</p>
                          <select class="dropdown form-control col-sm-12 mb-sm-0" style="border-radius: 50px; height: 50px;">
                            <div class="dropdown-menu col-sm-6 animated--fade-in" >
                              <option class="dropdown-item" value="gangso">강서혈액원</option>
                              <option class="dropdown-item" value="inchun">인천혈액원</option>
                            </div>
                          </select>
                        </div>
                      </div>
                    </div>
                  </form>
                  <div class="form-group row">
                    <div class="col-sm-2">
                      <a href="#" class="btn  text-white btn-danger btn-block" style="border-radius: 50px;"><i class="fas fa-trash" style="margin-right:0.5rem;"></i> 취소  </a>
                      <!-- <button type="text" class=" btn form-control bg-primary-400 form-control-user"  style="border:1px solid red; text-align:center;" > <p style="border:1px solid red; text-align:center; vertical-align: middle;" >중복확인</p></button> -->
                    </div>
                    <div>
                      <a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    </div>
                    <div class="col-sm-2">
                      <a href="#" class="btn  text-white btn-success btn-block" style="border-radius: 50px; width: 130px;"> <i class="fas fa-check" style="margin-right:0.5rem;"></i>발급요청  </a>
                      <!-- <button type="text" class=" btn form-control bg-gray-400 form-control-user"  style="border:1px solid red; text-align:center;" > <p style="border:1px solid red; text-align:center; vertical-align: middle;" >중복확인</p></button> -->
                    </div>
                  </div>

                  <!-- <div class="text-center">
                    <a class="small" href="forgot-password.html">Forgot Password?</a>
                  </div>
                  <div class="text-center">
                    <a class="small" href="login.html">Already have an account? Login!</a>
                  </div> -->
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
      <!-- /.container-fluid -->

    </div>
    <!-- End of Main Content -->






    <!-- Footer -->
    <footer class="sticky-footer bg-white">
      <div class="container my-auto">
        <div class="copyright text-center my-auto">
          <span>Copyright &copy; Your Website 2020</span>
        </div>
      </div>
    </footer>
    <!-- End of Footer -->

  </div>
  <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">×</span>
        </button>
      </div>
      <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
      <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
        <a class="btn btn-primary" href="login.html">Logout</a>
      </div>
    </div>
  </div>
</div>

<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="${pageContext.request.contextPath}/resources/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="${pageContext.request.contextPath}/resources/js/demo/chart-area-demo.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/demo/chart-pie-demo.js"></script>

</body>

</html>
