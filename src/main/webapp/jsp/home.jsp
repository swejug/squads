<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="se.swejug.squads.contexts.*,se.swejug.squads.beans.*" %>
<%
   HtmlHomeContext ctx = (HtmlHomeContext) request.getAttribute(HtmlContext.ATTRIBUTE);
%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="<%=ctx.getPageAuthor()%>">
<meta name="description" content="<%=ctx.getPageDescription()%>">

<title><%=ctx.getLink().getLabel()%></title>

<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/swejug.css" rel="stylesheet">

<link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon.png">
</head>

<body>

   <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
         <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse"
               data-target=".nav-collapse">
               <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="brand" href="<%=request.getContextPath()%>">SweJUG</a>
            <div class="nav-collapse collapse">
               <ul class="nav">
               <% for (Link link : ctx.getMenu()) { %>
                  <li class="active"><a href="<%=link.getUrl()%>"><%=link.getLabel()%></a></li>
               <% } %>
               </ul>
            </div>
         </div>
      </div>
   </div>

   <div class="container">

      <h1><%=ctx.getLink().getLabel()%></h1>
      <p>
         Use this document as a way to quick start any new project.<br> All you get is this
         message and a barebones HTML document.
      </p>
      <ul class="breadcrumb">
      <% for (Link link : ctx.getPath()) { %>
         <li><a href="<%=link.getUrl()%>"><%=link.getLabel()%></a> <span class="divider">/</span></li>
      <% } %>
         <li class="active"><%=ctx.getLink().getLabel()%></li>
      </ul>
   </div>

   <!-- javascript - Placed at the end of the document so the pages load faster -->
   <script src="<%=request.getContextPath()%>/js/jquery-1.9.1.js"></script>
   <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>
