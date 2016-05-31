<#import "/spring.ftl" as spring />
<#--форма отображения карточки сотрудника-->

<h2><@spring.message 'label.card' /></h2>
		
<table class="data">
        <tr>&nbsp;</tr>
        
        <tr>
		 	<th align="left"><@spring.message 'label.id' /> &nbsp; </th>
		 	<td>${employeefound.id}</td> 
		 </tr>
		
		 <tr>
		 	<th align="left"><@spring.message 'label.lastname' /> &nbsp; </th>
		 	<td>${employeefound.lastname}</td> 
		 </tr>
		
		 <tr>
			<th align="left"><@spring.message 'label.firstname' /> &nbsp; </th>
			<td>${employeefound.firstname}</td>
		</tr>
		
		<tr>
			<th align="left"><@spring.message 'label.birthday' /> &nbsp; </th>
			<td>${employeefound.birthday}</td>
		</tr>
		
		<tr>
			<#setting number_format="currency">
			<th align="left"><@spring.message 'label.salary' /> &nbsp; </th>
			<td>${employeefound.salary?string("0.00")}</td>
		</tr>
		
		<tr>
			<#setting number_format="number">	
			<th align="left"><@spring.message 'label.division' /> &nbsp; </th>
			<td>${employeefound.division.NAME}   (${employeefound.division.id})</td><#--NAME обязательно большими буквами-->
		</tr>
		
		<tr>	
			<th align="left"><@spring.message 'label.active' /> &nbsp; </th>
			<td>${employeefound.active?string("работает","не работает")}</td><#--boolean-->
		</tr>
			<th>&nbsp;</th>
</table>

	 <#--Кнопка сброс-->
<form  action="<@spring.url '/index'/>" method="post"  commandName="employee">
      	<input type="submit" value="<@spring.message 'label.return'/>" />
</form>