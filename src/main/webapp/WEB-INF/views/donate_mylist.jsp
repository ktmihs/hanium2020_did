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

  <!-- Custom styles for this page -->
  <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

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
          <div class="card col-lg-7 o-hidden border-0 shadow-lg my-5" style="margin:auto">
            <div class="card-body p-0">
              <!-- Nested Row within Card Body -->
              <div class="row">
                <!-- <div class="col-lg-5 d-none d-lg-block bg-register-image"></div> -->
                <div class="col-lg-12">
                  <div class="p-5">
                    <div class="text-center">
                      <h1 class="h3 text-gray-900 mb-4">기부내역</h1>
                    </div>
                      <hr class="mt-4">
                        <!-- donate list datatable -->
                        <div class="table-responsive">

<<<<<<< HEAD
                          <table class="table table-hover" id="datatable" width="100%" cellspacing="0">
                            <tr>
                              <th>no</th>
                              <th>요청글</th>
                              <th>기부 날짜</th>
                              <th>기부량</th>
                            </tr>
                            <c:forEach var="donate"  items = "${donate}"   varStatus="status">
                               <tr onclick="location.href='/request_detail_donor/${donate.request.reqId}'" style="cursor:pointer">
                                 <td>${status.count}</td>
                                 <td>${donate.request.reqTitle}</td>
                                 <td>${donate.donateDate}</td>
                                 <td>${donate.donateAmount}</td>
                               </tr>
                            </c:forEach>
                          </table>
=======
                          <table class="table" id="datatable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>no</th>
                                            <th>기부날짜</th>
                                            <th>헌혈증 번호</th>
                                            <th>사용</th>
                                            <th>사용날짜</th>
                                            <th>사용처</th>
                                        </tr>
                                      </thead>
                                      <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>20.2.1</td>
                                            <td>01-01-123456</td>
                                            <td>o</td>   <!-- 사용시 소문자 o, 미사용시 소문자 x -->
                                            <td>20.2.9</td>
                                            <td>아산병원</td>
                                        </tr>
                                         <c:forEach items = "${donateA}" var="donate">
                                            <tr>
                                              <td nowrap></td>
                                              <td nowrap></td>
                                              <td nowrap>${donate.donateAmount}</td>
                                              <td nowrap>${donate.donateId.reqId}</td>
                                              <td nowrap>${donate.donateDate}</td>
                                            </tr>
                                         </c:forEach>
                                        <tr>
                                            <td>2</td>
                                            <td>20.2.2</td>
                                            <td>01-01-123457</td>
                                            <td>o</td>
                                            <td>20.2.4</td>
                                            <td>세브란스병원</td>
                                        </tr>

                                        <tr>
                                          <td>3</td>
                                          <td>20.7.1</td>
                                          <td>01-01-123458</td>
                                          <td>o</td>
                                          <td>20.7.15</td>
                                          <td>세브란스병원</td>
                                        </tr>

                                        <tr>
                                          <td>4</td>
                                          <td>20.7.28</td>
                                          <td>01-01-123459</td>
                                          <td>x</td>
                                          <td></td>
                                          <td>아산병원</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
                        </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
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
  <script src="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>
  <!-- Page level custom scripts -->
  <script src="${pageContext.request.contextPath}/resources/js/demo/chart-area-demo.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/demo/chart-pie-demo.js"></script>

</body>

</html>
