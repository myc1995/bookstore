<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<!-- 添加区域 -->
<div style="padding: 20px;">

	<form id="bookAddForm" class="easyui-form"
		data-options="url:'success.json'" method="post"
		enctype="multipart/form-data">

		<label>图书名称：</label> <input name="name" class="easyui-textbox"
			data-options="required:true" /><br /> <label>作&nbsp&nbsp者：</label> <input
			name="author" class="easyui-textbox" data-options="required:true" /><br />

		<label>价&nbsp&nbsp格：</label> <input name="price" class="easyui-numberbox"
			data-options="required:true,min:0" /><br /> <label>图书分类：</label> <input
			name="categoryId" class="easyui-combobox"
			data-options="required:true,valueField:'id',textField:'name',url:'<%=path%>/category?action=listJson'" /><br />

		<label>出版社&nbsp：</label> <input name="press" class="easyui-textbox"
			data-options="required:true" /><br /> <label>出版日期：</label> <input
			name="publishDate" class="easyui-datebox"
			data-options="required:true" /><br /> <label>页&nbsp&nbsp数：</label> <input
			name="pageCount" class="easyui-numberbox"
			data-options="required:true,min:0" /><br /> <label>字&nbsp&nbsp数：</label> <input
			name="wordCount" class="easyui-numberbox"
			data-options="required:true,min:0" /><br /> <label>ISBN&nbsp&nbsp：</label> <input
			name="isbn" class="easyui-textbox" data-options="required:true" /><br />

		<label>图书封面：</label> <input name="coverImage" class="easyui-filebox"
			data-options="buttonText: '图片',accept: 'image/*',required:true" /><br />

		<label>图书描述：</label> <input name="description" class="easyui-textbox"
			data-options="required:true,multiline:true,height:100" /><br /> <a
			href="#" onclick="submitForm('bookAddForm',true,'bookDatagrid')"
			class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加新图书</a>
	</form>

</div>
