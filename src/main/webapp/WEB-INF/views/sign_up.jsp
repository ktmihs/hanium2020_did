<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">
            <!-- Sign up, logout -->
            <div style="width:100%; margin:auto; ">
              <li class="mb-1" style="height: 30%; margin-left: 1rem;  margin-right:1rem; width: 80%;  text-align: center; ">
                <a href="/profile_pre" class="d-none d-sm-inline-block  w-100  nav-link" style="padding: 0; background-color: #718FE9; color: white;"> <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-200"></i> Profile</a>
              </li>
              <li style="height: 20%; margin-left: 1rem;  width: 80%;    text-align: center; ">
                <c:if test="${empty userSession}">
                  <a href="/login" class="d-none d-sm-inline-block  w-100 nav-link " style="padding: 0; background-color: #718FE9; color: white;"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-200"></i> Login</a>
                </c:if>
                <c:if test="${!empty userSession}">
                  <a href="/logout" class="d-none d-sm-inline-block  w-100 nav-link " style="padding: 0; background-color: #718FE9; color: white;"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-200"></i> Logout</a>
                </c:if>
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
                      <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
                    </div>
                    <hr>
                    <form:form modelAttribute="accountForm" action="/sign_up" class="user"  method="post">
                      <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">회원 유형</p>
                          <form:select path="group" class="dropdown form-control col-sm-12 mb-sm-0" style="margin-right:10px;" >
                            <div class="dropdown-menu col-sm-6 animated--fade-in" style="">
                              <option class="dropdown-item" style=" padding: 0.25rem 1.5rem;" value="x">개인</option>
                              <option class="dropdown-item" style=" padding: 0.25rem 1.5rem;" value="o">기업</option>
                            </div>
                          </form:select>
                        </div>
                        <div class="col-sm-6">
                          <p class="col-sm-6" style="margin:1px;font-size: 1rem;">성별</p>
                          <form:select path="gender" class="dropdown form-control col-sm-12 mb-sm-0"  >
                            <div class="dropdown-menu col-sm-6 animated--fade-in" >
                              <option class="dropdown-item" value="1">여자</option>
                              <option class="dropdown-item" value="2">남자</option>
                            </div>
                          </form:select>
                        </div>
                      </div>
                      <div class="form-group row">
                      <div class="col-sm-6 mb-3 mb-sm-0">
                         <form:input class="form-control form-control-user" path="userId" placeholder="아이디 *"/>
                       </div>
                        <div class="col-sm-6 mb-3 mb-sm-0">
                          <form:input class="form-control form-control-user" path="name" placeholder="이름 *"/>
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="col-sm-6">
                          <form:input class="form-control form-control-user" path="birth" placeholder="생년월일(ex 19980518) *"/>
                        </div>
                      </div>
                      <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                          <form:password class="form-control form-control-user" path="password" placeholder="비밀번호 *"/>
                        </div>
                        <div class="col-sm-6">
                          <form:password class="form-control form-control-user" path="checkPassword" placeholder="비밀번호 확인 *"/>
                        </div>
                      </div>

                      <div class="form-group">
                        <form:input class="form-control form-control-user" path="address" placeholder="주소"/>
                      </div>
                      <div class="form-group">
                        <form:input class="form-control form-control-user" path="phone" placeholder="전화번호"/>
                      </div>
                      <div class="form-group">
                        <form:input class="form-control form-control-user" path="email" placeholder="이메일 *"/>
                      </div>
                      <input type="submit" value="회원가입" class="btn btn-primary btn-user btn-block">
                    </form:form>
                    <hr>
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
