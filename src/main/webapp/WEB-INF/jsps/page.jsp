<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    111
    <div class="jcpage-table">
    	<div class="data">
    	
    	</div>
	    <div class="jcpage">
	    
	    </div>
    </div>
</body>
<%-- ${page.pageScript }
 --%>
<script src='http://code.jquery.com/jquery-latest.js'></script>
<script type='text/javascript'>
	function switchPage(page,pageSize,location){
		pageSize = pageSize==null?10:pageSize;
		location = location==null?'jcpage-table':location;
		$.get('getpage?page='+page+'&pageSize=' + pageSize,function(data){
			jcpage = data;
			$('.' + location + ' .data').html('<div>'+data.list[0].id+'</div>');
			$('.' + location + ' .jcpage').html(data.pageString);
		})
	}
	$(function(){
		switchPage(1,1);
	})
</script>
</html>