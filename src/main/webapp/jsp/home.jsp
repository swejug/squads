<!DOCTYPE HTML>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="author" content="Thobias Bergqvist" />
  <meta name="description" content="This is SweJUG!" />
  <title>SweJUG</title>
  <link href="<%=request.getContextPath()%>/css/swejug.css" rel="stylesheet">
</head>
<body>
  <h1>SweJUG</h1>
  <p>This is SweJUG!<br />
    <%= request.getAttribute(se.swejug.squads.filters.DispatchFilter.REQUEST_PARTS).toString() %>
  </p>
</body>
</html>
