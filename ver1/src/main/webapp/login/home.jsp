<!DOCTYPE html>
<html lang="en">
<head>
  <title>SYSTEM</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style>
    .fakeimg {
      height: 200px;
      background: #aaa;
    }
  </style>
</head>
<body>
<div>
  <table>
    <tr>
      <td>Welcome: ${username}</td>
      <td><a href="/login">Log out</a></td>
    </tr>
  </table>
  
</div>
<div class="jumbotron text-center" style="margin-bottom:0">
  <h1>MANAGEMENT SYSTEM</h1>
  <p STYLE="font-size: 50px">LIBRARY ASAHI</p>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="#">HOME PAGE</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/books">SHOW ALL</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">KIND OF BOOK</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">AUTHOR</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">YEAR PUBLISHING</a>
      </li>
    </ul>
  </div>
</nav>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <h4>COURT EVERYONE</h4>
      <div class="fakeimg">
        <img src="https://suno.vn/blog/wp-content/uploads/2015/11/xu-huong-marketing.jpg" width="350px" height="200px">
      </div>
      <p>Appreciate books, read books every day and choose books as your companions on your way to success is the message that the Book Festival 2018 at the National Library of Vietnam wants to convey to all. you read.</p>
      <h3>Popular Newspaper Web</h3>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="https://designmagazines.net">Magazine</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="https://dtruyen.com">Story</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="https://edition.cnn.com">World Book</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="https://ebook.vn">EBook</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-8">
      <h2>BOOK STORE</h2>
      <div class="fakeimg">
        <img src="https://bcp.cdnchinhphu.vn/Uploaded/hoangtrongdien/2020_04_07/thu%20vien.jpg" width="730px" height="200px" >
      </div>
      <p>Only books can tell us truth, perfect beauty, and love. Books are a unique mobile magic... There are so many great quotes about books and perhaps no words can fully express the importance, benefits, and value of books. Let's refer to a few good quotes about the book below to share your feelings</p>
      <br>
      <h2>LIBRARY WORLD</h2>
      <div class="fakeimg">
        <img src="https://cdn.thukyluat.vn//uploads/NewsThumbnail/2020/08/28/224739Quy-dinh-tieu-chi-xac-dinh-khong-gian-doc-phong-doc-co-so-cua-thu-vien.jpg" width="730px" height="200px">
      </div>
      <p>I walked into the library and closed the door. Thus I have separated from greed, pride, drunkenness and laziness, and all the vices born of ignorance, idleness, and self-loathing. I bask in the eternity among wonderful authors with a pride, with a sense of satisfaction that I feel pity for all the rich and luxurious mandarins who do not enjoy this happiness.</p>
    </div>
  </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
  <p>We Love Books</p>
</div>

</body>
</html>