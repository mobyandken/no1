<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
$(function(){
	//初始化加载      Json格式字符串    
	var data = '{"id": 1,"name": "测试商品","price": 99.9,"detail": "测试商品描述","pic": "123456.jpg"}';
	$.ajax({
		url : "${pageContext.request.contextPath }/test/json.action",
		data : data,
		type : "post",
		contentType : "application/json;charset=UTF-8",//发送数据的类型
		dataType : "json", //回调数据类型
		success : function(data){
			//回调 json格式字符串
			alert(data.id + ":" + data.name);
		}
	});
});
</script>
</head>
<body> 
	<!-- 上传图片是需要指定属性 enctype="multipart/form-data" -->
	<!-- <form id="itemForm" action="" method="post" enctype="multipart/form-data"> --><!-- enctype="multipart/form-data 设置这个可以进行表单上传 -->
	<form id="itemForm"	action="${pageContext.request.contextPath }/updateitem.action" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${item.id }" /> 修改商品信息：
		<table width="100%" border=1>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name" value="${item.name }" /></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="price" value="${item.price }" /></td>
			</tr>
			<tr>
				<td>商品生产日期</td>
				<td><input type="text" name="createtime"
					value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
			</tr>
			<tr>
				<td>商品图片</td>
				<td>
					<c:if test="${item.pic !=null}">
						<img src="/pic/${item.pic}" width=100 height=100/>
						<br/>
					</c:if>
					<input type="file" name="picFile"/> 
				</td>
			</tr>
			<tr>
				<td>商品简介</td>
				<td><textarea rows="3" cols="30" name="detail">${item.detail }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>