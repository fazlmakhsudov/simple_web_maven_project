<%
String action = (String) request.getParameter("action");
out.println("You have chosed action: "+action);
String answer = (String) request.getAttribute("answer");
out.println(answer);
%>