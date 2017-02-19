<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath(); %>
<div style="padding: 20px;">
    <form id="bookUpdateForm" class="easyui-form" data-options="url:'success.json'"  method="post" enctype="multipart/form-data">
    
        <img src="<%=path%>/upload/santi.jpg"  style="width:100px;" /><br/>
        <label>图书封面：</label>
        <input  name="coverImage"  class="easyui-filebox"  data-options="buttonText: '图片',accept: 'image/*'"/><span>(如果不需要修改封面，则不用选择新图片)</span><br/>
        
        <label>图书名称：</label>
        <input value="三体全集（全三册）" name="name"  class="easyui-textbox" data-options="required:true"/><br/>
        
        <label>作者：</label>
        <input value="刘慈欣"  name="author"  class="easyui-textbox" data-options="required:true"/><br/>
        
        <label>价格：</label>
        <input value="168"  name="price"  class="easyui-numberbox" data-options="required:true,min:0"/><br/>
        
        <label>图书分类：</label>
        <input value="1"  name="categoryId"  class="easyui-combobox"    data-options="required:true,valueField:'id',textField:'name',url:'<%=path%>/category?action=listJson'" /><br/>
      
        <label>出版社：</label>
        <input value="重庆出版社"  name="press" class="easyui-textbox" data-options="required:true"/><br/>
        
        <label>出版日期：</label>
        <input value="2011-11-01"  name="publishDate" class="easyui-datebox"  data-options="required:true"/><br/>
        
        <label>页数：</label>
        <input  value="1326"  name="pageCount"  class="easyui-numberbox" data-options="required:true,min:0"/><br/>
        
        <label>字数：</label>
        <input value="891924"  name="wordCount"  class="easyui-numberbox" data-options="required:true,min:0"/><br/>
        
        <label>ISBN：</label>
        <input value="9787536692930"   name="isbn"  class="easyui-textbox" data-options="required:true"/><br/>
        
        <label>图书描述：</label>
        <input  value="三体人在利用魔法般的科技锁死了地球人的科学之后，庞大的宇宙舰队杀气腾腾地直扑太阳系，意欲清除地球文明。面对前所未有的危局，经历过无数磨难的地球人组建起同样庞大的太空舰队，同时，利用三体人思维透明的致命缺陷，制订了神秘莫测的“面壁计划”，精选出四位“面壁者”。秘密展开对三体人的反击。"   name="description"  class="easyui-textbox" data-options="required:true,multiline:true,height:100"/><br/>
        
        <a onclick="submitForm('bookUpdateForm',false,'bookDatagrid')" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" >修改</a>
    </form>

</div>
